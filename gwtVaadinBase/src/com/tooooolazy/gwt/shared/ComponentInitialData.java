package com.tooooolazy.gwt.shared;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class ComponentInitialData implements Serializable {
	private Map<String, Object> data;

	public ComponentInitialData() {
		data = new HashMap<String, Object>();
	}
	public ComponentInitialData(Map<String, Object> data) {
		this.data = data;
	}
	public Map<String, Object> getData() {
		return data;
	}

	public void setData(Map<String, Object> data) {
		this.data = data;
	}
	
}
