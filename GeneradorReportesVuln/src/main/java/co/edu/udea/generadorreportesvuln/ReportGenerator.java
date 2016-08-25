/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.udea.generadorreportesvuln;

import co.edu.udea.generadorreportesvuln.analyzer.ZapAnalyzer;
import co.edu.udea.generadorreportesvuln.analyzer.SQLMapAnalyzer;
import co.edu.udea.generadorreportesvuln.exception.ZAPApiConnectionException;
import co.edu.udea.generadorreportesvuln.model.DocumentWithHeadAndBody;
import co.edu.udea.generadorreportesvuln.model.Report;
import co.edu.udea.generadorreportesvuln.service.SiteStore;
import com.hp.gagawa.java.Document;
import com.hp.gagawa.java.elements.Html;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
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
public class ReportGenerator {

    // Class' logger
    private final static Logger LOGGER = Logger.getLogger(ReportGenerator.class);

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
        OPTIONS.addOption("s", "site", true, "Sets the site to analyze");
        OPTIONS.addOption("F", "force", true, "Force sites analyzed to be equals to -s option given argument");
        OPTIONS.addOption("f", "fields-file", true, "Sets the fields to analyze");
        OPTIONS.addOption("o", "output", true, "Sets the path where the HTML report will be exported");
        Option fileOption = new Option("s", "files", true, "Adds SQLMap files to be analyzed");
        fileOption.setArgs(Option.UNLIMITED_VALUES);
        OPTIONS.addOption(fileOption);
    }

    // Site to analyze
    private static String site = "";
    private static List<String> fieldList = null;
    private static ZapAnalyzer zapAnalyzer;
    private static boolean forced = false;
    private static String fieldsFile;
    private static List<String> sqlMapFiles;

    public static String generateReport(String site, boolean forcedEqualSite, String fieldsFile, List<String> sqlMapFiles) throws IOException {
        ReportGenerator.site = site;
        forced = forcedEqualSite;
        ReportGenerator.fieldsFile = fieldsFile;
        ReportGenerator.sqlMapFiles = sqlMapFiles;
        return generateReportString();
    }

    private static String generateReportString() throws FileNotFoundException, IOException {
        if (site != null && "".equals(site)) {
            zapAnalyzer = new ZapAnalyzer(ZAPURL, site);
        } else {
            zapAnalyzer = new ZapAnalyzer(ZAPURL);
        }

        if (fieldsFile != null && "".equals(fieldsFile)) {
            try (Scanner s = new Scanner(new File(fieldsFile))) {
                fieldList = new ArrayList<>();
                while (s.hasNext()) {
                    fieldList.add(s.next());
                }
            }
            zapAnalyzer.setFieldList(fieldList);
        }

        zapAnalyzer.setForced(forced);
        
        executeAnalyzis();

        DocumentWithHeadAndBody htmlReport = Report.toHtml(SiteStore.getAll(), "VulnFinder Report");
        return htmlReport.toString();
    }

    private static void executeAnalyzis() throws IOException {
        // Execute the ZAP report checking
        try {
            zapAnalyzer.getReport();
        } catch (ZAPApiConnectionException ex) {
            LOGGER.error("Error generating ZAP Report", ex);
        }
        LOGGER.info("ZAP report finished");

        LOGGER.info("Files to analyze (Input params): " + sqlMapFiles);
        for (String file : sqlMapFiles) {
            SQLMapAnalyzer analyzer = new SQLMapAnalyzer(file, site);
            if (fieldList != null && !fieldList.isEmpty()) {
                analyzer.setFieldList(fieldList);
            }
            analyzer.analyze();
        }
    }

    private static void executeAllAnaylisis(String[] args) throws ParseException, IOException {
        // File with site fields to look for
        // This objects will recognize, based on OPTIONS the CLI arguments user sent
        CommandLine cmd = PARSER.parse(OPTIONS, args);

        // If it is entered <code>-s</code> argument, analyze ZAP report with site
        if (cmd.hasOption("s")) {
            site = cmd.getOptionValue("s");
            LOGGER.info("Analyzing site reports of: " + site);
        }

        // If it is entered <code>-f</code> argument, save the parameterFile string
        if (cmd.hasOption("f")) {
            fieldsFile = cmd.getOptionValue("f");
        }

        if (cmd.hasOption("F")) {
            forced = true;
        }

        // If it is entered <code>-f</code> argument, analyze the given SQLMap files
        if (cmd.hasOption("s")) {
            LOGGER.info("Analyzing SQLMap files...");
            sqlMapFiles = Arrays.asList(cmd.getOptionValues("s"));
        } else {
            // If there's not a <code>-f</code> argument, don't analyze SQLMap report
            LOGGER.info("\"f\" param not entered, skiping SQLMap analysis.");
        }
        
        executeAnalyzis();

        if (cmd.hasOption("o")) {
            // After the report concluded, generate a Html file with the report information.
            DocumentWithHeadAndBody htmlReport = Report.toHtml(SiteStore.getAll(), "VulnFinder Report");
            Report.writeToFile(htmlReport, cmd.getOptionValue("o"));
        } else {
            // Or print it to standart output
            Report.writeToSystemOutput(SiteStore.getAll());
        }
    }
}
