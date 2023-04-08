package com.openclassrooms.safetynetalerts.service;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.openclassrooms.safetynetalerts.model.Firestation;
import com.openclassrooms.safetynetalerts.model.MedicalRecord;
import com.openclassrooms.safetynetalerts.model.Person;
import com.openclassrooms.safetynetalerts.model.DTO.PersonDTO;
import com.openclassrooms.safetynetalerts.repository.FirestationRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class FirestationService {

	@Autowired
	private FirestationRepository firestationRepository;
	@Autowired
	private PersonService personServiceImpl;
	@Autowired
	private MedicalRecordService medicalRecordService;

	public Map<Integer, List<String>> getAllFirestations() throws IOException {
		return firestationRepository.getAllFirestations();
	}

	public HashMap<Object, Object> findAddressByStationNumber(int stationNumber) throws ParseException {
		List<String> addresses = firestationRepository.findAddressByStationNumber(stationNumber);
		HashMap<Object, Object> mapPersonsDTO = new HashMap<>();
		if (addresses == null)
			return mapPersonsDTO;
		else {
			List<Object> persons = new ArrayList<>();
			List<Object> obj = new ArrayList<>();
			int adults = 0;
			int child = 0;
			HashMap<Object, Object> mapCount = new HashMap<>();

			for (String address : addresses) {
				ArrayList<Person> personsByAddress = personServiceImpl.getPersonsByAddress(address);
				for (Person person : personsByAddress) {
					PersonDTO personDTO = new PersonDTO();
					personDTO.setFirstName(person.getFirstName());
					personDTO.setLastName(person.getLastName());
					personDTO.setPhone(person.getPhone());
					personDTO.setAddress(person.getAddress());
					MedicalRecord medicalRecord = medicalRecordService.findByName(person.getFirstName(),
							person.getLastName());
					String birthday = medicalRecord.getBirthdate();
					personDTO.setAge(
							personServiceImpl.getPersonAge(person.getFirstName(), person.getLastName(), birthday));
					persons.add(personDTO);
					if (personDTO.getAge() >= 18) {
						adults++;
					} else {
						child++;
					}
				}
			}
			mapCount.put("adults", adults);
			mapCount.put("child", child);
			obj.add(stationNumber);
			obj.add(mapCount);
			mapPersonsDTO.put(obj, persons);
		}
		return mapPersonsDTO;
	}

	public List<Firestation> findFirestationByAddress(String address) {
		return firestationRepository.findFirestationByAddress(address);
	}

	public Firestation addFirestation(Firestation firestation) {
		firestationRepository.addFirestation(firestation);
		return firestation;
	}

	public Firestation deleteFirestation(Firestation firestation) {
		return firestationRepository.deleteFirestation(firestation);
	}

	public Firestation updateFirestation(Firestation firestation) {
		return firestationRepository.updateFirestation(firestation);
	}

	public List<String> getPhoneNumberByStation(int station) {
		List<String> listStationAddress = firestationRepository.findAddressByStationNumber(station);
		List<Person> listPersons = personServiceImpl.getAllPersons();
		List<String> listPhoneNumbers = new ArrayList<>();
		int i = 0;
		for (String address : listStationAddress) {
			while (i < listPersons.size()) {
				if (listPersons.get(i).getAddress().equals(address)) {
					listPhoneNumbers.add(listPersons.get(i).getPhone());
				}
				i++;
			}
		}
		return listPhoneNumbers;
	}

	public HashMap<Object, Object> getPersonsByAddress(String address) throws ParseException {
		List<Person> listPersons = personServiceImpl.getAllPersons();
		List<PersonDTO> listPersonsByAddress = new ArrayList<>();
		HashMap<Object, Object> mapPersons = new HashMap<>();
		for (Person person : listPersons) {
			if (person.getAddress().equals(address)) {
				PersonDTO personDTO = new PersonDTO();
				personDTO.setFirstName(person.getFirstName());
				personDTO.setLastName(person.getLastName());
				personDTO.setPhone(person.getPhone());
				String birthday = medicalRecordService.findByName(person.getFirstName(), person.getLastName())
						.getBirthdate();
				personDTO.setAge(personServiceImpl.getPersonAge(person.getFirstName(), person.getLastName(), birthday));
				personDTO
						.setMedicalRecord(medicalRecordService.findByName(person.getFirstName(), person.getLastName()));
				listPersonsByAddress.add(personDTO);
			}
		}
		mapPersons.put(findFirestationByAddress(address), listPersonsByAddress);
		return mapPersons;
	}

	public HashMap<Object, Object> getFlood(List<Integer> stations) throws ParseException {
		HashMap<Object, Object> mapFlood = new HashMap<>();
		for (Integer station : stations) {
			HashMap<Object, Object> mapByAddress = new HashMap<>();
			List<Person> listPersons = new ArrayList<>();
			List<String> listAddress = firestationRepository.findAddressByStationNumber(station);
			for (String address : listAddress) {
				ArrayList<Object> listPersonsDTO = new ArrayList<>();
				listPersons = personServiceImpl.getPersonsByAddress(address);
				for (Person person : listPersons) {
					PersonDTO personDTO = new PersonDTO();
					personDTO.setFirstName(person.getFirstName());
					personDTO.setLastName(person.getLastName());
					personDTO.setPhone(person.getPhone());
					MedicalRecord medicalRecord = new MedicalRecord();
					medicalRecord = medicalRecordService.findByName(person.getFirstName(), person.getLastName());
					String birthday = medicalRecord.getBirthdate();
					personDTO.setAge(
							personServiceImpl.getPersonAge(person.getFirstName(), person.getLastName(), birthday));
					personDTO.setMedicalRecord(
							medicalRecordService.findByName(person.getFirstName(), person.getLastName()));
					listPersonsDTO.add(personDTO);
				}
				mapByAddress.put(address, listPersonsDTO);
			}
			mapFlood.put(station, mapByAddress);
		}
		return mapFlood;
	}
}
