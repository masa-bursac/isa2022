package com.example.projectIsa.DTO;

public class ResponseDTO {
	
	String message;
	
	
	public ResponseDTO() {
		super();
	}

	public ResponseDTO(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	

}
