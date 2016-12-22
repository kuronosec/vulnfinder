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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_STRING", "RULE_ID", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'('", "'security-test'", "'{'", "':name'", "':severity'", "'}'", "'toes'", "')'", "'attacks'", "'notes'", "':roles'", "'['", "']'", "':username-param'", "':password-param'", "':login-target-url'", "':login-message-pattern'", "':logout-message-pattern'", "'toe'", "'attack'", "'page'", "':target'", "'field'", "'Low'", "'Medium'", "'High'"
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
    public static final int T__34=34;
    public static final int T__13=13;
    public static final int T__35=35;
    public static final int T__14=14;
    public static final int T__36=36;
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
    // InternalSecLanguage.g:77:1: ruleSecurityTest returns [EObject current=null] : ( () otherlv_1= '(' otherlv_2= 'security-test' (otherlv_3= '{' otherlv_4= ':name' ( (lv_id_5_0= ruleEString ) ) (otherlv_6= ':severity' ( (lv_severity_7_0= ruleESeverity ) ) )? ( (lv_authSetting_8_0= ruleAuthSetting ) ) otherlv_9= '}' ) (otherlv_10= '(' otherlv_11= 'toes' ( (lv_scope_12_0= ruleTargetOfEvaluation ) ) otherlv_13= ')' )? (otherlv_14= '(' otherlv_15= 'attacks' ( (lv_possibleAttacks_16_0= ruleAttack ) )+ otherlv_17= ')' )? (otherlv_18= '(' otherlv_19= 'notes' ( (lv_note_20_0= ruleNote ) ) otherlv_21= ')' )? otherlv_22= ')' ) ;
    public final EObject ruleSecurityTest() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_9=null;
        Token otherlv_10=null;
        Token otherlv_11=null;
        Token otherlv_13=null;
        Token otherlv_14=null;
        Token otherlv_15=null;
        Token otherlv_17=null;
        Token otherlv_18=null;
        Token otherlv_19=null;
        Token otherlv_21=null;
        Token otherlv_22=null;
        AntlrDatatypeRuleToken lv_id_5_0 = null;

        Enumerator lv_severity_7_0 = null;

        EObject lv_authSetting_8_0 = null;

        EObject lv_scope_12_0 = null;

        EObject lv_possibleAttacks_16_0 = null;

        EObject lv_note_20_0 = null;


         enterRule(); 
            
        try {
            // InternalSecLanguage.g:80:28: ( ( () otherlv_1= '(' otherlv_2= 'security-test' (otherlv_3= '{' otherlv_4= ':name' ( (lv_id_5_0= ruleEString ) ) (otherlv_6= ':severity' ( (lv_severity_7_0= ruleESeverity ) ) )? ( (lv_authSetting_8_0= ruleAuthSetting ) ) otherlv_9= '}' ) (otherlv_10= '(' otherlv_11= 'toes' ( (lv_scope_12_0= ruleTargetOfEvaluation ) ) otherlv_13= ')' )? (otherlv_14= '(' otherlv_15= 'attacks' ( (lv_possibleAttacks_16_0= ruleAttack ) )+ otherlv_17= ')' )? (otherlv_18= '(' otherlv_19= 'notes' ( (lv_note_20_0= ruleNote ) ) otherlv_21= ')' )? otherlv_22= ')' ) )
            // InternalSecLanguage.g:81:1: ( () otherlv_1= '(' otherlv_2= 'security-test' (otherlv_3= '{' otherlv_4= ':name' ( (lv_id_5_0= ruleEString ) ) (otherlv_6= ':severity' ( (lv_severity_7_0= ruleESeverity ) ) )? ( (lv_authSetting_8_0= ruleAuthSetting ) ) otherlv_9= '}' ) (otherlv_10= '(' otherlv_11= 'toes' ( (lv_scope_12_0= ruleTargetOfEvaluation ) ) otherlv_13= ')' )? (otherlv_14= '(' otherlv_15= 'attacks' ( (lv_possibleAttacks_16_0= ruleAttack ) )+ otherlv_17= ')' )? (otherlv_18= '(' otherlv_19= 'notes' ( (lv_note_20_0= ruleNote ) ) otherlv_21= ')' )? otherlv_22= ')' )
            {
            // InternalSecLanguage.g:81:1: ( () otherlv_1= '(' otherlv_2= 'security-test' (otherlv_3= '{' otherlv_4= ':name' ( (lv_id_5_0= ruleEString ) ) (otherlv_6= ':severity' ( (lv_severity_7_0= ruleESeverity ) ) )? ( (lv_authSetting_8_0= ruleAuthSetting ) ) otherlv_9= '}' ) (otherlv_10= '(' otherlv_11= 'toes' ( (lv_scope_12_0= ruleTargetOfEvaluation ) ) otherlv_13= ')' )? (otherlv_14= '(' otherlv_15= 'attacks' ( (lv_possibleAttacks_16_0= ruleAttack ) )+ otherlv_17= ')' )? (otherlv_18= '(' otherlv_19= 'notes' ( (lv_note_20_0= ruleNote ) ) otherlv_21= ')' )? otherlv_22= ')' )
            // InternalSecLanguage.g:81:2: () otherlv_1= '(' otherlv_2= 'security-test' (otherlv_3= '{' otherlv_4= ':name' ( (lv_id_5_0= ruleEString ) ) (otherlv_6= ':severity' ( (lv_severity_7_0= ruleESeverity ) ) )? ( (lv_authSetting_8_0= ruleAuthSetting ) ) otherlv_9= '}' ) (otherlv_10= '(' otherlv_11= 'toes' ( (lv_scope_12_0= ruleTargetOfEvaluation ) ) otherlv_13= ')' )? (otherlv_14= '(' otherlv_15= 'attacks' ( (lv_possibleAttacks_16_0= ruleAttack ) )+ otherlv_17= ')' )? (otherlv_18= '(' otherlv_19= 'notes' ( (lv_note_20_0= ruleNote ) ) otherlv_21= ')' )? otherlv_22= ')'
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
                
            // InternalSecLanguage.g:95:1: (otherlv_3= '{' otherlv_4= ':name' ( (lv_id_5_0= ruleEString ) ) (otherlv_6= ':severity' ( (lv_severity_7_0= ruleESeverity ) ) )? ( (lv_authSetting_8_0= ruleAuthSetting ) ) otherlv_9= '}' )
            // InternalSecLanguage.g:95:3: otherlv_3= '{' otherlv_4= ':name' ( (lv_id_5_0= ruleEString ) ) (otherlv_6= ':severity' ( (lv_severity_7_0= ruleESeverity ) ) )? ( (lv_authSetting_8_0= ruleAuthSetting ) ) otherlv_9= '}'
            {
            otherlv_3=(Token)match(input,13,FollowSets000.FOLLOW_5); 

                	newLeafNode(otherlv_3, grammarAccess.getSecurityTestAccess().getLeftCurlyBracketKeyword_3_0());
                
            otherlv_4=(Token)match(input,14,FollowSets000.FOLLOW_6); 

                	newLeafNode(otherlv_4, grammarAccess.getSecurityTestAccess().getNameKeyword_3_1());
                
            // InternalSecLanguage.g:103:1: ( (lv_id_5_0= ruleEString ) )
            // InternalSecLanguage.g:104:1: (lv_id_5_0= ruleEString )
            {
            // InternalSecLanguage.g:104:1: (lv_id_5_0= ruleEString )
            // InternalSecLanguage.g:105:3: lv_id_5_0= ruleEString
            {
             
            	        newCompositeNode(grammarAccess.getSecurityTestAccess().getIdEStringParserRuleCall_3_2_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_7);
            lv_id_5_0=ruleEString();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getSecurityTestRule());
            	        }
                   		set(
                   			current, 
                   			"id",
                    		lv_id_5_0, 
                    		"edu.udea.vulnfinder.gram.SecLanguage.EString");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // InternalSecLanguage.g:121:2: (otherlv_6= ':severity' ( (lv_severity_7_0= ruleESeverity ) ) )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==15) ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // InternalSecLanguage.g:121:4: otherlv_6= ':severity' ( (lv_severity_7_0= ruleESeverity ) )
                    {
                    otherlv_6=(Token)match(input,15,FollowSets000.FOLLOW_8); 

                        	newLeafNode(otherlv_6, grammarAccess.getSecurityTestAccess().getSeverityKeyword_3_3_0());
                        
                    // InternalSecLanguage.g:125:1: ( (lv_severity_7_0= ruleESeverity ) )
                    // InternalSecLanguage.g:126:1: (lv_severity_7_0= ruleESeverity )
                    {
                    // InternalSecLanguage.g:126:1: (lv_severity_7_0= ruleESeverity )
                    // InternalSecLanguage.g:127:3: lv_severity_7_0= ruleESeverity
                    {
                     
                    	        newCompositeNode(grammarAccess.getSecurityTestAccess().getSeverityESeverityEnumRuleCall_3_3_1_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_9);
                    lv_severity_7_0=ruleESeverity();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getSecurityTestRule());
                    	        }
                           		set(
                           			current, 
                           			"severity",
                            		lv_severity_7_0, 
                            		"edu.udea.vulnfinder.gram.SecLanguage.ESeverity");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            // InternalSecLanguage.g:143:4: ( (lv_authSetting_8_0= ruleAuthSetting ) )
            // InternalSecLanguage.g:144:1: (lv_authSetting_8_0= ruleAuthSetting )
            {
            // InternalSecLanguage.g:144:1: (lv_authSetting_8_0= ruleAuthSetting )
            // InternalSecLanguage.g:145:3: lv_authSetting_8_0= ruleAuthSetting
            {
             
            	        newCompositeNode(grammarAccess.getSecurityTestAccess().getAuthSettingAuthSettingParserRuleCall_3_4_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_10);
            lv_authSetting_8_0=ruleAuthSetting();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getSecurityTestRule());
            	        }
                   		set(
                   			current, 
                   			"authSetting",
                    		lv_authSetting_8_0, 
                    		"edu.udea.vulnfinder.gram.SecLanguage.AuthSetting");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_9=(Token)match(input,16,FollowSets000.FOLLOW_11); 

                	newLeafNode(otherlv_9, grammarAccess.getSecurityTestAccess().getRightCurlyBracketKeyword_3_5());
                

            }

            // InternalSecLanguage.g:165:2: (otherlv_10= '(' otherlv_11= 'toes' ( (lv_scope_12_0= ruleTargetOfEvaluation ) ) otherlv_13= ')' )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==11) ) {
                int LA2_1 = input.LA(2);

                if ( (LA2_1==17) ) {
                    alt2=1;
                }
            }
            switch (alt2) {
                case 1 :
                    // InternalSecLanguage.g:165:4: otherlv_10= '(' otherlv_11= 'toes' ( (lv_scope_12_0= ruleTargetOfEvaluation ) ) otherlv_13= ')'
                    {
                    otherlv_10=(Token)match(input,11,FollowSets000.FOLLOW_12); 

                        	newLeafNode(otherlv_10, grammarAccess.getSecurityTestAccess().getLeftParenthesisKeyword_4_0());
                        
                    otherlv_11=(Token)match(input,17,FollowSets000.FOLLOW_13); 

                        	newLeafNode(otherlv_11, grammarAccess.getSecurityTestAccess().getToesKeyword_4_1());
                        
                    // InternalSecLanguage.g:173:1: ( (lv_scope_12_0= ruleTargetOfEvaluation ) )
                    // InternalSecLanguage.g:174:1: (lv_scope_12_0= ruleTargetOfEvaluation )
                    {
                    // InternalSecLanguage.g:174:1: (lv_scope_12_0= ruleTargetOfEvaluation )
                    // InternalSecLanguage.g:175:3: lv_scope_12_0= ruleTargetOfEvaluation
                    {
                     
                    	        newCompositeNode(grammarAccess.getSecurityTestAccess().getScopeTargetOfEvaluationParserRuleCall_4_2_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_14);
                    lv_scope_12_0=ruleTargetOfEvaluation();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getSecurityTestRule());
                    	        }
                           		set(
                           			current, 
                           			"scope",
                            		lv_scope_12_0, 
                            		"edu.udea.vulnfinder.gram.SecLanguage.TargetOfEvaluation");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    otherlv_13=(Token)match(input,18,FollowSets000.FOLLOW_11); 

                        	newLeafNode(otherlv_13, grammarAccess.getSecurityTestAccess().getRightParenthesisKeyword_4_3());
                        

                    }
                    break;

            }

            // InternalSecLanguage.g:195:3: (otherlv_14= '(' otherlv_15= 'attacks' ( (lv_possibleAttacks_16_0= ruleAttack ) )+ otherlv_17= ')' )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==11) ) {
                int LA4_1 = input.LA(2);

                if ( (LA4_1==19) ) {
                    alt4=1;
                }
            }
            switch (alt4) {
                case 1 :
                    // InternalSecLanguage.g:195:5: otherlv_14= '(' otherlv_15= 'attacks' ( (lv_possibleAttacks_16_0= ruleAttack ) )+ otherlv_17= ')'
                    {
                    otherlv_14=(Token)match(input,11,FollowSets000.FOLLOW_15); 

                        	newLeafNode(otherlv_14, grammarAccess.getSecurityTestAccess().getLeftParenthesisKeyword_5_0());
                        
                    otherlv_15=(Token)match(input,19,FollowSets000.FOLLOW_13); 

                        	newLeafNode(otherlv_15, grammarAccess.getSecurityTestAccess().getAttacksKeyword_5_1());
                        
                    // InternalSecLanguage.g:203:1: ( (lv_possibleAttacks_16_0= ruleAttack ) )+
                    int cnt3=0;
                    loop3:
                    do {
                        int alt3=2;
                        int LA3_0 = input.LA(1);

                        if ( (LA3_0==11) ) {
                            alt3=1;
                        }


                        switch (alt3) {
                    	case 1 :
                    	    // InternalSecLanguage.g:204:1: (lv_possibleAttacks_16_0= ruleAttack )
                    	    {
                    	    // InternalSecLanguage.g:204:1: (lv_possibleAttacks_16_0= ruleAttack )
                    	    // InternalSecLanguage.g:205:3: lv_possibleAttacks_16_0= ruleAttack
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getSecurityTestAccess().getPossibleAttacksAttackParserRuleCall_5_2_0()); 
                    	    	    
                    	    pushFollow(FollowSets000.FOLLOW_11);
                    	    lv_possibleAttacks_16_0=ruleAttack();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getSecurityTestRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"possibleAttacks",
                    	            		lv_possibleAttacks_16_0, 
                    	            		"edu.udea.vulnfinder.gram.SecLanguage.Attack");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt3 >= 1 ) break loop3;
                                EarlyExitException eee =
                                    new EarlyExitException(3, input);
                                throw eee;
                        }
                        cnt3++;
                    } while (true);

                    otherlv_17=(Token)match(input,18,FollowSets000.FOLLOW_11); 

                        	newLeafNode(otherlv_17, grammarAccess.getSecurityTestAccess().getRightParenthesisKeyword_5_3());
                        

                    }
                    break;

            }

            // InternalSecLanguage.g:225:3: (otherlv_18= '(' otherlv_19= 'notes' ( (lv_note_20_0= ruleNote ) ) otherlv_21= ')' )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==11) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // InternalSecLanguage.g:225:5: otherlv_18= '(' otherlv_19= 'notes' ( (lv_note_20_0= ruleNote ) ) otherlv_21= ')'
                    {
                    otherlv_18=(Token)match(input,11,FollowSets000.FOLLOW_16); 

                        	newLeafNode(otherlv_18, grammarAccess.getSecurityTestAccess().getLeftParenthesisKeyword_6_0());
                        
                    otherlv_19=(Token)match(input,20,FollowSets000.FOLLOW_6); 

                        	newLeafNode(otherlv_19, grammarAccess.getSecurityTestAccess().getNotesKeyword_6_1());
                        
                    // InternalSecLanguage.g:233:1: ( (lv_note_20_0= ruleNote ) )
                    // InternalSecLanguage.g:234:1: (lv_note_20_0= ruleNote )
                    {
                    // InternalSecLanguage.g:234:1: (lv_note_20_0= ruleNote )
                    // InternalSecLanguage.g:235:3: lv_note_20_0= ruleNote
                    {
                     
                    	        newCompositeNode(grammarAccess.getSecurityTestAccess().getNoteNoteParserRuleCall_6_2_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_14);
                    lv_note_20_0=ruleNote();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getSecurityTestRule());
                    	        }
                           		set(
                           			current, 
                           			"note",
                            		lv_note_20_0, 
                            		"edu.udea.vulnfinder.gram.SecLanguage.Note");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    otherlv_21=(Token)match(input,18,FollowSets000.FOLLOW_14); 

                        	newLeafNode(otherlv_21, grammarAccess.getSecurityTestAccess().getRightParenthesisKeyword_6_3());
                        

                    }
                    break;

            }

            otherlv_22=(Token)match(input,18,FollowSets000.FOLLOW_2); 

                	newLeafNode(otherlv_22, grammarAccess.getSecurityTestAccess().getRightParenthesisKeyword_7());
                

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


    // $ANTLR start "entryRuleAuthSetting"
    // InternalSecLanguage.g:267:1: entryRuleAuthSetting returns [EObject current=null] : iv_ruleAuthSetting= ruleAuthSetting EOF ;
    public final EObject entryRuleAuthSetting() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAuthSetting = null;


        try {
            // InternalSecLanguage.g:268:2: (iv_ruleAuthSetting= ruleAuthSetting EOF )
            // InternalSecLanguage.g:269:2: iv_ruleAuthSetting= ruleAuthSetting EOF
            {
             newCompositeNode(grammarAccess.getAuthSettingRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleAuthSetting=ruleAuthSetting();

            state._fsp--;

             current =iv_ruleAuthSetting; 
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
    // $ANTLR end "entryRuleAuthSetting"


    // $ANTLR start "ruleAuthSetting"
    // InternalSecLanguage.g:276:1: ruleAuthSetting returns [EObject current=null] : ( () (otherlv_1= ':roles' otherlv_2= '[' ( (lv_roles_3_0= ruleEString ) )* otherlv_4= ']' )? (otherlv_5= ':username-param' ( (lv_usernameParam_6_0= ruleEString ) ) )? (otherlv_7= ':password-param' ( (lv_passwordParam_8_0= ruleEString ) ) )? (otherlv_9= ':login-target-url' ( (lv_loginTargetURL_10_0= ruleEString ) ) )? (otherlv_11= ':login-message-pattern' ( (lv_loginMessagePattern_12_0= ruleEString ) ) )? (otherlv_13= ':logout-message-pattern' ( (lv_logoutMessagePattern_14_0= ruleEString ) ) )? ) ;
    public final EObject ruleAuthSetting() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        Token otherlv_13=null;
        AntlrDatatypeRuleToken lv_roles_3_0 = null;

        AntlrDatatypeRuleToken lv_usernameParam_6_0 = null;

        AntlrDatatypeRuleToken lv_passwordParam_8_0 = null;

        AntlrDatatypeRuleToken lv_loginTargetURL_10_0 = null;

        AntlrDatatypeRuleToken lv_loginMessagePattern_12_0 = null;

        AntlrDatatypeRuleToken lv_logoutMessagePattern_14_0 = null;


         enterRule(); 
            
        try {
            // InternalSecLanguage.g:279:28: ( ( () (otherlv_1= ':roles' otherlv_2= '[' ( (lv_roles_3_0= ruleEString ) )* otherlv_4= ']' )? (otherlv_5= ':username-param' ( (lv_usernameParam_6_0= ruleEString ) ) )? (otherlv_7= ':password-param' ( (lv_passwordParam_8_0= ruleEString ) ) )? (otherlv_9= ':login-target-url' ( (lv_loginTargetURL_10_0= ruleEString ) ) )? (otherlv_11= ':login-message-pattern' ( (lv_loginMessagePattern_12_0= ruleEString ) ) )? (otherlv_13= ':logout-message-pattern' ( (lv_logoutMessagePattern_14_0= ruleEString ) ) )? ) )
            // InternalSecLanguage.g:280:1: ( () (otherlv_1= ':roles' otherlv_2= '[' ( (lv_roles_3_0= ruleEString ) )* otherlv_4= ']' )? (otherlv_5= ':username-param' ( (lv_usernameParam_6_0= ruleEString ) ) )? (otherlv_7= ':password-param' ( (lv_passwordParam_8_0= ruleEString ) ) )? (otherlv_9= ':login-target-url' ( (lv_loginTargetURL_10_0= ruleEString ) ) )? (otherlv_11= ':login-message-pattern' ( (lv_loginMessagePattern_12_0= ruleEString ) ) )? (otherlv_13= ':logout-message-pattern' ( (lv_logoutMessagePattern_14_0= ruleEString ) ) )? )
            {
            // InternalSecLanguage.g:280:1: ( () (otherlv_1= ':roles' otherlv_2= '[' ( (lv_roles_3_0= ruleEString ) )* otherlv_4= ']' )? (otherlv_5= ':username-param' ( (lv_usernameParam_6_0= ruleEString ) ) )? (otherlv_7= ':password-param' ( (lv_passwordParam_8_0= ruleEString ) ) )? (otherlv_9= ':login-target-url' ( (lv_loginTargetURL_10_0= ruleEString ) ) )? (otherlv_11= ':login-message-pattern' ( (lv_loginMessagePattern_12_0= ruleEString ) ) )? (otherlv_13= ':logout-message-pattern' ( (lv_logoutMessagePattern_14_0= ruleEString ) ) )? )
            // InternalSecLanguage.g:280:2: () (otherlv_1= ':roles' otherlv_2= '[' ( (lv_roles_3_0= ruleEString ) )* otherlv_4= ']' )? (otherlv_5= ':username-param' ( (lv_usernameParam_6_0= ruleEString ) ) )? (otherlv_7= ':password-param' ( (lv_passwordParam_8_0= ruleEString ) ) )? (otherlv_9= ':login-target-url' ( (lv_loginTargetURL_10_0= ruleEString ) ) )? (otherlv_11= ':login-message-pattern' ( (lv_loginMessagePattern_12_0= ruleEString ) ) )? (otherlv_13= ':logout-message-pattern' ( (lv_logoutMessagePattern_14_0= ruleEString ) ) )?
            {
            // InternalSecLanguage.g:280:2: ()
            // InternalSecLanguage.g:281:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getAuthSettingAccess().getAuthSettingAction_0(),
                        current);
                

            }

            // InternalSecLanguage.g:286:2: (otherlv_1= ':roles' otherlv_2= '[' ( (lv_roles_3_0= ruleEString ) )* otherlv_4= ']' )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==21) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // InternalSecLanguage.g:286:4: otherlv_1= ':roles' otherlv_2= '[' ( (lv_roles_3_0= ruleEString ) )* otherlv_4= ']'
                    {
                    otherlv_1=(Token)match(input,21,FollowSets000.FOLLOW_17); 

                        	newLeafNode(otherlv_1, grammarAccess.getAuthSettingAccess().getRolesKeyword_1_0());
                        
                    otherlv_2=(Token)match(input,22,FollowSets000.FOLLOW_18); 

                        	newLeafNode(otherlv_2, grammarAccess.getAuthSettingAccess().getLeftSquareBracketKeyword_1_1());
                        
                    // InternalSecLanguage.g:294:1: ( (lv_roles_3_0= ruleEString ) )*
                    loop6:
                    do {
                        int alt6=2;
                        int LA6_0 = input.LA(1);

                        if ( ((LA6_0>=RULE_STRING && LA6_0<=RULE_ID)) ) {
                            alt6=1;
                        }


                        switch (alt6) {
                    	case 1 :
                    	    // InternalSecLanguage.g:295:1: (lv_roles_3_0= ruleEString )
                    	    {
                    	    // InternalSecLanguage.g:295:1: (lv_roles_3_0= ruleEString )
                    	    // InternalSecLanguage.g:296:3: lv_roles_3_0= ruleEString
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getAuthSettingAccess().getRolesEStringParserRuleCall_1_2_0()); 
                    	    	    
                    	    pushFollow(FollowSets000.FOLLOW_18);
                    	    lv_roles_3_0=ruleEString();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getAuthSettingRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"roles",
                    	            		lv_roles_3_0, 
                    	            		"edu.udea.vulnfinder.gram.SecLanguage.EString");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop6;
                        }
                    } while (true);

                    otherlv_4=(Token)match(input,23,FollowSets000.FOLLOW_19); 

                        	newLeafNode(otherlv_4, grammarAccess.getAuthSettingAccess().getRightSquareBracketKeyword_1_3());
                        

                    }
                    break;

            }

            // InternalSecLanguage.g:316:3: (otherlv_5= ':username-param' ( (lv_usernameParam_6_0= ruleEString ) ) )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==24) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // InternalSecLanguage.g:316:5: otherlv_5= ':username-param' ( (lv_usernameParam_6_0= ruleEString ) )
                    {
                    otherlv_5=(Token)match(input,24,FollowSets000.FOLLOW_6); 

                        	newLeafNode(otherlv_5, grammarAccess.getAuthSettingAccess().getUsernameParamKeyword_2_0());
                        
                    // InternalSecLanguage.g:320:1: ( (lv_usernameParam_6_0= ruleEString ) )
                    // InternalSecLanguage.g:321:1: (lv_usernameParam_6_0= ruleEString )
                    {
                    // InternalSecLanguage.g:321:1: (lv_usernameParam_6_0= ruleEString )
                    // InternalSecLanguage.g:322:3: lv_usernameParam_6_0= ruleEString
                    {
                     
                    	        newCompositeNode(grammarAccess.getAuthSettingAccess().getUsernameParamEStringParserRuleCall_2_1_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_20);
                    lv_usernameParam_6_0=ruleEString();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getAuthSettingRule());
                    	        }
                           		set(
                           			current, 
                           			"usernameParam",
                            		lv_usernameParam_6_0, 
                            		"edu.udea.vulnfinder.gram.SecLanguage.EString");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            // InternalSecLanguage.g:338:4: (otherlv_7= ':password-param' ( (lv_passwordParam_8_0= ruleEString ) ) )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==25) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // InternalSecLanguage.g:338:6: otherlv_7= ':password-param' ( (lv_passwordParam_8_0= ruleEString ) )
                    {
                    otherlv_7=(Token)match(input,25,FollowSets000.FOLLOW_6); 

                        	newLeafNode(otherlv_7, grammarAccess.getAuthSettingAccess().getPasswordParamKeyword_3_0());
                        
                    // InternalSecLanguage.g:342:1: ( (lv_passwordParam_8_0= ruleEString ) )
                    // InternalSecLanguage.g:343:1: (lv_passwordParam_8_0= ruleEString )
                    {
                    // InternalSecLanguage.g:343:1: (lv_passwordParam_8_0= ruleEString )
                    // InternalSecLanguage.g:344:3: lv_passwordParam_8_0= ruleEString
                    {
                     
                    	        newCompositeNode(grammarAccess.getAuthSettingAccess().getPasswordParamEStringParserRuleCall_3_1_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_21);
                    lv_passwordParam_8_0=ruleEString();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getAuthSettingRule());
                    	        }
                           		set(
                           			current, 
                           			"passwordParam",
                            		lv_passwordParam_8_0, 
                            		"edu.udea.vulnfinder.gram.SecLanguage.EString");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            // InternalSecLanguage.g:360:4: (otherlv_9= ':login-target-url' ( (lv_loginTargetURL_10_0= ruleEString ) ) )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==26) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // InternalSecLanguage.g:360:6: otherlv_9= ':login-target-url' ( (lv_loginTargetURL_10_0= ruleEString ) )
                    {
                    otherlv_9=(Token)match(input,26,FollowSets000.FOLLOW_6); 

                        	newLeafNode(otherlv_9, grammarAccess.getAuthSettingAccess().getLoginTargetUrlKeyword_4_0());
                        
                    // InternalSecLanguage.g:364:1: ( (lv_loginTargetURL_10_0= ruleEString ) )
                    // InternalSecLanguage.g:365:1: (lv_loginTargetURL_10_0= ruleEString )
                    {
                    // InternalSecLanguage.g:365:1: (lv_loginTargetURL_10_0= ruleEString )
                    // InternalSecLanguage.g:366:3: lv_loginTargetURL_10_0= ruleEString
                    {
                     
                    	        newCompositeNode(grammarAccess.getAuthSettingAccess().getLoginTargetURLEStringParserRuleCall_4_1_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_22);
                    lv_loginTargetURL_10_0=ruleEString();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getAuthSettingRule());
                    	        }
                           		set(
                           			current, 
                           			"loginTargetURL",
                            		lv_loginTargetURL_10_0, 
                            		"edu.udea.vulnfinder.gram.SecLanguage.EString");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            // InternalSecLanguage.g:382:4: (otherlv_11= ':login-message-pattern' ( (lv_loginMessagePattern_12_0= ruleEString ) ) )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==27) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // InternalSecLanguage.g:382:6: otherlv_11= ':login-message-pattern' ( (lv_loginMessagePattern_12_0= ruleEString ) )
                    {
                    otherlv_11=(Token)match(input,27,FollowSets000.FOLLOW_6); 

                        	newLeafNode(otherlv_11, grammarAccess.getAuthSettingAccess().getLoginMessagePatternKeyword_5_0());
                        
                    // InternalSecLanguage.g:386:1: ( (lv_loginMessagePattern_12_0= ruleEString ) )
                    // InternalSecLanguage.g:387:1: (lv_loginMessagePattern_12_0= ruleEString )
                    {
                    // InternalSecLanguage.g:387:1: (lv_loginMessagePattern_12_0= ruleEString )
                    // InternalSecLanguage.g:388:3: lv_loginMessagePattern_12_0= ruleEString
                    {
                     
                    	        newCompositeNode(grammarAccess.getAuthSettingAccess().getLoginMessagePatternEStringParserRuleCall_5_1_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_23);
                    lv_loginMessagePattern_12_0=ruleEString();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getAuthSettingRule());
                    	        }
                           		set(
                           			current, 
                           			"loginMessagePattern",
                            		lv_loginMessagePattern_12_0, 
                            		"edu.udea.vulnfinder.gram.SecLanguage.EString");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            // InternalSecLanguage.g:404:4: (otherlv_13= ':logout-message-pattern' ( (lv_logoutMessagePattern_14_0= ruleEString ) ) )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==28) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // InternalSecLanguage.g:404:6: otherlv_13= ':logout-message-pattern' ( (lv_logoutMessagePattern_14_0= ruleEString ) )
                    {
                    otherlv_13=(Token)match(input,28,FollowSets000.FOLLOW_6); 

                        	newLeafNode(otherlv_13, grammarAccess.getAuthSettingAccess().getLogoutMessagePatternKeyword_6_0());
                        
                    // InternalSecLanguage.g:408:1: ( (lv_logoutMessagePattern_14_0= ruleEString ) )
                    // InternalSecLanguage.g:409:1: (lv_logoutMessagePattern_14_0= ruleEString )
                    {
                    // InternalSecLanguage.g:409:1: (lv_logoutMessagePattern_14_0= ruleEString )
                    // InternalSecLanguage.g:410:3: lv_logoutMessagePattern_14_0= ruleEString
                    {
                     
                    	        newCompositeNode(grammarAccess.getAuthSettingAccess().getLogoutMessagePatternEStringParserRuleCall_6_1_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_logoutMessagePattern_14_0=ruleEString();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getAuthSettingRule());
                    	        }
                           		set(
                           			current, 
                           			"logoutMessagePattern",
                            		lv_logoutMessagePattern_14_0, 
                            		"edu.udea.vulnfinder.gram.SecLanguage.EString");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }


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
    // $ANTLR end "ruleAuthSetting"


    // $ANTLR start "entryRuleNote"
    // InternalSecLanguage.g:434:1: entryRuleNote returns [EObject current=null] : iv_ruleNote= ruleNote EOF ;
    public final EObject entryRuleNote() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNote = null;


        try {
            // InternalSecLanguage.g:435:2: (iv_ruleNote= ruleNote EOF )
            // InternalSecLanguage.g:436:2: iv_ruleNote= ruleNote EOF
            {
             newCompositeNode(grammarAccess.getNoteRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleNote=ruleNote();

            state._fsp--;

             current =iv_ruleNote; 
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
    // $ANTLR end "entryRuleNote"


    // $ANTLR start "ruleNote"
    // InternalSecLanguage.g:443:1: ruleNote returns [EObject current=null] : ( () ( (lv_noteText_1_0= ruleEString ) ) ) ;
    public final EObject ruleNote() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_noteText_1_0 = null;


         enterRule(); 
            
        try {
            // InternalSecLanguage.g:446:28: ( ( () ( (lv_noteText_1_0= ruleEString ) ) ) )
            // InternalSecLanguage.g:447:1: ( () ( (lv_noteText_1_0= ruleEString ) ) )
            {
            // InternalSecLanguage.g:447:1: ( () ( (lv_noteText_1_0= ruleEString ) ) )
            // InternalSecLanguage.g:447:2: () ( (lv_noteText_1_0= ruleEString ) )
            {
            // InternalSecLanguage.g:447:2: ()
            // InternalSecLanguage.g:448:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getNoteAccess().getNoteAction_0(),
                        current);
                

            }

            // InternalSecLanguage.g:453:2: ( (lv_noteText_1_0= ruleEString ) )
            // InternalSecLanguage.g:454:1: (lv_noteText_1_0= ruleEString )
            {
            // InternalSecLanguage.g:454:1: (lv_noteText_1_0= ruleEString )
            // InternalSecLanguage.g:455:3: lv_noteText_1_0= ruleEString
            {
             
            	        newCompositeNode(grammarAccess.getNoteAccess().getNoteTextEStringParserRuleCall_1_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_2);
            lv_noteText_1_0=ruleEString();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getNoteRule());
            	        }
                   		set(
                   			current, 
                   			"noteText",
                    		lv_noteText_1_0, 
                    		"edu.udea.vulnfinder.gram.SecLanguage.EString");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }


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
    // $ANTLR end "ruleNote"


    // $ANTLR start "entryRuleTargetOfEvaluation"
    // InternalSecLanguage.g:479:1: entryRuleTargetOfEvaluation returns [EObject current=null] : iv_ruleTargetOfEvaluation= ruleTargetOfEvaluation EOF ;
    public final EObject entryRuleTargetOfEvaluation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTargetOfEvaluation = null;


        try {
            // InternalSecLanguage.g:480:2: (iv_ruleTargetOfEvaluation= ruleTargetOfEvaluation EOF )
            // InternalSecLanguage.g:481:2: iv_ruleTargetOfEvaluation= ruleTargetOfEvaluation EOF
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
    // InternalSecLanguage.g:488:1: ruleTargetOfEvaluation returns [EObject current=null] : ( () otherlv_1= '(' (otherlv_2= 'toe' ( (lv_domain_3_0= ruleEString ) ) ( (lv_components_4_0= ruleWebComponent ) )* ) otherlv_5= ')' ) ;
    public final EObject ruleTargetOfEvaluation() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_5=null;
        AntlrDatatypeRuleToken lv_domain_3_0 = null;

        EObject lv_components_4_0 = null;


         enterRule(); 
            
        try {
            // InternalSecLanguage.g:491:28: ( ( () otherlv_1= '(' (otherlv_2= 'toe' ( (lv_domain_3_0= ruleEString ) ) ( (lv_components_4_0= ruleWebComponent ) )* ) otherlv_5= ')' ) )
            // InternalSecLanguage.g:492:1: ( () otherlv_1= '(' (otherlv_2= 'toe' ( (lv_domain_3_0= ruleEString ) ) ( (lv_components_4_0= ruleWebComponent ) )* ) otherlv_5= ')' )
            {
            // InternalSecLanguage.g:492:1: ( () otherlv_1= '(' (otherlv_2= 'toe' ( (lv_domain_3_0= ruleEString ) ) ( (lv_components_4_0= ruleWebComponent ) )* ) otherlv_5= ')' )
            // InternalSecLanguage.g:492:2: () otherlv_1= '(' (otherlv_2= 'toe' ( (lv_domain_3_0= ruleEString ) ) ( (lv_components_4_0= ruleWebComponent ) )* ) otherlv_5= ')'
            {
            // InternalSecLanguage.g:492:2: ()
            // InternalSecLanguage.g:493:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getTargetOfEvaluationAccess().getTargetOfEvaluationAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,11,FollowSets000.FOLLOW_24); 

                	newLeafNode(otherlv_1, grammarAccess.getTargetOfEvaluationAccess().getLeftParenthesisKeyword_1());
                
            // InternalSecLanguage.g:502:1: (otherlv_2= 'toe' ( (lv_domain_3_0= ruleEString ) ) ( (lv_components_4_0= ruleWebComponent ) )* )
            // InternalSecLanguage.g:502:3: otherlv_2= 'toe' ( (lv_domain_3_0= ruleEString ) ) ( (lv_components_4_0= ruleWebComponent ) )*
            {
            otherlv_2=(Token)match(input,29,FollowSets000.FOLLOW_6); 

                	newLeafNode(otherlv_2, grammarAccess.getTargetOfEvaluationAccess().getToeKeyword_2_0());
                
            // InternalSecLanguage.g:506:1: ( (lv_domain_3_0= ruleEString ) )
            // InternalSecLanguage.g:507:1: (lv_domain_3_0= ruleEString )
            {
            // InternalSecLanguage.g:507:1: (lv_domain_3_0= ruleEString )
            // InternalSecLanguage.g:508:3: lv_domain_3_0= ruleEString
            {
             
            	        newCompositeNode(grammarAccess.getTargetOfEvaluationAccess().getDomainEStringParserRuleCall_2_1_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_11);
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

            // InternalSecLanguage.g:524:2: ( (lv_components_4_0= ruleWebComponent ) )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==11) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // InternalSecLanguage.g:525:1: (lv_components_4_0= ruleWebComponent )
            	    {
            	    // InternalSecLanguage.g:525:1: (lv_components_4_0= ruleWebComponent )
            	    // InternalSecLanguage.g:526:3: lv_components_4_0= ruleWebComponent
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getTargetOfEvaluationAccess().getComponentsWebComponentParserRuleCall_2_2_0()); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_11);
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
            	    break loop13;
                }
            } while (true);


            }

            otherlv_5=(Token)match(input,18,FollowSets000.FOLLOW_2); 

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
    // InternalSecLanguage.g:554:1: entryRuleAttack returns [EObject current=null] : iv_ruleAttack= ruleAttack EOF ;
    public final EObject entryRuleAttack() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAttack = null;


        try {
            // InternalSecLanguage.g:555:2: (iv_ruleAttack= ruleAttack EOF )
            // InternalSecLanguage.g:556:2: iv_ruleAttack= ruleAttack EOF
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
    // InternalSecLanguage.g:563:1: ruleAttack returns [EObject current=null] : ( () otherlv_1= '(' (otherlv_2= 'attack' ( (lv_name_3_0= ruleEString ) ) (otherlv_4= '{' otherlv_5= ':severity' ( (lv_severity_6_0= ruleESeverity ) ) otherlv_7= '}' )? ) otherlv_8= ')' ) ;
    public final EObject ruleAttack() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        AntlrDatatypeRuleToken lv_name_3_0 = null;

        Enumerator lv_severity_6_0 = null;


         enterRule(); 
            
        try {
            // InternalSecLanguage.g:566:28: ( ( () otherlv_1= '(' (otherlv_2= 'attack' ( (lv_name_3_0= ruleEString ) ) (otherlv_4= '{' otherlv_5= ':severity' ( (lv_severity_6_0= ruleESeverity ) ) otherlv_7= '}' )? ) otherlv_8= ')' ) )
            // InternalSecLanguage.g:567:1: ( () otherlv_1= '(' (otherlv_2= 'attack' ( (lv_name_3_0= ruleEString ) ) (otherlv_4= '{' otherlv_5= ':severity' ( (lv_severity_6_0= ruleESeverity ) ) otherlv_7= '}' )? ) otherlv_8= ')' )
            {
            // InternalSecLanguage.g:567:1: ( () otherlv_1= '(' (otherlv_2= 'attack' ( (lv_name_3_0= ruleEString ) ) (otherlv_4= '{' otherlv_5= ':severity' ( (lv_severity_6_0= ruleESeverity ) ) otherlv_7= '}' )? ) otherlv_8= ')' )
            // InternalSecLanguage.g:567:2: () otherlv_1= '(' (otherlv_2= 'attack' ( (lv_name_3_0= ruleEString ) ) (otherlv_4= '{' otherlv_5= ':severity' ( (lv_severity_6_0= ruleESeverity ) ) otherlv_7= '}' )? ) otherlv_8= ')'
            {
            // InternalSecLanguage.g:567:2: ()
            // InternalSecLanguage.g:568:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getAttackAccess().getAttackAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,11,FollowSets000.FOLLOW_25); 

                	newLeafNode(otherlv_1, grammarAccess.getAttackAccess().getLeftParenthesisKeyword_1());
                
            // InternalSecLanguage.g:577:1: (otherlv_2= 'attack' ( (lv_name_3_0= ruleEString ) ) (otherlv_4= '{' otherlv_5= ':severity' ( (lv_severity_6_0= ruleESeverity ) ) otherlv_7= '}' )? )
            // InternalSecLanguage.g:577:3: otherlv_2= 'attack' ( (lv_name_3_0= ruleEString ) ) (otherlv_4= '{' otherlv_5= ':severity' ( (lv_severity_6_0= ruleESeverity ) ) otherlv_7= '}' )?
            {
            otherlv_2=(Token)match(input,30,FollowSets000.FOLLOW_6); 

                	newLeafNode(otherlv_2, grammarAccess.getAttackAccess().getAttackKeyword_2_0());
                
            // InternalSecLanguage.g:581:1: ( (lv_name_3_0= ruleEString ) )
            // InternalSecLanguage.g:582:1: (lv_name_3_0= ruleEString )
            {
            // InternalSecLanguage.g:582:1: (lv_name_3_0= ruleEString )
            // InternalSecLanguage.g:583:3: lv_name_3_0= ruleEString
            {
             
            	        newCompositeNode(grammarAccess.getAttackAccess().getNameEStringParserRuleCall_2_1_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_26);
            lv_name_3_0=ruleEString();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getAttackRule());
            	        }
                   		set(
                   			current, 
                   			"name",
                    		lv_name_3_0, 
                    		"edu.udea.vulnfinder.gram.SecLanguage.EString");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // InternalSecLanguage.g:599:2: (otherlv_4= '{' otherlv_5= ':severity' ( (lv_severity_6_0= ruleESeverity ) ) otherlv_7= '}' )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==13) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // InternalSecLanguage.g:599:4: otherlv_4= '{' otherlv_5= ':severity' ( (lv_severity_6_0= ruleESeverity ) ) otherlv_7= '}'
                    {
                    otherlv_4=(Token)match(input,13,FollowSets000.FOLLOW_27); 

                        	newLeafNode(otherlv_4, grammarAccess.getAttackAccess().getLeftCurlyBracketKeyword_2_2_0());
                        
                    otherlv_5=(Token)match(input,15,FollowSets000.FOLLOW_8); 

                        	newLeafNode(otherlv_5, grammarAccess.getAttackAccess().getSeverityKeyword_2_2_1());
                        
                    // InternalSecLanguage.g:607:1: ( (lv_severity_6_0= ruleESeverity ) )
                    // InternalSecLanguage.g:608:1: (lv_severity_6_0= ruleESeverity )
                    {
                    // InternalSecLanguage.g:608:1: (lv_severity_6_0= ruleESeverity )
                    // InternalSecLanguage.g:609:3: lv_severity_6_0= ruleESeverity
                    {
                     
                    	        newCompositeNode(grammarAccess.getAttackAccess().getSeverityESeverityEnumRuleCall_2_2_2_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_10);
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

                    otherlv_7=(Token)match(input,16,FollowSets000.FOLLOW_14); 

                        	newLeafNode(otherlv_7, grammarAccess.getAttackAccess().getRightCurlyBracketKeyword_2_2_3());
                        

                    }
                    break;

            }


            }

            otherlv_8=(Token)match(input,18,FollowSets000.FOLLOW_2); 

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
    // InternalSecLanguage.g:641:1: entryRuleEString returns [String current=null] : iv_ruleEString= ruleEString EOF ;
    public final String entryRuleEString() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEString = null;


        try {
            // InternalSecLanguage.g:642:2: (iv_ruleEString= ruleEString EOF )
            // InternalSecLanguage.g:643:2: iv_ruleEString= ruleEString EOF
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
    // InternalSecLanguage.g:650:1: ruleEString returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID ) ;
    public final AntlrDatatypeRuleToken ruleEString() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_STRING_0=null;
        Token this_ID_1=null;

         enterRule(); 
            
        try {
            // InternalSecLanguage.g:653:28: ( (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID ) )
            // InternalSecLanguage.g:654:1: (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID )
            {
            // InternalSecLanguage.g:654:1: (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID )
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==RULE_STRING) ) {
                alt15=1;
            }
            else if ( (LA15_0==RULE_ID) ) {
                alt15=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 15, 0, input);

                throw nvae;
            }
            switch (alt15) {
                case 1 :
                    // InternalSecLanguage.g:654:6: this_STRING_0= RULE_STRING
                    {
                    this_STRING_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_2); 

                    		current.merge(this_STRING_0);
                        
                     
                        newLeafNode(this_STRING_0, grammarAccess.getEStringAccess().getSTRINGTerminalRuleCall_0()); 
                        

                    }
                    break;
                case 2 :
                    // InternalSecLanguage.g:662:10: this_ID_1= RULE_ID
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
    // InternalSecLanguage.g:677:1: entryRuleWebComponent returns [EObject current=null] : iv_ruleWebComponent= ruleWebComponent EOF ;
    public final EObject entryRuleWebComponent() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleWebComponent = null;


        try {
            // InternalSecLanguage.g:678:2: (iv_ruleWebComponent= ruleWebComponent EOF )
            // InternalSecLanguage.g:679:2: iv_ruleWebComponent= ruleWebComponent EOF
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
    // InternalSecLanguage.g:686:1: ruleWebComponent returns [EObject current=null] : ( () otherlv_1= '(' (otherlv_2= 'page' ( (lv_path_3_0= ruleEString ) ) (otherlv_4= '{' otherlv_5= ':target' otherlv_6= '[' ( ruleEString )* otherlv_8= ']' otherlv_9= '}' )? ( (lv_inputs_10_0= ruleInput ) )* ) otherlv_11= ')' ) ;
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
            // InternalSecLanguage.g:689:28: ( ( () otherlv_1= '(' (otherlv_2= 'page' ( (lv_path_3_0= ruleEString ) ) (otherlv_4= '{' otherlv_5= ':target' otherlv_6= '[' ( ruleEString )* otherlv_8= ']' otherlv_9= '}' )? ( (lv_inputs_10_0= ruleInput ) )* ) otherlv_11= ')' ) )
            // InternalSecLanguage.g:690:1: ( () otherlv_1= '(' (otherlv_2= 'page' ( (lv_path_3_0= ruleEString ) ) (otherlv_4= '{' otherlv_5= ':target' otherlv_6= '[' ( ruleEString )* otherlv_8= ']' otherlv_9= '}' )? ( (lv_inputs_10_0= ruleInput ) )* ) otherlv_11= ')' )
            {
            // InternalSecLanguage.g:690:1: ( () otherlv_1= '(' (otherlv_2= 'page' ( (lv_path_3_0= ruleEString ) ) (otherlv_4= '{' otherlv_5= ':target' otherlv_6= '[' ( ruleEString )* otherlv_8= ']' otherlv_9= '}' )? ( (lv_inputs_10_0= ruleInput ) )* ) otherlv_11= ')' )
            // InternalSecLanguage.g:690:2: () otherlv_1= '(' (otherlv_2= 'page' ( (lv_path_3_0= ruleEString ) ) (otherlv_4= '{' otherlv_5= ':target' otherlv_6= '[' ( ruleEString )* otherlv_8= ']' otherlv_9= '}' )? ( (lv_inputs_10_0= ruleInput ) )* ) otherlv_11= ')'
            {
            // InternalSecLanguage.g:690:2: ()
            // InternalSecLanguage.g:691:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getWebComponentAccess().getWebComponentAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,11,FollowSets000.FOLLOW_28); 

                	newLeafNode(otherlv_1, grammarAccess.getWebComponentAccess().getLeftParenthesisKeyword_1());
                
            // InternalSecLanguage.g:700:1: (otherlv_2= 'page' ( (lv_path_3_0= ruleEString ) ) (otherlv_4= '{' otherlv_5= ':target' otherlv_6= '[' ( ruleEString )* otherlv_8= ']' otherlv_9= '}' )? ( (lv_inputs_10_0= ruleInput ) )* )
            // InternalSecLanguage.g:700:3: otherlv_2= 'page' ( (lv_path_3_0= ruleEString ) ) (otherlv_4= '{' otherlv_5= ':target' otherlv_6= '[' ( ruleEString )* otherlv_8= ']' otherlv_9= '}' )? ( (lv_inputs_10_0= ruleInput ) )*
            {
            otherlv_2=(Token)match(input,31,FollowSets000.FOLLOW_6); 

                	newLeafNode(otherlv_2, grammarAccess.getWebComponentAccess().getPageKeyword_2_0());
                
            // InternalSecLanguage.g:704:1: ( (lv_path_3_0= ruleEString ) )
            // InternalSecLanguage.g:705:1: (lv_path_3_0= ruleEString )
            {
            // InternalSecLanguage.g:705:1: (lv_path_3_0= ruleEString )
            // InternalSecLanguage.g:706:3: lv_path_3_0= ruleEString
            {
             
            	        newCompositeNode(grammarAccess.getWebComponentAccess().getPathEStringParserRuleCall_2_1_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_29);
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

            // InternalSecLanguage.g:722:2: (otherlv_4= '{' otherlv_5= ':target' otherlv_6= '[' ( ruleEString )* otherlv_8= ']' otherlv_9= '}' )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==13) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // InternalSecLanguage.g:722:4: otherlv_4= '{' otherlv_5= ':target' otherlv_6= '[' ( ruleEString )* otherlv_8= ']' otherlv_9= '}'
                    {
                    otherlv_4=(Token)match(input,13,FollowSets000.FOLLOW_30); 

                        	newLeafNode(otherlv_4, grammarAccess.getWebComponentAccess().getLeftCurlyBracketKeyword_2_2_0());
                        
                    otherlv_5=(Token)match(input,32,FollowSets000.FOLLOW_17); 

                        	newLeafNode(otherlv_5, grammarAccess.getWebComponentAccess().getTargetKeyword_2_2_1());
                        
                    otherlv_6=(Token)match(input,22,FollowSets000.FOLLOW_18); 

                        	newLeafNode(otherlv_6, grammarAccess.getWebComponentAccess().getLeftSquareBracketKeyword_2_2_2());
                        
                    // InternalSecLanguage.g:734:1: ( ruleEString )*
                    loop16:
                    do {
                        int alt16=2;
                        int LA16_0 = input.LA(1);

                        if ( ((LA16_0>=RULE_STRING && LA16_0<=RULE_ID)) ) {
                            alt16=1;
                        }


                        switch (alt16) {
                    	case 1 :
                    	    // InternalSecLanguage.g:735:5: ruleEString
                    	    {
                    	     
                    	            newCompositeNode(grammarAccess.getWebComponentAccess().getEStringParserRuleCall_2_2_3()); 
                    	        
                    	    pushFollow(FollowSets000.FOLLOW_18);
                    	    ruleEString();

                    	    state._fsp--;

                    	     
                    	            afterParserOrEnumRuleCall();
                    	        

                    	    }
                    	    break;

                    	default :
                    	    break loop16;
                        }
                    } while (true);

                    otherlv_8=(Token)match(input,23,FollowSets000.FOLLOW_10); 

                        	newLeafNode(otherlv_8, grammarAccess.getWebComponentAccess().getRightSquareBracketKeyword_2_2_4());
                        
                    otherlv_9=(Token)match(input,16,FollowSets000.FOLLOW_11); 

                        	newLeafNode(otherlv_9, grammarAccess.getWebComponentAccess().getRightCurlyBracketKeyword_2_2_5());
                        

                    }
                    break;

            }

            // InternalSecLanguage.g:750:3: ( (lv_inputs_10_0= ruleInput ) )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( (LA18_0==11) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // InternalSecLanguage.g:751:1: (lv_inputs_10_0= ruleInput )
            	    {
            	    // InternalSecLanguage.g:751:1: (lv_inputs_10_0= ruleInput )
            	    // InternalSecLanguage.g:752:3: lv_inputs_10_0= ruleInput
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getWebComponentAccess().getInputsInputParserRuleCall_2_3_0()); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_11);
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
            	    break loop18;
                }
            } while (true);


            }

            otherlv_11=(Token)match(input,18,FollowSets000.FOLLOW_2); 

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
    // InternalSecLanguage.g:780:1: entryRuleInput returns [EObject current=null] : iv_ruleInput= ruleInput EOF ;
    public final EObject entryRuleInput() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInput = null;


        try {
            // InternalSecLanguage.g:781:2: (iv_ruleInput= ruleInput EOF )
            // InternalSecLanguage.g:782:2: iv_ruleInput= ruleInput EOF
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
    // InternalSecLanguage.g:789:1: ruleInput returns [EObject current=null] : ( () otherlv_1= '(' (otherlv_2= 'field' ( (lv_name_3_0= ruleEString ) ) (otherlv_4= '[' ( ( ruleEString ) )* otherlv_6= ']' )? ) otherlv_7= ')' ) ;
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
            // InternalSecLanguage.g:792:28: ( ( () otherlv_1= '(' (otherlv_2= 'field' ( (lv_name_3_0= ruleEString ) ) (otherlv_4= '[' ( ( ruleEString ) )* otherlv_6= ']' )? ) otherlv_7= ')' ) )
            // InternalSecLanguage.g:793:1: ( () otherlv_1= '(' (otherlv_2= 'field' ( (lv_name_3_0= ruleEString ) ) (otherlv_4= '[' ( ( ruleEString ) )* otherlv_6= ']' )? ) otherlv_7= ')' )
            {
            // InternalSecLanguage.g:793:1: ( () otherlv_1= '(' (otherlv_2= 'field' ( (lv_name_3_0= ruleEString ) ) (otherlv_4= '[' ( ( ruleEString ) )* otherlv_6= ']' )? ) otherlv_7= ')' )
            // InternalSecLanguage.g:793:2: () otherlv_1= '(' (otherlv_2= 'field' ( (lv_name_3_0= ruleEString ) ) (otherlv_4= '[' ( ( ruleEString ) )* otherlv_6= ']' )? ) otherlv_7= ')'
            {
            // InternalSecLanguage.g:793:2: ()
            // InternalSecLanguage.g:794:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getInputAccess().getInputAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,11,FollowSets000.FOLLOW_31); 

                	newLeafNode(otherlv_1, grammarAccess.getInputAccess().getLeftParenthesisKeyword_1());
                
            // InternalSecLanguage.g:803:1: (otherlv_2= 'field' ( (lv_name_3_0= ruleEString ) ) (otherlv_4= '[' ( ( ruleEString ) )* otherlv_6= ']' )? )
            // InternalSecLanguage.g:803:3: otherlv_2= 'field' ( (lv_name_3_0= ruleEString ) ) (otherlv_4= '[' ( ( ruleEString ) )* otherlv_6= ']' )?
            {
            otherlv_2=(Token)match(input,33,FollowSets000.FOLLOW_6); 

                	newLeafNode(otherlv_2, grammarAccess.getInputAccess().getFieldKeyword_2_0());
                
            // InternalSecLanguage.g:807:1: ( (lv_name_3_0= ruleEString ) )
            // InternalSecLanguage.g:808:1: (lv_name_3_0= ruleEString )
            {
            // InternalSecLanguage.g:808:1: (lv_name_3_0= ruleEString )
            // InternalSecLanguage.g:809:3: lv_name_3_0= ruleEString
            {
             
            	        newCompositeNode(grammarAccess.getInputAccess().getNameEStringParserRuleCall_2_1_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_32);
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

            // InternalSecLanguage.g:825:2: (otherlv_4= '[' ( ( ruleEString ) )* otherlv_6= ']' )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==22) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // InternalSecLanguage.g:825:4: otherlv_4= '[' ( ( ruleEString ) )* otherlv_6= ']'
                    {
                    otherlv_4=(Token)match(input,22,FollowSets000.FOLLOW_18); 

                        	newLeafNode(otherlv_4, grammarAccess.getInputAccess().getLeftSquareBracketKeyword_2_2_0());
                        
                    // InternalSecLanguage.g:829:1: ( ( ruleEString ) )*
                    loop19:
                    do {
                        int alt19=2;
                        int LA19_0 = input.LA(1);

                        if ( ((LA19_0>=RULE_STRING && LA19_0<=RULE_ID)) ) {
                            alt19=1;
                        }


                        switch (alt19) {
                    	case 1 :
                    	    // InternalSecLanguage.g:830:1: ( ruleEString )
                    	    {
                    	    // InternalSecLanguage.g:830:1: ( ruleEString )
                    	    // InternalSecLanguage.g:831:3: ruleEString
                    	    {

                    	    			if (current==null) {
                    	    	            current = createModelElement(grammarAccess.getInputRule());
                    	    	        }
                    	            
                    	     
                    	    	        newCompositeNode(grammarAccess.getInputAccess().getAttacksAttackCrossReference_2_2_1_0()); 
                    	    	    
                    	    pushFollow(FollowSets000.FOLLOW_18);
                    	    ruleEString();

                    	    state._fsp--;

                    	     
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop19;
                        }
                    } while (true);

                    otherlv_6=(Token)match(input,23,FollowSets000.FOLLOW_14); 

                        	newLeafNode(otherlv_6, grammarAccess.getInputAccess().getRightSquareBracketKeyword_2_2_2());
                        

                    }
                    break;

            }


            }

            otherlv_7=(Token)match(input,18,FollowSets000.FOLLOW_2); 

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
    // InternalSecLanguage.g:860:1: ruleESeverity returns [Enumerator current=null] : ( (enumLiteral_0= 'Low' ) | (enumLiteral_1= 'Medium' ) | (enumLiteral_2= 'High' ) ) ;
    public final Enumerator ruleESeverity() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;

         enterRule(); 
        try {
            // InternalSecLanguage.g:862:28: ( ( (enumLiteral_0= 'Low' ) | (enumLiteral_1= 'Medium' ) | (enumLiteral_2= 'High' ) ) )
            // InternalSecLanguage.g:863:1: ( (enumLiteral_0= 'Low' ) | (enumLiteral_1= 'Medium' ) | (enumLiteral_2= 'High' ) )
            {
            // InternalSecLanguage.g:863:1: ( (enumLiteral_0= 'Low' ) | (enumLiteral_1= 'Medium' ) | (enumLiteral_2= 'High' ) )
            int alt21=3;
            switch ( input.LA(1) ) {
            case 34:
                {
                alt21=1;
                }
                break;
            case 35:
                {
                alt21=2;
                }
                break;
            case 36:
                {
                alt21=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 21, 0, input);

                throw nvae;
            }

            switch (alt21) {
                case 1 :
                    // InternalSecLanguage.g:863:2: (enumLiteral_0= 'Low' )
                    {
                    // InternalSecLanguage.g:863:2: (enumLiteral_0= 'Low' )
                    // InternalSecLanguage.g:863:4: enumLiteral_0= 'Low'
                    {
                    enumLiteral_0=(Token)match(input,34,FollowSets000.FOLLOW_2); 

                            current = grammarAccess.getESeverityAccess().getLowEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_0, grammarAccess.getESeverityAccess().getLowEnumLiteralDeclaration_0()); 
                        

                    }


                    }
                    break;
                case 2 :
                    // InternalSecLanguage.g:869:6: (enumLiteral_1= 'Medium' )
                    {
                    // InternalSecLanguage.g:869:6: (enumLiteral_1= 'Medium' )
                    // InternalSecLanguage.g:869:8: enumLiteral_1= 'Medium'
                    {
                    enumLiteral_1=(Token)match(input,35,FollowSets000.FOLLOW_2); 

                            current = grammarAccess.getESeverityAccess().getMediumEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_1, grammarAccess.getESeverityAccess().getMediumEnumLiteralDeclaration_1()); 
                        

                    }


                    }
                    break;
                case 3 :
                    // InternalSecLanguage.g:875:6: (enumLiteral_2= 'High' )
                    {
                    // InternalSecLanguage.g:875:6: (enumLiteral_2= 'High' )
                    // InternalSecLanguage.g:875:8: enumLiteral_2= 'High'
                    {
                    enumLiteral_2=(Token)match(input,36,FollowSets000.FOLLOW_2); 

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

    // Delegated rules


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x000000001F218000L});
        public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000001C00000000L});
        public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x000000001F210000L});
        public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000010000L});
        public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000040800L});
        public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000020000L});
        public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000000800L});
        public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000000040000L});
        public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000000080000L});
        public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000000100000L});
        public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000000400000L});
        public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000000800030L});
        public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x000000001F000002L});
        public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x000000001E000002L});
        public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x000000001C000002L});
        public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000018000002L});
        public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000010000002L});
        public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000000020000000L});
        public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000000040000000L});
        public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000000000042000L});
        public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000000000008000L});
        public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000000080000000L});
        public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000000000042800L});
        public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000000100000000L});
        public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0000000200000000L});
        public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0000000000440000L});
    }


}