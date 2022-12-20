package com.example.projectIsa.DTO;

public class AnsweredSurveyDTO {
	private boolean answers;
	private Integer surveyId;
	private String question;
	
	
	public AnsweredSurveyDTO() {
		super();
	}
	public AnsweredSurveyDTO(boolean answers, Integer surveyId, String question) {
		super();
		this.answers = answers;
		this.surveyId = surveyId;
		this.question = question;
	}
	
	public boolean isAnswers() {
		return answers;
	}
	public void setAnswers(boolean answers) {
		this.answers = answers;
	}
	public Integer getSurveyId() {
		return surveyId;
	}
	public void setSurveyId(Integer surveyId) {
		this.surveyId = surveyId;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	
	
	
}
