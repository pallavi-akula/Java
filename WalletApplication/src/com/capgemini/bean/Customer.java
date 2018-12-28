package com.capgemini.bean;

public class Customer {
	private String customerName;
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public Wallet getWallet() {
		return wallet;
	}
	public void setWallet(Wallet wallet) {
		this.wallet = wallet;
	}
	private String mobileNumber;
	private Wallet wallet;
	public Customer(String name2, String mobileNo2, Wallet wallet2) {
		this.customerName=name2;
		mobileNumber=mobileNo2;
		wallet=wallet2;
	}
	@Override
	public String toString() {
		return "Customer name=" + customerName + ", mobileNo=" + mobileNumber
				 + wallet;
	}
	

}
