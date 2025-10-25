package com.apiprojectclass;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class APIAutomation {

	public void getSingleFlight() {

		RequestSpecification reqSpec;

		// 1. Initialize the Rest Assured Class
		reqSpec = RestAssured.given();

		// 2. Header(s), Req Body, Auth
		reqSpec = reqSpec.header("Content-Type", "application/json");

		// 3. Endpoint, Req type
		Response response = reqSpec.get("https://www.omrbranch.com/api/flight/52591");

		// GEt the Status Code
		int statusCode = response.getStatusCode();
		System.out.println(statusCode);

		// Res Body ---> asString
		String asString = response.asString();
		System.out.println(asString);

		// Res Body ---> asPrettyString
		String asPrettyString = response.asPrettyString();
		System.out.println("\n" + asPrettyString);

	}
	
	public void createFlight() throws ParseException {
		
		RequestSpecification reqSpec;

		// 1. Initialize the Rest Assured Class
		reqSpec = RestAssured.given();

		// 2. Header(s), Req Body, Auth
		reqSpec = reqSpec.header("Content-Type", "application/json");

		// 3. Req Body
		
		reqSpec = reqSpec.body("{\r\n"
				+ "    \"flightName\": \"AirIndia\",\r\n"
				+ "    \"Country\": \"India\",\r\n"
				+ "    \"Destinations\": \"87\",\r\n"
				+ "    \"URL\": \"https:\\/\\/en.wikipedia.org\\/wiki\\/Air_India\"\r\n"
				+ "}");
		
		// 4. Endpoint, Req type
		Response response = reqSpec.post("https://www.omrbranch.com/api/flights");

		// GEt the Status Code
		int statusCode = response.getStatusCode();
		System.out.println(statusCode);

		// Res Body ---> asString
		String asString = response.asString();
		System.out.println(asString);

		// Res Body ---> asPrettyString
		String asPrettyString = response.asPrettyString();
		System.out.println("\n" + asPrettyString);
		
		//Get id
		JSONParser jsonParser = new JSONParser();
		Object object = jsonParser.parse(asPrettyString);
		JSONObject jsonObject = (JSONObject) object;
		Object dataObject = jsonObject.get("data");
		JSONObject jsonObject2 = (JSONObject) dataObject;
		Object idObject  = jsonObject2.get("id");
		System.out.println(idObject);
		
	}
	
	public void updateFlight() {
		RequestSpecification reqSpec;

		// 1. Initialize the Rest Assured Class
		reqSpec = RestAssured.given();

		// 2. Header(s), Req Body, Auth
		reqSpec = reqSpec.header("Content-Type", "application/json");

		// 3. Req Body
		
		reqSpec = reqSpec.body("{\r\n"
				+ "    \"flightName\": \"AirAsia\",\r\n"
				+ "    \"Country\": \"Switzerland\",\r\n"
				+ "    \"Destinations\": \"90\",\r\n"
				+ "    \"URL\": \"https:\\/\\/en.wikipedia.org\\/wiki\\/Air_Asia\"\r\n"
				+ "}");
		
		// 4. Endpoint, Req type
		Response response = reqSpec.put("https://www.omrbranch.com/api/flight/52894");

		// GEt the Status Code
		int statusCode = response.getStatusCode();
		System.out.println(statusCode);

		// Res Body ---> asString
		String asString = response.asString();
		System.out.println(asString);

		// Res Body ---> asPrettyString
		String asPrettyString = response.asPrettyString();
		System.out.println("\n" + asPrettyString);
	}

	public void patchFlight() {
		RequestSpecification reqSpec;

		// 1. Initialize the Rest Assured Class
		reqSpec = RestAssured.given();

		// 2. Header(s), Req Body, Auth
		reqSpec = reqSpec.header("Content-Type", "application/json");

		// 3. Req Body
		
		reqSpec = reqSpec.body("{\r\n"
				+ "    \"flightName\": \"AirWORLD\",\r\n"
				+ "    \"Country\": \"Switzerland1\",\r\n"
				+ "    \"Destinations\": \"90\",\r\n"
				+ "    \"URL\": \"https:\\/\\/en.wikipedia.org\\/wiki\\/Air_Asia\"\r\n"
				+ "}");
		
		// 4. Endpoint, Req type
		Response response = reqSpec.patch("https://www.omrbranch.com/api/flight/52894");

		// GEt the Status Code
		int statusCode = response.getStatusCode();
		System.out.println(statusCode);

		// Res Body ---> asString
		String asString = response.asString();
		System.out.println(asString);

		// Res Body ---> asPrettyString
		String asPrettyString = response.asPrettyString();
		System.out.println("\n" + asPrettyString);
	}
	
	public void deleteFlight() {
		RequestSpecification reqSpec;
		
		// 1. Initialize the Rest Assured Class
		reqSpec = RestAssured.given();
		
		// 2. Header(s), Req Body, Auth
		reqSpec = reqSpec.header("Content-Type", "application/json");
		
		// 3. Req Body
		
		reqSpec = reqSpec.body("{\r\n"
				+ "    \"flightName\": \"AirWORLD\",\r\n"
				+ "    \"Country\": \"Switzerland\",\r\n"
				+ "    \"Destinations\": \"90\",\r\n"
				+ "    \"URL\": \"https:\\/\\/en.wikipedia.org\\/wiki\\/Air_Asia\"\r\n"
				+ "}");
		
		// 4. Endpoint, Req type
		Response response = reqSpec.delete("https://www.omrbranch.com/api/flight/52864");
		
		// GEt the Status Code
		int statusCode = response.getStatusCode();
		System.out.println(statusCode);
		
		// Res Body ---> asString
		String asString = response.asString();
		System.out.println(asString);
		
		// Res Body ---> asPrettyString
		String asPrettyString = response.asPrettyString();
		System.out.println("\n" + asPrettyString);
	}
	
	public void getListFlights() {

		RequestSpecification reqSpec;

		// 1. Initialize the Rest Assured Class
		reqSpec = RestAssured.given();

		// 2. Header(s), Req Body, Auth
		reqSpec = reqSpec.header("Content-Type", "application/json");

		// 3. Endpoint, Req type
		Response response = reqSpec.get("https://www.omrbranch.com/api/flights?page=1");

		// GEt the Status Code
		int statusCode = response.getStatusCode();
		System.out.println(statusCode);

		// Res Body ---> asString
		String asString = response.asString();
		System.out.println(asString);

		// Res Body ---> asPrettyString
		String asPrettyString = response.asPrettyString();
		System.out.println("\n" + asPrettyString);

	}

	
	public static void main(String[] args) throws ParseException {
		APIAutomation api = new APIAutomation();
		System.out.println("########## GET SINGLE FLIGHT ############");
		api.getSingleFlight();
		System.out.println("\n########## CREATE FLIGHT ############");
		api.createFlight();
		System.out.println("\n########## UPDATE FLIGHT ############");
		api.updateFlight();
		System.out.println("\n########## PATCH FLIGHT ############");
		api.patchFlight();
//		System.out.println("\n########## DELETE FLIGHT ############");
//		api.deleteFlight();
		System.out.println("########## GET LIST FLIGHTS ############");
		api.getListFlights();
	}

}
