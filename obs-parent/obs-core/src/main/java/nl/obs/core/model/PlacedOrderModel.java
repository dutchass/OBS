package nl.obs.core.model;

import java.util.Date;
import java.util.List;

import nl.obs.core.db.entity.Customer;
import nl.obs.core.db.entity.Order;
import nl.obs.core.db.entity.OrderedBook;

public class PlacedOrderModel {
	
	private Order order;
				
	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Customer getCustomer() {
		return order.getCustomer();
	}

	public List<OrderedBook> getOrderedBooks() {
		return order.getOrderedBooks();				
	}
	
	public boolean isShipped() {
		return order.getShipping() != null;
	}
		
	public Date getDate() {
		return order.getDate();
	}

	public int getInvoiceNumber() {
		return order.getInvoiceNumber();
	}

	public Date getShipping() {
		return order.getShipping();
	}

	public int getTotalOrderAmount() {
		int total = 0;
		
		List<OrderedBook> orderedBooks = getOrderedBooks();
		for (OrderedBook orderedBook : orderedBooks) {
			total = total + orderedBook.getAmount();
		}
		return total;
	}
}
