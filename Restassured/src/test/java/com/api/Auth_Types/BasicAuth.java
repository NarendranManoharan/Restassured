package com.api.Auth_Types;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class BasicAuth {
	
	@Test
	public void basicauth() {
		
		RestAssured.given()
		.auth()
		   .basic("postman", "password")
		    .baseUri("https://postman-echo.com")
		.when()
		    .get("/basic-auth")
		.prettyPrint();
	}

}
