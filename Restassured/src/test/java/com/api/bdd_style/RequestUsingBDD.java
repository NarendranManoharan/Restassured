package com.api.bdd_style;

import org.testng.annotations.Test;
     
import static io.restassured.RestAssured.*;

import java.io.File;

public class RequestUsingBDD {

	@Test
	public void getallemployeesBDD() {
		
		given().baseUri("http://localhost:3000")
		.when().get("/employees")
		.prettyPrint();
	}
	
	@Test
	public void createEmployeeBDD() {
		
		given()
		   .baseUri("http://localhost:3000")
		   .header("Content-Type", "application/json")
		   .body("{\r\n"
						+ "    \"first_name\": \"ajit\",\r\n"
						+ "    \"last_name\": \"agarkar\",\r\n"
						+ "    \"email\": \"ajit@gmail.com\"\r\n"
						+ "  }")
		.when()
		   .post("/employees")
		 .prettyPrint();
	}
	
	@Test
	public void updateEmployeeBDD() {
		
		given()
		   .baseUri("http://localhost:3000")
		   .header("Content-Type", "application/json")
		   .body("{\r\n"
					+ "    \"first_name\": \"ishant\",\r\n"
					+ "    \"last_name\": \"sharma\",\r\n"
					+ "    \"email\": \"ishant@gmail.com\"\r\n"
					+ "  }")
		.when()
		    .put("/employees/5")
		.prettyPrint();
		   
	}
	
	@Test
	public void deleteEmployeeBDD() {
		
		given()
		  .baseUri("http://localhost:3000")
	    .when()
	       .delete("/employees/5")
	     .prettyPrint();
	}
	
	@Test
	public void createEmployeefromJsonFile()   {
		
		File jsondata=new File("D:\\Study notes\\employees.json");
		
		given()
		   .baseUri("http://localhost:3000")
		   .header("Content-Type", "application/json")
		   .body(jsondata)
		.when()
		   .post("/employees")
		   .prettyPrint();
		
	}
}
