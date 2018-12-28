package com.capg_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Lab3_5 {
	public static void main(String[] args) {
		System.out.println("Enter the year of purchase:");

		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));

		String year = null;
		try {
			year = br.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Integer i=new Integer(year);

		 

		System.out.println("Enter the month of purchase:");

		BufferedReader br1 =new BufferedReader(new InputStreamReader(System.in));

		String month = null;
		try {
			month = br1.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Integer i1=new Integer(month);

		 

		System.out.println("Enter the warranty(years)");

		BufferedReader br2 =new BufferedReader(new InputStreamReader(System.in));

		String year1 = null;
		try {
			year1 = br2.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Integer i2=new Integer(year1);

		 

		System.out.println("Enter the warranty(months)");

		BufferedReader br3 =new BufferedReader(new InputStreamReader(System.in));

		String month1 = null;
		try {
			month1 = br3.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Integer i3=new Integer(month1);

		 

		 

		int outyear;

		int j = (i1+i3);

		int k = (j%12)+1;

		if(j>=12)

		{

		outyear = i+i2+1;

		System.out.println("The warranty expirnes on(month/year)"+k+"/"+outyear);

		}

		else

		{

		outyear = i+i2;

		System.out.println("The warranty expirnes on(month/year)"+k+"/"+outyear);

		}

		 

		}

		}
	


