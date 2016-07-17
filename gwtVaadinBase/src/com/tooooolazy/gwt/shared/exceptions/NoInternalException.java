package com.tooooolazy.gwt.shared.exceptions;

public class NoInternalException extends Exception {
	private String loginId;

	public NoInternalException() {
		super("NoInternalException");
	}

	public NoInternalException(String loginId) {
		this.loginId = loginId;
	}

	public String getLoginId() {
		return loginId;
	}
}
