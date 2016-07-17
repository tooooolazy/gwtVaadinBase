package com.tooooolazy.gwt.shared.interfaces;

public interface TransactionalController {
	public void doTransactional(Object obj, String method);
	/**
	 * @param obj - basically a dbcontroller object (eg. DB_UserController)
	 * @param string - the method to make transactional
	 * @param params - the parameters
	 * @return
	 * @throws Exception
	 */
	public Object doTransactional(Object obj, String string, Object[] params) throws Exception;
	/**
	 * @param obj - basically a dbcontroller object (eg. DB_UserController)
	 * @param string - the method to make transactional
	 * @param types - the types parameters
	 * @param params - the parameters
	 * @return
	 * @throws Exception
	 */
	public Object doTransactional(Object obj, String string, Class[] types, Object[] params) throws Exception;

}
