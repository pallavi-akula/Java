package com.capgemini.beans;

public class CustomerBean {
	private String CustomerId;
	private String CustomerName;
	public String getCustomerId() {
		return CustomerId;
	}
	public void setCustomerId(String customerId) {
		CustomerId = customerId;
	}
	public String getCustomerName() {
		return CustomerName;
	}
	public void setCustomerName(String customerName) {
		CustomerName = customerName;
	}
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		sb.append("Printing Customer Details \n");
		sb.append("Customer"
				+ " Name: " +CustomerName +"\n");
		return sb.toString();
	}

}
