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
    public void testAddPatientDetails() throws PatientsException {

        assertNotNull(dao.addPatientDetails(patientbean));
    }
    
    /************************************
     * Test case for addPatientDetails()
     * 
     ************************************/

    @Ignore
    @Test
    public void testAddPatientDetails1() throws PatientsException {
        assertEquals(1001, dao.addPatientDetails(patientbean));
    }

    /************************************
     * Test case for addPatientDetails()
     * 
     ************************************/

    @Test
    public void testAddPatientDetails2() throws PatientsException {
        
    	patientbean.setName("com");
    	patientbean.setPhoneNumber("9000342237");
    	patientbean.setAge("22");
    	patientbean.setDescription("apple");
        assertTrue("Data Inserted successfully",
                Integer.parseInt(dao.addPatientDetails(patientbean)) > 1000);

    }
}