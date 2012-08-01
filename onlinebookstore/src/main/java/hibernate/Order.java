package hibernate;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ORDER")
public class Order {

	private Customer customer;
	private Order_has_book order_has_book;
	private Order_has_DVD order_has_DVD;
	
    @Id    
    @GeneratedValue	
	private int id; 
    
    @Column(name="orderdate")
	private Date orderdate;
    
    @Column(name="invoicenumber")
	private Integer invoicenumber;
    
    @Column(name="shipmentdate")
	private Date shipmentdate;
	
    @Column(name="totalorderamount")
	private Integer totalorderamount;

    public Order(){
    	
    }
    
    public Order(int id, Date orderdate, Integer invoicenumber,
			Date shipmentdate, Integer totalorderamount) {
		super();
		this.id = id;
		this.orderdate = orderdate;
		this.invoicenumber = invoicenumber;
		this.shipmentdate = shipmentdate;
		this.totalorderamount = totalorderamount;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getOrderdate() {
		return orderdate;
	}

	public void setOrderdate(Date orderdate) {
		this.orderdate = orderdate;
	}

	public Integer getInvoicenumber() {
		return invoicenumber;
	}

	public void setInvoicenumber(Integer invoicenumber) {
		this.invoicenumber = invoicenumber;
	}

	public Date getShipmentdate() {
		return shipmentdate;
	}

	public void setShipmentdate(Date shipmentdate) {
		this.shipmentdate = shipmentdate;
	}

	public Integer getTotalorderamount() {
		return totalorderamount;
	}

	public void setTotalorderamount(Integer totalorderamount) {
		this.totalorderamount = totalorderamount;
	}

       
}
