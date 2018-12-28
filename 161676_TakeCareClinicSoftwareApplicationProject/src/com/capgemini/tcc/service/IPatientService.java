package com.capgemini.tcc.service;

import com.capgemini.tcc.bean.PatientBean;
import com.capgemini.tcc.exception.PatientException;

/*
 * Interface Class
 * 1.AddPatientDetails
 * 2.View details of Patient Information*/
public interface IPatientService {
	public String addPatientDetails(PatientBean patientbean) throws PatientException;
	public PatientBean viewPatientDetails(String patient_id) throws PatientException;
}