package com.openclassrooms.safetynetalerts.repositery;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jsoniter.JsonIterator;
import com.jsoniter.any.Any;
import com.openclassrooms.safetynetalerts.model.Person;
import com.openclassrooms.safetynetalerts.util.Util;

@Repository
public class PersonRepository {
//	Person findPersonByName(String name);
	
	public Util dataExtract() throws IOException{
	InputStream inputStream = new FileInputStream("C:\\STS\\safetynetalerts\\src\\main\\resources\\data.json");
	JsonIterator iter = JsonIterator.parse(inputStream.readAllBytes());
	Util util = iter.read(Util.class);
	iter.close();
	inputStream.close();
	return util;
	}

	public List<Person> getAllPersons() throws IOException   {
//	    Any textpersons = JsonIterator.deserialize(FileToString().toString());
		Person[] Allpersons = dataExtract().getPersons();
		List<Person> personsList = new ArrayList<Person>(Allpersons.length);
		for (Person person : Allpersons) {
			personsList.add(person);
		}
		return personsList;

	}
	
	public void getPersonByEmail()   {
		
	}
	
	public void addPerson()  {
		
	}
	
	public void deletePerson()  {
		
	}
	
	public void updatePerson()  {
		
	}
//	Iterable<Person> saveAll(Iterable<Person> persons);
}
