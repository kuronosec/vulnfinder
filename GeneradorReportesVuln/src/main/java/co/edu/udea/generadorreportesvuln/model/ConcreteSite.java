/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.udea.generadorreportesvuln.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author camilosampedro
 */
public class ConcreteSite implements Site {
    private List<String> charset;
    private String site;
    private List<Alert> alerts;
    private final List<Analyzer> analyzers;

    public ConcreteSite() {
        alerts = new ArrayList<>();
        analyzers = new ArrayList<>();
    }

    public ConcreteSite(String site) {
        alerts = new ArrayList<>();
        analyzers = new ArrayList<>();
        this.site = site;
    }

    @Override
    public void addAlert(Alert alert) {
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
    public List<Alert> getAlerts() {
        return alerts;
    }

    @Override
    public void setAlerts(List<Alert> alerts) {
        this.alerts = alerts;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        alerts.stream().forEach((alert) -> {
            builder.append(alert.toString()).append("\n--------------------\n");
        });
        return "Site{ "+ site +"\n"
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
    
    
    
    

}
