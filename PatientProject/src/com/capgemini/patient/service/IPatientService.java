package com.capgemini.patient.service;

import com.capgemini.patient.exception.PatientException;
import com.capgemini.tcc.bean.Patient;

public interface IPatientService {
	public interface ICustomerService {
		public String addCustomerDetails(Patient patientbean) throws PatientException;

}
}
