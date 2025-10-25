package com.omrbranch.pojo;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Employee {

	private String name;
	private String emailId;
	@JsonProperty("PhoneNo") 
	private long phoneNo;
	public ArrayList<EmpDetail> empDetails;
	
	public ArrayList<EmpDetail> getEmpDetails() {
		return empDetails;
	}

	public void setEmpDetails(ArrayList<EmpDetail> empDetails) {
		this.empDetails = empDetails;
	}

	public ArrayList<String> getCourses() {
		return courses;
	}

	public void setCourses(ArrayList<String> courses) {
		this.courses = courses;
	}

	private Address address;
	private ArrayList<String> courses;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public long getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(long phoneNo) {
		this.phoneNo = phoneNo;
	}
	
	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

}
