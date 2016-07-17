package com.tooooolazy.gwt.shared.exceptions;

import com.tooooolazy.gwt.shared.Credentials;

public class UserDeletedException extends Exception {
	private Credentials credentials;

	public UserDeletedException() {
		super("UserDeletedException");
	}
	public UserDeletedException(Credentials credentials) {
		super("UserDeletedException");
		setCredentials(credentials);
	}

	public Credentials getCredentials() {
		return credentials;
	}
	public void setCredentials(Credentials credentials) {
		this.credentials = credentials;
	}

}
