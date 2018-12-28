package com.capgemini.service;

import com.capgemini.bean.Patientbean;
import com.capgemini.exception.PatientsException;


public interface IPatientService {
	public String addPatientDetails(Patientbean patientbean) throws PatientsException;
}
