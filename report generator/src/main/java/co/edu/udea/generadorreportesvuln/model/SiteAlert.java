/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.udea.generadorreportesvuln.model;

import com.hp.gagawa.java.Node;
import com.hp.gagawa.java.elements.A;
import com.hp.gagawa.java.elements.Li;
import com.hp.gagawa.java.elements.Strong;
import com.hp.gagawa.java.elements.Ul;

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
    private static final int SHOWN_CHARACTERS = 20;

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
        //siteDiv.appendChild(table);
        Li alertItem = new Li();

        Strong alertStrong = new Strong();
        alertStrong.appendText(alert);
        alertItem.appendChild(alertStrong);
        Ul alertInformation = new Ul();
        alertInformation.appendChild(generateLi("Analyzer", getAnalyzer().toString()));

        if (risk != null) {
            alertInformation.appendChild(generateLi("Risk", risk.toString()));
        }

        if (!"".equals(description) && description != null) {
            alertInformation.appendChild(generateHiddenLi("Description", description));
        }

        if (!"".equals(confidence) && confidence != null) {
            alertInformation.appendChild(generateLi("Confidence", confidence));
        }

        if (!"".equals(solution) && solution != null) {
            alertInformation.appendChild(generateHiddenLi("Solution", solution));
        }
        alertItem.appendChild(alertInformation);

        return alertItem;
    }

    private Node generateLi(String title, String content) {
        Li li = new Li();
        Strong label = new Strong();
        label.appendText(title + ": ");
        li.appendChild(label);
        li.appendText(content);
        return li;
    }

    private Node generateHiddenLi(String title, String content) {
        Li li = new Li();
        Strong label = new Strong();
        label.appendText(title + ": ");
        li.appendChild(label);
        li.appendText(content.substring(0, Math.min(content.length(), SHOWN_CHARACTERS)) + "... ");
        A titleA = new A("Information");
        titleA.appendText("View more");
        titleA.setCSSClass("alert-title");
        titleA.setHref("#");
        // Payload popover
        titleA.setAttribute("data-toggle", "popover");
        if (content != null) {
            titleA.setAttribute("data-content", content);
        } else {
            titleA.setAttribute("data-content", "N/A");
        }
        titleA.setTitle(title);
        li.appendChild(titleA);
        return li;
    }
}
