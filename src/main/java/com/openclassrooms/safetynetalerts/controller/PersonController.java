package com.openclassrooms.safetynetalerts.controller;

import java.text.ParseException;
import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.openclassrooms.safetynetalerts.model.Person;
import com.openclassrooms.safetynetalerts.model.DTO.PersonDTO;
import com.openclassrooms.safetynetalerts.service.PersonService;

@RestController
public class PersonController {

	@Autowired
	private PersonService personService;

	private static final Logger logger = LoggerFactory.getLogger(PersonController.class);

	@GetMapping("/person")
	public Object getPersons() {
		logger.info("getting all persons");
		Object persons = personService.getAllPersons();
		return persons;
	}

	@PostMapping("/person")
	public ResponseEntity<Person> addPerson(@RequestBody Person person) {
		logger.info("adding person {}", person);
		Person personAdded = personService.addPerson(person);
		return new ResponseEntity<Person>(personAdded, HttpStatus.CREATED);
	}

	@PutMapping("/person")
	public Person updatePerson(@RequestBody Person person) {
		logger.info("updating person {}", person);
		return personService.updatePerson(person);
	}

	@DeleteMapping("/person")
	public ResponseEntity<Person> deletePerson(@RequestParam String firstName, @RequestParam String lastName)
			throws Exception {
		logger.info("deleting person {} {}", firstName, lastName);
		Person personDeleted = personService.deletePerson(firstName, lastName);
		return new ResponseEntity<Person>(personDeleted, HttpStatus.GONE);
	}

	/**
	 * Get one person
	 * 
	 * @param firstName, lastName
	 * @return person object
	 * @throws Exception
	 */
	@GetMapping("person/{firstName}/{lastName}")
	public Person findByName(@PathVariable String firstName, @PathVariable String lastName) throws Exception {
		logger.info("finding person {} {}", firstName, lastName);
		Person person = personService.findByName(firstName, lastName);
		return person;
	}

	/**
	 * Get emails of a city
	 * 
	 * @param city
	 * @return emails list
	 */
	@GetMapping("/communityEmail")
	public ArrayList<Object> getEmailsByCity(@RequestParam(defaultValue = "Culver") String city) {
		logger.info("getting emails of {}", city);
		return personService.getEmailsByCity(city);
	}

	/**
	 * Get info of a person
	 * 
	 * @param firstName, lastName
	 * @return person object
	 * @throws ParseException
	 */
	@GetMapping("/personInfo")
	public Object personInfo(@RequestParam(required = false) String firstName, @RequestParam String lastName)
			throws ParseException {
		logger.info("getting info of person :{} {}", firstName, lastName);
		return personService.getPersonInfo(firstName, lastName);
	}

	/**
	 * Get children of address specified
	 * 
	 * @param address
	 * @return children list
	 * @throws ParseException
	 */
	@GetMapping("/childAlert")
	public Iterable<PersonDTO> childAlert(@RequestParam String address) throws ParseException {
		logger.info("getting children of {}", address);
		Iterable<PersonDTO> persons = personService.getChildByAddress(address);
		return persons;
	}
}
