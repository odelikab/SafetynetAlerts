package com.openclassrooms.safetynetalerts.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.openclassrooms.safetynetalerts.model.MedicalRecord;
import com.openclassrooms.safetynetalerts.model.Person;
import com.openclassrooms.safetynetalerts.model.DTO.PersonDTO;
import com.openclassrooms.safetynetalerts.repository.MedicalRecordRepository;
import com.openclassrooms.safetynetalerts.repository.PersonRepository;

@Service
public class PersonService {

	@Autowired
	private PersonRepository personRepository;
	@Autowired
	private MedicalRecordRepository medicalRecordRepo;

	public List<Person> getAllPersons() {
		return personRepository.getAllPersons();
	}

	public Person findByName(String firstName, String lastName) {
		return personRepository.findByName(firstName, lastName);
	}

	public Person addPerson(Person person) {
		personRepository.addPerson(person);
		return person;
	}

	public Person deletePerson(String firstName, String lastName) {
		return personRepository.deletePerson(firstName, lastName);
	}

	public Person updatePerson(Person person) {
		return personRepository.updatePerson(person);
	}

	public ArrayList<Object> getEmailsByCity(String city) {
		// TODO Auto-generated method stub
		ArrayList<Object> listEmailsByCity = new ArrayList<Object>();
		List<Person> listPersons = personRepository.getAllPersons();
		for (Person person : listPersons) {
			if (person.getCity().equals(city)) {
				listEmailsByCity.add(person.getEmail());
			}
		}
		return listEmailsByCity;
	}

	public ArrayList<PersonDTO> getPersonInfo(String firstName, String lastName) throws ParseException {
		ArrayList<PersonDTO> listPersonsDTO = new ArrayList<>();
		for (Person person : getAllPersons()) {
			if (person.getLastName().equals(lastName)) {
				PersonDTO personDTO = new PersonDTO();
				personDTO.setFirstName(person.getFirstName());
				personDTO.setLastName(person.getLastName());
				personDTO.setEmail(person.getEmail());
				personDTO.setAddress(person.getAddress());
				MedicalRecord medicalRecord = medicalRecordRepo.findByName(person.getFirstName(), person.getLastName());
				String birthdate = "01/01/1970";
				if (medicalRecord != null) {
					birthdate = medicalRecord.getBirthdate();
				}
				personDTO.setAge(getPersonAge(person.getFirstName(), person.getLastName(), birthdate));
				personDTO.setMedicalRecord(medicalRecordRepo.findByName(firstName, lastName));
				listPersonsDTO.add(personDTO);
			}
		}
		return listPersonsDTO;
	}

	public Iterable<PersonDTO> getChildByAddress(String address) throws ParseException {
		// TODO Auto-generated method stub
		ArrayList<PersonDTO> listChildrenByAddress = new ArrayList<>();
		List<Person> listPersons = personRepository.getAllPersons();
		MedicalRecord medicalRecord = new MedicalRecord();
		for (Person person : listPersons) {
			String firstName = person.getFirstName();
			String lastName = person.getLastName();
			String birthdate;
			medicalRecord = new MedicalRecord();
			medicalRecord = medicalRecordRepo.findByName(firstName, lastName);
			if (medicalRecord != null) {
				birthdate = medicalRecord.getBirthdate();
			} else {
				birthdate = "01/01/2022";
			}
			Long age = getPersonAge(firstName, lastName, birthdate);
			if (age <= 18) {
				if (person.getAddress() != null && person.getAddress().equals(address)) {
					PersonDTO personDTO = new PersonDTO();
					personDTO.setFirstName(person.getFirstName());
					personDTO.setLastName(person.getLastName());
					personDTO.setAge(age);
					personDTO.setFamilyMembers(
							personRepository.getFamilyMembers(person.getFirstName(), person.getLastName()));
					listChildrenByAddress.add(personDTO);
				}
			}
		}
		return listChildrenByAddress;
	}

	public ArrayList<Person> getPersonsByAddress(String address) {
		ArrayList<Person> listPersons = new ArrayList<Person>();
		for (Person person : personRepository.getAllPersons()) {
			if (person.getAddress().equals(address)) {
				listPersons.add(person);
			}
		}
		return listPersons;
	}

	public Long getPersonAge(String firstName, String lastName, String birthdate) throws ParseException {
		Date dateBirthdate = new SimpleDateFormat("dd/MM/yyyy").parse(birthdate);
		long age = (System.currentTimeMillis() - dateBirthdate.getTime()) / 1000 / 60 / 60 / 24 / 365;
		return age;
	}

}
