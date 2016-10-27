/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.udea.vulnfinder.reportGenerator.analyzer;

import edu.udea.vulnfinder.reportGenerator.exception.ZAPApiConnectionException;
import edu.udea.vulnfinder.reportGenerator.model.Analyzer;
import edu.udea.vulnfinder.reportGenerator.model.FieldAlert;
import edu.udea.vulnfinder.reportGenerator.model.Risk;
import edu.udea.vulnfinder.reportGenerator.model.Site;
import edu.udea.vulnfinder.reportGenerator.model.SiteAlert;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.Proxy;
import java.net.URL;
import java.util.List;
import org.apache.log4j.Logger;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import edu.udea.vulnfinder.reportGenerator.service.SiteStore;

/**
 * Zap Analyzer. Analyzes the XML report that Zap provides through its API
 *
 * @author Camilo Sampedro <camilo.sampedro@udea.edu.co>
 */
public class ZapAnalyzer {

    private final static Logger LOGGER = Logger.getLogger(ZapAnalyzer.class);

    /**
     * Zap URL (For the API).
     */
    private String zapUrl;
    private final String zapHost;

    /**
     * API URL.
     */
    private final static String REPORT_URL = "OTHER/core/other/xmlreport/";

    /**
     * Site URL to be analyzed.
     */
    private String siteURLToBeAnalyzed = "";
    private boolean forcedSiteEquals = false;
    private List<String> fieldToBeIncludedList;
    private int apiPort;

    public int getPort() {
        return apiPort;
    }

    public void setPort(int port) {
        this.apiPort = port;
    }

    public String getZapUrl() {
        return zapUrl;
    }

    public void setZapUrl(String zapUrl) {
        this.zapUrl = zapUrl;
    }

    /**
     * Simple constructor. Doesn't execute anything still.
     *
     * @param zapUrl Zap URL (Used for the API - Something like "http://zap/")
     * @param zapHost Zap Host (Used for the proxy, to access the API -
     * Something like "localhost")
     */
    public ZapAnalyzer(String zapUrl, String zapHost) {
        this.zapHost = zapHost;
        this.zapUrl = zapUrl;
    }

    /**
     * Simple constructor. Doesn't execute anything still.
     *
     * @param zapUrl Zap URL (Used for the API - Something like "http://zap/")
     * @param site Site to be analyzed.
     * @param zapHost Zap Host (Used for the proxy, to access the API -
     */
    public ZapAnalyzer(String zapUrl, String site, String zapHost) {
        this.zapHost = zapHost;
        this.zapUrl = zapUrl;
        this.siteURLToBeAnalyzed = site;
    }

    /**
     * Executes the XML report analysis.
     *
     * @throws ZAPApiConnectionException Connection to Zap API could not be
     * done.
     */
    public void executeAnalysis() throws ZAPApiConnectionException {
        // Read the XML and pass it to a JDOM element.
        Element root = getXmlRoot();
        // All the children of the root should be sites elements.
        List<Element> siteElements = root.getChildren();
        // If no one is found here
        if (siteElements.isEmpty()) {
            LOGGER.warn("Empty ZAP XML report");
            return;
        }

        // Functional for, analyzing every site XML element
        siteElements.stream().forEach((Element siteElement) -> {
            String siteName = siteElement.getAttributeValue("name");
            // If it matches the site to be analyzed (Or the site to be analyzed 
            // is not given)
            if (siteURLToBeAnalyzed.equals("")
                    || (!forcedSiteEquals
                    && siteURLToBeAnalyzed.contains(siteName)
                    || siteName.contains(siteURLToBeAnalyzed))
                    || (forcedSiteEquals && siteURLToBeAnalyzed.equals(siteName)
                    || siteURLToBeAnalyzed.contains(siteName)
                    || siteName.contains(siteURLToBeAnalyzed))) {

                // Get the site from the store
                Site site = SiteStore.getSite(siteElement
                        .getAttributeValue("name"));

                // Add this analyzer
                site.addAnalyzer(Analyzer.ZAP);

                // Get alert elements
                List<Element> alerts = siteElement.getChild("alerts")
                        .getChildren();

                // Iterate functionally all the alerts
                alerts.stream().forEach((Element alertElement) -> {
                    // Get all the information of the alert. (At this point,
                    // just site alerts
                    String riskcodeString = alertElement.getChild("riskcode")
                            .getText();
                    int riskcode = Integer.parseInt(riskcodeString);
                    String riskdescription = alertElement.getChild("riskdesc")
                            .getText();
                    Risk risk = new Risk(riskcode, riskdescription);
                    String alertString = alertElement.getChild("alert")
                            .getText();
                    String description = alertElement.getChild("desc").getText()
                            .replace("<p>", "").replace("</p>", "");
                    String confidence = alertElement.getChild("confidence")
                            .getText();
                    String solution = alertElement.getChild("solution")
                            .getText().replace("<p>", "").replace("</p>", "");
                    SiteAlert alert = new SiteAlert(Analyzer.ZAP, alertString,
                            risk, description, solution, confidence);
                    site.addAlert(alert);

                    // Get the field alerts here
                    analyzeFieldAlerts(site, alertElement);
                });
            }
        });

    }

