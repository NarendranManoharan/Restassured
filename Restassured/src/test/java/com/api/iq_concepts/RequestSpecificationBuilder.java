package com.api.iq_concepts;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public class RequestSpecificationBuilder {
	
	

		@Test
		public void getaAnEmployee() {
			
			RequestSpecBuilder builder=new RequestSpecBuilder();
			RequestSpecification spec=builder.setBaseUri("http://localhost:3000").setBasePath("/employees").build();

			given(spec)
			.when().get("/7")
			.prettyPrint();
		
	}
}
