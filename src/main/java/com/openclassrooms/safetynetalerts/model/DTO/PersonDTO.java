package com.openclassrooms.safetynetalerts.model.DTO;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.openclassrooms.safetynetalerts.model.Firestation;
import com.openclassrooms.safetynetalerts.model.MedicalRecord;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
//@JsonFilter("monFiltreDynamique")
@JsonInclude(JsonInclude.Include.NON_NULL)

public class PersonDTO {

	public PersonDTO() {
		// TODO Auto-generated constructor stub
	}
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
	private String station;

//	@Override
//    public String toString() {
//        return "Nom{" +firstName+
//                "id=" + id +
//                ", nom='" + nom + '\'' +
//                ", prix=" + prix +
//                '}';
//    }
	
//	public long getAge()  {
//
//		Date date1;
//		try {
//			if(medicalRecord.getFirstName().equals(firstName))  {
//			date1 = new SimpleDateFormat("dd/MM/yyyy").parse(medicalRecord.getBirthdate());
//			long age = (System.currentTimeMillis() - date1.getTime()) / 1000 / 60 / 60 / 24 / 365;
//			}
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return age;
//	}
}
