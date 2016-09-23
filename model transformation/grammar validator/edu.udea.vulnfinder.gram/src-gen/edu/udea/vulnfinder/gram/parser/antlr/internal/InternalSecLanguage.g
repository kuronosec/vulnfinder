/*
 * generated by Xtext
 */
grammar InternalSecLanguage;

options {
	superClass=AbstractInternalAntlrParser;
	
}

@lexer::header {
package edu.udea.vulnfinder.gram.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;
}

@parser::header {
package edu.udea.vulnfinder.gram.parser.antlr.internal; 

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import edu.udea.vulnfinder.gram.services.SecLanguageGrammarAccess;

}

@parser::members {

 	private SecLanguageGrammarAccess grammarAccess;
 	
    public InternalSecLanguageParser(TokenStream input, SecLanguageGrammarAccess grammarAccess) {
        this(input);
        this.grammarAccess = grammarAccess;
        registerRules(grammarAccess.getGrammar());
    }
    
    @Override
    protected String getFirstRuleName() {
    	return "SecurityTest";	
   	}
   	
   	@Override
   	protected SecLanguageGrammarAccess getGrammarAccess() {
   		return grammarAccess;
   	}
}

@rulecatch { 
    catch (RecognitionException re) { 
        recover(input,re); 
        appendSkippedTokens();
    } 
}




// Entry rule entryRuleSecurityTest
entryRuleSecurityTest returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getSecurityTestRule()); }
	 iv_ruleSecurityTest=ruleSecurityTest 
	 { $current=$iv_ruleSecurityTest.current; } 
	 EOF 
;

// Rule SecurityTest
ruleSecurityTest returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
((
    {
        $current = forceCreateModelElement(
            grammarAccess.getSecurityTestAccess().getTestAction_0(),
            $current);
    }
)	otherlv_1='(' 
    {
    	newLeafNode(otherlv_1, grammarAccess.getSecurityTestAccess().getLeftParenthesisKeyword_1());
    }
	otherlv_2='securityTest' 
    {
    	newLeafNode(otherlv_2, grammarAccess.getSecurityTestAccess().getSecurityTestKeyword_2());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getSecurityTestAccess().getIdEStringParserRuleCall_3_0()); 
	    }
		lv_id_3_0=ruleEString		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getSecurityTestRule());
	        }
       		set(
       			$current, 
       			"id",
        		lv_id_3_0, 
        		"edu.udea.vulnfinder.gram.SecLanguage.EString");
	        afterParserOrEnumRuleCall();
	    }

)
)(	otherlv_4='(' 
    {
    	newLeafNode(otherlv_4, grammarAccess.getSecurityTestAccess().getLeftParenthesisKeyword_4_0());
    }
	otherlv_5='toes' 
    {
    	newLeafNode(otherlv_5, grammarAccess.getSecurityTestAccess().getToesKeyword_4_1());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getSecurityTestAccess().getScopeTargetOfEvaluationParserRuleCall_4_2_0()); 
	    }
		lv_scope_6_0=ruleTargetOfEvaluation		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getSecurityTestRule());
	        }
       		set(
       			$current, 
       			"scope",
        		lv_scope_6_0, 
        		"edu.udea.vulnfinder.gram.SecLanguage.TargetOfEvaluation");
	        afterParserOrEnumRuleCall();
	    }

)
)	otherlv_7=')' 
    {
    	newLeafNode(otherlv_7, grammarAccess.getSecurityTestAccess().getRightParenthesisKeyword_4_3());
    }
)?(	otherlv_8='(' 
    {
    	newLeafNode(otherlv_8, grammarAccess.getSecurityTestAccess().getLeftParenthesisKeyword_5_0());
    }
	otherlv_9='attacks' 
    {
    	newLeafNode(otherlv_9, grammarAccess.getSecurityTestAccess().getAttacksKeyword_5_1());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getSecurityTestAccess().getPossibleAttacksAttackParserRuleCall_5_2_0()); 
	    }
		lv_possibleAttacks_10_0=ruleAttack		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getSecurityTestRule());
	        }
       		add(
       			$current, 
       			"possibleAttacks",
        		lv_possibleAttacks_10_0, 
        		"edu.udea.vulnfinder.gram.SecLanguage.Attack");
	        afterParserOrEnumRuleCall();
	    }

)
)+	otherlv_11=')' 
    {
    	newLeafNode(otherlv_11, grammarAccess.getSecurityTestAccess().getRightParenthesisKeyword_5_3());
    }
)?(	otherlv_12='(' 
    {
    	newLeafNode(otherlv_12, grammarAccess.getSecurityTestAccess().getLeftParenthesisKeyword_6_0());
    }
	otherlv_13='notes' 
    {
    	newLeafNode(otherlv_13, grammarAccess.getSecurityTestAccess().getNotesKeyword_6_1());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getSecurityTestAccess().getNoteNoteParserRuleCall_6_2_0()); 
	    }
		lv_note_14_0=ruleNote		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getSecurityTestRule());
	        }
       		set(
       			$current, 
       			"note",
        		lv_note_14_0, 
        		"edu.udea.vulnfinder.gram.SecLanguage.Note");
	        afterParserOrEnumRuleCall();
	    }

)
)	otherlv_15=')' 
    {
    	newLeafNode(otherlv_15, grammarAccess.getSecurityTestAccess().getRightParenthesisKeyword_6_3());
    }
)?	otherlv_16=')' 
    {
    	newLeafNode(otherlv_16, grammarAccess.getSecurityTestAccess().getRightParenthesisKeyword_7());
    }
)
;





