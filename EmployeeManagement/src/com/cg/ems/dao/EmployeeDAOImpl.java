package com.cg.ems.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.cg.ems.bean.Employee;
import com.cg.ems.dbutil.DBConnectivity;
import com.cg.ems.dbutil.IQueryMapper;
import com.cg.ems.exception.EmployeeIssueException;

public class EmployeeDAOImpl implements IEmployeeDAO {
	Logger log = null;

	public EmployeeDAOImpl() {
		PropertyConfigurator.configure("src/resources/log4j.properties");
		log = Logger.getRootLogger();
		log.setLevel(Level.ALL);
		
	}

	Connection conn = null;

	@Override
	public int addEmployee(Employee emp) throws EmployeeIssueException {
		// db logic
		int retId = 0;
		try {
			log.info("program for insertion started");
			conn = DBConnectivity.getConnected();
			PreparedStatement pst = conn
					.prepareStatement(IQueryMapper.INSERT_EMPLOYEE_INFO);
			pst.setString(1, emp.getName());
			log.info("name is set :: " + emp.getName());
			pst.setString(2, emp.getMobile());
			pst.setInt(3, emp.getSal());
			pst.setString(4, emp.getMail());
			log.warn("data may not be stored due to DB issue");
			int status = pst.executeUpdate();
			log.info("data is getting stored");
			if (status >= 1) {
				
				pst = conn.prepareStatement(IQueryMapper.EMP_SEQ_CURR_ID);
				ResultSet rs = pst.executeQuery();

				if (rs.next()) {
					retId = rs.getInt(1);
					log.info("data is stored with emp id :: "+retId);
					
				}
			}

		} catch (SQLException e) {
log.error("error : "+e.getMessage());
			// throw it user defined excep
			throw new EmployeeIssueException("DB problem : " + e.getMessage());

		}
		return retId;
	}

	@Override
	public Employee retrieveByEmployeeId(int eid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Employee> retrieveAllEmployeeinfo()
			throws EmployeeIssueException {
		ArrayList<Employee> empList = new ArrayList<Employee>();
		try {
			conn = DBConnectivity.getConnected();
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(IQueryMapper.RETRIEVE_ALL_EMP);
			Employee emp = null;

			while (rs.next()) {
				emp = new Employee();
				emp.setEmpId(rs.getInt(1));
				emp.setName(rs.getString(2));
				emp.setMobile(rs.getString(3));
				emp.setSal(rs.getInt(4));
				emp.setMail(rs.getString(5));
				empList.add(emp);
			}

		} catch (SQLException e) {
			throw new EmployeeIssueException("exception occured :: "
					+ e.getMessage());
		}

		return empList;
	}

}
