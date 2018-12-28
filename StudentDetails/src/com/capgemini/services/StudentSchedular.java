package com.capgemini.services;

import com.capgemini.beans.Student;

public class StudentSchedular {
    
    private Student[] students = new Student[10];
     
      
     
    private int counterStudent;
 
    public String addStudent(int rollNumber,String name,int noOfCourses,String[] courseNames)
 
    {
 
        students[counterStudent++]=new Student(rollNumber,name,noOfCourses,courseNames);
        
        return "Student added successfully";
 
  
 
    }
 
  
 
    public void showAllStudents()
 
    {
 
        for(int i=0;i<counterStudent;i++)
 
        {
            
            System.out.println("Roll Number =" + students[i].getRollNumber());
 
            System.out.println("Name =" + students[i].getName());
        
            System.out.println("No Of Courses =" + students[i].getNoOfCourses());
            
            for(int j=0;j<students[i].getCourseNames().length;j++){
                int t=j+1;
            System.out.println("Course"+t+":" + students[i].getCourseNames()[j]);
        
        }
    }
        
    }       
            
    public void showByRollNumber(int rno) {
        // TODO Auto-generated method stub
        int flag=0;
            for(int i=0;i<counterStudent;i++){
                
            
            if(students[i].getRollNumber()==rno)
            {
                    
                
                System.out.println("Name =" +students[i].getName());
                    flag++;
            
            } 
            }if(flag==0)
                System.out.println("Record not found!");
            
    }



    public void showByCourse(String sub) {
        // TODO Auto-generated method stub
        int flag=0;
        for(int i=0;i<counterStudent;i++){
            
            for(int j=0;j<students[i].getCourseNames().length;j++){
                
            
            if((students[i].getCourseNames()[j]).equals(sub)==true)
            {
                System.out.println("Roll Number =" + students[i].getRollNumber());
                System.out.println("Name =" + students[i].getName());
                flag++;
            }
        }if(flag==0)
            System.out.println("Records not found!");
    }
}
    


   public boolean isRollNumberPresent(int rollNumber)
   {
       for(int i=0;i<counterStudent;i++)
       {
           if(rollNumber==students[i].getRollNumber())
               return true;
       }
       return false;
   }
}


