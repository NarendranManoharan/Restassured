package com.api.pojo_complex_json;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Herosmovies {
	
	private String Category;
	private List<String> Acceptedfranchise;
	private List<String> genres;
	private List<movies>  movies;
	private Otherdetails otherdetails;
	

}
