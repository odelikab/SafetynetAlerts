package com.openclassrooms.safetynetalerts.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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
//	private MedicalRecordRepository medicalRecordRepository;

	@GetMapping("/")
	@ResponseBody
	public List<MedicalRecord> getMedicalRecords()  {
		List<MedicalRecord> medicalRecords = medicalRecordService.getAllMedicalRecords();
		return medicalRecords;
	}
	
	@PostMapping
	public MedicalRecord addMedicalRecord(@RequestBody MedicalRecord medicalRecord) {
		MedicalRecord medicalRecordAdded = medicalRecordService.addMedicalRecord(medicalRecord);
	 return medicalRecordAdded;
	}
	
	@PutMapping//("/{firstName}/{lastName}")
	public MedicalRecord updateMedicalRecord(@RequestBody MedicalRecord medicalRecord) {
		return medicalRecordService.updateMedicalRecord(medicalRecord);
	}
	
	@DeleteMapping("/{firstName}/{lastName}")
	public MedicalRecord deleteMedicalRecord(@PathVariable String firstName, @PathVariable String lastName)  {
		MedicalRecord medicalRecordDeleted = medicalRecordService.deleteMedicalRecord(firstName,lastName);
		return medicalRecordDeleted;
 	}

}
