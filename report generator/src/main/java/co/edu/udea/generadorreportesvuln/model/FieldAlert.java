/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.udea.generadorreportesvuln.model;

import com.hp.gagawa.java.elements.A;
import com.hp.gagawa.java.elements.Td;
import com.hp.gagawa.java.elements.Tr;
import java.util.Objects;

/**
 *
 * @author camilosampedro
 */
public class FieldAlert extends Alert {

    private String type;
    private String typeExplanation;
    private String exploit;

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
        return typeExplanation;
    }

    public void setTitle(String title) {
        this.typeExplanation = title;
    }

    public String getPayload() {
        return exploit;
    }

    public void setPayload(String payload) {
        this.exploit = payload;
    }

    @Override
    public Tr toHtml() {
        // Row
        Tr alertDiv = new Tr();
        
        // Analyzer column
        Td sameTd = new Td();
        sameTd.appendText(getAnalyzer().toString());
        alertDiv.appendChild(sameTd);
        
        // Type column
        sameTd = new Td();
        A titleA = new A(type);
        if (type != null) {
            titleA.appendText(type);
        } else {
            titleA.appendText("N/A");
        }
        
        titleA.setCSSClass("alert-title");
        titleA.setHref("#");
        // Payload popover
        titleA.setAttribute("data-toggle", "popover");
//        titleA.setAttribute("data-placement", "left");
//        titleA.setAttribute("data-trigger", "focus");
        if (typeExplanation != null) {
            titleA.setAttribute("data-content", typeExplanation);
        } else {
            titleA.setAttribute("data-content", "N/A");
        }
        titleA.setTitle("Type explanation");
        sameTd.appendChild(titleA);
        
        alertDiv.appendChild(sameTd);
        
        
        sameTd = new Td();
        if (exploit != null) {
            sameTd.appendText(exploit);
        } else {
            sameTd.appendText("N/A");
        }
        alertDiv.appendChild(sameTd);
        return alertDiv;
    }

    @Override
    public String toString() {
        return "FieldAlert{\n\t\t\tType: " + type + "\n\t\t\tTitle:" + typeExplanation + "\n\t\t\tPayload:" + exploit + "}";
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.typeExplanation);
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
        return Objects.equals(this.typeExplanation, other.typeExplanation);
    }
    
    

}
