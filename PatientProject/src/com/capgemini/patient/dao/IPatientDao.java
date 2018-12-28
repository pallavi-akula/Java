package com.capgemini.patient.dao;

import com.capgemini.patient.exception.PatientException;
import com.capgemini.tcc.bean.Patient;

public interface IPatientDao {
	public String addPatientDetails(Patient patient) throws PatientException;


}
