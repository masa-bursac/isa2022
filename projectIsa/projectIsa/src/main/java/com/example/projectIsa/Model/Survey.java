package com.example.projectIsa.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "survey")
public class Survey {

	@Id
    @SequenceGenerator(name = "survey_id_seq", sequenceName = "survey_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "survey_id_seq")
    @Column(name = "id")
	private Integer id;
	private String question;
	
	
	public Survey() {
		super();
	}
	public Survey(Integer id, String question) {
		super();
		this.id = id;
		this.question = question;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	
	
}
