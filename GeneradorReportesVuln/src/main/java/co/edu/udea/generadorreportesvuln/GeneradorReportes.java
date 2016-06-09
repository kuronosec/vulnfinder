/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.udea.generadorreportesvuln;

import br.com.softplan.security.zap.api.ZapClient;
import br.com.softplan.security.zap.commons.ZapInfo;
import br.com.softplan.security.zap.zaproxy.clientapi.core.ClientApi;
import co.edu.udea.generadorreportesvuln.exception.ZAPApiConnectionException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.log4j.Logger;

/**
 *
 * @author camilosampedro
 */
public class GeneradorReportes {

    final static Logger LOGGER = Logger.getLogger(GeneradorReportes.class);
    private final static String ZAPURL = "http://zap/OTHER/core/other/xmlreport/";

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        ZAPReportGenerator zapReportGenerator = new ZAPReportGenerator(ZAPURL);
        try {
            zapReportGenerator.getReport();
        } catch (ZAPApiConnectionException ex) {
            LOGGER.error("Error generating ZAP Report",ex);
        }
        /*for (String archivo : args) {
            System.out.println(analizar(archivo));
            }*/
    }

    private static /*Report*/ void analizar(String archivo) throws IOException {
        String patron = "^\\[(?:[0-9]{2}:){2}[0-9]{2}\\]\\s\\[(?:INFO|WARNING)\\]\\s(?!testing)(.*)$";
        //Report reporte = new Report();
        Pattern r = Pattern.compile(patron);
        List<String> resultado = new ArrayList<>();
        List<String> parametros = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            StringBuilder sb = new StringBuilder();

            String line = br.readLine();
            Boolean inicio = false;
            while (line != null) {
                if ("---".equals(line)) {
                    inicio = !inicio;
                    line = br.readLine();
                    continue;
                }
                if (inicio) {
                    parametros.add(line);
                }
                Matcher m = r.matcher(line);
                if (m.find()) {
                    // System.out.println("Found value 1: " + m.group(0));
                    resultado.add(m.group(1));
                    // System.out.println(m.group(1));
                    // System.out.println("Found value 3: " + m.group(2));
                }
                line = br.readLine();
            }
        }
        /*reporte.setEventos(resultado);
        reporte.setParametros(parametros);
        return reporte;*/
        
    }

}
