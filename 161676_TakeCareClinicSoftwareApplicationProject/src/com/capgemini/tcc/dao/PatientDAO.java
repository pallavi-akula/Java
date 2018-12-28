package com.capgemini.tcc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import com.capgemini.tcc.bean.PatientBean;
import com.capgemini.tcc.exception.PatientException;
import com.capgemini.tcc.util.DBConnection;



public  class PatientDAO implements IPatientDAO {
	
	Logger logger=Logger.getRootLogger();
	
	public PatientDAO()
	{
	PropertyConfigurator.configure("resources//log4j.properties");
	
	}
	
//Add addPatientDetails Method to accept the information
	
	@SuppressWarnings("resource")
	public String addPatientDetails(PatientBean patientbean) throws PatientException 
	{
		Connection connection = DBConnection.getInstance().getConnection();	
		
		PreparedStatement preparedStatement=null;		
		ResultSet resultSet = null;
		
		String patient_id=null;
		
		int queryResult=0;
		try
		{		
			preparedStatement=connection.prepareStatement(QueryMapper.INSERT_QUERY);

			
			preparedStatement.setString(1, patientbean.getPatient_name());
			preparedStatement.setString(2, patientbean.getAge());
			preparedStatement.setString(3, patientbean.getPhone());
			preparedStatement.setString(4, patientbean.getDescription());
				
			
			queryResult=preparedStatement.executeUpdate();
		
			preparedStatement = connection.prepareStatement(QueryMapper.PATIENTID_QUERY_SEQUENCE);
			resultSet=preparedStatement.executeQuery();

			if(resultSet.next())
			{
				patient_id=resultSet.getString(1);
						
			}
	
			if(queryResult==0)
			{
				logger.error("Insertion failed ");
				throw new PatientException("Inserting Patient details failed ");

			}
			else
			{
				logger.info("Patient details added successfully:");
				return patient_id; 
			}

		}
		catch(SQLException sqlException)
		{
			sqlException.printStackTrace();
			logger.error(sqlException.getMessage());
			throw new PatientException("Tehnical problem occured refer log");
		}

		finally
		{
			try 
			{
				resultSet.close();
				preparedStatement.close();
				connection.close();
			}
			catch (SQLException sqlException) 
			{
				sqlException.printStackTrace();
				logger.error(sqlException.getMessage());
				throw new PatientException("Error in closing db connection");

			}
		}
		
		
	}
	//To display the Patient Information 
public PatientBean viewPatientDetails(String patient_id) throws PatientException {
		
		Connection connection=DBConnection.getInstance().getConnection();
		
		
		PreparedStatement preparedStatement=null;
		ResultSet resultset = null;
		PatientBean patientbean=null;
		
		try
		{
			preparedStatement=connection.prepareStatement(QueryMapper.VIEW_PATIENT_DETAILS_QUERY);
			preparedStatement.setString(1,patient_id);
			resultset=preparedStatement.executeQuery();
			
			if(resultset.next())
			{
				patientbean = new PatientBean();
				patientbean.setPatient_id(resultset.getString(1));
				patientbean.setPatient_name(resultset.getString(2));
				patientbean.setAge(resultset.getString(3));
				patientbean.setPhone(resultset.getString(4));
				patientbean.setDescription(resultset.getString(5));
				patientbean.setConsultation_Date(resultset.getDate(6));
				
			}
			
			if( patientbean != null)
			{
				logger.info("Patient Record Found Successfully");
				return patientbean;
			}
			else
			{
				logger.info("Patient Record Not Found Successfully");
				return null;
			}
			
		}
		catch(Exception e)
		{
			logger.error(e.getMessage());
			throw new PatientException(e.getMessage());
		}
		finally
		{
			try 
			{
				resultset.close();
				preparedStatement.close();
				connection.close();
			} 
			catch (SQLException e) 
			{
				logger.error(e.getMessage());
				throw new PatientException("Error in closing db connection");

			}
		}
		
	}




	

}
