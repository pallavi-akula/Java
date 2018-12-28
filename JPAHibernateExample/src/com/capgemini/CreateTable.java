package com.capgemini;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class CreateTable {
	private static SessionFactory factory; 
	public static void main(String[] args) {
		
		 factory=HibernateUtil.getSessionFactory();
		
		if(factory!=null)
		{
		Session session=factory.openSession();
		Transaction tx=session.beginTransaction();
		UserDetails user=new UserDetails();
		user.setUserName("Sachin 1");
		session.save(user);
		
		tx.commit();
      session.close();
      
      ReadData();
      
      
	}
		else
			System.out.println("Session factory is null");

}

	private static void ReadData() {
		// TODO Auto-generated method stub
		Session session=factory.openSession();
		Transaction tx=session.beginTransaction();
		UserDetails user1=(UserDetails)session.get(UserDetails.class,1);
		System.out.println(user1.getUserName());
		tx.commit();
		session.close();
		
		
	}

}
