package com.capgemini.util;
import java.io.FileInputStream;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import com.capgemini.exception.PatientsException;

import oracle.jdbc.pool.OracleDataSource;



public class DBConnection {
	private static Connection conn = null;
	private static DBConnection instance = null;
	private static Properties props = null;
	private static OracleDataSource dataSource = null;
	
	private DBConnection() throws  PatientsException{
		try {
			props = loadProperties();
			dataSource = prepareDataSource();
		} catch (IOException e) {
			throw new PatientsException(
					" Could not read the database details from properties file ");
		} catch (SQLException e) {
			throw new PatientsException(e.getMessage());
		}

	}

	/*****************************************************************
	 *  - Method Name:getInstance() 
	 *  - Input Parameters : 
	 *  - Return Type :DBConnection instance
	 *  - Throws : PatientsException 
	 *  - Author : CAPGEMINI 
	 *  - Creation Date : 18/11/2016
	 *  - Description : Singleton and Thread safe class
	 *******************************************************************/
	
	public static DBConnection getInstance() throws PatientsException {
		synchronized (DBConnection.class) {
			if (instance == null) {
				instance = new DBConnection();
			}
		}
		return instance;
	}
	
	/*****************************************************************
	 *  - Method Name:getConnection() 
	 *  - Input Parameters : 
	 *  - Return Type :DBConnection instance
	 *  - Throws : PatientsException 
	 *  - Author : CAPGEMINI 
	 *  - Creation Date : 18/11/2016
	 *  - Description :  Returns connection object
	 *******************************************************************/
	public Connection getConnection() throws PatientsException {
		try {

			conn = dataSource.getConnection();

		} catch (SQLException e) {
			
			throw new PatientsException(" Database connection problem");
		}
		return conn;
	}
	
	/*****************************************************************
	 *  - Method Name:loadProperties()
	 *  - Input Parameters : 
	 *  - Return Type :Properties object
	 *  - Author : CAPGEMINI 
	 *  - Creation Date : 18/11/2016
	 *  - Description : Returns Properties object
	 *******************************************************************/
	
	private Properties loadProperties() throws IOException {

		if (props == null) {
			Properties newProps = new Properties();
			String fileName = "resources/jdbc.properties";

			InputStream inputStream = new FileInputStream(fileName);
			newProps.load(inputStream);

			inputStream.close();

			return newProps;
		} else {
			return props;
		}
	}


	/*****************************************************************
	 *  - Method Name:prepareDataSource() 
	 *  - Input Parameters : 
	 *  - Return Type :OracleDataSource object
	 *  - Author : CAPGEMINI 
	 *  - Creation Date : 18/11/2016
	 *  - Description : Returns OracleDataSource object
	 *******************************************************************/
	
	private OracleDataSource prepareDataSource() throws SQLException {

		if (dataSource == null) {
			if (props != null) {
				String connectionURL = props.getProperty("dburl");
				String username = props.getProperty("username");
				String password = props.getProperty("password");

				dataSource = new OracleDataSource();

				dataSource.setURL(connectionURL);
				dataSource.setUser(username);
				dataSource.setPassword(password);
			}
		}
		return dataSource;
	}

}

