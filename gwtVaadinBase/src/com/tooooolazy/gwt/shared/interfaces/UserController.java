package com.tooooolazy.gwt.shared.interfaces;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONObject;

import com.tooooolazy.gwt.shared.Credentials;
import com.tooooolazy.gwt.shared.RegistrationData;
import com.tooooolazy.gwt.shared.exceptions.InvalidCredentialsException;
import com.tooooolazy.gwt.shared.exceptions.MultipleLoginException;
import com.tooooolazy.gwt.shared.exceptions.NoInternalException;
import com.tooooolazy.gwt.shared.exceptions.SessionExpiredException;
import com.tooooolazy.gwt.shared.exceptions.UserDeletedException;
import com.tooooolazy.gwt.shared.exceptions.UserInactiveException;
import com.tooooolazy.gwt.shared.exceptions.UserNotVerifiedException;
import com.tooooolazy.gwt.shared.exceptions.UserVerificationException;
import com.tooooolazy.gwt.shared.exceptions.UsernameExistsException;
import com.tooooolazy.gwt.shared.exceptions.WrongLoginIPException;

public interface UserController extends TransactionalController {
	public Object login(Credentials credentials);
	/**
	 * We need the <code>HttpServletRequest</code> so we can read the sessionID cookie and the user IP
	 * @param credentials
	 * @param threadLocalRequest
	 * @return
	 * @throws WrongLoginIPException
	 * @throws MultipleLoginException
	 * @throws InvalidCredentialsException 
	 * @throws UserInactiveException 
	 * @throws UserNotVerifiedException 
	 * @throws UserDeletedException 
	 */
	public Object login(Credentials credentials, HttpServletRequest request) throws WrongLoginIPException, MultipleLoginException, InvalidCredentialsException, UserInactiveException, UserNotVerifiedException, UserDeletedException;
	public Object login(JSONObject userDetails, Integer type, HttpServletRequest request) throws WrongLoginIPException, MultipleLoginException, InvalidCredentialsException, UserInactiveException, UserNotVerifiedException, UserDeletedException, NoInternalException;
	/**
	 * @param cookie
	 * @param request
	 * @param link - if true session's vDate (last session verification Date) will be updated to current date and user's session will be set to the session found.
	 * @return the User object that corresponds to the given cookie
	 * @throws UserDeletedException 
	 * @throws UserNotVerifiedException 
	 * @throws UserInactiveException 
	 */
	public Object verifySession(String cookie, HttpServletRequest request, boolean link) throws UserInactiveException, UserNotVerifiedException, UserDeletedException;
	/**
	 * Specifies if multiple logins are allowed
	 * @return
	 */
	public boolean allowMultipleLogins();
	public boolean allowMultipleLoginsFromDifferentIPs();
	/**
	 * If multiple logins are NOT allowed, it specifies which session will be kept 
	 * @return
	 */
	public boolean useNewSession();
	public boolean rememberLogin();
	
	/**
	 * The idea is to return the User that just logged out
	 * @param user
	 * @return
	 * @throws SessionExpiredException 
	 */
	public Object logout(Object userPK) throws SessionExpiredException;

	public Object registerUser(RegistrationData rd) throws UsernameExistsException;
	public void verifyFromEmail(String verification) throws UserVerificationException;
	public void requestPasswordReset(String username);
	public String getUserEmail(String username);

	public List getUsers();
}
