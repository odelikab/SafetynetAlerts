package com.openclassrooms.safetynetalerts.controller;

import lombok.AllArgsConstructor;

import com.jsoniter.any.Any;
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
//	private PersonServiceImpl personService;
	private PersonRepository personRepository;

	@GetMapping("/all")
	
	public List<Person> getPersons() throws IOException  {
		List<Person> persons = personRepository.getAllPersons();
		return persons;
	}
	
//	@PostMapping
//	public Iterable<Person> addPerson(@RequestBody List<Person> person) {
//		Iterable<Person> personAdded = personRepository.saveAll(person);
//	 return personAdded;
//	}
//	
//	@PutMapping(value = "/")
//	public void updatePerson(@PathVariable(value = "id") Long id) {
//		 personRepository.deleteById(id);
//	}
//	
//	@DeleteMapping(value = "/")
//	public ResponseEntity<Void> deletePerson(@RequestParam(value = "id", required = true) Long id) {
//		personRepository.deleteById(id);
//		return new ResponseEntity<Void>(HttpStatus.GONE);
// 	}
	

}
