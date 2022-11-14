package com.example.projectIsa.Model;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "appointment")
public class Appointment {

	@Id
    @SequenceGenerator(name = "appointment_id_seq", sequenceName = "appointment_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "appointment_id_seq")
    @Column(name = "id")
	private Integer id;
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name="center_id")
	private Center center;
	@ManyToMany(fetch = FetchType.LAZY)
	@JsonIgnore
	@JoinTable(
			  name = "appointment_center_admin", 
			  joinColumns = @JoinColumn(name = "appointment_id"), 
			  inverseJoinColumns = @JoinColumn(name = "user_id"))
	private List<CenterAdministrator> centerAdmin;
	private LocalDateTime date;
	private Integer duration;
	private boolean taken;
	@ManyToOne
	@JoinColumn(name="registered_user_id", nullable = true)
	private RegisteredUser regUser;
	
	
	public Appointment(Integer id, Center center, List<CenterAdministrator> centerAdmin, LocalDateTime date,
			Integer duration, boolean taken, RegisteredUser regUser) {
		super();
		this.id = id;
		this.center = center;
		this.centerAdmin = centerAdmin;
		this.date = date;
		this.duration = duration;
		this.taken = taken;
		this.regUser = regUser;
	}

	public Appointment() {
		super();
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Center getCenter() {
		return center;
	}
	public void setCenter(Center center) {
		this.center = center;
	}
	public List<CenterAdministrator> getCenterAdmin() {
		return centerAdmin;
	}
	public void setCenterAdmin(List<CenterAdministrator> centerAdmin) {
		this.centerAdmin = centerAdmin;
	}
	public LocalDateTime getDate() {
		return date;
	}
	public void setDate(LocalDateTime date) {
		this.date = date;
	}
	public Integer getDuration() {
		return duration;
	}
	public void setDuration(Integer duration) {
		this.duration = duration;
	}
	public boolean isTaken() {
		return taken;
	}
	public void setTaken(boolean taken) {
		this.taken = taken;
	}
	public RegisteredUser getRegUser() {
		return regUser;
	}
	public void setRegUser(RegisteredUser regUser) {
		this.regUser = regUser;
	}
	
	
}
