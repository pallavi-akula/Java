package com.cg.project.dto;

import java.util.Date;

public class ProgramsScheduled {

	private String scheduledprogramid;
	private String ProgramName;
	private String program_location;
	private String start_date;
	private String end_date;
	private int sessions_per_week;
	public String getScheduledprogramid() {
		return scheduledprogramid;
	}
	public void setScheduledprogramid(String scheduledprogramid) {
		this.scheduledprogramid = scheduledprogramid;
	}
	public String getProgramName() {
		return ProgramName;
	}
	public void setProgramName(String programName) {
		this.ProgramName = programName;
	}
	public String getProgram_location() {
		return program_location;
	}
	public void setProgram_location(String program_location) {
		this.program_location = program_location;
	}
	public String getStart_date() {
		return start_date;
	}
	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}
	public String getEnd_date() {
		return end_date;
	}
	public void setEnd_date(String end_date) {
		this.end_date = end_date;
	}
	public int getSessions_per_week() {
		return sessions_per_week;
	}
	public void setSessions_per_week(int sessions_per_week) {
		this.sessions_per_week = sessions_per_week;
	}
	
	
	
	
	
}
