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
public abstract class Alert implements HtmlElement {
    private final Analyzer analyzer;

    public Alert(Analyzer analyzer) {
        this.analyzer = analyzer;
    }
    
    public Analyzer getAnalyzer() {
        return analyzer;
    }
}
