package com.capgemini.patient.dao;

public interface QueryMapper {
	public static final String INSERT_QUERY="INSERT INTO Patient VALUES(patient_Id_sequence.NEXTVAL,?,?,?,?, (select SYSDATE from DUAL))";
	public static final String PATIENTID_QUERY_SEQUENCE="SELECT patient_Id_sequence.CURRVAL FROM DUAL";
	

}
