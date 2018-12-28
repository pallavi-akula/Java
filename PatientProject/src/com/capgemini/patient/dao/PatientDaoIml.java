import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.capgemini.patient.exception.PatientException;
import com.capgemini.patient.util.DBConnection;
import com.capgemini.tcc.bean.*;

public class PatientDaoIml implements IPatientDao {
	
	Logger logger=Logger.getRootLogger();
	
	public PatientDaoIml()
	{
	PropertyConfigurator.configure("resources//log4j.properties");
	
	}
	
	
	public String addPatientDetails(Patient patient) throws PatientException 
	{
		Connection connection = DBConnection.getInstance().getConnection();	
		
		PreparedStatement preparedStatement=null;		
		ResultSet resultSet = null;
		
		String patient_id=null;
		
		int queryResult=0;
		try
		{	
			
			preparedStatement=connection.prepareStatement(QueryMapper.INSERT_QUERY);

			
			preparedStatement.setString(1, patient.getName());
			preparedStatement.setString(2, patient.getAge());
			preparedStatement.setString(3, patient.getPhoneNumber());
			preparedStatement.setString(4, patient.getDescription());
				
			
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
				//resultSet.close();
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

}