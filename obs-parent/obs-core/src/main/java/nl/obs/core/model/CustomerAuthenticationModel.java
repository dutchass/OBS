package nl.obs.core.model;

import nl.obs.core.db.entity.Customer;

public class CustomerAuthenticationModel extends AuthenticationModel {

	private Customer customer;
		
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
}
