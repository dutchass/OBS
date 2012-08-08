package nl.obs.core.db.manager;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import nl.obs.core.db.entity.User;
import nl.obs.core.model.AuthenticationModel;

public class UserManager extends User{

	private EntityManagerFactory emf;
	
	public UserManager() {
		emf = javax.persistence.Persistence.createEntityManagerFactory("tibri");
	    
	}
	
	public AuthenticationModel authenticate(String username, String password){
		
		AuthenticationModel model = new AuthenticationModel();
		
		User u = getUserByUsername(username);
		model.setUser(u);
		
		boolean authenticated = false;
		if (u != null && password != null && !password.trim().isEmpty()) {
			authenticated = password.equals(u.getPassword());
		}
		model.setAuthenticated(authenticated);
		
		return model;
	}
	
	public User getUserByUsername(String username) {
		User u = new User();
		u.setUsername(username);
		u.setId(0);
		u.setPassword("1234");
		
		return u;
	}
	
	public User getUser(int id) {
		User u = new User();
		u.setUsername("piet");
		u.setId(id);
		u.setPassword("1234");
		
		return u;
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
