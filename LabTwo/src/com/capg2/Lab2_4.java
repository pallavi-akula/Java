package com.capg2;

import java.util.Scanner;


public class Lab2_4 {
	private String firstname;
	 
	public void setFirstname(String s1) {
	    this.firstname = s1;
	}
	 
	public String getFirstname() {
	    return this.firstname;
	}
	private String lastname;
	 
	public void setLastname(String s2) {
	    this.lastname = s2;
	}
	 
	public String getLastname() {
	    return this.lastname;
	}
	private char gender;
	public void setGender(char gend) {
		this.gender = gend;
	}
	public char getGender() {
		return this.gender;
	}

	public Lab2_4(String firstname, String lastname, char gender) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.gender = gender;
	}
	public static void main(String args[]) {
		String s1 = "Shobha";
		String  s2 = "Indra";
		char g = 'F';
		Lab2_4 pl = new Lab2_4(s1,s2,g);
		System.out.println("enter phone number");
		
		Scanner sc = new Scanner(System.in);
		String i = sc.next();
		System.out.println("Person Details:");
		System.out.println("______________________________\n");
		System.out.println("firstname:"+pl.getFirstname());
		System.out.println("lastname:"+pl.getLastname());
		System.out.println("gender:"+pl.getGender());
		System.out.println("phone number:"+i);
		
}

	
}
