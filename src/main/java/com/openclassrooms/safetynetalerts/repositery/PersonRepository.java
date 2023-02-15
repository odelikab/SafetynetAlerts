package com.openclassrooms.safetynetalerts.repositery;

import java.io.IOException;
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
	
	public Person deletePerson(String firstName, String lastName) {
		int i = 0;
		Iterator<Person> itr = listPersons.iterator();

		while (itr.hasNext()) {
			String firstNameCurrent = listPersons.get(i).getFirstName();
			String lastNameCurrent = listPersons.get(i).getLastName();

			if (firstNameCurrent.equals(firstName) && lastNameCurrent.equals(lastName)) {
				int indexToRemove = listPersons.indexOf(itr.next());
//				listPersons.remove(indexToRemove);
				itr.remove();
				break;
			}
			i++;
		}
		return listPersons.get(i);
	}

	public Person updatePerson(Person person) {
		int indexToUpdate = 0;
		while (indexToUpdate < listPersons.size() - 1) {
			Person personToUpdate = listPersons.get(indexToUpdate);
			if (personToUpdate.getFirstName().equals(person.getFirstName())
					&& personToUpdate.getLastName().equals(person.getLastName())) {
				personToUpdate.setAddress(person.getAddress());
				personToUpdate.setCity(person.getCity());
				personToUpdate.setEmail(person.getEmail());
				personToUpdate.setPhone(person.getPhone());
				personToUpdate.setZip(person.getZip());
				break;
			}
			indexToUpdate++;
		}
		return person;
	}

//	public Optional<Person> findOneByNameAndFirstName(String lastName, String firstName) {
//		// TODO Auto-generated method stub
//		return null;
//	}
	
	
}
