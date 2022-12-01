package com.example.projectIsa.Model;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import java.util.List;

import com.example.projectIsa.DTO.CenterAdministratorDTO;
import com.example.projectIsa.DTO.CentersDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@DiscriminatorValue("1")
public class CenterAdministrator extends User{

	@ManyToOne
	@JoinColumn(name="center_id")
	private Center center;
	@ManyToMany(mappedBy = "centerAdmin", fetch = FetchType.LAZY)
	private List<Appointment> appointment;
	private Boolean hasToChangePass;	
	@OneToMany(mappedBy="centerAdministrator")
	private List<ComplaintStaff> complaints;
			
	public CenterAdministrator() {
		super();
	}

	public CenterAdministrator(Integer id, String name, String surname, String email, String password,
			String phoneNumber, String jmbg, Gender gender, Role role, Address address, Education education,
			Center center, List<Appointment> appointment, boolean hasToChangePass) {
		super(id, name, surname, email, password, phoneNumber, jmbg, gender, role, address, education);
		this.center = center;
		this.appointment = appointment;
		this.hasToChangePass = hasToChangePass;
	}
	public CenterAdministrator(Integer id, String name, String surname, String email, String password,
			String phoneNumber, String jmbg, Gender gender, Role role, Address address, Education education) {
		super(id, name, surname, email, password, phoneNumber, jmbg, gender, role, address, education);
	}
	public CenterAdministrator(CenterAdministratorDTO centerAdminDTO) {
		this.setId(centerAdminDTO.getId());
		this.setName(centerAdminDTO.getName());
		this.setSurname(centerAdminDTO.getSurname());
		this.setEmail(centerAdminDTO.getEmail());
		this.setPhoneNumber(centerAdminDTO.getPhoneNumber());
		this.setJmbg(centerAdminDTO.getJmbg());
	}
	public Center getCenter() {
		return center;
	}
	public void setCenter(Center center) {
		this.center = center;
	}
	public List<Appointment> getAppointment() {
		return appointment;
	}
	public void setAppointment(List<Appointment> appointment) {
		this.appointment = appointment;
	}
	public Boolean isHasToChangePass() {
		return hasToChangePass;
	}
	public void setHasToChangePass(Boolean hasToChangePass) {
		this.hasToChangePass = hasToChangePass;
	}

	public List<ComplaintStaff> getComplaints() {
		return complaints;
	}

	public void setComplaints(List<ComplaintStaff> complaints) {
		this.complaints = complaints;
	}
}
