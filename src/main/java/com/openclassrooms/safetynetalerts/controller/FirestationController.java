package com.openclassrooms.safetynetalerts.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.openclassrooms.safetynetalerts.model.Firestation;
import com.openclassrooms.safetynetalerts.model.Person;
import com.openclassrooms.safetynetalerts.service.FirestationService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/firestation")
public class FirestationController {
	
	@Autowired
	private FirestationService firestationService;
	
	@PostMapping
	public Firestation addFirestation(@RequestBody Firestation firestation) {
		Firestation firestationAdded = firestationService.addFirestation(firestation);
	 return firestationAdded;
	}
	
	@GetMapping
	@ResponseBody
	public List<Firestation> getAllFirestations() throws IOException  {
		List<Firestation> mapFirestations = firestationService.getAllFirestations();
		return mapFirestations;
	}
	
	@PutMapping("/{station}")
	public Firestation updateFirestation(@PathVariable("station") String station, @RequestBody Firestation firestation) {
		 return firestationService.updateFirestation(firestation);
	}
	
	@DeleteMapping//("/{station}")
	public ResponseEntity<Firestation> deleteFirestation( @RequestBody Firestation firestation) {
		firestationService.deleteFirestation(firestation);
		return new ResponseEntity<>(firestation,HttpStatus.GONE);
 	}
	
//	@GetMapping("/")
//	public List<String> getStationPersons(@RequestParam String stationNumber) throws IOException   {
//		List<String> stationPersons = firestationService.findByStationNumber(stationNumber);
//		return stationPersons;
//	}

}


