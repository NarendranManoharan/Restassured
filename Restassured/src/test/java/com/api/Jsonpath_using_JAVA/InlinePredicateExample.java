package com.api.Jsonpath_using_JAVA;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.jayway.jsonpath.JsonPath;

public class InlinePredicateExample {

	public static void inlinePredicate() throws IOException {
		File jsonfileloc=new File("src/test/resources/bookstore.json");
		//List<Object> result=JsonPath.parse(jsonfileloc).read("$.store.book[?(@.price<10)]");
		//List<Object> result=JsonPath.parse(jsonfileloc).read("$.store.book[?(@.price<10  && @.category=='reference')]");
		//List<Object> result=JsonPath.parse(jsonfileloc).read("$.store.book[?(@.price>10 || @.category=='fiction')]");
		List<Object> result=JsonPath.parse(jsonfileloc).read("$.store.book[?(!(@.price>10 || @.category=='fiction'))]");
		System.out.println(result);
		//[?(@.price<10)]
	}

	public static void main(String[] args) throws IOException {

		inlinePredicate();
	}

}