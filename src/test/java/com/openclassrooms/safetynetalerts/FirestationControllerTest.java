package com.openclassrooms.safetynetalerts;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
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

//@SpringBootTest
@WebMvcTest(controllers = FirestationController.class)

public class FirestationControllerTest {

    @Autowired
    private MockMvc mockMvc;
    
    @MockBean
    FirestationService firestationService;

    @Test
    public void testGetFirestation0() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/firestation"))
            .andExpect(status().isOk());
    }

    @Test
    public void testGetFirestations() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/firestation").param("stationNumber", "1"))
            .andExpect(status().isOk());
    }
    
    @Test
    public void testAddFirestation() throws Exception {
    	String jsonContent = "{\r\n"
    			+ "    \"firstName\": \"John\",\r\n"
    			+ "    \"lastName\": \"Boyd\",";
        mockMvc.perform(post("/firestation").content(jsonContent))
            .andExpect(status().isOk());
    }
    
    @Test
    public void testModifyFirestation() throws Exception {
    	mockMvc.perform( MockMvcRequestBuilders
  	      .put("/firestation/{station}", "1")
  	      .content("{\"station\": \"1\"}")
  	      .contentType(MediaType.APPLICATION_JSON)
  	      .accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        ;
    }
    
    @Test
    public void testDeleteFirestation() throws Exception {
    	mockMvc.perform(delete("/firestation").param("address", "123 address").param("station", "1"))
		.andExpect(status().isGone())
		.andReturn();
    }
    
    @Test
    public void testPhoneAlert() throws Exception {
    	mockMvc.perform(get("/phoneAlert").param("firestation", "1"))
		.andExpect(status().isOk())
		;
    }
    
    @Test
    public void testFire() throws Exception {
    	mockMvc.perform(get("/fire").param("address", "123 address"))
		.andExpect(status().isOk())
		;
    }
    
    @Test
    public void testFloodStation() throws Exception {
    	mockMvc.perform(get("/flood/stations").param("stations", "1,2,3"))
		.andExpect(status().isOk())
		;
    }


    
}
