/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.udea.generadorreportesvuln.model;

import com.hp.gagawa.java.elements.Li;

/**
 *
 * @author camilosampedro
 */
public class SiteAlert extends Alert {
    
    private String alert;
    private Risk risk;
    private String description;
    private String solution;
    private String confidence;
    
    public SiteAlert(Analyzer analyzer) {
        super(analyzer);
    }
    
    public SiteAlert(Analyzer analyzer, String alert, Risk risk, String description, String solution, String confidence) {
        super(analyzer);
        this.alert = alert;
        this.risk = risk;
        this.description = description;
        this.solution = solution;
        this.confidence = confidence;
    }

    public Risk getRisk() {
        return risk;
    }

    public void setRisk(Risk risk) {
        this.risk = risk;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSolution() {
        return solution;
    }

    public void setSolution(String solution) {
        this.solution = solution;
    }

    public String getConfidence() {
        return confidence;
    }

    public void setConfidence(String confidence) {
        this.confidence = confidence;
    }

    public String getAlert() {
        return alert;
    }

    public void setAlert(String alert) {
        this.alert = alert;
    }
    
    @Override
    public String toString() {
        return "Alert{\n"
                + "Analyzer:\t" + getAnalyzer() + "\n"
                + "Alert:\t\t" + alert + "\n"
                + "Risk:\t\t" + risk + "\n"
                + "Description:\t" + description + "\n"
                + "Confidence:\t" + confidence + "\n"
                + "Solution:\t" + solution + "\n"
                + "}";
    }

    @Override
    public Li toHtml() {
        Li alertItem = new Li();
        alertItem.appendText(toString());
        return alertItem;
    }
}
