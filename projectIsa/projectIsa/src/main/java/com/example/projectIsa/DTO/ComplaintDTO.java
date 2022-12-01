package com.example.projectIsa.DTO;


import com.example.projectIsa.Model.Complaint;

public class ComplaintDTO {

	int id;
	String complaint;
	String answer;
	Integer regUserId;
	String complaintType;
	String userName;
	String userSurname;
	String userEmail;
	String StaffName;
	String StaffSurname;
	String CenterName;
	String complaintDate;
	String answerDate;
	
	int centerId;
	
	public ComplaintDTO() {
		// TODO Auto-generated constructor stub
	}

	public ComplaintDTO(Complaint complaint) {
		this.id = complaint.getId();
		this.complaint = complaint.getComplaint();
		this.answer = complaint.getAnswer();
		this.regUserId = complaint.getRegUser().getId();
		this.userEmail = complaint.getRegUser().getEmail();
		this.userName = complaint.getRegUser().getName();
		this.userSurname = complaint.getRegUser().getSurname();
		this.complaintType = complaint.getType().toString();
		if(complaint.getComplaintDate()!= null) {
		this.complaintDate = complaint.getComplaintDate().toString();
		}
		if(complaint.getAnswerDate()!=null) {
		this.answerDate = complaint.getAnswerDate().toString();
		}
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
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

	public String getComplaintType() {
		return complaintType;
	}

	public void setComplaintType(String complaintType) {
		this.complaintType = complaintType;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserSurname() {
		return userSurname;
	}

	public void setUserSurname(String userSurname) {
		this.userSurname = userSurname;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getStaffName() {
		return StaffName;
	}

	public void setStaffName(String staffName) {
		StaffName = staffName;
	}

	public String getStaffSurname() {
		return StaffSurname;
	}

	public void setStaffSurname(String staffSurname) {
		StaffSurname = staffSurname;
	}

	public String getCenterName() {
		return CenterName;
	}

	public void setCenterName(String centerName) {
		CenterName = centerName;
	}

	public int getCenterId() {
		return centerId;
	}

	public void setCenterId(int centerId) {
		this.centerId = centerId;
	}

	public String getComplaintDate() {
		return complaintDate;
	}

	public void setComplaintDate(String complaintDate) {
		this.complaintDate = complaintDate;
	}

	public String getAnswerDate() {
		return answerDate;
	}

	public void setAnswerDate(String answerDate) {
		this.answerDate = answerDate;
	}

}
