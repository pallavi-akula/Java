package com.cg.project.dao;

import java.util.Date;

import com.cg.project.dto.ProgramsOffered;
import com.cg.project.dto.ProgramsScheduled;
import com.cg.project.exception.UASException;


public interface AdminDAO {
	
	public String loginverification(String login_id,String user_password)throws UASException;
	public void retrieveprograms() throws UASException;
	public boolean createprogram(ProgramsOffered progoff,ProgramsScheduled progsch) throws UASException;
	public boolean updateprogram(String progid, String startdate, String enddate, int sessions, String location) throws UASException;
	public boolean deleteprogram(String name) throws UASException;
	public void scheduledprogramsinfo(String start_date,String end_date) throws UASException; 
	public void finallist(String programname,String status) throws UASException;
	public int countapplicants(String progid) throws UASException;
	
	
	
	

}
