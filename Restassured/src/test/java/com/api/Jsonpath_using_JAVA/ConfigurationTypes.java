package com.api.Jsonpath_using_JAVA;

import java.io.File;
import java.util.List;

import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.Option;

public class ConfigurationTypes {
	
	
	public static void usingConfig() {
		String jsonfile="[{\r\n"
				+ "     \"name\": \"ben\",\r\n"
				+ "     \"gender\": \"male\"\r\n"
				+ "  },\r\n"
				+ "  \r\n"
				+ "  {\r\n"
				+ "       \"name\": \"root\"\r\n"
				+ "  }]";
		
		//Configuration  config=Configuration.builder().options(Option.DEFAULT_PATH_LEAF_TO_NULL).build();
		
		Configuration  config=Configuration.defaultConfiguration().addOptions(Option.SUPPRESS_EXCEPTIONS);
		
		List<String> result=JsonPath.using(config).parse(jsonfile).read("$[*].gender");
		System.out.println(result);
	}
	
	
	public static void main(String[] args) {
		
            usingConfig();
	}

}
