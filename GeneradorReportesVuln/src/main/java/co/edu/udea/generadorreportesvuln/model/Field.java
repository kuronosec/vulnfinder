/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.udea.generadorreportesvuln.model;

import com.hp.gagawa.java.elements.Div;
import com.hp.gagawa.java.elements.Td;
import com.hp.gagawa.java.elements.Th;
import com.hp.gagawa.java.elements.Tr;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author camilosampedro
 */
public class Field implements HtmlElement {
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
    
    public void addAlert(FieldAlert newAlert){
        this.alerts.add(newAlert);
    }
    
    public List<Alert> getAlerts(){
        return this.alerts;
    }

    @Override
    public Tr toHtml() {
        Tr fieldRow = new Tr();
        Th td = new Th();
        td.setColspan("3");
        td.appendText("Field: " + fieldName + "\tMethod: " + fieldMethod);
        fieldRow.appendChild(td);
        alerts.stream().forEach((alert) -> {
            fieldRow.appendChild(alert.toHtml());
        });
        return fieldRow;
    }
    
}
