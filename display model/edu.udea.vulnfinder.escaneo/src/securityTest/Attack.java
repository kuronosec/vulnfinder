/**
 */
package securityTest;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Attack</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link securityTest.Attack#getName <em>Name</em>}</li>
 *   <li>{@link securityTest.Attack#getSeverity <em>Severity</em>}</li>
 * </ul>
 *
 * @see securityTest.SecurityTestPackage#getAttack()
 * @model
 * @generated
 */
public interface Attack extends EObject {
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
	 * @see securityTest.SecurityTestPackage#getAttack_Name()
	 * @model id="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link securityTest.Attack#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

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
	 * @see securityTest.SecurityTestPackage#getAttack_Severity()
	 * @model
	 * @generated
	 */
	ESeverity getSeverity();

	/**
	 * Sets the value of the '{@link securityTest.Attack#getSeverity <em>Severity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Severity</em>' attribute.
	 * @see securityTest.ESeverity
	 * @see #getSeverity()
	 * @generated
	 */
	void setSeverity(ESeverity value);

} // Attack
