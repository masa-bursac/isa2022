package com.example.projectIsa.Model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.example.projectIsa.DTO.CentersDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "center")
public class Center {
	
	@Transient
    public static final String SEQUENCE_NAME = "post_sequence";

	@Id
    @SequenceGenerator(name = "center_id_seq", sequenceName = "center_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "center_id_seq")
    @Column(name = "id")
	private Integer id;
	private String name;
	@JsonIgnore
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="center_address_id", referencedColumnName = "id")
	private CenterAddress centerAddress;
	private String description;
	private Double rating;
	@OneToMany(mappedBy="center", fetch = FetchType.LAZY)
	private List<Appointment> appointments;
	@OneToMany(mappedBy="center")
	private List<CenterAdministrator> staff;
	
		
	public Center(Integer id, String name, CenterAddress centerAddress, String description, Double rating,
			List<Appointment> appointments, List<CenterAdministrator> staff) {
		super();
		this.id = id;
		this.name = name;
		this.centerAddress = centerAddress;
		this.description = description;
		this.rating = rating;
		this.appointments = appointments;
		this.staff = staff;
	}
	public Center() {
		super();
	}
	public Center(CentersDTO centerDTO) {
		this.id = centerDTO.getId();
		this.name = centerDTO.getName();
		this.description = centerDTO.getDescription();
		this.rating = centerDTO.getRating();
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public CenterAddress getCenterAddress() {
		return centerAddress;
	}
	public void setCenterAddress(CenterAddress centerAddress) {
		this.centerAddress = centerAddress;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Double getRating() {
		return rating;
	}
	public void setRating(Double rating) {
		this.rating = rating;
	}
	public List<Appointment> getAppointments() {
		return appointments;
	}
	public void setAppointments(List<Appointment> appointments) {
		this.appointments = appointments;
	}
	public List<CenterAdministrator> getStaff() {
		return staff;
	}
	public void setStaff(List<CenterAdministrator> staff) {
		this.staff = staff;
	}
	
	
}
