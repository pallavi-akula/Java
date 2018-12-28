package com.connect2java;

import javax.persistence.EntityManager;


public class EmployeeDAO {
	
	
	public Employee get(Integer empId){
		
		EntityManager entityManager = null;
		Employee employee=null;
		
		try{
			entityManager = EntityManagerUtil.getEntityManager();
			employee = (Employee)entityManager.find(Employee.class, empId);
			
		}catch(Exception e){
			e.printStackTrace();
		}				
		return employee;
	}
	
	
	public void insert(Employee employee){
		
		EntityManager entityManager = null;
		
		try {
			
			entityManager= EntityManagerUtil.getEntityManager();
			entityManager.getTransaction().begin();
			entityManager.persist(employee);
			entityManager.getTransaction().commit();
			
		}catch (Exception e){
			e.printStackTrace();
		}		
	}
	
	
  public void update(Employee employee){
		
	  EntityManager entityManager = null;
		
		try {			
			entityManager= EntityManagerUtil.getEntityManager();
			entityManager.getTransaction().begin();
			entityManager.merge(employee);
			entityManager.getTransaction().commit();
			
		}catch (Exception e){
			e.printStackTrace();
		}		
	}
  
  
  public void delete(Integer empId){
		
	  EntityManager entityManager = null;

		
		try {
			
			entityManager= EntityManagerUtil.getEntityManager();
			entityManager.getTransaction().begin();
			Employee emp = (Employee)entityManager.find(Employee.class, empId);
			entityManager.remove(emp);
			entityManager.getTransaction().commit();
			
		}catch (Exception e){
			e.printStackTrace();
		}		
	}
}
