package com.capgemini.tcc.test;

import static org.junit.Assert.*;
import org.junit.BeforeClass;

import org.junit.Test;

import com.capgemini.tcc.bean.PatientBean;
import com.capgemini.tcc.dao.PatientDAO;
import com.capgemini.tcc.exception.PatientException;




public class PatientDaoTest {

	static PatientDAO dao;
	static PatientBean patientbean;

	@BeforeClass
	public static void initialize() {
		dao = new PatientDAO();
		patientbean = new PatientBean();
	}
/*Testcase for add Customer Deatils*/
	@Test
	public void testAddCustomerDetails() throws PatientException {

		assertNotNull(dao.addPatientDetails(patientbean));
	}
	
	/************************************
	 * Test case for addCustomerDetails()
	 * 
	 ************************************/
	/*Testcase for Checking the Patient details*/
	
	@Test
	public void testAddPatientDetails1() throws PatientException {
		assertEquals("1029", dao.addPatientDetails(patientbean));
	}


	/************************************
	 * Test case for addCustomerDetails()
	 * 
	 ************************************/
	/*Testcase for Checking the Patient details via correct information*/
	@Test
	public void testAddPatientDetails2() throws PatientException {
		
		patientbean.setPatient_name("Smith");
		patientbean.setPhone("9000342237");
		patientbean.setAge("35");
		patientbean.setDescription("Suffering from high fever");
		assertEquals("Data Inserted successfully",
				(dao.addPatientDetails(patientbean)) > 1000);

	}
}

	
