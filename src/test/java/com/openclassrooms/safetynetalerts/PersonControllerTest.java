package com.openclassrooms.safetynetalerts;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.openclassrooms.safetynetalerts.controller.PersonController;
import com.openclassrooms.safetynetalerts.model.Person;
import com.openclassrooms.safetynetalerts.service.PersonServiceImpl;

//@RunWith(SpringRunner.class)
@WebMvcTest(controllers = PersonController.class)
public class PersonControllerTest {

	@Autowired
    private MockMvc mockMvc;
//	private ObjectMapper objectMapper;

    @MockBean
    private PersonServiceImpl personServiceImpl;

    @Test
    public void testGetPersons() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/person"))
        .andDo(print())
        .andExpect(status().isOk());
    }
    
    @Test
    public void testAddPersons() throws Exception {
    	ObjectMapper objectMapper = new ObjectMapper();
    	Person person = new Person(); person.setFirstName("juju");

//    	String jsonContent = objectMapper.writeValueAsString(userToSave);
        mockMvc.perform(MockMvcRequestBuilders.post("/person").contentType(MediaType.APPLICATION_JSON_VALUE)
        		.content("{\"firstName\": \"Thomas\",\"lastName\": \"Boyd\"}"))
            .andExpect(status().isOk());
    }
    
    @Test
    public void testDeletePersons() throws Exception {
    	mockMvc.perform(MockMvcRequestBuilders.delete("/person").param("firstName", "John").param("lastName", "Boyd"))
		.andExpect(status().isOk())
		.andReturn();
    }

    @Test
    public void testModifyPersons() throws Exception {
    	mockMvc.perform( MockMvcRequestBuilders
  	      .put("/person")//.param("firstName", "Odeli").param("lastName", "Kabeya")
  	      .content("{\"firstName\": \"Tony\"}")
  	      .contentType(MediaType.APPLICATION_JSON)
  	      .accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        ;
    }
    
    @Test
    public void testChildAlert() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/childAlert").param("address", "address"))
        .andDo(print())
        .andExpect(status().isOk());
    }

	@Test
	public void testPersonInfo() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/personInfo").param("firstName", "name").param("lastName", "name"))
		.andDo(print())
				.andExpect(status().isOk());
	}
	
	@Test
	public void testCommunityEmail() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/communityEmail").param("city", "city"))
		.andDo(print())
				.andExpect(status().isOk());
	}
	
	@Test
	public void testFindByName() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/person/{firstName}/{lastName}", "firstName", "lastName"))
		.andDo(print())
				.andExpect(status().isOk());
	}
}
