package com.capg_3;

import java.util.Arrays;
import java.util.Scanner;

public class Lab3_8 {
	public static String sortString(String s1) {
		char tempArray[] = s1.toCharArray();
		Arrays.sort(tempArray);
		return new String(tempArray);
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s1 = sc.nextLine();
		String s2 = sortString(s1);
		int len = s1.length();
		int n = (len/2);
		System.out.println(s2);
		if(len%2==0) {
			
		
		for(int i = 0; i < len; i++) {
			char ch = s2.charAt(i);
			if(i<(n)) {
				System.out.println(Character.toUpperCase(ch));
			}
			else {
				System.out.println(Character.toLowerCase(ch));
			}
		}
	}
		else {
			for(int i = 0; i < len; i++) {
				char ch = s2.charAt(i);
				if(i<(n+1)) {
					System.out.println(Character.toUpperCase(ch));
				}
				else {
					System.out.println(Character.toLowerCase(ch));
		}

}
		}
	}
}

