package hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class HibernateTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Customer customer = new Customer();
		customer.setFirstname("Tim");
		customer.setLastname("van Abeelen");
		customer.setAdress("Anna Paulownahof 62");
		customer.setZippcode("5038VV");
		customer.setCity("Tilburg");
		customer.setEmailadress("timvanabeelen@gmail.com");
		customer.setPhonenumber(655702350);
		
		Login login = new Login ();
		login.setUsername("tim");
		login.setPassword("tim");
		
		customer.setLogin(login);
		
		SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		session.beginTransaction();
		session.save(login); 
		session.save(customer);		
		session.getTransaction().commit();
		
		session.close();
		
//		employee = null;
//		
//		session = sessionFactory.openSession();
//		session.beginTransaction();
//		employee =  (Employee) session.get(Employee.class, id);
//		System.out.println("Employee name retrieved is" + employee.getFirstname() + employee.getLastname());		
	}

}
