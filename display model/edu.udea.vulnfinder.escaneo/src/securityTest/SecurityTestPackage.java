/**
 */
package securityTest;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see securityTest.SecurityTestFactory
 * @model kind="package"
 * @generated
 */
public interface SecurityTestPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "securityTest";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://udea/vulnfinder/securityTest";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "securityTest";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	SecurityTestPackage eINSTANCE = securityTest.impl.SecurityTestPackageImpl.init();

	/**
	 * The meta object id for the '{@link securityTest.impl.TestImpl <em>Test</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see securityTest.impl.TestImpl
	 * @see securityTest.impl.SecurityTestPackageImpl#getTest()
	 * @generated
	 */
	int TEST = 0;

	/**
	 * The feature id for the '<em><b>Scope</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST__SCOPE = 0;

	/**
	 * The feature id for the '<em><b>Possible Attacks</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST__POSSIBLE_ATTACKS = 1;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST__ID = 2;

	/**
	 * The feature id for the '<em><b>Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST__DATE = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST__NAME = 4;

	/**
	 * The feature id for the '<em><b>Note</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST__NOTE = 5;

	/**
	 * The number of structural features of the '<em>Test</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_FEATURE_COUNT = 6;

	/**
	 * The number of operations of the '<em>Test</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link securityTest.impl.TargetOfEvaluationImpl <em>Target Of Evaluation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see securityTest.impl.TargetOfEvaluationImpl
	 * @see securityTest.impl.SecurityTestPackageImpl#getTargetOfEvaluation()
	 * @generated
	 */
	int TARGET_OF_EVALUATION = 1;

	/**
	 * The feature id for the '<em><b>Domain</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_OF_EVALUATION__DOMAIN = 0;

	/**
	 * The feature id for the '<em><b>Components</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_OF_EVALUATION__COMPONENTS = 1;

	/**
	 * The feature id for the '<em><b>Ip</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_OF_EVALUATION__IP = 2;

	/**
	 * The feature id for the '<em><b>Protocol</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_OF_EVALUATION__PROTOCOL = 3;

	/**
	 * The feature id for the '<em><b>Port</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_OF_EVALUATION__PORT = 4;

	/**
	 * The number of structural features of the '<em>Target Of Evaluation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_OF_EVALUATION_FEATURE_COUNT = 5;

	/**
	 * The number of operations of the '<em>Target Of Evaluation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_OF_EVALUATION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link securityTest.impl.WebComponentImpl <em>Web Component</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see securityTest.impl.WebComponentImpl
	 * @see securityTest.impl.SecurityTestPackageImpl#getWebComponent()
	 * @generated
	 */
	int WEB_COMPONENT = 2;

	/**
	 * The feature id for the '<em><b>Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WEB_COMPONENT__PATH = 0;

	/**
	 * The feature id for the '<em><b>Target Links</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WEB_COMPONENT__TARGET_LINKS = 1;

	/**
	 * The feature id for the '<em><b>Inputs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WEB_COMPONENT__INPUTS = 2;

	/**
	 * The number of structural features of the '<em>Web Component</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WEB_COMPONENT_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Web Component</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WEB_COMPONENT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link securityTest.impl.InputImpl <em>Input</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see securityTest.impl.InputImpl
	 * @see securityTest.impl.SecurityTestPackageImpl#getInput()
	 * @generated
	 */
	int INPUT = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT__NAME = 0;

	/**
	 * The feature id for the '<em><b>Attacks</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT__ATTACKS = 1;

	/**
	 * The number of structural features of the '<em>Input</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Input</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link securityTest.impl.AttackImpl <em>Attack</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see securityTest.impl.AttackImpl
	 * @see securityTest.impl.SecurityTestPackageImpl#getAttack()
	 * @generated
	 */
	int ATTACK = 4;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTACK__NAME = 0;

	/**
	 * The feature id for the '<em><b>Severity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTACK__SEVERITY = 1;

	/**
	 * The number of structural features of the '<em>Attack</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTACK_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Attack</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTACK_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link securityTest.impl.NoteImpl <em>Note</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see securityTest.impl.NoteImpl
	 * @see securityTest.impl.SecurityTestPackageImpl#getNote()
	 * @generated
	 */
	int NOTE = 5;

	/**
	 * The feature id for the '<em><b>Note Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOTE__NOTE_TEXT = 0;

	/**
	 * The number of structural features of the '<em>Note</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOTE_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Note</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOTE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link securityTest.ESeverity <em>ESeverity</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see securityTest.ESeverity
	 * @see securityTest.impl.SecurityTestPackageImpl#getESeverity()
	 * @generated
	 */
	int ESEVERITY = 6;

	/**
	 * The meta object id for the '{@link securityTest.EAttackMethod <em>EAttack Method</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see securityTest.EAttackMethod
	 * @see securityTest.impl.SecurityTestPackageImpl#getEAttackMethod()
	 * @generated
	 */
	int EATTACK_METHOD = 7;


	/**
	 * Returns the meta object for class '{@link securityTest.Test <em>Test</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Test</em>'.
	 * @see securityTest.Test
	 * @generated
	 */
	EClass getTest();

	/**
	 * Returns the meta object for the containment reference '{@link securityTest.Test#getScope <em>Scope</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Scope</em>'.
	 * @see securityTest.Test#getScope()
	 * @see #getTest()
	 * @generated
	 */
	EReference getTest_Scope();

	/**
	 * Returns the meta object for the containment reference list '{@link securityTest.Test#getPossibleAttacks <em>Possible Attacks</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Possible Attacks</em>'.
	 * @see securityTest.Test#getPossibleAttacks()
	 * @see #getTest()
	 * @generated
	 */
	EReference getTest_PossibleAttacks();

	/**
	 * Returns the meta object for the attribute '{@link securityTest.Test#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see securityTest.Test#getId()
	 * @see #getTest()
	 * @generated
	 */
	EAttribute getTest_Id();

	/**
	 * Returns the meta object for the attribute '{@link securityTest.Test#getDate <em>Date</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Date</em>'.
	 * @see securityTest.Test#getDate()
	 * @see #getTest()
	 * @generated
	 */
	EAttribute getTest_Date();

	/**
	 * Returns the meta object for the attribute '{@link securityTest.Test#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see securityTest.Test#getName()
	 * @see #getTest()
	 * @generated
	 */
	EAttribute getTest_Name();

	/**
	 * Returns the meta object for the containment reference '{@link securityTest.Test#getNote <em>Note</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Note</em>'.
	 * @see securityTest.Test#getNote()
	 * @see #getTest()
	 * @generated
	 */
	EReference getTest_Note();

	/**
	 * Returns the meta object for class '{@link securityTest.TargetOfEvaluation <em>Target Of Evaluation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Target Of Evaluation</em>'.
	 * @see securityTest.TargetOfEvaluation
	 * @generated
	 */
	EClass getTargetOfEvaluation();

	/**
	 * Returns the meta object for the attribute '{@link securityTest.TargetOfEvaluation#getDomain <em>Domain</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Domain</em>'.
	 * @see securityTest.TargetOfEvaluation#getDomain()
	 * @see #getTargetOfEvaluation()
	 * @generated
	 */
	EAttribute getTargetOfEvaluation_Domain();

	/**
	 * Returns the meta object for the containment reference list '{@link securityTest.TargetOfEvaluation#getComponents <em>Components</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Components</em>'.
	 * @see securityTest.TargetOfEvaluation#getComponents()
	 * @see #getTargetOfEvaluation()
	 * @generated
	 */
	EReference getTargetOfEvaluation_Components();

	/**
	 * Returns the meta object for the attribute '{@link securityTest.TargetOfEvaluation#getIp <em>Ip</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Ip</em>'.
	 * @see securityTest.TargetOfEvaluation#getIp()
	 * @see #getTargetOfEvaluation()
	 * @generated
	 */
	EAttribute getTargetOfEvaluation_Ip();

	/**
	 * Returns the meta object for the attribute '{@link securityTest.TargetOfEvaluation#getProtocol <em>Protocol</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Protocol</em>'.
	 * @see securityTest.TargetOfEvaluation#getProtocol()
	 * @see #getTargetOfEvaluation()
	 * @generated
	 */
	EAttribute getTargetOfEvaluation_Protocol();

	/**
	 * Returns the meta object for the attribute '{@link securityTest.TargetOfEvaluation#getPort <em>Port</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Port</em>'.
	 * @see securityTest.TargetOfEvaluation#getPort()
	 * @see #getTargetOfEvaluation()
	 * @generated
	 */
	EAttribute getTargetOfEvaluation_Port();

	/**
	 * Returns the meta object for class '{@link securityTest.WebComponent <em>Web Component</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Web Component</em>'.
	 * @see securityTest.WebComponent
	 * @generated
	 */
	EClass getWebComponent();

	/**
	 * Returns the meta object for the attribute '{@link securityTest.WebComponent#getPath <em>Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Path</em>'.
	 * @see securityTest.WebComponent#getPath()
	 * @see #getWebComponent()
	 * @generated
	 */
	EAttribute getWebComponent_Path();

	/**
	 * Returns the meta object for the reference list '{@link securityTest.WebComponent#getTargetLinks <em>Target Links</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Target Links</em>'.
	 * @see securityTest.WebComponent#getTargetLinks()
	 * @see #getWebComponent()
	 * @generated
	 */
	EReference getWebComponent_TargetLinks();

	/**
	 * Returns the meta object for the containment reference list '{@link securityTest.WebComponent#getInputs <em>Inputs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Inputs</em>'.
	 * @see securityTest.WebComponent#getInputs()
	 * @see #getWebComponent()
	 * @generated
	 */
	EReference getWebComponent_Inputs();

	/**
	 * Returns the meta object for class '{@link securityTest.Input <em>Input</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Input</em>'.
	 * @see securityTest.Input
	 * @generated
	 */
	EClass getInput();

	/**
	 * Returns the meta object for the attribute '{@link securityTest.Input#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see securityTest.Input#getName()
	 * @see #getInput()
	 * @generated
	 */
	EAttribute getInput_Name();

	/**
	 * Returns the meta object for the reference list '{@link securityTest.Input#getAttacks <em>Attacks</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Attacks</em>'.
	 * @see securityTest.Input#getAttacks()
	 * @see #getInput()
	 * @generated
	 */
	EReference getInput_Attacks();

	/**
	 * Returns the meta object for class '{@link securityTest.Attack <em>Attack</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Attack</em>'.
	 * @see securityTest.Attack
	 * @generated
	 */
	EClass getAttack();

	/**
	 * Returns the meta object for the attribute '{@link securityTest.Attack#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see securityTest.Attack#getName()
	 * @see #getAttack()
	 * @generated
	 */
	EAttribute getAttack_Name();

	/**
	 * Returns the meta object for the attribute '{@link securityTest.Attack#getSeverity <em>Severity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Severity</em>'.
	 * @see securityTest.Attack#getSeverity()
	 * @see #getAttack()
	 * @generated
	 */
	EAttribute getAttack_Severity();

	/**
	 * Returns the meta object for class '{@link securityTest.Note <em>Note</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Note</em>'.
	 * @see securityTest.Note
	 * @generated
	 */
	EClass getNote();

	/**
	 * Returns the meta object for the attribute '{@link securityTest.Note#getNoteText <em>Note Text</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Note Text</em>'.
	 * @see securityTest.Note#getNoteText()
	 * @see #getNote()
	 * @generated
	 */
	EAttribute getNote_NoteText();

	/**
	 * Returns the meta object for enum '{@link securityTest.ESeverity <em>ESeverity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>ESeverity</em>'.
	 * @see securityTest.ESeverity
	 * @generated
	 */
	EEnum getESeverity();

	/**
	 * Returns the meta object for enum '{@link securityTest.EAttackMethod <em>EAttack Method</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>EAttack Method</em>'.
	 * @see securityTest.EAttackMethod
	 * @generated
	 */
	EEnum getEAttackMethod();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	SecurityTestFactory getSecurityTestFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link securityTest.impl.TestImpl <em>Test</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see securityTest.impl.TestImpl
		 * @see securityTest.impl.SecurityTestPackageImpl#getTest()
		 * @generated
		 */
		EClass TEST = eINSTANCE.getTest();

		/**
		 * The meta object literal for the '<em><b>Scope</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TEST__SCOPE = eINSTANCE.getTest_Scope();

		/**
		 * The meta object literal for the '<em><b>Possible Attacks</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TEST__POSSIBLE_ATTACKS = eINSTANCE.getTest_PossibleAttacks();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TEST__ID = eINSTANCE.getTest_Id();

		/**
		 * The meta object literal for the '<em><b>Date</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TEST__DATE = eINSTANCE.getTest_Date();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TEST__NAME = eINSTANCE.getTest_Name();

		/**
		 * The meta object literal for the '<em><b>Note</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TEST__NOTE = eINSTANCE.getTest_Note();

		/**
		 * The meta object literal for the '{@link securityTest.impl.TargetOfEvaluationImpl <em>Target Of Evaluation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see securityTest.impl.TargetOfEvaluationImpl
		 * @see securityTest.impl.SecurityTestPackageImpl#getTargetOfEvaluation()
		 * @generated
		 */
		EClass TARGET_OF_EVALUATION = eINSTANCE.getTargetOfEvaluation();

		/**
		 * The meta object literal for the '<em><b>Domain</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TARGET_OF_EVALUATION__DOMAIN = eINSTANCE.getTargetOfEvaluation_Domain();

		/**
		 * The meta object literal for the '<em><b>Components</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TARGET_OF_EVALUATION__COMPONENTS = eINSTANCE.getTargetOfEvaluation_Components();

		/**
		 * The meta object literal for the '<em><b>Ip</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TARGET_OF_EVALUATION__IP = eINSTANCE.getTargetOfEvaluation_Ip();

		/**
		 * The meta object literal for the '<em><b>Protocol</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TARGET_OF_EVALUATION__PROTOCOL = eINSTANCE.getTargetOfEvaluation_Protocol();

		/**
		 * The meta object literal for the '<em><b>Port</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TARGET_OF_EVALUATION__PORT = eINSTANCE.getTargetOfEvaluation_Port();

		/**
		 * The meta object literal for the '{@link securityTest.impl.WebComponentImpl <em>Web Component</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see securityTest.impl.WebComponentImpl
		 * @see securityTest.impl.SecurityTestPackageImpl#getWebComponent()
		 * @generated
		 */
		EClass WEB_COMPONENT = eINSTANCE.getWebComponent();

		/**
		 * The meta object literal for the '<em><b>Path</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute WEB_COMPONENT__PATH = eINSTANCE.getWebComponent_Path();

		/**
		 * The meta object literal for the '<em><b>Target Links</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference WEB_COMPONENT__TARGET_LINKS = eINSTANCE.getWebComponent_TargetLinks();

		/**
		 * The meta object literal for the '<em><b>Inputs</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference WEB_COMPONENT__INPUTS = eINSTANCE.getWebComponent_Inputs();

		/**
		 * The meta object literal for the '{@link securityTest.impl.InputImpl <em>Input</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see securityTest.impl.InputImpl
		 * @see securityTest.impl.SecurityTestPackageImpl#getInput()
		 * @generated
		 */
		EClass INPUT = eINSTANCE.getInput();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INPUT__NAME = eINSTANCE.getInput_Name();

		/**
		 * The meta object literal for the '<em><b>Attacks</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INPUT__ATTACKS = eINSTANCE.getInput_Attacks();

		/**
		 * The meta object literal for the '{@link securityTest.impl.AttackImpl <em>Attack</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see securityTest.impl.AttackImpl
		 * @see securityTest.impl.SecurityTestPackageImpl#getAttack()
		 * @generated
		 */
		EClass ATTACK = eINSTANCE.getAttack();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ATTACK__NAME = eINSTANCE.getAttack_Name();

		/**
		 * The meta object literal for the '<em><b>Severity</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ATTACK__SEVERITY = eINSTANCE.getAttack_Severity();

		/**
		 * The meta object literal for the '{@link securityTest.impl.NoteImpl <em>Note</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see securityTest.impl.NoteImpl
		 * @see securityTest.impl.SecurityTestPackageImpl#getNote()
		 * @generated
		 */
		EClass NOTE = eINSTANCE.getNote();

		/**
		 * The meta object literal for the '<em><b>Note Text</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NOTE__NOTE_TEXT = eINSTANCE.getNote_NoteText();

		/**
		 * The meta object literal for the '{@link securityTest.ESeverity <em>ESeverity</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see securityTest.ESeverity
		 * @see securityTest.impl.SecurityTestPackageImpl#getESeverity()
		 * @generated
		 */
		EEnum ESEVERITY = eINSTANCE.getESeverity();

		/**
		 * The meta object literal for the '{@link securityTest.EAttackMethod <em>EAttack Method</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see securityTest.EAttackMethod
		 * @see securityTest.impl.SecurityTestPackageImpl#getEAttackMethod()
		 * @generated
		 */
		EEnum EATTACK_METHOD = eINSTANCE.getEAttackMethod();

	}

} //SecurityTestPackage
