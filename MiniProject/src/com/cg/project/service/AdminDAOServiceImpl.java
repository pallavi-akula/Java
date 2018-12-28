package com.cg.project.service;



import com.cg.project.dao.AdminDAO;
import com.cg.project.dao.AdminDAOImpl;
import com.cg.project.dto.ProgramsOffered;
import com.cg.project.dto.ProgramsScheduled;
import com.cg.project.exception.UASException;

public class AdminDAOServiceImpl implements AdminDAOService{

	AdminDAO daoref = new AdminDAOImpl();
	@Override
	public String loginverification(String login_id,String user_password)throws UASException
	{
		return daoref.loginverification(login_id,user_password);
	}
	
	@Override
	public void retrieveprograms() throws UASException
	{
		daoref.retrieveprograms();
	}
	
	@Override
	public boolean createprogram(ProgramsOffered progoff,ProgramsScheduled progsch) throws UASException
	{
		boolean a= daoref.createprogram(progoff,progsch);
		 return a;
	}
	
	

	
	@Override
	public boolean deleteprogram(String name) throws UASException
	{    boolean  a;
		 a= daoref.deleteprogram(name);
		 return a;
	}
	
	@Override
	public void scheduledprogramsinfo(String start_date,String end_date) throws UASException
	{
		daoref.scheduledprogramsinfo(start_date, end_date);
	}
	
	@Override
	public void finallist(String programname,String status) throws UASException
	{
		daoref.finallist(programname, status);
	}
	
	@Override
	public int countapplicants(String progid) throws UASException
	{
		return daoref.countapplicants(progid);
	}

	@Override
	public boolean updateprogram(String progid, String startdate, String enddate, int sessions, String location) throws UASException
	{
		boolean a= daoref.updateprogram(progid, startdate, enddate, sessions, location);
		return a;
	}
	
	
}
