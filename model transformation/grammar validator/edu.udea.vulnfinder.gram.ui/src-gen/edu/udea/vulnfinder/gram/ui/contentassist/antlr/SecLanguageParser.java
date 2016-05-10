/*
 * generated by Xtext
 */
package edu.udea.vulnfinder.gram.ui.contentassist.antlr;

import java.util.Collection;
import java.util.Map;
import java.util.HashMap;

import org.antlr.runtime.RecognitionException;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.ui.editor.contentassist.antlr.AbstractContentAssistParser;
import org.eclipse.xtext.ui.editor.contentassist.antlr.FollowElement;
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;

import com.google.inject.Inject;

import edu.udea.vulnfinder.gram.services.SecLanguageGrammarAccess;

public class SecLanguageParser extends AbstractContentAssistParser {
	
	@Inject
	private SecLanguageGrammarAccess grammarAccess;
	
	private Map<AbstractElement, String> nameMappings;
	
	@Override
	protected edu.udea.vulnfinder.gram.ui.contentassist.antlr.internal.InternalSecLanguageParser createParser() {
		edu.udea.vulnfinder.gram.ui.contentassist.antlr.internal.InternalSecLanguageParser result = new edu.udea.vulnfinder.gram.ui.contentassist.antlr.internal.InternalSecLanguageParser(null);
		result.setGrammarAccess(grammarAccess);
		return result;
	}
	
	@Override
	protected String getRuleName(AbstractElement element) {
		if (nameMappings == null) {
			nameMappings = new HashMap<AbstractElement, String>() {
				private static final long serialVersionUID = 1L;
				{
					put(grammarAccess.getEStringAccess().getAlternatives(), "rule__EString__Alternatives");
					put(grammarAccess.getESeverityAccess().getAlternatives(), "rule__ESeverity__Alternatives");
					put(grammarAccess.getEAttackMethodAccess().getAlternatives(), "rule__EAttackMethod__Alternatives");
					put(grammarAccess.getSecurityTestAccess().getGroup(), "rule__SecurityTest__Group__0");
					put(grammarAccess.getSecurityTestAccess().getGroup_4(), "rule__SecurityTest__Group_4__0");
					put(grammarAccess.getSecurityTestAccess().getGroup_5(), "rule__SecurityTest__Group_5__0");
					put(grammarAccess.getTargetOfEvaluationAccess().getGroup(), "rule__TargetOfEvaluation__Group__0");
					put(grammarAccess.getTargetOfEvaluationAccess().getGroup_2(), "rule__TargetOfEvaluation__Group_2__0");
					put(grammarAccess.getAttackAccess().getGroup(), "rule__Attack__Group__0");
					put(grammarAccess.getAttackAccess().getGroup_2(), "rule__Attack__Group_2__0");
					put(grammarAccess.getAttackAccess().getGroup_2_2(), "rule__Attack__Group_2_2__0");
					put(grammarAccess.getWebComponentAccess().getGroup(), "rule__WebComponent__Group__0");
					put(grammarAccess.getWebComponentAccess().getGroup_2(), "rule__WebComponent__Group_2__0");
					put(grammarAccess.getWebComponentAccess().getGroup_2_2(), "rule__WebComponent__Group_2_2__0");
					put(grammarAccess.getInputAccess().getGroup(), "rule__Input__Group__0");
					put(grammarAccess.getInputAccess().getGroup_2(), "rule__Input__Group_2__0");
					put(grammarAccess.getInputAccess().getGroup_2_2(), "rule__Input__Group_2_2__0");
					put(grammarAccess.getSecurityTestAccess().getIdAssignment_3(), "rule__SecurityTest__IdAssignment_3");
					put(grammarAccess.getSecurityTestAccess().getScopeAssignment_4_2(), "rule__SecurityTest__ScopeAssignment_4_2");
					put(grammarAccess.getSecurityTestAccess().getPossibleAttacksAssignment_5_2(), "rule__SecurityTest__PossibleAttacksAssignment_5_2");
					put(grammarAccess.getTargetOfEvaluationAccess().getDomainAssignment_2_1(), "rule__TargetOfEvaluation__DomainAssignment_2_1");
					put(grammarAccess.getTargetOfEvaluationAccess().getComponentsAssignment_2_2(), "rule__TargetOfEvaluation__ComponentsAssignment_2_2");
					put(grammarAccess.getAttackAccess().getNameAssignment_2_1(), "rule__Attack__NameAssignment_2_1");
					put(grammarAccess.getAttackAccess().getSeverityAssignment_2_2_2(), "rule__Attack__SeverityAssignment_2_2_2");
					put(grammarAccess.getWebComponentAccess().getPathAssignment_2_1(), "rule__WebComponent__PathAssignment_2_1");
					put(grammarAccess.getWebComponentAccess().getInputsAssignment_2_3(), "rule__WebComponent__InputsAssignment_2_3");
					put(grammarAccess.getInputAccess().getNameAssignment_2_1(), "rule__Input__NameAssignment_2_1");
				}
			};
		}
		return nameMappings.get(element);
	}
	
	@Override
	protected Collection<FollowElement> getFollowElements(AbstractInternalContentAssistParser parser) {
		try {
			edu.udea.vulnfinder.gram.ui.contentassist.antlr.internal.InternalSecLanguageParser typedParser = (edu.udea.vulnfinder.gram.ui.contentassist.antlr.internal.InternalSecLanguageParser) parser;
			typedParser.entryRuleSecurityTest();
			return typedParser.getFollowElements();
		} catch(RecognitionException ex) {
			throw new RuntimeException(ex);
		}		
	}
	
	@Override
	protected String[] getInitialHiddenTokens() {
		return new String[] { "RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT" };
	}
	
	public SecLanguageGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}
	
	public void setGrammarAccess(SecLanguageGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
}
