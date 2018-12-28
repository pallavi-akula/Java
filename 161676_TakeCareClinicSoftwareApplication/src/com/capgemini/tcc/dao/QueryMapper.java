package com.capgemini.tcc.dao;

public interface QueryMapper {

	
	public static final String INSERT_QUERY="INSERT INTO Patient VALUES(Patient_Id_Seq.NEXTVAL,?,?,?,?,SYSDATE)";
	public static final String PATIENTID_QUERY_SEQUENCE="SELECT Patient_Id_Seq.CURRVAL FROM DUAL";
	
	//Patient_Id_Seq
	//(patient_id NUMBER PRIMARY KEY,patient_name VARCHAR2(20),age number,phone VARCHAR2(10),description VARCHAR2(8),consultation_date DATE)
}
