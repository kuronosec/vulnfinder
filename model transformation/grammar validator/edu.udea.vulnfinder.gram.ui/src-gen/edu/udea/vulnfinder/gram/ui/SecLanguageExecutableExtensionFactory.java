/*
 * generated by Xtext
 */
package edu.udea.vulnfinder.gram.ui;

import org.eclipse.xtext.ui.guice.AbstractGuiceAwareExecutableExtensionFactory;
import org.osgi.framework.Bundle;

import com.google.inject.Injector;

import edu.udea.vulnfinder.gram.ui.internal.SecLanguageActivator;

/**
 * This class was generated. Customizations should only happen in a newly
 * introduced subclass. 
 */
public class SecLanguageExecutableExtensionFactory extends AbstractGuiceAwareExecutableExtensionFactory {

	@Override
	protected Bundle getBundle() {
		return SecLanguageActivator.getInstance().getBundle();
	}
	
	@Override
	protected Injector getInjector() {
		return SecLanguageActivator.getInstance().getInjector(SecLanguageActivator.EDU_UDEA_VULNFINDER_GRAM_SECLANGUAGE);
	}
	
}
