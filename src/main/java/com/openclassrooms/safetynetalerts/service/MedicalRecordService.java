package com.openclassrooms.safetynetalerts.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
	
	public MedicalRecord findByName(String firstName, String lastName)  {
		MedicalRecord medicalRecord = medicalRecordRepository.findByName(firstName, lastName);
		return medicalRecord;
	}
	
	public MedicalRecord addMedicalRecord(MedicalRecord medicalRecord)  {
		return medicalRecordRepository.addMedicalRecord(medicalRecord);
	}
	
    public MedicalRecord deleteMedicalRecord(String firstName, String lastName)   {
    	return medicalRecordRepository.deleteMedicalRecord(firstName,lastName);
    }
    
    public MedicalRecord updateMedicalRecord(MedicalRecord medicalRecord)  {
    	return medicalRecordRepository.updateMedicalRecord(medicalRecord);
    }

	public Long getAge(String firstName, String lastName) throws ParseException {
		// TODO Auto-generated method stub
		MedicalRecord medicalRecord = medicalRecordRepository.findByName(firstName, lastName);
		String birthdate = medicalRecord.getBirthdate();
	    Date dateBirthdate=new SimpleDateFormat("dd/MM/yyyy").parse(birthdate);  
	    long age = dateBirthdate.getTime()/1000/60/60/24/365;
		return age;
	}

}
