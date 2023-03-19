package com.openclassrooms.safetynetalerts.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MedicalRecord {
	
//	@JsonIgnore
    private String firstName;
//	@JsonIgnore
    private String lastName;
//	@JsonIgnore
    private String birthdate;
    private String[] medications;
    private String[] allergies;
    
    public MedicalRecord() {
		// TODO Auto-generated constructor stub
	}

	public MedicalRecord(String firstName, String lastName, String birthdate) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthdate = birthdate;
	}
    
}
