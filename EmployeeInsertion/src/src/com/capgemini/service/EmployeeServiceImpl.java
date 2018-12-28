package com.capgemini.service;

import com.capgemini.bean.Employee;
import com.capgemini.dao.EmployeeDao;
import com.capgemini.dao.EmployeeDaoImpl;
import com.capgemini.exception.EmployeeException;

public class EmployeeServiceImpl implements EmployeeService {

	EmployeeDao cbd= new EmployeeDaoImpl();
	
	@Override
	public int addEmployee(Employee employee) throws EmployeeException {
		
		return cbd.addEmployee(employee);
	}

	@Override
	public Employee getEmployee(int EmployeeNo) throws EmployeeException {
		
		return cbd.getEmployee(EmployeeNo);
	}

	@Override
	public boolean isValidEmployee(Employee employee) throws EmployeeException {
	
 	    
 	    if(employee.getEmployeeName()==null){
 	    	throw new EmployeeException("Employee name", null);
 	    }
		return true;
	}

	
	
	
}
