package com.api.Auth_Types;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class ApiKeyAuth {

	//https://api.openweathermap.org/data/2.5/weather?q={city name}&appid={API key}
	
	@Test
	public void apikeyauth() {
		
		given()
		.when()
		.get("https://api.openweathermap.org/data/2.5/weather?q=trichy&appid=994c9ec12c75223038a0837a6830d788")
		.then().log().body();
	}
	
	@Test
	public void apikeyusingParam() {
		given()
		.baseUri("https://api.openweathermap.org/data/2.5/weather")
		  .queryParam("q", "Trichy")
		  .queryParam("appid", "994c9ec12c75223038a0837a6830d788")
		.when()
		  .get()
		  .prettyPrint();
	}
	
	public void apikeyusingHeaders() {
		given()
		  .queryParam("q", "Trichy")
		  .header("appid", "994c9ec12c75223038a0837a6830d788")
		.when()
		  .get("https://api.openweathermap.org/data/2.5/weather")
		  .prettyPrint();
	}
}
