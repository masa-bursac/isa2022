package com.example.projectIsa.Model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("2")
public class SystemAdminstrator extends User {

	private Boolean hasToChangePass;	

	public SystemAdminstrator() {
		super();
	}

	public Boolean getHasToChangePass() {
		return hasToChangePass;
	}

	public void setHasToChangePass(Boolean hasToChangePass) {
		this.hasToChangePass = hasToChangePass;
	}

}
