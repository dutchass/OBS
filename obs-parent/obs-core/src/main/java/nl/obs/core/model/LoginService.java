package nl.obs.core.model;

import java.util.HashMap;

import nl.obs.core.db.entity.User;

public class LoginService {
	
	HashMap<Integer, String> users = new HashMap<Integer, String>();
	
	public LoginService(){
		users.put(1,	"Tim van Abeelen");
		users.put(2,	"Britt Outhuyse");
			}
	
	public boolean authenticate(String username, String password){
			
			if (password == null || password.trim() == "") { 
				return false;
				}
				return true;
		}
		
		public User getUserDetails (int id){
			User user = new User();
			user.setId(id);
			user.setUsername(users.get(id));
			return user;
		}
}
