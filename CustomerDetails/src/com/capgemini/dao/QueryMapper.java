package com.capgemini.dao;

public class QueryMapper {

	public static final String INSERT_QUERY="INSERT INTO customer_details VALUES(customerId_sequence.NEXTVAL,?,?,?,SYSDATE,?)";
	public static final String CUSTOMERID_QUERY_SEQUENCE="SELECT customerId_sequence.CURRVAL FROM DUAL";
	
		
	}


