package com.api.pojo_concepts;

import java.util.Arrays;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class SerializeandDeserialize {

	  ObjectMapper mapper=new ObjectMapper();
	  String EmployeeAsJson;
	  
	public void serialize() throws JsonProcessingException {
		Employee employee1=new Employee();
		employee1.setFirst_name("Grame");
		employee1.setLast_name("Smith");
		employee1.setEmail("grame@gmail.com");
		//employee1.setSkills(Arrays.asList("Java","Selenium"));
		
		/*System.out.println(employee1.getFirst_name());
		System.out.println(employee1.getLast_name());
		System.out.println(employee1.getEmail());
		System.out.println(employee1.getSkills());*/
		
	  
	    
	   EmployeeAsJson=mapper.writerWithDefaultPrettyPrinter().writeValueAsString(employee1);
	    System.out.println(EmployeeAsJson);	
	}
	
	public void deserialize() throws JsonMappingException, JsonProcessingException {
		String EmployeeAsJson="{\r\n"
				+ "  \"skills\" : [ \"Java\", \"Selenium\" ],\r\n"
				+ "  \"email\" : \"grame@gmail.com\",\r\n"
				+ "  \"last_name\" : \"Smith\",\r\n"
				+ "  \"first_name\" : \"Grame\"\r\n"
				+ "}";
		Employee employeePOJO=  mapper.readValue(EmployeeAsJson, Employee.class);
		/*  System.out.println(employeePOJO.getFirst_name());
		  System.out.println(employeePOJO.getLast_name());
		  System.out.println(employeePOJO.getEmail());
		  System.out.println(employeePOJO.getSkills()); */
	}
	public static void main(String[] args) throws JsonProcessingException {
		
		SerializeandDeserialize serializeandDeserialize=new SerializeandDeserialize();
		serializeandDeserialize.deserialize();
		
	  
	}

}
