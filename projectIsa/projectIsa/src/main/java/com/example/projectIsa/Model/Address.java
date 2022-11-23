package com.example.projectIsa.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "address")
public class Address {
	@Id
    @SequenceGenerator(name = "user_address_id_seq", sequenceName = "user_address_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_address_id_seq")
    @Column(name = "id")
	private Integer id;
	private double longitude;
	private double latitude;
	@Pattern(regexp = "^[A-Z][A-Za-z\\s]*$")
	private String street;
	@Pattern(regexp = "^[A-Za-z0-9]*$")
	private String houseNumber;
	@Pattern(regexp = "^[A-Z][A-Za-z\\s]*$")
	private String city;
	@Pattern(regexp = "^[A-Z][A-Za-z\\s]*$")
	private String state;
	@Pattern(regexp = "^[0-9]{1,13}$")
	private String postcode;
	@JsonIgnore
	@OneToOne(mappedBy = "address")
	private User user;
		
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
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
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Address(Integer id, double longitude, double latitude, String street, String houseNumber, String city,
			String state, String postcode, User user) {
		super();
		this.id = id;
		this.longitude = longitude;
		this.latitude = latitude;
		this.street = street;
		this.houseNumber = houseNumber;
		this.city = city;
		this.state = state;
		this.postcode = postcode;
		this.user = user;
	}
	public Address() {}
	
}
