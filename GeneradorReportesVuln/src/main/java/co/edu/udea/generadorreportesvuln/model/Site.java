/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.udea.generadorreportesvuln.model;
import java.util.List;

/**
 *
 * @author camilosampedro
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

    public void setCharset(String charset);
}
