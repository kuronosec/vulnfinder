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

import com.google.gson.internal.Excluder;

import edu.udea.vulnfinder.xmigenerator.generator.Main;

/**
 *
 * @author raven
 */
public class WebComponent {

    //private static final Pattern patPag = Pattern.compile("https?://[^/]+/?([^\\?]*)\\??.*");
	private static final Pattern patPag = Pattern.compile("https?:\\/\\/[^/]+\\/?(.*)");
    private String path;
    private List<Input> inputs = Collections.synchronizedList(new ArrayList<Input>());
    private boolean spidered;
    private List<int[]> links = Collections.synchronizedList(new ArrayList<int[]>());

    public WebComponent(String ruta) {
        this.path = ruta;
        this.spidered = false;
    }
    
    public void setSpidered(){
        this.spidered = true;
    }
    
    public void setSpidered(boolean s){
        this.spidered = s;
    }

    public String getPath() {
        return path;
    }

    public List<int[]> getLinks() {
        return links;
    }
    
    public void addLinks(int[] enl){
        /*for(int[] i : enlaces){
            if(i[0] == enl[0] && i[1] == enl[1]){
                return;
            }
        }*/
        for(int[] i : links){
            if(i[0] == enl[0]){
                return;
            }
        }
        links.add(enl);
    }

    public List<Input> getInputs() {
        return inputs;
    }
    
    
    
    public Input addInput(/*String tipo,*/ String nombre){
        Input i;
        for(Input e : inputs){
            if(e.getName().equals(nombre) /*&& e.getTipo().equals(tipo)*/){
                return e;
            }
        }
        inputs.add((i = new Input(/*tipo,*/ nombre)));
        return i;
    }

    public boolean isSpidered() {
        return spidered;
    }
    
    public static String extractWebComponent(String url){
        Matcher m = patPag.matcher(url);
        String res;
        m.matches();
        res = "/"+m.group(1).replaceAll("&", "&amp;");
        return res;
    }
    
    public static boolean checkExtensions(String pag){
    	if(pag == null){
    		return false;
    	}
    	
    	for(String s : Main.getExcludedExtensionsInSpidering().split("|")){
    		if(pag.endsWith(s)){
    			return false;
    		}
    	}
    	return true;
    }

	@Override
	public String toString() {
		return "WebComponent [ruta=" + path + ", entradas=" + inputs.toString() + ", spidered=" + spidered + ", enlaces="
				+ links.toString() + "]";
	}
    
    
}
