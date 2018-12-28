package com.cg.learning.staticdb;

import java.util.HashMap;

import com.cg.learning.beans.Country;

/**
 * 
 * @author yvalecha
 * Static DB class, hosting country details in a HashMap
 */
public class CountryDB {
	static HashMap<Integer, Country> countryIdMap = getCountryIdMap();
	
	static {
		if (countryIdMap == null) {
			countryIdMap = new HashMap<Integer, Country>();
			Country indiaCountry = new Country(1, "India", 10000);
			Country chinaCountry = new Country(4, "China", 20000);
			Country nepalCountry = new Country(3, "Nepal", 8000);
			Country bhutanCountry = new Country(2, "Bhutan", 7000);

			countryIdMap.put(1, indiaCountry);
			countryIdMap.put(4, chinaCountry);
			countryIdMap.put(3, nepalCountry);
			countryIdMap.put(2, bhutanCountry);
		}

	}
	/**
	 * This is a getter method of HashMap
	 * @return HashMap<Integer, Country>
	 */
	public static HashMap<Integer, Country> getCountryIdMap() {
		return countryIdMap;
	}
}
