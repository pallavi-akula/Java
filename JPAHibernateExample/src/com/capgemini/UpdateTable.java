package com.capgemini;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class UpdateTable {

	private static SessionFactory factory; 
	public static void main(String[] args) {
		
		 factory=HibernateUtil.getSessionFactory();
		
		Session session=factory.openSession();
		Transaction tx=session.beginTransaction();
		UserDetails user=(UserDetails)session.get(UserDetails.class,1);
		
		user.setUserName("updated name1");
		session.update(user);
		session.update(user);
		tx.commit();
		session.close();

}
}
