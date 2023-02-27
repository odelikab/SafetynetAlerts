package com.openclassrooms.safetynetalerts.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.jsoniter.fuzzy.MaybeStringIntDecoder;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

//@Entity
@Data
//@JsoniterAnnotationSupport.
//@Table(name = "firestations")
public class Firestation {
//	@Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
	
	private String address;
	private String station;
	private List<Person> persons;

}
