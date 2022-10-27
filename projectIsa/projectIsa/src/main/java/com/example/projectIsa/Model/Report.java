package com.example.projectIsa.Model;

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
	private BloodType bloodType;
	private String noteToDoctor;
	private String bs;
	private boolean levelHem;
	private String hemMeter;
	private String trueValue;
	

	public Report() {
		super();
	}
	public Report(Integer id, BloodType bloodType, String noteToDoctor, String bs, boolean levelHem, String hemMeter,
			String trueValue) {
		super();
		this.id = id;
		this.bloodType = bloodType;
		this.noteToDoctor = noteToDoctor;
		this.bs = bs;
		this.levelHem = levelHem;
		this.hemMeter = hemMeter;
		this.trueValue = trueValue;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
	public String getBs() {
		return bs;
	}
	public void setBs(String bs) {
		this.bs = bs;
	}
	public boolean isLevelHem() {
		return levelHem;
	}
	public void setLevelHem(boolean levelHem) {
		this.levelHem = levelHem;
	}
	public String getHemMeter() {
		return hemMeter;
	}
	public void setHemMeter(String hemMeter) {
		this.hemMeter = hemMeter;
	}
	public String getTrueValue() {
		return trueValue;
	}
	public void setTrueValue(String trueValue) {
		this.trueValue = trueValue;
	}
	
	
	
}
