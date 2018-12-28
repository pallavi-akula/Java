package com.cg.ems.service;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.cg.ems.bean.Employee;
import com.cg.ems.dao.EmployeeDAOImpl;
import com.cg.ems.dao.IEmployeeDAO;
import com.cg.ems.exception.EmployeeIssueException;

public class EmployeeServiceImpl implements IEmployeeService {

	IEmployeeDAO  edao;
	
	
	@Override
	public int addEmployee(Employee emp) throws EmployeeIssueException {
		//logic  like adding mr or mrs based on gender or age...
		emp.setName("Mr. "+emp.getName());
		edao=new EmployeeDAOImpl();
		int eid=edao.addEmployee(emp);
		return eid;
	}
	
	
	//@Override
	public Employee viewEmployeeDetails(int empId) throws EmployeeIssueException {
		edao = new EmployeeDAOImpl();
		Employee employee=null;
		employee=edao.viewEmployeeDetails(empId);
		return employee;
	}
		
	//	return null;
	

	@Override
	public ArrayList<Employee> retrieveAllEmployeeinfo() throws EmployeeIssueException {
		edao=new EmployeeDAOImpl();
		return edao.retrieveAllEmployeeinfo();
	}

public boolean validateEmployeeId(String employeeId) {
		
		Pattern idPattern = Pattern.compile("[1][0][1-9]");
		Matcher idMatcher = idPattern.matcher(employeeId);
		
		if(idMatcher.matches())
			return true;
		else
			return false;		
	}

	
}
