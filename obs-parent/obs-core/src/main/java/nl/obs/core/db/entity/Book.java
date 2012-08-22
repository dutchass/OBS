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

	@Override
	public String toString() {
		return author+ " " + title+" "+price;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ISBNnumber;
		result = prime * result + ((author == null) ? 0 : author.hashCode());
		result = prime * result + id;
		result = prime * result
				+ ((imagebookurl == null) ? 0 : imagebookurl.hashCode());
		result = prime * result + price;
		result = prime * result + ((title == null) ? 0 : title.hashCode());
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
		Book other = (Book) obj;
		if (ISBNnumber != other.ISBNnumber)
			return false;
		if (author == null) {
			if (other.author != null)
				return false;
		} else if (!author.equals(other.author))
			return false;
		if (id != other.id)
			return false;
		if (imagebookurl == null) {
			if (other.imagebookurl != null)
				return false;
		} else if (!imagebookurl.equals(other.imagebookurl))
			return false;
		if (price != other.price)
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}
	
	

}
