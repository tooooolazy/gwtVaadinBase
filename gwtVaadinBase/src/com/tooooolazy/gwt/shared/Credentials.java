package com.tooooolazy.gwt.shared;

import com.tooooolazy.gwt.forms.server.Validation;
import com.tooooolazy.gwt.forms.shared.IPValidator;

public class Credentials extends BaseDTO {
	private static final long serialVersionUID = 1L;

	private String username;
	private String password;
	private Boolean rememberMe;
	private String fromIp;

	public Credentials() {
		super();
	}
	public Credentials(String username, String password) {
		this.username = username;
		this.password = password;
	}
	public Credentials(Credentials userInfo) {
		if (userInfo == null)
			return;
		username = userInfo.getUsername();
		password = userInfo.getPassword();
	}

	public void setUsername(String name) {
		this.username = name;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getRememberMe() {
		return rememberMe;
	}

	public void setRememberMe(Boolean rememberMe) {
		this.rememberMe = rememberMe;
	}

	@Validation(validatorClass=IPValidator.class)
	public String getFromIp() {
		return this.fromIp;
	}

	public void setFromIp(String fromIp) {
		this.fromIp = fromIp;
	}
}
