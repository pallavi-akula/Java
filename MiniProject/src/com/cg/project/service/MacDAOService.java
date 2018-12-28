package com.cg.project.service;

import com.cg.project.dto.Applicant;
import com.cg.project.exception.UASException;

public interface MacDAOService {

	public void applicationstatus(int applicationid) throws UASException;
	public void updateapplicationstatus(int applicantionid ,String status) throws UASException;
	public boolean retrieveapplications(String scheduledprogramid) throws UASException;
	public boolean createapplicant(Applicant appl) throws UASException;
	
}
