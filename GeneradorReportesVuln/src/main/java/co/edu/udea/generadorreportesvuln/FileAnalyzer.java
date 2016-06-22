/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.udea.generadorreportesvuln;

import co.edu.udea.generadorreportesvuln.model.Site;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.log4j.Logger;

/**
 *
 * @author camilosampedro
 */
public class FileAnalyzer {

    private final static Logger LOGGER = Logger.getLogger(GeneradorReportes.class);
    private final String file;
    private final String siteToAnalyze;

    public FileAnalyzer(String file, String siteToAnalyze) {
        this.file = file;
        this.siteToAnalyze = siteToAnalyze;
    }

    public void analyze() throws IOException {
        LOGGER.info("Analyzing file: " + file);
        //String patternString = "^\\[(?:[0-9]{2}:){2}[0-9]{2}\\]\\s\\[(?:INFO|WARNING)\\]\\s(?!testing)(.*)$";
        String patternString = "^\\[(?:[0-9]{2}:){2}[0-9]{2}\\]\\s\\[(INFO|WARNING)\\]\\s(?!testing)(.*)$";
        String urlPatternString = "(http|ftp|https):\\/\\/([\\w_-]+(?:(?:\\.[\\w_-]+)+))([\\w.,@?^=%&:/~+#-]*[\\w@?^=%&/~+#-])?";
        //Report reporte = new Report();
        Pattern pattern = Pattern.compile(patternString);
        Pattern urlPattern = Pattern.compile(urlPatternString);
        List<String> result = new ArrayList<>();
        List<String> parameters = new ArrayList<>();
        Site site;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            StringBuilder stringBuilder = new StringBuilder();

            String line = bufferedReader.readLine();
            Boolean isTheBeginning = false;
            Boolean firstLine = true;
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
                        site = new Site(siteURL);
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
                    parameters.add(line);
                }
                Matcher matcher = pattern.matcher(line);
                if (matcher.find()) {
                    // System.out.println("Found value 1: " + m.group(0));
                    String level = matcher.group(1);
                    String found = matcher.group(2);
                    result.add(found);
                    LOGGER.info("Found: " + level.charAt(0) + " - " + found);
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
}
