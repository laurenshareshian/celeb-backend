package net.celebapp.matchmaker;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/profile")
public class ProfileController {
	
	@Autowired
	ProfileRepository profileRepository;
	
	@GetMapping("/get-all-profiles")
	public List<ProfileEntity> getAllProfile(){
		List<ProfileEntity> allProfilelist = profileRepository.findAll();
		return allProfilelist;
		
	}
	
	@GetMapping("/get-profile/{profileId}")
	public ProfileEntity getProfilebyId(@PathVariable(value = "profileId") Integer profileId)
      
	{
		ProfileEntity profileEntity = profileRepository.findById(profileId).get();
		
		return profileEntity;
	}
	
    @PostMapping("/create-profiles")
    public ProfileEntity createProfile(@RequestBody ProfileEntity profile) {
       
    	 ProfileEntity savedProfile = profileRepository.save(profile);
    	 
    	 return savedProfile;
    }
    
    @PutMapping("/update-profiles/{profileId}")
    public ResponseEntity<ProfileEntity> updateProfile(@PathVariable(value = "profileId") Integer profileId,
          @RequestBody ProfileEntity profileDetails) {
        ProfileEntity profile = profileRepository.findById(profileId).get();

        profile.setName(profileDetails.getName());
        profile.setGender(profileDetails.getGender());
        profile.setAge(profileDetails.getAge());
        profile.setCelebStatus(profileDetails.getCelebStatus());
        profile.setBio(profileDetails.getBio());
        final ProfileEntity updatedProfile = profileRepository.save(profile);
        return ResponseEntity.ok(updatedProfile);
    }
    
    @DeleteMapping("/delete-profiles/{profileId}")
    public Map<String, Boolean> deleteProfile(@PathVariable(value = "profileId") Integer profileId)
    {
     ProfileEntity profile = profileRepository.findById(profileId).get();

        profileRepository.delete(profile);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }



}
