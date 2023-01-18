package com.example.projectIsa.DTO;

import java.time.LocalDateTime;

import com.example.projectIsa.Model.BloodType;

public class ReportDTO {
	
	private Integer patientId;
	private Integer doctorId;
	
	private BloodType bloodType;
	private String noteToDoctor;
	private boolean bakarSulfatLevel;
	private Integer levelHem;
	
	private String bagNumber;
	
	private String puncturePlace;
	private LocalDateTime startTime;
	private LocalDateTime endTime;
	private String reasonForEndingEarly;
	private Integer quantityTaken;
	private Integer needlesUsed;
	
	private String bloodPressure;
	private Integer patientWeight;
	private Integer pulse;
	private String lungs;
	private boolean accepted;
	private String reasonForRejection;
	
	public ReportDTO(Integer patientId, Integer doctorId, BloodType bloodType, String noteToDoctor,
			boolean bakarSulfatLevel, Integer levelHem, String bagNumber, String puncturePlace,
			LocalDateTime startTime, LocalDateTime endTime, String reasonForEndingEarly, Integer quantityTaken,
			String bloodPressure, Integer patientWeight, Integer pulse, String lungs, boolean accepted,
			String reasonForRejection, Integer needlesUsed) {
		super();
		this.patientId = patientId;
		this.doctorId = doctorId;
		this.bloodType = bloodType;
		this.noteToDoctor = noteToDoctor;
		this.bakarSulfatLevel = bakarSulfatLevel;
		this.levelHem = levelHem;
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
		this.accepted = accepted;
		this.reasonForRejection = reasonForRejection;
		this.needlesUsed = needlesUsed;
	}
	public ReportDTO() {
		super();
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
	
	public Integer getLevelHem() {
		return levelHem;
	}
	public void setLevelHem(Integer levelHem) {
		this.levelHem = levelHem;
	}
	public boolean isAccepted() {
		return accepted;
	}
	public void setAccepted(boolean accepted) {
		this.accepted = accepted;
	}
	public String getReasonForRejection() {
		return reasonForRejection;
	}
	public void setReasonForRejection(String reasonForRejection) {
		this.reasonForRejection = reasonForRejection;
	}
	public Integer getNeedlesUsed() {
		return needlesUsed;
	}
	public void setNeedlesUsed(Integer needlesUsed) {
		this.needlesUsed = needlesUsed;
	}
	
	

}
