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
//@Entity
public class MedicalRecord {
	
//	@JsonIgnore
    private String firstName;
//	@JsonIgnore
    private String lastName;
//	@JsonIgnore
    private String birthdate;
    private String[] medication;
    private String[] allergies;
    
    public MedicalRecord() {
		// TODO Auto-generated constructor stub
	}
}
