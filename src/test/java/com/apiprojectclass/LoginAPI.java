package com.apiprojectclass;

import java.util.ArrayList;
import java.util.List;

import com.omrbranch.addaddress.AddUserAddress_Input_Pojo;
import com.omrbranch.addaddress.AddUserAddress_Output_Pojo;
import com.omrbranch.baseclass.BaseClass;
import com.omrbranch.pojo.citylist.CityList_Input_Pojo;
import com.omrbranch.pojo.citylist.CityList_Output_Pojo;
import com.omrbranch.pojo.deleteaddress.DeleteAddress_Input_Pojo;
import com.omrbranch.pojo.deleteaddress.DeleteAddress_Output_Pojo;
import com.omrbranch.pojo.login.PostmanBasicAuthentication_Output_Pojo;
import com.omrbranch.pojo.statelist.Datum;
import com.omrbranch.pojo.statelist.StateList_Output_Pojo;
import com.omrbranch.pojo.updateaddress.UpdateAddress_Input_Pojo;
import com.omrbranch.pojo.updateaddress.UpdateAddress_Output_Pojo;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class LoginAPI extends BaseClass {

	String stateIdText;
	int stateId;
	int cityId;
	String addressId;
	String logtoken;

	public void login() {
		initRestAssured();
		addHeader("accept", "application/json");
		addBasicAuth("jayasuryaravichandar05@gmail.com", "Suryagreens@123");
		Response response = getRequest("POST", "/postmanBasicAuthLogin");
//		printResponse(response);
		// retrieve credentials
		// serialization - retrieve, payload passing -> deserialization
		PostmanBasicAuthentication_Output_Pojo postmanBasicAuthentication_Output_Pojo = response
				.as(PostmanBasicAuthentication_Output_Pojo.class);
		String first_name = postmanBasicAuthentication_Output_Pojo.getData().getFirst_name();
		System.out.println(first_name);
		logtoken = postmanBasicAuthentication_Output_Pojo.getData().getLogtoken();
		System.out.println(logtoken);
	}

	public void stateList() {
		initRestAssured();
		addHeader("accept", "application/json");
		Response response = getRequest("GET", "/stateList");
		// mapping
		StateList_Output_Pojo stateList_Output_Pojo = response.as(StateList_Output_Pojo.class);
		// Find the State Id of Tamil Nadu
		ArrayList<Datum> stateList = stateList_Output_Pojo.getData();
		for (Datum eachState : stateList) {
			String stateName = eachState.getName();
			if (stateName.equals("Tamil Nadu")) {
				stateId = eachState.getId();
				stateIdText = String.valueOf(stateId);
				System.out.println(stateId);
				break;
			}
		}
	}

	public void cityList() {
		initRestAssured();
		List<Header> lstHeader = new ArrayList<>();
		Header h1 = new Header("accept", "application/json");
		Header h2 = new Header("Content-Type", "application/json");
		lstHeader.add(h1);
		lstHeader.add(h2);
		Headers headers = new Headers(lstHeader);
		addHeaders(headers);
		CityList_Input_Pojo cityList_Input_Pojo = new CityList_Input_Pojo(stateIdText);
		addPayload(cityList_Input_Pojo);

		Response response = getRequest("POST", "/cityList");
//		printResponse(response);

		CityList_Output_Pojo cityList_Output_Pojo = response.as(CityList_Output_Pojo.class);
		ArrayList<com.omrbranch.pojo.citylist.Datum> cityList = cityList_Output_Pojo.getData();
		for (com.omrbranch.pojo.citylist.Datum eachCity : cityList) {
			String cityName = eachCity.getName();
			if (cityName.equals("Chennai")) {
				cityId = eachCity.getId();
				System.out.println(cityId);
				break;
			}
		}
	}

	public void addUserAddress() {
		initRestAssured();
		List<Header> lstHeader = new ArrayList<>();
		Header h1 = new Header("accept", "application/json");
		Header h2 = new Header("Content-Type", "application/json");
		Header h3 = new Header("Authorization", "Bearer " + logtoken);
		lstHeader.add(h1);
		lstHeader.add(h2);
		lstHeader.add(h3);
		Headers headers = new Headers(lstHeader);
		addHeaders(headers);
		AddUserAddress_Input_Pojo addUserAddress_Input_Pojo = new AddUserAddress_Input_Pojo("Naveen", "Prakash",
				"1234567898", "AK", stateId, cityId, 101, "600097", "Chennai", "Home");
		addPayload(addUserAddress_Input_Pojo);
		Response response = getRequest("POST", "/addUserAddress");
//		printResponse(response);

		AddUserAddress_Output_Pojo addUserAddress_Output_Pojo = response.as(AddUserAddress_Output_Pojo.class);
		int address_id = addUserAddress_Output_Pojo.getAddress_id();
		addressId = String.valueOf(address_id);
		System.out.println(address_id);

	}

	public void updateUserAddress() {
		initRestAssured();
		List<Header> lstHeader = new ArrayList<>();
		Header h1 = new Header("accept", "application/json");
		Header h2 = new Header("Content-Type", "application/json");
		Header h3 = new Header("Authorization", "Bearer " + logtoken);
		lstHeader.add(h1);
		lstHeader.add(h2);
		lstHeader.add(h3);
		Headers headers = new Headers(lstHeader);
		addHeaders(headers);
		UpdateAddress_Input_Pojo address_Input_Pojo = new UpdateAddress_Input_Pojo(addressId, "Mani", "Vk",
				"9944152058", "AKM", stateId, cityId, 101, "600095", "CHennai", "Home");
		addPayload(address_Input_Pojo);
		Response response = getRequest("PUT", "/updateUserAddress");
		UpdateAddress_Output_Pojo address_Output_Pojo = response.as(UpdateAddress_Output_Pojo.class);
		String message = address_Output_Pojo.getMessage();
		System.out.println(message);
	}

	public void deleteUserAddress() {
		initRestAssured();
		List<Header> lstHeader = new ArrayList<>();
		Header h1 = new Header("accept", "application/json");
		Header h2 = new Header("Content-Type", "application/json");
		Header h3 = new Header("Authorization", "Bearer " + logtoken);
		lstHeader.add(h1);
		lstHeader.add(h2);
		lstHeader.add(h3);
		Headers headers = new Headers(lstHeader);
		addHeaders(headers);
		DeleteAddress_Input_Pojo deleteAddress_Input_Pojo = new DeleteAddress_Input_Pojo(addressId);
		addPayload(deleteAddress_Input_Pojo);
		Response response = getRequest("DELETE", "/deleteAddress");
		DeleteAddress_Output_Pojo deleteAddress_Output_Pojo = response.as(DeleteAddress_Output_Pojo.class);
		String message = deleteAddress_Output_Pojo.getMessage();
		System.out.println(message);
	}

	public static void main(String[] args) {
		LoginAPI loginAPI = new LoginAPI();
		loginAPI.login();
		loginAPI.stateList();
		loginAPI.cityList();
		loginAPI.addUserAddress();
		loginAPI.updateUserAddress();
		loginAPI.deleteUserAddress();
	}

}
