package com.openclassrooms.safetynetalerts.controller;

import lombok.AllArgsConstructor;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.openclassrooms.safetynetalerts.model.MedicalRecord;
import com.openclassrooms.safetynetalerts.model.Person;
import com.openclassrooms.safetynetalerts.model.DTO.PersonDTO;
import com.openclassrooms.safetynetalerts.repositery.PersonRepository;
import com.openclassrooms.safetynetalerts.service.PersonService;
import com.openclassrooms.safetynetalerts.service.PersonServiceImpl;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.*;

//@AllArgsConstructor
@RestController
//@RequestMapping("/person")
public class PersonController {
	
	@Autowired
	private PersonServiceImpl personService;
//	private PersonRepository personRepository;

	@GetMapping("/person")
	public Object getPersons()  {
		Object persons = personService.getAllPersons();
		return persons;
	}
	
	@PostMapping("/person")
	public Person addPerson(@RequestBody Person person) {
		Person personAdded = personService.addPerson(person);
	 return personAdded;
	}
//	
	@PutMapping("/person")//("/{firstName}/{lastName}")
	public Person updatePerson(@RequestBody Person person) {
		return personService.updatePerson(person);
	}
//	
	@DeleteMapping("/person/{firstName}/{lastName}")
	public Person deletePerson(@PathVariable String firstName, @PathVariable String lastName) throws Exception {
		Person personDeleted = personService.deletePerson(firstName,lastName);
		return personDeleted;
 	}
	
	@GetMapping("person/{firstName}/{lastName}")
	public Person findByName(@PathVariable String firstName, @PathVariable String lastName) throws Exception {
		Person person = personService.findByName(firstName,lastName);
		return person;
 	}
	
	@GetMapping("/communityEmail")
	public ArrayList<Object> getEmailsByCity(@RequestParam(defaultValue = "Culver") String city)  {
		return personService.getEmailsByCity(city);
	}

	@GetMapping("/personInfo")
	public Object personInfo(@RequestParam String firstName, @RequestParam String lastName) throws ParseException  {
		return personService.getPersonInfo(firstName, lastName);
	}
	
	@GetMapping("/childAlert")
	public MappingJacksonValue childAlert(@RequestParam String address) {
		Iterable<Person> persons = personService.getChildByAddress(address);
		SimpleBeanPropertyFilter monFiltre = SimpleBeanPropertyFilter.filterOutAllExcept("firstName", "lastName",
				"age","familyMembers");
		FilterProvider listDeNosFiltres = new SimpleFilterProvider().addFilter("monFiltreDynamique", monFiltre);
		MappingJacksonValue produitsFiltres = new MappingJacksonValue(persons);
		produitsFiltres.setFilters(listDeNosFiltres);
		return produitsFiltres;
	}
}
