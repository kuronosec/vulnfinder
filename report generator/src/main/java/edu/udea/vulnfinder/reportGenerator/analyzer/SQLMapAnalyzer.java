/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.udea.vulnfinder.reportGenerator.analyzer;

import edu.udea.vulnfinder.reportGenerator.FilePatternFinder;
import edu.udea.vulnfinder.reportGenerator.model.FieldAlert;
import edu.udea.vulnfinder.reportGenerator.model.Analyzer;
import edu.udea.vulnfinder.reportGenerator.model.Field;
import edu.udea.vulnfinder.reportGenerator.model.Site;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.regex.Matcher;
import org.apache.log4j.Logger;
import edu.udea.vulnfinder.reportGenerator.service.SiteStore;
import java.util.List;

/**
 * SQLMapAnalyzer, analyzes SQLMap log files, line by line. A SQLMapAnalyzer is
 * required for every single SQLMap log file.
 *
 * @author Camilo Sampedro <camilo.sampedro@udea.edu.co>
 */
public class SQLMapAnalyzer extends FilePatternFinder {

    private final static Logger LOGGER = Logger.getLogger(SQLMapAnalyzer.class);
    /**
     * File to be analyzed.
     */
    private final String filePath;
    /**
     * Site to be analyzed (Looked for). If this is null, all sites will be sent
     * to the final report.
     */
    private final String siteURLToBeAnalyzed;
    /**
     * Field list to be considered. If this is null or empty, all fields will be
     * included.
     */
    private List<String> fieldList;
    /**
     * Flag for knowing if it's the beginning of a '---'.
     */
    private boolean isTheBeginning;
    /**
     * Flag for knowing if it's the beginning of the file. The site URL might be
     * here.
     */
    private boolean firstLine;

    /**
     * Actual parameter (Or field).
     */
    private String actualParameter;
    /**
     * Actual http method (GET, POST, ...). Used to save when all information is
     * known
     */
    private String actualMethod;
    private String type = "", title = "", payload;

    /**
     * Simple constructor.
     *
     * @param filePath Path to the file to be analyzed.
     * @param siteURLToBeAnalyzed Site's URL
     */
    public SQLMapAnalyzer(String filePath, String siteURLToBeAnalyzed) {
        this.filePath = filePath;
        this.siteURLToBeAnalyzed = siteURLToBeAnalyzed;
    }

    public void analyze() throws IOException {
        LOGGER.info("Analyzing file: " + filePath);

        // Get the site from the store.
        Site site = SiteStore.getSite(siteURLToBeAnalyzed);

        // Initialize actualParameter
        actualParameter = "";
        // Read all the lines
        try (BufferedReader bufferedReader
                = new BufferedReader(new FileReader(filePath))) {
            // The first line, initialize the loop
            String line = bufferedReader.readLine();
            isTheBeginning = false;
            firstLine = true;
            // Until EOF
            while (line != null) {
                // Look for the URL on the first line
                if (firstLine) {
                    Matcher matcher = URL_PATTERN.matcher(line);
                    if (matcher.find()) {
                        String siteURL = matcher.group(0);
                        try {
                            // Check if it is a URL or not
                            URI uri = new URI(siteURL);
                            URL url = new URL(siteURL);
                            siteURL = url.getProtocol() + "://" + uri.getHost();
                            // If there is a site to be analyzed, and it is not 
                            // equal to the find above stop here.
                            if (!siteURLToBeAnalyzed.equals("")) {
                                if (!siteURL.contains(siteURLToBeAnalyzed)) {
                                    LOGGER.info("The site " + siteURLToBeAnalyzed
                                            + " is not been reported in this file. "
                                            + "This file has reports of "
                                            + siteURL + ".");
                                    break;
                                }
                            }
                            LOGGER.info("Site: " + siteURL);

                            site = SiteStore.getSite(siteURL);
                            site.addAnalyzer(Analyzer.SQLMAP);
                        } catch (URISyntaxException ex) {
                            LOGGER.error("There was an error parsing site URL: "
                                    + siteURL, ex);
                        }
                    } else {
                        LOGGER.info("No site found");
                    }
                    line = bufferedReader.readLine();
                    firstLine = !firstLine;
                    continue;
                }
                // Between '---' are the parameters (fields)
                if ("---".equals(line)) {
                    isTheBeginning = !isTheBeginning;
                    line = bufferedReader.readLine();
                    continue;
                }
                
                // If the line is between '---'s
                if (isTheBeginning) {
                    line = analyzeHyphens(site, bufferedReader, line);
                    continue;
                }
                
                // Find the messages (INFO/WARNING/...) on the file
                Matcher matcher = SQLMAP_LOG_MESSAGE_PATTERN.matcher(line);
                if (matcher.find()) {
                    // System.out.println("Found value 1: " + m.group(0));
                    String found = matcher.group(2);
                    if (found.contains("heuristics detected webpage charset") && site != null) {
                        site.addCharset(found.substring(found.lastIndexOf(' ') + 1));
                    }
                }
                line = bufferedReader.readLine();
            }
        } catch (IOException ex) {
            LOGGER.error("There was an error reading " + filePath + " file ", ex);
        }
    }

    /**
     * Sets the included field list
     * @param fieldList 
     */
    public void setFieldList(List<String> fieldList) {
        this.fieldList = fieldList;
    }

    /**
     * Analyzes the lines between '---'
     * @param site Actual report's site
     * @param bufferedReader The one that has the line pointer
     * @param line The already read line
     * @return Next line on the file
     * @throws IOException 
     */
    private String analyzeHyphens(Site site, BufferedReader bufferedReader, String line) throws IOException {
        LOGGER.debug("Analyzing beginning: \"" + line + "\"");
        
        Matcher parameterMatcher = PARAMETER_PATTERN.matcher(line);
        // If a parameter is found
        if (parameterMatcher.find()) {
            actualParameter = parameterMatcher.group(1);
            LOGGER.debug("Found parameter: " + actualParameter);
            if (fieldList == null || fieldList.isEmpty() || (!fieldList.isEmpty() && fieldList.contains(actualParameter))) {
                Field actualField = site.getField(actualParameter);
                actualMethod = parameterMatcher.group(2);
                actualField.setFieldMethod(actualMethod);
            } else {
                actualParameter = "";
            }
            return bufferedReader.readLine();
        }
        
        Matcher typeMatcher = TYPE_PATTERN.matcher(line);
        // If a 'type' is found
        if (typeMatcher.find() && !"".equals(actualParameter)) {
            type = typeMatcher.group(1);
            LOGGER.debug("Found type: " + type);
            return bufferedReader.readLine();
        }
        
        Matcher titleMatcher = TITLE_PATTERN.matcher(line);
        // If a 'title' is found
        if (titleMatcher.find() && !"".equals(actualParameter)) {
            title = titleMatcher.group(1);
            LOGGER.debug("Found title: " + title);
            return bufferedReader.readLine();
        }
        
        Matcher payloadMatcher = PAYLOAD_PATTERN.matcher(line);
        // If a 'payload' is found
        if (payloadMatcher.find() && !"".equals(actualParameter)) {
            payload = payloadMatcher.group(1);
            Field actualField = site.getField(actualParameter);
            FieldAlert alert = new FieldAlert(Analyzer.SQLMAP);
            alert.setType(type);
            alert.setTypeExplanation(title);
            alert.setExploit(payload);
            actualField.addAlert(alert);
        }
        
        // Read the next line on the buffer and return it
        return bufferedReader.readLine();
    }

}
