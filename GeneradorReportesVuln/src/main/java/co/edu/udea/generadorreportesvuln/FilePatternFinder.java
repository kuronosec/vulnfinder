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
    protected static final String PATTERNSTRING = "^\\[(?:[0-9]{2}:){2}[0-9]{2}\\]\\s\\[(INFO|WARNING)\\]\\s(?!testing)(.*)$";
    protected static final String URLPATTERNSTRING = "(http|ftp|https):\\/\\/([\\w_-]+(?:(?:\\.[\\w_-]+)+))([\\w.,@?^=%&:/~+#-]*[\\w@?^=%&/~+#-])?";
    protected static final String PARAMETERPATTERNSTRING = "(?:Parameter: )(\\w*) \\((POST)\\)";
    protected static final String TYPEPATTERNSTRING = "Type: (.*)";
    protected static final String TITLEPATTERNSTRING = "Title: (.*)";
    protected static final String PAYLOADPATTERNSTRING = "Payload: (.*)";

    protected final Pattern pattern = Pattern.compile(PATTERNSTRING);
    protected final Pattern urlPattern = Pattern.compile(URLPATTERNSTRING);
    protected final Pattern parameterPattern = Pattern.compile(PARAMETERPATTERNSTRING);
    protected final Pattern typePattern = Pattern.compile(TYPEPATTERNSTRING);
    protected final Pattern titlePattern = Pattern.compile(TITLEPATTERNSTRING);
    protected final Pattern payloadPattern = Pattern.compile(PAYLOADPATTERNSTRING);
}
