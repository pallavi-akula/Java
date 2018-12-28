package com.capgemini.tcc.dao;

public class QueryMapper {
	public static final String INSERT_QUERY="INSERT INTO Customer VALUES(Patient_Id_Seq.NEXTVAL,?,?,?,?,SYSDATE)";
	public static final String PATIENTID_QUERY_SEQUENCE="SELECT Patient_Id_Seq.CURRVAL FROM DUAL";
	

}
