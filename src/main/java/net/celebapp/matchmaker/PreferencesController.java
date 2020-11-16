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
@RequestMapping("/api/preferences")
public class PreferencesController {
	
	@Autowired
	PreferencesRepository preferencesRepository;
	
	@GetMapping("/get-all-preferences")
	public List<PreferencesEntity> getAllPreferences(){
		List<PreferencesEntity> allPreferenceslist = preferencesRepository.findAll();
		return allPreferenceslist;
		
	}

    @PostMapping("/create-preferences")
    public PreferencesEntity createPreferences(@RequestBody PreferencesEntity preferences) {
       
    	 PreferencesEntity savedPreferences = preferencesRepository.save(preferences);
    	 
    	 return savedPreferences;
    }

    @PutMapping("/update-preferences/{preferencesId}")
    public ResponseEntity<PreferencesEntity> updatePreferences(@PathVariable(value = "preferencesId") Integer preferencesId,
          @RequestBody PreferencesEntity preferencesDetails) {
        PreferencesEntity preferences = preferencesRepository.findById(preferencesId).get();

        if(preferencesDetails.getAgeMin() != null) {
            preferences.setAgeMin(preferencesDetails.getAgeMin());
        }
        if(preferencesDetails.getAgeMax() != null) {
            preferences.setAgeMax(preferencesDetails.getAgeMax());
        }
        if(preferencesDetails.getGender() != null) {
            preferences.setGender(preferencesDetails.getGender());
        }
        final PreferencesEntity updatedPreferences = preferencesRepository.save(preferences);
        return ResponseEntity.ok(updatedPreferences);
    }
    
    @DeleteMapping("/delete-preferences/{preferencesId}")
    public Map<String, Boolean> deletePreferences(@PathVariable(value = "preferencesId") Integer preferencesId)
    {
     PreferencesEntity preferences = preferencesRepository.findById(preferencesId).get();

        preferencesRepository.delete(preferences);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }



}
