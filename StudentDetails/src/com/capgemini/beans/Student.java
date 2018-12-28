package com.capgemini.beans;

public class Student {
    
    private int rollNumber;
    private String name;
    private int noOfCourses;
    private String[] courseNames;
    
    
    public Student(int rollNumber, String name, int noOfCourses, String[] courseNames) {
        super();
        this.rollNumber = rollNumber;
        this.name = name;
        this.noOfCourses = noOfCourses;
        this.courseNames = courseNames;
    }
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
    public int getNoOfCourses() {
        return noOfCourses;
    }
    public void setNoOfCourses(int noOfCourses) {
        this.noOfCourses = noOfCourses;
    }
    public String[] getCourseNames() {
        return courseNames;
    }
    public void setCourseNames(String[] courseNames) {
        this.courseNames = courseNames;
    }
    
    
}   
   	