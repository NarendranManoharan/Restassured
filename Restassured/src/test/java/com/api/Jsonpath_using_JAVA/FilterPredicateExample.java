package com.api.Jsonpath_using_JAVA;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.junit.experimental.categories.Categories;

import com.jayway.jsonpath.Criteria;
import com.jayway.jsonpath.Filter;
import com.jayway.jsonpath.JsonPath;

public class FilterPredicateExample {

	//$.store.book[?(@.price<10)]
	//$.store.book[?(@.price<10  && @.category=='reference')] and operation
	//$.store.book[?(@.price>10 || @.category=='fiction')] or operation
	//$.store.book[?(!(@.price>10 || @.category=='fiction'))] not operation
 	static File jsonfileloc=new File("src/test/resources/bookstore.json");
	public static void firstfilterAPIexample() throws IOException {
		File jsonfileloc=new File("src/test/resources/bookstore.json");
		Filter pricelessthanTen=Filter.filter(
				 Criteria
				 .where("price")
				 .lt(10)
				);
		
	List<Object> result=JsonPath.parse(jsonfileloc).read("$.store.book[?]",   pricelessthanTen);
	System.out.println(result);
			
	}
	
	public static void secondfilterAPIexample() throws IOException {
		
		Filter andoperationFilter= Filter.filter(
				Criteria.where("price")
				.lt(10)
				.and("category")
				.is("reference")
				);
		List<Map<String, Object>> result= JsonPath.parse(jsonfileloc).read("$.store.book[?]", andoperationFilter);
		System.out.println(result.get(0).get("author"));
		
	}
	public static void thirdfilterAPIexample() throws IOException {
		Filter ORoperationFilter=Filter.filter(
				Criteria.where("category")
				.is("fiction").and("price").gt(10)
				);
		List<Map<String, Object>> result=JsonPath.parse(jsonfileloc).read("$.store.book[?]", ORoperationFilter);
		System.out.println(result);
	}
	
	public static void main(String[] args) throws IOException {
		thirdfilterAPIexample();
		

	}

}
