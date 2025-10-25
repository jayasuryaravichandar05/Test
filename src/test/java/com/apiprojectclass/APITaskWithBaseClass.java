package com.apiprojectclass;

import com.omrbranch.baseclass.BaseClass;

import io.restassured.response.Response;

public class APITaskWithBaseClass extends BaseClass {

//	static {
//		// applicaable for this class only
//		//If given in baseclass, applicable to all classes
//		RestAssured.baseURI = "https://www.omrbranch.com/api";
//	}

	public String createFlight() {

		// won't be accessible to other methods, if this method isn't called during
		// execution
//		RestAssured.baseURI = "https://www.omrbranch.com/api";

		// 1. init RestAssured
		initRestAssured();

		// 2. Header
		addHeader("Content-Type", "application/json");

		// 3. Req Body
		addPayload("{\r\n"
				+ "    \"flightName\": \"AirIndia\",\r\n"
				+ "    \"Country\": \"India\",\r\n"
				+ "    \"Destinations\": \"87\",\r\n"
				+ "    \"URL\": \"https:\\/\\/en.wikipedia.org\\/wiki\\/Air_India\"\r\n"
				+ "}");

		// 4. req type, Endpoint
		Response response = getRequest("POST", "/flights");
		int statusCode = getStatusCode(response);
		System.out.println(statusCode);
		System.out.println(getResBodyAsPrettyString(response) + "\n\n");
		printResponse(response);

		String flightId = getJsonPathString(response, "data.id");
		System.out.println(flightId);
		return flightId;
	}

	public void getSingleFlight(String flightId) {

		initRestAssured();
		addHeader("Content-Type", "application/json");
		Response response = getRequest("GET", "/flight/" + flightId);
		printResponse(response);

	}

	public void updateFlight(String flightId) {

		initRestAssured();
		addHeader("Content-Type", "application/json");
		addPayload("{\r\n"
				+ "    \"flightName\": \"AirAsia\",\r\n"
				+ "    \"Country\": \"Switzerland\",\r\n"
				+ "    \"Destinations\": \"90\",\r\n"
				+ "    \"URL\": \"https:\\/\\/en.wikipedia.org\\/wiki\\/Air_Asia\"\r\n"
				+ "}");
		Response response = getRequest("PUT", "/flight/" + flightId);
		printResponse(response);

	}

	public void updateFlightDes(String flightId) {

		initRestAssured();
		addHeader("Content-Type", "application/json");
		addPayload("{\r\n"
				+ "    \"flightName\": \"AirAsia\",\r\n"
				+ "    \"Country\": \"Switzerland\",\r\n"
				+ "    \"Destinations\": \"10\",\r\n"
				+ "    \"URL\": \"https:\\/\\/en.wikipedia.org\\/wiki\\/Air_Asia\"\r\n"
				+ "}");
		Response response = getRequest("PATCH", "/flight/" + flightId);
		printResponse(response);
	
	}

	public void deleteFlight(String flightId) {
		
		initRestAssured();
		addHeader("Content-Type", "application/json");
		addPayload("{\r\n"
				+ "    \"flightName\": \"AirAsia\",\r\n"
				+ "    \"Country\": \"Switzerland\",\r\n"
				+ "    \"Destinations\": \"10\",\r\n"
				+ "    \"URL\": \"https:\\/\\/en.wikipedia.org\\/wiki\\/Air_Asia\"\r\n"
				+ "}");
		Response response = getRequest("DELETE", "/flight/" + flightId);
		printResponse(response);
	
	}

	public void getListFlights() {
		
		initRestAssured();
		addHeader("Content-Type", "application/json");
		addPayload("{\r\n"
				+ "    \"flightName\": \"AirIndia\",\r\n"
				+ "    \"Country\": \"India\",\r\n"
				+ "    \"Destinations\": \"87\",\r\n"
				+ "    \"URL\": \"https:\\/\\/en.wikipedia.org\\/wiki\\/Air_India\"\r\n"
				+ "}");
		Response response = getRequest("GET", "/flights?page=1");
		printResponse(response);

	}

	public static void main(String[] args) {
		APITaskWithBaseClass api = new APITaskWithBaseClass();
		System.out.println("\n########## CREATE FLIGHT ############");
		String flightId = api.createFlight();
		System.out.println("\n########## GET SINGLE FLIGHT ############");
		api.getSingleFlight(flightId);
		System.out.println("\n########## UPDATE FLIGHT ############");
		api.updateFlight(flightId);
		System.out.println("\n########## PATCH FLIGHT ############");
		api.updateFlightDes(flightId);
		System.out.println("\n########## DELETE FLIGHT ############");
		api.deleteFlight(flightId);
		System.out.println("\n########## GET LIST FLIGHTS ############");
		api.getListFlights();
	}

}
