/**
 */
package securityTest.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;

import securityTest.AuthSetting;
import securityTest.SecurityTestPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Auth Setting</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link securityTest.impl.AuthSettingImpl#getRoles <em>Roles</em>}</li>
 *   <li>{@link securityTest.impl.AuthSettingImpl#getUsernameParam <em>Username Param</em>}</li>
 *   <li>{@link securityTest.impl.AuthSettingImpl#getPasswordParam <em>Password Param</em>}</li>
 *   <li>{@link securityTest.impl.AuthSettingImpl#getLoginTargetURL <em>Login Target URL</em>}</li>
 *   <li>{@link securityTest.impl.AuthSettingImpl#getLoginMessagePattern <em>Login Message Pattern</em>}</li>
 *   <li>{@link securityTest.impl.AuthSettingImpl#getLogoutMessagePattern <em>Logout Message Pattern</em>}</li>
 * </ul>
 *
 * @generated
 */
public class AuthSettingImpl extends MinimalEObjectImpl.Container implements AuthSetting {
	/**
	 * The cached value of the '{@link #getRoles() <em>Roles</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRoles()
	 * @generated
	 * @ordered
	 */
	protected EList<String> roles;

	/**
	 * The default value of the '{@link #getUsernameParam() <em>Username Param</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUsernameParam()
	 * @generated
	 * @ordered
	 */
	protected static final String USERNAME_PARAM_EDEFAULT = "username";

	/**
	 * The cached value of the '{@link #getUsernameParam() <em>Username Param</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUsernameParam()
	 * @generated
	 * @ordered
	 */
	protected String usernameParam = USERNAME_PARAM_EDEFAULT;

	/**
	 * The default value of the '{@link #getPasswordParam() <em>Password Param</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPasswordParam()
	 * @generated
	 * @ordered
	 */
	protected static final String PASSWORD_PARAM_EDEFAULT = "password";

	/**
	 * The cached value of the '{@link #getPasswordParam() <em>Password Param</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPasswordParam()
	 * @generated
	 * @ordered
	 */
	protected String passwordParam = PASSWORD_PARAM_EDEFAULT;

	/**
	 * The default value of the '{@link #getLoginTargetURL() <em>Login Target URL</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLoginTargetURL()
	 * @generated
	 * @ordered
	 */
	protected static final String LOGIN_TARGET_URL_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLoginTargetURL() <em>Login Target URL</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLoginTargetURL()
	 * @generated
	 * @ordered
	 */
	protected String loginTargetURL = LOGIN_TARGET_URL_EDEFAULT;

	/**
	 * The default value of the '{@link #getLoginMessagePattern() <em>Login Message Pattern</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLoginMessagePattern()
	 * @generated
	 * @ordered
	 */
	protected static final String LOGIN_MESSAGE_PATTERN_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLoginMessagePattern() <em>Login Message Pattern</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLoginMessagePattern()
	 * @generated
	 * @ordered
	 */
	protected String loginMessagePattern = LOGIN_MESSAGE_PATTERN_EDEFAULT;

	/**
	 * The default value of the '{@link #getLogoutMessagePattern() <em>Logout Message Pattern</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLogoutMessagePattern()
	 * @generated
	 * @ordered
	 */
	protected static final String LOGOUT_MESSAGE_PATTERN_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLogoutMessagePattern() <em>Logout Message Pattern</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLogoutMessagePattern()
	 * @generated
	 * @ordered
	 */
	protected String logoutMessagePattern = LOGOUT_MESSAGE_PATTERN_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AuthSettingImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SecurityTestPackage.Literals.AUTH_SETTING;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getRoles() {
		if (roles == null) {
			roles = new EDataTypeUniqueEList<String>(String.class, this, SecurityTestPackage.AUTH_SETTING__ROLES);
		}
		return roles;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getUsernameParam() {
		return usernameParam;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUsernameParam(String newUsernameParam) {
		String oldUsernameParam = usernameParam;
		usernameParam = newUsernameParam;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SecurityTestPackage.AUTH_SETTING__USERNAME_PARAM, oldUsernameParam, usernameParam));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPasswordParam() {
		return passwordParam;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPasswordParam(String newPasswordParam) {
		String oldPasswordParam = passwordParam;
		passwordParam = newPasswordParam;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SecurityTestPackage.AUTH_SETTING__PASSWORD_PARAM, oldPasswordParam, passwordParam));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLoginTargetURL() {
		return loginTargetURL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLoginTargetURL(String newLoginTargetURL) {
		String oldLoginTargetURL = loginTargetURL;
		loginTargetURL = newLoginTargetURL;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SecurityTestPackage.AUTH_SETTING__LOGIN_TARGET_URL, oldLoginTargetURL, loginTargetURL));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLoginMessagePattern() {
		return loginMessagePattern;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLoginMessagePattern(String newLoginMessagePattern) {
		String oldLoginMessagePattern = loginMessagePattern;
		loginMessagePattern = newLoginMessagePattern;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SecurityTestPackage.AUTH_SETTING__LOGIN_MESSAGE_PATTERN, oldLoginMessagePattern, loginMessagePattern));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLogoutMessagePattern() {
		return logoutMessagePattern;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLogoutMessagePattern(String newLogoutMessagePattern) {
		String oldLogoutMessagePattern = logoutMessagePattern;
		logoutMessagePattern = newLogoutMessagePattern;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SecurityTestPackage.AUTH_SETTING__LOGOUT_MESSAGE_PATTERN, oldLogoutMessagePattern, logoutMessagePattern));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SecurityTestPackage.AUTH_SETTING__ROLES:
				return getRoles();
			case SecurityTestPackage.AUTH_SETTING__USERNAME_PARAM:
				return getUsernameParam();
			case SecurityTestPackage.AUTH_SETTING__PASSWORD_PARAM:
				return getPasswordParam();
			case SecurityTestPackage.AUTH_SETTING__LOGIN_TARGET_URL:
				return getLoginTargetURL();
			case SecurityTestPackage.AUTH_SETTING__LOGIN_MESSAGE_PATTERN:
				return getLoginMessagePattern();
			case SecurityTestPackage.AUTH_SETTING__LOGOUT_MESSAGE_PATTERN:
				return getLogoutMessagePattern();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case SecurityTestPackage.AUTH_SETTING__ROLES:
				getRoles().clear();
				getRoles().addAll((Collection<? extends String>)newValue);
				return;
			case SecurityTestPackage.AUTH_SETTING__USERNAME_PARAM:
				setUsernameParam((String)newValue);
				return;
			case SecurityTestPackage.AUTH_SETTING__PASSWORD_PARAM:
				setPasswordParam((String)newValue);
				return;
			case SecurityTestPackage.AUTH_SETTING__LOGIN_TARGET_URL:
				setLoginTargetURL((String)newValue);
				return;
			case SecurityTestPackage.AUTH_SETTING__LOGIN_MESSAGE_PATTERN:
				setLoginMessagePattern((String)newValue);
				return;
			case SecurityTestPackage.AUTH_SETTING__LOGOUT_MESSAGE_PATTERN:
				setLogoutMessagePattern((String)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case SecurityTestPackage.AUTH_SETTING__ROLES:
				getRoles().clear();
				return;
			case SecurityTestPackage.AUTH_SETTING__USERNAME_PARAM:
				setUsernameParam(USERNAME_PARAM_EDEFAULT);
				return;
			case SecurityTestPackage.AUTH_SETTING__PASSWORD_PARAM:
				setPasswordParam(PASSWORD_PARAM_EDEFAULT);
				return;
			case SecurityTestPackage.AUTH_SETTING__LOGIN_TARGET_URL:
				setLoginTargetURL(LOGIN_TARGET_URL_EDEFAULT);
				return;
			case SecurityTestPackage.AUTH_SETTING__LOGIN_MESSAGE_PATTERN:
				setLoginMessagePattern(LOGIN_MESSAGE_PATTERN_EDEFAULT);
				return;
			case SecurityTestPackage.AUTH_SETTING__LOGOUT_MESSAGE_PATTERN:
				setLogoutMessagePattern(LOGOUT_MESSAGE_PATTERN_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case SecurityTestPackage.AUTH_SETTING__ROLES:
				return roles != null && !roles.isEmpty();
			case SecurityTestPackage.AUTH_SETTING__USERNAME_PARAM:
				return USERNAME_PARAM_EDEFAULT == null ? usernameParam != null : !USERNAME_PARAM_EDEFAULT.equals(usernameParam);
			case SecurityTestPackage.AUTH_SETTING__PASSWORD_PARAM:
				return PASSWORD_PARAM_EDEFAULT == null ? passwordParam != null : !PASSWORD_PARAM_EDEFAULT.equals(passwordParam);
			case SecurityTestPackage.AUTH_SETTING__LOGIN_TARGET_URL:
				return LOGIN_TARGET_URL_EDEFAULT == null ? loginTargetURL != null : !LOGIN_TARGET_URL_EDEFAULT.equals(loginTargetURL);
			case SecurityTestPackage.AUTH_SETTING__LOGIN_MESSAGE_PATTERN:
				return LOGIN_MESSAGE_PATTERN_EDEFAULT == null ? loginMessagePattern != null : !LOGIN_MESSAGE_PATTERN_EDEFAULT.equals(loginMessagePattern);
			case SecurityTestPackage.AUTH_SETTING__LOGOUT_MESSAGE_PATTERN:
				return LOGOUT_MESSAGE_PATTERN_EDEFAULT == null ? logoutMessagePattern != null : !LOGOUT_MESSAGE_PATTERN_EDEFAULT.equals(logoutMessagePattern);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (roles: ");
		result.append(roles);
		result.append(", usernameParam: ");
		result.append(usernameParam);
		result.append(", passwordParam: ");
		result.append(passwordParam);
		result.append(", loginTargetURL: ");
		result.append(loginTargetURL);
		result.append(", loginMessagePattern: ");
		result.append(loginMessagePattern);
		result.append(", logoutMessagePattern: ");
		result.append(logoutMessagePattern);
		result.append(')');
		return result.toString();
	}

} //AuthSettingImpl
