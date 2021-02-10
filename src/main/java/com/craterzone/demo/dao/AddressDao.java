package com.craterzone.demo.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.craterzone.demo.model.User;

@Entity
@Table(name = "address")
public class AddressDao {

	@Id
	private int id;
	@Column
	private String houseNo;
	@Column
	private String street;
	@Column
	private String landmark;
	@Column
	private String city;
	@Column
	private String state;
	@Column
	private String country;
	@Column
	private int pincode;
	private String latitude;
	private String longitude;
	@OneToOne
	@JoinColumn(name ="user_id")
	private UserDao user;
	
	public AddressDao(@NotNull String houseNo, @NotNull String street, @NotNull String landmark, @NotNull String city,
			@NotNull String state, @NotNull String country, @NotNull int pincode, String latitude, String longitude) {
		super();
		this.houseNo = houseNo;
		this.street = street;
		this.landmark = landmark;
		this.city = city;
		this.state = state;
		this.country = country;
		this.pincode = pincode;
		this.latitude = latitude;
		this.longitude = longitude;
	}
	public String getHouseNo() {
		return houseNo;
	}
	public void setHouseNo(String houseNo) {
		this.houseNo = houseNo;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getLandmark() {
		return landmark;
	}
	public void setLandmark(String landmark) {
		this.landmark = landmark;
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
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	@Override
	public String toString() {
		return "AddressDao [houseNo=" + houseNo + ", street=" + street + ", landmark=" + landmark + ", city=" + city
				+ ", state=" + state + ", country=" + country + ", pincode=" + pincode + ", latitude=" + latitude
				+ ", longitude=" + longitude + "]";
	}
	
	
}
