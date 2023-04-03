package com.openclassrooms.safetynetalerts.repository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.openclassrooms.safetynetalerts.model.Firestation;
import com.openclassrooms.safetynetalerts.util.Util;

@Repository
public class FirestationRepository {

	public List<Firestation> listFirestations = new ArrayList<Firestation>();
	public Map<Integer, List<String>> mapFirestation = new HashMap<Integer, List<String>>();

	public FirestationRepository() throws IOException {
		Firestation[] arrayFirestation = Util.getInstance().getFirestations();
		for (Firestation firestation : arrayFirestation) {
			listFirestations.add(firestation);
			if (!mapFirestation.containsKey(Integer.valueOf(firestation.getStation()))) {
				mapFirestation.put(Integer.valueOf(firestation.getStation()), new ArrayList<String>());
			}
			mapFirestation.get(Integer.valueOf(firestation.getStation())).add(firestation.getAddress());
		}
	}

	public Map<Integer, List<String>> getAllFirestations() throws IOException {
		return mapFirestation;
	}

	public List<String> findAddressByStationNumber(int stationNumber) {
		return mapFirestation.get(stationNumber);
	}

	/**
	 * 
	 * @param stationAddress
	 * @return
	 */
	public List<Firestation> findFirestationByAddress(String stationAddress) {
		int i = 0;
		ArrayList<Firestation> listStationbyAddress = new ArrayList<Firestation>();
		while (i < listFirestations.size()) {
			if (listFirestations.get(i).getAddress().equals(stationAddress)
					&& !listStationbyAddress.contains(listFirestations.get(i))) {
				listStationbyAddress.add(listFirestations.get(i));
			}
			i++;
		}
		return listStationbyAddress;
	}

	public Firestation addFirestation(Firestation firestation) {
		// TODO Auto-generated method stub
		Integer station = Integer.valueOf(firestation.getStation());
		if (mapFirestation.get(station) != null) {
			mapFirestation.get(station).add(firestation.getAddress());
		} else {
			mapFirestation.put(station, new ArrayList<>());
			mapFirestation.get(station).add(firestation.getAddress());
		}
		return firestation;
	}

	public Firestation updateFirestation(Firestation firestationUpdate) {
//		List<Firestation> firestation = findFirestationByAddress(firestationUpdate.getAddress());
//		listFirestations.set(listFirestations.indexOf(firestation.get(0)), firestationUpdate);
		for (Integer key : mapFirestation.keySet()) {
			List<String> keyMap = mapFirestation.get(key);
			if (keyMap.contains((firestationUpdate.getAddress()))) {
				keyMap.remove((firestationUpdate.getAddress()));
			}
			break;
		}
		addFirestation(firestationUpdate);
		return firestationUpdate;
	}

	public Firestation deleteFirestation(Firestation firestation) {
		listFirestations.remove(firestation);
		mapFirestation.get(Integer.valueOf(firestation.getStation())).remove(firestation.getAddress());
		return firestation;
	}
}
