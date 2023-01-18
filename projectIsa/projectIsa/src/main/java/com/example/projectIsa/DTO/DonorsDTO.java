package com.example.projectIsa.DTO;

import java.time.LocalDateTime;

import com.example.projectIsa.Model.User;

public class DonorsDTO {
	
	int id;
    String name;
    String surname;
    String email;
    String phoneNumber;
    String jmbg;
    String gender;
    String street;
    String houseNumber;
    String city;
    String state;
    String postcode;
    String education;
    String profession;
    String role;
    LocalDateTime gaveBlood;

	public int getId() {
		return id;
	}
	public void setId(int id) {
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
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getHouseNumber() {
		return houseNumber;
	}
	public void setHouseNumber(String houseNumber) {
		this.houseNumber = houseNumber;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getPostcode() {
		return postcode;
	}
	public void setPostcode(String postcode) {
		this.postcode = postcode;
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
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	public LocalDateTime getGaveBlood() {
		return gaveBlood;
	}
	public void setGaveBlood(LocalDateTime gaveBlood) {
		this.gaveBlood = gaveBlood;
	}
	public DonorsDTO() {
		// TODO Auto-generated constructor stub
	}
	public DonorsDTO(User user) {
		this.id = user.getId();
		this.name = user.getName();
		this.surname = user.getSurname();
		this.email = user.getEmail();
		this.phoneNumber = user.getPhoneNumber();
		this.jmbg = user.getJmbg();
		this.gender = user.getGender().toString();
		this.role = user.getRole().toString();
		if(user.getAddress()!=null) {
			this.street = user.getAddress().getStreet();
			this.houseNumber = user.getAddress().getHouseNumber();
			this.city = user.getAddress().getCity();
			this.state = user.getAddress().getState();
			this.postcode = user.getAddress().getPostcode();
		}
		if(user.getEducation()!=null) {
			this.education = user.getEducation().getEducation();
			this.profession = user.getEducation().getProfession();
		}
	}

}
