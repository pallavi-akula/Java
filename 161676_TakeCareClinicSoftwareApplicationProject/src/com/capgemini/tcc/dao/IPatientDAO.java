package com.capgemini.tcc.dao;


import com.capgemini.tcc.bean.PatientBean;
import com.capgemini.tcc.exception.PatientException;
/*Interface IPatientDAO
 * 1.Add addPAtientDetails
 * 2.viewPatientDetails*/
public interface IPatientDAO {
	public String addPatientDetails(PatientBean patientbean) throws PatientException;
	public PatientBean viewPatientDetails(String patient_id) throws PatientException;
}
