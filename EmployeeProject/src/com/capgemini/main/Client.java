package com.capgemini.main;

import java.sql.SQLException;
import java.util.Scanner;

import com.capgemini.bean.Employee;
import com.capgemini.dao.EmployeeDao;
import com.capgemini.dao.EmployeeDaoImpl;
import com.capgemini.exception.EmployeeException;
import com.capgemini.service.EmployeeService;
import com.capgemini.service.EmployeeServiceImpl;

public class Client {

	public static void main(String[] args) throws EmployeeException, SQLException{
		
		EmployeeService cbs = new EmployeeServiceImpl();
		Scanner sc = new Scanner(System.in);
		EmployeeDao daoRef = new EmployeeDaoImpl();
		EmployeeDaoImpl Dao = new EmployeeDaoImpl();
		
		Employee en = new Employee();
		do
		{
		System.out.println("***************Employee*************");
		System.out.println(" ");
		System.out.println("Choose an operation");
		System.out.println("1. Enter Employee Details");
		System.out.println("0.Exit");
		System.out.println(" ");
		System.out.println("***********************************************");
		
		
int choice=sc.nextInt();
		
		switch(choice){
		
		
		case 1: 
			
			
			
			System.out.println("Enter Employee Name: ");
			en.setEmployeeName(sc.next());
		
			System.out.println("Enter Employee Number: ");
			en.setEmployeeNo(sc.nextInt());
			
		
			
			//sc.close();
			
			try{
				if(cbs.isValidEmployee(en)){
					
					daoRef.addEmployee(en);
					//Dao.getCallid();
					System.out.println("Thank You "+en.getEmployeeName());
					
				}
				
			}catch(EmployeeException e){
				e.printStackTrace();
				System.out.println("Please try Again");
			}
			
			break;
			
	
			
			
			
		case 0:System.out.println("Thank You..");
		
        System.exit(0);
        
        break;
        
		default: System.out.println("Invalid Choice..Try Again..!!");
        
			
		
		}
		
		}while(true);
		
		
		
		

	}

}
