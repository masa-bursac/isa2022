package com.example.projectIsa.Model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@DiscriminatorValue("0")
public class ComplaintCenter extends Complaint {

	@ManyToOne
	@JoinColumn(name="center_id")
	private Center center;
	
	public ComplaintCenter() {
		super();
	}

	public Center getCenter() {
		return center;
	}

	public void setCenter(Center center) {
		this.center = center;
	}

}
