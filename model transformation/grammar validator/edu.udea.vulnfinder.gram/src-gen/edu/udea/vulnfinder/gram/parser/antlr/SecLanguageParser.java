/*
 * generated by Xtext
 */
package edu.udea.vulnfinder.gram.parser.antlr;

import com.google.inject.Inject;

import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import edu.udea.vulnfinder.gram.services.SecLanguageGrammarAccess;

public class SecLanguageParser extends org.eclipse.xtext.parser.antlr.AbstractAntlrParser {
	
	@Inject
	private SecLanguageGrammarAccess grammarAccess;
	
	@Override
	protected void setInitialHiddenTokens(XtextTokenStream tokenStream) {
		tokenStream.setInitialHiddenTokens("RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT");
	}
	
	@Override
	protected edu.udea.vulnfinder.gram.parser.antlr.internal.InternalSecLanguageParser createParser(XtextTokenStream stream) {
		return new edu.udea.vulnfinder.gram.parser.antlr.internal.InternalSecLanguageParser(stream, getGrammarAccess());
	}
	
	@Override 
	protected String getDefaultRuleName() {
		return "SecurityTest";
	}
	
	public SecLanguageGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}
	
	public void setGrammarAccess(SecLanguageGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
	
}
