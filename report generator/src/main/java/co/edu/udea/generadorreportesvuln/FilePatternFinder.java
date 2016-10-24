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

    protected static final String SQLMAPMETHODS = "POST|GET|HEAD|OPTIONS|PUT|DELETE|TRACE|CONNECT";
    protected static final String PATTERNSTRING = "^\\[(?:[0-9]{2}:){2}[0-9]{2}\\]\\s\\[(INFO|WARNING)\\]\\s(?!testing)(.*)$";
    //protected static final String URLPATTERNSTRING = "((http|ftp|https):\\/\\/|)([\\w_-]+(?:(?:\\.[\\w_-]+)+))([\\w.,@?^=%&:/~+#-]*[\\w@?^=%&/~+#-])?";
    protected static final String URLPATTERNSTRING = "((http:\\/\\/|ftp:\\/\\/|https:\\/\\/|)([\\w_-]+(?:(?:\\.[\\w_-]+)+)(:\\d+)?))(?:[\\w.,@?^=%&:/~+#-]*[\\w@?^=%&/~+#-])?";
    protected static final String PARAMETERPATTERNSTRING = "(?:Parameter: )(\\w*) \\((" + SQLMAPMETHODS + ")\\)";
    protected static final String TYPEPATTERNSTRING = "Type: (.*)";
    protected static final String TITLEPATTERNSTRING = "Title: (.*)";
    protected static final String PAYLOADPATTERNSTRING = "Payload: (.*)";

    protected static final Pattern pattern = Pattern.compile(PATTERNSTRING);
    protected static final Pattern urlPattern = Pattern.compile(URLPATTERNSTRING);
    protected static final Pattern parameterPattern = Pattern.compile(PARAMETERPATTERNSTRING);
    protected static final Pattern typePattern = Pattern.compile(TYPEPATTERNSTRING);
    protected static final Pattern titlePattern = Pattern.compile(TITLEPATTERNSTRING);
    protected static final Pattern payloadPattern = Pattern.compile(PAYLOADPATTERNSTRING);
}
