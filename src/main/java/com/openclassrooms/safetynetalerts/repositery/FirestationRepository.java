package com.openclassrooms.safetynetalerts.repositery;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.openclassrooms.safetynetalerts.model.Firestation;
import com.openclassrooms.safetynetalerts.util.Util;

@Repository
public class FirestationRepository  {

public List<Firestation> listFirestations = new ArrayList<Firestation>();
	
public FirestationRepository() throws IOException  {
	Firestation[] arrayFirestation = Util.getInstance().getFirestations();
	for (Firestation firestation : arrayFirestation) {
		listFirestations.add(firestation);
	}
}
	
	public List<Firestation> getAllFirestations() throws IOException   {
		return listFirestations;
	}
	
	public Firestation findByStationNumber(String stationNumber) {
		int i = 0;
		while (i < listFirestations.size()) {
			if (listFirestations.get(i).getStation().equals(stationNumber)) {
				return listFirestations.get(i);
			}
			i++;
		}
		return null;
	}
	
	public Firestation findByAddress(String stationAddress) {
		int i = 0;
		while (i < listFirestations.size()) {
			if (listFirestations.get(i).getAddress().equals(stationAddress)) {
				return listFirestations.get(i);
			}
			i++;
		}
		return null;
	}

	public Firestation addFirestation(Firestation firestation) {
		// TODO Auto-generated method stub
		listFirestations.add(firestation);
		return firestation;
	}
	
	public Firestation updateFirestation(Firestation firestationUpdate) {
//		int i = 0;
//		while (i < listFirestations.size()) {
//			if (listFirestations.get(i).getAddress().equals(firestation.getAddress())) {
//				listFirestations.set(i, firestation);
//				break;
//			}
//			i++;
//		}
		 Firestation firestation = findByAddress(firestationUpdate.getAddress());
		listFirestations.set(listFirestations.indexOf(firestation), firestationUpdate);
		return firestationUpdate;
	}
	
	public Firestation deleteFirestation(Firestation firestation)  {
		listFirestations.remove(firestation);
		return firestation;
		
	}
	
	
}
