package com.example.projectIsa.DTO;

public class SurveyDTO {
	int id;
    String question;
    
	public SurveyDTO() {
		super();
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
    
}
