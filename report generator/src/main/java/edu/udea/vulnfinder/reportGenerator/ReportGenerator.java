/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.udea.vulnfinder.reportGenerator;

import edu.udea.vulnfinder.reportGenerator.analyzer.ZapAnalyzer;
import edu.udea.vulnfinder.reportGenerator.analyzer.SQLMapAnalyzer;
import edu.udea.vulnfinder.reportGenerator.exception.ZAPApiConnectionException;
import edu.udea.vulnfinder.reportGenerator.model.DocumentWithHeadAndBody;
import edu.udea.vulnfinder.reportGenerator.model.Report;
import edu.udea.vulnfinder.reportGenerator.service.SiteStore;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

/**
 * Main class
 *
 * @author Camilo Sampedro <camilo.sampedro@udea.edu.co>
 */
public class ReportGenerator {

    // Class' logger
    private final static Logger LOGGER = Logger.getLogger(ReportGenerator.class);

    // Zap API URL
    private static final String ZAPURL = "http://zap/";

    private static String zapHost = "localhost";

    private static int port = 8080;

    // Object that contains information about CLI arguments
    private static final Options OPTIONS = new Options();

    // Parses CLI arguments into known local behavior
    private static final CommandLineParser PARSER = new DefaultParser();
    private static String targetFile = null;

    /**
     * @param args Command line arguments
     * @throws java.io.IOException
     * @throws org.apache.commons.cli.ParseException
     */
    public static void main(String[] args) throws IOException, ParseException {
        LOGGER.info("Starting report generator");

        // First initialize CLI options, for then recognizing the arguments
        initializeCLIOptions();

        getParametersFromCLIAndStart(args);
        LOGGER.info("Program execution finished!");
    }

    /**
     * Initializes recognized CLI options.
     */
    private static void initializeCLIOptions() {
        OPTIONS.addOption("t", "toe", true, "Sets the site to analyze");
        OPTIONS.addOption("F", "force", true, "Force sites analyzed to be equals to -s option given argument");
        OPTIONS.addOption("f", "fields-file", true, "Sets the fields to analyze");
        OPTIONS.addOption("o", "output", true, "Sets the path where the HTML report will be exported");
        OPTIONS.addOption("d", "target-file", true, "Sets the path where the target.txt will be located");
        Option fileOption = new Option("s", "files", true, "Adds SQLMap files to be analyzed");
        fileOption.setArgs(Option.UNLIMITED_VALUES);
        OPTIONS.addOption(fileOption);
    }

    /**
     * Site URL to analyze.
     */
    private static String toeURL = "";
    /**
     * List of fields to be included in the report.
     */
    private static List<String> fieldList = null;
    /**
     * Zap analyzer object.
     */
    private static ZapAnalyzer zapAnalyzer;
    /**
     * Forces the site to be exactly equal to the received one from parameters.
     */
    private static boolean forced = false;
    /**
     * File where fields will be read from.
     */
    private static String fieldsFile;
    /**
     * SQLMap output log files.
     */
    private static List<String> sqlMapFiles;

    /**
     * Generate a single report html
     *
     * @param zapHost Zap host url
     * @param port Zap port
     * @param site Site to be analyzed
     * @param forcedEqualSite Force site to be strictly equals instead of
     * checking if the report site contains the given "site"
     * @param fieldList List of fields to be included.
     * @param sqlMapFiles List of sqlMapFiles
     * @param targetFile target.txt location
     * @return Single html file report
     * @throws IOException Error reading the SQLMap files given
     */
    public static String generateReport(String zapHost, int port, String site, boolean forcedEqualSite, List<String> fieldList, List<String> sqlMapFiles, String targetFile) throws IOException {
        ReportGenerator.zapHost = zapHost;
        ReportGenerator.port = port;
        ReportGenerator.toeURL = site;
        forced = forcedEqualSite;
        ReportGenerator.fieldList = fieldList;
        ReportGenerator.sqlMapFiles = sqlMapFiles;
        ReportGenerator.targetFile = targetFile;
        try {
            return generateReportString();
        } catch (IOException ex) {
            LOGGER.error("Error reading SQLMap files", ex);
            throw ex;
        }
    }

