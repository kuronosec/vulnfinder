/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.udea.generadorreportesvuln.model;

import co.edu.udea.generadorreportesvuln.file.FilesAsStrings;
import com.hp.gagawa.java.elements.Body;
import com.hp.gagawa.java.elements.Div;
import com.hp.gagawa.java.elements.H1;
import com.hp.gagawa.java.elements.Head;
import com.hp.gagawa.java.elements.Img;
import com.hp.gagawa.java.elements.Link;
import com.hp.gagawa.java.elements.Meta;
import com.hp.gagawa.java.elements.P;
import com.hp.gagawa.java.elements.Script;
import com.hp.gagawa.java.elements.Title;
import com.hp.gagawa.java.elements.Ul;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import org.apache.log4j.Logger;

/**
 *
 * @author camilosampedro
 */
public class Report {

    private final static Logger LOGGER = Logger.getLogger(Report.class);
    private static final String JAVASCRIPT_FILE = "main.js";
    private static final String CSS_FILE = "main.css";
    private static final String JQUERYMINJS = "jquery.min.js";
    private static final String BOOTSTRAPMINCSS = "bootstrap.min.css";
    private static final String FONTAWESOMEMINCSS = "font-awesome.min.css";
    private static final String BOOTSTRAPMINJS = "bootstrap.min.js";
    private static final String LOGO = "logo.png";
    private static String pageTitleToPut;
    private static List<Site> sitesToUse;

    public static DocumentWithHeadAndBody toHtml(List<Site> sites, String pageTitle) throws IOException {
        DocumentWithHeadAndBody finalHtml = new DocumentWithHeadAndBody("<!DOCTYPE html>");
        sitesToUse = sites;
        pageTitleToPut = pageTitle;

        Head head = generateHead();

        Body body = generateBody();
        finalHtml.head = head;
        finalHtml.body = body;
        return finalHtml;
    }

    public static void writeToFile(DocumentWithHeadAndBody html, String filePath) throws FileNotFoundException {
        File path = new File(filePath);
        if (!path.exists()) {
            Boolean success = (path).mkdirs();
            if (!success) {
                LOGGER.error("Failed to create folder: " + filePath);
                return;
            }
        }
        copyResource(JQUERYMINJS, filePath);
        copyResource(CSS_FILE, filePath);
        copyResource(JAVASCRIPT_FILE, filePath);
        copyResource(LOGO, filePath);
        copyResource(BOOTSTRAPMINJS, filePath);
        copyResource(FONTAWESOMEMINCSS, filePath);
        copyResource(BOOTSTRAPMINCSS, filePath);

        try (PrintWriter out = new PrintWriter(filePath + "/" + "report.html", "UTF-8")) {
            out.println(html.write());
            LOGGER.info("Saved to " + filePath + " successfuly");
        } catch (FileNotFoundException ex) {
            LOGGER.error("File not found: " + filePath, ex);
            throw ex;
        } catch (UnsupportedEncodingException ex) {
            java.util.logging.Logger.getLogger(Report.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static Head generateHead() throws IOException {
        Head head = new Head();

        Meta meta = new Meta("text/html; charset=ISO-8859-1");
        meta.setHttpEquiv("content-type");
        head.appendChild(meta);

        Script script;

        script = new Script("text/javascript");
        script.appendText(FilesAsStrings.getFileAsString(JQUERYMINJS));
        head.appendChild(script);

        script = new Script("text/javascript");
        script.appendText(FilesAsStrings.getFileAsString(BOOTSTRAPMINJS));
        head.appendChild(script);

        Link style = new Link();
        style.setRel("stylesheet");
        style.setType("text/css");
        style.appendText(FilesAsStrings.getFileAsString(CSS_FILE));
        head.appendChild(style);

        Link link = new Link();
        link.setRel("stylesheet");
        link.appendText(FilesAsStrings.getFileAsString(BOOTSTRAPMINCSS));
        link.setType("text/css");

        head.appendChild(link);

        link = new Link();
        link.setHref("https://maxcdn.bootstrapcdn.com/font-awesome/4.6.3/css/font-awesome.min.css");
        link.setRel("stylesheet");
        link.setType("text/css");
        head.appendChild(link);

        link = new Link();
        link.setHref("http://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700,800");
        link.setRel("stylesheet");
        link.setType("text/css");
        head.appendChild(link);

        script = new Script("text/javascript");
        script.appendText(FilesAsStrings.getFileAsString(JAVASCRIPT_FILE));
        script.setLanguage("javascript");
        script.setDefer("defer");
        head.appendChild(script);

        Title title = new Title();
        title.appendText(pageTitleToPut);
        head.appendChild(title);

        return head;
    }

    private static Body generateBody() {
        Body body = new Body();

        Div jumbotron = new Div();

        jumbotron.setCSSClass("jumbotron");

        Div jumbotronContainer = new Div();
        jumbotronContainer.setCSSClass("container");
        Div row = new Div();
        row.setCSSClass("row");
        Div imgCol = new Div();
        imgCol.setCSSClass("col-md-3");
        Img logo = new Img("Logo", FilesAsStrings.BASE64LOGO);
        logo.setId("logo");
        imgCol.appendChild(logo);
        row.appendChild(imgCol);

        Div titleCol = new Div();
        titleCol.setId("report-title");
        titleCol.setCSSClass("col-md-9 centerfy");

        H1 pageTitleElement = new H1();
        pageTitleElement.appendText(pageTitleToPut);
        P dateP = new P();
        Date date = new Date();
        SimpleDateFormat ft = new SimpleDateFormat("dd/MM/yyyy - hh:mm:ss");
        dateP.appendText("Generated at " + ft.format(date));

        titleCol.appendChild(pageTitleElement);
        titleCol.appendChild(dateP);
        row.appendChild(titleCol);
        jumbotron.appendChild(row);

        body.appendChild(jumbotron);

        Div container = new Div();
        container.setCSSClass("container");
        Div integrator = new Div();
        integrator.setId("integration-list");

        Ul siteList = new Ul();

        sitesToUse.stream().forEach((site) -> {
            siteList.appendChild(site.toHtml());
        });

        integrator.appendChild(siteList);
        container.appendChild(integrator);

        body.appendChild(container);

        return body;
    }

    public static void writeToSystemOutput(List<Site> all) {
        all.stream().forEach((site) -> {
            System.out.println(site.toString());
        });
    }

    private static void copyResource(String resource, String filePath) {
        LOGGER.info("Copying resource: " + resource);
        OutputStream outputStream = null;
        InputStream resourceAsStream = null;
        try {
            resourceAsStream = Report.class.getResourceAsStream("/" + resource);
            if (resourceAsStream == null) {
                LOGGER.error("Resource not found: " + resource);
                return;
            }
            outputStream = new FileOutputStream(new File(filePath + "/" + resource));
            int read;
            byte[] bytes = new byte[1024];
            while ((read = resourceAsStream.read(bytes)) != -1) {
                outputStream.write(bytes, 0, read);
            }
            LOGGER.info("Copying resource: " + resource + " | Done!");
        } catch (IOException ex) {
            LOGGER.error(ex);
        } finally {
            try {
                if (outputStream != null) {
                    outputStream.close();
                }
                if (resourceAsStream != null) {
                    resourceAsStream.close();
                }
            } catch (IOException | NullPointerException ex) {
                LOGGER.error(ex);
            }
        }
    }
}
