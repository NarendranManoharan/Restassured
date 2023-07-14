package com.api.json_schema_validation;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;

public class RestAssuredJsonschemaValidation {

	@Test
	public void ValidationUsingJsonSchemaInClasspath() {

		File jsoninput=new File("src/test/resources/input.json");

		RestAssured
		.given()
		.baseUri("http://localhost:3000")
		.header("Content-Type", "application/json")
		.body(jsoninput)
		.when()
		.post("/employees")
		.then()
		.body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schema.json"));			

	}


	@Test
	public void ValidationUsingMatchesJsonSchema() {

		File jsoninput=new File("src/test/resources/input.json");
		File schema=new File("C:\\Users\\shaeva\\Desktop\\naren\\New folder\\schema.json");
		RestAssured
		.given()
		.baseUri("http://localhost:3000")
		.header("Content-Type", "application/json")
		.body(jsoninput)
		.when()
		.post("/employees")
		.then()
		.body(JsonSchemaValidator.matchesJsonSchema(schema));
	}
}
