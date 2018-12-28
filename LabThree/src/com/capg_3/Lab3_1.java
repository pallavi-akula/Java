package com.capg_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Lab3_1 {
	public static void main(String args[]) {
		System.out.println("Enter choice 1 to add the string to itself\n ");
		System.out.println("Enter choice 2 to change odd characters to uppercase\n");
		System.out.println("Enter choice 3 to remove duplicate characters in a string\n");
		System.out.println("Enter choice 4 to replace odd positions with #\n");
		System.out.println("Enter the input string");
		try {
			BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
			String s1= sc.readLine();
			System.out.println("Enter the choice");
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
	
		String	choice = br.readLine();
		
		Integer x = new Integer(choice);
		switch(x) {
		case(1):{
			
		System.out.println("adding to the string itself");
		System.out.println(s1+" "+s1);
		break;
		}
		case(2):{
		for(int i = 0; i < s1.length(); i++) {
			char ch = s1.charAt(i);
			if(i%2==1) {
				System.out.println(Character.toUpperCase(ch));
			}else {
				System.out.println(ch);
			}
		}
		break;
		}
		case(3):{
		System.out.println();
		StringBuffer s = new StringBuffer(s1);
		for(int j = 0; j < s.length()-1; j++) {
			for(int k = j+1; k < s.length(); k++) {
				if(s.charAt(j)==s.charAt(k)) {
					s.deleteCharAt(k);
				}
			}
		}
		System.out.println(s);
		break;
		}
		case(4):{
		System.out.println();
		for(int i = 0; i < s1.length(); i++) {
			char ch = s1.charAt(i);
			if(i%2==1) {
				s1=s1.replace(s1.charAt(i), '#');
			}else {
				continue;
			}
		
	}
		System.out.println(s1);
		break;
		}
		default:
		{
			System.out.println("enter proper choice");
			break;
		}
}
}
		catch(IOException e)
		{
			e.printStackTrace();
		}
}
}