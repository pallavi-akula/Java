package com.capgemini.tcc.exception;

//Which will accept the Exception Class

public class PatientException extends Exception {
private static final long serialVersionUID = 726264577455921591L;
	public PatientException(String message) 
	{
		
		super(message);
	}

}
