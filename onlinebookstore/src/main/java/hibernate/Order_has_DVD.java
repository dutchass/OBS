	package hibernate;

	import javax.persistence.Column;
	import javax.persistence.Entity;
	import javax.persistence.Table;

	@Entity
	@Table(name="Order_has_DVD")
	public class Order_has_DVD {	
		
		    @Column(name="Order_ID")    
		    private int order_id; 
		 
		    @Column(name="DVD_ID")
			private int dvd_id;

		    @Column
		    private int amount;

			public int getOrder_id() {
				return order_id;
			}

			public void setOrder_id(int order_id) {
				this.order_id = order_id;
			}

			public int getDvd_id() {
				return dvd_id;
			}

			public void setDvd_id(int dvd_id) {
				this.dvd_id = dvd_id;
			}

			public int getAmount() {
				return amount;
			}

			public void setAmount(int amount) {
				this.amount = amount;
			}
	
		    
	
}
