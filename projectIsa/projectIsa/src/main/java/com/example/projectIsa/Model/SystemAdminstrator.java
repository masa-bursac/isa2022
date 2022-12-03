package com.example.projectIsa.Model;

import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
@DiscriminatorValue("2")
public class SystemAdminstrator extends User {

	private Boolean hasToChangePass;	

	@OneToMany(mappedBy="systemAdminAnswer")
	private List<Complaint> complaints;
	
	public SystemAdminstrator() {
		super();
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
