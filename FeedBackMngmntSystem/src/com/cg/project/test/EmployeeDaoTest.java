package com.cg.project.test;

import static org.junit.Assert.*;


import java.sql.SQLException;
import org.junit.BeforeClass;
import org.junit.Test;

import com.cg.project.exception.EmployeeException;
import com.cg.project.dao.EmployeeDAOImpl;
import com.cg.project.dto.EmployeeDTO;

public class EmployeeDaoTest {
	static EmployeeDAOImpl dao;
	static EmployeeDTO employee;

	@BeforeClass
	public static void initialize() {
		System.out.println("in before class");
		dao = new EmployeeDAOImpl();
		employee = new EmployeeDTO();
	}

	@Test
	public void testAdduser() throws EmployeeException, SQLException {

		assertNotNull(dao.addUser(employee));
}
	@Test
	public void addFeedback() throws EmployeeException, SQLException {
		assertNotNull(dao.addFeedback(null));
	}

	/************************************
	 * Test case for addDonarDetails()
	 * @throws SQLException 
	 * 
	 ************************************/

	@Test
	public void addskill() throws EmployeeException, SQLException {
		assertNotNull(dao. addSkill(null));
		}

/*
	@Ignore
	@Test
	public void testAddDonarDetails1() throws EmployeeException {
		// increment the number next time you test for positive test case
		assertEquals(1001, dao.addDonorDetails(donor));
	}

	
*/
	
	
}