/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.udea.generadorreportesvuln.service;

import co.edu.udea.generadorreportesvuln.model.ConcreteSite;
import co.edu.udea.generadorreportesvuln.model.Site;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author camilosampedro
 */
public class SiteStore {

    private static final Map<String, Site> SITES = new HashMap<>();

    public static Site getSite(String url) {
        Site site = SITES.get(url);
        if (site == null) {
            site = new ConcreteSite(url);
            SITES.put(url, site);
        }
        return site;
    }

    public static List<Site> getAll() {
        List<Site> siteList = new ArrayList<>();
        // Filter empty sites
        SITES.entrySet().stream().filter((entry) -> (!entry.getValue().isEmpty())).forEach((entry) -> {
            siteList.add(entry.getValue());
        });
        return siteList;
    }
}
