package com.cg.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import org.apache.log4j.Logger;


import com.cg.project.dto.ProgramsOffered;
import com.cg.project.dto.ProgramsScheduled;
import com.cg.project.exception.UASException;
import com.cg.project.utils.DBUtils;
import com.cg.project.utils.Log4jHTMLLayout;


public class AdminDAOImpl implements AdminDAO {
	
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
	public String loginverification(String login_id, String user_password) throws UASException {
		String loginQuery = "select * from Users where login_id=?";
		String role= "";
		//String password="";
		
		try {
			PreparedStatement insertStatement = dbConnection.prepareStatement(loginQuery);
			
			
			insertStatement.setString(1, login_id);
			ResultSet result = insertStatement.executeQuery();
			while(result.next()){
		     String password=result.getString(2);
		   
			
			if(password.equals(user_password))
			{
				System.out.println("Valid user..");
				log.info("Valid user..");
				 role= result.getString(3);
			    
				return role;
			}
			else{
				System.out.println("\n login id or password is incorrect");
			    
			}  
			
			}	
		}catch (SQLException e) {
			e.printStackTrace();
			log.error(e.getMessage());
		  throw new UASException("Login failed...",e);
			//return null;
		}
		
		
  return role;
				
	}

	@Override
	public void retrieveprograms() throws UASException {
		String retreivequery= " select * from Programs_Scheduled ";
		try{
			PreparedStatement insertStatement = dbConnection.prepareStatement(retreivequery);
            ResultSet result= insertStatement.executeQuery();
            while(result.next()){
            	String scheduledprogramid= result.getString(1);
            	String programname= result.getString(2);
            	String programlocation= result.getString(3);
                String startDate= result.getString(4);
                String endDate= result.getString(5);
				
            	int sessions_per_week= result.getInt(6);
            	
                ProgramsScheduled ps= new ProgramsScheduled();
                
                ps.setEnd_date(endDate);
                ps.setScheduledprogramid(scheduledprogramid);
                ps.setProgramName(programname);
                ps.setProgram_location(programlocation);
                ps.setSessions_per_week(sessions_per_week);
                ps.setStart_date(startDate);
                
                System.out.println("\n Scheduled Programs: \n ProgramID: "+ps.getScheduledprogramid());
                System.out.println("\n ProgramName: "+ ps.getProgramName());
                System.out.println("\n Program Location: "+ps.getProgram_location());
                System.out.println("\n Start Date: "+ ps.getStart_date());
                System.out.println("\n End Date: "+ps.getEnd_date());
                System.out.println("\n Sessions Per week: "+ ps.getSessions_per_week());
                
                

            }
            }
            catch (SQLException e) {
    			e.printStackTrace();
    			log.error(e.getMessage());
    			throw new UASException("Failed to retrieve program",e);
    			
    		}
            
	}
	
	
	@Override
	public boolean createprogram(ProgramsOffered progoff,ProgramsScheduled progsch) throws UASException {
		String insertquery1= " insert into Programs_Offered values(?,?,?,?,?) ";
		
		String insertquery2= " insert into Programs_Scheduled values(?,?,?,TO_DATE(?,'dd-mm-yyyy'),TO_DATE(?,'dd-mm-yyyy'),?) ";
		
		try {
			PreparedStatement insertStatement1 = dbConnection.prepareStatement(insertquery1);
			
			PreparedStatement insertStatement2 = dbConnection.prepareStatement(insertquery2);
			
			
			insertStatement1.setString(1, progoff.getProgramName());
			insertStatement1.setString(2, progoff.getDescription());
			insertStatement1.setString(3, progoff.getApplicant_eligibility());
			insertStatement1.setInt(4, progoff.getProgram_duration());
			insertStatement1.setString(5, progoff.getDegree_certificate_offered());
			
			
			insertStatement2.setString(1, progsch.getScheduledprogramid());
			insertStatement2.setString(2, progsch.getProgramName());
			insertStatement2.setString(3, progsch.getProgram_location());
			

			
			insertStatement2.setString(4, progsch.getStart_date() );
			insertStatement2.setString(5, progsch.getEnd_date());
			
			insertStatement2.setInt(6, progsch.getSessions_per_week());
			
						
			
			
			int rows1 = insertStatement1.executeUpdate();
			int rows2=insertStatement2.executeUpdate();
			
			if((rows1 > 0) && (rows2>0))
			{
				System.out.println("Program created succesfully...");
				log.info("Added a row in db now...");
				
				return true;
			}
				
				
			else 
				return false;
			
		} catch (SQLException e) {
			e.printStackTrace();
			log.error(e.getMessage());
			throw new UASException("Failed to create program",e);
			
		}
	
		
	}

