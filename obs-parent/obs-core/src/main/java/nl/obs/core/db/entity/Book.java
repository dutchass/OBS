package nl.obs.core.db.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name="Book")
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
    
    @Column(name="Auteur")
    private String author;
    
    @Column
    private int price;
        
    
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

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	

}
