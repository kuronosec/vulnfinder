/*
 * Copyright (C) 2015 raven
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package edu.udea.vulnfinder.xmigenerator.generator.metaclasses;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author raven
 */
public class TargetOfEvaluation {
    private List<WebComponent> webComponents = Collections.synchronizedList(new ArrayList<WebComponent>());
    private static final Pattern patDom = Pattern.compile("(https?://[^/]+)/?.*");
    private String name;
    

    public TargetOfEvaluation(String name) {
        this.name = name;
    }

    public List<WebComponent> getWebComponents() {
        return webComponents;
    }
    
    

    public String getName() {
        return name;
    }
    
    public String getTOEOnly(){
    	String toe = name.substring(name.lastIndexOf('/')+1);
    	return toe;
    }
    
    public int addNewWebComponent(String pagPath){
        for(int i = 0; i < webComponents.size(); i++){
            if(webComponents.get(i).getPath().equals(pagPath)){
                return i;
            }
        }
        WebComponent nueva = new WebComponent(pagPath);
        webComponents.add(nueva);
        return webComponents.size()-1;
    }
    
    
    public static String extractDomain(String url){
        Matcher m = patDom.matcher(url);
        m.matches();
        return m.group(1);
    }
    
}