// Entry rule entryRuleNote
entryRuleNote returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getNoteRule()); }
	 iv_ruleNote=ruleNote 
	 { $current=$iv_ruleNote.current; } 
	 EOF 
;

// Rule Note
ruleNote returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
((
    {
        $current = forceCreateModelElement(
            grammarAccess.getNoteAccess().getNoteAction_0(),
            $current);
    }
)(
(
		{ 
	        newCompositeNode(grammarAccess.getNoteAccess().getNoteTextEStringParserRuleCall_1_0()); 
	    }
		lv_noteText_1_0=ruleEString		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getNoteRule());
	        }
       		set(
       			$current, 
       			"noteText",
        		lv_noteText_1_0, 
        		"edu.udea.vulnfinder.gram.SecLanguage.EString");
	        afterParserOrEnumRuleCall();
	    }

)
))
;





// Entry rule entryRuleTargetOfEvaluation
entryRuleTargetOfEvaluation returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getTargetOfEvaluationRule()); }
	 iv_ruleTargetOfEvaluation=ruleTargetOfEvaluation 
	 { $current=$iv_ruleTargetOfEvaluation.current; } 
	 EOF 
;

// Rule TargetOfEvaluation
ruleTargetOfEvaluation returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
((
    {
        $current = forceCreateModelElement(
            grammarAccess.getTargetOfEvaluationAccess().getTargetOfEvaluationAction_0(),
            $current);
    }
)	otherlv_1='(' 
    {
    	newLeafNode(otherlv_1, grammarAccess.getTargetOfEvaluationAccess().getLeftParenthesisKeyword_1());
    }
(	otherlv_2='toe' 
    {
    	newLeafNode(otherlv_2, grammarAccess.getTargetOfEvaluationAccess().getToeKeyword_2_0());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getTargetOfEvaluationAccess().getDomainEStringParserRuleCall_2_1_0()); 
	    }
		lv_domain_3_0=ruleEString		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getTargetOfEvaluationRule());
	        }
       		set(
       			$current, 
       			"domain",
        		lv_domain_3_0, 
        		"edu.udea.vulnfinder.gram.SecLanguage.EString");
	        afterParserOrEnumRuleCall();
	    }

)
)(
(
		{ 
	        newCompositeNode(grammarAccess.getTargetOfEvaluationAccess().getComponentsWebComponentParserRuleCall_2_2_0()); 
	    }
		lv_components_4_0=ruleWebComponent		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getTargetOfEvaluationRule());
	        }
       		add(
       			$current, 
       			"components",
        		lv_components_4_0, 
        		"edu.udea.vulnfinder.gram.SecLanguage.WebComponent");
	        afterParserOrEnumRuleCall();
	    }

)
)*)	otherlv_5=')' 
    {
    	newLeafNode(otherlv_5, grammarAccess.getTargetOfEvaluationAccess().getRightParenthesisKeyword_3());
    }
)
;





// Entry rule entryRuleAttack
entryRuleAttack returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getAttackRule()); }
	 iv_ruleAttack=ruleAttack 
	 { $current=$iv_ruleAttack.current; } 
	 EOF 
;

