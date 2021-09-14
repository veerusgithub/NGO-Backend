package com.capgemini.ngo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "address")
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int addressId;
	
	private String city;
	
	private String state;
	
	private String pin;
	
	private String landmark;
	
	@OneToOne(mappedBy="address")
	@JsonIgnoreProperties("address")
	private Employee employee;
	
	@OneToOne(mappedBy="address")
	@JsonIgnoreProperties("address")
	private Donor donor;
	
	@OneToOne(mappedBy="address")
	@JsonIgnoreProperties("address")
	private NeedyPeople needyPeople;
	
	public Address() {
	}


	public Address(int addressId, String city, String state, String pin, String landmark, Employee employee,
			Donor donor, NeedyPeople needyPeople) {
		this.addressId = addressId;
		this.city = city;
		this.state = state;
		this.pin = pin;
		this.landmark = landmark;
		this.employee = employee;
		this.donor = donor;
		this.needyPeople = needyPeople;
	}



	public int getAddressId() {
		return addressId;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
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

	public String getPin() {
		return pin;
	}

	public void setPin(String pin) {
		this.pin = pin;
	}

	public String getLandmark() {
		return landmark;
	}

	public void setLandmark(String landmark) {
		this.landmark = landmark;
	}

	
	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
	public Donor getDonor() {
		return donor;
	}


	public void setDonor(Donor donor) {
		this.donor = donor;
	}


	public NeedyPeople getNeedyPeople() {
		return needyPeople;
	}


	public void setNeedyPeople(NeedyPeople needyPeople) {
		this.needyPeople = needyPeople;
	}


	@Override
	public String toString() {
		return "Address [addressId=" + addressId + ", city=" + city + ", state=" + state + ", pin=" + pin
				+ ", landmark=" + landmark + ", employee=" + employee + ", donor=" + donor + ", needyPeople="
				+ needyPeople + "]";
	}


}
