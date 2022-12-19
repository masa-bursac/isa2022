package com.example.projectIsa.Controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.projectIsa.Config.JwtUtils;
import com.example.projectIsa.Config.MessageResponse;
import com.example.projectIsa.Config.UserDetailsImpl;
import com.example.projectIsa.DTO.AuthDTO;
import com.example.projectIsa.DTO.JwtResponse;
import com.example.projectIsa.DTO.RegistrationDTO;
import com.example.projectIsa.Model.RegisteredUser;
import com.example.projectIsa.Model.User;
import com.example.projectIsa.Repository.UserRepository;
import com.example.projectIsa.Service.IAuthService;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/auth")
public class AuthController {
	
	private final IAuthService authService;
	
	public AuthController(IAuthService authService) {
        this.authService = authService;
    }
	
	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	UserRepository userRepository;

	@Autowired
	PasswordEncoder encoder;

	@Autowired
	JwtUtils jwtUtils;

	@PostMapping("/login")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody AuthDTO loginRequest) {

		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));

		User user = userRepository.findOneByEmail(loginRequest.getEmail());
		if(user.isActive()) {
			SecurityContextHolder.getContext().setAuthentication(authentication);
			String jwt = jwtUtils.generateJwtToken(authentication);
			
			UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();		
			List<String> roles = userDetails.getAuthorities().stream()
					.map(item -> item.getAuthority())
					.collect(Collectors.toList());
			Boolean hasToChangePass = authService.HasToChangePass(loginRequest);
			return ResponseEntity.ok(new JwtResponse(jwt, 
													 userDetails.getId(), 
													 userDetails.getUsername(), 
													 userDetails.getEmail(), 
													 roles, hasToChangePass));
		} else {
			return ResponseEntity
					.badRequest()
					.body(new MessageResponse("Error: You are not active!"));
		}
	}
	
	@PostMapping("/registration")
	public ResponseEntity<?> registerUser(@Valid @RequestBody RegistrationDTO signUpRequest) {
		
		if (userRepository.existsByEmail(signUpRequest.getEmail())) {
			return ResponseEntity
					.badRequest()
					.body(new MessageResponse("Error: Email already exist!"));
		}
		
		authService.registration(signUpRequest);

		return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
	}
	
	@PutMapping("/continueRegistration")
    public void continueRegistration(@RequestBody int id){
        authService.continueRegistration(id);
    }
}
