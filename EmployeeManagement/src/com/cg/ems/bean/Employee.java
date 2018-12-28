package com.cg.ems.bean;

public class Employee {
public Employee() {
	// TODO Auto-generated constructor stub
}
	private int empId;
	private String name;
	private String mobile;
	private int sal;
	private String mail;
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public int getSal() {
		return sal;
	}
	public void setSal(int sal) {
		this.sal = sal;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public Employee(int empId, String name, String mobile, int sal, String mail) {
	
		this.empId = empId;
		this.name = name;
		this.mobile = mobile;
		this.sal = sal;
		this.mail = mail;
	}
	@Override
		public String toString() {
		
			return this.empId+""+this.name+" "+this.mobile+" "+this.sal;
		}
	
	
}
