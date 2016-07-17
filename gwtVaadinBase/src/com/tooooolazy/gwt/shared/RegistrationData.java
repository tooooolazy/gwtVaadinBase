/**
 * 
 */
package com.tooooolazy.gwt.shared;

import com.tooooolazy.gwt.forms.server.Validation;
import com.tooooolazy.gwt.forms.shared.EmailValidator;
import com.tooooolazy.gwt.forms.shared.EqualityValidator;
import com.tooooolazy.gwt.widgets.shared.SupportedLanguage;
import com.tooooolazy.util.Messages;


/**
 * @author tooooolazy
 *
 * @param <C1> Country dto class
 * @param <C2> County dto class
 * @param <C3> City dto class
 */
public class RegistrationData extends Credentials {
	private String passwordVerify;
	private SupportedLanguage language;
	private String email;

//	private C1 country;
//	private C2 county;
//	private C3 city;

	public RegistrationData() {
		super();
	}
	
	public RegistrationData(Credentials userInfo) {
		super(userInfo);
	}
	public RegistrationData(RegistrationData userInfo) {
		super(userInfo);
		if (userInfo == null)
			return;
		passwordVerify = userInfo.getPasswordVerify();
		email = userInfo.getEmail();
		language = userInfo.getLanguage();
//		country = userInfo.getCountry();
//		county = userInfo.getCounty();
//		city = userInfo.getCity();
	}
	@Validation(validatorClass=EqualityValidator.class, related="getPassword")
	public String getPasswordVerify() {
		return passwordVerify;
	}

	public void setPasswordVerify(String passwordVerify) {
		this.passwordVerify = passwordVerify;
	}

	public SupportedLanguage getLanguage() {
		return language;
	}

	public void setLanguage(SupportedLanguage language) {
		this.language = language;
	}

	@Validation(validatorClass=EmailValidator.class)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		if (email != null && email.trim().length() > 3)
			this.email = email;
	}

//	public C1 getCountry() {
//		return country;
//	}
//	public void setCountry(C1 country) {
//		this.country = country;
//	}
//	public C2 getCounty() {
//		return county;
//	}
//	public void setCounty(C2 county) {
//		this.county = county;
//	}
//	public C3 getCity() {
//		return city;
//	}
//	public void setCity(C3 city) {
//		this.city = city;
//	}

	public Credentials getCredentials() {
		return new Credentials(this);
	}
	public String toString() {
		return Messages.getString("username") + ": " + getUsername() + "<br/>"
			 + Messages.getString("password") + ": " + getPassword();
	}
}
