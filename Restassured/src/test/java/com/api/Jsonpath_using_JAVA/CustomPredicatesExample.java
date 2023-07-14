package com.api.Jsonpath_using_JAVA;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.Predicate;
import com.jayway.jsonpath.Predicate.PredicateContext;

public class CustomPredicatesExample {

	static File jsonfileloc=new File("src/test/resources/bookstore.json");
	public void myCustomPredicate() throws IOException {
		
		Predicate bookswithISBN=new Predicate() {
			
			public boolean apply(PredicateContext ctx) {
				
				boolean predicate=ctx.item(Map.class).containsKey("isbn") ;
				return predicate;
			}
		};
		
		List<Map<String, Object>> result=JsonPath.parse(jsonfileloc).read("$.store.book[?]", bookswithISBN);
		System.out.println(result);
	}
	
	public static void usinglamda() throws IOException {
		Predicate bookswithISBN= ctx->ctx.item(Map.class).containsKey("isbn");
		List<Map<String, Object>> result=JsonPath.parse(jsonfileloc).read("$.store.book[?].isbn", bookswithISBN);
		System.out.println(result);
	}
	
	
	public static void main(String[] args) throws IOException {
		CustomPredicatesExample customPredicatesExample=new CustomPredicatesExample();
		customPredicatesExample.usinglamda();
	}
}
