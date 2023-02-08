package com.openclassrooms.safetynetalerts.util;

import java.util.Collection;

import com.jsoniter.JsonIterator;
import com.jsoniter.any.Any;
import com.openclassrooms.safetynetalerts.model.Firestation;
import com.openclassrooms.safetynetalerts.model.MedicalRecord;
import com.openclassrooms.safetynetalerts.model.Person;

import lombok.Data;
//@Data
public class Util {
	
	public Person[] persons;
    public MedicalRecord[] medicalrecords;
    public Firestation[] firestations;
    
	
    public Person[] getPersons() {
		return persons;
	}
	public void setPersons(Person[] persons) {
		this.persons = persons;
	}
	public MedicalRecord[] getMedicalrecords() {
		return medicalrecords;
	}
	public void setMedicalrecords(MedicalRecord[] medicalrecords) {
		this.medicalrecords = medicalrecords;
	}
	public Firestation[] getFirestations() {
		return firestations;
	}
	public void setFirestations(Firestation[] firestations) {
		this.firestations = firestations;
	}

}
