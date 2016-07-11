/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.udea.generadorreportesvuln.model;

import com.hp.gagawa.java.elements.Div;
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
    }

    public ConcreteSite(String site) {
        analyzers = new ArrayList<>();
        this.site = site;
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
        FIELDS.values().stream().forEach((field) -> {
            siteDiv.appendChild(field.toHtml());
        });
        return siteDiv;
    }

    @Override
    public Field getField(String fieldName) {
        Field field = FIELDS.get(fieldName);
        if(field == null) {
            field = new Field(fieldName);
            FIELDS.put(fieldName, field);
        }
        return field;
    }

    @Override
    public void addAlert(SiteAlert alert) {
        this.alerts.add(alert);
    }

    @Override
    public List<Alert> getAlerts() {
        return this.alerts;
    }
}
