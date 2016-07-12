/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.udea.generadorreportesvuln.model;

import com.hp.gagawa.java.elements.Div;
import com.hp.gagawa.java.elements.Td;
import com.hp.gagawa.java.elements.Tr;

/**
 *
 * @author camilosampedro
 */
public class FieldAlert extends Alert {
    private String type;
    private String title;
    private String payload;

    public FieldAlert(Analyzer analyzer) {
        super(analyzer);
    }

    

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPayload() {
        return payload;
    }

    public void setPayload(String payload) {
        this.payload = payload;
    }

    @Override
    public Tr toHtml() {
        Tr alertDiv = new Tr();
        Td sameTd = new Td();
        sameTd.appendText(type);
        alertDiv.appendChild(sameTd);
        sameTd = new Td();
        sameTd.appendText(title);
        alertDiv.appendChild(sameTd);
        sameTd = new Td();
        sameTd.appendText(payload);
        alertDiv.appendChild(sameTd);
        return alertDiv;
    }

}
