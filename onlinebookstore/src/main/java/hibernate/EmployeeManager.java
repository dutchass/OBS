package hibernate;

import java.sql.Date;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class EmployeeManager {

	public static List list() {        
		SessionFactory sf = HibernateUtil.getSessionFactory();        
		Session session = sf.openSession();         
		
		List employees = session.createQuery("from Employee").list();
		session.close();        
		return employees;    
	}    
	
	public static Employee read(int id) {        
		SessionFactory sf = HibernateUtil.getSessionFactory();        
		Session session = sf.openSession();         
		Employee employee = (Employee) session.get(Employee.class, id);        
		session.close();        
		return employee;    
	}    
	
	public static Employee save(Employee employee) {        
		SessionFactory sf = HibernateUtil.getSessionFactory();        
		Session session = sf.openSession();         
		session.beginTransaction();         
		
		int id = (Integer) session.save(employee);        
		employee.setId(id);                 
		
		session.getTransaction().commit();                 
		session.close();         
		return employee;    
	}     
	
	public static Employee update(Employee employee) {        
		SessionFactory sf = HibernateUtil.getSessionFactory();        
		Session session = sf.openSession();         
		session.beginTransaction();         
		
		session.merge(employee);                 
		session.getTransaction().commit();                 
		session.close();        
		return employee;     
	}     
	
	public static void delete(Employee employee) {        
		SessionFactory sf = HibernateUtil.getSessionFactory();        
		Session session = sf.openSession();                 
		session.beginTransaction();                 
		session.delete(employee);                 
		session.getTransaction().commit();                 
		session.close();    
	} 
}