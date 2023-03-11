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

@Data
@AllArgsConstructor
//@JsonInclude(JsonInclude.Include.NON_NULL)

public class Person {
	@NotNull
    private String firstName;
	@NotBlank
    private String lastName;
    private String address;
    private String city;
    private String zip;
    private String phone;
    private String email;
    @JsonIgnore
    private String birthdate;

    @Override
    public boolean equals(Object o) {
        // self check
        if (this == o)
            return true;
        // null check
        if (o == null)
            return false;
        // type check and cast
        if (getClass() != o.getClass())
            return false;
        Person person = (Person) o;
        // field comparison
        return Objects.equals(firstName, person.firstName)
                && Objects.equals(lastName, person.lastName);
    }

	public Person() {
		// TODO Auto-generated constructor stub
	}

}
