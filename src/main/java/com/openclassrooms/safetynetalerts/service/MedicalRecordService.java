package com.openclassrooms.safetynetalerts.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.openclassrooms.safetynetalerts.model.MedicalRecord;
import com.openclassrooms.safetynetalerts.repositery.MedicalRecordRepository;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Service
public class MedicalRecordService {

	@Autowired
	private MedicalRecordRepository medicalRecordRepository;
	
	public List<MedicalRecord> getAllMedicalRecords()    {
	return medicalRecordRepository.getAllMedicalRecords();
	}
	
	public MedicalRecord addMedicalRecord(MedicalRecord medicalRecord)  {
		medicalRecordRepository.addMedicalRecord(medicalRecord);
		return medicalRecord;
	}
	
    public MedicalRecord deleteMedicalRecord(String firstName, String lastName)   {
    	return medicalRecordRepository.deleteMedicalRecord(firstName,lastName);
    }
    
    public MedicalRecord updateMedicalRecord(MedicalRecord medicalRecord)  {
    	return medicalRecordRepository.updateMedicalRecord(medicalRecord);
    }

}
