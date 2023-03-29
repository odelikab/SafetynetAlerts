package com.openclassrooms.safetynetalerts;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.openclassrooms.safetynetalerts.service.PersonService;

@SpringBootTest
@AutoConfigureMockMvc
public class PersonControllerIT {

	@Autowired
    private MockMvc mockMvc;

//	@MockBean
//    private PersonServiceImpl personServiceImpl;

    @Test
    public void testGetPersons() throws Exception {
        mockMvc.perform(get("/person"))
        .andDo(print())
        .andExpect(status().isOk())
//        .andExpect(content().contentType(MediaType.APPLICATION_JSON));
//        .andReturn().getResponse().getContentAsString();
        .andExpect(jsonPath("$[0]['firstName']", is("John")));

    }
    
    @Test
    public void testAddPersons() throws Exception {
        mockMvc.perform(post("/person"))
        .andDo(print())
        .andExpect(status().isOk())
//        .andExpect(content().contentType(MediaType.APPLICATION_JSON));
//        .andReturn().getResponse().getContentAsString();
        .andExpect(jsonPath("$[0]['firstName']", is("John")));

    }

    
    @Test
	public void testFindByName() throws Exception {
		mockMvc.perform(get("/person/{firstName}/{lastName}", "John", "Boyd"))
		.andDo(print())
				.andExpect(status().isOk())
//                .andExpect(jsonPath("$", hasSize(2)));

        .andExpect(jsonPath("$.firstName", is("John")));

	}
}
