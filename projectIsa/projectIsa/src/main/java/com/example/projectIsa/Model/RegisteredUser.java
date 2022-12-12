package com.example.projectIsa.Model;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
@DiscriminatorValue("0")
public class RegisteredUser extends User{

	@OneToMany(mappedBy="regUser")
	private List<Appointment> appointments;
	private LocalDateTime gaveBloodDate;
	private LocalDateTime tookSurvey;
	
	@OneToMany(mappedBy="regUser")
	private List<Complaint> complaints;
	
	private Integer penals;
	
	public RegisteredUser() {}
	
	public RegisteredUser(Integer id, String name, String surname, String email, String password, String phoneNumber,
			String jmbg, Gender gender, Role role, Address address, Education education,
			List<Appointment> appointments,LocalDateTime gaveBloodDate, LocalDateTime tookSurvey, Integer penals) {
		super(id, name, surname, email, password, phoneNumber, jmbg, gender, role, address, education);
		this.appointments = appointments;
		this.gaveBloodDate = gaveBloodDate;
		this.tookSurvey = tookSurvey;
		this.penals = penals;
	}

	public RegisteredUser(Integer id, String name, String surname, String email, String password, String phoneNumber,
			String jmbg, Gender gender, Role role, Address address, Education education) {
		super(id, name, surname, email, password, phoneNumber, jmbg, gender, role, address, education);
	}

	public List<Appointment> getAppointments() {
		return appointments;
	}

	public void setAppointments(List<Appointment> appointments) {
		this.appointments = appointments;
	}

	public List<Complaint> getComplaints() {
		return complaints;
	}

	public void setComplaints(List<Complaint> complaints) {
		this.complaints = complaints;
	}
	public LocalDateTime getGaveBloodDate() {
		return gaveBloodDate;
	}

	public void setGaveBloodDate(LocalDateTime gaveBloodDate) {
		this.gaveBloodDate = gaveBloodDate;
	}

	public LocalDateTime getTookSurvey() {
		return tookSurvey;
	}

	public void setTookSurvey(LocalDateTime tookSurvey) {
		this.tookSurvey = tookSurvey;
	}

	public Integer getPenals() {
		return penals;
	}

	public void setPenals(Integer penals) {
		this.penals = penals;
	}
	
	
	
}
