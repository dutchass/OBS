package nl.obs.core.db.manager;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;

import nl.obs.core.db.entity.Customer;

public class CustomerManager {

	public static Customer getCustomer(int id) {
		EntityManager em = DBUtils.ENTITY_MANAGER_FACTORY.createEntityManager();
		EntityTransaction tx = em.getTransaction();

		Customer c;
		try {
			tx.begin();
			c = (Customer) em
					.createQuery(
							"select c from Customer c where c.id = :customerId")
					.setParameter("customerId", id).getSingleResult();
			tx.commit();
		} catch (NoResultException e) {
			return null;
		}

		return c;
	}

	public static Customer getCustomerByUsername(String username) {
		EntityManager em = DBUtils.ENTITY_MANAGER_FACTORY.createEntityManager();
		EntityTransaction tx = em.getTransaction();

		Customer c;
		try {
			tx.begin();
			c = (Customer) em
					.createQuery(
							"select c from Customer c where c.username = :userName")
					.setParameter("userName", username).getSingleResult();
			tx.commit();
		} catch (NoResultException e) {
			return null;
		}

		return c;
	}
}