    /**
     * Generate a single report html
     *
     * @param zapHost Zap host url
     * @param port Zap port
     * @param site Site to be analyzed
     * @param forcedEqualSite Force site to be strictly equals instead of
     * checking if the report site contains the given "site"
     * @param fieldList List of fields to be included.
     * @param sqlMapFiles List of sqlMapFiles
     * @return Single html file report
     * @throws IOException Error reading the SQLMap files given
     */
    public static String generateReport(String zapHost, int port, String site, boolean forcedEqualSite, List<String> fieldList, List<String> sqlMapFiles) throws IOException {
        return generateReport(zapHost, port, site, forcedEqualSite, null, sqlMapFiles, null);
    }

    /**
     * Generate a single report html
     *
     * @param zapHost Zap host url
     * @param port Zap port
     * @param site Site to be analyzed
     * @param fieldList List of fields to be included.
     * @param sqlMapFiles List of sqlMapFiles
     * @return Single html file report
     * @throws IOException Error reading the SQLMap files given
     */
    public static String generateReport(String zapHost, int port, String site, List<String> fieldList, List<String> sqlMapFiles) throws IOException {
        return generateReport(zapHost, port, site, false, fieldList, sqlMapFiles);
    }

    /**
     * Generate a single report html
     *
     * @param zapHost Zap host url
     * @param port Zap port
     * @param site Site to be analyzed
     * @param forcedEqualSite Force site to be strictly equals instead of
     * checking if the report site contains the given "site"
     * @param sqlMapFiles List of sqlMapFiles
     * @return Single html file report
     * @throws IOException Error reading the SQLMap files given
     */
    public static String generateReport(String zapHost, int port, String site, boolean forcedEqualSite, List<String> sqlMapFiles) throws IOException {
        return generateReport(zapHost, port, site, forcedEqualSite, null, sqlMapFiles);
    }

    /**
     * Generate a single report html
     *
     * @param zapHost Zap host url
     * @param port Zap port
     * @param toe Site to be analyzed
     * @param sqlMapFiles List of sqlMapFiles
     * @return Single html file report
     * @throws IOException Error reading the SQLMap files given
     */
    public static String generateReport(String zapHost, int port, String toe, List<String> sqlMapFiles) throws IOException {
        return generateReport(zapHost, port, toe, false, null, sqlMapFiles);
    }

    /**
     * Generate a single report html
     *
     * @param zapHost Zap host url
     * @param port Zap port
     * @param toe Site to be analyzed
     * @param sqlMapFiles List of sqlMapFiles
     * @param targetFile Target.txt file
     * @return Single html file report
     * @throws IOException Error reading the SQLMap files given
     */
    public static String generateReport(String zapHost, int port, String toe, List<String> sqlMapFiles, String targetFile) throws IOException {
        return generateReport(zapHost, port, toe, false, null, sqlMapFiles, targetFile);
    }

    /**
     * Generate a single report html
     *
     * @param zapHost Zap host url
     * @param zapPort Zap port
     * @param site Site to be analyzed
     * @return Single html file report
     * @throws IOException Error reading the SQLMap files given
     */
    public static String generateReport(String zapHost, int zapPort, String site) throws IOException {
        return generateReport(zapHost, zapPort, site, false, null, null);
    }

    private static String generateReportString() throws IOException {

        executeAnalysis();

        DocumentWithHeadAndBody htmlReport = Report.toHtml(SiteStore.getAll(), "VulnFinder Report");
        return htmlReport.toString();
    }

    /**
     * Debug report generation, can be switched off
     *
     * @param on Debug mode is on if true or off if false
     */
    public static void setDebugMode(boolean on) {
        if (on) {
            Logger.getRootLogger().setLevel(Level.DEBUG);
        } else {
            Logger.getRootLogger().setLevel(Level.INFO);
        }
    }

