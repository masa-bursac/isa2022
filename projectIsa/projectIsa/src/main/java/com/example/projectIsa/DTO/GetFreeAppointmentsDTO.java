package com.example.projectIsa.DTO;

import java.time.LocalDateTime;

public class GetFreeAppointmentsDTO {
	
	private Integer id;
	private Integer duration;
	private LocalDateTime date;
		
	public GetFreeAppointmentsDTO() {
		super();
	}

	public GetFreeAppointmentsDTO(Integer id, Integer duration, LocalDateTime date) {
		super();
		this.id = id;
		this.duration = duration;
		this.date = date;
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
	
	
	

}
