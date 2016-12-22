/**
 */
package securityTest.impl;

import java.util.Collection;
import java.util.Date;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import securityTest.Attack;
import securityTest.AuthSetting;
import securityTest.ESeverity;
import securityTest.Note;
import securityTest.SecurityTestPackage;
import securityTest.TargetOfEvaluation;
import securityTest.Test;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Test</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link securityTest.impl.TestImpl#getScope <em>Scope</em>}</li>
 *   <li>{@link securityTest.impl.TestImpl#getPossibleAttacks <em>Possible Attacks</em>}</li>
 *   <li>{@link securityTest.impl.TestImpl#getId <em>Id</em>}</li>
 *   <li>{@link securityTest.impl.TestImpl#getDate <em>Date</em>}</li>
 *   <li>{@link securityTest.impl.TestImpl#getName <em>Name</em>}</li>
 *   <li>{@link securityTest.impl.TestImpl#getNote <em>Note</em>}</li>
 *   <li>{@link securityTest.impl.TestImpl#getSeverity <em>Severity</em>}</li>
 *   <li>{@link securityTest.impl.TestImpl#getAuthSetting <em>Auth Setting</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TestImpl extends MinimalEObjectImpl.Container implements Test {
	/**
	 * The cached value of the '{@link #getScope() <em>Scope</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getScope()
	 * @generated
	 * @ordered
	 */
	protected TargetOfEvaluation scope;

	/**
	 * The cached value of the '{@link #getPossibleAttacks() <em>Possible Attacks</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPossibleAttacks()
	 * @generated
	 * @ordered
	 */
	protected EList<Attack> possibleAttacks;

	/**
	 * The default value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected static final String ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected String id = ID_EDEFAULT;

	/**
	 * The default value of the '{@link #getDate() <em>Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDate()
	 * @generated
	 * @ordered
	 */
	protected static final Date DATE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDate() <em>Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDate()
	 * @generated
	 * @ordered
	 */
	protected Date date = DATE_EDEFAULT;

	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getNote() <em>Note</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNote()
	 * @generated
	 * @ordered
	 */
	protected Note note;

	/**
	 * The default value of the '{@link #getSeverity() <em>Severity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSeverity()
	 * @generated
	 * @ordered
	 */
	protected static final ESeverity SEVERITY_EDEFAULT = ESeverity.MEDIUM;

	/**
	 * The cached value of the '{@link #getSeverity() <em>Severity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSeverity()
	 * @generated
	 * @ordered
	 */
	protected ESeverity severity = SEVERITY_EDEFAULT;

	/**
	 * The cached value of the '{@link #getAuthSetting() <em>Auth Setting</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAuthSetting()
	 * @generated
	 * @ordered
	 */
	protected AuthSetting authSetting;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TestImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SecurityTestPackage.Literals.TEST;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TargetOfEvaluation getScope() {
		return scope;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetScope(TargetOfEvaluation newScope, NotificationChain msgs) {
		TargetOfEvaluation oldScope = scope;
		scope = newScope;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SecurityTestPackage.TEST__SCOPE, oldScope, newScope);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setScope(TargetOfEvaluation newScope) {
		if (newScope != scope) {
			NotificationChain msgs = null;
			if (scope != null)
				msgs = ((InternalEObject)scope).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SecurityTestPackage.TEST__SCOPE, null, msgs);
			if (newScope != null)
				msgs = ((InternalEObject)newScope).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SecurityTestPackage.TEST__SCOPE, null, msgs);
			msgs = basicSetScope(newScope, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SecurityTestPackage.TEST__SCOPE, newScope, newScope));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Attack> getPossibleAttacks() {
		if (possibleAttacks == null) {
			possibleAttacks = new EObjectContainmentEList<Attack>(Attack.class, this, SecurityTestPackage.TEST__POSSIBLE_ATTACKS);
		}
		return possibleAttacks;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getId() {
		return id;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setId(String newId) {
		String oldId = id;
		id = newId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SecurityTestPackage.TEST__ID, oldId, id));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDate(Date newDate) {
		Date oldDate = date;
		date = newDate;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SecurityTestPackage.TEST__DATE, oldDate, date));
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
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SecurityTestPackage.TEST__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Note getNote() {
		return note;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetNote(Note newNote, NotificationChain msgs) {
		Note oldNote = note;
		note = newNote;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SecurityTestPackage.TEST__NOTE, oldNote, newNote);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNote(Note newNote) {
		if (newNote != note) {
			NotificationChain msgs = null;
			if (note != null)
				msgs = ((InternalEObject)note).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SecurityTestPackage.TEST__NOTE, null, msgs);
			if (newNote != null)
				msgs = ((InternalEObject)newNote).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SecurityTestPackage.TEST__NOTE, null, msgs);
			msgs = basicSetNote(newNote, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SecurityTestPackage.TEST__NOTE, newNote, newNote));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ESeverity getSeverity() {
		return severity;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSeverity(ESeverity newSeverity) {
		ESeverity oldSeverity = severity;
		severity = newSeverity == null ? SEVERITY_EDEFAULT : newSeverity;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SecurityTestPackage.TEST__SEVERITY, oldSeverity, severity));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AuthSetting getAuthSetting() {
		return authSetting;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetAuthSetting(AuthSetting newAuthSetting, NotificationChain msgs) {
		AuthSetting oldAuthSetting = authSetting;
		authSetting = newAuthSetting;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SecurityTestPackage.TEST__AUTH_SETTING, oldAuthSetting, newAuthSetting);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAuthSetting(AuthSetting newAuthSetting) {
		if (newAuthSetting != authSetting) {
			NotificationChain msgs = null;
			if (authSetting != null)
				msgs = ((InternalEObject)authSetting).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SecurityTestPackage.TEST__AUTH_SETTING, null, msgs);
			if (newAuthSetting != null)
				msgs = ((InternalEObject)newAuthSetting).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SecurityTestPackage.TEST__AUTH_SETTING, null, msgs);
			msgs = basicSetAuthSetting(newAuthSetting, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SecurityTestPackage.TEST__AUTH_SETTING, newAuthSetting, newAuthSetting));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SecurityTestPackage.TEST__SCOPE:
				return basicSetScope(null, msgs);
			case SecurityTestPackage.TEST__POSSIBLE_ATTACKS:
				return ((InternalEList<?>)getPossibleAttacks()).basicRemove(otherEnd, msgs);
			case SecurityTestPackage.TEST__NOTE:
				return basicSetNote(null, msgs);
			case SecurityTestPackage.TEST__AUTH_SETTING:
				return basicSetAuthSetting(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SecurityTestPackage.TEST__SCOPE:
				return getScope();
			case SecurityTestPackage.TEST__POSSIBLE_ATTACKS:
				return getPossibleAttacks();
			case SecurityTestPackage.TEST__ID:
				return getId();
			case SecurityTestPackage.TEST__DATE:
				return getDate();
			case SecurityTestPackage.TEST__NAME:
				return getName();
			case SecurityTestPackage.TEST__NOTE:
				return getNote();
			case SecurityTestPackage.TEST__SEVERITY:
				return getSeverity();
			case SecurityTestPackage.TEST__AUTH_SETTING:
				return getAuthSetting();
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
			case SecurityTestPackage.TEST__SCOPE:
				setScope((TargetOfEvaluation)newValue);
				return;
			case SecurityTestPackage.TEST__POSSIBLE_ATTACKS:
				getPossibleAttacks().clear();
				getPossibleAttacks().addAll((Collection<? extends Attack>)newValue);
				return;
			case SecurityTestPackage.TEST__ID:
				setId((String)newValue);
				return;
			case SecurityTestPackage.TEST__DATE:
				setDate((Date)newValue);
				return;
			case SecurityTestPackage.TEST__NAME:
				setName((String)newValue);
				return;
			case SecurityTestPackage.TEST__NOTE:
				setNote((Note)newValue);
				return;
			case SecurityTestPackage.TEST__SEVERITY:
				setSeverity((ESeverity)newValue);
				return;
			case SecurityTestPackage.TEST__AUTH_SETTING:
				setAuthSetting((AuthSetting)newValue);
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
			case SecurityTestPackage.TEST__SCOPE:
				setScope((TargetOfEvaluation)null);
				return;
			case SecurityTestPackage.TEST__POSSIBLE_ATTACKS:
				getPossibleAttacks().clear();
				return;
			case SecurityTestPackage.TEST__ID:
				setId(ID_EDEFAULT);
				return;
			case SecurityTestPackage.TEST__DATE:
				setDate(DATE_EDEFAULT);
				return;
			case SecurityTestPackage.TEST__NAME:
				setName(NAME_EDEFAULT);
				return;
			case SecurityTestPackage.TEST__NOTE:
				setNote((Note)null);
				return;
			case SecurityTestPackage.TEST__SEVERITY:
				setSeverity(SEVERITY_EDEFAULT);
				return;
			case SecurityTestPackage.TEST__AUTH_SETTING:
				setAuthSetting((AuthSetting)null);
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
			case SecurityTestPackage.TEST__SCOPE:
				return scope != null;
			case SecurityTestPackage.TEST__POSSIBLE_ATTACKS:
				return possibleAttacks != null && !possibleAttacks.isEmpty();
			case SecurityTestPackage.TEST__ID:
				return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
			case SecurityTestPackage.TEST__DATE:
				return DATE_EDEFAULT == null ? date != null : !DATE_EDEFAULT.equals(date);
			case SecurityTestPackage.TEST__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case SecurityTestPackage.TEST__NOTE:
				return note != null;
			case SecurityTestPackage.TEST__SEVERITY:
				return severity != SEVERITY_EDEFAULT;
			case SecurityTestPackage.TEST__AUTH_SETTING:
				return authSetting != null;
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
		result.append(" (id: ");
		result.append(id);
		result.append(", date: ");
		result.append(date);
		result.append(", name: ");
		result.append(name);
		result.append(", severity: ");
		result.append(severity);
		result.append(')');
		return result.toString();
	}

} //TestImpl
