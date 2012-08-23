package nl.obs.core.db.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name = "order_has_book")
public class OrderedBook {

	@EmbeddedId
	private OrderBookId orderBookId;
	@Column
	private int amount;
	
	@ManyToOne
	@JoinColumn(name="Book_ID",insertable=false, updatable=false)
	private Book book;
	
	@ManyToOne
	@JoinColumn(name="Order_ID",insertable=false, updatable=false)
	private Order order;
		
	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}	

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public OrderBookId getOrderBookId() {
		return orderBookId;
	}

	public void setOrderBookId(OrderBookId orderBookId) {
		this.orderBookId = orderBookId;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	@Embeddable
	public static class OrderBookId implements Serializable {

		private static final long serialVersionUID = -8883434588897492909L;
		
		@Column(name = "Order_ID")
		private int order;
		
		@Column(name = "Book_ID")
		private int book;
		
		public OrderBookId(){}
		
		public OrderBookId(int order, int book) {
			super();
			this.order = order;
			this.book = book;
		}

		public int getOrder() {
			return order;
		}

		public void setOrder(int order) {
			this.order = order;
		}

		public int getBook() {
			return book;
		}

		public void setBook(int book) {
			this.book = book;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + book;
			result = prime * result + order;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			OrderBookId other = (OrderBookId) obj;
			if (book != other.book)
				return false;
			if (order != other.order)
				return false;
			return true;
		}

		

		

	}

}
