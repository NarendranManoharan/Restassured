package com.api.Auth_Types;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

public class Oauth2 {
	
	@Test
	public void Oauth2() {
		String Token="ya29.a0AbVbY6NkYo8TTXavYUszNu_YjYDEVrDlZ0wAejK2V1Wcc4TfTPywrJEW3IAQzhMR3vetwfrrTWr1j_vezh-v3QpIDHn0lbAV9JSzjFF88G2iqsq6UMxhYYh--cdb9_nzmk1VibdPB6Swpgu_9YWL8Ip5xtIjaCgYKAe4SARISFQFWKvPle_r7OYvVej4mHbCkcuf_kA0163";
		given()
		 .auth()
		 .oauth2(Token)
		.when()
		.get("https://gmail.googleapis.com/gmail/v1/users/narendranmanohar07@gmail.com/messages/")
		.then().log().body();
	}

}
