/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.udea.generadorreportesvuln.model;

import java.util.List;
import java.util.function.Consumer;

/**
 *
 * @author camilosampedro
 */
public class Report {
    private List<Vulnerability> vulnerabilities;

    public List<Vulnerability> getVulnerabilities() {
        return vulnerabilities;
    }
    
    public void addVulnerability(Vulnerability vulnerability){
        vulnerabilities.add(vulnerability);
    }
    
}
