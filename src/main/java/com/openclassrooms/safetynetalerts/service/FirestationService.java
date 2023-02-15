package com.openclassrooms.safetynetalerts.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.openclassrooms.safetynetalerts.model.Firestation;
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
	public PersonServiceImpl personServiceImpl;
	
	public List<Firestation> getAllFirestations() throws IOException    {
	return firestationRepository.getAllFirestations();
	}
	
	public void findByStationNumber(String stationNumber) {
		firestationRepository.findByStationNumber(stationNumber);
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
