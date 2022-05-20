package com.capg.model;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;
//Modelclass

@Document(collection="PlaceDetails") 
public class PlaceDetails {
	
	
	@Id //primary key
	private int pincode;
	private String destination;
	private String famouse_place;
	
	//default constructor
	public PlaceDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	//Parameterized constructor
	public PlaceDetails(int pincode, String destination, String famouse_place) {
		super();
		this.pincode = pincode;
		this.destination = destination;
		this.famouse_place = famouse_place;
	}

	//Getter & Setter

	public int getPincode() {
		return pincode;
	}


	public void setPincode(int pincode) {
		this.pincode = pincode;
	}


	public String getDestination() {
		return destination;
	}


	public void setDestination(String destination) {
		this.destination = destination;
	}


	public String getFamouse_place() {
		return famouse_place;
	}


	public void setFamouse_place(String famouse_place) {
		this.famouse_place = famouse_place;
	}

	//toString
	@Override
	public String toString() {
		return "PlaceDetails [pincode=" + pincode + ", destination=" + destination + ", famouse_place="
				+ famouse_place + "]";
	}
	
	
	

}
