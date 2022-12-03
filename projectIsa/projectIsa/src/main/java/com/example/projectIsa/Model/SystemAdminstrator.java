package com.example.projectIsa.Model;

import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.example.projectIsa.DTO.CenterAdministratorDTO;

@Entity
@DiscriminatorValue("2")
public class SystemAdminstrator extends User {

	private Boolean hasToChangePass;	

	@OneToMany(mappedBy="systemAdminAnswer")
	private List<Complaint> complaints;
	
	public SystemAdminstrator() {
		super();
	}

	public SystemAdminstrator(CenterAdministratorDTO adminDTO) {
		this.setId(adminDTO.getId());
		this.setName(adminDTO.getName());
		this.setSurname(adminDTO.getSurname());
		this.setEmail(adminDTO.getEmail());
		this.setPhoneNumber(adminDTO.getPhoneNumber());
		this.setJmbg(adminDTO.getJmbg());
	}

	public Boolean getHasToChangePass() {
		return hasToChangePass;
	}

	public void setHasToChangePass(Boolean hasToChangePass) {
		this.hasToChangePass = hasToChangePass;
	}

	public List<Complaint> getComplaints() {
		return complaints;
	}

	public void setComplaints(List<Complaint> complaints) {
		this.complaints = complaints;
	}

}
