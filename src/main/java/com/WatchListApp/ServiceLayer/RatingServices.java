package com.WatchListApp.ServiceLayer;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.node.ObjectNode;

@Service
public class RatingServices {

	String api="https://omdbapi.com/?apikey=d5cf6a51&t=?";
	
	public String getRating(String title)
	{
		try {
		RestTemplate template=new RestTemplate();
	
		
		ResponseEntity<ObjectNode> response=template.getForEntity(api+title, ObjectNode.class);
		
	    ObjectNode jsonObject=response.getBody();
	    
	    if(jsonObject.path("Response").asText().equalsIgnoreCase("False"))
	    {
	    	System.out.println("Movie not found : "+jsonObject.path("Error").asText());
	    	return null;
	    }
	    return jsonObject.path("imdbRating").asText();
		}
		
		catch(Exception e)
		{
			System.out.println("Either movie name is not available  or api is down :"+e.getMessage());
			return null;
		}
	}
}
	

