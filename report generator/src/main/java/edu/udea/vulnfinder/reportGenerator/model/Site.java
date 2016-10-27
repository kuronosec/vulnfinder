/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.udea.vulnfinder.reportGenerator.model;
import java.util.List;

/**
 *
 * @author Camilo Sampedro <camilo.sampedro@udea.edu.co>
 */
public interface Site extends HtmlElement {    
    public Field getField(String fieldName);
    
    public void addAlert(SiteAlert alert);
    
    public List<Alert> getAlerts();
    
    public void addAnalyzer(Analyzer analyzer);
    
    public List<Analyzer> getAnalyzers();

    public String getSite();

    public void setSite(String site);
    
    public boolean deleteCharset(String charset);

    public String getCharset(int i);

    public void addCharset(String charset);

    public boolean isEmpty();
}
