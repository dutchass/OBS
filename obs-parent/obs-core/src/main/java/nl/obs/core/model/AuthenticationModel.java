package nl.obs.core.model;

import nl.obs.core.db.entity.User;

public class AuthenticationModel {
	
	private User user;
	private boolean authenticated = false;
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public boolean isAuthenticated() {
		return authenticated;
	}
	public void setAuthenticated(boolean authenticated) {
		this.authenticated = authenticated;
	}	
}
