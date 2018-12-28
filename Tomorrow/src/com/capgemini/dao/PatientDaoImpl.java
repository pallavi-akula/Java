package com.capgemini.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.capgemini.bean.Patientbean;
import com.capgemini.exception.PatientsException;
import com.capgemini.util.DBConnection;

public class PatientDaoImpl implements IPatientDAO {
	
	Logger logger=Logger.getRootLogger();
	
	public PatientDaoImpl()
	{
	PropertyConfigurator.configure("resources//log4j.properties");
	
	}
	
	@SuppressWarnings("resource")
	public String addPatientDetails(Patientbean patientbean) throws PatientsException 
	{
		Connection connection = DBConnection.getInstance().getConnection();	
		
		PreparedStatement preparedStatement=null;		
		ResultSet resultSet = null;
		
		String patient_id=null;
		
		int queryResult=0;
		try
		{	
			
			preparedStatement=connection.prepareStatement(QueryMapper.INSERT_QUERY);

			
			preparedStatement.setString(1, patientbean.getName());
			preparedStatement.setString(2, patientbean.getAge());
			preparedStatement.setString(3, patientbean.getPhoneNumber());
			preparedStatement.setString(4, patientbean.getProductInterested());
				
			
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
				throw new PatientsException("Inserting Patient details failed ");

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
			throw new PatientsException("Tehnical problem occured refer log");
		}

		finally
		{
			try 
			{
				//resultSet.close();
				preparedStatement.close();
				connection.close();
			}
			catch (SQLException sqlException) 
			{
				sqlException.printStackTrace();
				logger.error(sqlException.getMessage());
				throw new PatientsException("Error in closing db connection");

			}
		}
		
		
	}

	

}
