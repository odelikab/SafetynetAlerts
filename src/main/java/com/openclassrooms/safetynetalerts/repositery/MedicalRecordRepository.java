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
	
	public MedicalRecord addMedicalRecord(MedicalRecord medicalRecord)   {
		listMedicalRecords.add(medicalRecord);
		return medicalRecord;
		
 	}
	
	public MedicalRecord deleteMedicalRecord(String firstName, String lastName) {
		int i = 0;
		Iterator<MedicalRecord> itr = listMedicalRecords.iterator();

		while (itr.hasNext()) {
			String firstNameCurrent = listMedicalRecords.get(i).getFirstName();
			String lastNameCurrent = listMedicalRecords.get(i).getLastName();

			if (firstNameCurrent.equals(firstName) && lastNameCurrent.equals(lastName)) {
				int indexToRemove = listMedicalRecords.indexOf(itr.next());
//				listPersons.remove(indexToRemove);
				itr.remove();
				break;
			}
			i++;
		}
		return listMedicalRecords.get(i);
	}

	public MedicalRecord updateMedicalRecord(MedicalRecord medicalRecord) {
		int indexToUpdate = 0;
		while (indexToUpdate < listMedicalRecords.size() - 1) {
			MedicalRecord personToUpdate = listMedicalRecords.get(indexToUpdate);
			if (personToUpdate.getFirstName().equals(medicalRecord.getFirstName())
					&& personToUpdate.getLastName().equals(medicalRecord.getLastName())) {
				personToUpdate.setBirthdate(medicalRecord.getBirthdate());
				personToUpdate.setMedication(medicalRecord.getMedication());
				personToUpdate.setAllergies(medicalRecord.getAllergies());
				break;
			}
			indexToUpdate++;
		}
		return medicalRecord;
	}
}
