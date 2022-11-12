package com.example.projectIsa.Controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.projectIsa.DTO.RegistrationDTO;
import com.example.projectIsa.Service.IAuthService;

@RestController
@RequestMapping("/auth")
public class AuthController {
	
	private final IAuthService authService;
	
	public AuthController(IAuthService authService) {
        this.authService = authService;
    }
	
	@PostMapping("/registration")
    public Boolean registration(@RequestBody RegistrationDTO registrationDTO){
    	return authService.registration(registrationDTO);
    }
}
