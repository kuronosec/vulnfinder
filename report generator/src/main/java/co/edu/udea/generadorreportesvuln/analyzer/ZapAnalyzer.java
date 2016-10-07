/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.udea.generadorreportesvuln.analyzer;

import co.edu.udea.generadorreportesvuln.exception.ZAPApiConnectionException;
import co.edu.udea.generadorreportesvuln.model.Analyzer;
import co.edu.udea.generadorreportesvuln.model.FieldAlert;
import co.edu.udea.generadorreportesvuln.model.Risk;
import co.edu.udea.generadorreportesvuln.model.Site;
import co.edu.udea.generadorreportesvuln.model.SiteAlert;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.Proxy;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import co.edu.udea.generadorreportesvuln.service.SiteStore;

/**
 *
 * @author camilosampedro
 */
public class ZapAnalyzer {

    private final static Logger LOGGER = Logger.getLogger(ZapAnalyzer.class);

    private String zapUrl;
    private final String zapHost;
    private final static String REPORTURL = "OTHER/core/other/xmlreport/";
    private String siteURL = "";
    private boolean forced = false;
    private List<String> fieldList;
    private int port;

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getZapUrl() {
        return zapUrl;
    }

    public void setZapUrl(String zapUrl) {
        this.zapUrl = zapUrl;
    }

    public ZapAnalyzer(String zapUrl, String zapHost) {
        this.zapHost = zapHost;
        this.zapUrl = zapUrl;
    }

    public ZapAnalyzer(String zapUrl, String site, String zapHost) {
        this.zapHost = zapHost;
        this.zapUrl = zapUrl;
        this.siteURL = site;
    }

    public List<Site> getReport() throws ZAPApiConnectionException {
        List<Site> sites = new ArrayList<>();
        Element root = getXmlRoot();
        List<Element> siteElements = root.getChildren();

        if (siteElements.isEmpty()) {
            LOGGER.warn("Empty ZAP XML report");
        } else {
            siteElements.stream().forEach((Element siteElement) -> {
                String siteName = siteElement.getAttributeValue("name");
                if (siteURL.equals("") || (!forced && siteURL.contains(siteName) || siteName.contains(siteURL)) || (forced && siteURL.equals(siteName)  || siteURL.contains(siteName)|| siteName.contains(siteURL))) {
                    Site site = SiteStore.getSite(siteElement.getAttributeValue("name"));
                    site.addAnalyzer(Analyzer.ZAP);
                    List<Element> alerts = siteElement.getChild("alerts").getChildren();
                    alerts.stream().forEach((Element alertElement) -> {

                        String riskcodeString = alertElement.getChild("riskcode").getText();
                        int riskcode = Integer.parseInt(riskcodeString);
                        String riskdescription = alertElement.getChild("riskdesc").getText();
                        Risk risk = new Risk(riskcode, riskdescription);
                        String alertString = alertElement.getChild("alert").getText();
                        String description = alertElement.getChild("desc").getText().replace("<p>", "").replace("</p>", "");
                        String confidence = alertElement.getChild("confidence").getText();
                        String solution = alertElement.getChild("solution").getText().replace("<p>", "").replace("</p>", "");
                        SiteAlert alert = new SiteAlert(Analyzer.ZAP, alertString, risk, description, solution, confidence);
                        analyzeFieldAlerts(site, alertElement);
                        site.addAlert(alert);
                    });
                    if (!site.isEmpty()) {
                        //LOGGER.debug(site);
                    }
                    sites.add(site);
                }
            });
        }
        return sites;
    }

    private Element getXmlRoot() throws ZAPApiConnectionException {
        try {
            LOGGER.info("Connecting to ZAP API");
            URL obj = null;
            HttpURLConnection con = null;
            try {
                obj = new URL(zapUrl + REPORTURL);
            } catch (IOException ex) {
                LOGGER.error("There was an error connecting to ZAP Api", ex);
                throw new ZAPApiConnectionException("Input Output Exception connecting to ZAP Api (" + zapUrl + REPORTURL + "): " + ex.getMessage());
            }
            Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(zapHost, port));
            try {
                con = (HttpURLConnection) obj.openConnection(proxy);
            } catch (IOException ex) {
                LOGGER.error("There was an error connecting to ZAP Api", ex);
                throw new ZAPApiConnectionException("Input Output Exception connecting to ZAP Api (Proxy: " + zapHost + ":" + port + "): " + ex.getMessage());
            }
            SAXBuilder jdomBuilder = new SAXBuilder();
            Document jdomDocument = jdomBuilder.build(con.getInputStream());
            LOGGER.info("Connected! XML document retrieved, analyzing...");
            return jdomDocument.getRootElement();
        } catch (MalformedURLException ex) {
            LOGGER.error("There was an error connecting to ZAP Api: " + zapUrl + " malformed", ex);
            throw new ZAPApiConnectionException("Malformed ZAP URL: " + zapUrl + " " + ex.getMessage());
        } catch (IOException ex) {
            LOGGER.error("There was an error connecting to ZAP Api", ex);
            throw new ZAPApiConnectionException("Input Output Exception connecting to ZAP Api (" + zapUrl + REPORTURL + " | proxy: " + zapHost + ":" + port + "): " + ex.getMessage());
        } catch (JDOMException ex) {
            LOGGER.error("There was an error connecting to ZAP Api", ex);
            throw new ZAPApiConnectionException("Jdom exception: " + ex.getMessage());
        }
    }

    private void analyzeFieldAlerts(Site site, Element alertElement) {
        List<Element> instances = alertElement.getChild("instances").getChildren();
        instances.stream().map((instance)
                -> instance.getChild("param")
        ).filter((paramElement)
                -> (paramElement != null)
        ).map((paramElement)
                -> paramElement.getText()
        ).filter((param)
                -> (!"N/A".equals(param)
                && (((fieldList != null && !fieldList.isEmpty())
                && fieldList.contains(param))
                || (fieldList != null && fieldList.isEmpty())))
        ).map((param)
                -> site.getField(param)
        ).forEach((field) -> {
            //LOGGER.debug("Param found with ZAP: " + param);
            FieldAlert fieldAlert = new FieldAlert(Analyzer.ZAP);
            fieldAlert.setTitle(alertElement.getChildText("name"));
            field.addAlert(fieldAlert);
        });
    }

    public void setFieldList(List<String> fieldList) {
        this.fieldList = fieldList;
    }

    public void setForced(boolean forced) {
        this.forced = forced;
    }
}
