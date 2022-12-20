package com.example.projectIsa.DTO;

import java.time.LocalDateTime;

import com.example.projectIsa.Model.Appointment;

public class TakenAppointmentDTO {

	private Integer id;
	private Integer duration;
	private LocalDateTime date;
	private String userName;
	private String userSurname;
	private String email;
	
	public TakenAppointmentDTO() {
		// TODO Auto-generated constructor stub
	}

	public TakenAppointmentDTO(Appointment appointment) {
		this.id = appointment.getId();
		this.duration = appointment.getDuration();
		this.date = appointment.getDate();
		this.userName = appointment.getRegUser().getName();
		this.userSurname = appointment.getRegUser().getSurname();
		this.email = appointment.getRegUser().getEmail();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getDuration() {
		return duration;
	}

	public void setDuration(Integer duration) {
		this.duration = duration;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String user) {
		this.userName = user;
	}

	public String getUserSurname() {
		return userSurname;
	}

	public void setUserSurname(String userSurname) {
		this.userSurname = userSurname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}
