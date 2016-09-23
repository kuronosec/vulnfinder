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
    private String ruta;
    private List<Input> entradas = Collections.synchronizedList(new ArrayList<Input>());
    private boolean spidered;
    private List<int[]> enlaces = Collections.synchronizedList(new ArrayList<int[]>());

    public WebComponent(String ruta) {
        this.ruta = ruta;
        this.spidered = false;
    }
    
    public void setSpidered(){
        this.spidered = true;
    }

    public String getRuta() {
        return ruta;
    }

    public List<int[]> getEnlaces() {
        return enlaces;
    }
    
    public void insertarEnlaces(int[] enl){
        /*for(int[] i : enlaces){
            if(i[0] == enl[0] && i[1] == enl[1]){
                return;
            }
        }*/
        for(int[] i : enlaces){
            if(i[0] == enl[0]){
                return;
            }
        }
        enlaces.add(enl);
    }

    public List<Input> getEntradas() {
        return entradas;
    }
    
    
    
    public Input insertarEntrada(/*String tipo,*/ String nombre){
        Input i;
        for(Input e : entradas){
            if(e.getNombre().equals(nombre) /*&& e.getTipo().equals(tipo)*/){
                return e;
            }
        }
        entradas.add((i = new Input(/*tipo,*/ nombre)));
        return i;
    }

    public boolean isSpidered() {
        return spidered;
    }
    
    public static String extractPagina(String url){
        Matcher m = patPag.matcher(url);
        String res;
        m.matches();
        res = "/"+m.group(1).replaceAll("&", "&amp;");
        return res;
    }
    
    public static boolean revisaExtensiones(String pag){
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
		return "WebComponent [ruta=" + ruta + ", entradas=" + entradas.toString() + ", spidered=" + spidered + ", enlaces="
				+ enlaces.toString() + "]";
	}
    
    
}
