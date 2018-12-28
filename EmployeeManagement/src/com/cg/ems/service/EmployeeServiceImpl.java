package com.cg.ems.service;

import java.util.ArrayList;

import com.cg.ems.bean.Employee;
import com.cg.ems.dao.EmployeeDAOImpl;
import com.cg.ems.dao.IEmployeeDAO;
import com.cg.ems.exception.EmployeeIssueException;

public class EmployeeServiceImpl implements IEmployeeService {

	IEmployeeDAO  edao=null;
	
	@Override
	public boolean validateEmail(String email) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int addEmployee(Employee emp) throws EmployeeIssueException {
		//logic  like adding mr or mrs based on gender or age...
		emp.setName("Mr. "+emp.getName());
		edao=new EmployeeDAOImpl();
		int eid=edao.addEmployee(emp);
		return eid;
	}

	@Override
	public Employee retrieveByEmployeeId(int eid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Employee> retrieveAllEmployeeinfo() throws EmployeeIssueException {
		edao=new EmployeeDAOImpl();
		return edao.retrieveAllEmployeeinfo();
	}

}
