package com.tooooolazy.gwt.server.localization;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.Map;
import java.util.ResourceBundle;

import org.json.JSONException;
import org.json.JSONObject;

import com.tooooolazy.gwt.server.Initializer;
import com.tooooolazy.gwt.shared.interfaces.LanguageController;

/**
 * Extended to provide support for DB resource bundles and GWT dictionary construction
 * @author tooooolazy
 *
 */
public class Messages extends com.tooooolazy.util.Messages {

	public static String getDBString(String key) {
		LanguageController lc = getLanguageController();
		return null;
	}

	/**
	 * @return
	 */
	protected static LanguageController getLanguageController() {
		return (LanguageController) Initializer.singleton().getController(Initializer.singleton().getProperty(Initializer.LANGUAGE_CONTROLLER_CLASS));
	}
	/**
	 * Combines all multilingual data (for given language) into a single json string.<br>
	 * This string can be used as a datasource for a Dictionary in GWT.
	 * 
	 * @param lang
	 * @return
	 */
	public static String getAsDictionary(String _lang) {
		JSONObject jo = getAsJson(_lang);
		return jo.toString();
	}
	/**
	 * Similar to getAsDictionary(String _lang), BUT it also appends the entries in the dbRes Map.
	 * When keys exist in both the Map and resource bundles then the values from the Map are used.<br>
	 * This can be used to provide basic default messages that can be overridden in DB later on.
	 * TODO: think how to incorporate this in server side applications as well
	 * @param _lang
	 * @param dbRes
	 * @return
	 */
	public static String getAsDictionary(String _lang, Map<String, String> dbRes) {
		JSONObject jo = getAsJson(_lang);
		return appendDictionary(dbRes, jo);
	}

	/**
	 * @param dbRes
	 * @param jo
	 * @return
	 */
	public static String appendDictionary(Map<String, String> dbRes, JSONObject jo) {
		Iterator<String> it = dbRes.keySet().iterator();
		while (it.hasNext()) {
			String key = it.next();
			try {
				jo.put(key, dbRes.get(key));
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return jo.toString();
	}

	/**
	 * @param _lang
	 * @return
	 */
	public static JSONObject getAsJson(String _lang) {
		if (_lang == null)
			_lang = Messages.getLang();
	
		JSONObject jo = new JSONObject();

		Enumeration<String> e = RESOURCE_BUNDLES.get(_lang).getKeys();
		while (e.hasMoreElements()) {
			String key = e.nextElement();
			try {
				jo.put(key, RESOURCE_BUNDLES.get(_lang).getString(key));
			} catch (JSONException e1) {
			}
		}
		for (int i=0; i<EXTRA_BUNDLES.size(); i++) {
			Map<String, ResourceBundle> map = EXTRA_BUNDLES.get(i);

			Enumeration<String> ex = map.get(_lang).getKeys();
			while (ex.hasMoreElements()) {
				String key = ex.nextElement();
				try {
					jo.put(key, map.get(_lang).getString(key));
				} catch (JSONException e1) {
				}
			}
		}
		return jo;
	}
}
