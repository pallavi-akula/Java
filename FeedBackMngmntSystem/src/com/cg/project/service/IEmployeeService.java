package com.cg.project.service;

import java.sql.SQLException;
import java.util.List;

import com.cg.project.dto.CourseDto;
import com.cg.project.dto.EmployeeDTO;
import com.cg.project.dto.FacultySkillDTO;

public interface IEmployeeService {
	public String SearchForRole(EmployeeDTO emp) throws SQLException;
	//CourseFacultyMapping(String role);
	public EmployeeDTO addUser(EmployeeDTO emp) throws SQLException;
	public String showSkill(FacultySkillDTO faculty) throws SQLException;
	public List<FacultySkillDTO> facultyskill() throws Exception;
	public FacultySkillDTO addSkill(FacultySkillDTO faculty) throws SQLException;
	public CourseDto AddCourse(CourseDto course) throws SQLException;
	public CourseDto DeleteCourse(CourseDto course) throws SQLException;
	public CourseDto SearchCourse(CourseDto course) throws SQLException;
}
