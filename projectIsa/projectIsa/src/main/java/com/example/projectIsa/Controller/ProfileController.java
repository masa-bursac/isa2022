package com.example.projectIsa.Controller;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.projectIsa.DTO.CenterAdminPasswordDTO;
import com.example.projectIsa.DTO.UpdateDTO;
import com.example.projectIsa.Service.IProfileService;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/profile")
public class ProfileController {
	
	private final IProfileService profileService;

    public ProfileController(IProfileService profileService) {
    	this.profileService = profileService;
    }

    @GetMapping("/getProfile/{email}")
    @PreAuthorize("hasRole('ROLE_REGISTERED') or hasRole('ROLE_CENTERADMIN')")
    public UpdateDTO getProfile(@PathVariable String email){
        return profileService.getProfile(email);
    }
    
    @PutMapping("/update")
    @PreAuthorize("hasRole('ROLE_REGISTERED') or hasRole('ROLE_CENTERADMIN')")
	public ResponseEntity edit(@Valid @RequestBody UpdateDTO userInfo) {	 
    	try {
        	return new ResponseEntity(profileService.update(userInfo), HttpStatus.OK);
        } catch (Exception e) {
        	return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
	}
    
    @PutMapping("/changeCenterAdminPassword")
	public Boolean changeCenterAdminPassword(@RequestBody CenterAdminPasswordDTO admin) {
    	return profileService.changeCenterAdminPassword(admin);	      
	}

    @GetMapping("/getUsers")
    @PreAuthorize("hasRole('ROLE_SYSTEMADMIN') or hasRole('ROLE_CENTERADMIN')")
    public ResponseEntity getUsers() {
    	return new ResponseEntity(profileService.getUsers(), HttpStatus.OK);
    }

}
