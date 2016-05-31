/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.udea.generadorreportesvuln;

import co.edu.udea.generadorreportesvuln.model.Report;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.log4j.Logger;

/**
 *
 * @author camilosampedro
 */
public class GeneradorReportes {
    final static Logger LOGGER = Logger.getLogger(GeneradorReportes.class);

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        for (String archivo : args) {
            System.out.println(analizar(archivo));
        }
    }

    private static Report analizar(String archivo) throws IOException {
        String patron = "^\\[(?:[0-9]{2}:){2}[0-9]{2}\\]\\s\\[(?:INFO|WARNING)\\]\\s(?!testing)(.*)$";
        Report reporte = new Report();
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
        reporte.setEventos(resultado);
        reporte.setParametros(parametros);
        return reporte;
    }

}
