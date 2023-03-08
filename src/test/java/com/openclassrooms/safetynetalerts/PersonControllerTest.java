package com.openclassrooms.safetynetalerts;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.openclassrooms.safetynetalerts.controller.PersonController;
import com.openclassrooms.safetynetalerts.service.PersonServiceImpl;

@WebMvcTest(controllers = PersonController.class)
public class PersonControllerTest {

	@Autowired
    private MockMvc mockMvc;

    @MockBean
    private PersonServiceImpl personServiceImpl;

    @Test
    public void testGetPersons() throws Exception {
        mockMvc.perform(get("/person"))
            .andExpect(status().isOk());
    }

}
