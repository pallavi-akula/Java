package com.capgemini.service;

import com.capgemini.dao.PatientDaoImpl;

import com.capgemini.dao.IPatientDAO;

import com.capgemini.exception.PatientsException;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.capgemini.bean.Patientbean;

public  class PatientServiceImpl implements IPatientService {
	
	IPatientDAO patientDao;
	
	public String addPatientDetails(Patientbean patientbean) throws PatientsException {
		
		patientDao= new PatientDaoImpl();
		String patient_Id_sequence;
		patient_Id_sequence= patientDao.addPatientDetails(patientbean);
		return patient_Id_sequence;
	}
	
	
		public void validatePatient(Patientbean bean) throws Exception
		{
			List<String> validationErrors = new ArrayList<String>();

			//Validating name
			if(!(isValidName(bean.getName()))) {
				validationErrors.add("\n Patient Name Should Be In Alphabets and minimum 3 characters long ! \n");
			}
			/*//Validating age
			if(!(isValidAge(bean.getAge()))){
				validationErrors.add("\n Age Should Be Entered \n");
			}*/
			//Validating Phone Number
			if(!(isValidPhoneNumber(bean.getPhoneNumber()))){
				validationErrors.add("\n Phone Number Should be in 10 digit \n");
			}
			
		
			if(!validationErrors.isEmpty())
				throw new PatientsException(validationErrors +"");
		}

		public boolean isValidName(String name){
			Pattern namePattern=Pattern.compile("^[A-Za-z]{3,}$");
			Matcher nameMatcher=namePattern.matcher(name);
			return nameMatcher.matches();
		}
		/*public boolean isValidAge(String age){
			return (age.length()>3);
		}*/
		
		public boolean isValidPhoneNumber(String phoneNumber){
			Pattern phonePattern=Pattern.compile("^[1-9]{1}[0-9]{9}$");
			Matcher phoneMatcher=phonePattern.matcher(phoneNumber);
			return phoneMatcher.matches();
			
		}
		
		public boolean validatePatientId(String patient_id) {
			
			Pattern idPattern = Pattern.compile("[0-9]{1,4}");
			Matcher idMatcher = idPattern.matcher(patient_id);
			
			if(idMatcher.matches())
				return true;
			else
				return false;		
		}
}


		
