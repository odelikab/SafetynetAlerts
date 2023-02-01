package com.openclassrooms.safetynetalerts.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.openclassrooms.safetynetalerts.model.Firestation;
import com.openclassrooms.safetynetalerts.repositery.FirestationRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/firestation")
public class FirestationController {
	
	public final FirestationRepository firestationRepository;
	
	@PostMapping
	public Iterable<Firestation> addPerson(@RequestBody List<Firestation> firestation) {
		Iterable<Firestation> firestationAdded = firestationRepository.saveAll(firestation);
	 return firestationAdded;
	}
	
//	@PutMapping
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


