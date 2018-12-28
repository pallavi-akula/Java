package com.capgemini.bean;

public class EmployeeBean {
	private int Empno;
	public int getEmpno() {
		return Empno;
	}
	public void setEmpno(int empno) {
		Empno = empno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	private String name;
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		sb.append("Printing Employee Details \n");
		sb.append("Number: " +Empno +"\n");
		sb.append("Name: " +name+"\n");
		
		return sb.toString();
	}
}
