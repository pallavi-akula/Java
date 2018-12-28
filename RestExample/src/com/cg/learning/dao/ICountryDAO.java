package com.cg.learning.dao;

import java.util.List;

import com.cg.learning.beans.Country;

public interface ICountryDAO {
	public List<Country> getAllCountries();
	public Country getCountry(int id);
	public Country addCountry(Country country);
	public Country deleteCountry(int id);
}
