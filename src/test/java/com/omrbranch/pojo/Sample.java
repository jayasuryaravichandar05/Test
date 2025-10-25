package com.omrbranch.pojo;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Sample {

	public static void main(String[] args) throws StreamReadException, DatabindException, IOException {
		// 1. Mention thepath of json
		File file = new File(
				"D:\\Automation\\eclipse-workspace\\Maven\\APIProject\\src\\test\\resources\\Employee.json");

		// 2. Create Object for ObjectMapper Class
		ObjectMapper mapper = new ObjectMapper();

		// 3. Pass the json file to fetch value
		Employee emp = mapper.readValue(file, Employee.class);

		String name = emp.getName();
		System.out.println(name);

		String emailId = emp.getEmailId();
		System.out.println(emailId);

		long phoneNo = emp.getPhoneNo();
		System.out.println(phoneNo);

		// address
		Address address = emp.getAddress();
		String streetName = address.getStreetName();
		System.out.println(streetName);

		String districtName = address.getDistrictName();
		System.out.println(districtName);

		String stateName = address.getStateName();
		System.out.println(stateName);

		long pincode = address.getPincode();
		System.out.println(pincode);

		// courses
		ArrayList<String> courses = emp.getCourses();
		for (String c : courses) {
			System.out.println(c);
		}

		// emp Details
		ArrayList<EmpDetail> empDetails = emp.getEmpDetails();
		for (EmpDetail e : empDetails) {
			String firstName = e.getFirstName();
			System.out.println(firstName);
			String course = e.getCourse();
			System.out.println(course);
			String place = e.getPlace();
			System.out.println(place);
		}

	}
}
