/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.udea.generadorreportesvuln;

import co.edu.udea.generadorreportesvuln.model.Page;
import co.edu.udea.generadorreportesvuln.model.Param;
import co.edu.udea.generadorreportesvuln.model.Report;
import co.edu.udea.generadorreportesvuln.model.Vulnerability;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.apache.log4j.Logger;

/**
 *
 * @author camilosampedro
 */
public class ZAPReportGenerator {
    
    private final static Logger LOGGER = Logger.getLogger(ZAPReportGenerator.class);
    private final List<String> proxies;
    private final List<Page> pages;
    private Report report;
    
    public ZAPReportGenerator(){
        report = new Report();
        proxies = new ArrayList<>();
        pages = new ArrayList<>();
    }

    /**
     * Get the value of pages
     *
     * @return the value of pages
     */
    public List<Page> getPages() {
        return pages;
    }

    /**
     * Get the value of proxies
     *
     * @return the value of proxies
     */
    public List<String> getProxies() {
        return proxies;
    }

    public ZAPReportGenerator(List<String> proxies, List<Page> pages) {
        this.proxies = proxies;
        this.pages = pages;
    }
    
    public void addVulnerability(String name, String risk, String url, String param, String attackStr, String description, String solution){
        report.addVulnerability(new Vulnerability(risk,name,url,param,description,solution,attackStr));
    }
    
    private boolean isRelevant(String para, String uri, int tipoVuln){
        para = para.trim().split(" ")[0];
        LOGGER.debug(para);
        for(Page page: pages){
            if(uri.equals(page.getUrl())){
                for(Map.Entry<String,Param> param: page.getParams().entrySet()){
                    if(para.equals(param.getKey()) && param.getValue().getTests().contains(tipoVuln)){
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
