package com.api.restassured;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;

public class DeleteRequestBDD {

	@Test
	public void deleterequest() {
     RestAssured.baseURI="https://reqres.in/api";
		
		ValidatableResponse response =RestAssured
		.given()
		.delete("/users/3")
		.then()
		.statusCode(204);
		System.out.println(response);
		
		 
	}
}
