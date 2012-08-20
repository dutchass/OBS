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
		
	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
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
		private int orderId;
		@Column(name = "Book_ID")
		private int bookId;

		public int getOrderId() {
			return orderId;
		}

		public void setOrderId(int orderId) {
			this.orderId = orderId;
		}

		public int getBookId() {
			return bookId;
		}

		public void setBookId(int bookId) {
			this.bookId = bookId;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + bookId;
			result = prime * result + orderId;
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
			if (bookId != other.bookId)
				return false;
			if (orderId != other.orderId)
				return false;
			return true;
		}

	}

}
