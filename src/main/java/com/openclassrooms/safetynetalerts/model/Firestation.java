package com.openclassrooms.safetynetalerts.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.jsoniter.fuzzy.MaybeStringIntDecoder;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;

//@Data
//@AllArgsConstructor
public class Firestation {
	
	private String address;
	private String station;
	
	public Firestation() {
		
	}
	
	@Override
	public String toString() {
		return station;
		
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getStation() {
		return station;
	}

	public void setStation(String station) {
		this.station = station;
	}

}
