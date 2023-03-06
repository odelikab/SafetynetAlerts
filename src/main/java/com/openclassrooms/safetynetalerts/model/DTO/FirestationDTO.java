package com.openclassrooms.safetynetalerts.model.DTO;

import java.util.List;

import com.openclassrooms.safetynetalerts.model.MedicalRecord;
import com.openclassrooms.safetynetalerts.model.Person;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FirestationDTO {
	private String address;
	private String station;
	private List<Person> persons;
	
}
