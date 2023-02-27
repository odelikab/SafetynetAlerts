package com.openclassrooms.safetynetalerts.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.openclassrooms.safetynetalerts.model.Firestation;
import com.openclassrooms.safetynetalerts.model.MedicalRecord;
import com.openclassrooms.safetynetalerts.model.Person;
import com.openclassrooms.safetynetalerts.repositery.FirestationRepository;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Service
public class FirestationService {

	@Autowired
	private FirestationRepository firestationRepository;
	@Autowired
	public PersonServiceImpl personServiceImpl;
	public MedicalRecordService medicalRecordService;
	
	public Map<Integer, List<String>> getAllFirestations() throws IOException    {
	return firestationRepository.getAllFirestations();
	}
	
	public List<String> findByStationNumber(int stationNumber) {
		return firestationRepository.findAddressByStationNumber(stationNumber);
	}
	
	public Firestation addFirestation(Firestation firestation)  {
		firestationRepository.addFirestation(firestation);
		return firestation;
	}
	
    public Firestation deleteFirestation(Firestation firestation)   {
    	return firestationRepository.deleteFirestation(firestation);
    }
    
    public Firestation updateFirestation(Firestation firestation)  {
    	return firestationRepository.updateFirestation(firestation);
    }

	public List<String> getPhoneNumberByStation(int station) {
		ArrayList<String> listStationAddress = firestationRepository.findAddressByStationNumber(station);
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

	public List<Person> getPersonsByAddress(String address) {
		List<Firestation> listFire = firestationRepository.findFirestationByAddress(address);
		List<Person> listPersons = personServiceImpl.getAllPersons();
		List<Person> listPersonsByAddress = new ArrayList<>();
		int i =0;
		for(Person person : listPersons) {
		if(person.getAddress().equals(address)) {
			listPersonsByAddress.add(person);
//			MedicalRecord medicalRecord = medicalRecordService.findByName(person.getFirstName(), person.getLastName());
//		listFire.get(i).setMedicalRecord(medicalRecord);
		} i++;
		}
		return listPersonsByAddress;
	}

//	public List<String> findByStationNumber(String stationNumber) throws IOException {
//		// TODO Auto-generated method stub
//		getAllFirestations();
//		List<String> listAddressByStation = new ArrayList<>();
//		int i = 0;
//		while (i < getAllFirestations().size()) {
//			if (getAllFirestations().get(i).getStation().equals(stationNumber)) {
//				listAddressByStation.add(getAllFirestations().get(i).getAddress());
//			}
//			i++;
//		}
//		int k = 0, j = 0;
//		while(i<personServiceImpl.getAllPersons().size()) {
//		if(personServiceImpl.getAllPersons().get(k).getAddress().equals(listAddressByStation.get(j)))  {
//			;
//		}
//		//		person.getAddress
//		}
//		
//		return listAddressByStation;
//	}
}
