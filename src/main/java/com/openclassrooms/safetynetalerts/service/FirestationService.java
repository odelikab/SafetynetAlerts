package com.openclassrooms.safetynetalerts.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.openclassrooms.safetynetalerts.model.Firestation;
import com.openclassrooms.safetynetalerts.repositery.FirestationRepository;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Service
public class FirestationService {

	@Autowired
	private FirestationRepository firestationRepository;
	
	public List<Firestation> getAllFirestations() throws IOException    {
	return firestationRepository.getAllFirestations();
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
}
