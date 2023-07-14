package com.api.Jsonpath_using_JAVA;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;

public class ReadingJsonDocument {

	public static void parseEverytime() throws IOException {

		File jsonfile=new File("src/test/resources/bookstore.json");
		List<Object> pricelist= JsonPath.read(jsonfile, "$.store.book[?(@.price<10)]");
		for (Object price : pricelist) {
			System.out.println(price);
		}
	}

	public static void parseOnetime() throws IOException {
		
		InputStream jsonfile=new FileInputStream("src/test/resources/bookstore.json");
		
		
	  Object parsedDoc=Configuration.defaultConfiguration().jsonProvider().parse(jsonfile.readAllBytes());
		
		List<Object> titlelist=JsonPath.read(parsedDoc, "$..title");
		for (Object title : titlelist) {
			System.out.println(title);
		}
	}
	
	public static void fluentAPI() throws IOException {
		File jsonfile=new File("src/test/resources/bookstore.json");
		DocumentContext context=JsonPath.parse(jsonfile);
	    List<Object> authorlist=context.read("$..author");
	    
	    for (Object author : authorlist) {
			System.out.println(author);
	    }
		
	}
	
	public static void fluentAPIusingConfiguration() throws IOException {
		File jsonfile=new File("src/test/resources/bookstore.json");
		Configuration config=Configuration.defaultConfiguration();
		
		 List<Object> categorylist=JsonPath.using(config).parse(jsonfile).read("$..book.length()");
		 for (Object category : categorylist) {
				System.out.println(category);
		    }
	}
	
	public static void main(String[] args) throws IOException {

	//	parseEverytime();
	//	parseOnetime();
	//	fluentAPI();
		fluentAPIusingConfiguration();
	}

}
