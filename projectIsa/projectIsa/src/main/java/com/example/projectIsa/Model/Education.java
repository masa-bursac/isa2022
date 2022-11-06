package com.example.projectIsa.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "education")
public class Education {
	@Id
    @SequenceGenerator(name = "user_education_id_seq", sequenceName = "user_education_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_education_id_seq")
    @Column(name = "id")
	private Integer id;
	private String education;
	private String profession;
	@JsonIgnore
	@OneToOne(mappedBy = "education")
	private User user;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getEducation() {
		return education;
	}
	public void setEducation(String education) {
		this.education = education;
	}
	public String getProfession() {
		return profession;
	}
	public void setProfession(String profession) {
		this.profession = profession;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	public Education() {
		super();
	}
	public Education(Integer id, String education, String profession, User user) {
		super();
		this.id = id;
		this.education = education;
		this.profession = profession;
		this.user = user;
	}
	
	public Education(String education, String profession) {
		this.education = education;
		this.profession = profession;
	}
}
