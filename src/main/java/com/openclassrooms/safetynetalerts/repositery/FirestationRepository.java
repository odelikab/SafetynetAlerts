package com.openclassrooms.safetynetalerts.repositery;

import org.springframework.data.repository.CrudRepository;

import com.openclassrooms.safetynetalerts.model.Firestation;

public interface FirestationRepository extends CrudRepository<Firestation, Long> {

}