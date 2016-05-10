/**
 */
package securityTest;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Web Component</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link securityTest.WebComponent#getPath <em>Path</em>}</li>
 *   <li>{@link securityTest.WebComponent#getTargetLinks <em>Target Links</em>}</li>
 *   <li>{@link securityTest.WebComponent#getInputs <em>Inputs</em>}</li>
 * </ul>
 *
 * @see securityTest.SecurityTestPackage#getWebComponent()
 * @model
 * @generated
 */
public interface WebComponent extends EObject {
	/**
	 * Returns the value of the '<em><b>Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Path</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Path</em>' attribute.
	 * @see #setPath(String)
	 * @see securityTest.SecurityTestPackage#getWebComponent_Path()
	 * @model
	 * @generated
	 */
	String getPath();

	/**
	 * Sets the value of the '{@link securityTest.WebComponent#getPath <em>Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Path</em>' attribute.
	 * @see #getPath()
	 * @generated
	 */
	void setPath(String value);

	/**
	 * Returns the value of the '<em><b>Target Links</b></em>' reference list.
	 * The list contents are of type {@link securityTest.WebComponent}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target Links</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target Links</em>' reference list.
	 * @see securityTest.SecurityTestPackage#getWebComponent_TargetLinks()
	 * @model
	 * @generated
	 */
	EList<WebComponent> getTargetLinks();

	/**
	 * Returns the value of the '<em><b>Inputs</b></em>' containment reference list.
	 * The list contents are of type {@link securityTest.Input}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Inputs</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Inputs</em>' containment reference list.
	 * @see securityTest.SecurityTestPackage#getWebComponent_Inputs()
	 * @model containment="true"
	 * @generated
	 */
	EList<Input> getInputs();

} // WebComponent
