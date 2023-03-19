package com.openclassrooms.safetynetalerts;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.openclassrooms.safetynetalerts.model.MedicalRecord;
import com.openclassrooms.safetynetalerts.repositery.FirestationRepository;
import com.openclassrooms.safetynetalerts.repositery.MedicalRecordRepository;
import com.openclassrooms.safetynetalerts.service.FirestationService;
import com.openclassrooms.safetynetalerts.service.MedicalRecordService;
import com.openclassrooms.safetynetalerts.service.PersonServiceImpl;

@SpringBootTest
public class MedicalRecordServiceTest {

	@MockBean
	private MedicalRecordRepository medicalRecordRepo;
	@MockBean
	private PersonServiceImpl personServiceImpl;
//	@MockBean
//	private MedicalRecordService medicalRecordService;

	@Autowired
	private MedicalRecordService medicalRecordService;
	
	@Test
	public void testGetAllMedicalRecords() {
	medicalRecordService.getAllMedicalRecords();
	verify(medicalRecordRepo,times(1)).getAllMedicalRecords();
	}
	
	@Test
	public void testFindByName() {
	medicalRecordService.findByName("Thomas","Boyd");
	verify(medicalRecordRepo,times(1)).findByName("Thomas","Boyd");
	}
	
	@Test
	public void testaddMedicalRecord() {
	MedicalRecord medicalRecord = new MedicalRecord();
	medicalRecordService.addMedicalRecord(medicalRecord );
	verify(medicalRecordRepo,times(1)).addMedicalRecord(medicalRecord);
	}

	@Test
	public void testDeleteMedicalRecord() {
	medicalRecordService.deleteMedicalRecord("Thomas","Boyd");
	verify(medicalRecordRepo,times(1)).deleteMedicalRecord("Thomas","Boyd");
	}
	
	@Test
	public void testUpdateMedicalRecord() {
	MedicalRecord medicalRecord = new MedicalRecord();
	medicalRecordService.updateMedicalRecord(medicalRecord);
	verify(medicalRecordRepo,times(1)).updateMedicalRecord(medicalRecord);
	}


}
