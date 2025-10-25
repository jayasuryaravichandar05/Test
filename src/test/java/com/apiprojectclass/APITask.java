package com.apiprojectclass;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class APITask {

  public String createFlight() {
	  RequestSpecification reqSpec;

	  //demo
	  
	  
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
		String id = response.jsonPath().getString("data.id");
		return id;

  }

  public void getSingleFlight(String flightId) {
	  RequestSpecification reqSpec;

		// 1. Initialize the Rest Assured Class
		reqSpec = RestAssured.given();

		// 2. Header(s), Req Body, Auth
		reqSpec = reqSpec.header("Content-Type", "application/json");

		// 3. Endpoint, Req type
		Response response = reqSpec.get("https://www.omrbranch.com/api/flight/"+ flightId);

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

  public void updateFlight(String flightId) {
	  
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
		Response response = reqSpec.put("https://www.omrbranch.com/api/flight/"+ flightId);

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

  public void updateFlightDes(String flightId) {
	  RequestSpecification reqSpec;

		// 1. Initialize the Rest Assured Class
		reqSpec = RestAssured.given();

		// 2. Header(s), Req Body, Auth
		reqSpec = reqSpec.header("Content-Type", "application/json");

		// 3. Req Body
		
		reqSpec = reqSpec.body("{\r\n"
				+ "    \"flightName\": \"AirAsia\",\r\n"
				+ "    \"Country\": \"Switzerland\",\r\n"
				+ "    \"Destinations\": \"10\",\r\n"
				+ "    \"URL\": \"https:\\/\\/en.wikipedia.org\\/wiki\\/Air_Asia\"\r\n"
				+ "}");
		
		
		// 4. Endpoint, Req type
		Response response = reqSpec.patch("https://www.omrbranch.com/api/flight/"+ flightId);

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

  public void deleteFlight(String flightId) {
	  RequestSpecification reqSpec;
		
		// 1. Initialize the Rest Assured Class
		reqSpec = RestAssured.given();
		
		// 2. Header(s), Req Body, Auth
		reqSpec = reqSpec.header("Content-Type", "application/json");
		
		// 3. Req Body
		
		reqSpec = reqSpec.body("{\r\n"
				+ "    \"flightName\": \"AirAsia\",\r\n"
				+ "    \"Country\": \"Switzerland\",\r\n"
				+ "    \"Destinations\": \"10\",\r\n"
				+ "    \"URL\": \"https:\\/\\/en.wikipedia.org\\/wiki\\/Air_Asia\"\r\n"
				+ "}");
		
		// 4. Endpoint, Req type
		Response response = reqSpec.delete("https://www.omrbranch.com/api/flight/"+ flightId);
		
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

  public static void main(String[] args) {
    APITask sample = new APITask();
    System.out.println("\n########## CREATE FLIGHT ############");
    String id = sample.createFlight();
    System.out.println("\n########## GET SINGLE FLIGHT ############");
    sample.getSingleFlight(id);
    System.out.println("\n########## UPDATE FLIGHT ############");
    sample.updateFlight(id);
    System.out.println("\n########## PATCH FLIGHT ############");
    sample.updateFlightDes(id);
	System.out.println("\n########## DELETE FLIGHT ############");
    sample.deleteFlight(id);
    System.out.println("\n########## GET LIST FLIGHTS ############");
    sample.getListFlights();

  }

}
