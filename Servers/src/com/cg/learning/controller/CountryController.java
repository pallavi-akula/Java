package com.cg.learning.controller;

import java.util.List;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.cg.learning.beans.Country;
import com.cg.learning.service.CountryService;
import com.cg.learning.service.ICountryService;

/**
 * 
 * @author yvalecha Controller mapping different HTTP methods, supporting Media
 *         type as JSON
 */
@Path("/countries")
public class CountryController {
	ICountryService countryService;

	public CountryController() {
		countryService = new CountryService();
	}

	/**
	 * Method to list all country details, supporting HTTP GET method and
	 * produces Media type of JSON
	 * 
	 * @return List<Country>
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Country> getCountries() {
		List<Country> listOfCountries = countryService.getAllCountries();
		return listOfCountries;
	}

	/**
	 * Method to print specific country details, supporting HTTP GET method and
	 * produces Media type of JSON
	 * 
	 * @PathParam is used to extract parameter from URL
	 * @return Country
	 */
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Country getCountryById(@PathParam("id") int id) {
		return countryService.getCountry(id);
	}

	/**
	 * Method to create a new country,supporting HTTP POST method produces Media
	 * type of JSON
	 * 
	 * @FormParam used to retrieve the values entered in html form
	 * @param txtId
	 * @param txtName
	 * @param txtPopulation
	 * @return Country
	 */
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Country addCountry(@FormParam("txtId") int txtId,
			@FormParam("txtName") String txtName,
			@FormParam("txtPopulation") long txtPopulation) {
		Country country = new Country();
		country.setCountryId(txtId);
		country.setCountryName(txtName);
		country.setPopulation(txtPopulation);
		return countryService.addCountry(country);
	}

	/**
	 * Method to delete a country,supporting HTTP POST method, here we are using
	 * POST to support delete produces Media type of JSON
	 * 
	 * @param id
	 * @return Country
	 */
	@POST
	@Path("/delete")
	@Produces(MediaType.APPLICATION_JSON)
	public Country deleteCountry(@FormParam("txtId") int id) {
		Country country = countryService.deleteCountry(id);
		// if valid country Id is existing then country gets deleted; otherwise
		// returning a JSON object with default (null) values
		if (country != null) {
			return country;
		} else {
			return new Country();
		}

	}

}
