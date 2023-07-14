package Practice_concepts;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class Serialization {

	@Test
	public void serialize() {
		
		Map<String, Object> jsonbody= new HashMap<String, Object>();
		List<String> skills=new ArrayList<String>();
		skills.add("java");
		skills.add("selenium");
		
		jsonbody.put("first_name", "steve");
		jsonbody.put("last_name", "smith");
		jsonbody.put("email", "steve@gmail.com");
		jsonbody.put("skills", skills);
		
		System.out.println(jsonbody);
		
		RestAssured.given()
		.baseUri("http://localhost:3000")
		.header("Content-Type", "application/json")
		.body(jsonbody)
		.log().all()
		.when()
		.post("/employees")
		.then().log().all();
		
	}
}
