/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.udea.generadorreportesvuln.model;

import com.hp.gagawa.java.elements.Div;

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
    public Div toHtml() {
        Div alertDiv = new Div();
        return alertDiv;
    }

}
