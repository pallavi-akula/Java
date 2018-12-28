package com.capgemini.tcc.service;

import com.capgemini.tcc.bean.PatientBean;
import com.capgemini.tcc.dao.IPatientDAO;
import com.capgemini.tcc.dao.PatientDAO;
import com.capgemini.tcc.exception.PatientException;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public  class PatientService implements IPatientService {
    
    IPatientDAO patientDao;
    
    public int addPatientDetails(PatientBean patientbean) throws PatientException {
        
    	patientDao= new PatientDAO();
        int Patient_Id_Seq;
        Patient_Id_Seq= patientDao.addPatientDetails(patientbean);
        return Patient_Id_Seq;
    }
 /*
    
    public PatientBean getPatientDetails( int patient_id) throws PatientException{
	
		return IPatientDAO.getPatientDetails( patient_id );
	}
    */
    
    
        public void validateCustomer(PatientBean patientbean) throws Exception
        {
            List<String> validationErrors = new ArrayList<String>();

            //Validating name
            if(!(isValidName(patientbean.getPatient_name()))) {
                validationErrors.add("\n Patient Name Should Be In Alphabets and minimum 3 characters long ! \n");
            }
            //Validating age
            if(!(isValidAge(patientbean.getAge()))){
                validationErrors.add("\n Age Should Be greater than zero and should be less than 100 \n");
            }
            //Validating Phone Number
            if(!(isValidPhoneNumber(patientbean.getPhone()))){
                validationErrors.add("\n Phone Number Should be in 10 digit \n");
            }
            
  
            if(!validationErrors.isEmpty())
                throw new PatientException(validationErrors +"");
        }

        public boolean isValidName(String patient_name){
            Pattern namePattern=Pattern.compile("^[A-Za-z]{3,}$");
            Matcher nameMatcher=namePattern.matcher(patient_name);
            return nameMatcher.matches();
        }
        public boolean isValidAge(String age){
            
            Pattern agePattern=Pattern.compile("^([1-9][0-9])");
            Matcher ageMatcher=agePattern.matcher(age);
                return ageMatcher.matches();
        }
        
        public boolean isValidPhoneNumber(String phone){
            Pattern phonePattern=Pattern.compile("^[1-9]{1}[0-9]{9}$");
            Matcher phoneMatcher=phonePattern.matcher(phone);
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
