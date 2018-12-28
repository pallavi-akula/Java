package com.capgemini.view;

import java.util.Scanner;

import com.capgemini.services.StudentSchedular;

public class Admin {

    private static Scanner sc=new Scanner(System.in);
     
    private static StudentSchedular studSch = new StudentSchedular();
 
  
 
    public static void main(String[] args) {
   
 
        showMenu();
 
  
 
    }
 
    private static void showMenu() {
 
        int choice;
 
        while(true)
 
        {
 
            System.out.println("1.add student");
 
            System.out.println("2.Display details of all students");
 
            System.out.println("3.Display Student name by Roll number");
            
            System.out.println("4.Display Student details by Course");
 
            System.out.println("5.exit");
 
            System.out.println("Enter your choice");
 
            choice=sc.nextInt();
 
            switch(choice)
 
            {
            
            
            case 1:addStudentDetails();
                   break;
 
             case 2:showAllStudents();
 
                    break;
                    
             case 3:showByRollNumber();
                    break;
                    
             case 4:showByCourse();
                    break;
              

             case 5:System.exit(0);
             
             default:System.out.println("Sorry entered wrong choice");
 
 
 
            }
 
            
 
        }
 
  
 
    }
    
    
  private static void showByCourse() {
        // TODO Auto-generated method stub
        System.out.println("Enter course name:");
        String sub=sc.next();
        studSch.showByCourse(sub);
    }

    private static void showByRollNumber() {
        
        System.out.println("Enter rollnumber:");
        int rno=sc.nextInt();
        studSch.showByRollNumber(rno);
        
    }
 
    private static void showAllStudents() {
         
        studSch.showAllStudents();
        
 
  
 
    }
    private static void addStudentDetails() {
        
        
        System.out.println("Enter roll number");
 
        int rollNumber=sc.nextInt();
 if(!studSch.isRollNumberPresent(rollNumber)){
     
 
        System.out.println("Enter name");
        String name = sc.next();
        
        System.out.println("How many courses do you want to register?");
        int noOfCourses=sc.nextInt();
        
        System.out.println("Enter courses");
        String[] courseNames= new String[noOfCourses];
        for(int i=0;i<courseNames.length;i++){
            courseNames[i]=sc.next();
        }
 
        System.out.println(studSch.addStudent(rollNumber, name,noOfCourses, courseNames));
 
        
 
  
 
    }else
        System.out.println("roll number already exists");
 
    }
        
  }


