package com.example.projectIsa.Model;

import static javax.persistence.InheritanceType.SINGLE_TABLE;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "complaints")
@Inheritance(strategy=SINGLE_TABLE)
@DiscriminatorColumn(name="complaint_type", discriminatorType = DiscriminatorType.INTEGER)
public abstract class Complaint {

	@Id
    @SequenceGenerator(name = "complaint_id_seq", sequenceName = "complaint_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "complaint_id_seq")
    @Column(name = "id")
	private Integer id;
	private String complaint;
	private String answer;
	private LocalDateTime complaintDate;
	private LocalDateTime answerDate;
	@ManyToOne
	@JoinColumn(name="registered_user_id", nullable = true)
	private RegisteredUser regUser;
	
	@Column(name="complaint_type", insertable = false, updatable = false)
	private ComplaintType complaintType;
	
	@ManyToOne
	@JoinColumn(name="system_adminstrator_id", nullable = true)
	private SystemAdminstrator systemAdminAnswer;
	
	public Complaint() {
	}
	public Complaint(Integer id, String complaint, String answer) {
		super();
		this.id = id;
		this.complaint = complaint;
		this.answer = answer;
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
	public ComplaintType getType() {
		return complaintType;
	}
	public void setType(ComplaintType type) {
		this.complaintType = type;
	}
	public RegisteredUser getRegUser() {
		return regUser;
	}
	public void setRegUser(RegisteredUser regUser) {
		this.regUser = regUser;
	}
	public ComplaintType getComplaintType() {
		return complaintType;
	}
	public void setComplaintType(ComplaintType complaintType) {
		this.complaintType = complaintType;
	}
	public LocalDateTime getComplaintDate() {
		return complaintDate;
	}
	public void setComplaintDate(LocalDateTime complaintDate) {
		this.complaintDate = complaintDate;
	}
	public LocalDateTime getAnswerDate() {
		return answerDate;
	}
	public void setAnswerDate(LocalDateTime answerDate) {
		this.answerDate = answerDate;
	}
	public SystemAdminstrator getSystemAdminAnswer() {
		return systemAdminAnswer;
	}
	public void setSystemAdminAnswer(SystemAdminstrator systemAdminAnswer) {
		this.systemAdminAnswer = systemAdminAnswer;
	}
	
}
