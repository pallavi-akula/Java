import java.util.*;

import org.apache.log4j.Logger;

import java.lang.*;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.cg.project.dao.EmployeeDAOImpl;
import com.cg.project.dao.Employee_dao;
import com.cg.project.dto.CourseDto;
import com.cg.project.dto.EmployeeDTO;
import com.cg.project.dto.FacultySkillDTO;
import com.cg.project.dto.FeedbackDTO;
import com.cg.project.dto.TrainingDTO;
import com.cg.project.dto.TrainingPartIDTO;
import com.cg.project.exception.FeedbackManagement;
import com.cg.project.service.EmployeeServiceImpl;
import com.cg.project.service.IEmployeeService;

import java.io.*;

/**
 * @author kshitiz
 *
 */
public class Entry {

	static Scanner sc= new Scanner(System.in);
	public static IEmployeeService services;
	private static Logger logger= Logger.getLogger(Entry.class);
public static void main(String args[])throws FeedbackManagement{
 services=new EmployeeServiceImpl();
System.out.println("||||Enter the choice||||");
System.out.println("*-----*-------*-------*---------*---------*");
System.out.println("Enter 1 to Register as new User");
System.out.println("Enter 2 to Login as existing User");
int choice = sc.nextInt();
switch (choice) {
case 1:
	
	RegisterUser();
	break;
case 2:
	LoginUser();
	break;
default:
	System.out.println("Choose the correct Option");
	break;
}


}
	public static void RegisterUser() throws FeedbackManagement {
		
		System.out.println("Enter the Employee ID");
		int id=sc.nextInt();
		System.out.println("Enter the Employee Name");
		String name=sc.next();
		System.out.println("Enter the Employee Password");
		String password=sc.next();
		System.out.println("Write the Employee Role");
		String role=sc.next();
		EmployeeDTO empdto=new EmployeeDTO();
		empdto.setEmployee_id(id);
		empdto.setEmployee_name(name);
		empdto.setPassword(password);
		empdto.setRole(role);
		try {
			services.addUser(empdto);
			logger.info("Registration Unsuccessfull");
			LoginUser();
		}catch (Exception e) {
			logger.error(e.getMessage());
			throw new FeedbackManagement("Enter the valid details to register");
		}
}
	public static void LoginUser() throws FeedbackManagement {
		
		EmployeeDTO empdto= new EmployeeDTO();
		System.out.println("Enter the employee_id");
		int id= sc.nextInt();
		System.out.println("Enter the password");
		String password= sc.next();
		empdto.setEmployee_id(id);
		empdto.setPassword(password);
		try {
		String role= services.SearchForRole(empdto);
		if(role.equalsIgnoreCase("Admin"))
			adminRole();
		if(role.equalsIgnoreCase("Participant"))
			participantRole(id);
		if(role.equalsIgnoreCase("cocoordinator"))
			coordinatorRole();
		logger.info("Wrong Credentials");
		}
		catch(Exception e) {
			logger.error(e.getMessage());
			throw new FeedbackManagement("Enter the correct Login Credentials");
			
		}
			
	}
	private static void coordinatorRole() throws FeedbackManagement {
		// TODO Generate Menu for the Role-Cocoordinator
	System.out.println("||||Enter the choice||||");
	System.out.println("*-----*-------*-------*---------*---------*");
	System.out.println("Enter 1 to Add Training Program");
	System.out.println("Enter 2 to Delete Training Program");
	System.out.println("Enter 3 to Enroll Participant");
	System.out.println("Enter 4 to View Feedback");
	System.out.println("Enter 5 to Logout");
	int choice = sc.nextInt();
	switch (choice) {
	case 1:
		addTraining();
		break;
	case 2:
		deleteTraining();
		break;
	case 3:
		enrollParticipant();
	case 4:
		viewFeedback();
		break;
	case 5:
		LoginUser();
		break;
	default:
		System.out.println("Enter the correct choice");
		coordinatorRole();
	}
}
	private static void deleteTraining() {
	// TODO Auto-generated method stub
	
}
	private static void enrollParticipant() throws FeedbackManagement {
	// TODO Enroll Participant to the Training
	System.out.println("Kindly enter the training code to which partipant to be added");
	int tid=sc.nextInt();
	System.out.println("Enter the participant ID");
	int fid=sc.nextInt();
	TrainingPartIDTO partIDTO=new TrainingPartIDTO();
	partIDTO.setTraining_code(tid);
	partIDTO.setParticipant_id(fid);
	
	try {
		logger.info("Cannot Enroll Participant");
		services.addParticipant(partIDTO);
	}catch (Exception e) {
		logger.error(e.getMessage());
		throw new FeedbackManagement("PRovide the proper details");
	}
	
}
	private static void addTraining() throws FeedbackManagement {
	// TODO Add training on the Course
	TrainingDTO training =new TrainingDTO();
	System.out.println("Kindly enter the Course Id associated with it");
	int cid=sc.nextInt();
	System.out.println("Kindly enter the Faculty ID in that training");
	int fid=sc.nextInt();
	System.out.println("Enter the Starting Date");
	String sdate=sc.next();
	System.out.println("Enter the End Date");
	String edate=sc.next();
	training.setCourse_code(cid);
	training.setFaculty_code(fid);
	DateTimeFormatter formatter= DateTimeFormatter.ofPattern("dd-MM-yyyy");
	LocalDate sd=LocalDate.parse(sdate, formatter);
	LocalDate ed=LocalDate.parse(edate, formatter);
	training.setStart_date(sd);
	training.setEnd_date(ed);
    try {
		logger.info("Cannot add Training");
    	training=services.addTraining(training);
	} catch (Exception e) {
		logger.error(e.getMessage());
		throw new FeedbackManagement("Kindly enter the proper details");
	} 
	
}
	private static void participantRole(int id) throws FeedbackManagement {
		// TODO Menu for the Participant
	System.out.println("||||Enter the choice||||");
	System.out.println("*-----*-------*-------*---------*---------*");
	System.out.println("Enter 1 to Add Feedback");
	System.out.println("Enter 2 to Logout");
	int choice = sc.nextInt();
	switch (choice) {
	case 1:
		feedbackadd(id);
		break;
	case 2:
		LoginUser();
		break;
	default:
		System.out.println("Choose the correct option");
		participantRole(id);
	}
	}
	private static void feedbackadd(int id) throws FeedbackManagement {
	// TODO add Feedback
		FeedbackDTO feedback=new FeedbackDTO();
		System.out.println("Kindly enter the Training ID to be provvided Feedback");
		int tid=sc.nextInt();
		System.out.println("Rate the Course within 1-5");
		System.out.println("5-Excellent:-Ideal way of doing it-");
		System.out.println("4-Good:-No pain areas or concern but could have been better-");
		System.out.println("3-Average:-There are concerns but not significant-");
		System.out.println("2-Below Average:-Needs improvement and is salvageable-");
		System.out.println("1-Poor:-This way of doing things must change-");
		System.out.println("--------------------------------------------------------------------");
		System.out.println("----How do you rate Presentation and Communication?----");
		int fb_pr_com=sc.nextInt();
		System.out.println("----How do you rate Doubt Clearing?----");
		int fb_dbt=sc.nextInt();
		System.out.println("----How do you rate Time Management----");
		int fb_tm=sc.nextInt();
		System.out.println("----How do you rate Handout Provided----");
		int fb_hnd=sc.nextInt();
		System.out.println("----How do you rate HW/SW/NTWRK");
		int fb_hw=sc.nextInt();
		System.out.println("Kindly enter any comments");
		String comments=sc.next();
		System.out.println("Kindly provide some suggestion");
		String suggestion=sc.next();
		if(fb_pr_com>0&&fb_dbt>0&&fb_hnd>0&&fb_hw>0&&fb_tm>0)
		{
			if(fb_pr_com>5||fb_dbt>5||fb_tm>5||fb_hnd>5||fb_hw>5){
				System.out.println("Kindly check the input and re-enter the feedback");
				participantRole(id);
			logger.info("Feedback cannot be Added");
			}
			else
			{
				feedback.setComments(comments);
				feedback.setFb_hnd_out(fb_hnd);
				feedback.setFb_hw_sw_ntwrk(fb_hw);
				feedback.setFb_prs_comm(fb_pr_com);
				feedback.setFb_prs_dbts(fb_dbt);
				feedback.setFb_tm(fb_tm);
				feedback.setSuggestion(suggestion);
				feedback.setTraining_code(tid);
				feedback.setParticipant_id(id);
				
				try {
					feedback=services.addFeedback(id,feedback);
				} catch (Exception e) {
					logger.error(e.getMessage());
					throw new FeedbackManagement("Provide the correct details ");
				}
			}
		}
}
	private static void adminRole() throws FeedbackManagement {
		// TODO Menu for the Admin Role
		System.out.println("||||Enter the choice||||");
		System.out.println("*-----*-------*-------*---------*---------*");
		System.out.println("Enter 1 to Faculty Skill Maintenance");
		System.out.println("Enter 2 to Course Maintenance");
		System.out.println("Enter 3 to View Feedback Report");
		System.out.println("Enter 4 to Logout");
		int choice = sc.nextInt();
		switch (choice) {
		case 1:
			facultySkill();
			break;
		case 2:
			courseM();
			break;
		case 3:
			viewFeedback();
			break;
		case 4:
			LoginUser();
			break;
		default:
			System.out.println("Choose the correct option");
			adminRole();
			
		}
	}
	private static void viewFeedback() throws FeedbackManagement {
		// TODO Auto-generated method stub
		FeedbackDTO feedback=new FeedbackDTO();
		System.out.println();
		try {
			List<FeedbackDTO> feedbacks=services.feedbacks();
			
				for(FeedbackDTO c:feedbacks)
				{
					System.out.println("Training Code"+c.getTraining_code()+" Faculty Skills;"+c.getParticipant_id()+" Pres&Comm"+
							c.getFb_prs_comm()+"Clarify Doubts "+c.getFb_prs_dbts()+" TM"+c.getFb_tm()+" Handout"+c.getFb_hnd_out()+" Hw/Sw/Ntwrk"+c.getFb_hw_sw_ntwrk()
							);
				logger.info("Cannot View Feedback");
				}
		} catch (Exception e) {
			logger.info(e.getMessage());
			throw new FeedbackManagement("Provide the correct details");
		}
	}
	private static void courseM() throws FeedbackManagement {
		// TODO Auto-generated method stub
		System.out.println("Enter 1 to Show all Course");
		System.out.println("Enter 2 to Show Course by ID");
		System.out.println("Enter 3 to Add Course");
		System.out.println("Enter 4 to Delete Course");
		System.out.println("Enter 5 to Go Back");
		int choice = sc.nextInt();
		switch (choice) {
		case 1:
			showCourse();
			break;
		case 2:
			showCoursebyID();
			break;	
		case 3:
			addCourse();
			break;
		case 4:
			deleteCourse();
			break;
		case 5:
			adminRole();
			break;
		default:
			System.out.println("Choose the correct option");
			courseM();
		}
	}
	private static void deleteCourse() throws FeedbackManagement {
		// TODO Auto-generated method stub
		CourseDto course = new CourseDto();
		System.out.println("Enter course id");
		int course_id = sc.nextInt();
		course.setCourse_id(course_id);
		try {
			course =services.DeleteCourse(course);
		logger.info("Course cannot be Deleted");
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw new FeedbackManagement("Course ID is wrong");
		}
	}
	private static void addCourse() throws FeedbackManagement {
		// TODO Auto-generated method stub
		CourseDto course = new CourseDto();
		System.out.println("Enter The Course Name");
		String course_name = sc.next();
		System.out.println("Enter The Duration Of course");
		int no_of_days = sc.nextInt();
		course.setCourse_name(course_name);
		course.setNo_of_days(no_of_days);
		try {
			course =services.AddCourse(course);
			logger.info("Course cannot be Added");
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw new FeedbackManagement("Correct Details are not Proper");
		}
		
	}
	private static void showCoursebyID() throws FeedbackManagement {
		// TODO Auto-generated method stub
		CourseDto course = new CourseDto();
		System.out.println("Enter Course Id");
		int course_id = sc.nextInt();
		course.setCourse_id(course_id);
		try {
			course =services.SearchCourse(course);
			System.out.println(course.getCourse_name());
			System.out.println(course.getNo_of_days());
			logger.info("Cannot view course by id");} 
		catch (Exception e) {
			logger.error(e.getMessage());
			throw new FeedbackManagement("Enter the correct Course ID");
		}
		
		
	}
	private static void showCourse() throws FeedbackManagement {
		// TODO Auto-generated method stub
		CourseDto course=new CourseDto();
		System.out.println();
		try {
			List<CourseDto> courselist=services.listCourse();
			for(CourseDto c:courselist)
			{
				System.out.println("Course Id:"+c.getCourse_id()+" Course Name;"+c.getCourse_name()+" No of Days:"+
						c.getNo_of_days());
			logger.info("Cannot view Course");
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw new FeedbackManagement(e.getMessage());
		}
		
	}
	private static void facultySkill() throws FeedbackManagement {
		// TODO Auto-generated method stub
		System.out.println("Enter 1 to Show all Skills");
		System.out.println("Enter 2 to Show Skills by ID");
		System.out.println("Enter 3 to Add Skill");
		System.out.println("Enter 4 to Delete Skill");
		System.out.println("Enter 5 to Go Back");
		int choice = sc.nextInt();
		switch (choice) {
		case 1:
			showSkill();
			break;
		case 2:
			showSkillbyID();
			break;	
		case 3:
			addSkill();
			break;
		case 4:
			deleteSkill();
			break;
		case 5:
			adminRole();
			break;
		default:
			System.out.println("Enter the correct option");
			facultySkill();
		}
	}
	private static void showSkillbyID() throws FeedbackManagement {
		// TODO Auto-generated method stub
		System.out.println("Enter the ID for which you need to get Skills");
		int id=sc.nextInt();
		FacultySkillDTO faculty=new FacultySkillDTO();
		faculty.setFaculty_id(id);
		try {
			String skill=services.showSkill(faculty);
			System.out.println(skill);
			logger.info("No Such Skills");
		} catch (FeedbackManagement e) {
			logger.error(e.getMessage());
			throw new FeedbackManagement("Enter the correct details");
		}
	}
	private static void deleteSkill() throws FeedbackManagement {
		// TODO Auto-generated method stub
		System.out.println("Enter the Faculty ID for which skills to be deleted");
		System.out.println("Enter the faculty ");
		int id=sc.nextInt();
		FacultySkillDTO faculty=new FacultySkillDTO();
		faculty.setFaculty_id(id);
		
		try {
			services.deleteSkill(faculty);
			logger.info("Skills Cannot be deleted");
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw new FeedbackManagement("Enter the correct choices");
		}
	}
	private static void addSkill() throws FeedbackManagement {
		// TODO Auto-generated method stub
		System.out.println("Enter the Faculty ID to which it has to be added");
		int id=sc.nextInt();
		System.out.println("Enter the skill to be added to the set");
		String skill=sc.next();
		FacultySkillDTO faculty=new FacultySkillDTO();
		faculty.setFaculty_id(id);
		faculty.setSkillset(skill);
		try {
			services.addSkill(faculty);
			logger.info("Cannot Add Skills");
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw new FeedbackManagement("enter the correct details");
		}
	}
	private static void showSkill() throws FeedbackManagement {
		// TODO Auto-generated method stub
		FacultySkillDTO faculty=new FacultySkillDTO();
		System.out.println();
		try {
			List<FacultySkillDTO> facultylist=services.facultyskill();
			
				for(FacultySkillDTO c:facultylist)
				{
					System.out.println("Faculty Id:"+c.getFaculty_id()+"  Faculty Skills;"+c.getSkillset()
							);
				logger.info("No Skills");
				}
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw new FeedbackManagement("something went wrong");
		}
	}
}

