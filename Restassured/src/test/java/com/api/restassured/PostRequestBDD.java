package com.api.restassured;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class PostRequestBDD {

	@Test
	public void postrequest() {
		
		JSONObject jsonObject=new JSONObject();
		jsonObject.put("first_name", "naren");
		jsonObject.put("last_name", "tester");
		jsonObject.put("email", "abc@gmail.com");
		
		System.out.println(jsonObject.toJSONString());
		RestAssured.baseURI="http://localhost:3000";
		
		Response response=RestAssured
		.given()
		.header("Content-Type", "application/json")
		.body(jsonObject.toJSONString())
		.post("/employees");
		System.out.println(response.body().asPrettyString());
	}
}
