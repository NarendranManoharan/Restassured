package com.api.pojo_concepts;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.spi.mapper.JacksonMappingProvider;

import io.restassured.RestAssured;
import io.restassured.common.mapper.TypeRef;

public class DeserializationMethods {
	
	static File jsonfile=new File("src/test/resources/input.json");
	
	public static void deserialize() throws StreamReadException, DatabindException, IOException {
		
		ObjectMapper mapper=new ObjectMapper();
		Employee employee=mapper.readValue(jsonfile, Employee.class);
		
		System.out.println(employee.getFirst_name());
		System.out.println(employee.getLast_name());
		System.out.println(employee.getEmail());
		System.out.println(employee.getSkills());
		
	}
	
	
	public static void usingJSONPATH() throws IOException {
		
		JacksonMappingProvider jacksonMappingProvider=new JacksonMappingProvider();
		
	Configuration configuration=Configuration.builder().mappingProvider(jacksonMappingProvider).build();
		
		Employee employee=JsonPath.using(configuration).parse(jsonfile).read("$", Employee.class);
		
		System.out.println(employee.getFirst_name());
		System.out.println(employee.getLast_name());
		System.out.println(employee.getEmail());
		System.out.println(employee.getSkills());
	}
	
	public static void usingRAJsonpath() {
		Employee employee=io.restassured.path.json.JsonPath.from(jsonfile).getObject("$", Employee.class);
		System.out.println(employee.getFirst_name());
		System.out.println(employee.getLast_name());
		System.out.println(employee.getEmail());
		System.out.println(employee.getSkills());
	}

	
	public static void usingASFunction() {
		
		Map<String, Object> result=RestAssured.given()
		.baseUri("http://localhost:3000")
		.when()
		.get("/employees/5")
		.then()
		.extract()
		.body()
		.as(new TypeRef <Map<String, Object>>() {
		});
		
		System.out.println(result);
		System.out.println(result.get("first_name"));
		
		
		
	}
	public static void main(String[] args) throws StreamReadException, DatabindException, IOException {
		
		//deserialize();
		//usingJSONPATH();
		//usingRAJsonpath();
		usingASFunction();
		

	}

}
