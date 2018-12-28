package com.cg.learning.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.cg.learning.beans.Country;
import com.cg.learning.staticdb.CountryDB;

/**
 * 
 * @author yvalecha DAO class with operations like create, delete , fetch on the
 *         HashMap
 */
public class CountryDAOImpl implements ICountryDAO {
	static HashMap<Integer, Country> countryIdMap = CountryDB.getCountryIdMap();

	/**
	 * Fetching all details of countries
	 * 
	 * @return List<Country>
	 */
	public List<Country> getAllCountries() {
		List<Country> countries = new ArrayList<Country>(countryIdMap.values());
		return countries;
	}

	/**
	 * Fetching single country details
	 * 
	 * @param id
	 * @return Country
	 */
	public Country getCountry(int id) {
		Country country = countryIdMap.get(id);
		return country;
	}

	/**
	 * Creating a new Country
	 * 
	 * @param country
	 * @return Country
	 */
	public Country addCountry(Country country) {
		countryIdMap.put(country.getCountryId(), country);
		return country;
	}

	/**
	 * Updating an existing country
	 * 
	 * @param country
	 * @return Country
	 */
	public Country updateCountry(Country country) {
		if (country.getCountryId() <= 0)
			return null;
		countryIdMap.put(country.getCountryId(), country);
		return country;

	}

	/**
	 * Deleting an existing country
	 * 
	 * @param id
	 * @return Country
	 */
	public Country deleteCountry(int id) {
		return countryIdMap.remove(id);
	}

}
