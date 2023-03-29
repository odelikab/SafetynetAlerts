package com.openclassrooms.safetynetalerts;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.openclassrooms.safetynetalerts.controller.MedicalRecordController;
import com.openclassrooms.safetynetalerts.controller.PersonController;
import com.openclassrooms.safetynetalerts.model.MedicalRecord;
import com.openclassrooms.safetynetalerts.service.MedicalRecordService;
import com.openclassrooms.safetynetalerts.service.PersonService;
@SpringBootTest
@AutoConfigureMockMvc
//@WebMvcTest(controllers = MedicalRecordController.class)
public class MedicalRecordControllerTest {
	
	@Autowired
    private MockMvc mockMvc;

//    @MockBean
//    private MedicalRecordService medicalRecordService;
    
    @Test
    public void testGetMedicalRecord() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/medicalRecord"))
        .andDo(print())
        .andExpect(status().isOk());
    }
    
    @Test
    public void testAddMedicalRecord() throws Exception {
    	mockMvc.perform(post("/medicalRecord").contentType(MediaType.APPLICATION_JSON_VALUE)
        		.content("{\"firstName\": \"Thomas\",\"lastName\": \"Boyd\"}"))
          .andExpect(status().isCreated());
    }
    
    @Test
    public void testDeleteMedicalRecord() throws Exception {
    	mockMvc.perform(MockMvcRequestBuilders.delete("/medicalRecord").param("firstName", "John").param("lastName", "Boyd"))
		.andExpect(status().isGone())
		.andReturn();
    }

    @Test
    public void testModifyMedicalRecord() throws Exception {
    	mockMvc.perform( MockMvcRequestBuilders
  	      .put("/medicalRecord").param("firstName", "John").param("lastName", "Boyd").param("birthdate","03/06/1985")
  	      .content("\"firstName\":\"John\", \"lastName\":\"Boyd\", \"birthdate\":\"03/06/1985\", \"medications\":[\"aznol:350mg\", \"hydrapermazol:100mg\"], \"allergies\":[\"nillacilan\"] }")
  	      .contentType(MediaType.APPLICATION_JSON)
  	      .accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andDo(print())
        .andExpect(jsonPath("$.firstName", is("John")));

    }

    @Test
    public void testModifyMedicalRecordNull() throws Exception {
    	mockMvc.perform( MockMvcRequestBuilders
  	      .put("/medicalRecord").param("firstName", "Odeli").param("lastName", "Boyd")
  	      .content("{\"firstName\": \"Leo\",\r\n"
  	      		+ "        \"lastName\": \"Boyd\",\"medications\":[\"aznol:10mg\", \"hydrapermazol:10mg\"]}")
  	      .contentType(MediaType.APPLICATION_JSON)
  	      .accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andDo(print())
        ;
    }
    
}
