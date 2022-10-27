package com.example.projectIsa.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "complaint")
public class Complaint {

	@Id
    @SequenceGenerator(name = "complaint_id_seq", sequenceName = "complaint_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "complaint_id_seq")
    @Column(name = "id")
	private Integer id;
	private String complaint;
	private String answer;
	private Integer regUserId;
	
	
	
	public Complaint() {
		super();
	}
	public Complaint(Integer id, String complaint, String answer, Integer regUserId) {
		super();
		this.id = id;
		this.complaint = complaint;
		this.answer = answer;
		this.regUserId = regUserId;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getComplaint() {
		return complaint;
	}
	public void setComplaint(String complaint) {
		this.complaint = complaint;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public Integer getRegUserId() {
		return regUserId;
	}
	public void setRegUserId(Integer regUserId) {
		this.regUserId = regUserId;
	}
	
	
}
