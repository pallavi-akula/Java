package com.capg_3;

import java.util.Scanner;

public class Lab3_7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Enter New Username");
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		System.out.println(validate(s));
	}
	private static boolean validate(String str) {
		int len = str.length();
       //boolean k = true;
       if( str.endsWith("_job") && (len-4)>=8) {
    	  // System.out.println(s);
    	   System.out.println("Username have met requirements");
    	  return true;
       }else {
    	   System.out.println("Username should meet requirements");
    	  return false;
       }
	}

}
