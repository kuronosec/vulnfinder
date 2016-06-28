/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.udea.generadorreportesvuln;

import co.edu.udea.generadorreportesvuln.exception.ZAPApiConnectionException;
import java.io.IOException;
import java.util.Arrays;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.apache.log4j.Logger;

/**
 *
 * @author camilosampedro
 */
public class GeneradorReportes {

    private final static Logger LOGGER = Logger.getLogger(GeneradorReportes.class);
    private final static String ZAPURL = "http://zap/OTHER/core/other/xmlreport/";
    private static final Options OPTIONS = new Options();
    private static final CommandLineParser PARSER = new DefaultParser();

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     * @throws org.apache.commons.cli.ParseException
     */
    public static void main(String[] args) throws IOException, ParseException {
        LOGGER.info("Starting report generator");
        OPTIONS.addOption("s", true, "Set the site to analyze");
        Option fileOption = new Option("f", "Files to be analyzed");
        fileOption.setArgs(Option.UNLIMITED_VALUES);
        OPTIONS.addOption(fileOption);
        String site = "";

        CommandLine cmd = PARSER.parse(OPTIONS, args);
        ZAPReportGenerator zapReportGenerator;
        if (cmd.hasOption("s")) {
            site = cmd.getOptionValue("s");
            LOGGER.info("Analyzing site reports of: " + site);
            zapReportGenerator = new ZAPReportGenerator(ZAPURL, site);
        } else {
            zapReportGenerator = new ZAPReportGenerator(ZAPURL);
        }
        // TODO code application logic here

        try {
            zapReportGenerator.getReport();
        } catch (ZAPApiConnectionException ex) {
            LOGGER.error("Error generating ZAP Report", ex);
        }
        LOGGER.info("ZAP report finished");
        if (cmd.hasOption("f")) {
            LOGGER.info("Analyzing SQLMap files...");
            String[] files = cmd.getOptionValues("f");
            LOGGER.info("Files to analyze (Input params): " + Arrays.toString(files));
            for (String file : files) {
                FileAnalyzer analyzer = new FileAnalyzer(file,site);
                analyzer.analyze();
            }
        } else {
            LOGGER.info("\"f\" param not entered, skiping SQLMap analysis.");
        }
        LOGGER.info("Program execution finished!");
    }

    

}
