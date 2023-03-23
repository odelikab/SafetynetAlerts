package com.openclassrooms.safetynetalerts.model;


import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

import jakarta.annotation.Nonnull;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

//@Data
//@AllArgsConstructor
//@JsonInclude(JsonInclude.Include.NON_NULL)

public class Person {
	@NotBlank
    private String firstName;
	@NotBlank
    private String lastName;
    private String address;
    private String city;
    private String zip;
    private String phone;
    private String email;

//    @Override
//    public boolean equals(Object o) {
//        // self check
//        if (this == o)
//            return true;
//        // null check
//        if (o == null)
//            return false;
//        // type check and cast
//        if (getClass() != o.getClass())
//            return false;
//        Person person = (Person) o;
//        // field comparison
//        return Objects.equals(firstName, person.firstName)
//                && Objects.equals(lastName, person.lastName);
//    }

	public Person() {
		// TODO Auto-generated constructor stub
	}

	public Person(@NotNull String firstName, @NotBlank String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
