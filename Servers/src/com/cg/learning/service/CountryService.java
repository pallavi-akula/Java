package com.cg.learning.service;

import java.util.List;

import com.cg.learning.beans.Country;
import com.cg.learning.dao.CountryDAOImpl;
import com.cg.learning.dao.ICountryDAO;

/**
 * CountryService acting as a service layer dispatching calls to DAO layer
 * 
 * @author yvalecha
 *
 */
public class CountryService implements ICountryService {
	ICountryDAO dao;

	public CountryService() {
		dao = new CountryDAOImpl();
	}

	/**
	 * Fetching all details of countries
	 * 
	 * @return List<Country>
	 */
	public List<Country> getAllCountries() {
		return dao.getAllCountries();
	}

	/**
	 * Fetching single country details
	 * 
	 * @param id
	 * @return Country
	 */
	public Country getCountry(int id) {
		return dao.getCountry(id);
	}

	/**
	 * Creating a new Country
	 * 
	 * @param country
	 * @return Country
	 */
	public Country addCountry(Country country) {
		return dao.addCountry(country);
	}

	/**
	 * Deleting an existing country
	 * 
	 * @param id
	 * @return Country
	 */
	public Country deleteCountry(int id) {
		return dao.deleteCountry(id);
	}

}
