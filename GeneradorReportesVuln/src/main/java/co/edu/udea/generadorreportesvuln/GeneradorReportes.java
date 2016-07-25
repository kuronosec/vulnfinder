/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.udea.generadorreportesvuln;

import co.edu.udea.generadorreportesvuln.analyzer.ZapAnalyzer;
import co.edu.udea.generadorreportesvuln.analyzer.SQLMapAnalyzer;
import co.edu.udea.generadorreportesvuln.exception.ZAPApiConnectionException;
import co.edu.udea.generadorreportesvuln.model.Report;
import co.edu.udea.generadorreportesvuln.service.SiteMaker;
import com.hp.gagawa.java.elements.Html;
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
 * Main class
 *
 * @author Camilo Sampedro
 */
public class GeneradorReportes {

    // Class' logger
    private final static Logger LOGGER = Logger.getLogger(GeneradorReportes.class);

    // Zap API URL
    private final static String ZAPURL = "http://zap/";

    // Object that contains information about CLI arguments
    private static final Options OPTIONS = new Options();

    // Parses CLI arguments into known local behavior
    private static final CommandLineParser PARSER = new DefaultParser();

    /**
     * @param args Command line arguments
     * @throws java.io.IOException
     * @throws org.apache.commons.cli.ParseException
     */
    public static void main(String[] args) throws IOException, ParseException {
        LOGGER.info("Starting report generator");

        // First initialize CLI options, for then recognizing the arguments
        initializeCLIOptions();

        executeAllAnaylisis(args);
        LOGGER.info("Program execution finished!");
    }

    /**
     * Initializes recognized CLI options.
     */
    private static void initializeCLIOptions() {
        OPTIONS.addOption("s", true, "Set the site to analyze");
        OPTIONS.addOption("c", true, "Set the parameters to analyze");
        OPTIONS.addOption("o", true, "Set the output html file");
        Option fileOption = new Option("f", "Files to be analyzed");
        fileOption.setArgs(Option.UNLIMITED_VALUES);
        OPTIONS.addOption(fileOption);
    }

    private static void executeAllAnaylisis(String[] args) throws ParseException, IOException {
        // Site to analyze
        String site = "";

        // File with site fields to look for
        String parameterFile;

        // This objects will recognize, based on OPTIONS the CLI arguments user sent
        CommandLine cmd = PARSER.parse(OPTIONS, args);

        // First create a ZAP analyzer
        ZapAnalyzer zapAnalyzer;

        // If it is entered <code>-c</code> argument, save the parameterFile string
        if (cmd.hasOption("c")) {
            parameterFile = cmd.getOptionValue("c");
        }

        // If it is entered <code>-s</code> argument, analyze ZAP report with site
        if (cmd.hasOption("s")) {
            site = cmd.getOptionValue("s");
            LOGGER.info("Analyzing site reports of: " + site);
            zapAnalyzer = new ZapAnalyzer(ZAPURL, site);
        } else {
            // If there's not a <code>-s</code> argument, analyze all the sites.
            zapAnalyzer = new ZapAnalyzer(ZAPURL);
        }
        // Execute the ZAP report checking
        try {
            zapAnalyzer.getReport();
        } catch (ZAPApiConnectionException ex) {
            LOGGER.error("Error generating ZAP Report", ex);
        }
        LOGGER.info("ZAP report finished");

        // If it is entered <code>-f</code> argument, analyze the given SQLMap files
        if (cmd.hasOption("f")) {
            LOGGER.info("Analyzing SQLMap files...");
            String[] files = cmd.getOptionValues("f");
            LOGGER.info("Files to analyze (Input params): " + Arrays.toString(files));
            for (String file : files) {
                SQLMapAnalyzer analyzer = new SQLMapAnalyzer(file, site);
                analyzer.analyze();
            }
        } else {
            // If there's not a <code>-f</code> argument, don't analyze SQLMap report
            LOGGER.info("\"f\" param not entered, skiping SQLMap analysis.");
        }

        if (cmd.hasOption("o")) {
            // After the report concluded, generate a Html file with the report information.
            Html htmlReport = Report.toHtml(SiteMaker.getAll(), "VulnFinder Report");
            Report.writeToFile(htmlReport, cmd.getOptionValue("o"));
        } else {
            // Or print it to standart output
            Report.writeToSystemOutput(SiteMaker.getAll());
        }
    }

}
