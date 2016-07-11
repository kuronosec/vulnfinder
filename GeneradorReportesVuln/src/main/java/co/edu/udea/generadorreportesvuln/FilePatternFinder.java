/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.udea.generadorreportesvuln;

import java.util.regex.Pattern;

/**
 *
 * @author camilosampedro
 */
public class FilePatternFinder {
    protected final String patternString = "^\\[(?:[0-9]{2}:){2}[0-9]{2}\\]\\s\\[(INFO|WARNING)\\]\\s(?!testing)(.*)$";
    protected final String urlPatternString = "(http|ftp|https):\\/\\/([\\w_-]+(?:(?:\\.[\\w_-]+)+))([\\w.,@?^=%&:/~+#-]*[\\w@?^=%&/~+#-])?";
    protected final String parameterPatternString = "(?:Parameter: )(\\w*) \\((POST)\\)";
    protected final String typePatternString = "Type: (.*)";
    protected final String titlePatternString = "Title: (.*)";
    protected final String payloadPatternString = "Payload: (.*)";

    protected final Pattern pattern = Pattern.compile(patternString);
    protected final Pattern urlPattern = Pattern.compile(urlPatternString);
    protected final Pattern parameterPattern = Pattern.compile(parameterPatternString);
    protected final Pattern typePattern = Pattern.compile(typePatternString);
    protected final Pattern titlePattern = Pattern.compile(titlePatternString);
    protected final Pattern payloadPattern = Pattern.compile(payloadPatternString);
}
