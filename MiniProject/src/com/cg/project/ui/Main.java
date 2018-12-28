package com.cg.project.ui;

import java.util.Scanner;

import com.cg.project.dto.Applicant;
import com.cg.project.dto.ProgramsOffered;
import com.cg.project.dto.ProgramsScheduled;
import com.cg.project.exception.UASException;
import com.cg.project.service.AdminDAOService;
import com.cg.project.service.AdminDAOServiceImpl;
import com.cg.project.service.MacDAOService;
import com.cg.project.service.MacDAOServiceImpl;

public class Main {

	public static void main(String[] args) throws UASException {
		Scanner sc = new Scanner(System.in);
		while(true)
		{
		System.out.println("Welcome to University Admission System\n");
		System.out.println("1. Login (MAC/Admin)\n");
		System.out.println("2. View Scheduled Programs \n");
		System.out.println("3. Apply for a course\n");
		System.out.println("4. View Application Status\n");
		System.out.println("\n 5. Exit");
		System.out.println("Enter your choice: \n");
		AdminDAOService admindao = new AdminDAOServiceImpl();
        MacDAOService macdao = new MacDAOServiceImpl();
		int choice = sc.nextInt();
		if(choice!=5){
		switch(choice)
		{
		
		case 1: 
		        
		        
		        System.out.println("Login ID: \n");
		        String login_id = sc.next(); 
		        
		        System.out.println("Password: \n");
		        String user_password = sc.next();
		      
		     
		        String role = admindao.loginverification(login_id, user_password);
		   
		        if(role.equals("MAC"))
		        {   
		        	
                    while(true)
                    {
		        	System.out.println("\n-----------MAC Portal------------");
		        	System.out.println("\n 1.SetApplicationStatus \n 2.Retreive Applications\n 3.logout");
		            System.out.println("\n Enter Choice: \n");
		            
		            int opt= sc.nextInt();
		            if(opt!=3)
		            {
		            switch(opt){
		            case 1: System.out.println("\n Enter ApplicantId: ");
		                     int id= sc.nextInt();
		                     System.out.println("\n Status: ");
		                     String status= sc.next();
		                     macdao.updateapplicationstatus(id, status);
		                     break;
		            case 2: System.out.println("\n enter program Id to view applicants:");
		                    String progid= sc.next();
		                    macdao.retrieveapplications(progid);
		                    break;
		          //  case 3: System.out.println("\n logged out successfully");  break;
		            default: System.out.println("\n invalid option");
		                    
		            }
		            }
		            else 
		        	{
		        		System.out.println("\n Logged out successfully...\n"); break;
		        		
		        	}
                    }
		        }else if(role.equals("ADMIN"))
		        {
		        	while(true)
                    {
		        	System.out.println("\n------------ADMIN Portal--------------");
		        	System.out.println("\n 1.Create Program\n 2.Update Program\n 3.Delete Program");
		        	System.out.println("\n 4.View Applicants For a ScheduledProgram and Status \n 5.Logout");
		        	int opt2= sc.nextInt();
		        	if(opt2!=5)
		        	{
		        	switch(opt2){
		        	case 1: System.out.println("\n ProgramName: ");
		        	        String progname=sc.next();
		        	        System.out.println("\n Description: ");
		        	        String description= sc.next();
		        	        System.out.println("\n ApplicantEligibility: ");
		        	        String applEligibility= sc.next();
		        	        System.out.println("\n Duration of Program: ");
		        	        int duration = sc.nextInt();
		        	        System.out.println("\n Certificate Offered: ");
		        	        String certificate=sc.next();
		        	        
		        	        ProgramsOffered progoff= new ProgramsOffered();
		        	        
		        	        progoff.setProgramName(progname);
		        	        progoff.setDescription(description);
		        	        progoff.setApplicant_eligibility(applEligibility);
		        	        progoff.setProgram_duration(duration);
		        	        progoff.setDegree_certificate_offered(certificate);
		        	        
		        	        System.out.println("\n ProgramId: ");
		        	        String progid= sc.next();
		        	        System.out.println("\n Start Date(dd-mm-yyyy): ");
		        	        String startdate=sc.next();
		        	        System.out.println("\n ENd Date(dd-mm-yyyy): ");
		        	        String enddate=sc.next();
		        	        System.out.println("\n Program Location: ");
		        	        String location= sc.next();
		        	        System.out.println("\n Sessions per week: ");
		        	        int spw= sc.nextInt();
		        	        ProgramsScheduled progsch= new ProgramsScheduled();
		        	        progsch.setScheduledprogramid(progid);
		        	        progsch.setProgram_location(location);
		        	        progsch.setEnd_date(enddate);
		        	        progsch.setStart_date(startdate);
		        	        progsch.setProgramName(progname);
		        	        
		        	        progsch.setSessions_per_week(spw);
		        	        admindao.createprogram(progoff, progsch);
		        	        break;
		        	case 2:  System.out.println("\n enter Programid to update: ");
        	        		 String name= sc.next();
        	        		int count = admindao.countapplicants(name);
 		        	        if(count==0){
 		        	        System.out.println("\n Start Date(dd-mm-yyyy): ");
 		        	        String start_date= sc.next();
 		        	        System.out.println("\n ENd Date(dd-mm-yyyy): ");
 		        	        String end_date= sc.next();
 		        	        System.out.println("\n Program Location: ");
 		        	        String plocation= sc.next();
 		        	        System.out.println("\n Sessions per week: ");
 		        	        int sessionspw= sc.nextInt();
 		        	        admindao.updateprogram(name, start_date, end_date, sessionspw, plocation);
		        	         }else System.out.println("\n Can't be updated");
 		        	        break; 
		        	case 3:  System.out.println("\n enter Programid to delete: ");
	        		         String id= sc.next();
	        		         System.out.println("\n enter Programname to delete: ");
	        		         String name1=sc.next();
	        		         int count1 = admindao.countapplicants(id);
        	                 if(count1==0){
        	        		 admindao.deleteprogram(name1);
		        	         }else System.out.println("\n Can't be deleted");
        	                 break;
		        	case 4: System.out.println("\n Enter ProgramId view: ");
		        	        String programid=sc.next();
		        	        System.out.println("\n Enter Status: ");
		        	        String status= sc.next();
		        	        admindao.finallist(programid, status);
		        	        break;
		        //	case 5: System.out.println("\n logged out successfully"); break;
		        	default: System.out.println("\n invalid choice");
		        }
		        	}
		        	else 
		        	{
		        		System.out.println("\n Logged out successfully...\n"); break;
		        		
		        	}
                    }
		   }
		        break;
		    
		case 2: admindao.retrieveprograms();
		        break;
		case 3: System.out.println("\n Enter Details: ");
		        System.out.println("\n FullName: ");
		        String fullname= sc.next();
		        System.out.println("\n Enter DateOf Birth(dd-mm-yyyy): ");
		        String dob=sc.next();
		        System.out.println("\n Highest Qualification: ");
		        String qualification= sc.next();
		        System.out.println("\n Goals: ");
		        String goals= sc.next();
		        System.out.println("\n marks obtained: ");
		        int marks= sc.nextInt();
		        System.out.println("\n Email: ");
		        String email= sc.next();
		        System.out.println("\n ProgramId to Apply: ");
		        String programid= sc.next();
		        String status= "Applied";
		       String DOI="10-08-2018";
		        Applicant appl= new Applicant(fullname, dob, qualification, marks, goals, email, programid,status,DOI);
		        macdao.createapplicant(appl);
		        break;
		case 4: System.out.println("\n Enter ApplicantId: ");
		        int appid= sc.nextInt();
		        macdao.applicationstatus(appid);
		        break;
		 default: System.out.println("\n Invalid Choice");
		}}else {System.out.println("\n Exited Portal"); break;}
		
	 }
	}
	
}
