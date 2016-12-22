package edu.udea.vulnfinder.xmigenerator.generator.metaclasses;

public class AuthSetting {
	private String roles[];
	private String usernameParam;
	private String username;
	private String passwordParam;
	private String password;
	private String loginTargetUrl;
	private String loginMessagePattern;
	private String logoutMessagePattern;
	private boolean complete;
	
	public AuthSetting() {
		roles = new String[0];
		usernameParam = "username";
		passwordParam = "password";
		loginTargetUrl = "";
		loginMessagePattern = "";
		logoutMessagePattern = "";
		username = "";
		password = "";
		complete = false;
	}
	
	

	public AuthSetting(String[] roles, String usernameParam, String username, String passwordParam, String password,
			String loginTargetUrl, String loginMessagePattern, String logoutMessagePattern, boolean complete) {
		super();
		this.roles = roles;
		this.usernameParam = usernameParam;
		this.username = username;
		this.passwordParam = passwordParam;
		this.password = password;
		this.loginTargetUrl = loginTargetUrl;
		this.loginMessagePattern = loginMessagePattern;
		this.logoutMessagePattern = logoutMessagePattern;
		this.complete = complete;
	}



	public boolean isComplete() {
		return complete;
	}



	public void setComplete(boolean complete) {
		this.complete = complete;
	}



	public String[] getRoles() {
		return roles;
	}
	public void setRoles(String[] roles) {
		this.roles = roles;
	}
	public String getUsernameParam() {
		return usernameParam;
	}
	public void setUsernameParam(String usernameParam) {
		this.usernameParam = usernameParam;
	}
	public String getPasswordParam() {
		return passwordParam;
	}
	public void setPasswordParam(String passwordParam) {
		this.passwordParam = passwordParam;
	}
	public String getLoginTargetUrl() {
		return loginTargetUrl;
	}
	public void setLoginTargetUrl(String loginTargetUrl) {
		this.loginTargetUrl = loginTargetUrl;
	}
	public String getLoginMessagePattern() {
		return loginMessagePattern;
	}
	public void setLoginMessagePattern(String loginMessagePattern) {
		this.loginMessagePattern = loginMessagePattern;
	}
	public String getLogoutMessagePattern() {
		return logoutMessagePattern;
	}
	public void setLogoutMessagePattern(String logoutMessagePattern) {
		this.logoutMessagePattern = logoutMessagePattern;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
