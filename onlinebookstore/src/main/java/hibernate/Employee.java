package hibernate;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity 
@Table(name="Employee")
public class Employee {

    @Id 
    @GeneratedValue(strategy=GenerationType.AUTO)	// tells that it is a primary key. Hibernate chooses the best option suiting the DB.
    @Column(name="ID")    							// tells the name of the field in the database
    private int id; 
    
    @Column(name="firstname")
	private String firstname;
    @Column(name="lastname")
	private String lastname;
    @Temporal(TemporalType.DATE) // only saves the date, not the time
    @Column(name="joineddate")
	private Date joinedDate;
    @Column(name="cellphone")
	private String cellphone;     
    
    @OneToOne
    @JoinColumn(name="Login_ID",
    				referencedColumnName= "ID"	)
    private Login elogin;

  
	// Getter and Setter methods 
    
	public Employee(String string, String string2, java.sql.Date date,
			String string3) {
		// TODO Auto-generated constructor stub
	}

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

	public Date getJoinedDate() {
		return joinedDate;
	}

	public void setJoinedDate(Date joinedDate) {
		this.joinedDate = joinedDate;
	}

	public String getCellphone() {
		return cellphone;
	}

	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}

	public Login getElogin() {
		return elogin;
	}

	public void setElogin(Login elogin) {
		this.elogin = elogin;
	}
    
}
