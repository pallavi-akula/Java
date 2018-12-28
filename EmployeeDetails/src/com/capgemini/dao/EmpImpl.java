package com.capgemini.dao;

import com.capgemini.bean.EmployeeBean;
import com.capgemini.excep.EmployeeException;

public class EmpImpl implements IEmpDAO  {
	Logger logger=Logger.getRootLogger();
		public EmpImpl()
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

		public String addEmployeeDetails(EmployeeBean emp) throws EmployeeException
		{
			Connection connection = DBConnection.getInstance().getConnection();	
			
			PreparedStatement preparedStatement=null;		
			ResultSet resultSet = null;
			
			String donorId=null;
			
			int queryResult=0;
			try
			{		
				preparedStatement=connection.prepareStatement(QueryMapper.INSERT_QUERY);

				preparedStatement.setString(1,emp.getName());			
				preparedStatement.setString(2,emp.getEmpno());
					
				
				queryResult=preparedStatement.executeUpdate();
			
				preparedStatement = connection.prepareStatement(QueryMapper.DONARID_QUERY_SEQUENCE);
				resultSet=preparedStatement.executeQuery();

				if(resultSet.next())
				{
					donorId=resultSet.getString(1);
							
				}
		
				if(queryResult==0)
				{
					logger.error("Insertion failed ");
					throw new DonorException("Inserting donor details failed ");

				}
				else
				{
					logger.info("Donor details added successfully:");
					return donorId;
				}

			}
			catch(SQLException sqlException)
			{
				sqlException.printStackTrace();
				logger.error(sqlException.getMessage());
				throw new DonorException("Tehnical problem occured refer log");
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
					throw new DonorException("Error in closing db connection");

				}
			}
			
			
		}

		
}
