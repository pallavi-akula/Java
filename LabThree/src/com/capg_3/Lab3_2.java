package com.capg_3;

import java.util.Scanner;

public class Lab3_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		int len = str.length();
		int j = 0;
		for(int i = 0; i < len-1; i++) {
			if(str.charAt(i)-str.charAt(i+1)>0) {
				j=1;
				
			}
		}
		if(j==0) {
			System.out.println("Positive number");
		}else {
			System.out.println("Negative Number");
		}
		
		

	}

}
