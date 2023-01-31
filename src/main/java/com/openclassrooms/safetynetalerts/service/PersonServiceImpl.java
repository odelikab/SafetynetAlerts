package com.openclassrooms.safetynetalerts.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.openclassrooms.safetynetalerts.repositery.PersonRepository;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Service
public class PersonServiceImpl  {
	
	
	private final PersonRepository personRepository;
	
//	personRepository.save()
	
}
