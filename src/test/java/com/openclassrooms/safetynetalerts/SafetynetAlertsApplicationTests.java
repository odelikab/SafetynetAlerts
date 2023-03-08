package com.openclassrooms.safetynetalerts;

import static org.assertj.core.api.Assertions.assertThat;
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
	
//	@Autowired
//	public MockMvc mockMvc;

	@Test
	void contextLoads() {
	}

	@Test
	public void testgetpersons()  {
//	String input = "{ 'firstName':'John', 'lastName':'Boyd', 'address':'1509 Culver St', 'city':'Culver', 'zip':97451, 'phone':'841-874-6512', 'email':'jaboyd@email.com' }";
//	JsonIterator.deserialize("{'firstName':'John', 'lastName':'Boyd'}", Util.class);
//	assertEquals(1,test.get("1", 0));
//  String input = "{\"persons\": { \"firstName\":\"John\", \"lastName\":\"Boyd\", \"address\":\"1509 Culver St\", \"city\":\"Culver\", \"zip\":\"97451\", \"phone\":\"841-874-6512\", \"email\":\"jaboyd@email.com\" }}";
//  InputStream inputStream = new FileInputStream("src/main/resources/data.json");

//  Any obj = JsonIterator.deserialize(input);
//Any objget = obj.get("persons");
//System.out.println(objget);
//int[] array = JsonIterator.deserialize("[1,2,3]", int[].class);
//System.out.println(array[2]);
//JsonIterator iter = JsonIterator.parse(inputStream.readAllBytes());
//Map<String,Object> util = (Map<String, Object>) iter.read();//

//    Util util = iter.read(Util.class);
//    int longueur = util.getPersons().length;
//    HashMap<String,String> mapFirestations = new HashMap<>();
//    for(Firestation firestation : util.firestations) {
//		mapFirestations.put(firestation.getAddress(),firestation.getStation());
//    }
//    List<Person> personsList = new ArrayList<>();
//    for(Person person :util.getPersons()) {
//    	personsList.add(person);
//    }
//    String stringlist = personsList.toString();
//    int sizelist = personsList.size();
//    int i = 0;
//    while(i<personsList.size())  {
//	 String modifFirstname = personsList.get(i).getFirstName();
//	 Person current=new Person();
//	if(modifFirstname=="Jacob") personsList.get(i).setAddress(input);
//	 i++;
//    }
//    
    
//     Set keys = util.keys();
//    Any textpersons = JsonIterator.deserialize(util.toString("persons"));
//    Any textFirest = JsonIterator.deserialize(util.toString("firestations"));
//    Any textMrecords = JsonIterator.deserialize(util.toString("medicalrecords"));

//   Person textclass = JsonIterator.deserialize(text,Person.class);
//   text.bindTo(null)
//  Map<String, Any> namePersons = util.asMap();
// System.out.println(util.toString());
//for (Object userObj : util) {
//    Map user = (Map) userObj;
//    List friends = (List) user.get("friends");
//    total += friends.size();
//}
//Object getPersons = util.get("persons");
// Object nameStations = util.firestations;//.getFirestations();
//Person[] namePersons = util.getPersons();
//Object nameMRecords = util.getMedicalrecords();
//String emailperson3 = namePersons[3].getEmail();
//    assertThat(util.toString());//.isEqualTo("John");
//	any.get("firstName").valueType(); // extract out the first name from all items
//	any.get("size").toLong(); // no matter it is "100" or 100, return it as long, making Java weakly typed
//	any.bindTo("firstName"); // binding the JSON into object
//	for (Any element : any) {} 
	//	Util iter = JsonIterator.deserialize(input,Util.class);//parse(input);
//	JsonIterator.deserialize(input).get("items", 0); // the first item
		
	}
}
