package com.cg.learning.beans;

/**
 * 
 * @author yvalecha
 * Country bean with getters and setters and default and parametarized constructor
 */
public class Country {
	private int countryId;
	private String countryName;
	private long population;

	public Country() {

	}

	public Country(int countryId, String countryName, long population) {
		super();
		this.countryId = countryId;
		this.countryName = countryName;
		this.population = population;
	}

	public int getCountryId() {
		return countryId;
	}

	public void setCountryId(int countryId) {
		this.countryId = countryId;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public long getPopulation() {
		return population;
	}

	public void setPopulation(long population) {
		this.population = population;
	}

}
