package com.capgemini.tcc.bean;

import java.util.Date;

public class PatientBean {

		/*Add Patient Information
	      1.patient_id
	      2.patient_name
	      3.Age
	      4.phonenum
	      5.Description
	 */
	/* Getter and setters for Patient Information*/
	    private String patient_id;
		public String getPatient_id() {
			return patient_id;
		}
		public void setPatient_id(String patient_id) {
			this.patient_id = patient_id;
		}
		public String getPatient_name() {
			return patient_name;
		}
		public void setPatient_name(String patient_name) {
			this.patient_name = patient_name;
		}
		public String getAge() {
			return age;
		}
		public void setAge(String age) {
			this.age = age;
		}
		public String getPhone() {
			return phone;
		}
		public void setPhone(String phone) {
			this.phone = phone;
		}
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		public Date getConsultation_Date() {
			return consultation_Date;
		}
		public void setConsultation_Date(Date consultation_Date) {
			this.consultation_Date = consultation_Date;
		}
		private String patient_name;
		private String age;
		private String phone;
		private String description;
		private Date consultation_Date;
		public String toString()
		{
			StringBuilder sb = new StringBuilder();
			sb.append("INFORMATION OF PATIENT \n");
			sb.append("Patient Name: " +patient_name +"\n");
			sb.append("Patient age: "+ age +"\n");
			sb.append("Patient Phone Number: "+ phone+"\n");
			sb.append("Patient description: "+ description +"\n");
			sb.append("Patient consulted Date: " +java.time.LocalDate.now());
			return sb.toString();
		}
}
