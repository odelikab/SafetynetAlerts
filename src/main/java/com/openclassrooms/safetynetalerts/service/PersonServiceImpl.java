package com.openclassrooms.safetynetalerts.service;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collection;
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
	private MedicalRecordService medicalRecordService;
	
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
		for(Person person : getAllPersons()) {
			if(person.getLastName().equals(lastName)) {
				MedicalRecord medicalRecord = medicalRecordService.findByName(firstName, lastName);
				PersonDTO personDTO = new PersonDTO();
				personDTO.setFirstName(person.getFirstName());
				personDTO.setLastName(person.getLastName());
				personDTO.setEmail(person.getEmail());
				personDTO.setAddress(person.getAddress());
				personDTO.setAge(medicalRecordService.getAge(firstName,lastName));
				personDTO.setMedicalRecord(medicalRecordService.findByName(firstName,lastName));

				listPersonsDTO.add(personDTO);			}
		}
		return listPersonsDTO;
		
	}

//	public Iterable<Person> getChildByAddress(String address) {
//		// TODO Auto-generated method stub
//		List<Person> listChildrenByAddress = new ArrayList<Person>();
//		List<Person> listPersons = personRepository.getAllPersons();
//		for (Person person : listPersons) {
//			if (person.getAddress().equals(address) && person.getAge()<=18) {
//				person.setFamilyMembers( personRepository.getFamilyMembers(person.getFirstName(), person.getLastName()));
//				listChildrenByAddress.add(person);
//				person.setMedicalRecord(medicalRecordRepo.findByName(person.getFirstName(), person.getLastName()));
//			}
//		}
//		return listChildrenByAddress;
//	}
}
