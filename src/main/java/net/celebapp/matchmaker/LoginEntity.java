package net.celebapp.matchmaker;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "login")
public class LoginEntity {

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name="emailId")
	    private Integer emailId;
	    
	    @Column(name = "email", nullable = false)
	    private String email;
	    
	    @Column(name = "password", nullable = false)
	    private String password;
	 
	    public LoginEntity() {
	  
	    }
	   
		public Integer getEmailId() {
	        return emailId;
	    }
	    public void setEmailId(Integer emailId) {
	        this.emailId = emailId;
	    }
	 
	   	public String getEmail() {
	        return email;
	    }
	    public void setEmail(String email) {
	        this.email = email;
	    }
	 
	   
	    public String getPassword() {
	        return password;
	    }
	    public void setPassword(String password) {
	        this.password = password;
	    }

	    @Override
	    public String toString() {
	        return "Login [emailId=" + emailId + ", email=" + email + ", password=" + password
	       + "]";
	    }
	 
	}