	@Override
	public boolean updateprogram(String name, String startdate, String enddate, int sessions, String location) throws UASException {
        String updatequery= "update Programs_Scheduled Set  program_location=?, start_date=TO_DATE(?,'dd-mm-yyyy'), end_date=TO_DATE(?,'dd-mm-yyyy'), sessions_per_week=? where scheduledprogramid=?";
		try{
			PreparedStatement updatestatement= dbConnection.prepareStatement(updatequery);
			updatestatement.setString(1, location );
			updatestatement.setString(2, startdate);
			updatestatement.setString(3, enddate );

			updatestatement.setInt(4, sessions);
			updatestatement.setString(5, name);
			int rows = updatestatement.executeUpdate();
			if(rows > 0)
			{
				System.out.println("Program update created succesfully...");
				log.info("program updated in db now...");
				return true;
			}
				
				
			else 
				return false;
			
		} catch (SQLException e) {
			e.printStackTrace();
			log.error(e.getMessage());
			throw new UASException("Failed to update program",e);
			
		}

		
	}

	@Override
	public boolean deleteprogram(String name) throws UASException {
		String deletequery1= " delete from programs_scheduled where programname=?  ";
		String deletequery2= " delete from programs_offered where programname=?  ";
        try{
          PreparedStatement deletestatement1=dbConnection.prepareStatement(deletequery1);
          PreparedStatement deletestatement2=dbConnection.prepareStatement(deletequery2);
          deletestatement1.setString(1, name);
          deletestatement2.setString(1, name);

          deletestatement1.executeQuery();
          deletestatement2.executeQuery();
          System.out.println("\n program "+name+" deleted");
          return true;

        } catch (SQLException e) {
			e.printStackTrace();
			log.error(e.getMessage());
			return false;
        	
        }
	}

	@Override
	public void scheduledprogramsinfo(String start_date, String end_date) throws UASException {
        String selectquery=" select * from programs_scheduled where start_date=? AND end_date=?";
        try{
        	PreparedStatement selectstatement= dbConnection.prepareStatement(selectquery);
        	selectstatement.setString(1,start_date);
        	selectstatement.setString(2,end_date);
        	ResultSet result= selectstatement.executeQuery();
        	
        	while(result.next()){
            String id= result.getString(1);
            String name= result.getString(2);
            String location= result.getString(3);
            String startdate= result.getString(4);
            String enddate= result.getString(5);
            int sessions= result.getInt(6);
            System.out.println("\n ProgramId: "+ id);
            System.out.println("\n ProgramName: "+ name);
            System.out.println("\n Program Location: "+ location);
            System.out.println("\n Startdate: "+ startdate);
            System.out.println("\n Enddate: "+ enddate);
            System.out.println("\n Session per week: "+ sessions);

            
        	}
        	

        }catch (SQLException e) {
			e.printStackTrace();
			log.error(e.getMessage());
			throw new UASException("Unable to fetch scheduled programs information... ",e);
			
		
        	
        }
		
	}

	@Override
	public void finallist(String programid, String status) throws UASException {
        String selectquery= "select * from applicant where scheduledprogramid=? And status=?";
        try{
        	PreparedStatement selectstatement= dbConnection.prepareStatement(selectquery);
        	selectstatement.setString(1, programid);
        	selectstatement.setString(2, status);
        	ResultSet result= selectstatement.executeQuery();
        	while(result.next()){
        		String applicationid= result.getString(1);
        		String fullname= result.getString(2);
        		String dob= result.getString(3);
        		String qualification= result.getString(4);
        		int marks= result.getInt(5);
        		String goals= result.getString(6);
        		String email= result.getString(7);
        		String schprogid= result.getString(8);
        		String appstatus= result.getString(9);
        		String doi= result.getString(10);
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
        		System.out.println("\n\n");


        	}
        	
        	}catch (SQLException e) {
    			e.printStackTrace();
    			log.error(e.getMessage());
    			throw new UASException("Unable to retieve final list of applicants...",e);
    			
    		
            	
            }
            		
	}

	@Override
	public int countapplicants(String progid) throws UASException {
		String selectquery= "select * from applicant where scheduledprogramid=?";
        try{
        	PreparedStatement selectstatement= dbConnection.prepareStatement(selectquery);
        	selectstatement.setString(1, progid);
        	ResultSet rows= selectstatement.executeQuery();
        	int count=0;
        	while(rows.next()){
        		count++;


        	}
        	return count;
        	
        	}catch (SQLException e) {
    			e.printStackTrace();
    			log.error(e.getMessage());
    			throw new UASException("Failed to count thennumber of applicants...",e);
    			
    		   
            	
            }
          
	}

}
