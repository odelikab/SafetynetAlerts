package com.openclassrooms.safetynetalerts.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.openclassrooms.safetynetalerts.model.MedicalRecord;
import com.openclassrooms.safetynetalerts.model.Person;
import com.openclassrooms.safetynetalerts.service.MedicalRecordService;
import com.openclassrooms.safetynetalerts.service.PersonServiceImpl;

@RestController
@RequestMapping("/medicalRecord")
public class MedicalRecordController {

	@Autowired
	private MedicalRecordService medicalRecordService;

	@GetMapping
	@ResponseBody
	public List<MedicalRecord> getMedicalRecords()  {
		List<MedicalRecord> medicalRecords = medicalRecordService.getAllMedicalRecords();
		return medicalRecords;
	}
	
	@PostMapping
	public ResponseEntity<MedicalRecord> addMedicalRecord( MedicalRecord medicalRecord) {
		MedicalRecord medicalRecordAdded = medicalRecordService.addMedicalRecord(medicalRecord);
	 return new ResponseEntity<MedicalRecord>(medicalRecordAdded,HttpStatus.CREATED);
	}
	
	@PutMapping//("/{firstName}/{lastName}")
	public MedicalRecord updateMedicalRecord( MedicalRecord medicalRecord) {
		return medicalRecordService.updateMedicalRecord(medicalRecord);
	}
	
	@DeleteMapping
	public ResponseEntity<MedicalRecord> deleteMedicalRecord(@RequestParam String firstName, @RequestParam String lastName)  {
		MedicalRecord medicalRecordDeleted = medicalRecordService.deleteMedicalRecord(firstName,lastName);
		return new ResponseEntity<MedicalRecord>(medicalRecordDeleted,HttpStatus.GONE);
 	}
	

}
