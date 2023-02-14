package com.openclassrooms.safetynetalerts.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.openclassrooms.safetynetalerts.model.Person;
import com.openclassrooms.safetynetalerts.repositery.PersonRepository;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Service
public class PersonServiceImpl  {
	
	@Autowired
	private PersonRepository personRepository;
	
	public List<Person> getAllPersons()    {
	return personRepository.getAllPersons();
	}
	
	public Person addPerson(Person person)  {
		personRepository.addPerson(person);
		return person;
	}
    public Person deletePerson(String firstName, String lastName)   {
    	return personRepository.deletePerson(firstName,lastName);
    }
	private Person getValidPerson(String lastName, String firstName) throws Exception {
        Optional<Person> optionalPerson = personRepository.findOneByNameAndFirstName(lastName, firstName);
        if (optionalPerson.isEmpty()){
            throw new Exception() ;
        }
        return optionalPerson.get();
	}
}
