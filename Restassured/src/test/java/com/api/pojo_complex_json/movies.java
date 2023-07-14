package com.api.pojo_complex_json;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class movies {
	
	private String title;
	private int year;
	private List<String> cast;
	

}
