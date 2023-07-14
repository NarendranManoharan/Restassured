package com.api.restassured;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class PutRequestBDD {

	@Test
	public void putrequest() {
		JSONObject jsonObject=new JSONObject();
		jsonObject.put("name", "narendran");
		jsonObject.put("job", "automation");
		
		
		baseURI="https://reqres.in/api";
		
		given()
		.body(jsonObject.toJSONString())
		.put("/users/2")
		.then().statusCode(200);
	}
}
