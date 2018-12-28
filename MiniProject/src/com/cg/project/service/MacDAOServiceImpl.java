package com.cg.project.service;

import com.cg.project.dao.MacDAO;
import com.cg.project.dao.MacDAOImpl;
import com.cg.project.dto.Applicant;
import com.cg.project.exception.UASException;

public class MacDAOServiceImpl implements MacDAOService{

	MacDAO daoref = new MacDAOImpl();
	@Override
	public void applicationstatus(int applicationid) throws UASException {

		daoref.applicationstatus(applicationid);
	}

	@Override
	public void updateapplicationstatus(int applicantionid, String status) throws UASException {
		
		daoref.updateapplicationstatus(applicantionid, status);
	}

	@Override
	public boolean retrieveapplications(String scheduledprogramid) throws UASException {
		
		return daoref.retrieveapplications(scheduledprogramid);
	}

	@Override
	public boolean createapplicant(Applicant appl) throws UASException {
		
	  return	daoref.createapplicant(appl);
	
	}

}
