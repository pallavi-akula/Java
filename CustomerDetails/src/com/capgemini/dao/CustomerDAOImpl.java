package com.capgemini.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Logger;

import com.capgemini.beans.CustomerBean;
import com.capgemini.exception.CustomerException;
import com.capgemini.util.DBConnection;
/*
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
/*
import com.capgemini.CuatomerDetails.beans.DonorBean;
import com.capgemini.donorapplication.dao.QueryMapper;
import com.capgemini.donorapplication.exception.DonorException;
import com.capgemini.donorapplication.util.DBConnection;
*/
public class CustomerDAOImpl {
	Logger logger=Logger.getRootLogger();
	public CustomerDaoImpl()
	{
	PropertyConfigurator.configure("resources//log4j.properties");
	
	}
	

	//------------------------ 1. Donor Application --------------------------
	/*******************************************************************************************************
	 - Function Name	:	addDonorDetails(DonorBean donor)
	 - Input Parameters	:	DonorBean donor
	 - Return Type		:	String
	 - Throws			:  	DonorException
	 - Author			:	CAPGEMINI
	 - Creation Date	:	18/11/2016
	 - Description		:	Adding Donor
	 ********************************************************************************************************/

	public String addCustomerDetails(CustomerBean customer) throws CustomerException 
	{
		Connection connection = DBConnection.getInstance().getConnection();	
		
		PreparedStatement preparedStatement=null;		
		ResultSet resultSet = null;
		
		String donorId=null;
		
		int queryResult=0;
		try
		{		
			preparedStatement=connection.prepareStatement(QueryMapper.INSERT_QUERY);

			preparedStatement.setString(1,customer.getCustomerName());			
			
			queryResult=preparedStatement.executeUpdate();
		
			preparedStatement = connection.prepareStatement(QueryMapper.CUSTOMERID_QUERY_SEQUENCE);
			resultSet=preparedStatement.executeQuery();

			if(resultSet.next())
			{
				CustomerId=resultSet.getString(1);
						
			}
	
			if(queryResult==0)
			{
				logger.error("Insertion failed ");
				throw new CustomerException("Inserting Customer details failed ");

			}
			else
			{
				logger.info("Customer details added successfully:");
				return CustomerId;
			}

		}
		catch(SQLException sqlException)
		{
			sqlException.printStackTrace();
			logger.error(sqlException.getMessage());
			throw new CustomerException("Tehnical problem occured refer log");
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
				throw new CustomerException("Error in closing db connection");

			}
		}
		
		
	}

}
