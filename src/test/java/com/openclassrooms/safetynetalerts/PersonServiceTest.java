package com.openclassrooms.safetynetalerts;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.openclassrooms.safetynetalerts.model.Person;
import com.openclassrooms.safetynetalerts.repositery.PersonRepository;
import com.openclassrooms.safetynetalerts.service.PersonServiceImpl;

@SpringBootTest
public class PersonServiceTest {

	
	@MockBean
	private PersonRepository personRepo;
	
	@Autowired
	private PersonServiceImpl personServiceImpl;
	
	@Test
	public void testFindByName() {
		Person personTest = new Person();
		personTest.setFirstName("Bob");
		personTest.setLastName("Mathieu");
		when(personRepo.findByName("Bob","Mathieu")).thenReturn(personTest);
		
		Person person = personServiceImpl.findByName("Bob","Mathieu");

//		assertEquals("Bob",person.getFirstName());
		verify(personRepo,times(1)).findByName("Bob","Mathieu");
	}
	
}
