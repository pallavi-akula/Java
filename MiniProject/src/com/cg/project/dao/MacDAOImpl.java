package com.cg.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import org.apache.log4j.Logger;

import com.cg.project.dto.Applicant;
import com.cg.project.exception.UASException;
import com.cg.project.utils.DBUtils;
import com.cg.project.utils.Log4jHTMLLayout;

public class MacDAOImpl implements MacDAO {
   
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
	

	@Override
	public void applicationstatus(int applicationid) throws UASException {
         String selectquery=" select status from applicant where applicationid=?";
         try{
        	 PreparedStatement selectstatement= dbConnection.prepareStatement(selectquery);
        	 selectstatement.setInt(1, applicationid);
        	
        	 ResultSet result=  selectstatement.executeQuery();
        	 while(result.next())
        	 {
        	 String status= result.getString(9);
        	 System.out.println("\n Status of "+ applicationid+ "is "+status);
        	 }
         }catch (SQLException e) {
 			e.printStackTrace();
 			log.error(e.getMessage());
 			throw new UASException("Unable to fetch status of the applicant...",e);
 			
 		}
         
	}

	@Override
	public boolean retrieveapplications(String scheduledprogramid) throws UASException {
           String selectquery= " select * from applicant where scheduledprogramid=?";
           
           try{
           	PreparedStatement selectstatement= dbConnection.prepareStatement(selectquery);
           	selectstatement.setString(1, scheduledprogramid);
           	
           	ResultSet result= selectstatement.executeQuery();
           	while(result.next()){
           		String id= result.getString(8);
           		if(id.equals(scheduledprogramid)){
           		String applicationid= result.getString(1);
           		String fullname= result.getString(2);
           		Date dob= result.getDate(3);
           		String qualification= result.getString(4);
           		int marks= result.getInt(5);
           		String goals= result.getString(6);
           		String email= result.getString(7);
           		String schprogid= result.getString(8);
           		String appstatus= result.getString(9);
           		Date doi= result.getDate(10);
           		System.out.println("\n ApplicationId: "+ applicationid);
           		System.out.println("\n Fullname: "+ fullname);
           		System.out.println("\n Date Of Birth: "+ dob);
           		System.out.println("\n qualification: "+ qualification);
           		System.out.println("\n Marks Obtained: "+ marks);
           		System.out.println("\n Goals: "+ goals);
           		System.out.println("\n Email: "+ email);
           		System.out.println("\n Scheduled Program Id: "+ schprogid);
           		System.out.println("\n Status: "+ appstatus);

           		System.out.println("\n Date Of Interview: "+ doi);
                

           	}else System.out.println("\n Failed to Retrieve "); return false;}
           	
           	}catch (SQLException e) {
       			e.printStackTrace();
       			log.error(e.getMessage());
       			throw new UASException("Retrieval of application failed...",e);
       		
               	
               }
           return true;
	}

	
	private int generateNextApplicantId() throws SQLException {
		 int id = 0;

		String selectQuery = "select application_id_seq.nextval from dual";

		Statement selectStatement = dbConnection.createStatement();
		ResultSet result = selectStatement.executeQuery(selectQuery);

		result.next();

		id = result.getInt(1);
		return id;
	}

	
	@Override
	public boolean createapplicant(Applicant appl) throws UASException {
String insertquery= " insert into applicant values(?,?,TO_DATE(?,'dd-mm-yyyy'),?,?,?,?,?,?,TO_DATE(?,'dd-mm-yyyy')) ";

		
		try {
			PreparedStatement insertStatement = dbConnection.prepareStatement(insertquery);
			

	  insertStatement.setInt(1, generateNextApplicantId());
			insertStatement.setString(2, appl.getFullname());
			
			
	
			
			insertStatement.setString(3, appl.getDateofbirth() );
			insertStatement.setString(4, appl.getHighestqualification());
			insertStatement.setInt(5, appl.getMarksobtained());
			insertStatement.setString(6, appl.getGoals());
			insertStatement.setString(7, appl.getEmail());
			insertStatement.setString(8, appl.getScheduledprogramid());
			insertStatement.setString(9, appl.getStatus());
			
			
			
			insertStatement.setString(10, appl.getDateofinterview());
			
			
			int rows = insertStatement.executeUpdate();
			
			if((rows > 0))
			{
				System.out.println("Applicant added succesfully...");
				System.out.println("Your Applicant ID is: "+generateNextApplicantId());
				log.info("Added a row in db now...");
				return true;
			}
				
				
			else 
				return false;
			
		} catch (SQLException e) {
			e.printStackTrace();
			log.error(e.getMessage());
			throw new UASException("Failed to create application...",e);
//			return false;
		}
	

	}

	@Override
	public void updateapplicationstatus(int applicantid,String status) throws UASException {
      String updatequery="update applicant set status=? where applicationid=?";
      try{
			PreparedStatement updatestatement= dbConnection.prepareStatement(updatequery);
			updatestatement.setString(1, status);
			updatestatement.setInt(2, applicantid);
			updatestatement.executeQuery();
      }catch (SQLException e) {
			e.printStackTrace();
			log.error(e.getMessage());
      }	
	
	}
}
