package com.capgemini.dao;
import com.capgemini.bean.Patientbean;

import com.capgemini.exception.PatientsException;
public interface IPatientDAO {
	public String addPatientDetails(Patientbean patientbean) throws PatientsException;
}





