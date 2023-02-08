package com.openclassrooms.safetynetalerts.service;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsoniter.JsonIterator;
import com.openclassrooms.safetynetalerts.model.Person;
import com.openclassrooms.safetynetalerts.repositery.PersonRepository;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Service
public class PersonServiceImpl  {
	
	
	private final PersonRepository personRepository;
	

	
//	public Person[] getPersons() throws IOException {
//		Person[] persons = personRepository.getAllPersons();
//		return persons;
//	}



//	public Person[] getAllPersons() throws IOException {
//		// TODO Auto-generated method stub
//		Person[] persons = personRepository.getAllPersons();
//		return persons;
//	}	
}
