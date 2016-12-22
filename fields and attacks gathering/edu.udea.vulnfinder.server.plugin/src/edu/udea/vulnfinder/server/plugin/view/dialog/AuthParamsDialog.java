package edu.udea.vulnfinder.server.plugin.view.dialog;

import java.net.URI;
import java.net.URISyntaxException;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Spinner;
import org.eclipse.swt.widgets.Text;

import edu.udea.vulnfinder.xmigenerator.generator.Main;
import edu.udea.vulnfinder.xmigenerator.generator.metaclasses.AuthSetting;

public class AuthParamsDialog extends Dialog {
	
	private Text txtRoles;
	private String rolesStr;
	private String[] roles;
	private Text txtLoginUrl;
	private String loginUrl;
	private Text txtUserField;
	private String userField;
	private Text txtUsername;
	private String username;
	private Text txtPassField;
	private String passField;
	private Text txtPassword;
	private String password;
	private Text txtLoggedIn;
	private String loggedIn;
	private Text txtLoggedOut;
	private String loggedOut;
	private boolean complete;

	public AuthParamsDialog(Shell parentShell) {
		super(parentShell);
		roles = new String[0];
	}
	

	@Override
	protected Control createDialogArea(Composite parent) {
		Composite container = (Composite) super.createDialogArea(parent);
		StringBuilder roles = new StringBuilder();
		AuthSetting authSetting = Main.getAuthSetting();
		String[] rolesArr = authSetting.getRoles();
		
		GridLayout layout = new GridLayout(2, true);
		
		layout.marginRight = 5;
		layout.marginLeft = 10;
		
		container.setLayout(layout);
		if(rolesArr.length > 0){
			roles.append(rolesArr[0]);
			for(int i = 1; i < rolesArr.length; i++){
				roles.append(", ");
				roles.append(rolesArr[i]);
			}
		}
		
		
		Label lblRoles = new Label(container, SWT.NONE);
		lblRoles.setText("Roles:");
		
		
		txtRoles = new Text(container, SWT.BORDER);
		txtRoles.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		txtRoles.setText(roles.toString());
		txtRoles.addModifyListener(new ModifyListener() {

		@Override
		public void modifyText(ModifyEvent e) {
				Text textWidget = (Text) e.getSource();
				String userText = textWidget.getText();
				rolesStr = userText;
			}
		});
		
		lblRoles.setToolTipText("A list of comma-separated roles for this test.");
		txtRoles.setToolTipText(lblRoles.getToolTipText());
		
		Label lblLoginUrl = new Label(container, SWT.NONE);
		lblLoginUrl.setText("Login form URL:");

		txtLoginUrl = new Text(container, SWT.BORDER);
		txtLoginUrl.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		txtLoginUrl.setText(authSetting.getLoginTargetUrl());
		txtLoginUrl.addModifyListener(new ModifyListener() {

		@Override
		public void modifyText(ModifyEvent e) {
				Text textWidget = (Text) e.getSource();
				String userText = textWidget.getText();
				loginUrl = userText;
			}
		});
		
		Label lblUserfield = new Label(container, SWT.NONE);
		lblUserfield.setText("Username parameter:");

		txtUserField = new Text(container, SWT.BORDER);
		txtUserField.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		txtUserField.setText(authSetting.getUsernameParam());
		txtUserField.addModifyListener(new ModifyListener() {

		@Override
		public void modifyText(ModifyEvent e) {
				Text textWidget = (Text) e.getSource();
				String userText = textWidget.getText();
				userField = userText;
			}
		});
		
		
		
		Label lblUsername = new Label(container, SWT.NONE);
		lblUsername.setText("Username value:");

		txtUsername = new Text(container, SWT.BORDER);
		txtUsername.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		//txtUsername.setText(authSetting.getUsername());
		txtUsername.addModifyListener(new ModifyListener() {

		@Override
		public void modifyText(ModifyEvent e) {
				Text textWidget = (Text) e.getSource();
				String userText = textWidget.getText();
				username = userText;
			}
		});
		
		Label lblPaswordField= new Label(container, SWT.NONE);
		lblPaswordField.setText("Password parameter:");

		txtPassField = new Text(container, SWT.BORDER);
		txtPassField.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		txtPassField.setText(authSetting.getPasswordParam());
		txtPassField.addModifyListener(new ModifyListener() {

		@Override
		public void modifyText(ModifyEvent e) {
				Text textWidget = (Text) e.getSource();
				String passText = textWidget.getText();
				passField = passText;
			}
		});
		
		
		Label lblPassword = new Label(container, SWT.NONE);
		lblPassword.setText("Password value:");

		txtPassword = new Text(container, SWT.BORDER);
		txtPassword.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		//txtUserField.setText("username");
		txtPassword.setEchoChar('*');
		txtPassword.addModifyListener(new ModifyListener() {

		@Override
		public void modifyText(ModifyEvent e) {
				Text textWidget = (Text) e.getSource();
				String passText = textWidget.getText();
				password = passText;
			}
		});
		
		Label lblLoggedIn = new Label(container, SWT.NONE);
		lblLoggedIn.setText("Logged In message:");

		txtLoggedIn = new Text(container, SWT.BORDER);
		txtLoggedIn.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		txtLoggedIn.setText(authSetting.getLoginMessagePattern());
		
		txtLoggedIn.addModifyListener(new ModifyListener() {
			
			
		@Override
		public void modifyText(ModifyEvent e) {
				Text textWidget = (Text) e.getSource();
				String passText = textWidget.getText();
				loggedIn = passText;
			}
		});
		lblLoggedIn.setToolTipText("Regex pattern identified in Logged In response messages.");
		txtLoggedIn.setToolTipText(lblLoggedIn.getToolTipText());
		
		
		Label lblLoggedOut = new Label(container, SWT.NONE);
		lblLoggedOut.setText("Logged Out message:");

		txtLoggedOut = new Text(container, SWT.BORDER);
		txtLoggedOut.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		txtLoggedOut.setText(authSetting.getLogoutMessagePattern());
		txtLoggedOut.addModifyListener(new ModifyListener() {

		@Override
		public void modifyText(ModifyEvent e) {
				Text textWidget = (Text) e.getSource();
				String passText = textWidget.getText();
				loggedOut = passText;
			}
		});
		
		lblLoggedOut.setToolTipText("Regex pattern identified in Logged Out response messages.");
		txtLoggedOut.setToolTipText(lblLoggedOut.getToolTipText());
		
		container.pack();
		return container;
	}

