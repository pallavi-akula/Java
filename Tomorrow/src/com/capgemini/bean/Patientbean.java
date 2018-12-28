package com.capgemini.bean;

import java.util.Date;

public class Patientbean {
	/*@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((age == null) ? 0 : age.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((phoneNumber == null) ? 0 : phoneNumber.hashCode());
		result = prime * result + ((productInterested == null) ? 0 : productInterested.hashCode());
		//result = prime * result + ((regDate == null) ? 0 : regDate.hashCode());
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Patientbean other = (Patientbean)obj;
		if (age == null) {
			if (other.age != null)
				return false;
		} else if (!age.equals(other.age))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (phoneNumber == null) {
			if (other.phoneNumber != null)
				return false;
		} else if (!phoneNumber.equals(other.phoneNumber))
			return false;
		if (productInterested == null) {
			if (other.productInterested != null)
				return false;
		} else if (!productInterested.equals(other.productInterested))
			return false;
		/*if (regDate == null) {
			if (other.regDate != null)
				return false;
		} else if (!regDate.equals(other.regDate))
			return false;
		return true;
	}

*/
	private String name;
	private String age;
	private String phoneNumber;
	private String productInterested;
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



	public String getProductInterested() {
		return productInterested;
	}



	public void setProductInterested(String productInterested) {
		this.productInterested = productInterested;
	}



	/*public Date getRegDate() {
		return regDate;
	}



	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
*/


	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		sb.append("Printing Donor Details \n");
		sb.append("Name: " +name +"\n");
		sb.append("Age: " +age +"\n");
		sb.append("Phone Number: "+ phoneNumber +"\n");
		sb.append("Product Interested: "+ productInterested +"\n");
	//sb.append("Reg Date: "+ regDate);
		return sb.toString();
	}
	
}
