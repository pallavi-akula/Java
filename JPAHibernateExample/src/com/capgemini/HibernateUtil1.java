package com.capgemini;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil1 {

	
		public static SessionFactory factory=null;
		static{
		try{
		    factory = new Configuration().configure().buildSessionFactory();
		    		
			}catch(Throwable th){
				System.err.println("Exception in creating session Factory "+th);
			}
		} 
	   public static SessionFactory getSessionFactory(){
		   return factory;
	   }

	}

