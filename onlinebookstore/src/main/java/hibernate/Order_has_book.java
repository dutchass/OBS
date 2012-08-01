	package hibernate;

	import javax.persistence.Column;
	import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

	@Entity
	@Table(name="Order_has_book")
	public class Order_has_book {	
		
		    @Column(name="Order_ID")    
		    private int order_id; 
		 
		    @Column(name="Book_ID")
			private int book_id;

		    @Column
		    private int amount;
		    
		    @ManyToOne
		    @JoinColumn(name="Book_ID",
										referencedColumnName= "ID"	)
		    private Book book;
		    
		    
		    
			public int getOrder_id() {
				return order_id;
			}

			public void setOrder_id(int order_id) {
				this.order_id = order_id;
			}

			public int getBook_id() {
				return book_id;
			}

			public void setBook_id(int book_id) {
				this.book_id = book_id;
			}

			public int getAmount() {
				return amount;
			}

			public void setAmount(int amount) {
				this.amount = amount;
			}

			public Book getBook() {
				return book;
			}

			public void setBook(Book book) {
				this.book = book;
			}


	
}
