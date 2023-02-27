package com.openclassrooms.safetynetalerts.model.DTO;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.openclassrooms.safetynetalerts.model.MedicalRecord;
import lombok.Data;

@Data
//@JsonFilter("monFiltreDynamique")
public class PersonDTO {

	private String firstName;
	private String lastName;
	private String address;
	private String city;
	private String zip;
	private String phone;
	private String email;
	private Long age;
	private List<String> familyMembers;
	private MedicalRecord medicalRecord;

	public long getAge()  {
//	while (i < listPersons.size()) {

		Date date1;
		try {
			if(medicalRecord.getFirstName().equals(firstName))  {
			date1 = new SimpleDateFormat("dd/MM/yyyy").parse(medicalRecord.getBirthdate());
			long age = (System.currentTimeMillis() - date1.getTime()) / 1000 / 60 / 60 / 24 / 365;
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return age;
	}
}
