/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.udea.generadorreportesvuln;

import br.com.softplan.security.zap.zaproxy.clientapi.core.ApiResponse;
import br.com.softplan.security.zap.zaproxy.clientapi.core.ClientApi;
import br.com.softplan.security.zap.zaproxy.clientapi.core.ClientApiException;
import co.edu.udea.generadorreportesvuln.exception.ZAPApiConnectionException;
import co.edu.udea.generadorreportesvuln.model.Alert;
import co.edu.udea.generadorreportesvuln.model.Risk;
import co.edu.udea.generadorreportesvuln.model.Site;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.Proxy;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import org.apache.log4j.Logger;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

/**
 *
 * @author camilosampedro
 */
public class ZAPReportGenerator {

    private final static Logger LOGGER = Logger.getLogger(ZAPReportGenerator.class);

    private String zapUrl;
    private static final String USER_AGENT = "Mozulla/5.0";

    public String getZapUrl() {
        return zapUrl;
    }

    public void setZapUrl(String zapUrl) {
        this.zapUrl = zapUrl;
    }

    public ZAPReportGenerator(String zapUrl) {
        this.zapUrl = zapUrl;
    }

    public List<Site> getReport() throws ZAPApiConnectionException {
        List<Site> sites = new ArrayList<>();
        Element root = getXmlRoot();
        List<Element> siteElements = root.getChildren();

        siteElements.stream().forEach((Element siteElement) -> {
            Site site = new Site(siteElement.getAttributeValue("name"));
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

                Alert alert = new Alert(alertString, risk, description, solution, confidence);
                site.addAlert(alert);
            });
            System.out.println(site.toString());
            sites.add(site);
        });
        return sites;
    }

    private Element getXmlRoot() throws ZAPApiConnectionException {
        try {
            LOGGER.debug("Connecting to ZAP API");
            URL obj = new URL(zapUrl);
            Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("localhost", 8080));
            HttpURLConnection con = (HttpURLConnection) obj.openConnection(proxy);
            SAXBuilder jdomBuilder = new SAXBuilder();
            Document jdomDocument = jdomBuilder.build(con.getInputStream());
            return jdomDocument.getRootElement();
        } catch (MalformedURLException ex) {
            LOGGER.error("There was an error connecting to ZAP Api", ex);
            throw new ZAPApiConnectionException("Malformed ZAP URL" + ex.getMessage());
        } catch (IOException ex) {
            LOGGER.error("There was an error connecting to ZAP Api", ex);
            throw new ZAPApiConnectionException("Input Output Exception connecting to ZAP Api" + ex.getMessage());
        } catch (JDOMException ex) {
            LOGGER.error("There was an error connecting to ZAP Api", ex);
            throw new ZAPApiConnectionException("Jdom exception: " + ex.getMessage());
        }
    }
}
