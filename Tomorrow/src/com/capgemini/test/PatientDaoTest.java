package com.capgemini.test;  

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.capgemini.bean.Patientbean;
import com.capgemini.dao.PatientDaoImpl;
import com.capgemini.exception.PatientsException;


public class PatientDaoTest {

    static PatientDaoImpl dao;
    static Patientbean patientbean;

    @BeforeClass
    public static void initialize() {
        dao = new PatientDaoImpl();
        patientbean = new Patientbean();
    }

    @Test
    public void testAddDonarDetails() throws PatientsException {

        assertNotNull(dao.addPatientDetails(patientbean));
    }
    
    /************************************
     * Test case for addCustomerDetails()
     * 
     ************************************/

    @Ignore
    @Test
    public void testAddDonarDetails1() throws PatientsException {
        assertEquals(1001, dao.addPatientDetails(patientbean));
    }

    /************************************
     * Test case for addCustomerDetails()
     * 
     ************************************/

    @Test
    public void testAddCustomerDetails2() throws PatientsException {
        
    	patientbean.setName("com");
    	patientbean.setPhoneNumber("9000342237");
    	patientbean.setAge("22");
    	patientbean.setProductInterested("apple");
        assertTrue("Data Inserted successfully",
                Integer.parseInt(dao.addPatientDetails(patientbean)) > 1000);

    }
}