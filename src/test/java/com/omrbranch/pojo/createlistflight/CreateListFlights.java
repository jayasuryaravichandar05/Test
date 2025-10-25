package com.omrbranch.pojo.createlistflight;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class CreateListFlights {
	
	public static void main(String[] args) throws StreamWriteException, DatabindException, IOException {
		// 1.Mention the path for JSON to write
		File file = new File("D:\\Automation\\eclipse-workspace\\Maven\\APIProject\\src\\test\\resources\\Hello.json");
		
		// 2. Create object for ObjectMapper Class
		ObjectMapper mapper = new ObjectMapper();
		
		// 3. Assign the values
		
		ArrayList<Datum> data = new ArrayList<Datum>();
		Datum data1 = new Datum(548,"AirIndia","India","87","https://en.wikipedia.org/wiki/Air_India");
		Datum data2 = new Datum(573,"AirIndia","India","54","https://en.wikipedia.org/wiki/Air_India");
		Datum data3 = new Datum(576,"AirIndia","India","87","https://en.wikipedia.org/wiki/Air_India");
		Datum data4 = new Datum(630,"AirIndia","India","67","https://en.wikipedia.org/wiki/Air_India");
		Datum data5 = new Datum(636,"Aircanda","canada","97","https://en.wikipedia.org/wiki/Air_India");
		Datum data6 = new Datum(655,"AirMalasiya","Malasiya","87","https://en.wikipedia.org/wiki/Air_Malasiya");
		data.add(data1);
		data.add(data2);
		data.add(data3);
		data.add(data4);
		data.add(data5);
		data.add(data6);
		
		Support support = new Support("https://www.omrbranch.com","For Joining Automation Course, Please Contact-Velmurugan 9944152058");
		Flights flight = new Flights(1,6,16961,2827,data,support);
		
		// 4. Write value in json
		
		mapper.writeValue(file, flight);
		
		System.out.println("Done");
		
	}
}
