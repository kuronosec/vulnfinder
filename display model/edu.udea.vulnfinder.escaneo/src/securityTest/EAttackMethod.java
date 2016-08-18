/**
 */
package securityTest;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>EAttack Method</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see securityTest.SecurityTestPackage#getEAttackMethod()
 * @model
 * @generated
 */
public enum EAttackMethod implements Enumerator {
	/**
	 * The '<em><b>SQL Injection</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SQL_INJECTION_VALUE
	 * @generated
	 * @ordered
	 */
	SQL_INJECTION(0, "SQLInjection", "SQLInjection"),

	/**
	 * The '<em><b>XSS</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #XSS_VALUE
	 * @generated
	 * @ordered
	 */
	XSS(1, "XSS", "XSS"),

	/**
	 * The '<em><b>Authentication</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #AUTHENTICATION_VALUE
	 * @generated
	 * @ordered
	 */
	AUTHENTICATION(2, "Authentication", "Authentication"),

	/**
	 * The '<em><b>Authorization</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #AUTHORIZATION_VALUE
	 * @generated
	 * @ordered
	 */
	AUTHORIZATION(3, "Authorization", "Authorization"),

	/**
	 * The '<em><b>Privilege Scalation</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PRIVILEGE_SCALATION_VALUE
	 * @generated
	 * @ordered
	 */
	PRIVILEGE_SCALATION(4, "PrivilegeScalation", "PrivilegeScalation");

	/**
	 * The '<em><b>SQL Injection</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>SQL Injection</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SQL_INJECTION
	 * @model name="SQLInjection"
	 * @generated
	 * @ordered
	 */
	public static final int SQL_INJECTION_VALUE = 0;

	/**
	 * The '<em><b>XSS</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>XSS</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #XSS
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int XSS_VALUE = 1;

	/**
	 * The '<em><b>Authentication</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Authentication</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #AUTHENTICATION
	 * @model name="Authentication"
	 * @generated
	 * @ordered
	 */
	public static final int AUTHENTICATION_VALUE = 2;

	/**
	 * The '<em><b>Authorization</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Authorization</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #AUTHORIZATION
	 * @model name="Authorization"
	 * @generated
	 * @ordered
	 */
	public static final int AUTHORIZATION_VALUE = 3;

	/**
	 * The '<em><b>Privilege Scalation</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Privilege Scalation</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #PRIVILEGE_SCALATION
	 * @model name="PrivilegeScalation"
	 * @generated
	 * @ordered
	 */
	public static final int PRIVILEGE_SCALATION_VALUE = 4;

	/**
	 * An array of all the '<em><b>EAttack Method</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final EAttackMethod[] VALUES_ARRAY =
		new EAttackMethod[] {
			SQL_INJECTION,
			XSS,
			AUTHENTICATION,
			AUTHORIZATION,
			PRIVILEGE_SCALATION,
		};

	/**
	 * A public read-only list of all the '<em><b>EAttack Method</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<EAttackMethod> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>EAttack Method</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param literal the literal.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static EAttackMethod get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			EAttackMethod result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>EAttack Method</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name the name.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static EAttackMethod getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			EAttackMethod result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>EAttack Method</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the integer value.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static EAttackMethod get(int value) {
		switch (value) {
			case SQL_INJECTION_VALUE: return SQL_INJECTION;
			case XSS_VALUE: return XSS;
			case AUTHENTICATION_VALUE: return AUTHENTICATION;
			case AUTHORIZATION_VALUE: return AUTHORIZATION;
			case PRIVILEGE_SCALATION_VALUE: return PRIVILEGE_SCALATION;
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final int value;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String name;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String literal;

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EAttackMethod(int value, String name, String literal) {
		this.value = value;
		this.name = name;
		this.literal = literal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getValue() {
	  return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
	  return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLiteral() {
	  return literal;
	}

	/**
	 * Returns the literal value of the enumerator, which is its string representation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		return literal;
	}
	
} //EAttackMethod
