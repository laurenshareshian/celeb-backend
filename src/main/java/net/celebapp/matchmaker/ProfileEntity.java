package net.celebapp.matchmaker;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "profile")
public class ProfileEntity {

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)	
	    private Integer profileId;
	    
	    @Column(name = "first_name", nullable = false)
	    private String firstName;

		@Column(name = "last_name", nullable = false)
		private String lastName;

	    @Column(name = "gender", nullable = false)
	    private String gender;
	    
	    @Column(name = "age", nullable = false)
	    private Integer age;

		@Column(name = "celeb_status", nullable = false)
		private String celebStatus;

		@Column(name = "bio", nullable = false)
		private String bio;

		@Column(name = "fk_email_id", nullable = false)
		private Integer fkEmailId;

	    public ProfileEntity() {
	  
	    }
	 
	    public ProfileEntity(String firstName, String lastName, String gender, Integer age, String celebStatus, String bio, Integer fkEmailId) {
	         this.firstName = firstName;
	         this.lastName = lastName;
	         this.gender = gender;
	         this.age = age;
	         this.celebStatus = celebStatus;
	         this.bio = bio;
	         this.fkEmailId = fkEmailId;
	    }
	 
	   
	   	public Integer getProfileId() {
	        return profileId;
	    }
	    public void setProfileId(Integer profileId) {
	        this.profileId = profileId;
	    }
	 
	   	public String getFirstName() {
	        return firstName;
	    }
	    public void setFirstName(String firstName) {
	        this.firstName = firstName;
	    }

		public String getLastName() {
			return lastName;
		}
		public void setLastName(String lastName) {
			this.lastName = lastName;
		}
	   
	    public String getGender() {
	        return gender;
	    }
	    public void setGender(String gender) {
	        this.gender = gender;
	    }
	 
	   
	    public Integer getAge() {
	        return age;
	    }
	    public void setAge(Integer age) {
	        this.age = age;
	    }

		public String getCelebStatus() {
			return celebStatus;
		}
		public void setCelebStatus(String celebStatus) {
			this.celebStatus = celebStatus;
		}

		public String getBio() {
			return bio;
		}
		public void setBio(String bio) {
			this.bio = bio;
		}

		public Integer getFkEmailId() {
			return fkEmailId;
		}
		public void setFkEmailId(Integer fkEmailId) {
			this.fkEmailId = fkEmailId;
		}

	    @Override
	    public String toString() {
	        return "Profile [profileId=" + profileId + ", name=" + firstName + ", emailId=" + fkEmailId
					+ ", age=" + age + ", gender=" + gender + ", bio=" + bio + ", celeb status=" + celebStatus + "]";
	    }
	 
	}
