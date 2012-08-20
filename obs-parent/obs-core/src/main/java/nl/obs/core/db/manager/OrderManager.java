package nl.obs.core.db.manager;

import java.util.List;
import java.util.Vector;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;

import nl.obs.core.db.entity.Customer;
import nl.obs.core.db.entity.Order;
import nl.obs.core.model.PlacedOrderModel;

public class OrderManager {

	@SuppressWarnings("unchecked")
	public static List<PlacedOrderModel> getPlacedOrders(Customer customer) {
		EntityManager em = DBUtils.ENTITY_MANAGER_FACTORY.createEntityManager();
		EntityTransaction tx = em.getTransaction();

		List<Order> orders = null;
		try {
			tx.begin();
			orders = (List<Order>) em
					.createQuery(
							"select o from Order o where o.customer.id = :customerId")
					.setParameter("customerId", customer.getId()).getResultList();
			tx.commit();
		} catch (NoResultException e) {
			return null;
		}
		
		Vector<PlacedOrderModel> models = new Vector<>();
		for (Order order : orders) {
			PlacedOrderModel model = new PlacedOrderModel();
			model.setOrder(order);
			models.add(model);
		}

		return models;
	}
}
