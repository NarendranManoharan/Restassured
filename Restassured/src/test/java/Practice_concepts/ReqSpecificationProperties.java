package Practice_concepts;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.QueryableRequestSpecification;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.SpecificationQuerier;

public class ReqSpecificationProperties {
	@Test
	public void post() {
		
		
	   RequestSpecification requestSpecification= RestAssured
				.given().baseUri("http://localhost:3000")
				.header("Content-Type", "application/json")
				.body("{\r\n"
						+ "    \"first_name\": \"ajit\",\r\n"
						+ "    \"last_name\": \"agarkar\",\r\n"
						+ "    \"email\": \"ajit@gmail.com\"\r\n"
						+ "  }");
		
	//  Response response =requestSpecification.post("/employees");
			//	System.out.println(response.body().asPrettyString());
				
				QueryableRequestSpecification queryspec
				=SpecificationQuerier.query(requestSpecification);
				
				System.out.println(queryspec.getBaseUri());
			//	System.out.println(queryspec.getBody());
				System.out.println("ledhu baiya" +queryspec.getBasePath());
				
	}
	
	@Test
	public void example() {
		RestAssured.given().log().all().when().get();
	}

}
