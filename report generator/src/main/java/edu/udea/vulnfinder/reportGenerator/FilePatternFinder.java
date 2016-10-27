/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.udea.vulnfinder.reportGenerator;

import java.util.regex.Pattern;

/**
 * Regular expressions that look for specific patterns on Strings.
 * They are used to look for information inside Strings.
 * @author Camilo Sampedro <camilo.sampedro@udea.edu.co>
 */
public class FilePatternFinder {
    protected static final String SQLMAP_METHODS = "POST|GET|HEAD|OPTIONS|PUT|DELETE|TRACE|CONNECT";
    protected static final String SQLMAP_LOG_MESSAGE_PATTERN_STRING = "^\\[(?:[0-9]{2}:){2}[0-9]{2}\\]\\s\\[(INFO|WARNING)\\]\\s(?!testing)(.*)$";
    //protected static final String URLPATTERNSTRING = "((http|ftp|https):\\/\\/|)([\\w_-]+(?:(?:\\.[\\w_-]+)+))([\\w.,@?^=%&:/~+#-]*[\\w@?^=%&/~+#-])?";
    protected static final String URL_PATTERN_STRING = "((http:\\/\\/|ftp:\\/\\/|https:\\/\\/|)([\\w_-]+(?:(?:\\.[\\w_-]+)+)(:\\d+)?))(?:[\\w.,@?^=%&:/~+#-]*[\\w@?^=%&/~+#-])?";
    protected static final String PARAMETER_PATTERN_STRING = "(?:Parameter: )(\\w*) \\((" + SQLMAP_METHODS + ")\\)";
    protected static final String TYPE_PATTERN_STRING = "Type: (.*)";
    protected static final String TITLE_PATTERN_STRING = "Title: (.*)";
    protected static final String PAYLOAD_PATTERN_STRING = "Payload: (.*)";

    protected static final Pattern SQLMAP_LOG_MESSAGE_PATTERN = Pattern.compile(SQLMAP_LOG_MESSAGE_PATTERN_STRING);
    protected static final Pattern URL_PATTERN = Pattern.compile(URL_PATTERN_STRING);
    protected static final Pattern PARAMETER_PATTERN = Pattern.compile(PARAMETER_PATTERN_STRING);
    protected static final Pattern TYPE_PATTERN = Pattern.compile(TYPE_PATTERN_STRING);
    protected static final Pattern TITLE_PATTERN = Pattern.compile(TITLE_PATTERN_STRING);
    protected static final Pattern PAYLOAD_PATTERN = Pattern.compile(PAYLOAD_PATTERN_STRING);
}
