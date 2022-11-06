package com.example.projectIsa.DTO;

import java.util.ArrayList;
import java.util.List;

public class CentersDTO {

	int id;
    String name;
    String description;
    Double rating;
    String street;
    String houseNumber;
    String city;
    String state;
    String postcode;
    List<CenterAdministratorDTO> centerAdmins=new ArrayList<CenterAdministratorDTO>();
    
	public CentersDTO() {
		super();
	}
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
	public List<CenterAdministratorDTO> getCenterAdmins() {
		return centerAdmins;
	}
	public void setCenterAdmins(List<CenterAdministratorDTO> centerAdmins) {
		this.centerAdmins = centerAdmins;
	}
    
    
}
