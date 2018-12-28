package com.cg.ems.service;

import java.util.ArrayList;

import com.cg.ems.bean.Employee;
import com.cg.ems.exception.EmployeeIssueException;

public interface IEmployeeService {

	//validation
//	public boolean validateEmail(String email);
	public int addEmployee(Employee emp) throws EmployeeIssueException;
	//public Employee retrieveByEmployeeId(Object employeeId);
	public ArrayList<Employee> retrieveAllEmployeeinfo() throws EmployeeIssueException;

	public Employee viewEmployeeDetails(int empId) throws EmployeeIssueException;
	//Employee viewEmployeeDetails(int employeeId) throws EmployeeIssueException;
	public Employee deleteEmployeeDetails(int empId) throws EmployeeIssueException;


}
