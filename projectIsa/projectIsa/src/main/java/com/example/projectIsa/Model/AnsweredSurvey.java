package com.example.projectIsa.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "answered_survey")
public class AnsweredSurvey {

	@Id
    @SequenceGenerator(name = "answered_survey_id_seq", sequenceName = "answered_survey_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "answered_survey_id_seq")
    @Column(name = "id")
	private Integer id;
	private boolean answers;
	private Integer surveyId;
	private Integer regUserId;
	
	public AnsweredSurvey() {
		super();
	}
	public AnsweredSurvey(Integer id, boolean answers, Integer surveyId, Integer regUserId) {
		super();
		this.id = id;
		this.answers = answers;
		this.surveyId = surveyId;
		this.regUserId = regUserId;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
	public Integer getRegUserId() {
		return regUserId;
	}
	public void setRegUserId(Integer regUserId) {
		this.regUserId = regUserId;
	}
	
	
	
}
