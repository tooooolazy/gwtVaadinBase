package com.tooooolazy.gwt.shared.interfaces;

import java.util.Map;

import org.json.JSONObject;

public interface InitializationController extends TransactionalController {

	/**
	 * Retrieves the initialization sequence of actions that need to be performed to initialize
	 * the component of the given class
	 * @param className
	 * @return
	 */
	public Map<String, Object> getInitializationData(String className);

}
