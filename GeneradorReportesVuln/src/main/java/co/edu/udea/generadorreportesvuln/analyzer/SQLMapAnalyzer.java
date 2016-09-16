/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.udea.generadorreportesvuln.analyzer;

import co.edu.udea.generadorreportesvuln.FilePatternFinder;
import co.edu.udea.generadorreportesvuln.ReportGenerator;
import co.edu.udea.generadorreportesvuln.model.FieldAlert;
import co.edu.udea.generadorreportesvuln.model.Analyzer;
import co.edu.udea.generadorreportesvuln.model.Field;
import co.edu.udea.generadorreportesvuln.model.Site;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.regex.Matcher;
import org.apache.log4j.Logger;
import co.edu.udea.generadorreportesvuln.service.SiteStore;
import java.util.List;

/**
 *
 * @author Camilo Sampedro
 */
public class SQLMapAnalyzer extends FilePatternFinder {

    private final static Logger LOGGER = Logger.getLogger(SQLMapAnalyzer.class);
    private final String file;
    private final String siteToAnalyze;
    private List<String> fieldList;
    private boolean isTheBeginning;
    private boolean firstLine;
    private String actualParameter;
    private String actualMethod;
    private String type = "", title = "", payload;

    public SQLMapAnalyzer(String file, String siteToAnalyze) {
        this.file = file;
        this.siteToAnalyze = siteToAnalyze;
    }

    public void analyze() throws IOException {
        LOGGER.info("Analyzing file: " + file);
        //Report reporte = new Report();
        Site site = SiteStore.getSite(siteToAnalyze);

        actualParameter = "";
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String line = bufferedReader.readLine();
            isTheBeginning = false;
            firstLine = true;
            while (line != null) {
                if (firstLine) {
                    Matcher matcher = urlPattern.matcher(line);
                    if (matcher.find()) {
                        String siteURL = matcher.group(0);
                        try {
                            URI uri = new URI(siteURL);
                            URL url = new URL(siteURL);
                            siteURL = url.getProtocol() + "://" + uri.getHost();
                        } catch (URISyntaxException ex) {
                            LOGGER.error("There was an error parsing site URL", ex);
                        }
                        if (!siteToAnalyze.equals("") && !siteURL.contains(siteToAnalyze)) {
                            LOGGER.info("The site " + siteToAnalyze + " is not been reported in this file. This file has reports of " + siteURL + ".");
                            break;
                        }
                        LOGGER.info("Site: " + siteURL);
                        site = SiteStore.getSite(siteURL);
                        site.addAnalyzer(Analyzer.SQLMAP);
                    } else {
                        LOGGER.info("No site found");
                    }
                    line = bufferedReader.readLine();
                    firstLine = !firstLine;
                    continue;
                }
                if ("---".equals(line)) {
                    isTheBeginning = !isTheBeginning;
                    line = bufferedReader.readLine();
                    continue;
                }
                if (isTheBeginning) {
                    line = analyzeBeginning(site, bufferedReader, line);
                    continue;
                }
                Matcher matcher = pattern.matcher(line);
                if (matcher.find()) {
                    // System.out.println("Found value 1: " + m.group(0));
                    String level = matcher.group(1);
                    String found = matcher.group(2);
                    if (found.contains("heuristics detected webpage charset") && site != null) {
                        site.addCharset(found.substring(found.lastIndexOf(' ') + 1));
                    }
                    if ("INFO".equalsIgnoreCase(level)) {
                        //LOGGER.debug("Found: " + found);
                    } else if ("WARNING".equalsIgnoreCase(level)) {
                        LOGGER.warn("Found: " + found);
                    }

                    // System.out.println(m.group(1));
                    // System.out.println("Found value 3: " + m.group(2));
                }
                line = bufferedReader.readLine();
            }
        } catch (IOException ex) {
            LOGGER.error("There was an error reading " + file + " file ", ex);
        }
        /*reporte.setEventos(resultado);
        reporte.setParametros(parametros);
        return reporte;*/

    }

    public void setFieldList(List<String> fieldList) {
        this.fieldList = fieldList;
    }

    private String analyzeBeginning(Site site, BufferedReader bufferedReader, String line) throws IOException {
        LOGGER.debug("Analyzing beginning: \"" + line + "\"");
        Matcher parameterMatcher = parameterPattern.matcher(line);
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
        Matcher typeMatcher = typePattern.matcher(line);
        if (typeMatcher.find() && !"".equals(actualParameter)) {
            type = typeMatcher.group(1);
            LOGGER.debug("Found type: " + type);
            return bufferedReader.readLine();
        }
        Matcher titleMatcher = titlePattern.matcher(line);
        if (titleMatcher.find() && !"".equals(actualParameter)) {
            
            title = titleMatcher.group(1);
            LOGGER.debug("Found title: " + title);
            return bufferedReader.readLine();
        }
        Matcher payloadMatcher = payloadPattern.matcher(line);
        if (payloadMatcher.find() && !"".equals(actualParameter)) {
            payload = payloadMatcher.group(1);
            Field actualField = site.getField(actualParameter);
            FieldAlert alert = new FieldAlert(Analyzer.SQLMAP);
            alert.setType(type);
            alert.setTitle(title);
            alert.setPayload(payload);
            actualField.addAlert(alert);
        }
        return bufferedReader.readLine();
    }

}
