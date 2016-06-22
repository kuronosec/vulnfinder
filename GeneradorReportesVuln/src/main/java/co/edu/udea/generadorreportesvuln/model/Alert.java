/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.udea.generadorreportesvuln.model;

/**
 *
 * @author camilosampedro
 */
public class Alert {

    private final String field;
    private String alert;
    private Risk risk;
    private String description;
    private String solution;
    private String confidence;

    public Alert(String field) {
        this.field = field;
    }

    public Alert(String field,String alert, Risk risk, String description, String solution, String confidence) {
        this.field = field;
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
        return "Alert{ " + "Field="+ field 
                + "\t" + alert + "\n"
                + "\t" + risk + "\n"
                + "\tDescription: " + description + "\n"
                + "\tConfidence: " + confidence + "\n"
                + "\tSolution: " + solution + "\n"
                + "}";
    }

}
