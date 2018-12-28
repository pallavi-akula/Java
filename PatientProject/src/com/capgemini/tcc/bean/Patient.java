package com.capgemini.tcc.bean;

public class Patient {
	private String name;
	private String age;
	private String phoneNumber;
	private String description;
	//private Date regDate;
	
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}



	public String getAge() {
		return age;
	}



	public void setAge(String age) {
		this.age = age;
	}



	public String getPhoneNumber() {
		return phoneNumber;
	}



	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}



	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}



	

	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		sb.append("Printing Donor Details \n");
		sb.append("Name: " +name +"\n");
		sb.append("Age: " +age +"\n");
		sb.append("Phone Number: "+ phoneNumber +"\n");
		sb.append("Product Interested: "+ description +"\n");
	
		return sb.toString();
	}
	

}
