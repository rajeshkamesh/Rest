package org.data;

public class PetDetails {
	
	public static String petData(int id, String name) {
		return "{\r\n"
				+ "  \"id\": "+id+",\r\n"
				+ "  \"category\": {\r\n"
				+ "    \"id\": 13,\r\n"
				+ "    \"name\": \"cat\"\r\n"
				+ "  },\r\n"
				+ "  \"name\": \""+name+"\",\r\n"
				+ "  \"photoUrls\": [\r\n"
				+ "    \"string\"\r\n"
				+ "  ],\r\n"
				+ "  \"tags\": [\r\n"
				+ "    {\r\n"
				+ "      \"id\": 2,\r\n"
				+ "      \"name\": \"persian dog\"\r\n"
				+ "    }\r\n"
				+ "  ],\r\n"
				+ "  \"status\": \"available\"\r\n"
				+ "}";
		
	}

}
