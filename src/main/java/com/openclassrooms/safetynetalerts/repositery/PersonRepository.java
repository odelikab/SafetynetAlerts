package com.openclassrooms.safetynetalerts.repositery;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jsoniter.JsonIterator;
import com.jsoniter.any.Any;
import com.openclassrooms.safetynetalerts.model.Person;
import com.openclassrooms.safetynetalerts.model.DTO.PersonDTO;
import com.openclassrooms.safetynetalerts.util.Util;

@Repository
public class PersonRepository {
	
	public List<Person> listPersons = new ArrayList<Person>();
	MedicalRecordRepository medicalRecordRepository = new MedicalRecordRepository();
	
		public PersonRepository() throws IOException, ParseException  {
			Person[] arrayPersons = Util.getInstance().getPersons();
			for (Person person : arrayPersons) {
				listPersons.add(person);
			}
//			getPersonsAge();
		}
	
	public List<Person> getAllPersons()   {
		return listPersons;

	}
	
	public Person findByName(String firstName, String lastName) {
		int i = 0;
		Person person = new Person();
		while(i<listPersons.size()) {
			person = listPersons.get(i);
			if(person.getFirstName().equals(firstName)
					&& person.getLastName().equals(lastName)) {
				return person;
			}
			i++;
		}
		return null;
	}
	
	public List<String> getFamilyMembers(String firstName, String lastName) {
		int i = 0;
		List<String> family = new ArrayList<>();
		while (i < listPersons.size()) {
			if (listPersons.get(i).getLastName().equals(lastName) && listPersons.get(i).getFirstName() != firstName) {
				family.add(listPersons.get(i).getFirstName());
//				listPersons.get(i).setFamilyMembers(family);
			}
			i++;
		}
		return family;
	}
	
	public Person addPerson(Person person)   {
		listPersons.add(person);
		return person;
 	}
	
	public Person deletePerson(String firstName, String lastName) {
//		int i = 0;
//		Iterator<Person> itr = listPersons.iterator();
//		while (itr.hasNext()) {
//			String firstNameCurrent = listPersons.get(i).getFirstName();
//			String lastNameCurrent = listPersons.get(i).getLastName();
//			if (firstNameCurrent.equals(firstName) && lastNameCurrent.equals(lastName)) {
//				int indexToRemove = listPersons.indexOf(itr.next());
////				listPersons.remove(indexToRemove);
//				itr.remove();
//				break;
//			}
//			i++;
//		}
		Person person = findByName(firstName, lastName);
		listPersons.remove(person);
		return person;
	}

	public Person updatePerson(Person personToUpdate) {
		String firstName = personToUpdate.getFirstName();
		String lastName = personToUpdate.getLastName();
		Person person = findByName(firstName, lastName);
		listPersons.set(listPersons.indexOf(person),personToUpdate);
		return personToUpdate;
//		int indexToUpdate = 0;
//		while (indexToUpdate < listPersons.size() - 1) {
//			Person personToUpdate = listPersons.get(indexToUpdate);
//			if (personToUpdate.getFirstName().equals(person.getFirstName())
//					&& personToUpdate.getLastName().equals(person.getLastName())) {
//				personToUpdate.setAddress(person.getAddress());
//				personToUpdate.setCity(person.getCity());
//				personToUpdate.setEmail(person.getEmail());
//				personToUpdate.setPhone(person.getPhone());
//				personToUpdate.setZip(person.getZip());
//				break;
//			}
//			indexToUpdate++;
//		}
	}
}
