/**
 */
package securityTest;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Auth Setting</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link securityTest.AuthSetting#getRoles <em>Roles</em>}</li>
 *   <li>{@link securityTest.AuthSetting#getUsernameParam <em>Username Param</em>}</li>
 *   <li>{@link securityTest.AuthSetting#getPasswordParam <em>Password Param</em>}</li>
 *   <li>{@link securityTest.AuthSetting#getLoginTargetURL <em>Login Target URL</em>}</li>
 *   <li>{@link securityTest.AuthSetting#getLoginMessagePattern <em>Login Message Pattern</em>}</li>
 *   <li>{@link securityTest.AuthSetting#getLogoutMessagePattern <em>Logout Message Pattern</em>}</li>
 * </ul>
 *
 * @see securityTest.SecurityTestPackage#getAuthSetting()
 * @model
 * @generated
 */
public interface AuthSetting extends EObject {
	/**
	 * Returns the value of the '<em><b>Roles</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Roles</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Roles</em>' attribute list.
	 * @see securityTest.SecurityTestPackage#getAuthSetting_Roles()
	 * @model
	 * @generated
	 */
	EList<String> getRoles();

	/**
	 * Returns the value of the '<em><b>Username Param</b></em>' attribute.
	 * The default value is <code>"username"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Username Param</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Username Param</em>' attribute.
	 * @see #setUsernameParam(String)
	 * @see securityTest.SecurityTestPackage#getAuthSetting_UsernameParam()
	 * @model default="username"
	 * @generated
	 */
	String getUsernameParam();

	/**
	 * Sets the value of the '{@link securityTest.AuthSetting#getUsernameParam <em>Username Param</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Username Param</em>' attribute.
	 * @see #getUsernameParam()
	 * @generated
	 */
	void setUsernameParam(String value);

	/**
	 * Returns the value of the '<em><b>Password Param</b></em>' attribute.
	 * The default value is <code>"password"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Password Param</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Password Param</em>' attribute.
	 * @see #setPasswordParam(String)
	 * @see securityTest.SecurityTestPackage#getAuthSetting_PasswordParam()
	 * @model default="password"
	 * @generated
	 */
	String getPasswordParam();

	/**
	 * Sets the value of the '{@link securityTest.AuthSetting#getPasswordParam <em>Password Param</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Password Param</em>' attribute.
	 * @see #getPasswordParam()
	 * @generated
	 */
	void setPasswordParam(String value);

	/**
	 * Returns the value of the '<em><b>Login Target URL</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Login Target URL</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Login Target URL</em>' attribute.
	 * @see #setLoginTargetURL(String)
	 * @see securityTest.SecurityTestPackage#getAuthSetting_LoginTargetURL()
	 * @model
	 * @generated
	 */
	String getLoginTargetURL();

	/**
	 * Sets the value of the '{@link securityTest.AuthSetting#getLoginTargetURL <em>Login Target URL</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Login Target URL</em>' attribute.
	 * @see #getLoginTargetURL()
	 * @generated
	 */
	void setLoginTargetURL(String value);

	/**
	 * Returns the value of the '<em><b>Login Message Pattern</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Login Message Pattern</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Login Message Pattern</em>' attribute.
	 * @see #setLoginMessagePattern(String)
	 * @see securityTest.SecurityTestPackage#getAuthSetting_LoginMessagePattern()
	 * @model
	 * @generated
	 */
	String getLoginMessagePattern();

	/**
	 * Sets the value of the '{@link securityTest.AuthSetting#getLoginMessagePattern <em>Login Message Pattern</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Login Message Pattern</em>' attribute.
	 * @see #getLoginMessagePattern()
	 * @generated
	 */
	void setLoginMessagePattern(String value);

	/**
	 * Returns the value of the '<em><b>Logout Message Pattern</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Logout Message Pattern</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Logout Message Pattern</em>' attribute.
	 * @see #setLogoutMessagePattern(String)
	 * @see securityTest.SecurityTestPackage#getAuthSetting_LogoutMessagePattern()
	 * @model
	 * @generated
	 */
	String getLogoutMessagePattern();

	/**
	 * Sets the value of the '{@link securityTest.AuthSetting#getLogoutMessagePattern <em>Logout Message Pattern</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Logout Message Pattern</em>' attribute.
	 * @see #getLogoutMessagePattern()
	 * @generated
	 */
	void setLogoutMessagePattern(String value);

} // AuthSetting
