/*
 * generated by Xtext
 */
package edu.udea.vulnfinder.gram;

/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class SecLanguageStandaloneSetup extends SecLanguageStandaloneSetupGenerated{

	public static void doSetup() {
		new SecLanguageStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}

