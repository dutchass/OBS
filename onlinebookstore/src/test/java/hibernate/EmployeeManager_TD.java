package hibernate;

import java.sql.Date;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class EmployeeManager_TD extends EmployeeManager{
	public static void main(String[] args) {                          
		// Read        
		System.out.println("******* READ *******");        
		List employees = list();        
		System.out.println("Total Employees: " + employees.size());                          
		
		// Write        
		System.out.println("******* WRITE *******");        
		Employee empl = new Employee("Tim", "van Abeelen", new Date(System.currentTimeMillis()), "0655702350");        
		empl = save(empl);        
		empl = read(empl.getId());        
		System.out.printf("%d %s %s \n", empl.getId(), empl.getFirstname(), empl.getLastname());                                  
		
		// Update        
		System.out.println("******* UPDATE *******");        
		Employee empl2 = read(empl.getId()); // read employee with id given from write method        
		System.out.println("Name Before Update:" + empl2.getFirstname());        
		empl2.setFirstname("Britt");        
		update(empl2);  // save the updated employee details                 
		empl2 = read(empl.getId()); // read again employee with id given from write method      
		System.out.println("Name After Update:" + empl2.getFirstname());                          
		
		// Delete        
		System.out.println("******* DELETE *******");        
		delete(empl);         
		Employee empl3 = read(empl.getId());       
		System.out.println("Object:" + empl3);    } 
	}