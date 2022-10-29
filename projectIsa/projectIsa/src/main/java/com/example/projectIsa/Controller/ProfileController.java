package com.example.projectIsa.Controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.projectIsa.DTO.UpdateDTO;
import com.example.projectIsa.Service.IProfileService;

@RestController
@RequestMapping("/profile")
public class ProfileController {
	
	private final IProfileService profileService;

    public ProfileController(IProfileService profileService) {
    	this.profileService = profileService;
    }

    @GetMapping("/getProfile/{email}")
    public UpdateDTO getProfile(@PathVariable String email){
        return profileService.getProfile(email);
    }
}
