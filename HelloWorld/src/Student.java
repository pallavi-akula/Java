
import java.util.Scanner;
import java.io.*;

 class StudentDemo {
	 int rollNumber;
	public int getRollNumber() {
		return rollNumber;
	}
	public void setRollNumber(int rollNumber) {
		this.rollNumber = rollNumber;
	}
	 String name;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	 String[] course;
	public String[] getCourse() {
		return course;
	}
	public void setCourse(String[] course) {
		this.course = course;
	}
	
}
public class Student {

	public static void main(String[] args) {
		StudentDemo stu = new StudentDemo();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Roll Number:");
		int rollnumber = sc.nextInt();
		System.out.println("Enter Name:");
		String name=sc.next();
		System.out.println("How many subjects do you want to select? ");
		int course = sc.nextInt();
		String[] courseNames = new String[course];
		for(int i = 0 ;i < courseNames.length;i++){
			courseNames[i] = sc.next();
		}
		stu.setRollNumber(rollnumber);
		stu.setName(name);
		stu.getCourse();
		System.out.println(stu.getRollNumber());
		System.out.println(stu.getName());
		for(int j = 0;j < stu.getCourse().length;j++){
		System.out.println(stu.getCourse()[j]);
		}
			
			
		}
		
	}


