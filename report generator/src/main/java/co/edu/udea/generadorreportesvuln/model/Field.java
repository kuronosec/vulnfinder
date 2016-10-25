/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.udea.generadorreportesvuln.model;

import co.edu.udea.generadorreportesvuln.service.Counter;
import com.hp.gagawa.java.elements.A;
import com.hp.gagawa.java.elements.Div;
import com.hp.gagawa.java.elements.H3;
import com.hp.gagawa.java.elements.Table;
import com.hp.gagawa.java.elements.Tbody;
import com.hp.gagawa.java.elements.Th;
import com.hp.gagawa.java.elements.Thead;
import com.hp.gagawa.java.elements.Tr;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author camilosampedro
 */
public class Field implements HtmlElement {

    private String uri;
    private String fieldName;
    private String fieldMethod;
    private final List<Alert> alerts = new ArrayList<>();

    public Field(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getFieldMethod() {
        return fieldMethod;
    }

    public void setFieldMethod(String fieldMethod) {
        this.fieldMethod = fieldMethod;
    }

    public void addAlert(FieldAlert newAlert) {
        if (!alerts.contains(newAlert)) {
            this.alerts.add(newAlert);
        }
    }

    public List<Alert> getAlerts() {
        return this.alerts;
    }

    @Override
    public Div toHtml() {
        Div fieldAlertDiv = new Div();
        String id = fieldName + Counter.getActual();
        Div fieldPanel = new Div();
        fieldPanel.setCSSClass("panel panel-default");

        Div fieldPanelHeading = new Div();
        fieldPanelHeading.setCSSClass("panel-heading field-title");
        fieldPanelHeading.setAttribute("role", "tab");
        fieldPanelHeading.setId("heading" + id);

        // TODO: Add field's uri in this part (If it is not null)
        
        A toggle = new A();
        toggle.setAttribute("data-toggle", "collapse");
        toggle.appendText(fieldName);
        toggle.setHref("#body" + id);
        toggle.setAttribute("aria-controls", "body" + id);
        
        fieldPanelHeading.appendChild(toggle);
        fieldPanel.appendChild(fieldPanelHeading);

        if (!alerts.isEmpty()) {

            Div collapsed = new Div();
            collapsed.setId("body" + id);
            collapsed.setCSSClass("panel-collapse collapse in");
            collapsed.setAttribute("role", "tabpanel");
            collapsed.setAttribute("aria-labelledby", "heading" + id);
            Table table = new Table();
            table.setCSSClass("table table-bordered");
            Thead thead = new Thead();
            thead.setCSSClass("thead-default");
            Tr tr = new Tr();
            //Type title payload
            Th analyzerTh = new Th();
            analyzerTh.appendText("Analyzer");
            tr.appendChild(analyzerTh);
            Th typeTh = new Th();
            typeTh.appendText("Type");
            tr.appendChild(typeTh);
//            Th titleTh = new Th();
//            titleTh.appendText("Title");
//            tr.appendChild(titleTh);
            Th exploitTh = new Th();
            exploitTh.appendText("Exploit");
            tr.appendChild(exploitTh);
            thead.appendChild(tr);
            table.appendChild(thead);

            Tbody tbody = new Tbody();

            table.appendChild(tbody);
            alerts.stream().forEach((alert) -> {
                tbody.appendChild(alert.toHtml());
            });
            collapsed.appendChild(table);
            fieldPanel.appendChild(collapsed);
        }
        fieldAlertDiv.appendChild(fieldPanel);
        return fieldAlertDiv;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("\tField:").append(fieldName).append(" Method:").append(fieldMethod).append("\n");
        alerts.stream().forEach((alert) -> {
            builder.append("\t\t").append(alert.toString()).append("\n");
        });
        return builder.toString();
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    
}
