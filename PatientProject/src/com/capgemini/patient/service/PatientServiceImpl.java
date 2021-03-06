package com.capgemini.patient.service;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.capgemini.patient.dao.PatientDaoIml;
import com.capgemini.patient.dao.IPatientDao;
import com.capgemini.patient.exception.PatientException;
import com.capgemini.patient.service.IPatientService;
import com.capgemini.tcc.bean.Patient;

public class PatientServiceImpl {
	public  class CustomerServiceImpl implements IPatientService {
		
		IPatientDao patientDao;
		
		public String addPatientDetails(Patient patientbean) throws PatientException {
			
			patientDao= new PatientDaoIml();
			String customer_Id_sequence;
			customer_Id_sequence= patientDao.addPatientDetails( patientbean);
			return customer_Id_sequence;
		}
		
		
			public void validateCustomer( Patient bean) throws Exception
			{
				List<String> validationErrors = new ArrayList<String>();

				//Validating name
				if(!(isValidName(bean.getName()))) {
					validationErrors.add("\n Customer Name Should Be In Alphabets and minimum 3 characters long ! \n");
				}
				//Validating age
				if(!(isValidAge(bean.getAge()))){
					validationErrors.add("\n Age Should Be greater than zero and should be less than 100 \n");
				}
				//Validating Phone Number
				if(!(isValidPhoneNumber(bean.getPhoneNumber()))){
					validationErrors.add("\n Phone Number Should be in 10 digit \n");
				}
				
			
				if(!validationErrors.isEmpty())
					throw new PatientException(validationErrors +"");
			}

			public boolean isValidName(String name){
				Pattern namePattern=Pattern.compile("^[A-Za-z]{3,}$");
				Matcher nameMatcher=namePattern.matcher(name);
				return nameMatcher.matches();
			}
			public boolean isValidAge(String age){
				
				Pattern agePattern=Pattern.compile("^([1-9][0-9])");
				Matcher ageMatcher=agePattern.matcher(age);
					return ageMatcher.matches();
			}
			
			public boolean isValidPhoneNumber(String phoneNumber){
				Pattern phonePattern=Pattern.compile("^[1-9]{1}[0-9]{9}$");
				Matcher phoneMatcher=phonePattern.matcher(phoneNumber);
				return phoneMatcher.matches();
				
			}
			
			public boolean validateCustomerId(String customer_id) {
				
				Pattern idPattern = Pattern.compile("[0-9]{1,4}");
				Matcher idMatcher = idPattern.matcher(customer_id);
				
				if(idMatcher.matches())
					return true;
				else
					return false;		
			}
	}


			


}
