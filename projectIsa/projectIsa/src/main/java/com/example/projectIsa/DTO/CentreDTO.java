package com.example.projectIsa.DTO;

import java.util.List;

import javax.persistence.OneToMany;

import com.example.projectIsa.Model.Appointment;
import com.example.projectIsa.Model.CenterAddress;
import com.example.projectIsa.Model.CenterAdministrator;

public class CentreDTO {
	private Integer id;
	private String name;
	private CenterAddress centerAddress;
	private String description;
	private Double rating;
	private List<Appointment> appointments;
	private List<CenterAdministrator> staff;
	
	public CentreDTO(Integer id, String name, CenterAddress centerAddress, String description, Double rating,
			List<Appointment> appointments, List<CenterAdministrator> staff) {
		super();
		this.id = id;
		this.name = name;
		this.centerAddress = centerAddress;
		this.description = description;
		this.rating = rating;
		this.appointments = appointments;
		this.staff = staff;
	}

	public CentreDTO() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public CenterAddress getCenterAddress() {
		return centerAddress;
	}

	public void setCenterAddress(CenterAddress centerAddress) {
		this.centerAddress = centerAddress;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getRating() {
		return rating;
	}

	public void setRating(Double rating) {
		this.rating = rating;
	}

	public List<Appointment> getAppointments() {
		return appointments;
	}

	public void setAppointments(List<Appointment> appointments) {
		this.appointments = appointments;
	}

	public List<CenterAdministrator> getStaff() {
		return staff;
	}

	public void setStaff(List<CenterAdministrator> staff) {
		this.staff = staff;
	}
	
	
}
