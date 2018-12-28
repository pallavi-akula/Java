

	class Person 
	{ 
	    Person() 
	    { 
	        System.out.println("Person class Constructor"); 
	    } 
	} 
	class Student extends Person 
	{ 
	    Student() 
	    { 
	       
	        super(); 
	  
	        System.out.println("Student class Constructor"); 
	    } 
	} 
	public class InheritanceSuper {
	public static void main(String[] args) {
		Student s = new Student(); 
		//s. Student(); 
		
	} 
	
	}


