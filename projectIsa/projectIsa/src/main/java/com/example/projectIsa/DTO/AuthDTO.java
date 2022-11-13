package com.example.projectIsa.DTO;

public class AuthDTO {

	 String email;
	 String password;
	 
	 
	public AuthDTO(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}
	public AuthDTO() {
		super();
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	 
	 
}
