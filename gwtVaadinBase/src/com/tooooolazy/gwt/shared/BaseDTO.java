package com.tooooolazy.gwt.shared;

import java.io.Serializable;

import com.tooooolazy.gwt.forms.shared.HasValidators;

public class BaseDTO implements Serializable, HasValidators {
	private String errorMessage;

	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

}
