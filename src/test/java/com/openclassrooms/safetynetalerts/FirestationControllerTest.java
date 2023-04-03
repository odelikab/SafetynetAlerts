package com.openclassrooms.safetynetalerts;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
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

import com.openclassrooms.safetynetalerts.controller.FirestationController;
import com.openclassrooms.safetynetalerts.controller.PersonController;
import com.openclassrooms.safetynetalerts.service.FirestationService;

@SpringBootTest
@AutoConfigureMockMvc
//@WebMvcTest(controllers = FirestationController.class)

public class FirestationControllerTest {

    @Autowired
    private MockMvc mockMvc;
    
    
    @Test
    public void testGetAllFirestations() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/firestation"))
            .andExpect(status().isOk())
        .andExpect(jsonPath("$.1.[0]", is("644 Gershwin Cir")));
    }

    @Test
    public void testGetFirestation() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/firestation").param("stationNumber","1"))
            .andExpect(status().isOk())
        .andExpect(jsonPath("$.['[1, {adults=5, child=1}]'].[0].firstName", is("Peter")));
    }
    
    @Test
    public void testGetUnkwownFirestation() throws Exception {
        mockMvc.perform(get("/firestation").param("stationNumber","6"))
        .andDo(print())
            .andExpect(status().isOk())
            .andExpect(result -> assertTrue(result.getResolvedException() instanceof Exception));
            }
    
    @Test
    public void testAddKnownFirestation() throws Exception {
        mockMvc.perform(post("/firestation").param("address","123 address").param("station","1"))
            .andExpect(status().isOk())
            .andDo(print())
            .andExpect(jsonPath("$.address", is("123 address")));
    }
    
    @Test
    public void testAddFirestationNew() throws Exception {
    	        mockMvc.perform(post("/firestation").param("address","123 address").param("station","5"))
            .andExpect(status().isOk())
            .andDo(print())
            .andExpect(jsonPath("$.address", is("123 address")));
    }
    
    @Test
    public void testModifyFirestation() throws Exception {
    	mockMvc.perform( MockMvcRequestBuilders
  	      .put("/firestation/{station}", "1")
  	      .content("{\"station\": \"1\"}")
  	      .contentType(MediaType.APPLICATION_JSON)
  	      .accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.station", is("1")));
    }
    
    @Test
    public void testDeleteFirestation() throws Exception {
    	mockMvc.perform(delete("/firestation").param("address", "123 address").param("station", "1"))
		.andExpect(status().isGone())
        .andExpect(jsonPath("$.address", is("123 address")));
    }
    
    @Test
    public void testPhoneAlert() throws Exception {
    	mockMvc.perform(get("/phoneAlert").param("firestation", "1"))
		.andExpect(status().isOk())
        .andExpect(jsonPath("$[0]", is("841-874-6512")));
    }
    
    @Test
    public void testFire() throws Exception {
    	mockMvc.perform(get("/fire").param("address", "748 Townings Dr"))
		.andExpect(status().isOk())
		.andDo(print())
        .andExpect(jsonPath("$.['[3, 3]'].[0].firstName", is("Foster")));
    }
    
    @Test
    public void testFloodStation() throws Exception {
    	mockMvc.perform(get("/flood/stations").param("stations", "2,3"))
		.andExpect(status().isOk())
    	.andDo(print())
        .andExpect(jsonPath("$.2.['951 LoneTree Rd'].[0].firstName", is("Eric")));
    }
}
