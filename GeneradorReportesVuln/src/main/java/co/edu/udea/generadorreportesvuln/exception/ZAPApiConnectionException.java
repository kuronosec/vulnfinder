/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.udea.generadorreportesvuln.exception;

/**
 *
 * @author camilosampedro
 */
public class ZAPApiConnectionException extends Exception {

    /**
     * Creates a new instance of <code>ZAPApiConnectionException</code> without
     * detail message.
     */
    public ZAPApiConnectionException() {
    }

    /**
     * Constructs an instance of <code>ZAPApiConnectionException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public ZAPApiConnectionException(String msg) {
        super(msg);
    }
}
