package hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Customer")
public class Customer {

    @Id 
    @GeneratedValue
    @Column(name="ID")   
	private int id; 
    
    @Column(name="firstname")
	private String firstname;
    
    @Column(name="lastname")
	private String lastname;
    
    @Column 
    private String adress;
    
    @Column 
    private String zippcode;
    
    @Column 
    private String city;
    
    @Column 
    private String emailadress;
    
    @Column (name= "phonenumber", nullable = true) 
    private int phonenumber;
    
    @OneToOne
    @JoinColumn(name = "Login_ID", 
    				referencedColumnName="ID")
    private Login login;
    
    
   // Constructors
    public Customer() {             
			
	}         
	
	public Customer(String firstname, String lastname, String adress, String zippcode, String city, String emailadress, Integer phonenumber, String username, String password) {        
		this.firstname = firstname;
		this.lastname = lastname;
		this.adress = adress;
		this.zippcode = zippcode;
		this.city = city;
		this.emailadress = emailadress;
		this.phonenumber = phonenumber;
	}

	// Getter and Setter methods 
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public String getZippcode() {
		return zippcode;
	}

	public void setZippcode(String zippcode) {
		this.zippcode = zippcode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getEmailadress() {
		return emailadress;
	}

	public void setEmailadress(String emailadress) {
		this.emailadress = emailadress;
	}

	public Integer getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(Integer phonenumber) {
		this.phonenumber = phonenumber;
	}

	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}

}
