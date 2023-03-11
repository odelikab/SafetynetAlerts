package com.openclassrooms.safetynetalerts.model.DTO;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.openclassrooms.safetynetalerts.model.MedicalRecord;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
//@JsonFilter("monFiltreDynamique")
@JsonInclude(JsonInclude.Include.NON_NULL)

public class PersonDTO {

	public PersonDTO() {
		// TODO Auto-generated constructor stub
	}
	private String firstName;
	private String lastName;
	private String address;
	private String city;
	private String zip;
	private String phone;
	private String email;
	private Long age;
	private List<String> familyMembers;
	private MedicalRecord medicalRecord;
	private String medication;
	private String allergies;
	private String station;

	
}
