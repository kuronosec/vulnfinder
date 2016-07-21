/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.udea.generadorreportesvuln.model;

import com.hp.gagawa.java.elements.Td;
import com.hp.gagawa.java.elements.Tr;
import java.util.Objects;

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
        sameTd.appendText(getAnalyzer().toString());
        alertDiv.appendChild(sameTd);
        sameTd = new Td();
        if (type != null) {
            sameTd.appendText(type);
        } else {
            sameTd.appendText("N/A");
        }
        alertDiv.appendChild(sameTd);
        sameTd = new Td();
        sameTd.appendText(title);
        alertDiv.appendChild(sameTd);
        sameTd = new Td();
        if (payload != null) {
            sameTd.appendText(payload);
        } else {
            sameTd.appendText("N/A");
        }
        alertDiv.appendChild(sameTd);
        return alertDiv;
    }

    @Override
    public String toString() {
        return "FieldAlert{\n\t\t\tType: " + type + "\n\t\t\tTitle:" + title + "\n\t\t\tPayload:" + payload + "}";
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.title);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final FieldAlert other = (FieldAlert) obj;
        if (!Objects.equals(this.title, other.title)) {
            return false;
        }
        return true;
    }
    
    

}
