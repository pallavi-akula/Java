package com.capgemini.dao;

import com.capgemini.bean.Employee;
import com.capgemini.exception.EmployeeException;

public interface EmployeeDao {

	public int addEmployee(Employee employee) throws EmployeeException;
	public Employee getEmployee(int EmployeeNo) throws EmployeeException;
	
}
