package com.cg.project.service;

import java.sql.SQLException;
import java.util.List;

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
public interface IEmployeeService {
	public String SearchForRole(EmployeeDTO emp) throws FeedbackManagement;
	//CourseFacultyMapping(String role);
	public EmployeeDTO addUser(EmployeeDTO emp) throws FeedbackManagement;
	public String showSkill(FacultySkillDTO faculty) throws FeedbackManagement;
	public List<FacultySkillDTO> facultyskill() throws FeedbackManagement;
	public FacultySkillDTO addSkill(FacultySkillDTO faculty) throws FeedbackManagement;
	public FacultySkillDTO deleteSkill(FacultySkillDTO faculty) throws FeedbackManagement;
	public List<CourseDto> listCourse() throws FeedbackManagement;
	public CourseDto AddCourse(CourseDto course) throws FeedbackManagement;
	public CourseDto DeleteCourse(CourseDto course) throws FeedbackManagement;
	public CourseDto SearchCourse(CourseDto course) throws FeedbackManagement;
//	public List<FeedbackDTO> feedbacks() throws SQLException;
	public TrainingDTO addTraining(TrainingDTO training) throws FeedbackManagement;
	public TrainingPartIDTO addParticipant(TrainingPartIDTO trainingparti) throws FeedbackManagement;	
	public FeedbackDTO addFeedback(int id,FeedbackDTO feedback) throws FeedbackManagement;
	public List<FeedbackDTO> feedbacks() throws FeedbackManagement;
}
