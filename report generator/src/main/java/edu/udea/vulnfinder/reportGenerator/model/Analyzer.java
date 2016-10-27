/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.udea.vulnfinder.reportGenerator.model;

import java.util.Objects;

/**
 * Class that represent the Analyzers
 * @author Camilo Sampedro <camilo.sampedro@udea.edu.co>
 */
public class Analyzer {
    public static final Analyzer ZAP = new Analyzer("ZAP");
    public static final Analyzer SQLMAP = new Analyzer("SQLMap");
    
    private final String name;
    
    private Analyzer(String name){
        this.name = name;
    }

    @Override
    public int hashCode() {
        int hash = 7;
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
        final Analyzer other = (Analyzer) obj;
        return Objects.equals(this.name, other.name);
    }

    @Override
    public String toString() {
        return name + " Analyzer";
    }
}
