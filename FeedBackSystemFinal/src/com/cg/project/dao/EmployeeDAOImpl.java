package com.cg.project.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import com.cg.project.dto.CourseDto;
import com.cg.project.dto.EmployeeDTO;
import com.cg.project.dto.FacultySkillDTO;
import com.cg.project.dto.FeedbackDTO;
import com.cg.project.dto.TrainingDTO;
import com.cg.project.dto.TrainingPartIDTO;
import com.cg.project.exception.FeedbackManagement;
import com.cg.project.utils.DBUtils;
/**
 * @author kshitiz
 *
 */
public class EmployeeDAOImpl implements Employee_dao {
	private static Logger logger= Logger.getLogger(EmployeeDAOImpl.class);
private Connection dbConnection;
EmployeeDTO emp;



{
	try {
		dbConnection = DBUtils.getConnection();
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	} catch (SQLException e) {
		e.printStackTrace();
	}
}
private int generatetrainingcode() throws FeedbackManagement{
	int code=0;
try {
	Statement s= dbConnection.createStatement();
	ResultSet rs= 
s.executeQuery("select training_seq.nextval from dual");
if(rs.next())
	code=rs.getInt(1);
} catch (SQLException e) {
	throw new FeedbackManagement(e.getMessage());
}
return code;
}

private int generatecoursecode() throws FeedbackManagement{
	int code=0;
try {
	Statement s= dbConnection.createStatement();
	ResultSet rs= 
s.executeQuery("select course_seq.nextval from dual");
if(rs.next())
	code=rs.getInt(1);
} catch (SQLException e) {
	throw new FeedbackManagement(e.getMessage());
}
return code;
}
@Override
public String SearchForRole(EmployeeDTO emp) throws FeedbackManagement {
String role=null;
	try {
		String selectQuery = "select role from employee_master where employee_id=? and password=?";
		PreparedStatement selectStatement = dbConnection.prepareStatement(selectQuery);
		selectStatement.setInt(1, emp.getEmployee_id());
		selectStatement.setString(2, emp.getPassword());
		
		
		ResultSet rs = selectStatement.executeQuery();
		while (rs.next()) {
		    role=rs.getString(1);
		logger.info("Cannot search Role");
		}
		return role;
	} catch (Exception e) {
		logger.info(e.getMessage());
		throw new FeedbackManagement(e.getMessage());
	}
}


@Override
public EmployeeDTO addUser(EmployeeDTO emp) throws FeedbackManagement {
	// TODO Auto-generated method stub
	String insertQuery="insert into employee_master"+"(employee_id,employee_name,password,role)"+"values(?,?,?,?)";
	
	try {
		PreparedStatement ps=dbConnection.prepareStatement(insertQuery);
		ps.setInt(1, emp.getEmployee_id());
		ps.setString(2, emp.getEmployee_name());
		ps.setString(3, emp.getPassword());
		ps.setString(4, emp.getRole());
		int row =ps.executeUpdate();
		System.out.println("Congratulations!!!.....You have successfully registered");
		logger.info("Cannot add User");
		return emp;
	} catch (Exception e) {
		logger.info(e.getMessage());
		throw new FeedbackManagement(e.getMessage());
	}
}


@Override
public String showSkill(FacultySkillDTO faculty) throws FeedbackManagement {
	// TODO Auto-generated method stub
	String skill="";
	int count=0;
	try {
		String selectQuery="Select skill_set from faculty_skill where faculty_id=?";
		PreparedStatement p=dbConnection.prepareStatement(selectQuery);
		p.setInt(1, faculty.getFaculty_id());
		ResultSet rs=p.executeQuery();
		while(rs.next()){
			logger.info("No skills to show");
			count++;
			skill=skill.concat(rs.getString(1)).concat(",");
		}
		if(count==0)
		{
			System.out.println("asd");
		}
		return skill;
	} catch (Exception e) {
		logger.info(e.getMessage());
		throw new FeedbackManagement(e.getMessage());
	}
}


@Override
public FacultySkillDTO addSkill(FacultySkillDTO faculty) throws FeedbackManagement {
	// TODO Auto-generated method stub
	String insertQuery="Insert into faculty_skill"+"(faculty_id,skill_set)"+"values(?,?)";
	try {
		PreparedStatement ps=dbConnection.prepareStatement(insertQuery);
		ps.setInt(1, faculty.getFaculty_id());
		ps.setString(2, faculty.getSkillset());
		int row=ps.executeUpdate();
		System.out.println("Skill added to faculty id:"+faculty.getFaculty_id());
		logger.info("Skills cannot be Added");
		return faculty;
	} catch (Exception e) {
		logger.error(e.getMessage());
		throw new FeedbackManagement(e.getMessage());
	}
}


@Override
public FacultySkillDTO deleteSkill(FacultySkillDTO faculty) throws FeedbackManagement {
	// TODO Auto-generated method stub
	String selectQuery="Select * from faculty_skill where faculty_id=?";
	try {
		PreparedStatement ps=dbConnection.prepareStatement(selectQuery);
		ps.setInt(1, faculty.getFaculty_id());
		ResultSet rs=ps.executeQuery();
		while(rs.next()) {
			System.out.println(rs.getString(1)+",");
			logger.info("Skills Cannot be Deleted");
		}
		return faculty;
	}
	catch(Exception e)
	{
		logger.error(e.getMessage());
		throw new FeedbackManagement(e.getMessage());
	}
}


@Override
public List<FacultySkillDTO> facultyskill() throws FeedbackManagement {
	// TODO Auto-generated method stub
	List<FacultySkillDTO> facultyskill=new ArrayList<>();
	String sql="Select  * from faculty_skill ";
	try {
		PreparedStatement ps=dbConnection.prepareStatement(sql);
		
		ResultSet rs = ps.executeQuery();
		while(rs.next()){
			int fid= rs.getInt("Faculty_Id");
			String  skillset= rs.getString("Skill_Set");
			FacultySkillDTO f=new FacultySkillDTO();
			f.setFaculty_id(fid);
			f.setSkillset(skillset);
			
			facultyskill.add(f);
			
			logger.info("No skills");
		}
		return facultyskill;
	} catch (Exception e) {
		logger.info(e.getMessage());
		throw new FeedbackManagement(e.getMessage());
	}
}


@Override
public CourseDto AddCourse(CourseDto course) throws FeedbackManagement {
	// TODO Auto-generated method stub
	String selectQuery = "insert into course_master" + " (course_id,course_name,no_of_days)" + "values (?,?,?)";
	try {

		PreparedStatement selectStatement = dbConnection.prepareStatement(selectQuery);
		selectStatement.setInt(1, generatecoursecode());
		selectStatement.setString(2, course.getCourse_name());
		selectStatement.setInt(3, course.getNo_of_days());
		selectStatement.executeUpdate();
		System.out.println("Your Course Have Successfully added........");
		return course;
	} catch (Exception e) {
		e.printStackTrace();
		throw new FeedbackManagement(e.getMessage());
	}
}


@Override
public CourseDto DeleteCourse(CourseDto course) throws FeedbackManagement {
	// TODO Auto-generated method stub
	String selectQuery = "delete from course_master" +" where course_id=?";
	try{
		PreparedStatement selectStatement = dbConnection.prepareStatement(selectQuery);
		selectStatement.setInt(1, course.getCourse_id());
		selectStatement.executeQuery();
		System.out.println("Your Course Have successfully Deleted........");
		return course;
	}
	catch(SQLException e){
		e.printStackTrace();
		throw new FeedbackManagement(e.getMessage());
	}
}


@Override
public CourseDto SearchCourse(CourseDto course) throws FeedbackManagement {
	// TODO Auto-generated method stub
	String selectQuery = "select * from course_master" +" where course_id=?";
	try{
		PreparedStatement selectStatement = dbConnection.prepareStatement(selectQuery);
		selectStatement.setInt(1, course.getCourse_id());
		ResultSet rs= selectStatement.executeQuery();
		while(rs.next()){
			course.setCourse_id(rs.getInt(1));
			course.setCourse_name(rs.getString(2));
			course.setNo_of_days(rs.getInt(3));
			logger.info("Course cannot be shown");
		}
		return course;
	}
	catch(SQLException e){
		logger.error(e.getMessage());
		throw new FeedbackManagement(e.getMessage());
	}
}


@Override
public FeedbackDTO addFeedback(int id,FeedbackDTO feedback) throws FeedbackManagement {
	// TODO Auto-generated method stub
	String sql="insert into feedback_master"+" values(?,?,?,?,?,?,?,?,?,sysdate)";
	try {
		PreparedStatement ps=dbConnection.prepareStatement(sql);
		
		ps.setInt(1, feedback.getTraining_code());
		ps.setInt(2, id);
		ps.setInt(3, feedback.getFb_prs_comm());
		ps.setInt(4, feedback.getFb_prs_dbts());
		ps.setInt(5, feedback.getFb_tm());
		ps.setInt(6, feedback.getFb_hnd_out());
		ps.setInt(7, feedback.getFb_hw_sw_ntwrk());
		ps.setString(8, feedback.getComments());
		ps.setString(9, feedback.getSuggestion());
		ps.executeUpdate();
			System.out.println("feedback entered");
			logger.info("Feedback not entered");
			return feedback;
	} catch (Exception e) {
		logger.info(e.getMessage());
		throw new FeedbackManagement(e.getMessage());
	}
	
}


@Override
public List<FeedbackDTO> feedbacks() throws FeedbackManagement {
	// TODO Auto-generated method stub
	String sql="Select * from feedback_master";
	
	try {
		PreparedStatement ps=dbConnection.prepareStatement(sql);
		ResultSet rs=ps.executeQuery();
		while(rs.next()){
			int tcode=rs.getInt("training_code");
			int pid=rs.getInt("participant_id");
			int fbprsc=rs.getInt("fb_prs_comm");
			int fbprsd=rs.getInt("fb_prs_dbts");
			int fbtm=rs.getInt("fb_tm");
			int fbhn=rs.getInt("fb_hnd_out");
			int fbhw=rs.getInt("fb_hw_sw_ntwrk");
			String comm=rs.getString("comments");
			String sugg=rs.getString("suggestion");
			java.sql.Date fdate=rs.getDate("feedback_date");
			FeedbackDTO feedback=new FeedbackDTO();
			feedback.setFeedback_date(fdate);
			feedback.setTraining_code(tcode);
			feedback.setParticipant_id(pid);
			feedback.setFb_prs_comm(fbprsc);
			feedback.setFb_prs_dbts(fbprsd);
			feedback.setFb_tm(fbtm);
			feedback.setFb_hnd_out(fbhn);
			feedback.setFb_hw_sw_ntwrk(fbhw);
			feedback.setComments(comm);
			feedback.setSuggestion(sugg);
			feedbacks().add(feedback);
			logger.info("No Feedback");
		}
		return feedbacks();
	} catch (Exception e) {
		logger.info(e.getMessage());
		throw new FeedbackManagement(e.getMessage());
	}
	
}


@Override
public TrainingDTO addTraining(TrainingDTO training) throws FeedbackManagement {
	// TODO Auto-generated method stub
	String insertquery="Insert into Training_Program"+" values(?,?,?,?,?)";
	
	try {
		PreparedStatement ps=dbConnection.prepareStatement(insertquery);
		ps.setInt(1, generatetrainingcode());
		ps.setInt(2, training.getCourse_code());
		ps.setInt(3, training.getFaculty_code());
		java.sql.Date sdate=java.sql.Date.valueOf(training.getStart_date());
		java.sql.Date edate=java.sql.Date.valueOf(training.getEnd_date());
		ps.setDate(4, sdate);
		ps.setDate(5, edate);
		ps.executeUpdate();
		System.out.println("Training Course Added");
		logger.info("Training course cannot be added");
		return training;
	} catch (Exception e) {
		logger.info(e.getMessage());
		throw new FeedbackManagement(e.getMessage());
	}
	
}


@Override
public TrainingPartIDTO addParticipant(TrainingPartIDTO trainingparti) throws FeedbackManagement {
	// TODO Auto-generated method stub
	String insertQuery="insert into training_participant_enroll "+"values(?,?)";
	
	try {
		PreparedStatement ps=dbConnection.prepareStatement(insertQuery);
		ps.setInt(1, trainingparti.getTraining_code());
		ps.setInt(2, trainingparti.getParticipant_id());
		ps.executeUpdate();
		System.out.println(trainingparti.getParticipant_id()+" Participant added to "+trainingparti.getTraining_code());
		logger.info("Cannot add Participant");
		return trainingparti;
	} catch (Exception e) {
		logger.info(e.getMessage());
		throw new FeedbackManagement(e.getMessage());
	}
}


@Override
public List<CourseDto> listCourse() throws FeedbackManagement {
	// TODO Auto-generated method stub
	List<CourseDto> courselist=new ArrayList<>();
	String sql="Select  * from Course_master ";
	try {
		PreparedStatement ps=dbConnection.prepareStatement(sql);
		
		ResultSet rs = ps.executeQuery();
		while(rs.next()){
			int cid=rs.getInt(1);
			String cname=rs.getString(2);
			int days=rs.getInt(3);
			CourseDto course=new CourseDto();
			course.setCourse_id(cid);
			course.setCourse_name(cname);
			course.setNo_of_days(days);
			courselist.add(course);
			
			logger.info("No Course");
		}
		return courselist;
	} catch (Exception e) {
		logger.error(e.getMessage());
		throw new FeedbackManagement(e.getMessage());
	}
}

}
