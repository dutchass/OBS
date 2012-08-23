package nl.obs.core.db.manager;

import java.util.Date;
import java.util.List;
import java.util.Vector;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;

import nl.obs.core.db.entity.Book;
import nl.obs.core.db.entity.Customer;
import nl.obs.core.db.entity.Order;
import nl.obs.core.db.entity.OrderedBook;
import nl.obs.core.model.BookEntry;
import nl.obs.core.model.PlacedOrderModel;
import nl.obs.core.model.ShoppingCartModel;

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
	
	public static void persistOrder(Order order) {
		EntityManager em = DBUtils.ENTITY_MANAGER_FACTORY.createEntityManager();
		EntityTransaction tx = em.getTransaction();

		tx.begin();
		em.persist(order);
		for (OrderedBook orderedBook : order.getOrderedBooks()) {
			orderedBook.setOrderBookId(new OrderedBook.OrderBookId(order.getId(),orderedBook.getBook().getId()));
			em.persist(orderedBook);
		}
		tx.commit();
		
	}
	
	public static Order createOrder(Customer customer, ShoppingCartModel model) {
		Order order = new Order();
		order.setDate(new Date());
		order.setCustomer(customer);
		order.setInvoiceNumber(((Long)(new Date()).getTime()).intValue());
		order.setShipping(null);
		order.setTotalAmount(model.getTotalAmount());
		
		List<BookEntry> bookEntries = model.getBookEntries();
		Vector<OrderedBook> orderedBooks = new Vector<>();
		for (BookEntry bookEntry : bookEntries) {
			Book book = bookEntry.getBook();
			
			OrderedBook orderedBook = new OrderedBook();
			orderedBook.setAmount(bookEntry.getAmount());
			orderedBook.setBook(book);
			orderedBook.setOrder(order);
			orderedBooks.add(orderedBook);
		}
		
		order.setOrderedBooks(orderedBooks);
		
		return order;
	}
}
