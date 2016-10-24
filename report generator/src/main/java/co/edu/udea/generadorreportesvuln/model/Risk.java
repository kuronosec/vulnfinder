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
public class Risk {
    private int code;
    private String description;

    public Risk() {
    }

    public Risk(int code) {
        this.code = code;
    }

    public Risk(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return Integer.toString(code) + " ( " + description + " ) ";
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 41 * hash + this.code;
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
        final Risk other = (Risk) obj;
        return this.code == other.code;
    }
    
    
}
