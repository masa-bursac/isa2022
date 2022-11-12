package com.example.projectIsa.DTO;

import java.time.LocalDateTime;
import java.util.List;

public class FreeAppointmentDTO {
	private Integer centerId;
	private List<Integer> staffIds;
	private LocalDateTime date;
	private Integer duration;
	
	public FreeAppointmentDTO(Integer centerId, List<Integer> staffIds, LocalDateTime date,
			Integer duration) {
		super();
		this.centerId = centerId;
		this.staffIds = staffIds;
		this.date = date;
		this.duration = duration;
	}

	public FreeAppointmentDTO() {
		super();
	}

	public Integer getCenterId() {
		return centerId;
	}

	public void setCenterId(Integer centerId) {
		this.centerId = centerId;
	}

	public List<Integer> getStaffIds() {
		return staffIds;
	}

	public void setStaffIds(List<Integer> staffIds) {
		this.staffIds = staffIds;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public Integer getDuration() {
		return duration;
	}

	public void setDuration(Integer duration) {
		this.duration = duration;
	}
	
}
