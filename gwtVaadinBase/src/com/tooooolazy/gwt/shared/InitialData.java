/**
 * 
 */
package com.tooooolazy.gwt.shared;

import java.io.Serializable;

/**
 * Requires 3 Generic Classes that define the data transfer object that will be used
 * <lo>
 * <li>L = "Language" class</li> - used for supported languages
 * <li>T = "User" class</li> - used for currently logged in user
 * <li>S = "Security" class - defines the access rights per Role</li>
 * </lo>
 * @author tooooolazy
 *
 */
public class InitialData<L, T, S> implements Serializable {
	private static final long serialVersionUID = 1L;

	protected String dictionary;
	protected L[] supportedLanguages;
	protected T currentUser;
	protected S securityDefs;

	public S getSecurityDefs() {
		return securityDefs;
	}

	public void setSecurityDefs(S securityDefs) {
		this.securityDefs = securityDefs;
	}

	public T getCurrentUser() {
		return currentUser;
	}

	public void setCurrentUser(T currentUser) {
		this.currentUser = currentUser;
	}

	public String getDictionary() {
		return dictionary;
	}

	public void setDictionary(String dictionary) {
		this.dictionary = dictionary;
	}

	public L[] getSupportedLanguages() {
		return supportedLanguages;
	}

	public void setSupportedLanguages(L[] supportedLanguages) {
		this.supportedLanguages = supportedLanguages;
	}

}
