package com.connect2java;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "EMPLOYEE")
public class Employee {  
    private int empId;  
    private String empName;  
    private String empDept;  
  
    public Employee() {}  
    
	public Employee(int empId, String empName, String empDept) {  
    super();  
    this.empId = empId;  
    this.empName = empName;  
    this.empDept = empDept;  
    }
    
	@Id
	@Column(name = "EMPNO", unique = true, nullable = false, length=5)
    public int getEmpId() {
	return empId;
    }
    
    public void setEmpId(int empId) {
	this.empId = empId;
    }
    
    @Column(name = "EMPNAME", nullable = false, length = 20)
    public String getEmpName() {
	return empName;
    }
    
    public void setEmpName(String empName) {
	this.empName = empName;
    }
    
    @Column(name = "EMPDEPT", nullable = false, length = 20)
    public String getEmpDept() {
	return empDept;
    }
    
	public void setEmpDept(String empDept) {
	this.empDept = empDept;
	}   
		
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName
				+ ", empDept=" + empDept + "]";
	}
  }  
