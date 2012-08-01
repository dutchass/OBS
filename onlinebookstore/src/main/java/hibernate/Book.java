package hibernate;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Book")
public class Book {
		
    @Id    
    @GeneratedValue (strategy=GenerationType.AUTO)
    @Column(name="ID")
	private int id; 
    
    @Column(name="imageurl")
	private String imagebookurl;
    
    @Column
	private String title;
    
    @Column
	private int ISBNnumber;
    
    @Column
    private int price;

    @OneToMany (mappedBy="book" )
    private Collection<Order_has_book> order_has_book = new ArrayList<Order_has_book>();
    
    
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getImagebookurl() {
		return imagebookurl;
	}

	public void setImagebookurl(String imagebookurl) {
		this.imagebookurl = imagebookurl;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getISBNnumber() {
		return ISBNnumber;
	}

	public void setISBNnumber(int iSBNnumber) {
		ISBNnumber = iSBNnumber;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public Collection<Order_has_book> getOrder_has_book() {
		return order_has_book;
	}

	public void setOrder_has_book(Collection<Order_has_book> order_has_book) {
		this.order_has_book = order_has_book;
	}

}
