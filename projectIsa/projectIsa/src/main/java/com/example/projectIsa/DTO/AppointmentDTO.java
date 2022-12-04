package com.example.projectIsa.DTO;

import java.time.LocalDateTime;
import java.util.List;

import com.example.projectIsa.Model.Appointment;
import com.example.projectIsa.Model.CenterAdministrator;

public class AppointmentDTO {
	private Integer id;
	private Integer duration;
	private LocalDateTime date;
	private List<CenterAdministrator> staff;
	
	public AppointmentDTO() {
		super();
	}
	public AppointmentDTO(Integer id, Integer duration, LocalDateTime date, List<CenterAdministrator> staff) {
		super();
		this.id = id;
		this.duration = duration;
		this.date = date;
		this.staff = staff;
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
	public List<CenterAdministrator> getStaff() {
		return staff;
	}
	public void setStaff(List<CenterAdministrator> staff) {
		this.staff = staff;
	}
	
	
}
