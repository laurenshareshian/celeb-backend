package net.celebapp.matchmaker;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "matches")
public class MatchesEntity {

		@Id
	    @Column(name = "fk_profile_id", nullable = false)
	    private int fkProfileId;

	    @Column(name = "fk_dream_profile_id", nullable = false)
	    private int fkDreamProfileId;
	    
	    @Column(name = "message_to_dream_profile")
	    private String messageToDreamProfile;
	 
	    public MatchesEntity() {
	  
	    }
	 
	    public MatchesEntity(int fkProfileId, int fkDreamProfileId, String messageToDreamProfile) {
	         this.fkProfileId = fkProfileId;
	         this.fkDreamProfileId = fkDreamProfileId;
	         this.messageToDreamProfile = messageToDreamProfile;
	    }
	 
	   
	    public int getFkProfileId() {
	        return fkProfileId;
	    }
	    public void setFkProfileId(Integer fkProfileId) {
	        this.fkProfileId = fkProfileId;
	    }
	 
	   	public int getFkDreamProfileId() {
	        return fkDreamProfileId;
	    }
	    public void setFkDreamProfileId(int fkDreamProfileId) {this.fkDreamProfileId = fkDreamProfileId; }
	 
	   
	    public String getMessageToDreamProfile() {
	        return messageToDreamProfile;
	    }
	    public void setMessageToDreamProfile(String messageToDreamProfile) {
	        this.messageToDreamProfile = messageToDreamProfile;
	    }

	    @Override
	    public String toString() {
	        return "Matches [profileId=" + fkProfileId + ", dreamProfileId=" + fkDreamProfileId +
					", message =" + messageToDreamProfile + "]";
	    }
	 
	}
