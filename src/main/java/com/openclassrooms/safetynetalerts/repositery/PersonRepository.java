package com.openclassrooms.safetynetalerts.repositery;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jsoniter.JsonIterator;
import com.jsoniter.any.Any;
import com.openclassrooms.safetynetalerts.model.Person;
import com.openclassrooms.safetynetalerts.util.Util;


@Repository
public class PersonRepository {
	
	public List<Person> listPersons = new ArrayList<Person>();
	
		public PersonRepository() throws IOException  {
			Person[] arrayPersons = Util.getInstance().getPersons();
			for (Person person : arrayPersons) {
				listPersons.add(person);
			}
		}
	
	public List<Person> getAllPersons()   {
		return listPersons;

	}
	
	public Person getPersonByEmail()   {
		return null;
		
	}
	
	public Person addPerson(Person person)   {
		listPersons.add(person);
		return person;
		
 	}
	
	public Person deletePerson(String firstName, String lastName)  {
		int i = 0;
//		listPersons.c
//		Object obj = listPersons.toString();
//		listPersons.indexOf(obj);
		Iterator<Person> itr = listPersons.iterator();

		while (itr.hasNext()) {
			String firstNameCurrent = itr.next().getFirstName();
			String lastNameCurrent = itr.next().getLastName();

			if (firstNameCurrent.equals(firstName) && lastNameCurrent.equals(lastName)) {
//				 && itr.next().getLastName() == lastName
				int indexToRemove = listPersons.indexOf(itr.next());
				
				listPersons.remove(indexToRemove);
				itr.remove();
				break;
			}
		}
		return listPersons.get(0);
	}
	
		public void updatePerson(Person person) throws IOException  {

	}

	public Optional<Person> findOneByNameAndFirstName(String lastName, String firstName) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
