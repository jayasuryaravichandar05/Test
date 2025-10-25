package com.apiprojectclass;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Info {

	public static void main(String[] args) throws IOException, ParseException {
		//1. Mention the path of JSON
		FileReader fileReader = new FileReader("D:\\Automation\\eclipse-workspace\\Maven\\APIProject\\src\\test\\resources\\information.json");
		
		//2. Create Object for JSONParser Class
		JSONParser jsonParser = new JSONParser();
		
		// 3. Pass the json file to fetch value
		Object object = jsonParser.parse(fileReader);
		
		// Convert to JSSONObject
		JSONObject jsonObject = (JSONObject) object;
		
		Object pageObj = jsonObject.get("page");
		long page = (long) pageObj;
		System.out.println(page);
		
		Object per_pageObj = jsonObject.get("per_page");
		long per_page = (long) per_pageObj;
		System.out.println(per_page);
		
		Object totalObj = jsonObject.get("total");
		long total = (long) totalObj;
		System.out.println(total);
		
		Object total_pagesObj = jsonObject.get("total_pages");
		long total_pages = (long) total_pagesObj;
		System.out.println(total_pages);
		
		Object dataObj = jsonObject.get("data");
		JSONArray dataArray = (JSONArray) dataObj;
		for(int i = 0 ; i < dataArray.size(); i++ ) {
			Object object2 = dataArray.get(i);
			JSONObject jsonObject2 = (JSONObject) object2;
			Object idObject = jsonObject2.get("id");
			long id = (long) idObject;
			System.out.println(id);
			Object flightNameObject = jsonObject2.get("flightName");
			String flightName = (String) flightNameObject;
			System.out.println(flightName);
			Object countryObject = jsonObject2.get("Country");
			String country = (String) countryObject;
			System.out.println(country);
			Object destinationsObject = jsonObject2.get("Destinations");
			String destinations= (String) destinationsObject;
			System.out.println(destinations);
			Object urlObject = jsonObject2.get("URL");
			String url = (String) urlObject;
			System.out.println(url);
		}
		
		Object supportObj = jsonObject.get("support");
		JSONObject jsonObject3 = (JSONObject) supportObj;
		Object urlObject = jsonObject3.get("url");
		String url = (String) urlObject;
		System.out.println(url);
		Object textObject = jsonObject3.get("text");
		String text = (String) textObject;
		System.out.println(text);
				
	}

}
