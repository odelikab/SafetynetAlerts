package com.openclassrooms.safetynetalerts.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.openclassrooms.safetynetalerts.model.MedicalRecord;
import com.openclassrooms.safetynetalerts.repository.MedicalRecordRepository;

//@Data
//@AllArgsConstructor
@Service
public class MedicalRecordService {

	@Autowired
	private MedicalRecordRepository medicalRecordRepository;

	public MedicalRecordService() {
	}

	public List<MedicalRecord> getAllMedicalRecords() {
		return medicalRecordRepository.getAllMedicalRecords();
	}

	public MedicalRecord findByName(String firstName, String lastName) {
		MedicalRecord medicalRecord = medicalRecordRepository.findByName(firstName, lastName);
		return medicalRecord;
	}

	public MedicalRecord addMedicalRecord(MedicalRecord medicalRecord) {
		return medicalRecordRepository.addMedicalRecord(medicalRecord);
	}

	public MedicalRecord deleteMedicalRecord(String firstName, String lastName) {
		return medicalRecordRepository.deleteMedicalRecord(firstName, lastName);
	}

	public MedicalRecord updateMedicalRecord(MedicalRecord medicalRecord) {
		return medicalRecordRepository.updateMedicalRecord(medicalRecord);
	}

}
