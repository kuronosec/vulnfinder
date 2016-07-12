/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.udea.generadorreportesvuln.model;

import com.hp.gagawa.java.elements.Div;
import com.hp.gagawa.java.elements.H1;
import com.hp.gagawa.java.elements.Span;
import com.hp.gagawa.java.elements.Table;
import com.hp.gagawa.java.elements.Tbody;
import com.hp.gagawa.java.elements.Th;
import com.hp.gagawa.java.elements.Thead;
import com.hp.gagawa.java.elements.Ul;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author camilosampedro
 */
public class ConcreteSite implements Site {

    private static final Map<String, Field> FIELDS = new HashMap<>();
    private List<Alert> alerts;
    private List<String> charset;
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
    public void setCharset(String charset) {
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
    public Div toHtml() {
        Div siteDiv = new Div();

        siteDiv.setCSSClass("site");

        H1 title = new H1();

        title.appendText("Site: ");

        Span span = new Span();
        span.setCSSClass("siteurl");
        span.appendText(site);

        title.appendChild(span);

        siteDiv.appendChild(title);

        if (!alerts.isEmpty()) {

            H1 siteAlertsTitle = new H1();
            siteAlertsTitle.appendText("Site alerts");
            siteDiv.appendChild(siteAlertsTitle);

            Ul siteAlertList = new Ul();
            alerts.stream().forEach((siteAlert) -> {
                siteAlertList.appendChild(siteAlert.toHtml());
            });
            siteDiv.appendChild(siteAlertList);
        }

        Table table = new Table();
        table.setCSSClass("table");
        Thead thead = new Thead();
        thead.setCSSClass("thead-default");
        //Type title payload
        Th typeTh = new Th();
        typeTh.appendText("Type");
        thead.appendChild(typeTh);
        Th titleTh = new Th();
        titleTh.appendText("Title");
        thead.appendChild(titleTh);
        Th payloadTh = new Th();
        payloadTh.appendText("Payload");
        thead.appendChild(payloadTh);
        table.appendChild(thead);

        Tbody tbody = new Tbody();
        FIELDS.values().stream().forEach((field) -> {
            tbody.appendChild(field.toHtml());
        });
        table.appendChild(tbody);

        siteDiv.appendChild(table);

        return siteDiv;
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
}
