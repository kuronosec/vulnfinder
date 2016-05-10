package edu.udea.vulnfinder.gram.ui.contentassist.antlr.internal; 

import java.io.InputStream;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.DFA;
import edu.udea.vulnfinder.gram.services.SecLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalSecLanguageParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_STRING", "RULE_ID", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'Low'", "'Medium'", "'High'", "'SQLInjection'", "'XSS'", "'Authentication'", "'Authorization'", "'PrivilegeScalation'", "'('", "'securityTest'", "')'", "'toes'", "'attacks'", "'toe'", "'attack'", "'{'", "':level'", "'}'", "'page'", "':target'", "'['", "']'", "'field'"
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
     	
        public void setGrammarAccess(SecLanguageGrammarAccess grammarAccess) {
        	this.grammarAccess = grammarAccess;
        }
        
        @Override
        protected Grammar getGrammar() {
        	return grammarAccess.getGrammar();
        }
        
        @Override
        protected String getValueForTokenName(String tokenName) {
        	return tokenName;
        }




    // $ANTLR start "entryRuleSecurityTest"
    // InternalSecLanguage.g:60:1: entryRuleSecurityTest : ruleSecurityTest EOF ;
    public final void entryRuleSecurityTest() throws RecognitionException {
        try {
            // InternalSecLanguage.g:61:1: ( ruleSecurityTest EOF )
            // InternalSecLanguage.g:62:1: ruleSecurityTest EOF
            {
             before(grammarAccess.getSecurityTestRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleSecurityTest();

            state._fsp--;

             after(grammarAccess.getSecurityTestRule()); 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleSecurityTest"


    // $ANTLR start "ruleSecurityTest"
    // InternalSecLanguage.g:69:1: ruleSecurityTest : ( ( rule__SecurityTest__Group__0 ) ) ;
    public final void ruleSecurityTest() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalSecLanguage.g:73:2: ( ( ( rule__SecurityTest__Group__0 ) ) )
            // InternalSecLanguage.g:74:1: ( ( rule__SecurityTest__Group__0 ) )
            {
            // InternalSecLanguage.g:74:1: ( ( rule__SecurityTest__Group__0 ) )
            // InternalSecLanguage.g:75:1: ( rule__SecurityTest__Group__0 )
            {
             before(grammarAccess.getSecurityTestAccess().getGroup()); 
            // InternalSecLanguage.g:76:1: ( rule__SecurityTest__Group__0 )
            // InternalSecLanguage.g:76:2: rule__SecurityTest__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__SecurityTest__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getSecurityTestAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleSecurityTest"


    // $ANTLR start "entryRuleTargetOfEvaluation"
    // InternalSecLanguage.g:88:1: entryRuleTargetOfEvaluation : ruleTargetOfEvaluation EOF ;
    public final void entryRuleTargetOfEvaluation() throws RecognitionException {
        try {
            // InternalSecLanguage.g:89:1: ( ruleTargetOfEvaluation EOF )
            // InternalSecLanguage.g:90:1: ruleTargetOfEvaluation EOF
            {
             before(grammarAccess.getTargetOfEvaluationRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleTargetOfEvaluation();

            state._fsp--;

             after(grammarAccess.getTargetOfEvaluationRule()); 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleTargetOfEvaluation"


    // $ANTLR start "ruleTargetOfEvaluation"
    // InternalSecLanguage.g:97:1: ruleTargetOfEvaluation : ( ( rule__TargetOfEvaluation__Group__0 ) ) ;
    public final void ruleTargetOfEvaluation() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalSecLanguage.g:101:2: ( ( ( rule__TargetOfEvaluation__Group__0 ) ) )
            // InternalSecLanguage.g:102:1: ( ( rule__TargetOfEvaluation__Group__0 ) )
            {
            // InternalSecLanguage.g:102:1: ( ( rule__TargetOfEvaluation__Group__0 ) )
            // InternalSecLanguage.g:103:1: ( rule__TargetOfEvaluation__Group__0 )
            {
             before(grammarAccess.getTargetOfEvaluationAccess().getGroup()); 
            // InternalSecLanguage.g:104:1: ( rule__TargetOfEvaluation__Group__0 )
            // InternalSecLanguage.g:104:2: rule__TargetOfEvaluation__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__TargetOfEvaluation__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getTargetOfEvaluationAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleTargetOfEvaluation"


    // $ANTLR start "entryRuleAttack"
    // InternalSecLanguage.g:116:1: entryRuleAttack : ruleAttack EOF ;
    public final void entryRuleAttack() throws RecognitionException {
        try {
            // InternalSecLanguage.g:117:1: ( ruleAttack EOF )
            // InternalSecLanguage.g:118:1: ruleAttack EOF
            {
             before(grammarAccess.getAttackRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleAttack();

            state._fsp--;

             after(grammarAccess.getAttackRule()); 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleAttack"


    // $ANTLR start "ruleAttack"
    // InternalSecLanguage.g:125:1: ruleAttack : ( ( rule__Attack__Group__0 ) ) ;
    public final void ruleAttack() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalSecLanguage.g:129:2: ( ( ( rule__Attack__Group__0 ) ) )
            // InternalSecLanguage.g:130:1: ( ( rule__Attack__Group__0 ) )
            {
            // InternalSecLanguage.g:130:1: ( ( rule__Attack__Group__0 ) )
            // InternalSecLanguage.g:131:1: ( rule__Attack__Group__0 )
            {
             before(grammarAccess.getAttackAccess().getGroup()); 
            // InternalSecLanguage.g:132:1: ( rule__Attack__Group__0 )
            // InternalSecLanguage.g:132:2: rule__Attack__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Attack__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getAttackAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleAttack"


    // $ANTLR start "entryRuleEString"
    // InternalSecLanguage.g:144:1: entryRuleEString : ruleEString EOF ;
    public final void entryRuleEString() throws RecognitionException {
        try {
            // InternalSecLanguage.g:145:1: ( ruleEString EOF )
            // InternalSecLanguage.g:146:1: ruleEString EOF
            {
             before(grammarAccess.getEStringRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getEStringRule()); 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleEString"


    // $ANTLR start "ruleEString"
    // InternalSecLanguage.g:153:1: ruleEString : ( ( rule__EString__Alternatives ) ) ;
    public final void ruleEString() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalSecLanguage.g:157:2: ( ( ( rule__EString__Alternatives ) ) )
            // InternalSecLanguage.g:158:1: ( ( rule__EString__Alternatives ) )
            {
            // InternalSecLanguage.g:158:1: ( ( rule__EString__Alternatives ) )
            // InternalSecLanguage.g:159:1: ( rule__EString__Alternatives )
            {
             before(grammarAccess.getEStringAccess().getAlternatives()); 
            // InternalSecLanguage.g:160:1: ( rule__EString__Alternatives )
            // InternalSecLanguage.g:160:2: rule__EString__Alternatives
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__EString__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getEStringAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleEString"


    // $ANTLR start "entryRuleWebComponent"
    // InternalSecLanguage.g:172:1: entryRuleWebComponent : ruleWebComponent EOF ;
    public final void entryRuleWebComponent() throws RecognitionException {
        try {
            // InternalSecLanguage.g:173:1: ( ruleWebComponent EOF )
            // InternalSecLanguage.g:174:1: ruleWebComponent EOF
            {
             before(grammarAccess.getWebComponentRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleWebComponent();

            state._fsp--;

             after(grammarAccess.getWebComponentRule()); 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleWebComponent"


    // $ANTLR start "ruleWebComponent"
    // InternalSecLanguage.g:181:1: ruleWebComponent : ( ( rule__WebComponent__Group__0 ) ) ;
    public final void ruleWebComponent() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalSecLanguage.g:185:2: ( ( ( rule__WebComponent__Group__0 ) ) )
            // InternalSecLanguage.g:186:1: ( ( rule__WebComponent__Group__0 ) )
            {
            // InternalSecLanguage.g:186:1: ( ( rule__WebComponent__Group__0 ) )
            // InternalSecLanguage.g:187:1: ( rule__WebComponent__Group__0 )
            {
             before(grammarAccess.getWebComponentAccess().getGroup()); 
            // InternalSecLanguage.g:188:1: ( rule__WebComponent__Group__0 )
            // InternalSecLanguage.g:188:2: rule__WebComponent__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__WebComponent__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getWebComponentAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleWebComponent"


    // $ANTLR start "entryRuleInput"
    // InternalSecLanguage.g:200:1: entryRuleInput : ruleInput EOF ;
    public final void entryRuleInput() throws RecognitionException {
        try {
            // InternalSecLanguage.g:201:1: ( ruleInput EOF )
            // InternalSecLanguage.g:202:1: ruleInput EOF
            {
             before(grammarAccess.getInputRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleInput();

            state._fsp--;

             after(grammarAccess.getInputRule()); 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleInput"


    // $ANTLR start "ruleInput"
    // InternalSecLanguage.g:209:1: ruleInput : ( ( rule__Input__Group__0 ) ) ;
    public final void ruleInput() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalSecLanguage.g:213:2: ( ( ( rule__Input__Group__0 ) ) )
            // InternalSecLanguage.g:214:1: ( ( rule__Input__Group__0 ) )
            {
            // InternalSecLanguage.g:214:1: ( ( rule__Input__Group__0 ) )
            // InternalSecLanguage.g:215:1: ( rule__Input__Group__0 )
            {
             before(grammarAccess.getInputAccess().getGroup()); 
            // InternalSecLanguage.g:216:1: ( rule__Input__Group__0 )
            // InternalSecLanguage.g:216:2: rule__Input__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Input__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getInputAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleInput"


    // $ANTLR start "ruleESeverity"
    // InternalSecLanguage.g:229:1: ruleESeverity : ( ( rule__ESeverity__Alternatives ) ) ;
    public final void ruleESeverity() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalSecLanguage.g:233:1: ( ( ( rule__ESeverity__Alternatives ) ) )
            // InternalSecLanguage.g:234:1: ( ( rule__ESeverity__Alternatives ) )
            {
            // InternalSecLanguage.g:234:1: ( ( rule__ESeverity__Alternatives ) )
            // InternalSecLanguage.g:235:1: ( rule__ESeverity__Alternatives )
            {
             before(grammarAccess.getESeverityAccess().getAlternatives()); 
            // InternalSecLanguage.g:236:1: ( rule__ESeverity__Alternatives )
            // InternalSecLanguage.g:236:2: rule__ESeverity__Alternatives
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__ESeverity__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getESeverityAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleESeverity"


    // $ANTLR start "ruleEAttackMethod"
    // InternalSecLanguage.g:248:1: ruleEAttackMethod : ( ( rule__EAttackMethod__Alternatives ) ) ;
    public final void ruleEAttackMethod() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalSecLanguage.g:252:1: ( ( ( rule__EAttackMethod__Alternatives ) ) )
            // InternalSecLanguage.g:253:1: ( ( rule__EAttackMethod__Alternatives ) )
            {
            // InternalSecLanguage.g:253:1: ( ( rule__EAttackMethod__Alternatives ) )
            // InternalSecLanguage.g:254:1: ( rule__EAttackMethod__Alternatives )
            {
             before(grammarAccess.getEAttackMethodAccess().getAlternatives()); 
            // InternalSecLanguage.g:255:1: ( rule__EAttackMethod__Alternatives )
            // InternalSecLanguage.g:255:2: rule__EAttackMethod__Alternatives
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__EAttackMethod__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getEAttackMethodAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleEAttackMethod"


    // $ANTLR start "rule__EString__Alternatives"
    // InternalSecLanguage.g:266:1: rule__EString__Alternatives : ( ( RULE_STRING ) | ( RULE_ID ) );
    public final void rule__EString__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalSecLanguage.g:270:1: ( ( RULE_STRING ) | ( RULE_ID ) )
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==RULE_STRING) ) {
                alt1=1;
            }
            else if ( (LA1_0==RULE_ID) ) {
                alt1=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }
            switch (alt1) {
                case 1 :
                    // InternalSecLanguage.g:271:1: ( RULE_STRING )
                    {
                    // InternalSecLanguage.g:271:1: ( RULE_STRING )
                    // InternalSecLanguage.g:272:1: RULE_STRING
                    {
                     before(grammarAccess.getEStringAccess().getSTRINGTerminalRuleCall_0()); 
                    match(input,RULE_STRING,FollowSets000.FOLLOW_2); 
                     after(grammarAccess.getEStringAccess().getSTRINGTerminalRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalSecLanguage.g:277:6: ( RULE_ID )
                    {
                    // InternalSecLanguage.g:277:6: ( RULE_ID )
                    // InternalSecLanguage.g:278:1: RULE_ID
                    {
                     before(grammarAccess.getEStringAccess().getIDTerminalRuleCall_1()); 
                    match(input,RULE_ID,FollowSets000.FOLLOW_2); 
                     after(grammarAccess.getEStringAccess().getIDTerminalRuleCall_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EString__Alternatives"


    // $ANTLR start "rule__ESeverity__Alternatives"
    // InternalSecLanguage.g:288:1: rule__ESeverity__Alternatives : ( ( ( 'Low' ) ) | ( ( 'Medium' ) ) | ( ( 'High' ) ) );
    public final void rule__ESeverity__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalSecLanguage.g:292:1: ( ( ( 'Low' ) ) | ( ( 'Medium' ) ) | ( ( 'High' ) ) )
            int alt2=3;
            switch ( input.LA(1) ) {
            case 11:
                {
                alt2=1;
                }
                break;
            case 12:
                {
                alt2=2;
                }
                break;
            case 13:
                {
                alt2=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }

            switch (alt2) {
                case 1 :
                    // InternalSecLanguage.g:293:1: ( ( 'Low' ) )
                    {
                    // InternalSecLanguage.g:293:1: ( ( 'Low' ) )
                    // InternalSecLanguage.g:294:1: ( 'Low' )
                    {
                     before(grammarAccess.getESeverityAccess().getLowEnumLiteralDeclaration_0()); 
                    // InternalSecLanguage.g:295:1: ( 'Low' )
                    // InternalSecLanguage.g:295:3: 'Low'
                    {
                    match(input,11,FollowSets000.FOLLOW_2); 

                    }

                     after(grammarAccess.getESeverityAccess().getLowEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalSecLanguage.g:300:6: ( ( 'Medium' ) )
                    {
                    // InternalSecLanguage.g:300:6: ( ( 'Medium' ) )
                    // InternalSecLanguage.g:301:1: ( 'Medium' )
                    {
                     before(grammarAccess.getESeverityAccess().getMediumEnumLiteralDeclaration_1()); 
                    // InternalSecLanguage.g:302:1: ( 'Medium' )
                    // InternalSecLanguage.g:302:3: 'Medium'
                    {
                    match(input,12,FollowSets000.FOLLOW_2); 

                    }

                     after(grammarAccess.getESeverityAccess().getMediumEnumLiteralDeclaration_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalSecLanguage.g:307:6: ( ( 'High' ) )
                    {
                    // InternalSecLanguage.g:307:6: ( ( 'High' ) )
                    // InternalSecLanguage.g:308:1: ( 'High' )
                    {
                     before(grammarAccess.getESeverityAccess().getHighEnumLiteralDeclaration_2()); 
                    // InternalSecLanguage.g:309:1: ( 'High' )
                    // InternalSecLanguage.g:309:3: 'High'
                    {
                    match(input,13,FollowSets000.FOLLOW_2); 

                    }

                     after(grammarAccess.getESeverityAccess().getHighEnumLiteralDeclaration_2()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ESeverity__Alternatives"


    // $ANTLR start "rule__EAttackMethod__Alternatives"
    // InternalSecLanguage.g:319:1: rule__EAttackMethod__Alternatives : ( ( ( 'SQLInjection' ) ) | ( ( 'XSS' ) ) | ( ( 'Authentication' ) ) | ( ( 'Authorization' ) ) | ( ( 'PrivilegeScalation' ) ) );
    public final void rule__EAttackMethod__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalSecLanguage.g:323:1: ( ( ( 'SQLInjection' ) ) | ( ( 'XSS' ) ) | ( ( 'Authentication' ) ) | ( ( 'Authorization' ) ) | ( ( 'PrivilegeScalation' ) ) )
            int alt3=5;
            switch ( input.LA(1) ) {
            case 14:
                {
                alt3=1;
                }
                break;
            case 15:
                {
                alt3=2;
                }
                break;
            case 16:
                {
                alt3=3;
                }
                break;
            case 17:
                {
                alt3=4;
                }
                break;
            case 18:
                {
                alt3=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }

            switch (alt3) {
                case 1 :
                    // InternalSecLanguage.g:324:1: ( ( 'SQLInjection' ) )
                    {
                    // InternalSecLanguage.g:324:1: ( ( 'SQLInjection' ) )
                    // InternalSecLanguage.g:325:1: ( 'SQLInjection' )
                    {
                     before(grammarAccess.getEAttackMethodAccess().getSQLInjectionEnumLiteralDeclaration_0()); 
                    // InternalSecLanguage.g:326:1: ( 'SQLInjection' )
                    // InternalSecLanguage.g:326:3: 'SQLInjection'
                    {
                    match(input,14,FollowSets000.FOLLOW_2); 

                    }

                     after(grammarAccess.getEAttackMethodAccess().getSQLInjectionEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalSecLanguage.g:331:6: ( ( 'XSS' ) )
                    {
                    // InternalSecLanguage.g:331:6: ( ( 'XSS' ) )
                    // InternalSecLanguage.g:332:1: ( 'XSS' )
                    {
                     before(grammarAccess.getEAttackMethodAccess().getXSSEnumLiteralDeclaration_1()); 
                    // InternalSecLanguage.g:333:1: ( 'XSS' )
                    // InternalSecLanguage.g:333:3: 'XSS'
                    {
                    match(input,15,FollowSets000.FOLLOW_2); 

                    }

                     after(grammarAccess.getEAttackMethodAccess().getXSSEnumLiteralDeclaration_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalSecLanguage.g:338:6: ( ( 'Authentication' ) )
                    {
                    // InternalSecLanguage.g:338:6: ( ( 'Authentication' ) )
                    // InternalSecLanguage.g:339:1: ( 'Authentication' )
                    {
                     before(grammarAccess.getEAttackMethodAccess().getAuthenticationEnumLiteralDeclaration_2()); 
                    // InternalSecLanguage.g:340:1: ( 'Authentication' )
                    // InternalSecLanguage.g:340:3: 'Authentication'
                    {
                    match(input,16,FollowSets000.FOLLOW_2); 

                    }

                     after(grammarAccess.getEAttackMethodAccess().getAuthenticationEnumLiteralDeclaration_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalSecLanguage.g:345:6: ( ( 'Authorization' ) )
                    {
                    // InternalSecLanguage.g:345:6: ( ( 'Authorization' ) )
                    // InternalSecLanguage.g:346:1: ( 'Authorization' )
                    {
                     before(grammarAccess.getEAttackMethodAccess().getAuthorizationEnumLiteralDeclaration_3()); 
                    // InternalSecLanguage.g:347:1: ( 'Authorization' )
                    // InternalSecLanguage.g:347:3: 'Authorization'
                    {
                    match(input,17,FollowSets000.FOLLOW_2); 

                    }

                     after(grammarAccess.getEAttackMethodAccess().getAuthorizationEnumLiteralDeclaration_3()); 

                    }


                    }
                    break;
                case 5 :
                    // InternalSecLanguage.g:352:6: ( ( 'PrivilegeScalation' ) )
                    {
                    // InternalSecLanguage.g:352:6: ( ( 'PrivilegeScalation' ) )
                    // InternalSecLanguage.g:353:1: ( 'PrivilegeScalation' )
                    {
                     before(grammarAccess.getEAttackMethodAccess().getPrivilegeScalationEnumLiteralDeclaration_4()); 
                    // InternalSecLanguage.g:354:1: ( 'PrivilegeScalation' )
                    // InternalSecLanguage.g:354:3: 'PrivilegeScalation'
                    {
                    match(input,18,FollowSets000.FOLLOW_2); 

                    }

                     after(grammarAccess.getEAttackMethodAccess().getPrivilegeScalationEnumLiteralDeclaration_4()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EAttackMethod__Alternatives"


    // $ANTLR start "rule__SecurityTest__Group__0"
    // InternalSecLanguage.g:366:1: rule__SecurityTest__Group__0 : rule__SecurityTest__Group__0__Impl rule__SecurityTest__Group__1 ;
    public final void rule__SecurityTest__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalSecLanguage.g:370:1: ( rule__SecurityTest__Group__0__Impl rule__SecurityTest__Group__1 )
            // InternalSecLanguage.g:371:2: rule__SecurityTest__Group__0__Impl rule__SecurityTest__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_3);
            rule__SecurityTest__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__SecurityTest__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SecurityTest__Group__0"


    // $ANTLR start "rule__SecurityTest__Group__0__Impl"
    // InternalSecLanguage.g:378:1: rule__SecurityTest__Group__0__Impl : ( () ) ;
    public final void rule__SecurityTest__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalSecLanguage.g:382:1: ( ( () ) )
            // InternalSecLanguage.g:383:1: ( () )
            {
            // InternalSecLanguage.g:383:1: ( () )
            // InternalSecLanguage.g:384:1: ()
            {
             before(grammarAccess.getSecurityTestAccess().getTestAction_0()); 
            // InternalSecLanguage.g:385:1: ()
            // InternalSecLanguage.g:387:1: 
            {
            }

             after(grammarAccess.getSecurityTestAccess().getTestAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SecurityTest__Group__0__Impl"


    // $ANTLR start "rule__SecurityTest__Group__1"
    // InternalSecLanguage.g:397:1: rule__SecurityTest__Group__1 : rule__SecurityTest__Group__1__Impl rule__SecurityTest__Group__2 ;
    public final void rule__SecurityTest__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalSecLanguage.g:401:1: ( rule__SecurityTest__Group__1__Impl rule__SecurityTest__Group__2 )
            // InternalSecLanguage.g:402:2: rule__SecurityTest__Group__1__Impl rule__SecurityTest__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_4);
            rule__SecurityTest__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__SecurityTest__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SecurityTest__Group__1"


    // $ANTLR start "rule__SecurityTest__Group__1__Impl"
    // InternalSecLanguage.g:409:1: rule__SecurityTest__Group__1__Impl : ( '(' ) ;
    public final void rule__SecurityTest__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalSecLanguage.g:413:1: ( ( '(' ) )
            // InternalSecLanguage.g:414:1: ( '(' )
            {
            // InternalSecLanguage.g:414:1: ( '(' )
            // InternalSecLanguage.g:415:1: '('
            {
             before(grammarAccess.getSecurityTestAccess().getLeftParenthesisKeyword_1()); 
            match(input,19,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getSecurityTestAccess().getLeftParenthesisKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SecurityTest__Group__1__Impl"


    // $ANTLR start "rule__SecurityTest__Group__2"
    // InternalSecLanguage.g:428:1: rule__SecurityTest__Group__2 : rule__SecurityTest__Group__2__Impl rule__SecurityTest__Group__3 ;
    public final void rule__SecurityTest__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalSecLanguage.g:432:1: ( rule__SecurityTest__Group__2__Impl rule__SecurityTest__Group__3 )
            // InternalSecLanguage.g:433:2: rule__SecurityTest__Group__2__Impl rule__SecurityTest__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_5);
            rule__SecurityTest__Group__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__SecurityTest__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SecurityTest__Group__2"


    // $ANTLR start "rule__SecurityTest__Group__2__Impl"
    // InternalSecLanguage.g:440:1: rule__SecurityTest__Group__2__Impl : ( 'securityTest' ) ;
    public final void rule__SecurityTest__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalSecLanguage.g:444:1: ( ( 'securityTest' ) )
            // InternalSecLanguage.g:445:1: ( 'securityTest' )
            {
            // InternalSecLanguage.g:445:1: ( 'securityTest' )
            // InternalSecLanguage.g:446:1: 'securityTest'
            {
             before(grammarAccess.getSecurityTestAccess().getSecurityTestKeyword_2()); 
            match(input,20,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getSecurityTestAccess().getSecurityTestKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SecurityTest__Group__2__Impl"


    // $ANTLR start "rule__SecurityTest__Group__3"
    // InternalSecLanguage.g:459:1: rule__SecurityTest__Group__3 : rule__SecurityTest__Group__3__Impl rule__SecurityTest__Group__4 ;
    public final void rule__SecurityTest__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalSecLanguage.g:463:1: ( rule__SecurityTest__Group__3__Impl rule__SecurityTest__Group__4 )
            // InternalSecLanguage.g:464:2: rule__SecurityTest__Group__3__Impl rule__SecurityTest__Group__4
            {
            pushFollow(FollowSets000.FOLLOW_6);
            rule__SecurityTest__Group__3__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__SecurityTest__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SecurityTest__Group__3"


    // $ANTLR start "rule__SecurityTest__Group__3__Impl"
    // InternalSecLanguage.g:471:1: rule__SecurityTest__Group__3__Impl : ( ( rule__SecurityTest__IdAssignment_3 ) ) ;
    public final void rule__SecurityTest__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalSecLanguage.g:475:1: ( ( ( rule__SecurityTest__IdAssignment_3 ) ) )
            // InternalSecLanguage.g:476:1: ( ( rule__SecurityTest__IdAssignment_3 ) )
            {
            // InternalSecLanguage.g:476:1: ( ( rule__SecurityTest__IdAssignment_3 ) )
            // InternalSecLanguage.g:477:1: ( rule__SecurityTest__IdAssignment_3 )
            {
             before(grammarAccess.getSecurityTestAccess().getIdAssignment_3()); 
            // InternalSecLanguage.g:478:1: ( rule__SecurityTest__IdAssignment_3 )
            // InternalSecLanguage.g:478:2: rule__SecurityTest__IdAssignment_3
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__SecurityTest__IdAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getSecurityTestAccess().getIdAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SecurityTest__Group__3__Impl"


    // $ANTLR start "rule__SecurityTest__Group__4"
    // InternalSecLanguage.g:488:1: rule__SecurityTest__Group__4 : rule__SecurityTest__Group__4__Impl rule__SecurityTest__Group__5 ;
    public final void rule__SecurityTest__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalSecLanguage.g:492:1: ( rule__SecurityTest__Group__4__Impl rule__SecurityTest__Group__5 )
            // InternalSecLanguage.g:493:2: rule__SecurityTest__Group__4__Impl rule__SecurityTest__Group__5
            {
            pushFollow(FollowSets000.FOLLOW_6);
            rule__SecurityTest__Group__4__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__SecurityTest__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SecurityTest__Group__4"


    // $ANTLR start "rule__SecurityTest__Group__4__Impl"
    // InternalSecLanguage.g:500:1: rule__SecurityTest__Group__4__Impl : ( ( rule__SecurityTest__Group_4__0 )? ) ;
    public final void rule__SecurityTest__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalSecLanguage.g:504:1: ( ( ( rule__SecurityTest__Group_4__0 )? ) )
            // InternalSecLanguage.g:505:1: ( ( rule__SecurityTest__Group_4__0 )? )
            {
            // InternalSecLanguage.g:505:1: ( ( rule__SecurityTest__Group_4__0 )? )
            // InternalSecLanguage.g:506:1: ( rule__SecurityTest__Group_4__0 )?
            {
             before(grammarAccess.getSecurityTestAccess().getGroup_4()); 
            // InternalSecLanguage.g:507:1: ( rule__SecurityTest__Group_4__0 )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==19) ) {
                int LA4_1 = input.LA(2);

                if ( (LA4_1==22) ) {
                    alt4=1;
                }
            }
            switch (alt4) {
                case 1 :
                    // InternalSecLanguage.g:507:2: rule__SecurityTest__Group_4__0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__SecurityTest__Group_4__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getSecurityTestAccess().getGroup_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SecurityTest__Group__4__Impl"


    // $ANTLR start "rule__SecurityTest__Group__5"
    // InternalSecLanguage.g:517:1: rule__SecurityTest__Group__5 : rule__SecurityTest__Group__5__Impl rule__SecurityTest__Group__6 ;
    public final void rule__SecurityTest__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalSecLanguage.g:521:1: ( rule__SecurityTest__Group__5__Impl rule__SecurityTest__Group__6 )
            // InternalSecLanguage.g:522:2: rule__SecurityTest__Group__5__Impl rule__SecurityTest__Group__6
            {
            pushFollow(FollowSets000.FOLLOW_6);
            rule__SecurityTest__Group__5__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__SecurityTest__Group__6();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SecurityTest__Group__5"


    // $ANTLR start "rule__SecurityTest__Group__5__Impl"
    // InternalSecLanguage.g:529:1: rule__SecurityTest__Group__5__Impl : ( ( rule__SecurityTest__Group_5__0 )? ) ;
    public final void rule__SecurityTest__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalSecLanguage.g:533:1: ( ( ( rule__SecurityTest__Group_5__0 )? ) )
            // InternalSecLanguage.g:534:1: ( ( rule__SecurityTest__Group_5__0 )? )
            {
            // InternalSecLanguage.g:534:1: ( ( rule__SecurityTest__Group_5__0 )? )
            // InternalSecLanguage.g:535:1: ( rule__SecurityTest__Group_5__0 )?
            {
             before(grammarAccess.getSecurityTestAccess().getGroup_5()); 
            // InternalSecLanguage.g:536:1: ( rule__SecurityTest__Group_5__0 )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==19) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // InternalSecLanguage.g:536:2: rule__SecurityTest__Group_5__0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__SecurityTest__Group_5__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getSecurityTestAccess().getGroup_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SecurityTest__Group__5__Impl"


    // $ANTLR start "rule__SecurityTest__Group__6"
    // InternalSecLanguage.g:546:1: rule__SecurityTest__Group__6 : rule__SecurityTest__Group__6__Impl ;
    public final void rule__SecurityTest__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalSecLanguage.g:550:1: ( rule__SecurityTest__Group__6__Impl )
            // InternalSecLanguage.g:551:2: rule__SecurityTest__Group__6__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__SecurityTest__Group__6__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SecurityTest__Group__6"


    // $ANTLR start "rule__SecurityTest__Group__6__Impl"
    // InternalSecLanguage.g:557:1: rule__SecurityTest__Group__6__Impl : ( ')' ) ;
    public final void rule__SecurityTest__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalSecLanguage.g:561:1: ( ( ')' ) )
            // InternalSecLanguage.g:562:1: ( ')' )
            {
            // InternalSecLanguage.g:562:1: ( ')' )
            // InternalSecLanguage.g:563:1: ')'
            {
             before(grammarAccess.getSecurityTestAccess().getRightParenthesisKeyword_6()); 
            match(input,21,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getSecurityTestAccess().getRightParenthesisKeyword_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SecurityTest__Group__6__Impl"


    // $ANTLR start "rule__SecurityTest__Group_4__0"
    // InternalSecLanguage.g:590:1: rule__SecurityTest__Group_4__0 : rule__SecurityTest__Group_4__0__Impl rule__SecurityTest__Group_4__1 ;
    public final void rule__SecurityTest__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalSecLanguage.g:594:1: ( rule__SecurityTest__Group_4__0__Impl rule__SecurityTest__Group_4__1 )
            // InternalSecLanguage.g:595:2: rule__SecurityTest__Group_4__0__Impl rule__SecurityTest__Group_4__1
            {
            pushFollow(FollowSets000.FOLLOW_7);
            rule__SecurityTest__Group_4__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__SecurityTest__Group_4__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SecurityTest__Group_4__0"


    // $ANTLR start "rule__SecurityTest__Group_4__0__Impl"
    // InternalSecLanguage.g:602:1: rule__SecurityTest__Group_4__0__Impl : ( '(' ) ;
    public final void rule__SecurityTest__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalSecLanguage.g:606:1: ( ( '(' ) )
            // InternalSecLanguage.g:607:1: ( '(' )
            {
            // InternalSecLanguage.g:607:1: ( '(' )
            // InternalSecLanguage.g:608:1: '('
            {
             before(grammarAccess.getSecurityTestAccess().getLeftParenthesisKeyword_4_0()); 
            match(input,19,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getSecurityTestAccess().getLeftParenthesisKeyword_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SecurityTest__Group_4__0__Impl"


    // $ANTLR start "rule__SecurityTest__Group_4__1"
    // InternalSecLanguage.g:621:1: rule__SecurityTest__Group_4__1 : rule__SecurityTest__Group_4__1__Impl rule__SecurityTest__Group_4__2 ;
    public final void rule__SecurityTest__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalSecLanguage.g:625:1: ( rule__SecurityTest__Group_4__1__Impl rule__SecurityTest__Group_4__2 )
            // InternalSecLanguage.g:626:2: rule__SecurityTest__Group_4__1__Impl rule__SecurityTest__Group_4__2
            {
            pushFollow(FollowSets000.FOLLOW_3);
            rule__SecurityTest__Group_4__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__SecurityTest__Group_4__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SecurityTest__Group_4__1"


    // $ANTLR start "rule__SecurityTest__Group_4__1__Impl"
    // InternalSecLanguage.g:633:1: rule__SecurityTest__Group_4__1__Impl : ( 'toes' ) ;
    public final void rule__SecurityTest__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalSecLanguage.g:637:1: ( ( 'toes' ) )
            // InternalSecLanguage.g:638:1: ( 'toes' )
            {
            // InternalSecLanguage.g:638:1: ( 'toes' )
            // InternalSecLanguage.g:639:1: 'toes'
            {
             before(grammarAccess.getSecurityTestAccess().getToesKeyword_4_1()); 
            match(input,22,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getSecurityTestAccess().getToesKeyword_4_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SecurityTest__Group_4__1__Impl"


    // $ANTLR start "rule__SecurityTest__Group_4__2"
    // InternalSecLanguage.g:652:1: rule__SecurityTest__Group_4__2 : rule__SecurityTest__Group_4__2__Impl rule__SecurityTest__Group_4__3 ;
    public final void rule__SecurityTest__Group_4__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalSecLanguage.g:656:1: ( rule__SecurityTest__Group_4__2__Impl rule__SecurityTest__Group_4__3 )
            // InternalSecLanguage.g:657:2: rule__SecurityTest__Group_4__2__Impl rule__SecurityTest__Group_4__3
            {
            pushFollow(FollowSets000.FOLLOW_8);
            rule__SecurityTest__Group_4__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__SecurityTest__Group_4__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SecurityTest__Group_4__2"


    // $ANTLR start "rule__SecurityTest__Group_4__2__Impl"
    // InternalSecLanguage.g:664:1: rule__SecurityTest__Group_4__2__Impl : ( ( rule__SecurityTest__ScopeAssignment_4_2 ) ) ;
    public final void rule__SecurityTest__Group_4__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalSecLanguage.g:668:1: ( ( ( rule__SecurityTest__ScopeAssignment_4_2 ) ) )
            // InternalSecLanguage.g:669:1: ( ( rule__SecurityTest__ScopeAssignment_4_2 ) )
            {
            // InternalSecLanguage.g:669:1: ( ( rule__SecurityTest__ScopeAssignment_4_2 ) )
            // InternalSecLanguage.g:670:1: ( rule__SecurityTest__ScopeAssignment_4_2 )
            {
             before(grammarAccess.getSecurityTestAccess().getScopeAssignment_4_2()); 
            // InternalSecLanguage.g:671:1: ( rule__SecurityTest__ScopeAssignment_4_2 )
            // InternalSecLanguage.g:671:2: rule__SecurityTest__ScopeAssignment_4_2
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__SecurityTest__ScopeAssignment_4_2();

            state._fsp--;


            }

             after(grammarAccess.getSecurityTestAccess().getScopeAssignment_4_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SecurityTest__Group_4__2__Impl"


    // $ANTLR start "rule__SecurityTest__Group_4__3"
    // InternalSecLanguage.g:681:1: rule__SecurityTest__Group_4__3 : rule__SecurityTest__Group_4__3__Impl ;
    public final void rule__SecurityTest__Group_4__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalSecLanguage.g:685:1: ( rule__SecurityTest__Group_4__3__Impl )
            // InternalSecLanguage.g:686:2: rule__SecurityTest__Group_4__3__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__SecurityTest__Group_4__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SecurityTest__Group_4__3"


    // $ANTLR start "rule__SecurityTest__Group_4__3__Impl"
    // InternalSecLanguage.g:692:1: rule__SecurityTest__Group_4__3__Impl : ( ')' ) ;
    public final void rule__SecurityTest__Group_4__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalSecLanguage.g:696:1: ( ( ')' ) )
            // InternalSecLanguage.g:697:1: ( ')' )
            {
            // InternalSecLanguage.g:697:1: ( ')' )
            // InternalSecLanguage.g:698:1: ')'
            {
             before(grammarAccess.getSecurityTestAccess().getRightParenthesisKeyword_4_3()); 
            match(input,21,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getSecurityTestAccess().getRightParenthesisKeyword_4_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SecurityTest__Group_4__3__Impl"


    // $ANTLR start "rule__SecurityTest__Group_5__0"
    // InternalSecLanguage.g:719:1: rule__SecurityTest__Group_5__0 : rule__SecurityTest__Group_5__0__Impl rule__SecurityTest__Group_5__1 ;
    public final void rule__SecurityTest__Group_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalSecLanguage.g:723:1: ( rule__SecurityTest__Group_5__0__Impl rule__SecurityTest__Group_5__1 )
            // InternalSecLanguage.g:724:2: rule__SecurityTest__Group_5__0__Impl rule__SecurityTest__Group_5__1
            {
            pushFollow(FollowSets000.FOLLOW_9);
            rule__SecurityTest__Group_5__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__SecurityTest__Group_5__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SecurityTest__Group_5__0"


    // $ANTLR start "rule__SecurityTest__Group_5__0__Impl"
    // InternalSecLanguage.g:731:1: rule__SecurityTest__Group_5__0__Impl : ( '(' ) ;
    public final void rule__SecurityTest__Group_5__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalSecLanguage.g:735:1: ( ( '(' ) )
            // InternalSecLanguage.g:736:1: ( '(' )
            {
            // InternalSecLanguage.g:736:1: ( '(' )
            // InternalSecLanguage.g:737:1: '('
            {
             before(grammarAccess.getSecurityTestAccess().getLeftParenthesisKeyword_5_0()); 
            match(input,19,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getSecurityTestAccess().getLeftParenthesisKeyword_5_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SecurityTest__Group_5__0__Impl"


    // $ANTLR start "rule__SecurityTest__Group_5__1"
    // InternalSecLanguage.g:750:1: rule__SecurityTest__Group_5__1 : rule__SecurityTest__Group_5__1__Impl rule__SecurityTest__Group_5__2 ;
    public final void rule__SecurityTest__Group_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalSecLanguage.g:754:1: ( rule__SecurityTest__Group_5__1__Impl rule__SecurityTest__Group_5__2 )
            // InternalSecLanguage.g:755:2: rule__SecurityTest__Group_5__1__Impl rule__SecurityTest__Group_5__2
            {
            pushFollow(FollowSets000.FOLLOW_3);
            rule__SecurityTest__Group_5__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__SecurityTest__Group_5__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SecurityTest__Group_5__1"


    // $ANTLR start "rule__SecurityTest__Group_5__1__Impl"
    // InternalSecLanguage.g:762:1: rule__SecurityTest__Group_5__1__Impl : ( 'attacks' ) ;
    public final void rule__SecurityTest__Group_5__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalSecLanguage.g:766:1: ( ( 'attacks' ) )
            // InternalSecLanguage.g:767:1: ( 'attacks' )
            {
            // InternalSecLanguage.g:767:1: ( 'attacks' )
            // InternalSecLanguage.g:768:1: 'attacks'
            {
             before(grammarAccess.getSecurityTestAccess().getAttacksKeyword_5_1()); 
            match(input,23,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getSecurityTestAccess().getAttacksKeyword_5_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SecurityTest__Group_5__1__Impl"


    // $ANTLR start "rule__SecurityTest__Group_5__2"
    // InternalSecLanguage.g:781:1: rule__SecurityTest__Group_5__2 : rule__SecurityTest__Group_5__2__Impl rule__SecurityTest__Group_5__3 ;
    public final void rule__SecurityTest__Group_5__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalSecLanguage.g:785:1: ( rule__SecurityTest__Group_5__2__Impl rule__SecurityTest__Group_5__3 )
            // InternalSecLanguage.g:786:2: rule__SecurityTest__Group_5__2__Impl rule__SecurityTest__Group_5__3
            {
            pushFollow(FollowSets000.FOLLOW_8);
            rule__SecurityTest__Group_5__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__SecurityTest__Group_5__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SecurityTest__Group_5__2"


    // $ANTLR start "rule__SecurityTest__Group_5__2__Impl"
    // InternalSecLanguage.g:793:1: rule__SecurityTest__Group_5__2__Impl : ( ( ( rule__SecurityTest__PossibleAttacksAssignment_5_2 ) ) ( ( rule__SecurityTest__PossibleAttacksAssignment_5_2 )* ) ) ;
    public final void rule__SecurityTest__Group_5__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalSecLanguage.g:797:1: ( ( ( ( rule__SecurityTest__PossibleAttacksAssignment_5_2 ) ) ( ( rule__SecurityTest__PossibleAttacksAssignment_5_2 )* ) ) )
            // InternalSecLanguage.g:798:1: ( ( ( rule__SecurityTest__PossibleAttacksAssignment_5_2 ) ) ( ( rule__SecurityTest__PossibleAttacksAssignment_5_2 )* ) )
            {
            // InternalSecLanguage.g:798:1: ( ( ( rule__SecurityTest__PossibleAttacksAssignment_5_2 ) ) ( ( rule__SecurityTest__PossibleAttacksAssignment_5_2 )* ) )
            // InternalSecLanguage.g:799:1: ( ( rule__SecurityTest__PossibleAttacksAssignment_5_2 ) ) ( ( rule__SecurityTest__PossibleAttacksAssignment_5_2 )* )
            {
            // InternalSecLanguage.g:799:1: ( ( rule__SecurityTest__PossibleAttacksAssignment_5_2 ) )
            // InternalSecLanguage.g:800:1: ( rule__SecurityTest__PossibleAttacksAssignment_5_2 )
            {
             before(grammarAccess.getSecurityTestAccess().getPossibleAttacksAssignment_5_2()); 
            // InternalSecLanguage.g:801:1: ( rule__SecurityTest__PossibleAttacksAssignment_5_2 )
            // InternalSecLanguage.g:801:2: rule__SecurityTest__PossibleAttacksAssignment_5_2
            {
            pushFollow(FollowSets000.FOLLOW_10);
            rule__SecurityTest__PossibleAttacksAssignment_5_2();

            state._fsp--;


            }

             after(grammarAccess.getSecurityTestAccess().getPossibleAttacksAssignment_5_2()); 

            }

            // InternalSecLanguage.g:804:1: ( ( rule__SecurityTest__PossibleAttacksAssignment_5_2 )* )
            // InternalSecLanguage.g:805:1: ( rule__SecurityTest__PossibleAttacksAssignment_5_2 )*
            {
             before(grammarAccess.getSecurityTestAccess().getPossibleAttacksAssignment_5_2()); 
            // InternalSecLanguage.g:806:1: ( rule__SecurityTest__PossibleAttacksAssignment_5_2 )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==19) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // InternalSecLanguage.g:806:2: rule__SecurityTest__PossibleAttacksAssignment_5_2
            	    {
            	    pushFollow(FollowSets000.FOLLOW_10);
            	    rule__SecurityTest__PossibleAttacksAssignment_5_2();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);

             after(grammarAccess.getSecurityTestAccess().getPossibleAttacksAssignment_5_2()); 

            }


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SecurityTest__Group_5__2__Impl"


    // $ANTLR start "rule__SecurityTest__Group_5__3"
    // InternalSecLanguage.g:817:1: rule__SecurityTest__Group_5__3 : rule__SecurityTest__Group_5__3__Impl ;
    public final void rule__SecurityTest__Group_5__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalSecLanguage.g:821:1: ( rule__SecurityTest__Group_5__3__Impl )
            // InternalSecLanguage.g:822:2: rule__SecurityTest__Group_5__3__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__SecurityTest__Group_5__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SecurityTest__Group_5__3"


    // $ANTLR start "rule__SecurityTest__Group_5__3__Impl"
    // InternalSecLanguage.g:828:1: rule__SecurityTest__Group_5__3__Impl : ( ')' ) ;
    public final void rule__SecurityTest__Group_5__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalSecLanguage.g:832:1: ( ( ')' ) )
            // InternalSecLanguage.g:833:1: ( ')' )
            {
            // InternalSecLanguage.g:833:1: ( ')' )
            // InternalSecLanguage.g:834:1: ')'
            {
             before(grammarAccess.getSecurityTestAccess().getRightParenthesisKeyword_5_3()); 
            match(input,21,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getSecurityTestAccess().getRightParenthesisKeyword_5_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SecurityTest__Group_5__3__Impl"


    // $ANTLR start "rule__TargetOfEvaluation__Group__0"
    // InternalSecLanguage.g:855:1: rule__TargetOfEvaluation__Group__0 : rule__TargetOfEvaluation__Group__0__Impl rule__TargetOfEvaluation__Group__1 ;
    public final void rule__TargetOfEvaluation__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalSecLanguage.g:859:1: ( rule__TargetOfEvaluation__Group__0__Impl rule__TargetOfEvaluation__Group__1 )
            // InternalSecLanguage.g:860:2: rule__TargetOfEvaluation__Group__0__Impl rule__TargetOfEvaluation__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_3);
            rule__TargetOfEvaluation__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__TargetOfEvaluation__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TargetOfEvaluation__Group__0"


    // $ANTLR start "rule__TargetOfEvaluation__Group__0__Impl"
    // InternalSecLanguage.g:867:1: rule__TargetOfEvaluation__Group__0__Impl : ( () ) ;
    public final void rule__TargetOfEvaluation__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalSecLanguage.g:871:1: ( ( () ) )
            // InternalSecLanguage.g:872:1: ( () )
            {
            // InternalSecLanguage.g:872:1: ( () )
            // InternalSecLanguage.g:873:1: ()
            {
             before(grammarAccess.getTargetOfEvaluationAccess().getTargetOfEvaluationAction_0()); 
            // InternalSecLanguage.g:874:1: ()
            // InternalSecLanguage.g:876:1: 
            {
            }

             after(grammarAccess.getTargetOfEvaluationAccess().getTargetOfEvaluationAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TargetOfEvaluation__Group__0__Impl"


    // $ANTLR start "rule__TargetOfEvaluation__Group__1"
    // InternalSecLanguage.g:886:1: rule__TargetOfEvaluation__Group__1 : rule__TargetOfEvaluation__Group__1__Impl rule__TargetOfEvaluation__Group__2 ;
    public final void rule__TargetOfEvaluation__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalSecLanguage.g:890:1: ( rule__TargetOfEvaluation__Group__1__Impl rule__TargetOfEvaluation__Group__2 )
            // InternalSecLanguage.g:891:2: rule__TargetOfEvaluation__Group__1__Impl rule__TargetOfEvaluation__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_11);
            rule__TargetOfEvaluation__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__TargetOfEvaluation__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TargetOfEvaluation__Group__1"


    // $ANTLR start "rule__TargetOfEvaluation__Group__1__Impl"
    // InternalSecLanguage.g:898:1: rule__TargetOfEvaluation__Group__1__Impl : ( '(' ) ;
    public final void rule__TargetOfEvaluation__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalSecLanguage.g:902:1: ( ( '(' ) )
            // InternalSecLanguage.g:903:1: ( '(' )
            {
            // InternalSecLanguage.g:903:1: ( '(' )
            // InternalSecLanguage.g:904:1: '('
            {
             before(grammarAccess.getTargetOfEvaluationAccess().getLeftParenthesisKeyword_1()); 
            match(input,19,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getTargetOfEvaluationAccess().getLeftParenthesisKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TargetOfEvaluation__Group__1__Impl"


    // $ANTLR start "rule__TargetOfEvaluation__Group__2"
    // InternalSecLanguage.g:917:1: rule__TargetOfEvaluation__Group__2 : rule__TargetOfEvaluation__Group__2__Impl rule__TargetOfEvaluation__Group__3 ;
    public final void rule__TargetOfEvaluation__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalSecLanguage.g:921:1: ( rule__TargetOfEvaluation__Group__2__Impl rule__TargetOfEvaluation__Group__3 )
            // InternalSecLanguage.g:922:2: rule__TargetOfEvaluation__Group__2__Impl rule__TargetOfEvaluation__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_8);
            rule__TargetOfEvaluation__Group__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__TargetOfEvaluation__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TargetOfEvaluation__Group__2"


    // $ANTLR start "rule__TargetOfEvaluation__Group__2__Impl"
    // InternalSecLanguage.g:929:1: rule__TargetOfEvaluation__Group__2__Impl : ( ( rule__TargetOfEvaluation__Group_2__0 ) ) ;
    public final void rule__TargetOfEvaluation__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalSecLanguage.g:933:1: ( ( ( rule__TargetOfEvaluation__Group_2__0 ) ) )
            // InternalSecLanguage.g:934:1: ( ( rule__TargetOfEvaluation__Group_2__0 ) )
            {
            // InternalSecLanguage.g:934:1: ( ( rule__TargetOfEvaluation__Group_2__0 ) )
            // InternalSecLanguage.g:935:1: ( rule__TargetOfEvaluation__Group_2__0 )
            {
             before(grammarAccess.getTargetOfEvaluationAccess().getGroup_2()); 
            // InternalSecLanguage.g:936:1: ( rule__TargetOfEvaluation__Group_2__0 )
            // InternalSecLanguage.g:936:2: rule__TargetOfEvaluation__Group_2__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__TargetOfEvaluation__Group_2__0();

            state._fsp--;


            }

             after(grammarAccess.getTargetOfEvaluationAccess().getGroup_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TargetOfEvaluation__Group__2__Impl"


    // $ANTLR start "rule__TargetOfEvaluation__Group__3"
    // InternalSecLanguage.g:946:1: rule__TargetOfEvaluation__Group__3 : rule__TargetOfEvaluation__Group__3__Impl ;
    public final void rule__TargetOfEvaluation__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalSecLanguage.g:950:1: ( rule__TargetOfEvaluation__Group__3__Impl )
            // InternalSecLanguage.g:951:2: rule__TargetOfEvaluation__Group__3__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__TargetOfEvaluation__Group__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TargetOfEvaluation__Group__3"


    // $ANTLR start "rule__TargetOfEvaluation__Group__3__Impl"
    // InternalSecLanguage.g:957:1: rule__TargetOfEvaluation__Group__3__Impl : ( ')' ) ;
    public final void rule__TargetOfEvaluation__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalSecLanguage.g:961:1: ( ( ')' ) )
            // InternalSecLanguage.g:962:1: ( ')' )
            {
            // InternalSecLanguage.g:962:1: ( ')' )
            // InternalSecLanguage.g:963:1: ')'
            {
             before(grammarAccess.getTargetOfEvaluationAccess().getRightParenthesisKeyword_3()); 
            match(input,21,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getTargetOfEvaluationAccess().getRightParenthesisKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TargetOfEvaluation__Group__3__Impl"


    // $ANTLR start "rule__TargetOfEvaluation__Group_2__0"
    // InternalSecLanguage.g:984:1: rule__TargetOfEvaluation__Group_2__0 : rule__TargetOfEvaluation__Group_2__0__Impl rule__TargetOfEvaluation__Group_2__1 ;
    public final void rule__TargetOfEvaluation__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalSecLanguage.g:988:1: ( rule__TargetOfEvaluation__Group_2__0__Impl rule__TargetOfEvaluation__Group_2__1 )
            // InternalSecLanguage.g:989:2: rule__TargetOfEvaluation__Group_2__0__Impl rule__TargetOfEvaluation__Group_2__1
            {
            pushFollow(FollowSets000.FOLLOW_5);
            rule__TargetOfEvaluation__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__TargetOfEvaluation__Group_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TargetOfEvaluation__Group_2__0"


    // $ANTLR start "rule__TargetOfEvaluation__Group_2__0__Impl"
    // InternalSecLanguage.g:996:1: rule__TargetOfEvaluation__Group_2__0__Impl : ( 'toe' ) ;
    public final void rule__TargetOfEvaluation__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalSecLanguage.g:1000:1: ( ( 'toe' ) )
            // InternalSecLanguage.g:1001:1: ( 'toe' )
            {
            // InternalSecLanguage.g:1001:1: ( 'toe' )
            // InternalSecLanguage.g:1002:1: 'toe'
            {
             before(grammarAccess.getTargetOfEvaluationAccess().getToeKeyword_2_0()); 
            match(input,24,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getTargetOfEvaluationAccess().getToeKeyword_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TargetOfEvaluation__Group_2__0__Impl"


    // $ANTLR start "rule__TargetOfEvaluation__Group_2__1"
    // InternalSecLanguage.g:1015:1: rule__TargetOfEvaluation__Group_2__1 : rule__TargetOfEvaluation__Group_2__1__Impl rule__TargetOfEvaluation__Group_2__2 ;
    public final void rule__TargetOfEvaluation__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalSecLanguage.g:1019:1: ( rule__TargetOfEvaluation__Group_2__1__Impl rule__TargetOfEvaluation__Group_2__2 )
            // InternalSecLanguage.g:1020:2: rule__TargetOfEvaluation__Group_2__1__Impl rule__TargetOfEvaluation__Group_2__2
            {
            pushFollow(FollowSets000.FOLLOW_3);
            rule__TargetOfEvaluation__Group_2__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__TargetOfEvaluation__Group_2__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TargetOfEvaluation__Group_2__1"


    // $ANTLR start "rule__TargetOfEvaluation__Group_2__1__Impl"
    // InternalSecLanguage.g:1027:1: rule__TargetOfEvaluation__Group_2__1__Impl : ( ( rule__TargetOfEvaluation__DomainAssignment_2_1 ) ) ;
    public final void rule__TargetOfEvaluation__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalSecLanguage.g:1031:1: ( ( ( rule__TargetOfEvaluation__DomainAssignment_2_1 ) ) )
            // InternalSecLanguage.g:1032:1: ( ( rule__TargetOfEvaluation__DomainAssignment_2_1 ) )
            {
            // InternalSecLanguage.g:1032:1: ( ( rule__TargetOfEvaluation__DomainAssignment_2_1 ) )
            // InternalSecLanguage.g:1033:1: ( rule__TargetOfEvaluation__DomainAssignment_2_1 )
            {
             before(grammarAccess.getTargetOfEvaluationAccess().getDomainAssignment_2_1()); 
            // InternalSecLanguage.g:1034:1: ( rule__TargetOfEvaluation__DomainAssignment_2_1 )
            // InternalSecLanguage.g:1034:2: rule__TargetOfEvaluation__DomainAssignment_2_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__TargetOfEvaluation__DomainAssignment_2_1();

            state._fsp--;


            }

             after(grammarAccess.getTargetOfEvaluationAccess().getDomainAssignment_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TargetOfEvaluation__Group_2__1__Impl"


    // $ANTLR start "rule__TargetOfEvaluation__Group_2__2"
    // InternalSecLanguage.g:1044:1: rule__TargetOfEvaluation__Group_2__2 : rule__TargetOfEvaluation__Group_2__2__Impl ;
    public final void rule__TargetOfEvaluation__Group_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalSecLanguage.g:1048:1: ( rule__TargetOfEvaluation__Group_2__2__Impl )
            // InternalSecLanguage.g:1049:2: rule__TargetOfEvaluation__Group_2__2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__TargetOfEvaluation__Group_2__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TargetOfEvaluation__Group_2__2"


    // $ANTLR start "rule__TargetOfEvaluation__Group_2__2__Impl"
    // InternalSecLanguage.g:1055:1: rule__TargetOfEvaluation__Group_2__2__Impl : ( ( rule__TargetOfEvaluation__ComponentsAssignment_2_2 )* ) ;
    public final void rule__TargetOfEvaluation__Group_2__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalSecLanguage.g:1059:1: ( ( ( rule__TargetOfEvaluation__ComponentsAssignment_2_2 )* ) )
            // InternalSecLanguage.g:1060:1: ( ( rule__TargetOfEvaluation__ComponentsAssignment_2_2 )* )
            {
            // InternalSecLanguage.g:1060:1: ( ( rule__TargetOfEvaluation__ComponentsAssignment_2_2 )* )
            // InternalSecLanguage.g:1061:1: ( rule__TargetOfEvaluation__ComponentsAssignment_2_2 )*
            {
             before(grammarAccess.getTargetOfEvaluationAccess().getComponentsAssignment_2_2()); 
            // InternalSecLanguage.g:1062:1: ( rule__TargetOfEvaluation__ComponentsAssignment_2_2 )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==19) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // InternalSecLanguage.g:1062:2: rule__TargetOfEvaluation__ComponentsAssignment_2_2
            	    {
            	    pushFollow(FollowSets000.FOLLOW_10);
            	    rule__TargetOfEvaluation__ComponentsAssignment_2_2();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);

             after(grammarAccess.getTargetOfEvaluationAccess().getComponentsAssignment_2_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TargetOfEvaluation__Group_2__2__Impl"


    // $ANTLR start "rule__Attack__Group__0"
    // InternalSecLanguage.g:1078:1: rule__Attack__Group__0 : rule__Attack__Group__0__Impl rule__Attack__Group__1 ;
    public final void rule__Attack__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalSecLanguage.g:1082:1: ( rule__Attack__Group__0__Impl rule__Attack__Group__1 )
            // InternalSecLanguage.g:1083:2: rule__Attack__Group__0__Impl rule__Attack__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_3);
            rule__Attack__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Attack__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Attack__Group__0"


    // $ANTLR start "rule__Attack__Group__0__Impl"
    // InternalSecLanguage.g:1090:1: rule__Attack__Group__0__Impl : ( () ) ;
    public final void rule__Attack__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalSecLanguage.g:1094:1: ( ( () ) )
            // InternalSecLanguage.g:1095:1: ( () )
            {
            // InternalSecLanguage.g:1095:1: ( () )
            // InternalSecLanguage.g:1096:1: ()
            {
             before(grammarAccess.getAttackAccess().getAttackAction_0()); 
            // InternalSecLanguage.g:1097:1: ()
            // InternalSecLanguage.g:1099:1: 
            {
            }

             after(grammarAccess.getAttackAccess().getAttackAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Attack__Group__0__Impl"


    // $ANTLR start "rule__Attack__Group__1"
    // InternalSecLanguage.g:1109:1: rule__Attack__Group__1 : rule__Attack__Group__1__Impl rule__Attack__Group__2 ;
    public final void rule__Attack__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalSecLanguage.g:1113:1: ( rule__Attack__Group__1__Impl rule__Attack__Group__2 )
            // InternalSecLanguage.g:1114:2: rule__Attack__Group__1__Impl rule__Attack__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_12);
            rule__Attack__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Attack__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Attack__Group__1"


    // $ANTLR start "rule__Attack__Group__1__Impl"
    // InternalSecLanguage.g:1121:1: rule__Attack__Group__1__Impl : ( '(' ) ;
    public final void rule__Attack__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalSecLanguage.g:1125:1: ( ( '(' ) )
            // InternalSecLanguage.g:1126:1: ( '(' )
            {
            // InternalSecLanguage.g:1126:1: ( '(' )
            // InternalSecLanguage.g:1127:1: '('
            {
             before(grammarAccess.getAttackAccess().getLeftParenthesisKeyword_1()); 
            match(input,19,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getAttackAccess().getLeftParenthesisKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Attack__Group__1__Impl"


    // $ANTLR start "rule__Attack__Group__2"
    // InternalSecLanguage.g:1140:1: rule__Attack__Group__2 : rule__Attack__Group__2__Impl rule__Attack__Group__3 ;
    public final void rule__Attack__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalSecLanguage.g:1144:1: ( rule__Attack__Group__2__Impl rule__Attack__Group__3 )
            // InternalSecLanguage.g:1145:2: rule__Attack__Group__2__Impl rule__Attack__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_8);
            rule__Attack__Group__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Attack__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Attack__Group__2"


    // $ANTLR start "rule__Attack__Group__2__Impl"
    // InternalSecLanguage.g:1152:1: rule__Attack__Group__2__Impl : ( ( rule__Attack__Group_2__0 ) ) ;
    public final void rule__Attack__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalSecLanguage.g:1156:1: ( ( ( rule__Attack__Group_2__0 ) ) )
            // InternalSecLanguage.g:1157:1: ( ( rule__Attack__Group_2__0 ) )
            {
            // InternalSecLanguage.g:1157:1: ( ( rule__Attack__Group_2__0 ) )
            // InternalSecLanguage.g:1158:1: ( rule__Attack__Group_2__0 )
            {
             before(grammarAccess.getAttackAccess().getGroup_2()); 
            // InternalSecLanguage.g:1159:1: ( rule__Attack__Group_2__0 )
            // InternalSecLanguage.g:1159:2: rule__Attack__Group_2__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Attack__Group_2__0();

            state._fsp--;


            }

             after(grammarAccess.getAttackAccess().getGroup_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Attack__Group__2__Impl"


    // $ANTLR start "rule__Attack__Group__3"
    // InternalSecLanguage.g:1169:1: rule__Attack__Group__3 : rule__Attack__Group__3__Impl ;
    public final void rule__Attack__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalSecLanguage.g:1173:1: ( rule__Attack__Group__3__Impl )
            // InternalSecLanguage.g:1174:2: rule__Attack__Group__3__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Attack__Group__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Attack__Group__3"


    // $ANTLR start "rule__Attack__Group__3__Impl"
    // InternalSecLanguage.g:1180:1: rule__Attack__Group__3__Impl : ( ')' ) ;
    public final void rule__Attack__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalSecLanguage.g:1184:1: ( ( ')' ) )
            // InternalSecLanguage.g:1185:1: ( ')' )
            {
            // InternalSecLanguage.g:1185:1: ( ')' )
            // InternalSecLanguage.g:1186:1: ')'
            {
             before(grammarAccess.getAttackAccess().getRightParenthesisKeyword_3()); 
            match(input,21,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getAttackAccess().getRightParenthesisKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Attack__Group__3__Impl"


    // $ANTLR start "rule__Attack__Group_2__0"
    // InternalSecLanguage.g:1207:1: rule__Attack__Group_2__0 : rule__Attack__Group_2__0__Impl rule__Attack__Group_2__1 ;
    public final void rule__Attack__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalSecLanguage.g:1211:1: ( rule__Attack__Group_2__0__Impl rule__Attack__Group_2__1 )
            // InternalSecLanguage.g:1212:2: rule__Attack__Group_2__0__Impl rule__Attack__Group_2__1
            {
            pushFollow(FollowSets000.FOLLOW_13);
            rule__Attack__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Attack__Group_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Attack__Group_2__0"


    // $ANTLR start "rule__Attack__Group_2__0__Impl"
    // InternalSecLanguage.g:1219:1: rule__Attack__Group_2__0__Impl : ( 'attack' ) ;
    public final void rule__Attack__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalSecLanguage.g:1223:1: ( ( 'attack' ) )
            // InternalSecLanguage.g:1224:1: ( 'attack' )
            {
            // InternalSecLanguage.g:1224:1: ( 'attack' )
            // InternalSecLanguage.g:1225:1: 'attack'
            {
             before(grammarAccess.getAttackAccess().getAttackKeyword_2_0()); 
            match(input,25,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getAttackAccess().getAttackKeyword_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Attack__Group_2__0__Impl"


    // $ANTLR start "rule__Attack__Group_2__1"
    // InternalSecLanguage.g:1238:1: rule__Attack__Group_2__1 : rule__Attack__Group_2__1__Impl rule__Attack__Group_2__2 ;
    public final void rule__Attack__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalSecLanguage.g:1242:1: ( rule__Attack__Group_2__1__Impl rule__Attack__Group_2__2 )
            // InternalSecLanguage.g:1243:2: rule__Attack__Group_2__1__Impl rule__Attack__Group_2__2
            {
            pushFollow(FollowSets000.FOLLOW_14);
            rule__Attack__Group_2__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Attack__Group_2__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Attack__Group_2__1"


    // $ANTLR start "rule__Attack__Group_2__1__Impl"
    // InternalSecLanguage.g:1250:1: rule__Attack__Group_2__1__Impl : ( ( rule__Attack__NameAssignment_2_1 ) ) ;
    public final void rule__Attack__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalSecLanguage.g:1254:1: ( ( ( rule__Attack__NameAssignment_2_1 ) ) )
            // InternalSecLanguage.g:1255:1: ( ( rule__Attack__NameAssignment_2_1 ) )
            {
            // InternalSecLanguage.g:1255:1: ( ( rule__Attack__NameAssignment_2_1 ) )
            // InternalSecLanguage.g:1256:1: ( rule__Attack__NameAssignment_2_1 )
            {
             before(grammarAccess.getAttackAccess().getNameAssignment_2_1()); 
            // InternalSecLanguage.g:1257:1: ( rule__Attack__NameAssignment_2_1 )
            // InternalSecLanguage.g:1257:2: rule__Attack__NameAssignment_2_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Attack__NameAssignment_2_1();

            state._fsp--;


            }

             after(grammarAccess.getAttackAccess().getNameAssignment_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Attack__Group_2__1__Impl"


    // $ANTLR start "rule__Attack__Group_2__2"
    // InternalSecLanguage.g:1267:1: rule__Attack__Group_2__2 : rule__Attack__Group_2__2__Impl ;
    public final void rule__Attack__Group_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalSecLanguage.g:1271:1: ( rule__Attack__Group_2__2__Impl )
            // InternalSecLanguage.g:1272:2: rule__Attack__Group_2__2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Attack__Group_2__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Attack__Group_2__2"


    // $ANTLR start "rule__Attack__Group_2__2__Impl"
    // InternalSecLanguage.g:1278:1: rule__Attack__Group_2__2__Impl : ( ( rule__Attack__Group_2_2__0 )? ) ;
    public final void rule__Attack__Group_2__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalSecLanguage.g:1282:1: ( ( ( rule__Attack__Group_2_2__0 )? ) )
            // InternalSecLanguage.g:1283:1: ( ( rule__Attack__Group_2_2__0 )? )
            {
            // InternalSecLanguage.g:1283:1: ( ( rule__Attack__Group_2_2__0 )? )
            // InternalSecLanguage.g:1284:1: ( rule__Attack__Group_2_2__0 )?
            {
             before(grammarAccess.getAttackAccess().getGroup_2_2()); 
            // InternalSecLanguage.g:1285:1: ( rule__Attack__Group_2_2__0 )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==26) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // InternalSecLanguage.g:1285:2: rule__Attack__Group_2_2__0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__Attack__Group_2_2__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getAttackAccess().getGroup_2_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Attack__Group_2__2__Impl"


    // $ANTLR start "rule__Attack__Group_2_2__0"
    // InternalSecLanguage.g:1301:1: rule__Attack__Group_2_2__0 : rule__Attack__Group_2_2__0__Impl rule__Attack__Group_2_2__1 ;
    public final void rule__Attack__Group_2_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalSecLanguage.g:1305:1: ( rule__Attack__Group_2_2__0__Impl rule__Attack__Group_2_2__1 )
            // InternalSecLanguage.g:1306:2: rule__Attack__Group_2_2__0__Impl rule__Attack__Group_2_2__1
            {
            pushFollow(FollowSets000.FOLLOW_15);
            rule__Attack__Group_2_2__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Attack__Group_2_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Attack__Group_2_2__0"


    // $ANTLR start "rule__Attack__Group_2_2__0__Impl"
    // InternalSecLanguage.g:1313:1: rule__Attack__Group_2_2__0__Impl : ( '{' ) ;
    public final void rule__Attack__Group_2_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalSecLanguage.g:1317:1: ( ( '{' ) )
            // InternalSecLanguage.g:1318:1: ( '{' )
            {
            // InternalSecLanguage.g:1318:1: ( '{' )
            // InternalSecLanguage.g:1319:1: '{'
            {
             before(grammarAccess.getAttackAccess().getLeftCurlyBracketKeyword_2_2_0()); 
            match(input,26,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getAttackAccess().getLeftCurlyBracketKeyword_2_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Attack__Group_2_2__0__Impl"


    // $ANTLR start "rule__Attack__Group_2_2__1"
    // InternalSecLanguage.g:1332:1: rule__Attack__Group_2_2__1 : rule__Attack__Group_2_2__1__Impl rule__Attack__Group_2_2__2 ;
    public final void rule__Attack__Group_2_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalSecLanguage.g:1336:1: ( rule__Attack__Group_2_2__1__Impl rule__Attack__Group_2_2__2 )
            // InternalSecLanguage.g:1337:2: rule__Attack__Group_2_2__1__Impl rule__Attack__Group_2_2__2
            {
            pushFollow(FollowSets000.FOLLOW_16);
            rule__Attack__Group_2_2__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Attack__Group_2_2__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Attack__Group_2_2__1"


    // $ANTLR start "rule__Attack__Group_2_2__1__Impl"
    // InternalSecLanguage.g:1344:1: rule__Attack__Group_2_2__1__Impl : ( ':level' ) ;
    public final void rule__Attack__Group_2_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalSecLanguage.g:1348:1: ( ( ':level' ) )
            // InternalSecLanguage.g:1349:1: ( ':level' )
            {
            // InternalSecLanguage.g:1349:1: ( ':level' )
            // InternalSecLanguage.g:1350:1: ':level'
            {
             before(grammarAccess.getAttackAccess().getLevelKeyword_2_2_1()); 
            match(input,27,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getAttackAccess().getLevelKeyword_2_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Attack__Group_2_2__1__Impl"


    // $ANTLR start "rule__Attack__Group_2_2__2"
    // InternalSecLanguage.g:1363:1: rule__Attack__Group_2_2__2 : rule__Attack__Group_2_2__2__Impl rule__Attack__Group_2_2__3 ;
    public final void rule__Attack__Group_2_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalSecLanguage.g:1367:1: ( rule__Attack__Group_2_2__2__Impl rule__Attack__Group_2_2__3 )
            // InternalSecLanguage.g:1368:2: rule__Attack__Group_2_2__2__Impl rule__Attack__Group_2_2__3
            {
            pushFollow(FollowSets000.FOLLOW_17);
            rule__Attack__Group_2_2__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Attack__Group_2_2__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Attack__Group_2_2__2"


    // $ANTLR start "rule__Attack__Group_2_2__2__Impl"
    // InternalSecLanguage.g:1375:1: rule__Attack__Group_2_2__2__Impl : ( ( rule__Attack__SeverityAssignment_2_2_2 ) ) ;
    public final void rule__Attack__Group_2_2__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalSecLanguage.g:1379:1: ( ( ( rule__Attack__SeverityAssignment_2_2_2 ) ) )
            // InternalSecLanguage.g:1380:1: ( ( rule__Attack__SeverityAssignment_2_2_2 ) )
            {
            // InternalSecLanguage.g:1380:1: ( ( rule__Attack__SeverityAssignment_2_2_2 ) )
            // InternalSecLanguage.g:1381:1: ( rule__Attack__SeverityAssignment_2_2_2 )
            {
             before(grammarAccess.getAttackAccess().getSeverityAssignment_2_2_2()); 
            // InternalSecLanguage.g:1382:1: ( rule__Attack__SeverityAssignment_2_2_2 )
            // InternalSecLanguage.g:1382:2: rule__Attack__SeverityAssignment_2_2_2
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Attack__SeverityAssignment_2_2_2();

            state._fsp--;


            }

             after(grammarAccess.getAttackAccess().getSeverityAssignment_2_2_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Attack__Group_2_2__2__Impl"


    // $ANTLR start "rule__Attack__Group_2_2__3"
    // InternalSecLanguage.g:1392:1: rule__Attack__Group_2_2__3 : rule__Attack__Group_2_2__3__Impl ;
    public final void rule__Attack__Group_2_2__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalSecLanguage.g:1396:1: ( rule__Attack__Group_2_2__3__Impl )
            // InternalSecLanguage.g:1397:2: rule__Attack__Group_2_2__3__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Attack__Group_2_2__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Attack__Group_2_2__3"


    // $ANTLR start "rule__Attack__Group_2_2__3__Impl"
    // InternalSecLanguage.g:1403:1: rule__Attack__Group_2_2__3__Impl : ( '}' ) ;
    public final void rule__Attack__Group_2_2__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalSecLanguage.g:1407:1: ( ( '}' ) )
            // InternalSecLanguage.g:1408:1: ( '}' )
            {
            // InternalSecLanguage.g:1408:1: ( '}' )
            // InternalSecLanguage.g:1409:1: '}'
            {
             before(grammarAccess.getAttackAccess().getRightCurlyBracketKeyword_2_2_3()); 
            match(input,28,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getAttackAccess().getRightCurlyBracketKeyword_2_2_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Attack__Group_2_2__3__Impl"


    // $ANTLR start "rule__WebComponent__Group__0"
    // InternalSecLanguage.g:1430:1: rule__WebComponent__Group__0 : rule__WebComponent__Group__0__Impl rule__WebComponent__Group__1 ;
    public final void rule__WebComponent__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalSecLanguage.g:1434:1: ( rule__WebComponent__Group__0__Impl rule__WebComponent__Group__1 )
            // InternalSecLanguage.g:1435:2: rule__WebComponent__Group__0__Impl rule__WebComponent__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_3);
            rule__WebComponent__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__WebComponent__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__WebComponent__Group__0"


    // $ANTLR start "rule__WebComponent__Group__0__Impl"
    // InternalSecLanguage.g:1442:1: rule__WebComponent__Group__0__Impl : ( () ) ;
    public final void rule__WebComponent__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalSecLanguage.g:1446:1: ( ( () ) )
            // InternalSecLanguage.g:1447:1: ( () )
            {
            // InternalSecLanguage.g:1447:1: ( () )
            // InternalSecLanguage.g:1448:1: ()
            {
             before(grammarAccess.getWebComponentAccess().getWebComponentAction_0()); 
            // InternalSecLanguage.g:1449:1: ()
            // InternalSecLanguage.g:1451:1: 
            {
            }

             after(grammarAccess.getWebComponentAccess().getWebComponentAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__WebComponent__Group__0__Impl"


    // $ANTLR start "rule__WebComponent__Group__1"
    // InternalSecLanguage.g:1461:1: rule__WebComponent__Group__1 : rule__WebComponent__Group__1__Impl rule__WebComponent__Group__2 ;
    public final void rule__WebComponent__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalSecLanguage.g:1465:1: ( rule__WebComponent__Group__1__Impl rule__WebComponent__Group__2 )
            // InternalSecLanguage.g:1466:2: rule__WebComponent__Group__1__Impl rule__WebComponent__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_18);
            rule__WebComponent__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__WebComponent__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__WebComponent__Group__1"


    // $ANTLR start "rule__WebComponent__Group__1__Impl"
    // InternalSecLanguage.g:1473:1: rule__WebComponent__Group__1__Impl : ( '(' ) ;
    public final void rule__WebComponent__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalSecLanguage.g:1477:1: ( ( '(' ) )
            // InternalSecLanguage.g:1478:1: ( '(' )
            {
            // InternalSecLanguage.g:1478:1: ( '(' )
            // InternalSecLanguage.g:1479:1: '('
            {
             before(grammarAccess.getWebComponentAccess().getLeftParenthesisKeyword_1()); 
            match(input,19,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getWebComponentAccess().getLeftParenthesisKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__WebComponent__Group__1__Impl"


    // $ANTLR start "rule__WebComponent__Group__2"
    // InternalSecLanguage.g:1492:1: rule__WebComponent__Group__2 : rule__WebComponent__Group__2__Impl rule__WebComponent__Group__3 ;
    public final void rule__WebComponent__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalSecLanguage.g:1496:1: ( rule__WebComponent__Group__2__Impl rule__WebComponent__Group__3 )
            // InternalSecLanguage.g:1497:2: rule__WebComponent__Group__2__Impl rule__WebComponent__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_8);
            rule__WebComponent__Group__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__WebComponent__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__WebComponent__Group__2"


    // $ANTLR start "rule__WebComponent__Group__2__Impl"
    // InternalSecLanguage.g:1504:1: rule__WebComponent__Group__2__Impl : ( ( rule__WebComponent__Group_2__0 ) ) ;
    public final void rule__WebComponent__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalSecLanguage.g:1508:1: ( ( ( rule__WebComponent__Group_2__0 ) ) )
            // InternalSecLanguage.g:1509:1: ( ( rule__WebComponent__Group_2__0 ) )
            {
            // InternalSecLanguage.g:1509:1: ( ( rule__WebComponent__Group_2__0 ) )
            // InternalSecLanguage.g:1510:1: ( rule__WebComponent__Group_2__0 )
            {
             before(grammarAccess.getWebComponentAccess().getGroup_2()); 
            // InternalSecLanguage.g:1511:1: ( rule__WebComponent__Group_2__0 )
            // InternalSecLanguage.g:1511:2: rule__WebComponent__Group_2__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__WebComponent__Group_2__0();

            state._fsp--;


            }

             after(grammarAccess.getWebComponentAccess().getGroup_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__WebComponent__Group__2__Impl"


    // $ANTLR start "rule__WebComponent__Group__3"
    // InternalSecLanguage.g:1521:1: rule__WebComponent__Group__3 : rule__WebComponent__Group__3__Impl ;
    public final void rule__WebComponent__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalSecLanguage.g:1525:1: ( rule__WebComponent__Group__3__Impl )
            // InternalSecLanguage.g:1526:2: rule__WebComponent__Group__3__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__WebComponent__Group__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__WebComponent__Group__3"


    // $ANTLR start "rule__WebComponent__Group__3__Impl"
    // InternalSecLanguage.g:1532:1: rule__WebComponent__Group__3__Impl : ( ')' ) ;
    public final void rule__WebComponent__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalSecLanguage.g:1536:1: ( ( ')' ) )
            // InternalSecLanguage.g:1537:1: ( ')' )
            {
            // InternalSecLanguage.g:1537:1: ( ')' )
            // InternalSecLanguage.g:1538:1: ')'
            {
             before(grammarAccess.getWebComponentAccess().getRightParenthesisKeyword_3()); 
            match(input,21,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getWebComponentAccess().getRightParenthesisKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__WebComponent__Group__3__Impl"


    // $ANTLR start "rule__WebComponent__Group_2__0"
    // InternalSecLanguage.g:1559:1: rule__WebComponent__Group_2__0 : rule__WebComponent__Group_2__0__Impl rule__WebComponent__Group_2__1 ;
    public final void rule__WebComponent__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalSecLanguage.g:1563:1: ( rule__WebComponent__Group_2__0__Impl rule__WebComponent__Group_2__1 )
            // InternalSecLanguage.g:1564:2: rule__WebComponent__Group_2__0__Impl rule__WebComponent__Group_2__1
            {
            pushFollow(FollowSets000.FOLLOW_5);
            rule__WebComponent__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__WebComponent__Group_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__WebComponent__Group_2__0"


    // $ANTLR start "rule__WebComponent__Group_2__0__Impl"
    // InternalSecLanguage.g:1571:1: rule__WebComponent__Group_2__0__Impl : ( 'page' ) ;
    public final void rule__WebComponent__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalSecLanguage.g:1575:1: ( ( 'page' ) )
            // InternalSecLanguage.g:1576:1: ( 'page' )
            {
            // InternalSecLanguage.g:1576:1: ( 'page' )
            // InternalSecLanguage.g:1577:1: 'page'
            {
             before(grammarAccess.getWebComponentAccess().getPageKeyword_2_0()); 
            match(input,29,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getWebComponentAccess().getPageKeyword_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__WebComponent__Group_2__0__Impl"


    // $ANTLR start "rule__WebComponent__Group_2__1"
    // InternalSecLanguage.g:1590:1: rule__WebComponent__Group_2__1 : rule__WebComponent__Group_2__1__Impl rule__WebComponent__Group_2__2 ;
    public final void rule__WebComponent__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalSecLanguage.g:1594:1: ( rule__WebComponent__Group_2__1__Impl rule__WebComponent__Group_2__2 )
            // InternalSecLanguage.g:1595:2: rule__WebComponent__Group_2__1__Impl rule__WebComponent__Group_2__2
            {
            pushFollow(FollowSets000.FOLLOW_19);
            rule__WebComponent__Group_2__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__WebComponent__Group_2__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__WebComponent__Group_2__1"


    // $ANTLR start "rule__WebComponent__Group_2__1__Impl"
    // InternalSecLanguage.g:1602:1: rule__WebComponent__Group_2__1__Impl : ( ( rule__WebComponent__PathAssignment_2_1 ) ) ;
    public final void rule__WebComponent__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalSecLanguage.g:1606:1: ( ( ( rule__WebComponent__PathAssignment_2_1 ) ) )
            // InternalSecLanguage.g:1607:1: ( ( rule__WebComponent__PathAssignment_2_1 ) )
            {
            // InternalSecLanguage.g:1607:1: ( ( rule__WebComponent__PathAssignment_2_1 ) )
            // InternalSecLanguage.g:1608:1: ( rule__WebComponent__PathAssignment_2_1 )
            {
             before(grammarAccess.getWebComponentAccess().getPathAssignment_2_1()); 
            // InternalSecLanguage.g:1609:1: ( rule__WebComponent__PathAssignment_2_1 )
            // InternalSecLanguage.g:1609:2: rule__WebComponent__PathAssignment_2_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__WebComponent__PathAssignment_2_1();

            state._fsp--;


            }

             after(grammarAccess.getWebComponentAccess().getPathAssignment_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__WebComponent__Group_2__1__Impl"


    // $ANTLR start "rule__WebComponent__Group_2__2"
    // InternalSecLanguage.g:1619:1: rule__WebComponent__Group_2__2 : rule__WebComponent__Group_2__2__Impl rule__WebComponent__Group_2__3 ;
    public final void rule__WebComponent__Group_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalSecLanguage.g:1623:1: ( rule__WebComponent__Group_2__2__Impl rule__WebComponent__Group_2__3 )
            // InternalSecLanguage.g:1624:2: rule__WebComponent__Group_2__2__Impl rule__WebComponent__Group_2__3
            {
            pushFollow(FollowSets000.FOLLOW_19);
            rule__WebComponent__Group_2__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__WebComponent__Group_2__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__WebComponent__Group_2__2"


    // $ANTLR start "rule__WebComponent__Group_2__2__Impl"
    // InternalSecLanguage.g:1631:1: rule__WebComponent__Group_2__2__Impl : ( ( rule__WebComponent__Group_2_2__0 )? ) ;
    public final void rule__WebComponent__Group_2__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalSecLanguage.g:1635:1: ( ( ( rule__WebComponent__Group_2_2__0 )? ) )
            // InternalSecLanguage.g:1636:1: ( ( rule__WebComponent__Group_2_2__0 )? )
            {
            // InternalSecLanguage.g:1636:1: ( ( rule__WebComponent__Group_2_2__0 )? )
            // InternalSecLanguage.g:1637:1: ( rule__WebComponent__Group_2_2__0 )?
            {
             before(grammarAccess.getWebComponentAccess().getGroup_2_2()); 
            // InternalSecLanguage.g:1638:1: ( rule__WebComponent__Group_2_2__0 )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==26) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // InternalSecLanguage.g:1638:2: rule__WebComponent__Group_2_2__0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__WebComponent__Group_2_2__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getWebComponentAccess().getGroup_2_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__WebComponent__Group_2__2__Impl"


    // $ANTLR start "rule__WebComponent__Group_2__3"
    // InternalSecLanguage.g:1648:1: rule__WebComponent__Group_2__3 : rule__WebComponent__Group_2__3__Impl ;
    public final void rule__WebComponent__Group_2__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalSecLanguage.g:1652:1: ( rule__WebComponent__Group_2__3__Impl )
            // InternalSecLanguage.g:1653:2: rule__WebComponent__Group_2__3__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__WebComponent__Group_2__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__WebComponent__Group_2__3"


    // $ANTLR start "rule__WebComponent__Group_2__3__Impl"
    // InternalSecLanguage.g:1659:1: rule__WebComponent__Group_2__3__Impl : ( ( rule__WebComponent__InputsAssignment_2_3 )* ) ;
    public final void rule__WebComponent__Group_2__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalSecLanguage.g:1663:1: ( ( ( rule__WebComponent__InputsAssignment_2_3 )* ) )
            // InternalSecLanguage.g:1664:1: ( ( rule__WebComponent__InputsAssignment_2_3 )* )
            {
            // InternalSecLanguage.g:1664:1: ( ( rule__WebComponent__InputsAssignment_2_3 )* )
            // InternalSecLanguage.g:1665:1: ( rule__WebComponent__InputsAssignment_2_3 )*
            {
             before(grammarAccess.getWebComponentAccess().getInputsAssignment_2_3()); 
            // InternalSecLanguage.g:1666:1: ( rule__WebComponent__InputsAssignment_2_3 )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==19) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // InternalSecLanguage.g:1666:2: rule__WebComponent__InputsAssignment_2_3
            	    {
            	    pushFollow(FollowSets000.FOLLOW_10);
            	    rule__WebComponent__InputsAssignment_2_3();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop10;
                }
            } while (true);

             after(grammarAccess.getWebComponentAccess().getInputsAssignment_2_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__WebComponent__Group_2__3__Impl"


    // $ANTLR start "rule__WebComponent__Group_2_2__0"
    // InternalSecLanguage.g:1684:1: rule__WebComponent__Group_2_2__0 : rule__WebComponent__Group_2_2__0__Impl rule__WebComponent__Group_2_2__1 ;
    public final void rule__WebComponent__Group_2_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalSecLanguage.g:1688:1: ( rule__WebComponent__Group_2_2__0__Impl rule__WebComponent__Group_2_2__1 )
            // InternalSecLanguage.g:1689:2: rule__WebComponent__Group_2_2__0__Impl rule__WebComponent__Group_2_2__1
            {
            pushFollow(FollowSets000.FOLLOW_20);
            rule__WebComponent__Group_2_2__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__WebComponent__Group_2_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__WebComponent__Group_2_2__0"


    // $ANTLR start "rule__WebComponent__Group_2_2__0__Impl"
    // InternalSecLanguage.g:1696:1: rule__WebComponent__Group_2_2__0__Impl : ( '{' ) ;
    public final void rule__WebComponent__Group_2_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalSecLanguage.g:1700:1: ( ( '{' ) )
            // InternalSecLanguage.g:1701:1: ( '{' )
            {
            // InternalSecLanguage.g:1701:1: ( '{' )
            // InternalSecLanguage.g:1702:1: '{'
            {
             before(grammarAccess.getWebComponentAccess().getLeftCurlyBracketKeyword_2_2_0()); 
            match(input,26,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getWebComponentAccess().getLeftCurlyBracketKeyword_2_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__WebComponent__Group_2_2__0__Impl"


    // $ANTLR start "rule__WebComponent__Group_2_2__1"
    // InternalSecLanguage.g:1715:1: rule__WebComponent__Group_2_2__1 : rule__WebComponent__Group_2_2__1__Impl rule__WebComponent__Group_2_2__2 ;
    public final void rule__WebComponent__Group_2_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalSecLanguage.g:1719:1: ( rule__WebComponent__Group_2_2__1__Impl rule__WebComponent__Group_2_2__2 )
            // InternalSecLanguage.g:1720:2: rule__WebComponent__Group_2_2__1__Impl rule__WebComponent__Group_2_2__2
            {
            pushFollow(FollowSets000.FOLLOW_21);
            rule__WebComponent__Group_2_2__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__WebComponent__Group_2_2__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__WebComponent__Group_2_2__1"


    // $ANTLR start "rule__WebComponent__Group_2_2__1__Impl"
    // InternalSecLanguage.g:1727:1: rule__WebComponent__Group_2_2__1__Impl : ( ':target' ) ;
    public final void rule__WebComponent__Group_2_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalSecLanguage.g:1731:1: ( ( ':target' ) )
            // InternalSecLanguage.g:1732:1: ( ':target' )
            {
            // InternalSecLanguage.g:1732:1: ( ':target' )
            // InternalSecLanguage.g:1733:1: ':target'
            {
             before(grammarAccess.getWebComponentAccess().getTargetKeyword_2_2_1()); 
            match(input,30,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getWebComponentAccess().getTargetKeyword_2_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__WebComponent__Group_2_2__1__Impl"


    // $ANTLR start "rule__WebComponent__Group_2_2__2"
    // InternalSecLanguage.g:1746:1: rule__WebComponent__Group_2_2__2 : rule__WebComponent__Group_2_2__2__Impl rule__WebComponent__Group_2_2__3 ;
    public final void rule__WebComponent__Group_2_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalSecLanguage.g:1750:1: ( rule__WebComponent__Group_2_2__2__Impl rule__WebComponent__Group_2_2__3 )
            // InternalSecLanguage.g:1751:2: rule__WebComponent__Group_2_2__2__Impl rule__WebComponent__Group_2_2__3
            {
            pushFollow(FollowSets000.FOLLOW_22);
            rule__WebComponent__Group_2_2__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__WebComponent__Group_2_2__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__WebComponent__Group_2_2__2"


    // $ANTLR start "rule__WebComponent__Group_2_2__2__Impl"
    // InternalSecLanguage.g:1758:1: rule__WebComponent__Group_2_2__2__Impl : ( '[' ) ;
    public final void rule__WebComponent__Group_2_2__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalSecLanguage.g:1762:1: ( ( '[' ) )
            // InternalSecLanguage.g:1763:1: ( '[' )
            {
            // InternalSecLanguage.g:1763:1: ( '[' )
            // InternalSecLanguage.g:1764:1: '['
            {
             before(grammarAccess.getWebComponentAccess().getLeftSquareBracketKeyword_2_2_2()); 
            match(input,31,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getWebComponentAccess().getLeftSquareBracketKeyword_2_2_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__WebComponent__Group_2_2__2__Impl"


    // $ANTLR start "rule__WebComponent__Group_2_2__3"
    // InternalSecLanguage.g:1777:1: rule__WebComponent__Group_2_2__3 : rule__WebComponent__Group_2_2__3__Impl rule__WebComponent__Group_2_2__4 ;
    public final void rule__WebComponent__Group_2_2__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalSecLanguage.g:1781:1: ( rule__WebComponent__Group_2_2__3__Impl rule__WebComponent__Group_2_2__4 )
            // InternalSecLanguage.g:1782:2: rule__WebComponent__Group_2_2__3__Impl rule__WebComponent__Group_2_2__4
            {
            pushFollow(FollowSets000.FOLLOW_22);
            rule__WebComponent__Group_2_2__3__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__WebComponent__Group_2_2__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__WebComponent__Group_2_2__3"


    // $ANTLR start "rule__WebComponent__Group_2_2__3__Impl"
    // InternalSecLanguage.g:1789:1: rule__WebComponent__Group_2_2__3__Impl : ( ( ruleEString )* ) ;
    public final void rule__WebComponent__Group_2_2__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalSecLanguage.g:1793:1: ( ( ( ruleEString )* ) )
            // InternalSecLanguage.g:1794:1: ( ( ruleEString )* )
            {
            // InternalSecLanguage.g:1794:1: ( ( ruleEString )* )
            // InternalSecLanguage.g:1795:1: ( ruleEString )*
            {
             before(grammarAccess.getWebComponentAccess().getEStringParserRuleCall_2_2_3()); 
            // InternalSecLanguage.g:1796:1: ( ruleEString )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( ((LA11_0>=RULE_STRING && LA11_0<=RULE_ID)) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // InternalSecLanguage.g:1796:3: ruleEString
            	    {
            	    pushFollow(FollowSets000.FOLLOW_23);
            	    ruleEString();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop11;
                }
            } while (true);

             after(grammarAccess.getWebComponentAccess().getEStringParserRuleCall_2_2_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__WebComponent__Group_2_2__3__Impl"


    // $ANTLR start "rule__WebComponent__Group_2_2__4"
    // InternalSecLanguage.g:1806:1: rule__WebComponent__Group_2_2__4 : rule__WebComponent__Group_2_2__4__Impl rule__WebComponent__Group_2_2__5 ;
    public final void rule__WebComponent__Group_2_2__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalSecLanguage.g:1810:1: ( rule__WebComponent__Group_2_2__4__Impl rule__WebComponent__Group_2_2__5 )
            // InternalSecLanguage.g:1811:2: rule__WebComponent__Group_2_2__4__Impl rule__WebComponent__Group_2_2__5
            {
            pushFollow(FollowSets000.FOLLOW_17);
            rule__WebComponent__Group_2_2__4__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__WebComponent__Group_2_2__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__WebComponent__Group_2_2__4"


    // $ANTLR start "rule__WebComponent__Group_2_2__4__Impl"
    // InternalSecLanguage.g:1818:1: rule__WebComponent__Group_2_2__4__Impl : ( ']' ) ;
    public final void rule__WebComponent__Group_2_2__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalSecLanguage.g:1822:1: ( ( ']' ) )
            // InternalSecLanguage.g:1823:1: ( ']' )
            {
            // InternalSecLanguage.g:1823:1: ( ']' )
            // InternalSecLanguage.g:1824:1: ']'
            {
             before(grammarAccess.getWebComponentAccess().getRightSquareBracketKeyword_2_2_4()); 
            match(input,32,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getWebComponentAccess().getRightSquareBracketKeyword_2_2_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__WebComponent__Group_2_2__4__Impl"


    // $ANTLR start "rule__WebComponent__Group_2_2__5"
    // InternalSecLanguage.g:1837:1: rule__WebComponent__Group_2_2__5 : rule__WebComponent__Group_2_2__5__Impl ;
    public final void rule__WebComponent__Group_2_2__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalSecLanguage.g:1841:1: ( rule__WebComponent__Group_2_2__5__Impl )
            // InternalSecLanguage.g:1842:2: rule__WebComponent__Group_2_2__5__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__WebComponent__Group_2_2__5__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__WebComponent__Group_2_2__5"


    // $ANTLR start "rule__WebComponent__Group_2_2__5__Impl"
    // InternalSecLanguage.g:1848:1: rule__WebComponent__Group_2_2__5__Impl : ( '}' ) ;
    public final void rule__WebComponent__Group_2_2__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalSecLanguage.g:1852:1: ( ( '}' ) )
            // InternalSecLanguage.g:1853:1: ( '}' )
            {
            // InternalSecLanguage.g:1853:1: ( '}' )
            // InternalSecLanguage.g:1854:1: '}'
            {
             before(grammarAccess.getWebComponentAccess().getRightCurlyBracketKeyword_2_2_5()); 
            match(input,28,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getWebComponentAccess().getRightCurlyBracketKeyword_2_2_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__WebComponent__Group_2_2__5__Impl"


    // $ANTLR start "rule__Input__Group__0"
    // InternalSecLanguage.g:1879:1: rule__Input__Group__0 : rule__Input__Group__0__Impl rule__Input__Group__1 ;
    public final void rule__Input__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalSecLanguage.g:1883:1: ( rule__Input__Group__0__Impl rule__Input__Group__1 )
            // InternalSecLanguage.g:1884:2: rule__Input__Group__0__Impl rule__Input__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_3);
            rule__Input__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Input__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Input__Group__0"


    // $ANTLR start "rule__Input__Group__0__Impl"
    // InternalSecLanguage.g:1891:1: rule__Input__Group__0__Impl : ( () ) ;
    public final void rule__Input__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalSecLanguage.g:1895:1: ( ( () ) )
            // InternalSecLanguage.g:1896:1: ( () )
            {
            // InternalSecLanguage.g:1896:1: ( () )
            // InternalSecLanguage.g:1897:1: ()
            {
             before(grammarAccess.getInputAccess().getInputAction_0()); 
            // InternalSecLanguage.g:1898:1: ()
            // InternalSecLanguage.g:1900:1: 
            {
            }

             after(grammarAccess.getInputAccess().getInputAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Input__Group__0__Impl"


    // $ANTLR start "rule__Input__Group__1"
    // InternalSecLanguage.g:1910:1: rule__Input__Group__1 : rule__Input__Group__1__Impl rule__Input__Group__2 ;
    public final void rule__Input__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalSecLanguage.g:1914:1: ( rule__Input__Group__1__Impl rule__Input__Group__2 )
            // InternalSecLanguage.g:1915:2: rule__Input__Group__1__Impl rule__Input__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_24);
            rule__Input__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Input__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Input__Group__1"


    // $ANTLR start "rule__Input__Group__1__Impl"
    // InternalSecLanguage.g:1922:1: rule__Input__Group__1__Impl : ( '(' ) ;
    public final void rule__Input__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalSecLanguage.g:1926:1: ( ( '(' ) )
            // InternalSecLanguage.g:1927:1: ( '(' )
            {
            // InternalSecLanguage.g:1927:1: ( '(' )
            // InternalSecLanguage.g:1928:1: '('
            {
             before(grammarAccess.getInputAccess().getLeftParenthesisKeyword_1()); 
            match(input,19,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getInputAccess().getLeftParenthesisKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Input__Group__1__Impl"


    // $ANTLR start "rule__Input__Group__2"
    // InternalSecLanguage.g:1941:1: rule__Input__Group__2 : rule__Input__Group__2__Impl rule__Input__Group__3 ;
    public final void rule__Input__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalSecLanguage.g:1945:1: ( rule__Input__Group__2__Impl rule__Input__Group__3 )
            // InternalSecLanguage.g:1946:2: rule__Input__Group__2__Impl rule__Input__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_8);
            rule__Input__Group__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Input__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Input__Group__2"


    // $ANTLR start "rule__Input__Group__2__Impl"
    // InternalSecLanguage.g:1953:1: rule__Input__Group__2__Impl : ( ( rule__Input__Group_2__0 ) ) ;
    public final void rule__Input__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalSecLanguage.g:1957:1: ( ( ( rule__Input__Group_2__0 ) ) )
            // InternalSecLanguage.g:1958:1: ( ( rule__Input__Group_2__0 ) )
            {
            // InternalSecLanguage.g:1958:1: ( ( rule__Input__Group_2__0 ) )
            // InternalSecLanguage.g:1959:1: ( rule__Input__Group_2__0 )
            {
             before(grammarAccess.getInputAccess().getGroup_2()); 
            // InternalSecLanguage.g:1960:1: ( rule__Input__Group_2__0 )
            // InternalSecLanguage.g:1960:2: rule__Input__Group_2__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Input__Group_2__0();

            state._fsp--;


            }

             after(grammarAccess.getInputAccess().getGroup_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Input__Group__2__Impl"


    // $ANTLR start "rule__Input__Group__3"
    // InternalSecLanguage.g:1970:1: rule__Input__Group__3 : rule__Input__Group__3__Impl ;
    public final void rule__Input__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalSecLanguage.g:1974:1: ( rule__Input__Group__3__Impl )
            // InternalSecLanguage.g:1975:2: rule__Input__Group__3__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Input__Group__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Input__Group__3"


    // $ANTLR start "rule__Input__Group__3__Impl"
    // InternalSecLanguage.g:1981:1: rule__Input__Group__3__Impl : ( ')' ) ;
    public final void rule__Input__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalSecLanguage.g:1985:1: ( ( ')' ) )
            // InternalSecLanguage.g:1986:1: ( ')' )
            {
            // InternalSecLanguage.g:1986:1: ( ')' )
            // InternalSecLanguage.g:1987:1: ')'
            {
             before(grammarAccess.getInputAccess().getRightParenthesisKeyword_3()); 
            match(input,21,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getInputAccess().getRightParenthesisKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Input__Group__3__Impl"


    // $ANTLR start "rule__Input__Group_2__0"
    // InternalSecLanguage.g:2008:1: rule__Input__Group_2__0 : rule__Input__Group_2__0__Impl rule__Input__Group_2__1 ;
    public final void rule__Input__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalSecLanguage.g:2012:1: ( rule__Input__Group_2__0__Impl rule__Input__Group_2__1 )
            // InternalSecLanguage.g:2013:2: rule__Input__Group_2__0__Impl rule__Input__Group_2__1
            {
            pushFollow(FollowSets000.FOLLOW_5);
            rule__Input__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Input__Group_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Input__Group_2__0"


    // $ANTLR start "rule__Input__Group_2__0__Impl"
    // InternalSecLanguage.g:2020:1: rule__Input__Group_2__0__Impl : ( 'field' ) ;
    public final void rule__Input__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalSecLanguage.g:2024:1: ( ( 'field' ) )
            // InternalSecLanguage.g:2025:1: ( 'field' )
            {
            // InternalSecLanguage.g:2025:1: ( 'field' )
            // InternalSecLanguage.g:2026:1: 'field'
            {
             before(grammarAccess.getInputAccess().getFieldKeyword_2_0()); 
            match(input,33,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getInputAccess().getFieldKeyword_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Input__Group_2__0__Impl"


    // $ANTLR start "rule__Input__Group_2__1"
    // InternalSecLanguage.g:2039:1: rule__Input__Group_2__1 : rule__Input__Group_2__1__Impl rule__Input__Group_2__2 ;
    public final void rule__Input__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalSecLanguage.g:2043:1: ( rule__Input__Group_2__1__Impl rule__Input__Group_2__2 )
            // InternalSecLanguage.g:2044:2: rule__Input__Group_2__1__Impl rule__Input__Group_2__2
            {
            pushFollow(FollowSets000.FOLLOW_21);
            rule__Input__Group_2__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Input__Group_2__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Input__Group_2__1"


    // $ANTLR start "rule__Input__Group_2__1__Impl"
    // InternalSecLanguage.g:2051:1: rule__Input__Group_2__1__Impl : ( ( rule__Input__NameAssignment_2_1 ) ) ;
    public final void rule__Input__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalSecLanguage.g:2055:1: ( ( ( rule__Input__NameAssignment_2_1 ) ) )
            // InternalSecLanguage.g:2056:1: ( ( rule__Input__NameAssignment_2_1 ) )
            {
            // InternalSecLanguage.g:2056:1: ( ( rule__Input__NameAssignment_2_1 ) )
            // InternalSecLanguage.g:2057:1: ( rule__Input__NameAssignment_2_1 )
            {
             before(grammarAccess.getInputAccess().getNameAssignment_2_1()); 
            // InternalSecLanguage.g:2058:1: ( rule__Input__NameAssignment_2_1 )
            // InternalSecLanguage.g:2058:2: rule__Input__NameAssignment_2_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Input__NameAssignment_2_1();

            state._fsp--;


            }

             after(grammarAccess.getInputAccess().getNameAssignment_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Input__Group_2__1__Impl"


    // $ANTLR start "rule__Input__Group_2__2"
    // InternalSecLanguage.g:2068:1: rule__Input__Group_2__2 : rule__Input__Group_2__2__Impl ;
    public final void rule__Input__Group_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalSecLanguage.g:2072:1: ( rule__Input__Group_2__2__Impl )
            // InternalSecLanguage.g:2073:2: rule__Input__Group_2__2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Input__Group_2__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Input__Group_2__2"


    // $ANTLR start "rule__Input__Group_2__2__Impl"
    // InternalSecLanguage.g:2079:1: rule__Input__Group_2__2__Impl : ( ( rule__Input__Group_2_2__0 )? ) ;
    public final void rule__Input__Group_2__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalSecLanguage.g:2083:1: ( ( ( rule__Input__Group_2_2__0 )? ) )
            // InternalSecLanguage.g:2084:1: ( ( rule__Input__Group_2_2__0 )? )
            {
            // InternalSecLanguage.g:2084:1: ( ( rule__Input__Group_2_2__0 )? )
            // InternalSecLanguage.g:2085:1: ( rule__Input__Group_2_2__0 )?
            {
             before(grammarAccess.getInputAccess().getGroup_2_2()); 
            // InternalSecLanguage.g:2086:1: ( rule__Input__Group_2_2__0 )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==31) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // InternalSecLanguage.g:2086:2: rule__Input__Group_2_2__0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__Input__Group_2_2__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getInputAccess().getGroup_2_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Input__Group_2__2__Impl"


    // $ANTLR start "rule__Input__Group_2_2__0"
    // InternalSecLanguage.g:2102:1: rule__Input__Group_2_2__0 : rule__Input__Group_2_2__0__Impl rule__Input__Group_2_2__1 ;
    public final void rule__Input__Group_2_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalSecLanguage.g:2106:1: ( rule__Input__Group_2_2__0__Impl rule__Input__Group_2_2__1 )
            // InternalSecLanguage.g:2107:2: rule__Input__Group_2_2__0__Impl rule__Input__Group_2_2__1
            {
            pushFollow(FollowSets000.FOLLOW_22);
            rule__Input__Group_2_2__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Input__Group_2_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Input__Group_2_2__0"


    // $ANTLR start "rule__Input__Group_2_2__0__Impl"
    // InternalSecLanguage.g:2114:1: rule__Input__Group_2_2__0__Impl : ( '[' ) ;
    public final void rule__Input__Group_2_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalSecLanguage.g:2118:1: ( ( '[' ) )
            // InternalSecLanguage.g:2119:1: ( '[' )
            {
            // InternalSecLanguage.g:2119:1: ( '[' )
            // InternalSecLanguage.g:2120:1: '['
            {
             before(grammarAccess.getInputAccess().getLeftSquareBracketKeyword_2_2_0()); 
            match(input,31,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getInputAccess().getLeftSquareBracketKeyword_2_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Input__Group_2_2__0__Impl"


    // $ANTLR start "rule__Input__Group_2_2__1"
    // InternalSecLanguage.g:2133:1: rule__Input__Group_2_2__1 : rule__Input__Group_2_2__1__Impl rule__Input__Group_2_2__2 ;
    public final void rule__Input__Group_2_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalSecLanguage.g:2137:1: ( rule__Input__Group_2_2__1__Impl rule__Input__Group_2_2__2 )
            // InternalSecLanguage.g:2138:2: rule__Input__Group_2_2__1__Impl rule__Input__Group_2_2__2
            {
            pushFollow(FollowSets000.FOLLOW_22);
            rule__Input__Group_2_2__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Input__Group_2_2__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Input__Group_2_2__1"


    // $ANTLR start "rule__Input__Group_2_2__1__Impl"
    // InternalSecLanguage.g:2145:1: rule__Input__Group_2_2__1__Impl : ( ( ruleEString )* ) ;
    public final void rule__Input__Group_2_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalSecLanguage.g:2149:1: ( ( ( ruleEString )* ) )
            // InternalSecLanguage.g:2150:1: ( ( ruleEString )* )
            {
            // InternalSecLanguage.g:2150:1: ( ( ruleEString )* )
            // InternalSecLanguage.g:2151:1: ( ruleEString )*
            {
             before(grammarAccess.getInputAccess().getEStringParserRuleCall_2_2_1()); 
            // InternalSecLanguage.g:2152:1: ( ruleEString )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( ((LA13_0>=RULE_STRING && LA13_0<=RULE_ID)) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // InternalSecLanguage.g:2152:3: ruleEString
            	    {
            	    pushFollow(FollowSets000.FOLLOW_23);
            	    ruleEString();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop13;
                }
            } while (true);

             after(grammarAccess.getInputAccess().getEStringParserRuleCall_2_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Input__Group_2_2__1__Impl"


    // $ANTLR start "rule__Input__Group_2_2__2"
    // InternalSecLanguage.g:2162:1: rule__Input__Group_2_2__2 : rule__Input__Group_2_2__2__Impl ;
    public final void rule__Input__Group_2_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalSecLanguage.g:2166:1: ( rule__Input__Group_2_2__2__Impl )
            // InternalSecLanguage.g:2167:2: rule__Input__Group_2_2__2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Input__Group_2_2__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Input__Group_2_2__2"


    // $ANTLR start "rule__Input__Group_2_2__2__Impl"
    // InternalSecLanguage.g:2173:1: rule__Input__Group_2_2__2__Impl : ( ']' ) ;
    public final void rule__Input__Group_2_2__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalSecLanguage.g:2177:1: ( ( ']' ) )
            // InternalSecLanguage.g:2178:1: ( ']' )
            {
            // InternalSecLanguage.g:2178:1: ( ']' )
            // InternalSecLanguage.g:2179:1: ']'
            {
             before(grammarAccess.getInputAccess().getRightSquareBracketKeyword_2_2_2()); 
            match(input,32,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getInputAccess().getRightSquareBracketKeyword_2_2_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Input__Group_2_2__2__Impl"


    // $ANTLR start "rule__SecurityTest__IdAssignment_3"
    // InternalSecLanguage.g:2199:1: rule__SecurityTest__IdAssignment_3 : ( ruleEString ) ;
    public final void rule__SecurityTest__IdAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalSecLanguage.g:2203:1: ( ( ruleEString ) )
            // InternalSecLanguage.g:2204:1: ( ruleEString )
            {
            // InternalSecLanguage.g:2204:1: ( ruleEString )
            // InternalSecLanguage.g:2205:1: ruleEString
            {
             before(grammarAccess.getSecurityTestAccess().getIdEStringParserRuleCall_3_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getSecurityTestAccess().getIdEStringParserRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SecurityTest__IdAssignment_3"


    // $ANTLR start "rule__SecurityTest__ScopeAssignment_4_2"
    // InternalSecLanguage.g:2214:1: rule__SecurityTest__ScopeAssignment_4_2 : ( ruleTargetOfEvaluation ) ;
    public final void rule__SecurityTest__ScopeAssignment_4_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalSecLanguage.g:2218:1: ( ( ruleTargetOfEvaluation ) )
            // InternalSecLanguage.g:2219:1: ( ruleTargetOfEvaluation )
            {
            // InternalSecLanguage.g:2219:1: ( ruleTargetOfEvaluation )
            // InternalSecLanguage.g:2220:1: ruleTargetOfEvaluation
            {
             before(grammarAccess.getSecurityTestAccess().getScopeTargetOfEvaluationParserRuleCall_4_2_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleTargetOfEvaluation();

            state._fsp--;

             after(grammarAccess.getSecurityTestAccess().getScopeTargetOfEvaluationParserRuleCall_4_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SecurityTest__ScopeAssignment_4_2"


    // $ANTLR start "rule__SecurityTest__PossibleAttacksAssignment_5_2"
    // InternalSecLanguage.g:2229:1: rule__SecurityTest__PossibleAttacksAssignment_5_2 : ( ruleAttack ) ;
    public final void rule__SecurityTest__PossibleAttacksAssignment_5_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalSecLanguage.g:2233:1: ( ( ruleAttack ) )
            // InternalSecLanguage.g:2234:1: ( ruleAttack )
            {
            // InternalSecLanguage.g:2234:1: ( ruleAttack )
            // InternalSecLanguage.g:2235:1: ruleAttack
            {
             before(grammarAccess.getSecurityTestAccess().getPossibleAttacksAttackParserRuleCall_5_2_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleAttack();

            state._fsp--;

             after(grammarAccess.getSecurityTestAccess().getPossibleAttacksAttackParserRuleCall_5_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SecurityTest__PossibleAttacksAssignment_5_2"


    // $ANTLR start "rule__TargetOfEvaluation__DomainAssignment_2_1"
    // InternalSecLanguage.g:2244:1: rule__TargetOfEvaluation__DomainAssignment_2_1 : ( ruleEString ) ;
    public final void rule__TargetOfEvaluation__DomainAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalSecLanguage.g:2248:1: ( ( ruleEString ) )
            // InternalSecLanguage.g:2249:1: ( ruleEString )
            {
            // InternalSecLanguage.g:2249:1: ( ruleEString )
            // InternalSecLanguage.g:2250:1: ruleEString
            {
             before(grammarAccess.getTargetOfEvaluationAccess().getDomainEStringParserRuleCall_2_1_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getTargetOfEvaluationAccess().getDomainEStringParserRuleCall_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TargetOfEvaluation__DomainAssignment_2_1"


    // $ANTLR start "rule__TargetOfEvaluation__ComponentsAssignment_2_2"
    // InternalSecLanguage.g:2259:1: rule__TargetOfEvaluation__ComponentsAssignment_2_2 : ( ruleWebComponent ) ;
    public final void rule__TargetOfEvaluation__ComponentsAssignment_2_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalSecLanguage.g:2263:1: ( ( ruleWebComponent ) )
            // InternalSecLanguage.g:2264:1: ( ruleWebComponent )
            {
            // InternalSecLanguage.g:2264:1: ( ruleWebComponent )
            // InternalSecLanguage.g:2265:1: ruleWebComponent
            {
             before(grammarAccess.getTargetOfEvaluationAccess().getComponentsWebComponentParserRuleCall_2_2_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleWebComponent();

            state._fsp--;

             after(grammarAccess.getTargetOfEvaluationAccess().getComponentsWebComponentParserRuleCall_2_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TargetOfEvaluation__ComponentsAssignment_2_2"


    // $ANTLR start "rule__Attack__NameAssignment_2_1"
    // InternalSecLanguage.g:2274:1: rule__Attack__NameAssignment_2_1 : ( ruleEAttackMethod ) ;
    public final void rule__Attack__NameAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalSecLanguage.g:2278:1: ( ( ruleEAttackMethod ) )
            // InternalSecLanguage.g:2279:1: ( ruleEAttackMethod )
            {
            // InternalSecLanguage.g:2279:1: ( ruleEAttackMethod )
            // InternalSecLanguage.g:2280:1: ruleEAttackMethod
            {
             before(grammarAccess.getAttackAccess().getNameEAttackMethodEnumRuleCall_2_1_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleEAttackMethod();

            state._fsp--;

             after(grammarAccess.getAttackAccess().getNameEAttackMethodEnumRuleCall_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Attack__NameAssignment_2_1"


    // $ANTLR start "rule__Attack__SeverityAssignment_2_2_2"
    // InternalSecLanguage.g:2289:1: rule__Attack__SeverityAssignment_2_2_2 : ( ruleESeverity ) ;
    public final void rule__Attack__SeverityAssignment_2_2_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalSecLanguage.g:2293:1: ( ( ruleESeverity ) )
            // InternalSecLanguage.g:2294:1: ( ruleESeverity )
            {
            // InternalSecLanguage.g:2294:1: ( ruleESeverity )
            // InternalSecLanguage.g:2295:1: ruleESeverity
            {
             before(grammarAccess.getAttackAccess().getSeverityESeverityEnumRuleCall_2_2_2_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleESeverity();

            state._fsp--;

             after(grammarAccess.getAttackAccess().getSeverityESeverityEnumRuleCall_2_2_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Attack__SeverityAssignment_2_2_2"


    // $ANTLR start "rule__WebComponent__PathAssignment_2_1"
    // InternalSecLanguage.g:2304:1: rule__WebComponent__PathAssignment_2_1 : ( ruleEString ) ;
    public final void rule__WebComponent__PathAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalSecLanguage.g:2308:1: ( ( ruleEString ) )
            // InternalSecLanguage.g:2309:1: ( ruleEString )
            {
            // InternalSecLanguage.g:2309:1: ( ruleEString )
            // InternalSecLanguage.g:2310:1: ruleEString
            {
             before(grammarAccess.getWebComponentAccess().getPathEStringParserRuleCall_2_1_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getWebComponentAccess().getPathEStringParserRuleCall_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__WebComponent__PathAssignment_2_1"


    // $ANTLR start "rule__WebComponent__InputsAssignment_2_3"
    // InternalSecLanguage.g:2319:1: rule__WebComponent__InputsAssignment_2_3 : ( ruleInput ) ;
    public final void rule__WebComponent__InputsAssignment_2_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalSecLanguage.g:2323:1: ( ( ruleInput ) )
            // InternalSecLanguage.g:2324:1: ( ruleInput )
            {
            // InternalSecLanguage.g:2324:1: ( ruleInput )
            // InternalSecLanguage.g:2325:1: ruleInput
            {
             before(grammarAccess.getWebComponentAccess().getInputsInputParserRuleCall_2_3_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleInput();

            state._fsp--;

             after(grammarAccess.getWebComponentAccess().getInputsInputParserRuleCall_2_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__WebComponent__InputsAssignment_2_3"


    // $ANTLR start "rule__Input__NameAssignment_2_1"
    // InternalSecLanguage.g:2334:1: rule__Input__NameAssignment_2_1 : ( ruleEString ) ;
    public final void rule__Input__NameAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalSecLanguage.g:2338:1: ( ( ruleEString ) )
            // InternalSecLanguage.g:2339:1: ( ruleEString )
            {
            // InternalSecLanguage.g:2339:1: ( ruleEString )
            // InternalSecLanguage.g:2340:1: ruleEString
            {
             before(grammarAccess.getInputAccess().getNameEStringParserRuleCall_2_1_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getInputAccess().getNameEStringParserRuleCall_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Input__NameAssignment_2_1"

    // Delegated rules


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000080000L});
        public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000100000L});
        public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000280000L});
        public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000400000L});
        public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000200000L});
        public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000800000L});
        public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000080002L});
        public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000001000000L});
        public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000002000000L});
        public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x000000000007C000L});
        public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000004000000L});
        public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000008000000L});
        public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000000003800L});
        public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000010000000L});
        public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000020000000L});
        public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000004080000L});
        public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000040000000L});
        public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000080000000L});
        public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000100000030L});
        public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000000000032L});
        public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000000200000000L});
    }


}