	@Override
	protected void okPressed() {
		loginUrl = txtLoginUrl.getText().trim();
		userField = txtUserField.getText().trim();
		username = txtUsername.getText().trim();
		passField = txtPassField.getText().trim();
		password = txtPassword.getText().trim();
		loggedIn = txtLoggedIn.getText().trim();
		loggedOut = txtLoggedOut.getText().trim();
		roles = txtRoles.getText().split(",");
		
		for(int i = 0; i < roles.length; i++){
			roles[i] = roles[i].trim();
		}
		
		if("".equals(loginUrl) || "".equals(userField) || "".equals(username)
				|| "".equals(passField) || "".equals(password)){
			complete = false;
		}else{
			complete = true;
		}
		super.okPressed();
	}
	

	@Override
	protected void createButtonsForButtonBar(Composite parent) {
		createButton(parent, IDialogConstants.OK_ID, IDialogConstants.OK_LABEL, true);
		createButton(parent, IDialogConstants.CANCEL_ID, IDialogConstants.CANCEL_LABEL, false);
	}

	@Override
	protected Point getInitialSize() {
		return new Point(620, 350);
	}
	
	@Override
	protected boolean isResizable() {
	    return true;
	}
	
	


	public boolean isComplete() {
		return complete;
	}


	public void setComplete(boolean complete) {
		this.complete = complete;
	}


	public String getLoginUrl() {
		return loginUrl;
	}


	public void setLoginUrl(String loginUrl) {
		this.loginUrl = loginUrl;
	}
	
	


	


	public String getUserField() {
		return userField;
	}


	public void setUserField(String userField) {
		this.userField = userField;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}
	
	


	public String[] getRoles() {
		return roles;
	}


	public void setRoles(String[] roles) {
		this.roles = roles;
	}


	public String getPassField() {
		return passField;
	}


	public void setPassField(String passField) {
		this.passField = passField;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getLoggedIn() {
		return loggedIn;
	}


	public void setLoggedIn(String loggedIn) {
		this.loggedIn = loggedIn;
	}


	public String getLoggedOut() {
		return loggedOut;
	}


	public void setLoggedOut(String loggedOut) {
		this.loggedOut = loggedOut;
	}
}
