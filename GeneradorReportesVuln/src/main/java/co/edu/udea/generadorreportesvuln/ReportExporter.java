/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.udea.generadorreportesvuln;

import co.edu.udea.generadorreportesvuln.model.Site;
import java.util.List;
import org.apache.pdfbox.pdmodel.PDDocument;


/**
 *
 * @author camilosampedro
 */
public class ReportExporter {
    public static void createPDF(List<Site> sites, String fileName){
        PDDocument document = new PDDocument();
    }
}
