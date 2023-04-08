package com.openclassrooms.safetynetalerts.controller;

import java.text.ParseException;
import java.util.List;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.openclassrooms.safetynetalerts.model.Firestation;
import com.openclassrooms.safetynetalerts.service.FirestationService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
public class FirestationController {

	@Autowired
	private FirestationService firestationService;

	private static final Logger logger = LoggerFactory.getLogger(FirestationController.class);

	@PostMapping("/firestation")
	public Firestation addFirestation(Firestation firestation) {
		logger.info("add station {}", firestation);
		Firestation firestationAdded = firestationService.addFirestation(firestation);
		return firestationAdded;
	}

	@PutMapping("/firestation/{station}")
	public Firestation updateFirestation(@PathVariable("station") String station,
			@RequestBody Firestation firestation) {
		logger.info("put request for station {}", station);
		return firestationService.updateFirestation(firestation);
	}

	@DeleteMapping("/firestation")
	public ResponseEntity<Firestation> deleteFirestation(Firestation firestation) {
		logger.info("delete request for station {}", firestation);
		firestationService.deleteFirestation(firestation);
		return new ResponseEntity<Firestation>(firestation, HttpStatus.GONE);
	}

	/**
	 * Get addresses of a station provided
	 * 
	 * @param station Number
	 * @return addresses of station number
	 */
	@GetMapping("/firestation")
	public Object findAddressByStationNumber(@RequestParam(required = true) int stationNumber) {
		try {
			logger.info("getting addresses of station {}", stationNumber);
			return firestationService.findAddressByStationNumber(stationNumber);

		} catch (Exception e) {
			logger.error("exception raised {}", e);
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "failure", e);
		}
	}

	/**
	 * Get all phone numbers of a station
	 * 
	 * @param station
	 * @return phone numbers list
	 */
	@GetMapping("/phoneAlert")
	public List<String> phoneAlert(@RequestParam("firestation") int station) {
		logger.info("Phone numbers list request for station {} ", station);
		return firestationService.getPhoneNumberByStation(station);
	}

	/**
	 * Get persons of an address provided
	 * 
	 * @param address
	 * @return persons list
	 * @throws ParseException
	 */
	@GetMapping("/fire")
	public Object getPersonsByAddress(@RequestParam String address) throws ParseException {
		logger.info("Persons list for address {}", address);
		return firestationService.getPersonsByAddress(address);
	}

	/**
	 * Get persons of stations list provided
	 * 
	 * @param list of stations
	 * @return persons list
	 * @throws ParseException
	 */
	@GetMapping("/flood/stations")
	public Object getFlood(@RequestParam List<Integer> stations) throws ParseException {
		logger.info("getting people for stations {}", stations);
		return firestationService.getFlood(stations);
	}
}
