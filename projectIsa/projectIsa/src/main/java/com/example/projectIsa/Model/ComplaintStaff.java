package com.example.projectIsa.Model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@DiscriminatorValue("1")
public class ComplaintStaff extends Complaint {

	@ManyToOne
	@JoinColumn(name="user_id")
	private CenterAdministrator centerAdministrator;
	
	public ComplaintStaff() {
		super();
	}

	public CenterAdministrator getCenterAdministrator() {
		return centerAdministrator;
	}

	public void setCenterAdministrator(CenterAdministrator centerAdministrator) {
		this.centerAdministrator = centerAdministrator;
	}

}
