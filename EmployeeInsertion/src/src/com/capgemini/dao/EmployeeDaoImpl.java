package com.capgemini.dao;
	import java.sql.Connection;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.sql.Statement;

	import org.apache.log4j.Logger;

import com.capgemini.bean.Employee;
import com.capgemini.exception.EmployeeException;
import com.capgemini.utils.DBUtils;
import com.capgemini.utils.Log4jHTMLLayout;

	public class EmployeeDaoImpl implements EmployeeDao {

		
	private static Logger log = Logger.getLogger(Log4jHTMLLayout.class);
		
		private Connection dbConnection;

		{
			try {
				dbConnection = DBUtils.getConnection();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	
		

	   
	   
		
		

		//implemented Methods
		
		@Override
		public int addEmployee(Employee employee) throws EmployeeException {
			
			String insertQuery = "insert into employee values(?,?)";
			
			try {
				PreparedStatement insertStatement = dbConnection.prepareStatement(insertQuery);
				
				insertStatement.setInt(1, employee.getEmployeeNo());
				
				insertStatement.setString(2, employee.getEmployeeName());
				
				
				
				int rows = insertStatement.executeUpdate();
				
				if(rows>0){
					System.out.println("New Enquiry Added..");
					log.info("New Enquiry is Added");
					return 1;
				}
				else 
					return 0;
					
			} catch (SQLException e) {
				
				e.printStackTrace();
				log.error(e.getMessage());
				return 0;
			}
			
			
		}

		
		
		




		@Override
		public Employee getEmployee(int EmployeeNo) throws EmployeeException {
			
			String selectQuery = "select * from employee where employeeNo = ?";
			
			try{
			
			PreparedStatement selectStatement = dbConnection.prepareStatement(selectQuery);
			
			selectStatement.setInt(1, EmployeeNo);
			
			ResultSet result = selectStatement.executeQuery();
			
			while (result.next()) {
				
				int employeeNo = result.getInt(1);
				
				String employeeName = result.getString(2);
				
				
				Employee employee = new Employee();
				employee.setEmployeeNo(employeeNo);
				employee.setEmployeeName(employeeName);
			
				return employee;
				
			}
			
			} catch(SQLException e){
				
				e.printStackTrace();
				
				throw new EmployeeException("Employee not found",e);
			}
			
			return null;
		}
		
		
		
	}

