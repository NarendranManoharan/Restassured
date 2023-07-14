package com.api.non_BDD_style;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class RequestUSingNONBDD {

	@Test(enabled = false)
	public void getallEmployees() {

		RestAssured.baseURI="http://localhost:3000";
		RequestSpecification requestSpecification=RestAssured.given();
		Response response=requestSpecification.request(Method.GET, "/employees");

		System.out.println(response.asPrettyString());
		System.out.println(response.getStatusLine());

	}

	@Test(enabled = true)
	public void getsingleEmployees() {

		RestAssured.baseURI="http://localhost:3000";
		RequestSpecification requestSpecification=RestAssured.given();
		Response response=requestSpecification.request(Method.GET, "/employees/1");

		System.out.println(response.asPrettyString());
		System.out.println(response.getStatusLine());

	}

	@Test(enabled = false)
	public void createEmployee() {
		RestAssured.baseURI="http://localhost:3000";
		RequestSpecification requestSpecification=RestAssured.given()
				.header("Content-Type", "application/json")
				.body("{\r\n"
						+ "    \"first_name\": \"virat\",\r\n"
						+ "    \"last_name\": \"kohli\",\r\n"
						+ "    \"email\": \"virat@gmail.com\"\r\n"
						+ "  }");

		Response response=requestSpecification.request(Method.POST, "/employees");

		System.out.println(response.asPrettyString());
		System.out.println(response.statusLine());	
	}

	@Test(enabled = true)
	public void updateEmployee() {
		RestAssured.baseURI="http://localhost:3000";
		RequestSpecification requestSpecification=RestAssured
				.given()
				.header("Content-Type", "application/json")
				.body("{\r\n"
						+ "    \"first_name\": \"rohit\",\r\n"
						+ "    \"last_name\": \"sharma\",\r\n"
						+ "    \"email\": \"hittuna@gmail.com\"\r\n"
						+ "  }");

		Response response=requestSpecification.request(Method.PUT, "/employees/5");
           System.out.println(response.getStatusLine());
           System.out.println(response.asPrettyString());

	}
	
	@Test(enabled = true)
	public void deleteEmployee() {
		RestAssured.baseURI="http://localhost:3000";
		
		RequestSpecification requestSpecification=RestAssured.given();
		Response response=requestSpecification.request(Method.DELETE, "/employees/5");
		
		System.out.println(response.getStatusLine());
        System.out.println(response.asPrettyString());
		
	}
}
