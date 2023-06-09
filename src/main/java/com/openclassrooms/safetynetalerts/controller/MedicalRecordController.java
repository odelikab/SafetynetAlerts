package com.openclassrooms.safetynetalerts.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.openclassrooms.safetynetalerts.model.MedicalRecord;
import com.openclassrooms.safetynetalerts.service.MedicalRecordService;

@RestController
@RequestMapping("/medicalRecord")
public class MedicalRecordController {

	@Autowired
	private MedicalRecordService medicalRecordService;

	private static final Logger logger = LoggerFactory.getLogger(MedicalRecordController.class);

	@GetMapping
	public List<MedicalRecord> getMedicalRecords() {
		List<MedicalRecord> medicalRecords = medicalRecordService.getAllMedicalRecords();
		logger.info("getting all medical records");
		return medicalRecords;
	}

	@PostMapping
	public ResponseEntity<MedicalRecord> addMedicalRecord(MedicalRecord medicalRecord) {
		MedicalRecord medicalRecordAdded = medicalRecordService.addMedicalRecord(medicalRecord);
		logger.info("adding record : {}", medicalRecord);
		return new ResponseEntity<MedicalRecord>(medicalRecordAdded, HttpStatus.CREATED);
	}

	@PutMapping
	public MedicalRecord updateMedicalRecord(MedicalRecord medicalRecord) {
		logger.info("updating record : {}", medicalRecord);
		return medicalRecordService.updateMedicalRecord(medicalRecord);
	}

	@DeleteMapping
	public ResponseEntity<MedicalRecord> deleteMedicalRecord(@RequestParam String firstName,
			@RequestParam String lastName) {
		MedicalRecord medicalRecordDeleted = medicalRecordService.deleteMedicalRecord(firstName, lastName);
		logger.info("deleting record : {}", medicalRecordDeleted);
		return new ResponseEntity<MedicalRecord>(medicalRecordDeleted, HttpStatus.GONE);
	}

}
