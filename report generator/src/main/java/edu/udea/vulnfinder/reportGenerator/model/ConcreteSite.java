/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.udea.vulnfinder.reportGenerator.model;

import com.hp.gagawa.java.Node;
import com.hp.gagawa.java.elements.A;
import com.hp.gagawa.java.elements.Div;
import com.hp.gagawa.java.elements.H2;
import com.hp.gagawa.java.elements.Li;
import com.hp.gagawa.java.elements.Span;
import com.hp.gagawa.java.elements.Ul;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.log4j.Logger;

/**
 * Implementation of a Site
 * @author Camilo Sampedro <camilo.sampedro@udea.edu.co>
 */
public class ConcreteSite implements Site {

    private static final Logger LOGGER = Logger.getLogger(ConcreteSite.class);
    private final Map<String, Field> FIELDS = new HashMap<>();
    private final List<Alert> alerts;
    private final List<String> charset = new ArrayList<>();
    private String site;
    private final List<Analyzer> analyzers;

    public ConcreteSite() {
        analyzers = new ArrayList<>();
        alerts = new ArrayList<>();
    }

    public ConcreteSite(String site) {
        analyzers = new ArrayList<>();
        alerts = new ArrayList<>();
        this.site = site;
    }

    @Override
    public void addAlert(SiteAlert alert) {
        alerts.add(alert);
    }

    @Override
    public String getSite() {
        return site;
    }

    @Override
    public void setSite(String site) {
        this.site = site;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        if (!alerts.isEmpty()) {
            builder.append("ALERTS \n");
            alerts.stream().forEach((alert) -> {
                builder.append("\t").append(alert.toString());
            });
        }

        if (!FIELDS.isEmpty()) {
            builder.append("FIELDS");
            FIELDS.values().stream().forEach((field) -> {
                builder.append("\t").append(field.toString());
            });
        }
        return "Site{ " + site + "\n"
                + builder.toString()
                + "}";
    }

    @Override
    public boolean deleteCharset(String charset) {
        return this.charset.remove(charset);
    }

    @Override
    public String getCharset(int i) {
        return charset.get(i);
    }

    @Override
    public void addCharset(String charset) {
        this.charset.add(charset);
    }

    @Override
    public void addAnalyzer(Analyzer analyzer) {
        analyzers.add(analyzer);
    }

    @Override
    public List<Analyzer> getAnalyzers() {
        return analyzers;
    }

    @Override
    public Li toHtml() {
        Li siteLi = new Li();

        A titleSection = new A();
        titleSection.setCSSClass("expand");

        Div rightArrow = new Div();
        rightArrow.setCSSClass("right-arrow");
        rightArrow.appendText("+");
        titleSection.appendChild(rightArrow);

        Div titleContent = new Div();
        H2 title = new H2();
        title.setCSSClass("siteurl");
        title.appendText(site);
        titleContent.appendChild(title);
        //TODO add alert counters
        Span span = new Span();
        span.appendChild(getAlertCounters());
        titleContent.appendChild(span);
        titleSection.appendChild(titleContent);

        siteLi.appendChild(titleSection);

        Div contentSection = new Div();
        contentSection.setCSSClass("detail");

        Div left = new Div();
        left.setCSSClass("left");
        Div content = new Div();

        if (!alerts.isEmpty()) {

            H2 siteAlertsTitle = new H2();
            siteAlertsTitle.appendText("Site alerts");
            content.appendChild(siteAlertsTitle);

            Ul siteAlertList = new Ul();
            alerts.stream().forEach((siteAlert) -> {
                siteAlertList.appendChild(siteAlert.toHtml());
            });
            content.appendChild(siteAlertList);
        }

        if (!FIELDS.isEmpty()) {
            H2 siteAlertsTitle = new H2();
            siteAlertsTitle.appendText("Field alerts");
            content.appendChild(siteAlertsTitle);

            Div accordion = new Div();
            accordion.setId("accordion");

            FIELDS.values().stream().forEach((field) -> {
                accordion.appendChild(field.toHtml());
            });
            content.appendChild(accordion);
        }

        left.appendChild(content);
        contentSection.appendChild(left);

        siteLi.appendChild(contentSection);
        return siteLi;
    }

    @Override
    public Field getField(String fieldName) {
        Field field = FIELDS.get(fieldName);
        if (field == null) {
            field = new Field(fieldName);
            FIELDS.put(fieldName, field);
        }
        return field;
    }

    @Override
    public List<Alert> getAlerts() {
        return this.alerts;
    }

    @Override
    public boolean isEmpty() {
        return alerts.isEmpty() && FIELDS.isEmpty();
    }

    private List<Node> getAlertCounters() {
        List<Node> alertCounters = new ArrayList<>();
        Span siteAlertsSpan = new Span();
        siteAlertsSpan.setCSSClass("sitealertcounter");
        siteAlertsSpan.appendText("Site alerts: " + Integer.toString(alerts.size()) + " | ");
        alertCounters.add(siteAlertsSpan);
        Span fieldAlertsSpan = new Span();
        fieldAlertsSpan.setCSSClass("fieldalertcounter");
        fieldAlertsSpan.appendText("Field alerts: " + Integer.toString(FIELDS.size()));
        alertCounters.add(fieldAlertsSpan);
        return alertCounters;
    }
}
