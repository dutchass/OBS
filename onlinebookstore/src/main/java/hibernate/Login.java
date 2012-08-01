package hibernate;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Embeddable // gives the value object (username, password) to employee and customer
@Table(name="Login")
public class Login {
	    
		@Id 
		@GeneratedValue	
	    @Column(name="ID")    
	    private int loginId; 
	    
	    @Column(name="username")
		private String username;
	    
	    @Column(name="password")
		private String password;

  
  		public int getloginId() {
			return loginId;
		}

		public void setloginId(int loginId) {
			this.loginId = loginId;
		}

		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}


}
