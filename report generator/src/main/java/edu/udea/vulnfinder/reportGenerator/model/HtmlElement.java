/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.udea.vulnfinder.reportGenerator.model;

import com.hp.gagawa.java.FertileNode;

/**
 * This interface is used to ensure the class can be converted to a HTML element
 * with <code>toHtml()</code> method.
 *
 * @author Camilo Sampedro <camilo.sampedro@udea.edu.co>
 */
public interface HtmlElement {

    /**
     * @return Some FertileNode with the information of the class.
     */
    public FertileNode toHtml();
}
