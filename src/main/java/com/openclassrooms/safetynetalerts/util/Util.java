package com.openclassrooms.safetynetalerts.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;

import com.jsoniter.JsonIterator;
import com.jsoniter.any.Any;
import com.openclassrooms.safetynetalerts.model.Firestation;
import com.openclassrooms.safetynetalerts.model.MedicalRecord;
import com.openclassrooms.safetynetalerts.model.Person;

import lombok.Data;
//@Data
public class Util {
	//singleton
	private static Util instance;
	
	private Person[] persons;
    private MedicalRecord[] medicalrecords;
    private Firestation[] firestations;
    
    private Util()  {
    	}
    
	public static Util getInstance() throws IOException{
		if(instance==null) {
			InputStream inputStream = new FileInputStream("src/main/resources/data.json");
			JsonIterator iter = JsonIterator.parse(inputStream.readAllBytes());
			instance = iter.read(Util.class);
			iter.close();
			inputStream.close();
		}
		return instance;
	}
	
    public Person[] getPersons() throws IOException {
		return getInstance().persons;
    		
	}
	public void setPersons(Person[] persons) {
		this.persons = persons;
	}
	public MedicalRecord[] getMedicalRecords() throws IOException {
		return getInstance().medicalrecords;
		
	}
	public void setMedicalrecords(MedicalRecord[] medicalrecords) {
		this.medicalrecords = medicalrecords;
	}
	public Firestation[] getFirestations() throws IOException {
		return getInstance().firestations;
		
	}
	public void setFirestations(Firestation[] firestations) {
		this.firestations = firestations;
	}

}
