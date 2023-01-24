package com.example.projectIsa.DTO;

import java.util.List;

public class JwtResponse {
	private String token;
	private String type = "Bearer";
	private Integer id;
	private String username;
	private String email;
	private List<String> roles;
	private Boolean hasToChangePass;
	private Boolean isActive;

	public JwtResponse(String accessToken, Integer id, String username, String email, List<String> roles, Boolean hasToChangePass,
			Boolean isActive) {
		this.token = accessToken;
		this.id = id;
		this.username = username;
		this.email = email;
		this.roles = roles;
		this.hasToChangePass = hasToChangePass;
		this.isActive = isActive;
	}

	public String getAccessToken() {
		return token;
	}

	public void setAccessToken(String accessToken) {
		this.token = accessToken;
	}

	public String getTokenType() {
		return type;
	}

	public void setTokenType(String tokenType) {
		this.type = tokenType;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<String> getRoles() {
		return roles;
	}

	public boolean isHasToChangePass() {
		return hasToChangePass;
	}

	public void setHasToChangePass(boolean hasToChangePass) {
		this.hasToChangePass = hasToChangePass;
	}

	public Boolean isActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}
	
}
