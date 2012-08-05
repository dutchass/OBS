package nl.obs.core.model;

import java.util.HashMap;

import nl.obs.core.db.entity.User;

public class LoginService {
	
	HashMap<String, String> users = new HashMap<String, String>();
	
	public LoginService(){
		users.put("tva",	"Tim van Abeelen");
		users.put("bo",	"Britt Outhuyse");
			}
	
	public boolean authenticate(String username, String password){
			
			if (password == null || password.trim() == "") { 
				return false;
				}
				return true;
		}
		
		public User getUserDetails (String id){
			User user = new User();
			user.setId(id);
			user.setUsername(users.get(id));
			return user;
		}
}
