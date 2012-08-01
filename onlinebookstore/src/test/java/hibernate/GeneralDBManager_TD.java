//package hibernate;
//
//import java.sql.Date;
//import java.util.List;
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//
//public class GeneralDBManager_TD extends GeneralDBManager{
//	public static void main(String[] args) {                          
//		// Read        
//		System.out.println("******* READ *******");        
//		List authors = list();        
//		System.out.println("Total Authors: " + authors.size());                          
//		
//		// Write        
//		System.out.println("******* WRITE *******");        
//		Author auth = new Author("Tim", "van Abeelen");        
//		auth = save(auth);        
//		auth = read(auth.getId());        
//		System.out.printf("%d %s %s \n", auth.getId(), auth.getFirstname(), auth.getLastname());                                  
//		
//		// Update        
//		System.out.println("******* UPDATE *******");        
//		Employee empl2 = read(empl.getId()); // read employee with id given from write method        
//		System.out.println("Name Before Update:" + empl2.getFirstname());        
//		empl2.setFirstname("Britt");        
//		update(empl2);  // save the updated employee details                 
//		empl2 = read(empl.getId()); // read again employee with id given from write method      
//		System.out.println("Name After Update:" + empl2.getFirstname());                          
//		
//		// Delete        
//		System.out.println("******* DELETE *******");        
//		delete(empl);         
//		Employee empl3 = read(empl.getId());       
//		System.out.println("Object:" + empl3);    } 
//	}