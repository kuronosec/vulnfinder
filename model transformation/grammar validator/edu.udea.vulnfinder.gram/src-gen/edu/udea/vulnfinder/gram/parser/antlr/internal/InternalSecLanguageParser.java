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



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalSecLanguageParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_STRING", "RULE_ID", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'('", "'securityTest'", "'toes'", "')'", "'attacks'", "'toe'", "'attack'", "'{'", "':level'", "'}'", "'page'", "':target'", "'['", "']'", "'field'", "'Low'", "'Medium'", "'High'", "'SQLInjection'", "'XSS'", "'Authentication'", "'Authorization'", "'PrivilegeScalation'"
    };
    public static final int RULE_STRING=4;
    public static final int RULE_SL_COMMENT=8;
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__11=11;
    public static final int T__33=33;
    public static final int T__12=12;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int EOF=-1;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int RULE_ID=5;
    public static final int RULE_WS=9;
    public static final int RULE_ANY_OTHER=10;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int RULE_INT=6;
    public static final int T__29=29;
    public static final int T__22=22;
    public static final int RULE_ML_COMMENT=7;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__25=25;
    public static final int T__20=20;
    public static final int T__21=21;

    // delegates
    // delegators


        public InternalSecLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalSecLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalSecLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "InternalSecLanguage.g"; }



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



    // $ANTLR start "entryRuleSecurityTest"
    // InternalSecLanguage.g:68:1: entryRuleSecurityTest returns [EObject current=null] : iv_ruleSecurityTest= ruleSecurityTest EOF ;
    public final EObject entryRuleSecurityTest() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSecurityTest = null;


        try {
            // InternalSecLanguage.g:69:2: (iv_ruleSecurityTest= ruleSecurityTest EOF )
            // InternalSecLanguage.g:70:2: iv_ruleSecurityTest= ruleSecurityTest EOF
            {
             newCompositeNode(grammarAccess.getSecurityTestRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleSecurityTest=ruleSecurityTest();

            state._fsp--;

             current =iv_ruleSecurityTest; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSecurityTest"


    // $ANTLR start "ruleSecurityTest"
    // InternalSecLanguage.g:77:1: ruleSecurityTest returns [EObject current=null] : ( () otherlv_1= '(' otherlv_2= 'securityTest' ( (lv_id_3_0= ruleEString ) ) (otherlv_4= '(' otherlv_5= 'toes' ( (lv_scope_6_0= ruleTargetOfEvaluation ) ) otherlv_7= ')' )? (otherlv_8= '(' otherlv_9= 'attacks' ( (lv_possibleAttacks_10_0= ruleAttack ) )+ otherlv_11= ')' )? otherlv_12= ')' ) ;
    public final EObject ruleSecurityTest() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        Token otherlv_12=null;
        AntlrDatatypeRuleToken lv_id_3_0 = null;

        EObject lv_scope_6_0 = null;

        EObject lv_possibleAttacks_10_0 = null;


         enterRule(); 
            
        try {
            // InternalSecLanguage.g:80:28: ( ( () otherlv_1= '(' otherlv_2= 'securityTest' ( (lv_id_3_0= ruleEString ) ) (otherlv_4= '(' otherlv_5= 'toes' ( (lv_scope_6_0= ruleTargetOfEvaluation ) ) otherlv_7= ')' )? (otherlv_8= '(' otherlv_9= 'attacks' ( (lv_possibleAttacks_10_0= ruleAttack ) )+ otherlv_11= ')' )? otherlv_12= ')' ) )
            // InternalSecLanguage.g:81:1: ( () otherlv_1= '(' otherlv_2= 'securityTest' ( (lv_id_3_0= ruleEString ) ) (otherlv_4= '(' otherlv_5= 'toes' ( (lv_scope_6_0= ruleTargetOfEvaluation ) ) otherlv_7= ')' )? (otherlv_8= '(' otherlv_9= 'attacks' ( (lv_possibleAttacks_10_0= ruleAttack ) )+ otherlv_11= ')' )? otherlv_12= ')' )
            {
            // InternalSecLanguage.g:81:1: ( () otherlv_1= '(' otherlv_2= 'securityTest' ( (lv_id_3_0= ruleEString ) ) (otherlv_4= '(' otherlv_5= 'toes' ( (lv_scope_6_0= ruleTargetOfEvaluation ) ) otherlv_7= ')' )? (otherlv_8= '(' otherlv_9= 'attacks' ( (lv_possibleAttacks_10_0= ruleAttack ) )+ otherlv_11= ')' )? otherlv_12= ')' )
            // InternalSecLanguage.g:81:2: () otherlv_1= '(' otherlv_2= 'securityTest' ( (lv_id_3_0= ruleEString ) ) (otherlv_4= '(' otherlv_5= 'toes' ( (lv_scope_6_0= ruleTargetOfEvaluation ) ) otherlv_7= ')' )? (otherlv_8= '(' otherlv_9= 'attacks' ( (lv_possibleAttacks_10_0= ruleAttack ) )+ otherlv_11= ')' )? otherlv_12= ')'
            {
            // InternalSecLanguage.g:81:2: ()
            // InternalSecLanguage.g:82:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getSecurityTestAccess().getTestAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,11,FollowSets000.FOLLOW_3); 

                	newLeafNode(otherlv_1, grammarAccess.getSecurityTestAccess().getLeftParenthesisKeyword_1());
                
            otherlv_2=(Token)match(input,12,FollowSets000.FOLLOW_4); 

                	newLeafNode(otherlv_2, grammarAccess.getSecurityTestAccess().getSecurityTestKeyword_2());
                
            // InternalSecLanguage.g:95:1: ( (lv_id_3_0= ruleEString ) )
            // InternalSecLanguage.g:96:1: (lv_id_3_0= ruleEString )
            {
            // InternalSecLanguage.g:96:1: (lv_id_3_0= ruleEString )
            // InternalSecLanguage.g:97:3: lv_id_3_0= ruleEString
            {
             
            	        newCompositeNode(grammarAccess.getSecurityTestAccess().getIdEStringParserRuleCall_3_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_5);
            lv_id_3_0=ruleEString();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getSecurityTestRule());
            	        }
                   		set(
                   			current, 
                   			"id",
                    		lv_id_3_0, 
                    		"edu.udea.vulnfinder.gram.SecLanguage.EString");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // InternalSecLanguage.g:113:2: (otherlv_4= '(' otherlv_5= 'toes' ( (lv_scope_6_0= ruleTargetOfEvaluation ) ) otherlv_7= ')' )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==11) ) {
                int LA1_1 = input.LA(2);

                if ( (LA1_1==13) ) {
                    alt1=1;
                }
            }
            switch (alt1) {
                case 1 :
                    // InternalSecLanguage.g:113:4: otherlv_4= '(' otherlv_5= 'toes' ( (lv_scope_6_0= ruleTargetOfEvaluation ) ) otherlv_7= ')'
                    {
                    otherlv_4=(Token)match(input,11,FollowSets000.FOLLOW_6); 

                        	newLeafNode(otherlv_4, grammarAccess.getSecurityTestAccess().getLeftParenthesisKeyword_4_0());
                        
                    otherlv_5=(Token)match(input,13,FollowSets000.FOLLOW_7); 

                        	newLeafNode(otherlv_5, grammarAccess.getSecurityTestAccess().getToesKeyword_4_1());
                        
                    // InternalSecLanguage.g:121:1: ( (lv_scope_6_0= ruleTargetOfEvaluation ) )
                    // InternalSecLanguage.g:122:1: (lv_scope_6_0= ruleTargetOfEvaluation )
                    {
                    // InternalSecLanguage.g:122:1: (lv_scope_6_0= ruleTargetOfEvaluation )
                    // InternalSecLanguage.g:123:3: lv_scope_6_0= ruleTargetOfEvaluation
                    {
                     
                    	        newCompositeNode(grammarAccess.getSecurityTestAccess().getScopeTargetOfEvaluationParserRuleCall_4_2_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_8);
                    lv_scope_6_0=ruleTargetOfEvaluation();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getSecurityTestRule());
                    	        }
                           		set(
                           			current, 
                           			"scope",
                            		lv_scope_6_0, 
                            		"edu.udea.vulnfinder.gram.SecLanguage.TargetOfEvaluation");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    otherlv_7=(Token)match(input,14,FollowSets000.FOLLOW_5); 

                        	newLeafNode(otherlv_7, grammarAccess.getSecurityTestAccess().getRightParenthesisKeyword_4_3());
                        

                    }
                    break;

            }

            // InternalSecLanguage.g:143:3: (otherlv_8= '(' otherlv_9= 'attacks' ( (lv_possibleAttacks_10_0= ruleAttack ) )+ otherlv_11= ')' )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==11) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // InternalSecLanguage.g:143:5: otherlv_8= '(' otherlv_9= 'attacks' ( (lv_possibleAttacks_10_0= ruleAttack ) )+ otherlv_11= ')'
                    {
                    otherlv_8=(Token)match(input,11,FollowSets000.FOLLOW_9); 

                        	newLeafNode(otherlv_8, grammarAccess.getSecurityTestAccess().getLeftParenthesisKeyword_5_0());
                        
                    otherlv_9=(Token)match(input,15,FollowSets000.FOLLOW_7); 

                        	newLeafNode(otherlv_9, grammarAccess.getSecurityTestAccess().getAttacksKeyword_5_1());
                        
                    // InternalSecLanguage.g:151:1: ( (lv_possibleAttacks_10_0= ruleAttack ) )+
                    int cnt2=0;
                    loop2:
                    do {
                        int alt2=2;
                        int LA2_0 = input.LA(1);

                        if ( (LA2_0==11) ) {
                            alt2=1;
                        }


                        switch (alt2) {
                    	case 1 :
                    	    // InternalSecLanguage.g:152:1: (lv_possibleAttacks_10_0= ruleAttack )
                    	    {
                    	    // InternalSecLanguage.g:152:1: (lv_possibleAttacks_10_0= ruleAttack )
                    	    // InternalSecLanguage.g:153:3: lv_possibleAttacks_10_0= ruleAttack
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getSecurityTestAccess().getPossibleAttacksAttackParserRuleCall_5_2_0()); 
                    	    	    
                    	    pushFollow(FollowSets000.FOLLOW_5);
                    	    lv_possibleAttacks_10_0=ruleAttack();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getSecurityTestRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"possibleAttacks",
                    	            		lv_possibleAttacks_10_0, 
                    	            		"edu.udea.vulnfinder.gram.SecLanguage.Attack");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt2 >= 1 ) break loop2;
                                EarlyExitException eee =
                                    new EarlyExitException(2, input);
                                throw eee;
                        }
                        cnt2++;
                    } while (true);

                    otherlv_11=(Token)match(input,14,FollowSets000.FOLLOW_8); 

                        	newLeafNode(otherlv_11, grammarAccess.getSecurityTestAccess().getRightParenthesisKeyword_5_3());
                        

                    }
                    break;

            }

            otherlv_12=(Token)match(input,14,FollowSets000.FOLLOW_2); 

                	newLeafNode(otherlv_12, grammarAccess.getSecurityTestAccess().getRightParenthesisKeyword_6());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSecurityTest"


    // $ANTLR start "entryRuleTargetOfEvaluation"
    // InternalSecLanguage.g:185:1: entryRuleTargetOfEvaluation returns [EObject current=null] : iv_ruleTargetOfEvaluation= ruleTargetOfEvaluation EOF ;
    public final EObject entryRuleTargetOfEvaluation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTargetOfEvaluation = null;


        try {
            // InternalSecLanguage.g:186:2: (iv_ruleTargetOfEvaluation= ruleTargetOfEvaluation EOF )
            // InternalSecLanguage.g:187:2: iv_ruleTargetOfEvaluation= ruleTargetOfEvaluation EOF
            {
             newCompositeNode(grammarAccess.getTargetOfEvaluationRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleTargetOfEvaluation=ruleTargetOfEvaluation();

            state._fsp--;

             current =iv_ruleTargetOfEvaluation; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTargetOfEvaluation"


    // $ANTLR start "ruleTargetOfEvaluation"
    // InternalSecLanguage.g:194:1: ruleTargetOfEvaluation returns [EObject current=null] : ( () otherlv_1= '(' (otherlv_2= 'toe' ( (lv_domain_3_0= ruleEString ) ) ( (lv_components_4_0= ruleWebComponent ) )* ) otherlv_5= ')' ) ;
    public final EObject ruleTargetOfEvaluation() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_5=null;
        AntlrDatatypeRuleToken lv_domain_3_0 = null;

        EObject lv_components_4_0 = null;


         enterRule(); 
            
        try {
            // InternalSecLanguage.g:197:28: ( ( () otherlv_1= '(' (otherlv_2= 'toe' ( (lv_domain_3_0= ruleEString ) ) ( (lv_components_4_0= ruleWebComponent ) )* ) otherlv_5= ')' ) )
            // InternalSecLanguage.g:198:1: ( () otherlv_1= '(' (otherlv_2= 'toe' ( (lv_domain_3_0= ruleEString ) ) ( (lv_components_4_0= ruleWebComponent ) )* ) otherlv_5= ')' )
            {
            // InternalSecLanguage.g:198:1: ( () otherlv_1= '(' (otherlv_2= 'toe' ( (lv_domain_3_0= ruleEString ) ) ( (lv_components_4_0= ruleWebComponent ) )* ) otherlv_5= ')' )
            // InternalSecLanguage.g:198:2: () otherlv_1= '(' (otherlv_2= 'toe' ( (lv_domain_3_0= ruleEString ) ) ( (lv_components_4_0= ruleWebComponent ) )* ) otherlv_5= ')'
            {
            // InternalSecLanguage.g:198:2: ()
            // InternalSecLanguage.g:199:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getTargetOfEvaluationAccess().getTargetOfEvaluationAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,11,FollowSets000.FOLLOW_10); 

                	newLeafNode(otherlv_1, grammarAccess.getTargetOfEvaluationAccess().getLeftParenthesisKeyword_1());
                
            // InternalSecLanguage.g:208:1: (otherlv_2= 'toe' ( (lv_domain_3_0= ruleEString ) ) ( (lv_components_4_0= ruleWebComponent ) )* )
            // InternalSecLanguage.g:208:3: otherlv_2= 'toe' ( (lv_domain_3_0= ruleEString ) ) ( (lv_components_4_0= ruleWebComponent ) )*
            {
            otherlv_2=(Token)match(input,16,FollowSets000.FOLLOW_4); 

                	newLeafNode(otherlv_2, grammarAccess.getTargetOfEvaluationAccess().getToeKeyword_2_0());
                
            // InternalSecLanguage.g:212:1: ( (lv_domain_3_0= ruleEString ) )
            // InternalSecLanguage.g:213:1: (lv_domain_3_0= ruleEString )
            {
            // InternalSecLanguage.g:213:1: (lv_domain_3_0= ruleEString )
            // InternalSecLanguage.g:214:3: lv_domain_3_0= ruleEString
            {
             
            	        newCompositeNode(grammarAccess.getTargetOfEvaluationAccess().getDomainEStringParserRuleCall_2_1_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_5);
            lv_domain_3_0=ruleEString();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getTargetOfEvaluationRule());
            	        }
                   		set(
                   			current, 
                   			"domain",
                    		lv_domain_3_0, 
                    		"edu.udea.vulnfinder.gram.SecLanguage.EString");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // InternalSecLanguage.g:230:2: ( (lv_components_4_0= ruleWebComponent ) )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==11) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // InternalSecLanguage.g:231:1: (lv_components_4_0= ruleWebComponent )
            	    {
            	    // InternalSecLanguage.g:231:1: (lv_components_4_0= ruleWebComponent )
            	    // InternalSecLanguage.g:232:3: lv_components_4_0= ruleWebComponent
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getTargetOfEvaluationAccess().getComponentsWebComponentParserRuleCall_2_2_0()); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_5);
            	    lv_components_4_0=ruleWebComponent();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getTargetOfEvaluationRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"components",
            	            		lv_components_4_0, 
            	            		"edu.udea.vulnfinder.gram.SecLanguage.WebComponent");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);


            }

            otherlv_5=(Token)match(input,14,FollowSets000.FOLLOW_2); 

                	newLeafNode(otherlv_5, grammarAccess.getTargetOfEvaluationAccess().getRightParenthesisKeyword_3());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTargetOfEvaluation"


    // $ANTLR start "entryRuleAttack"
    // InternalSecLanguage.g:260:1: entryRuleAttack returns [EObject current=null] : iv_ruleAttack= ruleAttack EOF ;
    public final EObject entryRuleAttack() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAttack = null;


        try {
            // InternalSecLanguage.g:261:2: (iv_ruleAttack= ruleAttack EOF )
            // InternalSecLanguage.g:262:2: iv_ruleAttack= ruleAttack EOF
            {
             newCompositeNode(grammarAccess.getAttackRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleAttack=ruleAttack();

            state._fsp--;

             current =iv_ruleAttack; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAttack"


    // $ANTLR start "ruleAttack"
    // InternalSecLanguage.g:269:1: ruleAttack returns [EObject current=null] : ( () otherlv_1= '(' (otherlv_2= 'attack' ( (lv_name_3_0= ruleEAttackMethod ) ) (otherlv_4= '{' otherlv_5= ':level' ( (lv_severity_6_0= ruleESeverity ) ) otherlv_7= '}' )? ) otherlv_8= ')' ) ;
    public final EObject ruleAttack() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Enumerator lv_name_3_0 = null;

        Enumerator lv_severity_6_0 = null;


         enterRule(); 
            
        try {
            // InternalSecLanguage.g:272:28: ( ( () otherlv_1= '(' (otherlv_2= 'attack' ( (lv_name_3_0= ruleEAttackMethod ) ) (otherlv_4= '{' otherlv_5= ':level' ( (lv_severity_6_0= ruleESeverity ) ) otherlv_7= '}' )? ) otherlv_8= ')' ) )
            // InternalSecLanguage.g:273:1: ( () otherlv_1= '(' (otherlv_2= 'attack' ( (lv_name_3_0= ruleEAttackMethod ) ) (otherlv_4= '{' otherlv_5= ':level' ( (lv_severity_6_0= ruleESeverity ) ) otherlv_7= '}' )? ) otherlv_8= ')' )
            {
            // InternalSecLanguage.g:273:1: ( () otherlv_1= '(' (otherlv_2= 'attack' ( (lv_name_3_0= ruleEAttackMethod ) ) (otherlv_4= '{' otherlv_5= ':level' ( (lv_severity_6_0= ruleESeverity ) ) otherlv_7= '}' )? ) otherlv_8= ')' )
            // InternalSecLanguage.g:273:2: () otherlv_1= '(' (otherlv_2= 'attack' ( (lv_name_3_0= ruleEAttackMethod ) ) (otherlv_4= '{' otherlv_5= ':level' ( (lv_severity_6_0= ruleESeverity ) ) otherlv_7= '}' )? ) otherlv_8= ')'
            {
            // InternalSecLanguage.g:273:2: ()
            // InternalSecLanguage.g:274:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getAttackAccess().getAttackAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,11,FollowSets000.FOLLOW_11); 

                	newLeafNode(otherlv_1, grammarAccess.getAttackAccess().getLeftParenthesisKeyword_1());
                
            // InternalSecLanguage.g:283:1: (otherlv_2= 'attack' ( (lv_name_3_0= ruleEAttackMethod ) ) (otherlv_4= '{' otherlv_5= ':level' ( (lv_severity_6_0= ruleESeverity ) ) otherlv_7= '}' )? )
            // InternalSecLanguage.g:283:3: otherlv_2= 'attack' ( (lv_name_3_0= ruleEAttackMethod ) ) (otherlv_4= '{' otherlv_5= ':level' ( (lv_severity_6_0= ruleESeverity ) ) otherlv_7= '}' )?
            {
            otherlv_2=(Token)match(input,17,FollowSets000.FOLLOW_12); 

                	newLeafNode(otherlv_2, grammarAccess.getAttackAccess().getAttackKeyword_2_0());
                
            // InternalSecLanguage.g:287:1: ( (lv_name_3_0= ruleEAttackMethod ) )
            // InternalSecLanguage.g:288:1: (lv_name_3_0= ruleEAttackMethod )
            {
            // InternalSecLanguage.g:288:1: (lv_name_3_0= ruleEAttackMethod )
            // InternalSecLanguage.g:289:3: lv_name_3_0= ruleEAttackMethod
            {
             
            	        newCompositeNode(grammarAccess.getAttackAccess().getNameEAttackMethodEnumRuleCall_2_1_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_13);
            lv_name_3_0=ruleEAttackMethod();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getAttackRule());
            	        }
                   		set(
                   			current, 
                   			"name",
                    		lv_name_3_0, 
                    		"edu.udea.vulnfinder.gram.SecLanguage.EAttackMethod");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // InternalSecLanguage.g:305:2: (otherlv_4= '{' otherlv_5= ':level' ( (lv_severity_6_0= ruleESeverity ) ) otherlv_7= '}' )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==18) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // InternalSecLanguage.g:305:4: otherlv_4= '{' otherlv_5= ':level' ( (lv_severity_6_0= ruleESeverity ) ) otherlv_7= '}'
                    {
                    otherlv_4=(Token)match(input,18,FollowSets000.FOLLOW_14); 

                        	newLeafNode(otherlv_4, grammarAccess.getAttackAccess().getLeftCurlyBracketKeyword_2_2_0());
                        
                    otherlv_5=(Token)match(input,19,FollowSets000.FOLLOW_15); 

                        	newLeafNode(otherlv_5, grammarAccess.getAttackAccess().getLevelKeyword_2_2_1());
                        
                    // InternalSecLanguage.g:313:1: ( (lv_severity_6_0= ruleESeverity ) )
                    // InternalSecLanguage.g:314:1: (lv_severity_6_0= ruleESeverity )
                    {
                    // InternalSecLanguage.g:314:1: (lv_severity_6_0= ruleESeverity )
                    // InternalSecLanguage.g:315:3: lv_severity_6_0= ruleESeverity
                    {
                     
                    	        newCompositeNode(grammarAccess.getAttackAccess().getSeverityESeverityEnumRuleCall_2_2_2_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_16);
                    lv_severity_6_0=ruleESeverity();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getAttackRule());
                    	        }
                           		set(
                           			current, 
                           			"severity",
                            		lv_severity_6_0, 
                            		"edu.udea.vulnfinder.gram.SecLanguage.ESeverity");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    otherlv_7=(Token)match(input,20,FollowSets000.FOLLOW_8); 

                        	newLeafNode(otherlv_7, grammarAccess.getAttackAccess().getRightCurlyBracketKeyword_2_2_3());
                        

                    }
                    break;

            }


            }

            otherlv_8=(Token)match(input,14,FollowSets000.FOLLOW_2); 

                	newLeafNode(otherlv_8, grammarAccess.getAttackAccess().getRightParenthesisKeyword_3());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAttack"


    // $ANTLR start "entryRuleEString"
    // InternalSecLanguage.g:347:1: entryRuleEString returns [String current=null] : iv_ruleEString= ruleEString EOF ;
    public final String entryRuleEString() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEString = null;


        try {
            // InternalSecLanguage.g:348:2: (iv_ruleEString= ruleEString EOF )
            // InternalSecLanguage.g:349:2: iv_ruleEString= ruleEString EOF
            {
             newCompositeNode(grammarAccess.getEStringRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleEString=ruleEString();

            state._fsp--;

             current =iv_ruleEString.getText(); 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEString"


    // $ANTLR start "ruleEString"
    // InternalSecLanguage.g:356:1: ruleEString returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID ) ;
    public final AntlrDatatypeRuleToken ruleEString() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_STRING_0=null;
        Token this_ID_1=null;

         enterRule(); 
            
        try {
            // InternalSecLanguage.g:359:28: ( (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID ) )
            // InternalSecLanguage.g:360:1: (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID )
            {
            // InternalSecLanguage.g:360:1: (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==RULE_STRING) ) {
                alt6=1;
            }
            else if ( (LA6_0==RULE_ID) ) {
                alt6=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // InternalSecLanguage.g:360:6: this_STRING_0= RULE_STRING
                    {
                    this_STRING_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_2); 

                    		current.merge(this_STRING_0);
                        
                     
                        newLeafNode(this_STRING_0, grammarAccess.getEStringAccess().getSTRINGTerminalRuleCall_0()); 
                        

                    }
                    break;
                case 2 :
                    // InternalSecLanguage.g:368:10: this_ID_1= RULE_ID
                    {
                    this_ID_1=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

                    		current.merge(this_ID_1);
                        
                     
                        newLeafNode(this_ID_1, grammarAccess.getEStringAccess().getIDTerminalRuleCall_1()); 
                        

                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEString"


    // $ANTLR start "entryRuleWebComponent"
    // InternalSecLanguage.g:383:1: entryRuleWebComponent returns [EObject current=null] : iv_ruleWebComponent= ruleWebComponent EOF ;
    public final EObject entryRuleWebComponent() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleWebComponent = null;


        try {
            // InternalSecLanguage.g:384:2: (iv_ruleWebComponent= ruleWebComponent EOF )
            // InternalSecLanguage.g:385:2: iv_ruleWebComponent= ruleWebComponent EOF
            {
             newCompositeNode(grammarAccess.getWebComponentRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleWebComponent=ruleWebComponent();

            state._fsp--;

             current =iv_ruleWebComponent; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleWebComponent"


    // $ANTLR start "ruleWebComponent"
    // InternalSecLanguage.g:392:1: ruleWebComponent returns [EObject current=null] : ( () otherlv_1= '(' (otherlv_2= 'page' ( (lv_path_3_0= ruleEString ) ) (otherlv_4= '{' otherlv_5= ':target' otherlv_6= '[' ( ruleEString )* otherlv_8= ']' otherlv_9= '}' )? ( (lv_inputs_10_0= ruleInput ) )* ) otherlv_11= ')' ) ;
    public final EObject ruleWebComponent() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        AntlrDatatypeRuleToken lv_path_3_0 = null;

        EObject lv_inputs_10_0 = null;


         enterRule(); 
            
        try {
            // InternalSecLanguage.g:395:28: ( ( () otherlv_1= '(' (otherlv_2= 'page' ( (lv_path_3_0= ruleEString ) ) (otherlv_4= '{' otherlv_5= ':target' otherlv_6= '[' ( ruleEString )* otherlv_8= ']' otherlv_9= '}' )? ( (lv_inputs_10_0= ruleInput ) )* ) otherlv_11= ')' ) )
            // InternalSecLanguage.g:396:1: ( () otherlv_1= '(' (otherlv_2= 'page' ( (lv_path_3_0= ruleEString ) ) (otherlv_4= '{' otherlv_5= ':target' otherlv_6= '[' ( ruleEString )* otherlv_8= ']' otherlv_9= '}' )? ( (lv_inputs_10_0= ruleInput ) )* ) otherlv_11= ')' )
            {
            // InternalSecLanguage.g:396:1: ( () otherlv_1= '(' (otherlv_2= 'page' ( (lv_path_3_0= ruleEString ) ) (otherlv_4= '{' otherlv_5= ':target' otherlv_6= '[' ( ruleEString )* otherlv_8= ']' otherlv_9= '}' )? ( (lv_inputs_10_0= ruleInput ) )* ) otherlv_11= ')' )
            // InternalSecLanguage.g:396:2: () otherlv_1= '(' (otherlv_2= 'page' ( (lv_path_3_0= ruleEString ) ) (otherlv_4= '{' otherlv_5= ':target' otherlv_6= '[' ( ruleEString )* otherlv_8= ']' otherlv_9= '}' )? ( (lv_inputs_10_0= ruleInput ) )* ) otherlv_11= ')'
            {
            // InternalSecLanguage.g:396:2: ()
            // InternalSecLanguage.g:397:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getWebComponentAccess().getWebComponentAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,11,FollowSets000.FOLLOW_17); 

                	newLeafNode(otherlv_1, grammarAccess.getWebComponentAccess().getLeftParenthesisKeyword_1());
                
            // InternalSecLanguage.g:406:1: (otherlv_2= 'page' ( (lv_path_3_0= ruleEString ) ) (otherlv_4= '{' otherlv_5= ':target' otherlv_6= '[' ( ruleEString )* otherlv_8= ']' otherlv_9= '}' )? ( (lv_inputs_10_0= ruleInput ) )* )
            // InternalSecLanguage.g:406:3: otherlv_2= 'page' ( (lv_path_3_0= ruleEString ) ) (otherlv_4= '{' otherlv_5= ':target' otherlv_6= '[' ( ruleEString )* otherlv_8= ']' otherlv_9= '}' )? ( (lv_inputs_10_0= ruleInput ) )*
            {
            otherlv_2=(Token)match(input,21,FollowSets000.FOLLOW_4); 

                	newLeafNode(otherlv_2, grammarAccess.getWebComponentAccess().getPageKeyword_2_0());
                
            // InternalSecLanguage.g:410:1: ( (lv_path_3_0= ruleEString ) )
            // InternalSecLanguage.g:411:1: (lv_path_3_0= ruleEString )
            {
            // InternalSecLanguage.g:411:1: (lv_path_3_0= ruleEString )
            // InternalSecLanguage.g:412:3: lv_path_3_0= ruleEString
            {
             
            	        newCompositeNode(grammarAccess.getWebComponentAccess().getPathEStringParserRuleCall_2_1_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_18);
            lv_path_3_0=ruleEString();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getWebComponentRule());
            	        }
                   		set(
                   			current, 
                   			"path",
                    		lv_path_3_0, 
                    		"edu.udea.vulnfinder.gram.SecLanguage.EString");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // InternalSecLanguage.g:428:2: (otherlv_4= '{' otherlv_5= ':target' otherlv_6= '[' ( ruleEString )* otherlv_8= ']' otherlv_9= '}' )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==18) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // InternalSecLanguage.g:428:4: otherlv_4= '{' otherlv_5= ':target' otherlv_6= '[' ( ruleEString )* otherlv_8= ']' otherlv_9= '}'
                    {
                    otherlv_4=(Token)match(input,18,FollowSets000.FOLLOW_19); 

                        	newLeafNode(otherlv_4, grammarAccess.getWebComponentAccess().getLeftCurlyBracketKeyword_2_2_0());
                        
                    otherlv_5=(Token)match(input,22,FollowSets000.FOLLOW_20); 

                        	newLeafNode(otherlv_5, grammarAccess.getWebComponentAccess().getTargetKeyword_2_2_1());
                        
                    otherlv_6=(Token)match(input,23,FollowSets000.FOLLOW_21); 

                        	newLeafNode(otherlv_6, grammarAccess.getWebComponentAccess().getLeftSquareBracketKeyword_2_2_2());
                        
                    // InternalSecLanguage.g:440:1: ( ruleEString )*
                    loop7:
                    do {
                        int alt7=2;
                        int LA7_0 = input.LA(1);

                        if ( ((LA7_0>=RULE_STRING && LA7_0<=RULE_ID)) ) {
                            alt7=1;
                        }


                        switch (alt7) {
                    	case 1 :
                    	    // InternalSecLanguage.g:441:5: ruleEString
                    	    {
                    	     
                    	            newCompositeNode(grammarAccess.getWebComponentAccess().getEStringParserRuleCall_2_2_3()); 
                    	        
                    	    pushFollow(FollowSets000.FOLLOW_21);
                    	    ruleEString();

                    	    state._fsp--;

                    	     
                    	            afterParserOrEnumRuleCall();
                    	        

                    	    }
                    	    break;

                    	default :
                    	    break loop7;
                        }
                    } while (true);

                    otherlv_8=(Token)match(input,24,FollowSets000.FOLLOW_16); 

                        	newLeafNode(otherlv_8, grammarAccess.getWebComponentAccess().getRightSquareBracketKeyword_2_2_4());
                        
                    otherlv_9=(Token)match(input,20,FollowSets000.FOLLOW_5); 

                        	newLeafNode(otherlv_9, grammarAccess.getWebComponentAccess().getRightCurlyBracketKeyword_2_2_5());
                        

                    }
                    break;

            }

            // InternalSecLanguage.g:456:3: ( (lv_inputs_10_0= ruleInput ) )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==11) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // InternalSecLanguage.g:457:1: (lv_inputs_10_0= ruleInput )
            	    {
            	    // InternalSecLanguage.g:457:1: (lv_inputs_10_0= ruleInput )
            	    // InternalSecLanguage.g:458:3: lv_inputs_10_0= ruleInput
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getWebComponentAccess().getInputsInputParserRuleCall_2_3_0()); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_5);
            	    lv_inputs_10_0=ruleInput();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getWebComponentRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"inputs",
            	            		lv_inputs_10_0, 
            	            		"edu.udea.vulnfinder.gram.SecLanguage.Input");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop9;
                }
            } while (true);


            }

            otherlv_11=(Token)match(input,14,FollowSets000.FOLLOW_2); 

                	newLeafNode(otherlv_11, grammarAccess.getWebComponentAccess().getRightParenthesisKeyword_3());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleWebComponent"


    // $ANTLR start "entryRuleInput"
    // InternalSecLanguage.g:486:1: entryRuleInput returns [EObject current=null] : iv_ruleInput= ruleInput EOF ;
    public final EObject entryRuleInput() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInput = null;


        try {
            // InternalSecLanguage.g:487:2: (iv_ruleInput= ruleInput EOF )
            // InternalSecLanguage.g:488:2: iv_ruleInput= ruleInput EOF
            {
             newCompositeNode(grammarAccess.getInputRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleInput=ruleInput();

            state._fsp--;

             current =iv_ruleInput; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleInput"


    // $ANTLR start "ruleInput"
    // InternalSecLanguage.g:495:1: ruleInput returns [EObject current=null] : ( () otherlv_1= '(' (otherlv_2= 'field' ( (lv_name_3_0= ruleEString ) ) (otherlv_4= '[' ( ruleEString )* otherlv_6= ']' )? ) otherlv_7= ')' ) ;
    public final EObject ruleInput() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        AntlrDatatypeRuleToken lv_name_3_0 = null;


         enterRule(); 
            
        try {
            // InternalSecLanguage.g:498:28: ( ( () otherlv_1= '(' (otherlv_2= 'field' ( (lv_name_3_0= ruleEString ) ) (otherlv_4= '[' ( ruleEString )* otherlv_6= ']' )? ) otherlv_7= ')' ) )
            // InternalSecLanguage.g:499:1: ( () otherlv_1= '(' (otherlv_2= 'field' ( (lv_name_3_0= ruleEString ) ) (otherlv_4= '[' ( ruleEString )* otherlv_6= ']' )? ) otherlv_7= ')' )
            {
            // InternalSecLanguage.g:499:1: ( () otherlv_1= '(' (otherlv_2= 'field' ( (lv_name_3_0= ruleEString ) ) (otherlv_4= '[' ( ruleEString )* otherlv_6= ']' )? ) otherlv_7= ')' )
            // InternalSecLanguage.g:499:2: () otherlv_1= '(' (otherlv_2= 'field' ( (lv_name_3_0= ruleEString ) ) (otherlv_4= '[' ( ruleEString )* otherlv_6= ']' )? ) otherlv_7= ')'
            {
            // InternalSecLanguage.g:499:2: ()
            // InternalSecLanguage.g:500:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getInputAccess().getInputAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,11,FollowSets000.FOLLOW_22); 

                	newLeafNode(otherlv_1, grammarAccess.getInputAccess().getLeftParenthesisKeyword_1());
                
            // InternalSecLanguage.g:509:1: (otherlv_2= 'field' ( (lv_name_3_0= ruleEString ) ) (otherlv_4= '[' ( ruleEString )* otherlv_6= ']' )? )
            // InternalSecLanguage.g:509:3: otherlv_2= 'field' ( (lv_name_3_0= ruleEString ) ) (otherlv_4= '[' ( ruleEString )* otherlv_6= ']' )?
            {
            otherlv_2=(Token)match(input,25,FollowSets000.FOLLOW_4); 

                	newLeafNode(otherlv_2, grammarAccess.getInputAccess().getFieldKeyword_2_0());
                
            // InternalSecLanguage.g:513:1: ( (lv_name_3_0= ruleEString ) )
            // InternalSecLanguage.g:514:1: (lv_name_3_0= ruleEString )
            {
            // InternalSecLanguage.g:514:1: (lv_name_3_0= ruleEString )
            // InternalSecLanguage.g:515:3: lv_name_3_0= ruleEString
            {
             
            	        newCompositeNode(grammarAccess.getInputAccess().getNameEStringParserRuleCall_2_1_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_23);
            lv_name_3_0=ruleEString();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getInputRule());
            	        }
                   		set(
                   			current, 
                   			"name",
                    		lv_name_3_0, 
                    		"edu.udea.vulnfinder.gram.SecLanguage.EString");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // InternalSecLanguage.g:531:2: (otherlv_4= '[' ( ruleEString )* otherlv_6= ']' )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==23) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // InternalSecLanguage.g:531:4: otherlv_4= '[' ( ruleEString )* otherlv_6= ']'
                    {
                    otherlv_4=(Token)match(input,23,FollowSets000.FOLLOW_21); 

                        	newLeafNode(otherlv_4, grammarAccess.getInputAccess().getLeftSquareBracketKeyword_2_2_0());
                        
                    // InternalSecLanguage.g:535:1: ( ruleEString )*
                    loop10:
                    do {
                        int alt10=2;
                        int LA10_0 = input.LA(1);

                        if ( ((LA10_0>=RULE_STRING && LA10_0<=RULE_ID)) ) {
                            alt10=1;
                        }


                        switch (alt10) {
                    	case 1 :
                    	    // InternalSecLanguage.g:536:5: ruleEString
                    	    {
                    	     
                    	            newCompositeNode(grammarAccess.getInputAccess().getEStringParserRuleCall_2_2_1()); 
                    	        
                    	    pushFollow(FollowSets000.FOLLOW_21);
                    	    ruleEString();

                    	    state._fsp--;

                    	     
                    	            afterParserOrEnumRuleCall();
                    	        

                    	    }
                    	    break;

                    	default :
                    	    break loop10;
                        }
                    } while (true);

                    otherlv_6=(Token)match(input,24,FollowSets000.FOLLOW_8); 

                        	newLeafNode(otherlv_6, grammarAccess.getInputAccess().getRightSquareBracketKeyword_2_2_2());
                        

                    }
                    break;

            }


            }

            otherlv_7=(Token)match(input,14,FollowSets000.FOLLOW_2); 

                	newLeafNode(otherlv_7, grammarAccess.getInputAccess().getRightParenthesisKeyword_3());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleInput"


    // $ANTLR start "ruleESeverity"
    // InternalSecLanguage.g:559:1: ruleESeverity returns [Enumerator current=null] : ( (enumLiteral_0= 'Low' ) | (enumLiteral_1= 'Medium' ) | (enumLiteral_2= 'High' ) ) ;
    public final Enumerator ruleESeverity() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;

         enterRule(); 
        try {
            // InternalSecLanguage.g:561:28: ( ( (enumLiteral_0= 'Low' ) | (enumLiteral_1= 'Medium' ) | (enumLiteral_2= 'High' ) ) )
            // InternalSecLanguage.g:562:1: ( (enumLiteral_0= 'Low' ) | (enumLiteral_1= 'Medium' ) | (enumLiteral_2= 'High' ) )
            {
            // InternalSecLanguage.g:562:1: ( (enumLiteral_0= 'Low' ) | (enumLiteral_1= 'Medium' ) | (enumLiteral_2= 'High' ) )
            int alt12=3;
            switch ( input.LA(1) ) {
            case 26:
                {
                alt12=1;
                }
                break;
            case 27:
                {
                alt12=2;
                }
                break;
            case 28:
                {
                alt12=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                throw nvae;
            }

            switch (alt12) {
                case 1 :
                    // InternalSecLanguage.g:562:2: (enumLiteral_0= 'Low' )
                    {
                    // InternalSecLanguage.g:562:2: (enumLiteral_0= 'Low' )
                    // InternalSecLanguage.g:562:4: enumLiteral_0= 'Low'
                    {
                    enumLiteral_0=(Token)match(input,26,FollowSets000.FOLLOW_2); 

                            current = grammarAccess.getESeverityAccess().getLowEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_0, grammarAccess.getESeverityAccess().getLowEnumLiteralDeclaration_0()); 
                        

                    }


                    }
                    break;
                case 2 :
                    // InternalSecLanguage.g:568:6: (enumLiteral_1= 'Medium' )
                    {
                    // InternalSecLanguage.g:568:6: (enumLiteral_1= 'Medium' )
                    // InternalSecLanguage.g:568:8: enumLiteral_1= 'Medium'
                    {
                    enumLiteral_1=(Token)match(input,27,FollowSets000.FOLLOW_2); 

                            current = grammarAccess.getESeverityAccess().getMediumEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_1, grammarAccess.getESeverityAccess().getMediumEnumLiteralDeclaration_1()); 
                        

                    }


                    }
                    break;
                case 3 :
                    // InternalSecLanguage.g:574:6: (enumLiteral_2= 'High' )
                    {
                    // InternalSecLanguage.g:574:6: (enumLiteral_2= 'High' )
                    // InternalSecLanguage.g:574:8: enumLiteral_2= 'High'
                    {
                    enumLiteral_2=(Token)match(input,28,FollowSets000.FOLLOW_2); 

                            current = grammarAccess.getESeverityAccess().getHighEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_2, grammarAccess.getESeverityAccess().getHighEnumLiteralDeclaration_2()); 
                        

                    }


                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleESeverity"


    // $ANTLR start "ruleEAttackMethod"
    // InternalSecLanguage.g:584:1: ruleEAttackMethod returns [Enumerator current=null] : ( (enumLiteral_0= 'SQLInjection' ) | (enumLiteral_1= 'XSS' ) | (enumLiteral_2= 'Authentication' ) | (enumLiteral_3= 'Authorization' ) | (enumLiteral_4= 'PrivilegeScalation' ) ) ;
    public final Enumerator ruleEAttackMethod() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;
        Token enumLiteral_4=null;

         enterRule(); 
        try {
            // InternalSecLanguage.g:586:28: ( ( (enumLiteral_0= 'SQLInjection' ) | (enumLiteral_1= 'XSS' ) | (enumLiteral_2= 'Authentication' ) | (enumLiteral_3= 'Authorization' ) | (enumLiteral_4= 'PrivilegeScalation' ) ) )
            // InternalSecLanguage.g:587:1: ( (enumLiteral_0= 'SQLInjection' ) | (enumLiteral_1= 'XSS' ) | (enumLiteral_2= 'Authentication' ) | (enumLiteral_3= 'Authorization' ) | (enumLiteral_4= 'PrivilegeScalation' ) )
            {
            // InternalSecLanguage.g:587:1: ( (enumLiteral_0= 'SQLInjection' ) | (enumLiteral_1= 'XSS' ) | (enumLiteral_2= 'Authentication' ) | (enumLiteral_3= 'Authorization' ) | (enumLiteral_4= 'PrivilegeScalation' ) )
            int alt13=5;
            switch ( input.LA(1) ) {
            case 29:
                {
                alt13=1;
                }
                break;
            case 30:
                {
                alt13=2;
                }
                break;
            case 31:
                {
                alt13=3;
                }
                break;
            case 32:
                {
                alt13=4;
                }
                break;
            case 33:
                {
                alt13=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 13, 0, input);

                throw nvae;
            }

            switch (alt13) {
                case 1 :
                    // InternalSecLanguage.g:587:2: (enumLiteral_0= 'SQLInjection' )
                    {
                    // InternalSecLanguage.g:587:2: (enumLiteral_0= 'SQLInjection' )
                    // InternalSecLanguage.g:587:4: enumLiteral_0= 'SQLInjection'
                    {
                    enumLiteral_0=(Token)match(input,29,FollowSets000.FOLLOW_2); 

                            current = grammarAccess.getEAttackMethodAccess().getSQLInjectionEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_0, grammarAccess.getEAttackMethodAccess().getSQLInjectionEnumLiteralDeclaration_0()); 
                        

                    }


                    }
                    break;
                case 2 :
                    // InternalSecLanguage.g:593:6: (enumLiteral_1= 'XSS' )
                    {
                    // InternalSecLanguage.g:593:6: (enumLiteral_1= 'XSS' )
                    // InternalSecLanguage.g:593:8: enumLiteral_1= 'XSS'
                    {
                    enumLiteral_1=(Token)match(input,30,FollowSets000.FOLLOW_2); 

                            current = grammarAccess.getEAttackMethodAccess().getXSSEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_1, grammarAccess.getEAttackMethodAccess().getXSSEnumLiteralDeclaration_1()); 
                        

                    }


                    }
                    break;
                case 3 :
                    // InternalSecLanguage.g:599:6: (enumLiteral_2= 'Authentication' )
                    {
                    // InternalSecLanguage.g:599:6: (enumLiteral_2= 'Authentication' )
                    // InternalSecLanguage.g:599:8: enumLiteral_2= 'Authentication'
                    {
                    enumLiteral_2=(Token)match(input,31,FollowSets000.FOLLOW_2); 

                            current = grammarAccess.getEAttackMethodAccess().getAuthenticationEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_2, grammarAccess.getEAttackMethodAccess().getAuthenticationEnumLiteralDeclaration_2()); 
                        

                    }


                    }
                    break;
                case 4 :
                    // InternalSecLanguage.g:605:6: (enumLiteral_3= 'Authorization' )
                    {
                    // InternalSecLanguage.g:605:6: (enumLiteral_3= 'Authorization' )
                    // InternalSecLanguage.g:605:8: enumLiteral_3= 'Authorization'
                    {
                    enumLiteral_3=(Token)match(input,32,FollowSets000.FOLLOW_2); 

                            current = grammarAccess.getEAttackMethodAccess().getAuthorizationEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_3, grammarAccess.getEAttackMethodAccess().getAuthorizationEnumLiteralDeclaration_3()); 
                        

                    }


                    }
                    break;
                case 5 :
                    // InternalSecLanguage.g:611:6: (enumLiteral_4= 'PrivilegeScalation' )
                    {
                    // InternalSecLanguage.g:611:6: (enumLiteral_4= 'PrivilegeScalation' )
                    // InternalSecLanguage.g:611:8: enumLiteral_4= 'PrivilegeScalation'
                    {
                    enumLiteral_4=(Token)match(input,33,FollowSets000.FOLLOW_2); 

                            current = grammarAccess.getEAttackMethodAccess().getPrivilegeScalationEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_4, grammarAccess.getEAttackMethodAccess().getPrivilegeScalationEnumLiteralDeclaration_4()); 
                        

                    }


                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEAttackMethod"

    // Delegated rules


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000004800L});
        public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000000800L});
        public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000008000L});
        public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000010000L});
        public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000020000L});
        public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x00000003E0000000L});
        public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000044000L});
        public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000000080000L});
        public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x000000001C000000L});
        public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000000100000L});
        public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000000200000L});
        public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000000044800L});
        public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000000400000L});
        public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000000800000L});
        public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000001000030L});
        public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000002000000L});
        public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000000804000L});
    }


}