/**
 * 
 */
package com.tooooolazy.gwt.shared.interfaces;

import java.util.List;

/**
 * @author tooooolazy
 *
 */
public interface AddressController extends TransactionalController {
	public List getCountries();
//	public List getCounties();
	public List getCounties(String country_alpha2_code);
//	public List getCities();
	public List getCities(Integer county_id);
	public Object findCountryByLanguage(String language);
}
