package com.tooooolazy.gwt.shared;

public class RequiredFieldMissingException extends RuntimeException {

	public RequiredFieldMissingException(String captionKey) {
		super(captionKey);
	}

}
