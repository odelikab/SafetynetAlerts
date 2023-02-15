package com.openclassrooms.safetynetalerts.repositery;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.openclassrooms.safetynetalerts.model.MedicalRecord;
import com.openclassrooms.safetynetalerts.model.Person;
import com.openclassrooms.safetynetalerts.util.Util;

@Repository
public class MedicalRecordRepository {

	
	public List<MedicalRecord> listMedicalRecords = new ArrayList<MedicalRecord>();
	
	public MedicalRecordRepository() throws IOException  {
		MedicalRecord[] arrayMedicalRecords = Util.getInstance().getMedicalRecords();
		for (MedicalRecord medicalRecord : arrayMedicalRecords) {
			listMedicalRecords.add(medicalRecord);
		}
	}
	
	public List<MedicalRecord> getAllMedicalRecords()   {
		return listMedicalRecords;

	}
	
	public MedicalRecord findByName(String firstName, String lastName) {
		int i = 0;
		MedicalRecord medicalRecord = new MedicalRecord();
		while(i<listMedicalRecords.size()) {
			medicalRecord = listMedicalRecords.get(i);
			if(medicalRecord.getFirstName().equals(firstName)
					&& medicalRecord.getLastName().equals(lastName)) {
				return medicalRecord;
			}
			i++;
		}
		return null;
	}
	
	public MedicalRecord addMedicalRecord(MedicalRecord medicalRecord)   {
		listMedicalRecords.add(medicalRecord);
		return medicalRecord;
 	}
	
	public MedicalRecord deleteMedicalRecord(String firstName, String lastName) {
		MedicalRecord medicalRecord = findByName(firstName,lastName);
		listMedicalRecords.remove(medicalRecord);
		return medicalRecord;
	}

	public MedicalRecord updateMedicalRecord(MedicalRecord medicalRecord) {
		
		String firstName= medicalRecord.getFirstName();
		String lastName = medicalRecord.getLastName();
		MedicalRecord medicalRecordOrigin = findByName(firstName,lastName);
		listMedicalRecords.set(listMedicalRecords.indexOf(medicalRecordOrigin), medicalRecord);
		return medicalRecord;
	}
}
