package com.openclassrooms.safetynetalerts.repositery;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

import org.springframework.data.repository.CrudRepository;

import com.jsoniter.JsonIterator;
import com.openclassrooms.safetynetalerts.model.Firestation;
import com.openclassrooms.safetynetalerts.model.Person;
import com.openclassrooms.safetynetalerts.util.Util;

public class FirestationRepository  {

public Map<String, String> mapFirestations;
	
//	public Util dataExtract() throws IOException{
//	InputStream inputStream = new FileInputStream("src/main/resources/data.json");
//	JsonIterator iter = JsonIterator.parse(inputStream.readAllBytes());
//	Util util = iter.read(Util.class);
//	iter.close();
//	inputStream.close();
//	return util;
//	}
//	
//	public Map<String,String> getAllFirestations() throws IOException   {
//		Firestation[] allFirestations = dataExtract().getFirestations();
//		for(Firestation firestation : allFirestations) {
//			mapFirestations.put(firestation.getAddress(),firestation.getStation());
//		}
//		
//		return mapFirestations;
//
//		
//	}

	public Firestation addFirestation(Firestation firestation) {
		// TODO Auto-generated method stub
		mapFirestations.put(firestation.getAddress(),firestation.getStation());
		return firestation;
	}
}
