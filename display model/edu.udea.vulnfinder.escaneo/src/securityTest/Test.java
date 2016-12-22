/**
 */
package securityTest;

import java.util.Date;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Test</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link securityTest.Test#getScope <em>Scope</em>}</li>
 *   <li>{@link securityTest.Test#getPossibleAttacks <em>Possible Attacks</em>}</li>
 *   <li>{@link securityTest.Test#getId <em>Id</em>}</li>
 *   <li>{@link securityTest.Test#getDate <em>Date</em>}</li>
 *   <li>{@link securityTest.Test#getName <em>Name</em>}</li>
 *   <li>{@link securityTest.Test#getNote <em>Note</em>}</li>
 *   <li>{@link securityTest.Test#getSeverity <em>Severity</em>}</li>
 *   <li>{@link securityTest.Test#getAuthSetting <em>Auth Setting</em>}</li>
 * </ul>
 *
 * @see securityTest.SecurityTestPackage#getTest()
 * @model
 * @generated
 */
public interface Test extends EObject {
	/**
	 * Returns the value of the '<em><b>Scope</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Scope</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Scope</em>' containment reference.
	 * @see #setScope(TargetOfEvaluation)
	 * @see securityTest.SecurityTestPackage#getTest_Scope()
	 * @model containment="true" required="true"
	 * @generated
	 */
	TargetOfEvaluation getScope();

	/**
	 * Sets the value of the '{@link securityTest.Test#getScope <em>Scope</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Scope</em>' containment reference.
	 * @see #getScope()
	 * @generated
	 */
	void setScope(TargetOfEvaluation value);

	/**
	 * Returns the value of the '<em><b>Possible Attacks</b></em>' containment reference list.
	 * The list contents are of type {@link securityTest.Attack}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Possible Attacks</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Possible Attacks</em>' containment reference list.
	 * @see securityTest.SecurityTestPackage#getTest_PossibleAttacks()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<Attack> getPossibleAttacks();

	/**
	 * Returns the value of the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Id</em>' attribute.
	 * @see #setId(String)
	 * @see securityTest.SecurityTestPackage#getTest_Id()
	 * @model id="true"
	 * @generated
	 */
	String getId();

	/**
	 * Sets the value of the '{@link securityTest.Test#getId <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Id</em>' attribute.
	 * @see #getId()
	 * @generated
	 */
	void setId(String value);

	/**
	 * Returns the value of the '<em><b>Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Date</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Date</em>' attribute.
	 * @see #setDate(Date)
	 * @see securityTest.SecurityTestPackage#getTest_Date()
	 * @model
	 * @generated
	 */
	Date getDate();

	/**
	 * Sets the value of the '{@link securityTest.Test#getDate <em>Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Date</em>' attribute.
	 * @see #getDate()
	 * @generated
	 */
	void setDate(Date value);

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see securityTest.SecurityTestPackage#getTest_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link securityTest.Test#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Note</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Note</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Note</em>' containment reference.
	 * @see #setNote(Note)
	 * @see securityTest.SecurityTestPackage#getTest_Note()
	 * @model containment="true"
	 * @generated
	 */
	Note getNote();

	/**
	 * Sets the value of the '{@link securityTest.Test#getNote <em>Note</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Note</em>' containment reference.
	 * @see #getNote()
	 * @generated
	 */
	void setNote(Note value);

	/**
	 * Returns the value of the '<em><b>Severity</b></em>' attribute.
	 * The literals are from the enumeration {@link securityTest.ESeverity}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Severity</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Severity</em>' attribute.
	 * @see securityTest.ESeverity
	 * @see #setSeverity(ESeverity)
	 * @see securityTest.SecurityTestPackage#getTest_Severity()
	 * @model
	 * @generated
	 */
	ESeverity getSeverity();

	/**
	 * Sets the value of the '{@link securityTest.Test#getSeverity <em>Severity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Severity</em>' attribute.
	 * @see securityTest.ESeverity
	 * @see #getSeverity()
	 * @generated
	 */
	void setSeverity(ESeverity value);

	/**
	 * Returns the value of the '<em><b>Auth Setting</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Auth Setting</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Auth Setting</em>' containment reference.
	 * @see #setAuthSetting(AuthSetting)
	 * @see securityTest.SecurityTestPackage#getTest_AuthSetting()
	 * @model containment="true"
	 * @generated
	 */
	AuthSetting getAuthSetting();

	/**
	 * Sets the value of the '{@link securityTest.Test#getAuthSetting <em>Auth Setting</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Auth Setting</em>' containment reference.
	 * @see #getAuthSetting()
	 * @generated
	 */
	void setAuthSetting(AuthSetting value);

} // Test
