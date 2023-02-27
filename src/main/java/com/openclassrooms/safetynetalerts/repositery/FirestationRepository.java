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
public Map<Integer, List<String>> mapFirestation = new HashMap<Integer, List<String>>();
	
public FirestationRepository() throws IOException  {
	Firestation[] arrayFirestation = Util.getInstance().getFirestations();
	for (Firestation firestation : arrayFirestation) {
		listFirestations.add(firestation);
		if (!mapFirestation.containsKey(Integer.valueOf(firestation.getStation()))) {
		mapFirestation.put(Integer.valueOf(firestation.getStation()), new ArrayList<String>());
		}
		mapFirestation.get(Integer.valueOf(firestation.getStation())).add(firestation.getAddress());
	}
}
	
	public Map<Integer, List<String>> getAllFirestations() throws IOException   {
		return mapFirestation;
	}
	
	public ArrayList<String> findAddressByStationNumber(int stationNumber) {
		int i = 0;
		ArrayList<String> listAddressbyStationNumber = new ArrayList<>();
		while (i < listFirestations.size()) {
			if (Integer.valueOf(listFirestations.get(i).getStation())==(stationNumber)) {
				listAddressbyStationNumber.add(listFirestations.get(i).getAddress());
			}
			i++;
		}
		return listAddressbyStationNumber;
	}
	
	public List<Firestation> findFirestationByAddress(String stationAddress) {
		int i = 0;
		ArrayList<Firestation> listStationbyAddress = new ArrayList<Firestation>();
		while (i < listFirestations.size()) {
			if (listFirestations.get(i).getAddress().equals(stationAddress)) {
				listStationbyAddress.add(listFirestations.get(i));
			}
			i++;
		}
		return listStationbyAddress;
	}

	public Firestation addFirestation(Firestation firestation) {
		// TODO Auto-generated method stub
		listFirestations.add(firestation);
		return firestation;
	}
	
	public Firestation updateFirestation(Firestation firestationUpdate) {
		 List<Firestation> firestation = findFirestationByAddress(firestationUpdate.getAddress());
		 firestation.get(0);
		listFirestations.set(listFirestations.indexOf(firestation.get(0)), firestationUpdate);
		return firestationUpdate;
	}
	
	public Firestation deleteFirestation(Firestation firestation)  {
		listFirestations.remove(firestation);
		return firestation;
		
	}
	
	
}
