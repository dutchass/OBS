package hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class GeneralDBManager {
	// read named query hibernate maken...
	// save or update methode invoegen
	public static void saveObject(Object t) {        
		SessionFactory sf = HibernateUtil.getSessionFactory();        
		Session session = sf.openSession();         
		session.beginTransaction();         
		
		session.save(t);        
		
		session.getTransaction().commit();                 
		session.close();         
	}     
	
	public static void deleteObject(Object o) {   
		SessionFactory sf = HibernateUtil.getSessionFactory();        
		Session session = sf.openSession();                 
		session.beginTransaction();                 
		session.delete(o);                 
		session.getTransaction().commit();                 
		session.close();    
	} 
}