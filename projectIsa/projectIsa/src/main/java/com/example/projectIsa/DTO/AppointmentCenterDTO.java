package com.example.projectIsa.DTO;

import java.time.LocalDateTime;

public class AppointmentCenterDTO {

	private Integer id;
	private LocalDateTime date;
	private Integer duration;
	private String name;
	private String description;
	private Double rating;
	private String street;
	private String houseNumber;
	private String city;
	private String state;
	private String postcode;
	
	
	public AppointmentCenterDTO() {
		super();
	}

	public AppointmentCenterDTO(Integer id, LocalDateTime date, Integer duration, String name, String description,
			Double rating, String street, String houseNumber, String city, String state, String postcode) {
		super();
		this.id = id;
		this.date = date;
		this.duration = duration;
		this.name = name;
		this.description = description;
		this.rating = rating;
		this.street = street;
		this.houseNumber = houseNumber;
		this.city = city;
		this.state = state;
		this.postcode = postcode;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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
	
	
	
}
