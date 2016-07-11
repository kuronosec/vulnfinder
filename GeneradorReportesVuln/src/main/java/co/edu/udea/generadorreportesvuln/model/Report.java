/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.udea.generadorreportesvuln.model;

import com.hp.gagawa.java.elements.Body;
import com.hp.gagawa.java.elements.Div;
import com.hp.gagawa.java.elements.H1;
import com.hp.gagawa.java.elements.Head;
import com.hp.gagawa.java.elements.Html;
import com.hp.gagawa.java.elements.Link;
import com.hp.gagawa.java.elements.Meta;
import com.hp.gagawa.java.elements.Script;
import com.hp.gagawa.java.elements.Style;
import com.hp.gagawa.java.elements.Title;
import java.util.List;

/**
 *
 * @author camilosampedro
 */
public class Report {

    private static String pageTitleToPut;
    private static List<Site> sitesToUse;

    public static Html toHtml(List<Site> sites, String pageTitle) {
        sitesToUse = sites;
        pageTitleToPut = pageTitle;
        Html html = new Html();

        Head head = generateHead();
        html.appendChild(head);

        Body body = generateBody();
        return html;
    }

    private static Head generateHead() {
        Head head = new Head();

        Meta meta = new Meta("text/html; charset=ISO-8859-1");
        meta.setHttpEquiv("content-type");
        head.appendChild(meta);

        Title title = new Title();
        title.appendText(pageTitleToPut);
        head.appendChild(title);

        Script script = new Script("javascript");
        script.setSrc("https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js");
        script.setAttribute("integrity", "sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS");
        script.setAttribute("crossorigin", "anonymous");
        head.appendChild(script);

        script = new Script("javascript");
        script.setSrc("https://code.jquery.com/jquery-3.0.0.min.js");
        script.setAttribute("integrity", "sha256-JmvOoLtYsmqlsWxa7mDSLMwa6dZ9rrIdtrrVYRnDRH0=");
        script.setAttribute("crossorigin", "anonymous");
        head.appendChild(script);

        Style style = new Style("text/css");
        style.appendText(".siteurl {\n"
                + "            font-family: monospace;\n"
                + "        }");
        head.appendChild(style);

        script = new Script("javascript");
        script.appendText("$(function () {\n"
                + "            $(\"#site1\").load(\"site.html\");\n"
                + "        });");
        head.appendChild(script);

        Link link = new Link();
        link.setRel("stylesheet");
        link.setHref("https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css");
        link.setType("text/css");
        head.appendChild(link);

        return head;
    }

    private static Body generateBody() {
        Body body = new Body();

        Div jumbotron = new Div();

        jumbotron.setCSSClass("jumbotron");

        H1 pageTitleElement = new H1();
        pageTitleElement.setTitle(pageTitleToPut);

        jumbotron.appendChild(pageTitleElement);

        body.appendChild(jumbotron);

        Div container = new Div();
        container.setCSSClass("container");

        sitesToUse.stream().forEach((site) -> {
            container.appendChild(site.toHtml());
        });

        body.appendChild(container);

        return body;
    }
}
