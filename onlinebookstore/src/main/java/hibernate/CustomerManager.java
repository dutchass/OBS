package hibernate;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class CustomerManager {

	public static List list() {        
		SessionFactory sf = HibernateUtil.getSessionFactory();        
		Session session = sf.openSession();         
		
		List customers = session.createQuery("from Customer").list();
		session.close();        
		return customers;    
	}    
	
	public static Customer read(int id) {        
		SessionFactory sf = HibernateUtil.getSessionFactory();        
		Session session = sf.openSession();         
		Customer customer = (Customer) session.get(Customer.class, id);        
		session.close();        
		return customer;    
	}    
	
	public static Customer save(Customer customer) {        
		SessionFactory sf = HibernateUtil.getSessionFactory();        
		Session session = sf.openSession();         
		session.beginTransaction();         
		
		int id = (Integer) session.save(customer);        
		customer.setId(id);                 
		
		session.getTransaction().commit();                 
		session.close();         
		return customer;    
	}     
	
	public static Customer update(Customer customer) {        
		SessionFactory sf = HibernateUtil.getSessionFactory();        
		Session session = sf.openSession();         
		session.beginTransaction();         
		
		session.merge(customer);                 
		session.getTransaction().commit();                 
		session.close();        
		return customer;     
	}     
	
	public static void delete(Customer customer) {        
		SessionFactory sf = HibernateUtil.getSessionFactory();        
		Session session = sf.openSession();                 
		session.beginTransaction();                 
		session.delete(customer);                 
		session.getTransaction().commit();                 
		session.close();    
	} 
}