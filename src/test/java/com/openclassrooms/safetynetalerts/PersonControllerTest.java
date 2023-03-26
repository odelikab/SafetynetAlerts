package com.openclassrooms.safetynetalerts;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.openclassrooms.safetynetalerts.controller.PersonController;
import com.openclassrooms.safetynetalerts.model.Person;
import com.openclassrooms.safetynetalerts.service.PersonServiceImpl;

@SpringBootTest
@AutoConfigureMockMvc
//@WebMvcTest(controllers = PersonController.class)
public class PersonControllerTest {

	@Autowired
    private MockMvc mockMvc;
//	private ObjectMapper objectMapper;

//    @MockBean
//    private PersonServiceImpl personServiceImpl;

    @Test
    public void testGetPersons() throws Exception {
        mockMvc.perform(get("/person"))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(jsonPath("$[0]['firstName']", is("John")));


    }
    
    @Test
    public void testAddPersons() throws Exception {
    	ObjectMapper objectMapper = new ObjectMapper();
    	Person person = new Person(); person.setFirstName("juju");

//    	String jsonContent = objectMapper.writeValueAsString(userToSave);
        mockMvc.perform(MockMvcRequestBuilders.post("/person").contentType(MediaType.APPLICATION_JSON_VALUE)
        		.content("{\"firstName\": \"Thomas\",\"lastName\": \"Boyd\"}"))
            .andExpect(status().isCreated())
            .andExpect(jsonPath("$.firstName", is("Thomas")));
    }
    
    @Test
    public void testDeletePersons() throws Exception {
    	mockMvc.perform(MockMvcRequestBuilders.delete("/person").param("firstName", "John").param("lastName", "Boyd"))
		.andExpect(status().isGone())
        .andExpect(jsonPath("$.firstName", is("John")))
		.andReturn();
    }

    @Test
    public void testModifyPersons() throws Exception {
    	mockMvc.perform( MockMvcRequestBuilders
  	      .put("/person")//.param("firstName", "Odeli").param("lastName", "Kabeya")
  	      .content("{\"firstName\": \"John\",\r\n"
  	      		+ "        \"lastName\": \"Boyd\",\"address\":\"6000 Culver St\"}")
  	      .contentType(MediaType.APPLICATION_JSON)
  	      .accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.firstName", is("John")));

    }
    
    @Test
    public void testChildAlert() throws Exception {
        mockMvc.perform(get("/childAlert").param("address", "1509 Culver St"))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(jsonPath("$[0].firstName", is("Tenley")));

    }

	@Test
	public void testPersonInfo() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/personInfo").param("firstName", "Tenley").param("lastName", "Boyd"))
		.andDo(print())
				.andExpect(status().isOk())
		        .andExpect(jsonPath("$[0].firstName", is("John")));

	}
	
	@Test
	public void testCommunityEmail() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/communityEmail").param("city", "Culver"))
		.andDo(print())
				.andExpect(status().isOk())
		        .andExpect(jsonPath("$[0]", is("jaboyd@email.com")));

	}
	
	@Test
	public void testFindByName() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/person/{firstName}/{lastName}", "Felicia", "Boyd"))
		.andDo(print())
				.andExpect(status().isOk())
		        .andExpect(jsonPath("$.firstName", is("Felicia")));

	}
}