    /**
     * Execute analysis having the necessary information.
     * After the preprocess (This class' variables), proceed to analyze
     * @throws IOException 
     */
    private static void executeAnalysis() throws IOException {
        // Analyze the expected content of the variables
        if (targetFile != null && !"".equals(targetFile)) {
            // Read the target.txt files
            BufferedReader brTest = new BufferedReader(new FileReader(targetFile));
            String targetTOE = brTest.readLine();
            Matcher urlMatcher = FilePatternFinder.URL_PATTERN.matcher(targetTOE);
            // If the url is found
            if (urlMatcher.find()) {
                targetTOE = urlMatcher.group(1);
                toeURL = targetTOE;
                LOGGER.debug("TOE found in target file is: " + targetTOE);
            } else {
                LOGGER.debug("target.txt found but no TOE were found there");
            }

        } else {
            LOGGER.debug("No target.txt submitted");
        }

        // If toe have been passed, send it to the Zap Analyzer
        if (toeURL != null && !"".equals(toeURL)) {
            zapAnalyzer = new ZapAnalyzer(ZAPURL, toeURL, zapHost);
        } else {
            zapAnalyzer = new ZapAnalyzer(ZAPURL, zapHost);
        }

        // Send the known variables to Zap Analyzer
        zapAnalyzer.setForced(forced);
        zapAnalyzer.setFieldList(fieldList);
        zapAnalyzer.setPort(port);

        // Execute the ZAP report checking
        try {
            zapAnalyzer.executeAnalysis();
        } catch (ZAPApiConnectionException ex) {
            // If Zap has an error, stand still on execution
            LOGGER.error("Error generating ZAP Report", ex);
        }
        LOGGER.info("ZAP report finished");
        
        // Analyze with the SQLMap analyzer
        LOGGER.info("Files to analyze (Input params): " + sqlMapFiles);
        for (String file : sqlMapFiles) {
            SQLMapAnalyzer analyzer = new SQLMapAnalyzer(file, toeURL);
            // Send fieldList if it has been sent previously
            if (fieldList != null && !fieldList.isEmpty()) {
                analyzer.setFieldList(fieldList);
            }
            analyzer.analyze();
        }
    }

    /**
     * Execute analysis receiving all the parameters from CLI.
     * @param args Raw String with the CLI parameters
     * @throws ParseException
     * @throws IOException 
     */
    private static void getParametersFromCLIAndStart(String[] args) throws ParseException, IOException {
        // File with site fields to look for
        // This objects will recognize, based on OPTIONS the CLI arguments user sent
        CommandLine cmd = PARSER.parse(OPTIONS, args);

        // If it is entered <code>-s</code> argument, analyze ZAP report with site
        if (cmd.hasOption("t")) {
            toeURL = cmd.getOptionValue("t");
            LOGGER.info("Analyzing site reports of: " + toeURL);
        }

        // Target.txt file
        if (cmd.hasOption("d")) {
            targetFile = cmd.getOptionValue("d");
            LOGGER.info("Target file: " + targetFile);
        }

        // If it is entered <code>-f</code> argument, save the parameterFile string
        if (cmd.hasOption("f")) {
            fieldsFile = cmd.getOptionValue("f");
            if (fieldsFile != null && "".equals(fieldsFile)) {
                try (Scanner s = new Scanner(new File(fieldsFile), "UTF-8")) {
                    fieldList = new ArrayList<>();
                    while (s.hasNext()) {
                        fieldList.add(s.next());
                    }
                }
            }
        }

        // If <code>-F</code> is passed, set forced to true.
        if (cmd.hasOption("F")) {
            forced = true;
        }

        // If it is entered <code>-s</code> argument, analyze the given SQLMap files
        if (cmd.hasOption("s")) {
            LOGGER.info("Analyzing SQLMap files...");
            sqlMapFiles = Arrays.asList(cmd.getOptionValues("s"));
        } else {
            // If there's not a <code>-s</code> argument, don't analyze SQLMap report
            LOGGER.info("\"s\" param not entered, skiping SQLMap analysis.");
        }

        // With the information asigned to this class' variables, proceed to 
        // execute the analysis
        executeAnalysis();

        // <code>-o</code> parameter will have the output path for the html
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
