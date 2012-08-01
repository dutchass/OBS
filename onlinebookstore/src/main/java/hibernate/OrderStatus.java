package hibernate;

import javax.persistence.*;


@Entity
@Table(name="OrderStatus")
public class OrderStatus {

    @Id    
    @GeneratedValue	(strategy=GenerationType.AUTO)	
    @Column(name="ID")  
	private int id; 
    
    @Column
	private String inprocess;
    
    @Column
	private String shipped;
    
    @Column
	private String canceled;
	
    @OneToOne
    @JoinColumn(name="Order_ID",
    				referencedColumnName= "ID"	)
    private Order order ;
    
    // Constructors
	public OrderStatus() {             
		
		
	}         
	
	

	public OrderStatus(int id, String inprocess, String shipped, String canceled) {
		super();
		this.id = id;
		this.inprocess = inprocess;
		this.shipped = shipped;
		this.canceled = canceled;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getInprocess() {
		return inprocess;
	}



	public void setInprocess(String inprocess) {
		this.inprocess = inprocess;
	}



	public String getShipped() {
		return shipped;
	}



	public void setShipped(String shipped) {
		this.shipped = shipped;
	}



	public String getCanceled() {
		return canceled;
	}



	public void setCanceled(String canceled) {
		this.canceled = canceled;
	}



	public Order getOrder() {
		return order;
	}



	public void setOrder(Order order) {
		this.order = order;
	}
		
}
