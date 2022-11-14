package com.example.projectIsa.DTO;

public class AnswerDTO {
	int id;
	Boolean answers;
	int surveyId;
	int regUserId;
	
	public AnswerDTO() {
		super();
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Boolean getAnswers() {
		return answers;
	}
	public void setAnswers(Boolean answers) {
		this.answers = answers;
	}
	public int getSurveyId() {
		return surveyId;
	}
	public void setSurveyId(int surveyId) {
		this.surveyId = surveyId;
	}
	public int getRegUserId() {
		return regUserId;
	}
	public void setRegUserId(int regUserId) {
		this.regUserId = regUserId;
	}
	
}
