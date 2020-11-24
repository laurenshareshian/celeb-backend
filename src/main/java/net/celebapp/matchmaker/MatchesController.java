package net.celebapp.matchmaker;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
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

import javax.transaction.Transactional;

@RestController
@RequestMapping("/api/matches")
public class MatchesController {
	
	@Autowired
	MatchesRepository matchesRepository;
	
	@GetMapping("/get-all-matches")
	public List<MatchesEntity> getAllMatches(){
		List<MatchesEntity> allMatchesList = matchesRepository.findAll();
		return allMatchesList;
		
	}
	
	@GetMapping("/get-matches/{profileId}")
	public MatchesEntity getMatchesById(@PathVariable(value = "profileId") Integer profileId)
      
	{
		MatchesEntity matchesEntity = matchesRepository.findById(profileId).get();
		return matchesEntity;
	}
	
    @PostMapping("/create-matches")
    public String createMatches(@RequestBody MatchesEntity match) {

		matchesRepository.addMatch(match.getFkProfileId(), match.getFkDreamProfileId(), match.getMessageToDreamProfile());
		return "add match success";
    }
    
    @DeleteMapping("/delete-matches/{profileId}")
    public Map<String, Boolean> deleteMatches(@PathVariable(value = "profileId") Integer profileId)
    {
     MatchesEntity matches = matchesRepository.findById(profileId).get();

        matchesRepository.delete(matches);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

	@DeleteMapping("/unlike/{profileId}/{dreamProfileId}")
	public String unlike(@PathVariable(value = "profileId") Integer profileId,
										   @PathVariable(value = "dreamProfileId") Integer dreamProfileId)

	{
		matchesRepository.unlike(profileId, dreamProfileId);
		return "delete successful";
	}
}
