package com.openclassrooms.safetynetalerts;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;

import org.hibernate.mapping.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.openclassrooms.safetynetalerts.model.Firestation;
import com.openclassrooms.safetynetalerts.model.MedicalRecord;
import com.openclassrooms.safetynetalerts.model.Person;
import com.openclassrooms.safetynetalerts.repository.FirestationRepository;
import com.openclassrooms.safetynetalerts.service.FirestationService;
import com.openclassrooms.safetynetalerts.service.MedicalRecordService;
import com.openclassrooms.safetynetalerts.service.PersonServiceImpl;

@SpringBootTest
public class FirestationServiceTest {
	
@MockBean
private FirestationRepository firestationRepo;
@MockBean
private PersonServiceImpl personServiceImpl;
@MockBean
private MedicalRecordService medicalRecordService;

@Autowired
private FirestationService firestationService;

	@Test
	public void testFindByStationNumber() throws ParseException  {
	ArrayList<String> fireList = new ArrayList<String>();
	fireList.add("123 address");
	fireList.add("567 address");
	ArrayList<Person> persons = new ArrayList<Person>();
	persons.add(new Person("Thomas","Boyd"));
	persons.add(new Person("Leo","Boyd"));
	when(firestationRepo.findAddressByStationNumber(anyInt())).thenReturn(fireList);
	when(personServiceImpl.getPersonsByAddress(anyString())).thenReturn(persons);
	when(medicalRecordService.findByName("Thomas","Boyd")).thenReturn(new MedicalRecord("Thomas","Boyd","12/12/1992"));
	when(medicalRecordService.findByName("Leo","Boyd")).thenReturn(new MedicalRecord("Leo","Boyd","12/12/2022"));
	when(personServiceImpl.getPersonAge("Thomas","Boyd", "12/12/1992")).thenReturn((long) 30);
	when(personServiceImpl.getPersonAge("Leo","Boyd", "12/12/2022")).thenReturn((long) 1);
	firestationService.findAddressByStationNumber(1);
//	assertEquals("Bob",person.getFirstName());
	verify(firestationRepo,times(1)).findAddressByStationNumber(1);
	}

	@Test
	public void testFindFirestation()  {
		ArrayList<Firestation> fireList = new ArrayList<Firestation>();
		Firestation firestation = null;
		fireList.add(firestation);
//		fireList.add("567 address");
		//when(firestationRepo.findFirestationByAddress(anyString())).thenReturn(fireList);
		firestationService.findFirestationByAddress("567 address");
		verify(firestationRepo,times(1)).findFirestationByAddress("567 address");

	}
	
	@Test
	public void testGetFirestations() throws IOException  {
		firestationService.getAllFirestations();
		verify(firestationRepo,times(1)).getAllFirestations();

	}
	
	@Test
	public void testAddFirestations() {
	Firestation firestation = new Firestation();
	firestation.setAddress("123 address");
	firestationService.addFirestation(firestation);
	verify(firestationRepo,times(1)).addFirestation(firestation);

	}
	
	@Test
	public void testDeleteFirestations() {
		Firestation firestation = new Firestation();
		firestation.setAddress("123 address");
		firestationService.deleteFirestation(firestation);
		verify(firestationRepo,times(1)).deleteFirestation(firestation);

	}
	
	@Test
	public void testModifyFirestations() {
		Firestation firestation = new Firestation();
		firestation.setAddress("123 address");
		firestationService.updateFirestation(firestation);
		verify(firestationRepo,times(1)).updateFirestation(firestation);

	}
	
	@Test
	public void testGetPhoneNumberByStation() {
		java.util.List<String> listAddress = new ArrayList<>();
		listAddress.add("123 address");
		listAddress.add("456 address");
		when(firestationRepo.findAddressByStationNumber(anyInt())).thenReturn(listAddress);
		java.util.List<Person> listPersons = new ArrayList<>();
		listPersons.add(new Person("Thomas","Boyd"));
		listPersons.get(0).setAddress("123 address");
		listPersons.add(new Person("Leo","Boyd"));
		listPersons.get(1).setAddress("789 address");
		when(personServiceImpl.getAllPersons()).thenReturn(listPersons);
		ArrayList<Firestation> fireList = new ArrayList<Firestation>();
		firestationService.getPhoneNumberByStation(0);
		verify(firestationRepo,times(1)).findAddressByStationNumber(0);
		
	}
	
	@Test
	public void testGetPersonsByAddress() throws ParseException {
		java.util.List<Person> listPersons = new ArrayList<>();
		listPersons.add(new Person("Thomas","Boyd"));
		listPersons.get(0).setAddress("123 address");
		listPersons.add(new Person("Leo","Boyd"));
		listPersons.get(1).setAddress("789 address");
		when(personServiceImpl.getAllPersons()).thenReturn(listPersons);
		when(medicalRecordService.findByName("Thomas","Boyd")).thenReturn(new MedicalRecord("Thomas","Boyd","12/12/1992"));
		firestationService.getPersonsByAddress("123 address");
		verify(personServiceImpl,times(1)).getAllPersons();

	}
	
	@Test
	public void testGetFlood() throws ParseException {
		java.util.List<String> listAddress = new ArrayList<>();
		listAddress.add("123 address");
		listAddress.add("456 address");
		when(firestationRepo.findAddressByStationNumber(anyInt())).thenReturn(listAddress);
		String address = "123 address";
		ArrayList<Person> listPersons = new ArrayList<>();
		listPersons.add(new Person("Thomas","Boyd"));
		listPersons.add(new Person("Leo","Boyd"));
		when(personServiceImpl.getPersonsByAddress(address)).thenReturn(listPersons);
		when(medicalRecordService.findByName("Thomas","Boyd")).thenReturn(new MedicalRecord("Thomas","Boyd","12/12/1992"));
		when(medicalRecordService.findByName("Leo","Boyd")).thenReturn(new MedicalRecord("Leo","Boyd","12/12/2022"));
		java.util.List<Integer> listStations = new ArrayList<>();
		listStations.add(1);
		listStations.add(2);
		firestationService.getFlood(listStations);
		verify(firestationRepo,times(1)).findAddressByStationNumber(1);

	}


}
