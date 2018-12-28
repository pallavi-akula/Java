package com.capgemini.tcc.dao;

import com.capgemini.tcc.bean.PatientBean;
import com.capgemini.tcc.exception.PatientException;

public interface IPatientDAO {
	public int addPatientDetails(PatientBean patientbean) throws PatientException;
	//public static PatientBean getPatientDetails( int patient_id) throws PatientException {
		// TODO Auto-generated method stub
	
	}
//}
