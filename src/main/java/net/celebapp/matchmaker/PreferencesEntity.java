package net.celebapp.matchmaker;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "preferences")
public class PreferencesEntity {

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)	
	    private Integer preferencesId;
	    
	    @Column(name = "age_min")
	    private Integer ageMin;

		@Column(name = "age_max")
		private Integer ageMax;

		@Column(name = "gender")
		private String gender;

		@Column(name = "fk_profile_id", nullable = false)
		private Integer fkProfileId;

	    public PreferencesEntity() {
	  
	    }
	 
	    public PreferencesEntity(int ageMin, int ageMax, String gender, int fkProfileId) {
	         this.ageMin = ageMin;
	         this.ageMax = ageMax;
	         this.gender = gender;
	         this.fkProfileId = fkProfileId;
	    }
	 
	   
	    public Integer getPreferencesId() {
	        return preferencesId;
	    }
	    public void setPreferencesId(Integer preferencesId) {
	        this.preferencesId = preferencesId;
	    }
	 
	    public Integer getAgeMax() { return ageMax; }
	    public void setAgeMax(int ageMax) {
	        this.ageMax = ageMax;
	    }


		public int getAgeMin() { return ageMin; }
		public void setAgeMin(int ageMin) {
		this.ageMin = ageMin;
	}
	 
	   
	    public String getGender() {
	        return gender;
	    }
	    public void setGender(String gender) {
	        this.gender = gender;
	    }

		public Integer getFkProfileId() {
			return fkProfileId;
		}
		public void setFkProfileId(Integer fkProfileId) {
			this.fkProfileId = fkProfileId;
		}

	    @Override
	    public String toString() {
	        return "Preferences[preferencesId=" + preferencesId
					+ ", agemin=" + ageMin + ", ageMax=" + ageMax + ", gender=" + gender + "]";
	    }
	 
	}
