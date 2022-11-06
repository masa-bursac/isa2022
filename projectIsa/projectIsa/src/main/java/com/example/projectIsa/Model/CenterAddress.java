package com.example.projectIsa.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "center_address")
public class CenterAddress {

	@Transient
    public static final String SEQUENCE_NAME = "post_sequence";
	@Id
    @SequenceGenerator(name = "center_address_id_seq", sequenceName = "center_address_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "center_address_id_seq")
    @Column(name = "id")
	private Integer id;
	private double longitude;
	private double latitude;
	private String street;
	private String houseNumber;
	private String city;
	private String state;
	private String postcode;
	@JsonIgnore
	@OneToOne(mappedBy = "centerAddress")
	private Center center;
	
	
	public CenterAddress() {
		super();
	}
	public CenterAddress(Integer id, double longitude, double latitude, String street, String houseNumber, String city,
			String state, String postcode, Center center) {
		super();
		this.id = id;
		this.longitude = longitude;
		this.latitude = latitude;
		this.street = street;
		this.houseNumber = houseNumber;
		this.city = city;
		this.state = state;
		this.postcode = postcode;
		this.center = center;
	}
	
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
	public Center getCenter() {
		return center;
	}
	public void setCenter(Center center) {
		this.center = center;
	}
	
	
}
