package com.example.projectIsa.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "medical_equipment")
public class MedicalEquipment {

	@Id
    @SequenceGenerator(name = "medical_equipment_id_seq", sequenceName = "medical_equipment_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "medical_equipment_id_seq")
    @Column(name = "id")
	private Integer id;
	private double quantity;
	private BloodType bloodType;
	
	
	
	public MedicalEquipment() {
		super();
	}
	public MedicalEquipment(Integer id, double quantity, BloodType bloodType) {
		super();
		this.id = id;
		this.quantity = quantity;
		this.bloodType = bloodType;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public double getQuantity() {
		return quantity;
	}
	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}
	public BloodType getBloodType() {
		return bloodType;
	}
	public void setBloodType(BloodType bloodType) {
		this.bloodType = bloodType;
	}
	
	
}
