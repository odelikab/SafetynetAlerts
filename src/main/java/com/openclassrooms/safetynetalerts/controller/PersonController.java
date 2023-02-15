package com.openclassrooms.safetynetalerts.controller;

import lombok.AllArgsConstructor;

import com.openclassrooms.safetynetalerts.model.Person;
import com.openclassrooms.safetynetalerts.repositery.PersonRepository;
import com.openclassrooms.safetynetalerts.service.PersonService;
import com.openclassrooms.safetynetalerts.service.PersonServiceImpl;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//@AllArgsConstructor
@RestController
@RequestMapping("/person")
public class PersonController {
	
	@Autowired
	private PersonServiceImpl personService;
//	private PersonRepository personRepository;

	@GetMapping("/")
	@ResponseBody
	public List<Person> getPersons()  {
		List<Person> persons = personService.getAllPersons();
		return persons;
	}
	
	@PostMapping
	public Person addPerson(@RequestBody Person person) {
		Person personAdded = personService.addPerson(person);
	 return personAdded;
	}
//	
	@PutMapping//("/{firstName}/{lastName}")
	public Person updatePerson(@RequestBody Person person) {
		return personService.updatePerson(person);
	}
//	
	@DeleteMapping("/{firstName}/{lastName}")
	public Person deletePerson(@PathVariable String firstName, @PathVariable String lastName) throws Exception {
		Person personDeleted = personService.deletePerson(firstName,lastName);
		return personDeleted;
 	}
	
	@GetMapping("/{firstName}/{lastName}")
	public Person findByName(@PathVariable String firstName, @PathVariable String lastName) throws Exception {
		Person person = personService.findByName(firstName,lastName);
		return person;
 	}

}
