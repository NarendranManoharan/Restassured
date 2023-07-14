package com.api.Auth_Types;
import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

public class Bearer_Token {

	@Test
	public void bearertoken() {
		String Token="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";
		given()
		 .header("Authorization", "Bearer "+Token)
		.when()
		.get("https://api.github.com/user/repos")
		.then().log().body();
	}
}
