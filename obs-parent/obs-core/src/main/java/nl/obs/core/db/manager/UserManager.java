package nl.obs.core.db.manager;

import nl.obs.core.db.entity.Customer;
import nl.obs.core.db.entity.User;
import nl.obs.core.model.AuthenticationModel;
import nl.obs.core.model.CustomerAuthenticationModel;

public class UserManager extends User{	
		
	public static AuthenticationModel authenticateCustomer(String username, String password){
		
		CustomerAuthenticationModel model = new CustomerAuthenticationModel();
		
		Customer c = CustomerManager.getCustomerByUsername(username);

		model.setUser(c);
		model.setCustomer(c);
				
		boolean authenticated = false;
		if (c != null && password != null && !password.trim().isEmpty()) {
			authenticated = password.equals(c.getPassword());
		}
		model.setAuthenticated(authenticated);
		
		return model;
	}
	
}
