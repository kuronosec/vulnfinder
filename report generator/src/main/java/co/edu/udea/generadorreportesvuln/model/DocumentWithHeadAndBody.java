/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.udea.generadorreportesvuln.model;

import com.hp.gagawa.java.elements.Body;
import com.hp.gagawa.java.elements.Head;
import com.hp.gagawa.java.elements.Html;

/**
 *
 * @author camilosampedro
 */
public class DocumentWithHeadAndBody {

    private final String doctype;
    private final Html html;
    public Head head;
    public Body body;

    public DocumentWithHeadAndBody(String spec) {
        doctype = spec;
        html = new Html();
        html.setXmlns("http://www.w3.org/1999/xhtml");
        head = new Head();
        body = new Body();
    }

    public String write() {
        StringBuilder b = new StringBuilder();
        b.append(doctype);
        html.appendChild(head);
        html.appendChild(body);
        b.append(html.write());
        return b.toString();
    }

    @Override
    public String toString() {
        return this.write();
    }

}