// Rule Attack
ruleAttack returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
((
    {
        $current = forceCreateModelElement(
            grammarAccess.getAttackAccess().getAttackAction_0(),
            $current);
    }
)	otherlv_1='(' 
    {
    	newLeafNode(otherlv_1, grammarAccess.getAttackAccess().getLeftParenthesisKeyword_1());
    }
(	otherlv_2='attack' 
    {
    	newLeafNode(otherlv_2, grammarAccess.getAttackAccess().getAttackKeyword_2_0());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getAttackAccess().getNameEStringParserRuleCall_2_1_0()); 
	    }
		lv_name_3_0=ruleEString		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getAttackRule());
	        }
       		set(
       			$current, 
       			"name",
        		lv_name_3_0, 
        		"edu.udea.vulnfinder.gram.SecLanguage.EString");
	        afterParserOrEnumRuleCall();
	    }

)
)(	otherlv_4='{' 
    {
    	newLeafNode(otherlv_4, grammarAccess.getAttackAccess().getLeftCurlyBracketKeyword_2_2_0());
    }
	otherlv_5=':level' 
    {
    	newLeafNode(otherlv_5, grammarAccess.getAttackAccess().getLevelKeyword_2_2_1());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getAttackAccess().getSeverityESeverityEnumRuleCall_2_2_2_0()); 
	    }
		lv_severity_6_0=ruleESeverity		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getAttackRule());
	        }
       		set(
       			$current, 
       			"severity",
        		lv_severity_6_0, 
        		"edu.udea.vulnfinder.gram.SecLanguage.ESeverity");
	        afterParserOrEnumRuleCall();
	    }

)
)	otherlv_7='}' 
    {
    	newLeafNode(otherlv_7, grammarAccess.getAttackAccess().getRightCurlyBracketKeyword_2_2_3());
    }
)?)	otherlv_8=')' 
    {
    	newLeafNode(otherlv_8, grammarAccess.getAttackAccess().getRightParenthesisKeyword_3());
    }
)
;





// Entry rule entryRuleEString
entryRuleEString returns [String current=null] 
	:
	{ newCompositeNode(grammarAccess.getEStringRule()); } 
	 iv_ruleEString=ruleEString 
	 { $current=$iv_ruleEString.current.getText(); }  
	 EOF 
;

// Rule EString
ruleEString returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(    this_STRING_0=RULE_STRING    {
		$current.merge(this_STRING_0);
    }

    { 
    newLeafNode(this_STRING_0, grammarAccess.getEStringAccess().getSTRINGTerminalRuleCall_0()); 
    }

    |    this_ID_1=RULE_ID    {
		$current.merge(this_ID_1);
    }

    { 
    newLeafNode(this_ID_1, grammarAccess.getEStringAccess().getIDTerminalRuleCall_1()); 
    }
)
    ;





// Entry rule entryRuleWebComponent
entryRuleWebComponent returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getWebComponentRule()); }
	 iv_ruleWebComponent=ruleWebComponent 
	 { $current=$iv_ruleWebComponent.current; } 
	 EOF 
;

// Rule WebComponent
ruleWebComponent returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
((
    {
        $current = forceCreateModelElement(
            grammarAccess.getWebComponentAccess().getWebComponentAction_0(),
            $current);
    }
)	otherlv_1='(' 
    {
    	newLeafNode(otherlv_1, grammarAccess.getWebComponentAccess().getLeftParenthesisKeyword_1());
    }
(	otherlv_2='page' 
    {
    	newLeafNode(otherlv_2, grammarAccess.getWebComponentAccess().getPageKeyword_2_0());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getWebComponentAccess().getPathEStringParserRuleCall_2_1_0()); 
	    }
		lv_path_3_0=ruleEString		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getWebComponentRule());
	        }
       		set(
       			$current, 
       			"path",
        		lv_path_3_0, 
        		"edu.udea.vulnfinder.gram.SecLanguage.EString");
	        afterParserOrEnumRuleCall();
	    }

)
)(	otherlv_4='{' 
    {
    	newLeafNode(otherlv_4, grammarAccess.getWebComponentAccess().getLeftCurlyBracketKeyword_2_2_0());
    }
	otherlv_5=':target' 
    {
    	newLeafNode(otherlv_5, grammarAccess.getWebComponentAccess().getTargetKeyword_2_2_1());
    }
	otherlv_6='[' 
    {
    	newLeafNode(otherlv_6, grammarAccess.getWebComponentAccess().getLeftSquareBracketKeyword_2_2_2());
    }
(
    { 
        newCompositeNode(grammarAccess.getWebComponentAccess().getEStringParserRuleCall_2_2_3()); 
    }
ruleEString
    { 
        afterParserOrEnumRuleCall();
    }
)*	otherlv_8=']' 
    {
    	newLeafNode(otherlv_8, grammarAccess.getWebComponentAccess().getRightSquareBracketKeyword_2_2_4());
    }
	otherlv_9='}' 
    {
    	newLeafNode(otherlv_9, grammarAccess.getWebComponentAccess().getRightCurlyBracketKeyword_2_2_5());
    }
)?(
(
		{ 
	        newCompositeNode(grammarAccess.getWebComponentAccess().getInputsInputParserRuleCall_2_3_0()); 
	    }
		lv_inputs_10_0=ruleInput		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getWebComponentRule());
	        }
       		add(
       			$current, 
       			"inputs",
        		lv_inputs_10_0, 
        		"edu.udea.vulnfinder.gram.SecLanguage.Input");
	        afterParserOrEnumRuleCall();
	    }

)
)*)	otherlv_11=')' 
    {
    	newLeafNode(otherlv_11, grammarAccess.getWebComponentAccess().getRightParenthesisKeyword_3());
    }
)
;





