/*
 * generated by Xtext
 */
package edu.udea.vulnfinder.gram;

import org.eclipse.xtext.junit4.IInjectorProvider;

import com.google.inject.Injector;

public class SecLanguageUiInjectorProvider implements IInjectorProvider {

	@Override
	public Injector getInjector() {
		return edu.udea.vulnfinder.gram.ui.internal.SecLanguageActivator.getInstance().getInjector("edu.udea.vulnfinder.gram.SecLanguage");
	}

}
