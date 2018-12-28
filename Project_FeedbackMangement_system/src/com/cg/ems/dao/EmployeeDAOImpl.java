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
			pst.setString(3, emp.getSal());
			pst.setString(4, emp.getMail());
			pst.setString(5, emp.getFeedback());
			
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
	public Employee deleteEmployeeDetails(int empId) throws EmployeeIssueException {
		// TODO Auto-generated method stub
		Connection connection=null;
		try {
			connection = DBConnectivity.getConnected();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	
		
		PreparedStatement preparedStatement=null;
		ResultSet resultset = null;
		 Employee  employee=null;
		
		 try
			{
				preparedStatement=connection.prepareStatement(IQueryMapper. DELETE_EMP_BY_ID);
				preparedStatement.setInt(1,empId);
				resultset=preparedStatement.executeQuery();
				if( employee == null)
				{
					log.info("Record Found and deleted Successfully");
					return null;
				}
				
				
				
				
				
			}
		 catch(Exception e)
			{
				log.error(e.getMessage());
				throw new EmployeeIssueException(e.getMessage());
			}
		//return employee;
		
		
		
		
		
		return null;
	}

	
	
	@Override
	public Employee viewEmployeeDetails(int empId) throws EmployeeIssueException {
		
		Connection connection=null;
		try {
			connection = DBConnectivity.getConnected();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		PreparedStatement preparedStatement=null;
		ResultSet resultset = null;
		 Employee  employee=null;
		
		try
		{
			preparedStatement=connection.prepareStatement(IQueryMapper. RETRIEVE_EMP_BY_ID);
			preparedStatement.setInt(1,empId);
			resultset=preparedStatement.executeQuery();
			
			if(resultset.next())
			{
				employee = new Employee();
				employee.setName(resultset.getString(1));
				employee.setMobile(resultset.getString(2));
				employee.setSal(resultset.getString(3));
				employee.setMail(resultset.getString(4));
				employee.setFeedback(resultset.getString(5));
				
			}
			
			if( employee != null)
			{
				log.info("Record Found Successfully");
				return employee;
			}
			else
			{
				log.info("Record Not Found Successfully");
				return null;
			}
			
		}
		catch(Exception e)
		{
			log.error(e.getMessage());
			throw new EmployeeIssueException(e.getMessage());
		}
	/*	finally
		{
			try 
			{
				resultset.close();
				preparedStatement.close();
				connection.close();
			} 
			catch (SQLException e) 
			{
				log.error(e.getMessage());
				throw new EmployeeIssueException("Error in closing db connection");

			}
		}
		*/
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
				emp.setSal(rs.getString(4));
				emp.setMail(rs.getString(5));
				emp.setFeedback(rs.getString(6));
				empList.add(emp);
				
			}

		} catch (SQLException e) {
			throw new EmployeeIssueException("exception occured :: "
					+ e.getMessage());
		}

		return empList;
	}





	

	

}
