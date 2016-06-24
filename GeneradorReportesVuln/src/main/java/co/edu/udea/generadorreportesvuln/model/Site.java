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
public class Site {

    private List<String> charset;
    private String site;
    private List<Alert> alerts;

    public Site() {
        alerts = new ArrayList<>();
    }

    public Site(String site) {
        alerts = new ArrayList<>();
        this.site = site;
    }

    public void addAlert(Alert alert) {
        alerts.add(alert);
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public List<Alert> getAlerts() {
        return alerts;
    }

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
    
    public boolean deleteCharset(String charset) {
        return this.charset.remove(charset);
    }

    public String getCharset(int i) {
        return charset.get(i);
    }

    public void setCharset(String charset) {
        this.charset.add(charset);
    }
    
    
    
    

}
