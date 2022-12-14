package com.example.projectIsa.Model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "report")
public class Report {

	@Id
    @SequenceGenerator(name = "report_id_seq", sequenceName = "report_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "report_id_seq")
    @Column(name = "id")
	private Integer id;
	private Integer patientId;
	private Integer doctorId;
	
	private BloodType bloodType;
	private String noteToDoctor;
	private boolean bakarSulfatLevel;
	private double levelHemoglobin;
	
	private String bagNumber;
	
	private String puncturePlace;
	private LocalDateTime startTime;
	private LocalDateTime endTime;
	private String reasonForEndingEarly;
	private Integer quantityTaken;
	
	private String bloodPressure;
	private Integer patientWeight;
	private Integer pulse;
	private String lungs;
	private boolean isAccepted;
	private String reasonForRejection;
	

	public Report() {
		super();
	}


	public Report(Integer id, Integer patientId, Integer doctorId, BloodType bloodType, String noteToDoctor,
			boolean bakarSulfatLevel, double levelHemoglobin, String bagNumber, String puncturePlace,
			LocalDateTime startTime, LocalDateTime endTime, String reasonForEndingEarly, Integer quantityTaken,
			String bloodPressure, Integer patientWeight, Integer pulse, String lungs, boolean isAccepted,
			String reasonForRejection) {
		super();
		this.id = id;
		this.patientId = patientId;
		this.doctorId = doctorId;
		this.bloodType = bloodType;
		this.noteToDoctor = noteToDoctor;
		this.bakarSulfatLevel = bakarSulfatLevel;
		this.levelHemoglobin = levelHemoglobin;
		this.bagNumber = bagNumber;
		this.puncturePlace = puncturePlace;
		this.startTime = startTime;
		this.endTime = endTime;
		this.reasonForEndingEarly = reasonForEndingEarly;
		this.quantityTaken = quantityTaken;
		this.bloodPressure = bloodPressure;
		this.patientWeight = patientWeight;
		this.pulse = pulse;
		this.lungs = lungs;
		this.isAccepted = isAccepted;
		this.reasonForRejection = reasonForRejection;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public Integer getPatientId() {
		return patientId;
	}


	public void setPatientId(Integer patientId) {
		this.patientId = patientId;
	}


	public Integer getDoctorId() {
		return doctorId;
	}


	public void setDoctorId(Integer doctorId) {
		this.doctorId = doctorId;
	}


	public BloodType getBloodType() {
		return bloodType;
	}


	public void setBloodType(BloodType bloodType) {
		this.bloodType = bloodType;
	}


	public String getNoteToDoctor() {
		return noteToDoctor;
	}


	public void setNoteToDoctor(String noteToDoctor) {
		this.noteToDoctor = noteToDoctor;
	}


	public boolean isBakarSulfatLevel() {
		return bakarSulfatLevel;
	}


	public void setBakarSulfatLevel(boolean bakarSulfatLevel) {
		this.bakarSulfatLevel = bakarSulfatLevel;
	}


	public double getLevelHemoglobin() {
		return levelHemoglobin;
	}


	public void setLevelHemoglobin(double levelHemoglobin) {
		this.levelHemoglobin = levelHemoglobin;
	}


	public String getBagNumber() {
		return bagNumber;
	}


	public void setBagNumber(String bagNumber) {
		this.bagNumber = bagNumber;
	}


	public String getPuncturePlace() {
		return puncturePlace;
	}


	public void setPuncturePlace(String puncturePlace) {
		this.puncturePlace = puncturePlace;
	}


	public LocalDateTime getStartTime() {
		return startTime;
	}


	public void setStartTime(LocalDateTime startTime) {
		this.startTime = startTime;
	}


	public LocalDateTime getEndTime() {
		return endTime;
	}


	public void setEndTime(LocalDateTime endTime) {
		this.endTime = endTime;
	}


	public String getReasonForEndingEarly() {
		return reasonForEndingEarly;
	}


	public void setReasonForEndingEarly(String reasonForEndingEarly) {
		this.reasonForEndingEarly = reasonForEndingEarly;
	}


	public Integer getQuantityTaken() {
		return quantityTaken;
	}


	public void setQuantityTaken(Integer quantityTaken) {
		this.quantityTaken = quantityTaken;
	}


	public String getBloodPressure() {
		return bloodPressure;
	}


	public void setBloodPressure(String bloodPressure) {
		this.bloodPressure = bloodPressure;
	}


	public Integer getPatientWeight() {
		return patientWeight;
	}


	public void setPatientWeight(Integer patientWeight) {
		this.patientWeight = patientWeight;
	}


	public Integer getPulse() {
		return pulse;
	}


	public void setPulse(Integer pulse) {
		this.pulse = pulse;
	}


	public String getLungs() {
		return lungs;
	}


	public void setLungs(String lungs) {
		this.lungs = lungs;
	}


	public boolean isAccepted() {
		return isAccepted;
	}


	public void setAccepted(boolean isAccepted) {
		this.isAccepted = isAccepted;
	}


	public String getReasonForRejection() {
		return reasonForRejection;
	}


	public void setReasonForRejection(String reasonForRejection) {
		this.reasonForRejection = reasonForRejection;
	}
	
	
	
}
