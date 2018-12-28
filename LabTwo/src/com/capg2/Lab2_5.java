package com.capg2;

import java.util.Scanner;

enum gender{
	M,F,m,f
}
public class Lab2_5 {
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
	

	public Lab2_5(String firstname, String lastname) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		
	}
	public static void main(String args[]) {
		String s1 = "Akhila";
		String  s2 = "Shruthi";
		
		Lab2_5 pl = new Lab2_5(s1,s2);
		System.out.println("enter Phone number");
		Scanner sc = new Scanner(System.in);
		String i = sc.next();
		
        System.out.println("enter Gender");
		Scanner g = new Scanner(System.in);
		System.out.println("gender:"+gender.valueOf(g.nextLine()));
		
		System.out.println("Person Details:");
		System.out.println("______________________________\n");
		System.out.println("Firstname:"+pl.getFirstname());
		System.out.println("Lastname:"+pl.getLastname());
		//System.out.println("Gender:"+g);
		System.out.println("Phone number:"+i);
		
}

	
}
