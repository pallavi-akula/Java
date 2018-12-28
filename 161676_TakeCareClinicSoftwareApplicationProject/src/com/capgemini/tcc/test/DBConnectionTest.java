package com.capgemini.tcc.test;

import java.sql.Connection;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.capgemini.tcc.dao.PatientDAO;
import com.capgemini.tcc.exception.PatientException;
import com.capgemini.tcc.util.DBConnection;



public class DBConnectionTest {
	static PatientDAO daotest;
	static Connection dbCon;
	/*Test cases for establishing the connection*/

	@BeforeClass
	public static void initialise() {
		daotest = new PatientDAO();
		dbCon = null;
	}

	@Before
	public void beforeEachTest() {
		System.out.println("----Starting DBConnection Test Case----\n");
	}

	/**
	 * Test case for Establishing Connection
	 * 
	 * @throws DonorException
	 **/
	@Test
	public void test() throws PatientException {
		Connection dbCon = DBConnection.getInstance().getConnection();
		Assert.assertNotNull(dbCon);
	}

	@After
	public void afterEachTest() {
		System.out.println("----End of DBConnection Test Case----\n");
	}

	@AfterClass
	public static void destroy() {
		System.out.println("\t----End of Tests----");
		daotest = null;
		dbCon = null;
	}

}
