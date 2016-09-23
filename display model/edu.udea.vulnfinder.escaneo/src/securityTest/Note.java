/**
 */
package securityTest;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Note</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link securityTest.Note#getNoteText <em>Note Text</em>}</li>
 * </ul>
 *
 * @see securityTest.SecurityTestPackage#getNote()
 * @model
 * @generated
 */
public interface Note extends EObject {
	/**
	 * Returns the value of the '<em><b>Note Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Note Text</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Note Text</em>' attribute.
	 * @see #setNoteText(String)
	 * @see securityTest.SecurityTestPackage#getNote_NoteText()
	 * @model
	 * @generated
	 */
	String getNoteText();

	/**
	 * Sets the value of the '{@link securityTest.Note#getNoteText <em>Note Text</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Note Text</em>' attribute.
	 * @see #getNoteText()
	 * @generated
	 */
	void setNoteText(String value);

} // Note
