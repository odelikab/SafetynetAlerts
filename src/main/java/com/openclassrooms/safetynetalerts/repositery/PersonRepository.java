package com.openclassrooms.safetynetalerts.repositery;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.openclassrooms.safetynetalerts.model.Person;

@Repository
public interface PersonRepository extends CrudRepository<Person, Long>{
	Person findById(int id);

//	Iterable<Person> saveAll(Iterable<Person> persons);
}
