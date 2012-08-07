package nl.obs.core.db.manager;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import nl.obs.core.db.entity.User;

public class UserManager extends User{

	private EntityManagerFactory emf;
	
	public UserManager() {
		emf = javax.persistence.Persistence.createEntityManagerFactory("tibri");
	    
	}
	
	public boolean authenticate(String username, String password){
		
		if (password == null || password.trim() == "" || password != getPassword() ) { 
			return false;
			}
			return true;
	}
	
	public User getUser(int id) {
		return null;
	}
	
	public User saveUser(User user) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		tx.begin();
		em.persist(user);
		tx.commit();
		
		return user;
	}
	
}
