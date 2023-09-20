package com.hibernate;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "student_address")
public class Address {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Address_Id")
	private int addressId;
	
	@Column(name = "Pincode")
	private int pincode;
	
	@Transient
	private int notAcolumn;
	
	@Column(name = "Address",length = 150)
	private String address;
	
	@Column(name = "Street")
	private String street;
	
	
	@Column(name = "Image")
	@Lob
	private byte[] image;
	
	@Temporal(TemporalType.DATE)
	private Date date;
	
	public int getNotAcolumn() {
		return notAcolumn;
	}
	public void setNotAcolumn(int notAcolumn) {
		this.notAcolumn = notAcolumn;
	}
	public int getAddressId() {
		return addressId;
	}
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public byte[] getImage() {
		return image;
	}
	public void setImage(byte[] image) {
		this.image = image;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	
	
}
