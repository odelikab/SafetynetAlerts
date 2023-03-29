package com.openclassrooms.safetynetalerts;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.openclassrooms.safetynetalerts.model.MedicalRecord;
import com.openclassrooms.safetynetalerts.model.Person;
import com.openclassrooms.safetynetalerts.repository.MedicalRecordRepository;
import com.openclassrooms.safetynetalerts.repository.PersonRepository;
import com.openclassrooms.safetynetalerts.service.PersonService;

@SpringBootTest
public class PersonServiceTest {

	@MockBean
	private MedicalRecordRepository medicalRecordRepo;
	@MockBean
	private PersonRepository personRepo;
	
	@Autowired
	private PersonService personServiceImpl;
	
	@Test
	public void testFindByName() {
		Person personTest = new Person();
		personTest.setFirstName("Bob");
		personTest.setLastName("Mathieu");
		when(personRepo.findByName(anyString(),anyString())).thenReturn(personTest);
		Person person = personServiceImpl.findByName("Bob","Mathieu");
//		assertEquals("Bob",person.getFirstName());
		verify(personRepo,times(1)).findByName("Bob","Mathieu");
	}
	
	@Test
	public void testAddPerson() {
		Person personTest = new Person();
		personTest.setFirstName("Bob");
		personTest.setLastName("Mathieu");
		Person person = personServiceImpl.addPerson(personTest);
		verify(personRepo,times(1)).addPerson(personTest);
	}
	
	@Test
	public void testDeletePerson() {
		Person person = personServiceImpl.deletePerson(null, null);
		verify(personRepo,times(1)).deletePerson(null, null);
	}
	
	@Test
	public void testUpdatePerson() {
		Person person = personServiceImpl.updatePerson(null);
		verify(personRepo,times(1)).updatePerson(null);
	}
	
	@Test
	public void testGetPersons() {
		List<Person> person = personServiceImpl.getAllPersons();
		verify(personRepo,times(1)).getAllPersons();
	}

	@Test
	public void testGetPersonsByAddress() {
		String address = "123 address";
		List<Person> listPersons = new ArrayList<>();
		listPersons.add(new Person("Thomas","Boyd"));
		listPersons.add(new Person("Leo","Boyd"));
		listPersons.get(0).setAddress(address);
		listPersons.get(1).setAddress("657 address");
		when(personRepo.getAllPersons()).thenReturn(listPersons);
		personServiceImpl.getPersonsByAddress(address);
		verify(personRepo,times(1)).getAllPersons();
//		assert
	}
	
	@Test
	public void testGetEmailsByCity() {
		String city = "Culver";
		List<Person> listPersons = new ArrayList<>();
		listPersons.add(new Person("Thomas","Boyd"));
		listPersons.add(new Person("Leo","Boyd"));
		listPersons.get(0).setCity(city);
		listPersons.get(1).setCity("paris");
		when(personRepo.getAllPersons()).thenReturn(listPersons);
		personServiceImpl.getEmailsByCity(city);
		verify(personRepo,times(1)).getAllPersons();
	}

	@Test
	public void testGetPersonInfo() throws ParseException {
		String firstName = "Thomas";
		String lastName = "Boyd";
		List<Person> listPersons = new ArrayList<>();
		listPersons.add(new Person("Thomas","Boyd"));
		listPersons.add(new Person("Leo","Forest"));
		MedicalRecord medicalRecord = new MedicalRecord("Thomas","Boyd","12/12/1992");
		when(medicalRecordRepo.findByName(anyString(),anyString())).thenReturn(medicalRecord);
		when(personRepo.getAllPersons()).thenReturn(listPersons);
		personServiceImpl.getPersonInfo(firstName, lastName);
		verify(personRepo,times(1)).getAllPersons();
	}
	
	@Test
	public void testGetChildByAddress() throws ParseException {
		Person personTest = new Person("Leo","Boyd");
		personTest.setAddress("123 address");
		List<Person> persons = new ArrayList<>();
		persons.add(personTest);
		persons.add(new Person("Leo", "Forest"));
		persons.get(1).setAddress("657 address");
		persons.add(new Person("Bob", "Forest"));
		persons.get(2).setAddress("789 address");
		MedicalRecord medicalRecordBoyd = new MedicalRecord();
		medicalRecordBoyd.setBirthdate("12/12/1992");
		MedicalRecord medicalRecordForest = new MedicalRecord();
		medicalRecordForest.setBirthdate("12/12/2022");
		MedicalRecord medicalRecordBob = new MedicalRecord("Bob","Forest","12/12/2020");
		when(personRepo.getAllPersons()).thenReturn(persons);
		when(medicalRecordRepo.findByName("Leo","Boyd")).thenReturn(medicalRecordBoyd);
		when(medicalRecordRepo.findByName("Leo","Forest")).thenReturn(medicalRecordForest);
		when(medicalRecordRepo.findByName("Bob","Forest")).thenReturn(medicalRecordBob);

		String address = "657 address";
		personServiceImpl.getChildByAddress(address);	
		String firstName = "Leo";
		String lastName = "Forest";
		verify(personRepo,times(1)).getFamilyMembers(firstName, lastName);
	}

	@Test
	public void testGetPersonAge() throws ParseException {
		String firstName = "Thomas";
		String lastName = "Boyd";
		String birthdate = "12/12/1992";
		Long age = personServiceImpl.getPersonAge(firstName, lastName, birthdate );
		assertEquals(30, age);
	}

}

