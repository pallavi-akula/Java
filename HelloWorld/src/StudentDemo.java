package kal;

import java.util.Scanner;

public class Student {
    int rollNumber;
    String name;
    String[] course;
    public int getRollNumber() {
        return rollNumber;
    }
    public void setRollNumber(int rollNumber) {
        this.rollNumber = rollNumber;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String[] getCourse() {
        return course;
    }
    public void setCourse(String[] course) {
        this.course = course;
    }
    public class Test
    {
        public static void main(String args[])
        {
            Student s=new Student();
            Scanner sc=new Scanner(System.in);
            System.out.println("Enter roll no");
            int rollNumber=sc.nextInt();
            System.out.println("Enter name");
            string name=sc.next();
            System.out.println("How many courses do you want to regoster?");
            int courses=sc.nextInt();
            String[] courseNames=new String (course);
            for(int i=0;i<courseNames.length;i++)
            {
                courseNames[i]=sc.next();
            }
            s.setRollNumber(rollNumber);
            s.setName(name);
            s.getCourse();
            
            System.out.println(s.getRollNumber());
            System.out.println(s.getName());
            for (int j=0;j<s.getCourse().length;j++)
            {
                System.out.println(s.getCourse()[j]);
            }
            
        }
    }
}