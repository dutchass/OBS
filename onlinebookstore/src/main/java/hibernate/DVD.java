package hibernate;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="DVD")
public class DVD implements Serializable {
	
    @Id    
    @GeneratedValue	
	private int id; 
    
    @Column(name="imagebookurl")
	private String imagebookurl;
    
    @Column
	private String title;
    
    @Column
	private Integer articlenumber;
    
   // Constructors
    public DVD() {             
			
	}

public DVD(int id, String imagebookurl, String title,
		Integer iSBNnumber) {
	super();
	this.id = id;
	this.imagebookurl = imagebookurl;
	this.title = title;
	this.articlenumber = articlenumber;
}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getImageurl() {
	return imagebookurl;
}

public void setImageurl(String imageurl) {
	this.imagebookurl = imagebookurl;
}

public String getTitle() {
	return title;
}

public void setTitle(String title) {
	this.title = title;
}

public Integer getArticlenumber() {
	return articlenumber;
}

public void setArticlenumber(Integer articlenumber) {
	this.articlenumber = articlenumber;
}

			
}
