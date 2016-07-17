/**
 * 
 */
package com.tooooolazy.gwt.shared.interfaces;

import java.lang.reflect.Method;
import java.util.List;

/**
 * @author tooooolazy
 *
 * @param <U> the 'User' class
 * @param <M> the Method level security class
 * @param <O> the Object level security class
 * @param <R> the Role class
 */
public interface SecurityController<U, M, O, R> extends TransactionalController {
	public R getRole(HasPrimaryKey pk);
	public List<R> getRoles();
	public List<M> getMethodSecurityDefs();
	public List<O> getObjectSecurityDefs();

	public boolean hasAccess(U user, Method method, Class _class, Object[] params);
	public boolean hasAccess(U user, String methodName, Class _class, Object[] params);
	/**
	 * Added for Vaadin 7 secure Views
	 * @param methodName
	 * @param methodClass
	 * @return
	 */
	public boolean isSecure(String methodName, Class methodClass);
}
