package com.omrbranch.pojo.listflights;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ListFlights {

	public static void main(String[] args) throws StreamReadException, DatabindException, IOException {
		//1.Mention the path of JSON
				File file=new File("D:\\Automation\\eclipse-workspace\\Maven\\APIProject\\src\\test\\resources\\information.json");
				
				//2.Create object for objectMapper class
				ObjectMapper mapper=new ObjectMapper();
				
				//3.Pass the jsonfile to fetch value
				Flights emp = mapper.readValue(file, Flights.class);
				
				int page = emp.getPage();
				System.out.println(page);
				
				int per_page = emp.getPer_page();
				System.out.println(per_page);
				
				int total = emp.getTotal();
				System.out.println(total);
				
				int total_pages = emp.getTotal_pages();
				System.out.println(total_pages);
				
				ArrayList<Datum> data = emp.getData();
				for (Datum datum : data) {
					System.out.println(datum.getId());
					System.out.println(datum.getFlightName());
					System.out.println(datum.getCountry());
					System.out.println(datum.getDestinations());
					System.out.println(datum.getuRL());
				}
				
				Support support = emp.getSupport();
				System.out.println(support.getUrl());
				System.out.println(support.getText());

	}

}