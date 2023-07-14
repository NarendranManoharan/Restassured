package com.api.json_schema_validation;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Set;

import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.networknt.schema.JsonSchema;
import com.networknt.schema.JsonSchemaFactory;
import com.networknt.schema.SpecVersion.VersionFlag;
import com.networknt.schema.ValidationMessage;

public class NetworkntJsonSchemaValidator {

	@Test
	public void validateJsonSchema() throws IOException {
		
		ObjectMapper mapper=new ObjectMapper();
		JsonSchemaFactory factory=JsonSchemaFactory.getInstance(VersionFlag.V4);
		
		File jsonInput=new File("src/test/resources/input.json");
		JsonNode jsonNode=mapper.readTree(jsonInput);
		
		InputStream schema=new FileInputStream("C:\\Users\\shaeva\\Desktop\\naren\\New folder\\schema.json");
		JsonSchema jsonschema=factory.getSchema(schema);
		
		Set<ValidationMessage> result=jsonschema.validate(jsonNode);
		
		if(result.isEmpty()) {
			System.out.println("No validation errors");
		}else {
			for (ValidationMessage validationMessage : result) {
				System.out.println(validationMessage);
			}
		}
		
		
		
	    

	}
}
