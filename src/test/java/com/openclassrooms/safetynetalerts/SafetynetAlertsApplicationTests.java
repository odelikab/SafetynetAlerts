package com.openclassrooms.safetynetalerts;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import com.jsoniter.JsonIterator;
import com.jsoniter.any.Any;
import com.jsoniter.any.Any.EntryIterator;
import com.openclassrooms.safetynetalerts.model.Firestation;
import com.openclassrooms.safetynetalerts.model.MedicalRecord;
import com.openclassrooms.safetynetalerts.model.Person;
import com.openclassrooms.safetynetalerts.util.Util;

@SpringBootTest
class SafetynetAlertsApplicationTests {
	
	@Test
	void contextLoads() {
	}

	@Test
	public void testgetpersons()  {
//	String input = "{ 'firstName':'John', 'lastName':'Boyd', 'address':'1509 Culver St', 'city':'Culver', 'zip':97451, 'phone':'841-874-6512', 'email':'jaboyd@email.com' }";
//  String input = "{\"persons\": { \"firstName\":\"John\", \"lastName\":\"Boyd\", \"address\":\"1509 Culver St\", \"city\":\"Culver\", \"zip\":\"97451\", \"phone\":\"841-874-6512\", \"email\":\"jaboyd@email.com\" }}";
//  InputStream inputStream = new FileInputStream("src/main/resources/data.json");

//  Any obj = JsonIterator.deserialize(input);
//int[] array = JsonIterator.deserialize("[1,2,3]", int[].class);
//JsonIterator iter = JsonIterator.parse(inputStream.readAllBytes());

//    
//    Any textpersons = JsonIterator.deserialize(util.toString("persons"));
//    Any textFirest = JsonIterator.deserialize(util.toString("firestations"));
//    Any textMrecords = JsonIterator.deserialize(util.toString("medicalrecords"));
//}
		
	}
}
