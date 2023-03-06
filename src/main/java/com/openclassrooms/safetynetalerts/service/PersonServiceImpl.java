package com.openclassrooms.safetynetalerts.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.openclassrooms.safetynetalerts.model.MedicalRecord;
import com.openclassrooms.safetynetalerts.model.Person;
import com.openclassrooms.safetynetalerts.model.DTO.PersonDTO;
import com.openclassrooms.safetynetalerts.repositery.MedicalRecordRepository;
import com.openclassrooms.safetynetalerts.repositery.PersonRepository;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Service
public class PersonServiceImpl  {
	
	@Autowired
	private PersonRepository personRepository;
	@Autowired
	private MedicalRecordRepository medicalRecordRepo;
	
	public List<Person> getAllPersons()    {
	return personRepository.getAllPersons();
	}
	
	public Person findByName(String firstName, String lastName)  {
		return personRepository.findByName(firstName, lastName);
	}
	
	public Person addPerson(Person person)  {
		personRepository.addPerson(person);
		return person;
	}
	
    public Person deletePerson(String firstName, String lastName)   {
    	return personRepository.deletePerson(firstName,lastName);
    }
    
    public Person updatePerson(Person person)  {
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
//				MedicalRecord medicalRecord = medicalRecordService.findByName(firstName, lastName);
				PersonDTO personDTO = new PersonDTO();
				personDTO.setFirstName(person.getFirstName());
				personDTO.setLastName(person.getLastName());
				personDTO.setEmail(person.getEmail());
				personDTO.setAddress(person.getAddress());
				personDTO.setAge(getPersonAge(person.getFirstName(), person.getLastName()));
				personDTO.setMedicalRecord(medicalRecordRepo.findByName(firstName, lastName));
				listPersonsDTO.add(personDTO);
			}
		}
		return listPersonsDTO;

	}

	public Iterable<PersonDTO> getChildByAddress(String address) throws ParseException {
		// TODO Auto-generated method stub
		ArrayList<PersonDTO> listChildrenByAddress = new ArrayList<>();
//		List<Person> listPersons = personRepository.getAllPersons();
//		 List<MedicalRecord> listMedicalRecords = medicalRecordService.getAllMedicalRecords();
		for (MedicalRecord medicalRecord : medicalRecordRepo.getAllMedicalRecords()) {
			String firstName = medicalRecord.getFirstName();
			String lastName = medicalRecord.getLastName();
			if(getPersonAge(firstName, lastName )<=18)  {
				Person personByName = personRepository.findByName(firstName, lastName);
				if( personByName.getAddress().equals(address)) {
					PersonDTO personDTO = new PersonDTO();
					personDTO.setFirstName(personByName.getFirstName());
					personDTO.setLastName(personByName.getLastName());
					personDTO.setAge(getPersonAge(personByName.getFirstName(),personByName.getLastName()));
					personDTO.setFamilyMembers( personRepository.getFamilyMembers(personByName.getFirstName(), personByName.getLastName()));
					listChildrenByAddress.add(personDTO);
				}
			}
		}
		return listChildrenByAddress;
	}
	
	public ArrayList<Person> getPersonsByAddress(String address)  {
		ArrayList<Person> listPersons = new ArrayList<Person>();
//		List<Person> listPersons = personRepository.getAllPersons();
		for (Person person : personRepository.getAllPersons()) {
			if (person.getAddress().equals(address)) {
				listPersons.add(person);
			}
		}
		return listPersons;
	}

	
	public Long getPersonAge(String firstName, String lastName) throws ParseException {
		// TODO Auto-generated method stub
		MedicalRecord medicalRecord = medicalRecordRepo.findByName(firstName, lastName);
		String birthdate = medicalRecord.getBirthdate();
	    Date dateBirthdate=new SimpleDateFormat("dd/MM/yyyy").parse(birthdate);  
	    long age = (System.currentTimeMillis() - dateBirthdate.getTime())/1000/60/60/24/365;
		return age;
	}

}
