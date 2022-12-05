package com.example.projectIsa.DTO;

import java.time.LocalDateTime;

public class ScheduleAppointmentDTO {
	
	private LocalDateTime date;
	private Integer userId;
	private Integer centerId;
	
	
	public ScheduleAppointmentDTO() {
		super();
	}


	public ScheduleAppointmentDTO(LocalDateTime date, Integer userId, Integer centerId) {
		super();
		this.date = date;
		this.userId = userId;
		this.centerId = centerId;
	}


	public LocalDateTime getDate() {
		return date;
	}


	public void setDate(LocalDateTime date) {
		this.date = date;
	}


	public Integer getUserId() {
		return userId;
	}


	public void setUserId(Integer userId) {
		this.userId = userId;
	}


	public Integer getCenterId() {
		return centerId;
	}


	public void setCenterId(Integer centerId) {
		this.centerId = centerId;
	}
	
	

}
