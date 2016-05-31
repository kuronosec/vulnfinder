/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.udea.generadorreportesvuln.model;

import java.util.Map;

/**
 *
 * @author camilosampedro
 */
public class Page {
    private final String url;
    private final Map<String,Param> params;
    private final Map<String,Param> cookies;

    public String getUrl() {
        return url;
    }

    public Map<String, Param> getParams() {
        return params;
    }

    public Map<String, Param> getCookies() {
        return cookies;
    }

    public Page(String url, Map<String, Param> params, Map<String, Param> cookies) {
        this.url = url;
        this.params = params;
        this.cookies = cookies;
    }
    
}
