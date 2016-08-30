package edu.udea.vulnfinder.escaneo.design.services;

import securityTest.WebComponent;
import edu.udea.vulnfinder.xmigenerator.generator.Main;


public class SecurityTestServices {
	public boolean filterWithExtensions(WebComponent wc){
		String[] exts = Main.getExcludedExtensionsInModel().split("\\|");
		for(String s : exts){
			if(wc.getPath().endsWith(s)){
				return false;
			}
		}
		return true;
	}
}
