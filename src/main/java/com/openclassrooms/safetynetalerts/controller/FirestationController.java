package com.openclassrooms.safetynetalerts.controller;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;
import java.util.Map;

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
@RequestMapping
public class FirestationController {
	
	@Autowired
	private FirestationService firestationService;
	
    private static final Logger logger = LoggerFactory.getLogger(FirestationController.class);

	
	@PostMapping("/firestation")
	public Firestation addFirestation( Firestation firestation) {
		Firestation firestationAdded = firestationService.addFirestation(firestation);
	 return firestationAdded;
	}
		
	@GetMapping("/firestation")
	public Object findAddressByStationNumber(@RequestParam(required=false, defaultValue = "0") int stationNumber) throws IOException, ParseException {
		logger.info("request get OK .....");
		if(stationNumber==0) {
			return firestationService.getAllFirestations();
		}
		return firestationService.findAddressByStationNumber(stationNumber);
	}
	
	@PutMapping("/firestation/{station}")
	public Firestation updateFirestation(@PathVariable("station") String station, @RequestBody Firestation firestation) {
		 return firestationService.updateFirestation(firestation);
	}
	
	@DeleteMapping("/firestation")
	public ResponseEntity<Firestation> deleteFirestation( Firestation firestation) {
		firestationService.deleteFirestation(firestation);
		return new ResponseEntity<Firestation>(firestation,HttpStatus.GONE);
 	}
	
	@GetMapping("/phoneAlert")
	public List<String> phoneAlert(@RequestParam("firestation") int station)  {
		return firestationService.getPhoneNumberByStation(station);
	}
	
	@GetMapping("/fire")
	public Object getPersonsByAddress(@RequestParam String address) throws ParseException  {
		return firestationService.getPersonsByAddress(address);
	}
	
	@GetMapping("/flood/stations")
	
	public Object getFlood(@RequestParam List<Integer> stations) throws ParseException {
		return firestationService.getFlood(stations);
	}
}


