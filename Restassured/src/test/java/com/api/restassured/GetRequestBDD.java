package com.api.restassured;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.response.ValidatableResponse;

public class GetRequestBDD {

	@Test
	public void getrequest() {
		Response response=RestAssured.get("https://reqres.in/api/users/2");
		int statuscode=response.statusCode();
		ResponseBody body= response.getBody();
		System.out.println(body.asPrettyString());
		System.out.println(statuscode);
		
	}
	
	@Test
	public void getrequestBDD() {
		
		RestAssured.baseURI="http://localhost:3000";
		
		Response response =RestAssured
		.given().param("", "").header("", "")
		.when()
		.get("/employees/5");
		System.out.println(response.body().asPrettyString());
		
		

	}
}