// Entry rule entryRuleInput
entryRuleInput returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getInputRule()); }
	 iv_ruleInput=ruleInput 
	 { $current=$iv_ruleInput.current; } 
	 EOF 
;

// Rule Input
ruleInput returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
((
    {
        $current = forceCreateModelElement(
            grammarAccess.getInputAccess().getInputAction_0(),
            $current);
    }
)	otherlv_1='(' 
    {
    	newLeafNode(otherlv_1, grammarAccess.getInputAccess().getLeftParenthesisKeyword_1());
    }
(	otherlv_2='field' 
    {
    	newLeafNode(otherlv_2, grammarAccess.getInputAccess().getFieldKeyword_2_0());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getInputAccess().getNameEStringParserRuleCall_2_1_0()); 
	    }
		lv_name_3_0=ruleEString		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getInputRule());
	        }
       		set(
       			$current, 
       			"name",
        		lv_name_3_0, 
        		"edu.udea.vulnfinder.gram.SecLanguage.EString");
	        afterParserOrEnumRuleCall();
	    }

)
)(	otherlv_4='[' 
    {
    	newLeafNode(otherlv_4, grammarAccess.getInputAccess().getLeftSquareBracketKeyword_2_2_0());
    }
(
(
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getInputRule());
	        }
        }
		{ 
	        newCompositeNode(grammarAccess.getInputAccess().getAttacksAttackCrossReference_2_2_1_0()); 
	    }
		ruleEString		{ 
	        afterParserOrEnumRuleCall();
	    }

)
)*	otherlv_6=']' 
    {
    	newLeafNode(otherlv_6, grammarAccess.getInputAccess().getRightSquareBracketKeyword_2_2_2());
    }
)?)	otherlv_7=')' 
    {
    	newLeafNode(otherlv_7, grammarAccess.getInputAccess().getRightParenthesisKeyword_3());
    }
)
;





// Rule ESeverity
ruleESeverity returns [Enumerator current=null] 
    @init { enterRule(); }
    @after { leaveRule(); }:
((	enumLiteral_0='Low' 
	{
        $current = grammarAccess.getESeverityAccess().getLowEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
        newLeafNode(enumLiteral_0, grammarAccess.getESeverityAccess().getLowEnumLiteralDeclaration_0()); 
    }
)
    |(	enumLiteral_1='Medium' 
	{
        $current = grammarAccess.getESeverityAccess().getMediumEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
        newLeafNode(enumLiteral_1, grammarAccess.getESeverityAccess().getMediumEnumLiteralDeclaration_1()); 
    }
)
    |(	enumLiteral_2='High' 
	{
        $current = grammarAccess.getESeverityAccess().getHighEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
        newLeafNode(enumLiteral_2, grammarAccess.getESeverityAccess().getHighEnumLiteralDeclaration_2()); 
    }
));





RULE_ID : '^'? ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

RULE_INT : ('0'..'9')+;

RULE_STRING : ('"' ('\\' .|~(('\\'|'"')))* '"'|'\'' ('\\' .|~(('\\'|'\'')))* '\'');

RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;

RULE_WS : (' '|'\t'|'\r'|'\n')+;

RULE_ANY_OTHER : .;


