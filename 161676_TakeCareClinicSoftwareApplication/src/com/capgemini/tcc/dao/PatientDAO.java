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
	

	
	@SuppressWarnings("resource")
	public int addPatientDetails(PatientBean patientbean) throws PatientException 
	{
		Connection connection = DBConnection.getInstance().getConnection();	
		
		PreparedStatement preparedStatement=null;		
		ResultSet resultSet = null;
		
		int patient_id=0;
		
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
				patient_id=resultSet.getInt(1);
						
			}
	
			if(queryResult==0)
			{
				logger.error("Insertion failed ");
				throw new PatientException("Inserting Customer details failed ");

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
	/*
	public PatientBean getPatientDetails(int patient_id) throws PatientException {
        logger.info("getAppointmentStatus method called");
		
        PatientBean patientbean = null;
		
		int index = patientbean.indexOf( new PatientBean( ) );
		
		//check if appointment request exists
		if( index == -1 )
		{
			logger.error("Exception: Sorry No Appointment Request exists with id " +patient_id );
			throw new PatientException("Sorry No Appointment Request exists with id " + patient_id);
		}
		
		//else get the appointment which exists
		patientbean = patientbean.get( index ); 
		
		return patientbean;
		//return null;
	}




	
*/



	

}
