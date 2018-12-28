package com.cg.ems.service;

import java.util.ArrayList;

import com.cg.ems.bean.Employee;
import com.cg.ems.exception.EmployeeIssueException;

public interface IEmployeeService {

	//validation
	public boolean validateEmail(String email);
	public int addEmployee(Employee emp) throws EmployeeIssueException;
	public Employee retrieveByEmployeeId(int eid);
	public ArrayList<Employee> retrieveAllEmployeeinfo() throws EmployeeIssueException;
}
