package com.example.projectIsa.DTO;

public class ComplaintAnswerDTO {

	int id;
	String answer;
	int adminAnswerId;
	
	public ComplaintAnswerDTO() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public int getAdminAnswerId() {
		return adminAnswerId;
	}

	public void setAdminAnswerId(int adminAnswerId) {
		this.adminAnswerId = adminAnswerId;
	}

}
