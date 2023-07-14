package com.api.json_schema_validation;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.hamcrest.MatcherAssert;
import org.testng.annotations.Test;

import io.restassured.module.jsv.JsonSchemaValidator;

public class HamcrestMatchersJsonSchemaValidation {
	

	@Test
	public void validation() throws IOException {
		File inputJson=new File("src/test/resources/input.json");
		String Jsoncontent=FileUtils.readFileToString(inputJson);
		File schema=new File("src/test/resources/schema.json");
		
		MatcherAssert.assertThat(Jsoncontent, JsonSchemaValidator.matchesJsonSchema(schema));
	}

}