    /**
     * Looks for the XML root (In the Zap API)
     *
     * @return The XML root JDOM element
     * @throws ZAPApiConnectionException Zap API connection failed
     */
    private Element getXmlRoot() throws ZAPApiConnectionException {
        try {
            LOGGER.info("Connecting to ZAP API");
            URL obj = null;
            HttpURLConnection con = null;
            // Get the url
            try {
                obj = new URL(zapUrl + REPORT_URL);
            } catch (IOException ex) {
                LOGGER.error("There was an error connecting to ZAP Api", ex);
                throw new ZAPApiConnectionException("Input Output Exception "
                        + "connecting to ZAP Api (" + zapUrl + REPORT_URL + "): "
                        + ex.getMessage());
            }
            // Create the proxy to access the URL
            Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(zapHost, apiPort));

            // Open connection
            try {
                con = (HttpURLConnection) obj.openConnection(proxy);
            } catch (IOException ex) {
                LOGGER.error("There was an error connecting to ZAP Api", ex);
                throw new ZAPApiConnectionException("Input Output Exception "
                        + "connecting to ZAP Api (Proxy: " + zapHost + ":"
                        + apiPort + "): " + ex.getMessage());
            }

            // JDOM will fetch the XML and transform it itself to elements
            SAXBuilder jdomBuilder = new SAXBuilder();
            Document jdomDocument = jdomBuilder.build(con.getInputStream());
            LOGGER.info("Connected! XML document retrieved, analyzing...");
            return jdomDocument.getRootElement();
        } catch (MalformedURLException ex) {
            LOGGER.error("There was an error connecting to ZAP Api: " + zapUrl
                    + " malformed", ex);
            throw new ZAPApiConnectionException("Malformed ZAP URL: " + zapUrl
                    + " " + ex.getMessage());
        } catch (IOException ex) {
            LOGGER.error("There was an error connecting to ZAP Api", ex);
            throw new ZAPApiConnectionException("Input Output Exception "
                    + "connecting to ZAP Api (" + zapUrl + REPORT_URL
                    + " | proxy: " + zapHost + ":" + apiPort + "): "
                    + ex.getMessage());
        } catch (JDOMException ex) {
            LOGGER.error("There was an error connecting to ZAP Api", ex);
            throw new ZAPApiConnectionException("Jdom exception: " + ex.getMessage());
        }
    }

    /**
     * Analyze the field alerts from the XML element
     *
     * @param site Site being analyzed
     * @param alertElement Parent of the field alerts
     */
    private void analyzeFieldAlerts(Site site, Element alertElement) {
        List<Element> instances = alertElement.getChild("instances")
                .getChildren();

        instances.stream().map((instance)
                // Transform instances to its param child
                -> instance.getChild("param")
        ).filter((paramElement)
                // Filter all that aren't null
                -> (paramElement != null)
        ).map((paramElement)
                // Transform paramElements to their contained text
                -> paramElement.getText()
        ).filter((param)
                // Filter the fields that are not inside the included field list
                -> (!"N/A".equals(param)
                && (((fieldToBeIncludedList != null
                && !fieldToBeIncludedList.isEmpty())
                && fieldToBeIncludedList.contains(param))
                || (fieldToBeIncludedList != null
                && fieldToBeIncludedList.isEmpty())))
        ).map((param)
                // Transform the param String, getting the field from the site 
                // being analyzed
                -> site.getField(param)
        ).forEach((field) -> {
            // For all those found fields, get the information inside the XML
            FieldAlert fieldAlert = new FieldAlert(Analyzer.ZAP);
            fieldAlert.setTypeExplanation(alertElement.getChildText("name"));
            fieldAlert.setExploit(alertElement.getChildText("evidence"));
            field.setUri(alertElement.getChildText("uri"));
            field.addAlert(fieldAlert);
        });
    }

    public void setFieldList(List<String> fieldList) {
        this.fieldToBeIncludedList = fieldList;
    }

    public void setForced(boolean forced) {
        this.forcedSiteEquals = forced;
    }
}
