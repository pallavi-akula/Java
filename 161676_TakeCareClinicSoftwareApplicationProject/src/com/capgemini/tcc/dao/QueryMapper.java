package com.capgemini.tcc.dao;

public interface QueryMapper {

	public static final String VIEW_PATIENT_DETAILS_QUERY="SELECT patient_name,age,phone,description,consultation_date FROM Patient WHERE  patient_id=?";
	public static final String INSERT_QUERY="INSERT INTO Patient VALUES(Patient_Id_Seq.NEXTVAL,?,?,?,?,SYSDATE)";
	public static final String PATIENTID_QUERY_SEQUENCE="SELECT Patient_Id_Seq.CURRVAL FROM DUAL";
	
	//CREATE TABLE Patient(patient_id NUMBER PRIMARY KEY, patient_name VARCHAR2(20),age NUMBER(3), phone VARCHAR2(10), description VARCHAR2(80),consultation_date DATE);  

	    //CREATE SEQUENCE Patient_Id_Seq
			//START WITH 1000;
}
