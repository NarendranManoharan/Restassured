package com.api.pojo_complex_json;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Serialization {

	public static void main(String[] args) throws StreamWriteException, DatabindException, IOException {
		
		Herosmovies herosmovies=new Herosmovies();
		herosmovies.setCategory("heros movies in tamil");
		
		List<String> acceptedfranchiselist=new ArrayList<String>();
		acceptedfranchiselist.add("LCU");
		acceptedfranchiselist.add("ICU");
		
		List<String> genresList=new ArrayList<String>();
		genresList.add("Action");
		genresList.add("Drama");
		genresList.add("comedy");
		

		List<movies> listofmovies=new ArrayList<movies>();
		
		
		movies vijaymovie=new movies();
		vijaymovie.setTitle("Master");
		vijaymovie.setYear(2022);
		 List<String> mastetcastlist=new ArrayList<String>();
		 mastetcastlist.add("JD");
		 mastetcastlist.add("Bavani");
		 mastetcastlist.add("Bargav mosamanvan");
		 vijaymovie.setCast(mastetcastlist);
		 
		 listofmovies.add(vijaymovie);
	
		
		movies kamalmovie=new movies();
		kamalmovie.setTitle("Vikram");
		kamalmovie.setYear(2023);
		 List<String> vikramcastList=new ArrayList<String>();
		 vikramcastList.add("Vikram");
		 vikramcastList.add("Amar");
		 vikramcastList.add("Rolexxx");
		kamalmovie.setCast(vikramcastList);
		listofmovies.add(kamalmovie);
		
		
		
		
		 Otherdetails otherdetails=new Otherdetails();
		 otherdetails.setCountry("Indian");
		 otherdetails.setLangugae("Tamil");
		 
		 herosmovies.setAcceptedfranchise(acceptedfranchiselist);
		 herosmovies.setGenres(genresList);
		 herosmovies.setMovies(listofmovies);
		 herosmovies.setOtherdetails(otherdetails);
		 
		 
		 ObjectMapper mapper=new ObjectMapper();
		 File jsonfile=new File("movies.json");
		 mapper.writerWithDefaultPrettyPrinter().writeValue(jsonfile, herosmovies);
		 
		 
	}

}
