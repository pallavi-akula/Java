package com.cg.project.dto;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
/**
 * @author kshitiz
 *
 */
public class TrainingDTO {
	private int training_code;
	private int course_code;
	private int faculty_code;
//	private java.util.Date start_date;
	LocalDate start_date;
	LocalDate end_date;
//	private java.util.Date end_date;
	DateFormat formatter = new SimpleDateFormat("d/MM/yyyy");  
	public int getTraining_code() {
		return training_code;
	}
	public void setTraining_code(int training_code) {
		this.training_code = training_code;
	}
	public int getCourse_code() {
		return course_code;
	}
	public void setCourse_code(int course_code) {
		this.course_code = course_code;
	}
	public int getFaculty_code() {
		return faculty_code;
	}
	public void setFaculty_code(int faculty_code) {
		this.faculty_code = faculty_code;
	}
	public LocalDate getStart_date() {
		return start_date;
	}
	public void setStart_date(LocalDate sdate)  {
		this.start_date=sdate;
	}
	public LocalDate getEnd_date() {
		return end_date;
	}
	public void setEnd_date(LocalDate edate)  {
		this.end_date=edate;
	}
	
}
