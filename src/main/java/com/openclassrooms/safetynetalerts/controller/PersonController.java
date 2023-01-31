package com.openclassrooms.safetynetalerts.controller;

import org.springframework.web.bind.annotation.RestController;
import lombok.AllArgsConstructor;

import com.openclassrooms.safetynetalerts.model.Person;
import com.openclassrooms.safetynetalerts.repositery.PersonRepository;
import com.openclassrooms.safetynetalerts.service.PersonService;

import java.util.List;

import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/person")
public class PersonController {
	
//	private final PersonService personService;
	private final PersonRepository personRepository;

	@PostMapping
	public Iterable<Person> addPerson(@RequestBody List<Person> person) {
		Iterable<Person> personAdded = personRepository.saveAll(person);
	 return personAdded;
	}
	
	

}
