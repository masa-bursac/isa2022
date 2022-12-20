package com.example.projectIsa.DTO;

import com.example.projectIsa.Model.PatientAbilityForAppointmentStatus;

public class AppointmentStatusDTO {
	private Integer id;
	private PatientAbilityForAppointmentStatus patientStatus;
	private Integer patientId;
	
	
	public AppointmentStatusDTO() {
		super();
	}
	public AppointmentStatusDTO(Integer id, PatientAbilityForAppointmentStatus patientStatus,
			Integer patientId) {
		super();
		this.id = id;
		this.patientStatus = patientStatus;
		this.patientId = patientId;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public PatientAbilityForAppointmentStatus getPatientStatus() {
		return patientStatus;
	}
	public void setPatientStatus(PatientAbilityForAppointmentStatus patientStatus) {
		this.patientStatus = patientStatus;
	}
	public Integer getPatientId() {
		return patientId;
	}
	public void setPatientId(Integer patientId) {
		this.patientId = patientId;
	}
	
	
	
}
