package Practice_concepts;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonComparison {

	static String json1="{\r\n"
			+ "    \"first_name\": \"ajit\",\r\n"
			+ "    \"last_name\": \"agarkar\",\r\n"
			+ "    \"email\": \"ajit@gmail.com\"\r\n"
			+"      \"skills\": \"java\"\r\n"
			+ "  }";
	
	static String json2="{\r\n"
			+ "    \"first_name\": \"ajit\",\r\n"
			+ "    \"last_name\": \"agarkar\",\r\n"
			+ "    \"email\": \"ajit@gmail.com\"\r\n"
			+ "  }";
	
	public static void main(String[] args) throws JsonMappingException, JsonProcessingException {
		
		ObjectMapper mapper=new ObjectMapper();
		JsonNode jsonNode1=mapper.readTree(json1);
		JsonNode jsonNode2=mapper.readTree(json2);
		
		System.out.println(jsonNode1.equals(jsonNode2));

	}

}
