package nl.obs.core.db.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="order")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private int id;
	@Column(name = "orderdate")
	private Date date;
	@Column(name = "invoicenumber")
	private int invoiceNumber;
	@Column(name = "shipmentDate")
	private Date shipping;
	@Column(name = "totalorderamount")
	private int totalAmount;

	@ManyToOne
	@JoinColumn(name = "Customer_ID")
	private Customer customer;

	@OneToMany
	@JoinColumn(name = "Order_ID")
	private List<OrderedBook> orderedBooks;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getInvoiceNumber() {
		return invoiceNumber;
	}

	public void setInvoiceNumber(int invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
	}

	public Date getShipping() {
		return shipping;
	}

	public void setShipping(Date shipping) {
		this.shipping = shipping;
	}

	public int getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(int totalAmount) {
		this.totalAmount = totalAmount;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<OrderedBook> getOrderedBooks() {
		return orderedBooks;
	}

	public void setOrderedBooks(List<OrderedBook> orderedBooks) {
		this.orderedBooks = orderedBooks;
	}
	
	

}
