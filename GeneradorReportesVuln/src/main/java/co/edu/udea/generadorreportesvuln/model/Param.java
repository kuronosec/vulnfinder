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
public class Param {
    private final String value;
    private final List<Integer> tests;

    public String getValue() {
        return value;
    }

    public List<Integer> getTests() {
        return tests;
    }

    public Param(String value, List<Integer> tests) {
        this.value = value;
        this.tests = tests;
    }
    
    
}
