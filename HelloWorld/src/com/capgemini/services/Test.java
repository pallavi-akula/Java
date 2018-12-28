package com.capgemini.services;

import java.util.Scanner;

import com.capgemini.beans.Employeee;

public class Test {

	public static void main(String[] args) {
	 Scanner sc = new Scanner(System.in);
	 int size;
     System.out.println("Enter size");
     size=sc.nextInt();
	 Employeee[] emps = new Employeee[size];
    
     /*emps[0] = new Employeee();
     emps[1] = new Employeee();
     emps[2] = new Employeee();
     
     emps[0].setEmployenumber(101);
     emps[0].setName("Sachin");
     */
     for(int i = 0;i < size;i++){
     emps[i] = new Employeee();
     }
     String a;
     for(int i =0 ,j;i<emps.length;i++){
    	 System.out.println("Enter name");
    	 emps[i].setName(a=sc.next());
    	 System.out.println("Enter number");
    	 emps[i].setEmployenumber(j=sc.nextInt());
     }
     for(int k = 0;k<emps.length;k++){
    	 System.out.println(emps[k].getName());
    	 System.out.println(emps[k].getEmployenumber());
     }
	}

}
