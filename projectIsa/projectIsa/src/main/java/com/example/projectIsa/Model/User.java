package com.example.projectIsa.Model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;
import javax.persistence.DiscriminatorType;

import com.example.projectIsa.DTO.RegistrationDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;

import static javax.persistence.InheritanceType.SINGLE_TABLE;

import java.util.Locale;

import javax.persistence.CascadeType;

@Entity
@Table(name = "users")
@Inheritance(strategy=SINGLE_TABLE)
@DiscriminatorColumn(name="role", discriminatorType = DiscriminatorType.INTEGER)
public abstract class User {
	@Id
    @SequenceGenerator(name = "user_entity_id_seq", sequenceName = "user_entity_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_entity_id_seq")
    @Column(name = "id")
	private Integer id;
	@Pattern(regexp = "^[A-Z][A-Za-z\\s]{1,25}$")
	private String name;
	@Pattern(regexp = "^[A-Z][A-Za-z\\s]{1,25}$")
	private String surname;
	@Pattern(regexp = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$")
	private String email;
	private String password;
	@Pattern(regexp = "^(\\s*[0-9]+)+$")
	private String phoneNumber;
	@Pattern(regexp = "^[0-9]{13,13}$")
	private String jmbg;
	private Gender gender;
	@Column(insertable = false, updatable = false)
	private Role role;
	//https://www.baeldung.com/jpa-one-to-one
	@JsonIgnore
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="address_id", referencedColumnName = "id")
	private Address address;
	@JsonIgnore
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="education_id", referencedColumnName = "id")
	private Education education;
	
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
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getJmbg() {
		return jmbg;
	}
	public void setJmbg(String jmbg) {
		this.jmbg = jmbg;
	}
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public Education getEducation() {
		return education;
	}
	public void setEducation(Education education) {
		this.education = education;
	}
	public User(Integer id, String name, String surname, String email, String password, String phoneNumber, String jmbg,
			Gender gender, Role role, Address address, Education education) {
		super();
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.password = password;
		this.phoneNumber = phoneNumber;
		this.jmbg = jmbg;
		this.gender = gender;
		this.role = role;
		this.address = address;
		this.education = education;
	}
	public User() {}
}
