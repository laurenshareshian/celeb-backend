package net.celebapp.matchmaker;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/login")
public class LoginController {
	
	@Autowired
	LoginRepository loginRepository;

    @Autowired
    ProfileRepository profileRepository;


	@GetMapping("/get-all-logins")
	public List<LoginEntity> getAllLogin(){
		List<LoginEntity> allLoginlist = loginRepository.findAll();
		return allLoginlist;
		
	}

	@GetMapping(value = "/get-login/{emailId}")
	public LoginEntity getLoginByEmailId(@PathVariable("emailId") Integer emailId)
      
	{
		LoginEntity loginEntity = loginRepository.findById(emailId).get();
		
		return loginEntity;
	}
	
    @PostMapping(value = "/create-logins")
    public LoginEntity createLogin(@RequestBody LoginEntity login) {

    	 LoginEntity savedLogin = loginRepository.save(login);

    	 return savedLogin;
    }


    @PostMapping(value = "/login")
    public ProfileEntity Login(@RequestBody LoginEntity login) {
        System.out.println("login"+login);
        String email = login.getEmail();
        String password = login.getPassword();
        List<LoginEntity> loginEntity = loginRepository.findLoginByEmailAndPassword(email, password);
        Integer email_id = loginEntity.get(0).getEmailId();
        ProfileEntity profileEntity = profileRepository.findProfileByFkEmailId(email_id);
        System.out.println(profileEntity);
        return profileEntity;
    }

    @PutMapping("/update-logins/{emailId}")
    public ResponseEntity<LoginEntity> updateLogin(@PathVariable(value = "emailId") Integer loginId,
          @RequestBody LoginEntity loginDetails) {
        LoginEntity login = loginRepository.findById(loginId).get();

        login.setEmailId(loginDetails.getEmailId());
        login.setPassword(loginDetails.getPassword());
        login.setEmail(loginDetails.getEmail());
        final LoginEntity updatedLogin = loginRepository.save(login);
        return ResponseEntity.ok(updatedLogin);
    }
    
    @DeleteMapping("/delete-logins/{emailId}")
    public Map<String, Boolean> deleteLogin(@PathVariable(value = "emailId") Integer loginId)
    {
     LoginEntity login = loginRepository.findById(loginId).get();

        loginRepository.delete(login);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }



}
