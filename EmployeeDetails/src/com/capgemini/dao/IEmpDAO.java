package com.capgemini.dao;

import com.capgemini.bean.EmployeeBean;
import com.capgemini.excep.EmployeeException;

public interface IEmpDAO {
	public String addEmployeeDetails(EmployeeBean emp) throws EmployeeException;
}
