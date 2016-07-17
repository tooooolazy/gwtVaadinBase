package com.tooooolazy.gwt.shared.exceptions;

import com.tooooolazy.gwt.shared.RegistrationData;

public class UsernameExistsException extends Exception {
	protected RegistrationData rd;

	public UsernameExistsException() {
		super("UsernameExistsException");
	}
	public UsernameExistsException(Exception trace) {
		super(trace);
	}

	public UsernameExistsException(RegistrationData rd) {
		this();
		this.rd = rd;
	}
}
