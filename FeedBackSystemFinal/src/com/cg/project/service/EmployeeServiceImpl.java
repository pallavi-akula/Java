package com.cg.project.service;

import java.sql.SQLException;
import java.util.List;

import com.cg.project.dao.EmployeeDAOImpl;
import com.cg.project.dao.Employee_dao;
import com.cg.project.dto.CourseDto;
import com.cg.project.dto.EmployeeDTO;
import com.cg.project.dto.FacultySkillDTO;
import com.cg.project.dto.FeedbackDTO;
import com.cg.project.dto.TrainingDTO;
import com.cg.project.dto.TrainingPartIDTO;
import com.cg.project.exception.FeedbackManagement;
/**
 * @author kshitiz
 *
 */
public class EmployeeServiceImpl implements IEmployeeService {

	Employee_dao dao;
	{
		dao=new EmployeeDAOImpl();
	}
	@Override
	public String SearchForRole(EmployeeDTO emp) throws FeedbackManagement {
		// TODO Auto-generated method stub
		return dao.SearchForRole(emp);
	}

	@Override
	public EmployeeDTO addUser(EmployeeDTO emp) throws FeedbackManagement {
		// TODO Auto-generated method stub
		return dao.addUser(emp);
	}

	@Override
	public String showSkill(FacultySkillDTO faculty) throws FeedbackManagement {
		// TODO Auto-generated method stub
		return dao.showSkill(faculty);
	}

	@Override
	public FacultySkillDTO addSkill(FacultySkillDTO faculty) throws FeedbackManagement {
		// TODO Auto-generated method stub
		return dao.addSkill(faculty);
	}

	@Override
	public List<FacultySkillDTO> facultyskill() throws FeedbackManagement {
		// TODO Auto-generated method stub
		return dao.facultyskill();
	}

	@Override
	public CourseDto AddCourse(CourseDto course) throws FeedbackManagement {
		// TODO Auto-generated method stub
		return dao.AddCourse(course);
	}

	@Override
	public CourseDto DeleteCourse(CourseDto course) throws FeedbackManagement {
		// TODO Auto-generated method stub
		return dao.DeleteCourse(course);
	}

	@Override
	public CourseDto SearchCourse(CourseDto course) throws FeedbackManagement {
		// TODO Auto-generated method stub
		return dao.SearchCourse(course);
	}

	@Override
	public List<FeedbackDTO> feedbacks() throws FeedbackManagement {
		// TODO Auto-generated method stub
		return dao.feedbacks();
	}

	@Override
	public FeedbackDTO addFeedback(int id,FeedbackDTO feedback) throws FeedbackManagement {
		// TODO Auto-generated method stub
		return dao.addFeedback(id,feedback);
	}

	@Override
	public TrainingDTO addTraining(TrainingDTO training) throws FeedbackManagement {
		// TODO Auto-generated method stub
		return dao.addTraining(training);
	}

	@Override
	public TrainingPartIDTO addParticipant(TrainingPartIDTO trainingparti) throws FeedbackManagement {
		// TODO Auto-generated method stub
		return dao.addParticipant(trainingparti);
	}

	@Override
	public FacultySkillDTO deleteSkill(FacultySkillDTO faculty) throws FeedbackManagement {
		// TODO Auto-generated method stub
		return dao.deleteSkill(faculty);
	}

	@Override
	public List<CourseDto> listCourse() throws FeedbackManagement {
		// TODO Auto-generated method stub
		return dao.listCourse();
	}

}
