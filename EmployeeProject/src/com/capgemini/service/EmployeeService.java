package com.capgemini.service;

import com.capgemini.bean.Employee;
import com.capgemini.exception.EmployeeException;

public interface EmployeeService {

	public int addEmployee(Employee employee) throws EmployeeException;
	public Employee getEmployee(int EmployeeNo) throws EmployeeException;
	public boolean isValidEmployee(Employee employee) throws EmployeeException;
	
	
}
