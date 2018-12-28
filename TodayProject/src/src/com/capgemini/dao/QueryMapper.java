package com.capgemini.dao;

public interface QueryMapper {

	//public static final String RETRIVE_ALL_QUERY="SELECT donor_name,address,phone_number,donor_date,donor_amount FROM donor_details";
	//public static final String VIEW_DONAR_DETAILS_QUERY="SELECT donor_name,address,phone_number,donor_date,donor_amount FROM donor_details WHERE  donor_id=?";
	public static final String INSERT_QUERY="INSERT INTO Patient VALUES(patient_Id_sequence.NEXTVAL,?,?,?,?, (select SYSDATE from DUAL))";
	public static final String PATIENTID_QUERY_SEQUENCE="SELECT patient_Id_sequence.CURRVAL FROM DUAL";
	
	
}