package com.example.projectIsa.Model;

import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
@DiscriminatorValue("0")
public class RegisteredUser extends User{

	@OneToMany(mappedBy="regUser")
	private List<Appointment> appointments;
	
	@OneToMany(mappedBy="regUser")
	private List<Complaint> complaints;
	
	public RegisteredUser() {}
	
	public RegisteredUser(Integer id, String name, String surname, String email, String password, String phoneNumber,
			String jmbg, Gender gender, Role role, Address address, Education education,
			List<Appointment> appointments) {
		super(id, name, surname, email, password, phoneNumber, jmbg, gender, role, address, education);
		this.appointments = appointments;
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
	
	
}
