package com.openclassrooms.safetynetalerts.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
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
	
//	public final FirestationRepository firestationRepository;
	
//	@PostMapping
//	public Firestation addFirestation(@RequestBody Firestation firestation) {
//		Firestation firestationAdded = firestationRepository.addFirestation(firestation);
//	 return firestationAdded;
//	}
//	
//	@GetMapping
//	public Map<String,String> getAllFirestations() throws IOException {
//		Map<String, String> mapFirestations = firestationRepository.getAllFirestations();
//		return mapFirestations;
//	}
	
//	@PutMapping("/firestation/{id}")
//	public void updateFirestation(@PathVariable(value = "id") Long id) {
//		 firestationRepository.deleteById(id);
//	}
//	
//	@DeleteMapping(value = "/")
//	public ResponseEntity<Void> deleteFirestation(@RequestParam(value = "id", required = true) Long id) {
//		firestationRepository.deleteById(id);
//		return new ResponseEntity<Void>(HttpStatus.GONE);
// 	}
	

}


