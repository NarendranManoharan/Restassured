package com.api.iq_concepts;

import static io.restassured.RestAssured.given;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

public class RequestSpecificationExample {

	//RequestSpecification reqSpecification;

	@BeforeSuite
	public void setspecification() {

	RestAssured.requestSpecification=given().baseUri("http://localhost:3000").basePath("/employees");
	}

	@Test
	public void getallemployees() {  

		given()
		.when().get()
		.prettyPrint();
	}

	@Test
	public void getaAnEmployee() {

		given()
		.when().get("/5")
		.prettyPrint();
	}

	@Test
	public void createEmployeeBDD() {

		RequestSpecification rs=given().baseUri("http://localhost:3000").basePath("/employees").header("Content-Type", "application/json");
		
		given().spec(rs)
		.body("{\r\n"
				+ "    \"first_name\": \"ajit\",\r\n"
				+ "    \"last_name\": \"agarkar\",\r\n"
				+ "    \"email\": \"ajit@gmail.com\"\r\n"
				+ "  }")
		
		.when()
		.post()
		.prettyPrint();
	}


}
