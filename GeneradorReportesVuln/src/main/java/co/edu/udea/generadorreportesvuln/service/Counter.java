/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.udea.generadorreportesvuln.service;

/**
 *
 * @author camilosampedro
 */
public class Counter {

    private static int x = 0;

    public static int getActual() {
        x = x + 1;
        return x;
    }
}
