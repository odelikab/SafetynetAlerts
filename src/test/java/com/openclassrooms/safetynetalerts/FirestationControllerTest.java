package com.openclassrooms.safetynetalerts;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import com.openclassrooms.safetynetalerts.controller.FirestationController;
import com.openclassrooms.safetynetalerts.controller.PersonController;

@SpringBootTest
@AutoConfigureMockMvc
@WebMvcTest(controllers = FirestationController.class)

public class FirestationControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testGetFirestations() throws Exception {
        mockMvc.perform(get("/firestation"))
            .andExpect(status().isOk());
    }
    
    @Test
    public void testAddFirestations() throws Exception {
        mockMvc.perform(post("/firestation"))
            .andExpect(status().isOk());
    }
    
}
