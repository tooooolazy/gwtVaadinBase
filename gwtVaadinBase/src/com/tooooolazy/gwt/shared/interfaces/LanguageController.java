/**
 * 
 */
package com.tooooolazy.gwt.shared.interfaces;


import java.util.List;
import java.util.Map;

import com.tooooolazy.gwt.widgets.shared.SupportedLanguage;

/**
 * @author tooooolazy
 *
 */
public interface LanguageController extends TransactionalController {
	public List getLanguages();
//	public void addSupportedLanguages();
//	public void addDefaultLabels();

	public SupportedLanguage findLanguage(String language);

	/**
	 * Retrieves the Label from DB based on the provided 'key'. Null is returned if no such label exists.
	 * @param key
	 * @return
	 */
	public Object findLabel(String key);
	public Object createLabel(String lang, String key, String value);
	public Object createDefaultLabel(String lang, String key, String value);
	/**
	 * The idea is to retrieve multilingual text from DB and then (another function)
	 * integrate them with the resource bundle messages.
	 * Labels + LabelsML tables are the first candidates.
	 * The table should have a 'resourceKey' column field so that it can be merged into the final messages.
	 * The whole idea came from using GWT where we had to have all resources loaded in html as dictionary.
	 * @return
	 */
	public List getDBresources(String language);
	public List getDBresources(int group, String language);
	/**
	 * Retrieves all labels from DB for the given language and transforms them into a Map.
	 * @param language
	 * @return
	 */
	public Map<String, String> getDBresourcesAsMap(String language);
	public Map<String, String> getDBresourcesAsMap(int group, String language);
	}
