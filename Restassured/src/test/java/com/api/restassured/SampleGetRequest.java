package com.api.restassured;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class SampleGetRequest {

	public static void main(String[] args) {
		
		Response response=RestAssured.get("http://localhost:3000/employees/5");
		int statusCode=response.statusCode();
		String statusLine=response.statusLine();
		
		System.out.println(statusCode);
		System.out.println(statusLine);
		System.out.println(response.body().asPrettyString());

	}

}
