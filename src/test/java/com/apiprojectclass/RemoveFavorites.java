package com.apiprojectclass;

import java.util.ArrayList;
import java.util.List;

import com.omrbranch.baseclass.BaseClass;
import com.omrbranch.pojo.addfavorite.AddFavorite_Input_Pojo;
import com.omrbranch.pojo.addfavorite.AddFavorite_Output_Pojo;
import com.omrbranch.pojo.categorylist.CategoryList_Output_Pojo;
import com.omrbranch.pojo.categorylist.ChildCatList;
import com.omrbranch.pojo.categorylist.Datum;
import com.omrbranch.pojo.login.PostmanBasicAuthentication_Output_Pojo;
import com.omrbranch.pojo.productlist.Option;
import com.omrbranch.pojo.productlist.ProductList_Input_Pojo;
import com.omrbranch.pojo.productlist.ProductList_Output_Pojo;
import com.omrbranch.pojo.productlist.Variation;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class RemoveFavorites extends BaseClass{
	
	String logtoken;
	String categoryIdText;
	String productIdText;
	String variationIdText;

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

	
	public void getCategoryList() {
		initRestAssured();
		addHeader("accept", "application/json");
		Response response = getRequest("GET", "/categoryList");
		CategoryList_Output_Pojo categoryList_Output_Pojo = response.as(CategoryList_Output_Pojo.class);
		ArrayList<Datum> data = categoryList_Output_Pojo.getData();
		for(Datum eachData : data) {
			String categoryName = eachData.getName();
			if(categoryName.equals("Grocery")) {
				ArrayList<ChildCatList> child_cat_list = eachData.getChild_cat_list();
				for(ChildCatList eachChildCat : child_cat_list) {
					String childCatName = eachChildCat.getName();
					if(childCatName.equals("Fruit & Nuts")) {
						int categoryId = eachChildCat.getId();
						System.out.println(categoryId);
						categoryIdText = String.valueOf(categoryId);
						break;
					}
				}
			}
		}
	}
	
	public void getProductList() {
		initRestAssured();
		List<Header> lstHeader = new ArrayList<>();
		Header h1 = new Header("accept", "application/json");
		Header h2 = new Header("Content-Type", "application/json");
		lstHeader.add(h1);
		lstHeader.add(h2);
		Headers headers = new Headers(lstHeader);
		addHeaders(headers);
		ProductList_Input_Pojo productList_Input_Pojo = new ProductList_Input_Pojo(categoryIdText,"0");
		addPayload(productList_Input_Pojo);
		Response response = getRequest("POST", "/productList");
		ProductList_Output_Pojo productList_Output_Pojo = response.as(ProductList_Output_Pojo.class);
		ArrayList<com.omrbranch.pojo.productlist.Datum> data = productList_Output_Pojo.getData();
		for(com.omrbranch.pojo.productlist.Datum eachData : data) {
			String productName = eachData.getName();
			if(productName.equals("Nuts & Seeds - Raw Peanut")) {
				ArrayList<Variation> variations = eachData.getVariations();
				for(Variation variation : variations) {
					String specifications = variation.getSpecifications();
					if(specifications.equals("1 kg")) {
						ArrayList<Option> options = variation.getOptions();
						for(Option option : options) {
							int product_id = option.getProduct_id();
							productIdText = String.valueOf(product_id);
							System.out.println(productIdText);
							int variation_id = option.getVariation_id();
							variationIdText = String.valueOf(variation_id);
							System.out.println(variationIdText);
							break;
						}
					}
				}
			}
		}		
	}
	
	public void removeFavorite() {
		initRestAssured();
		List<Header> lstHeader = new ArrayList<>();
		Header h1 = new Header("accept","application/json");
		Header h2 = new Header("Authorization", "Bearer " + logtoken);
		Header h3 = new Header("Content-Type", "application/json");
		lstHeader.add(h1);
		lstHeader.add(h2);
		lstHeader.add(h3);
		Headers headers = new Headers(lstHeader);
		addHeaders(headers);
		AddFavorite_Input_Pojo addFavorite_Input_Pojo = new AddFavorite_Input_Pojo(productIdText,variationIdText);
		addPayload(addFavorite_Input_Pojo);
		Response response = getRequest("POST", "/manageUserFavourite");
//		AddFavorite_Output_Pojo addFavorite_Output_Pojo = response.as(AddFavorite_Output_Pojo.class);
		int statusCode = getStatusCode(response);
		System.out.println(statusCode);
	}
	
	
	public static void main(String[] args) {
		RemoveFavorites removeFavorites = new RemoveFavorites();
		removeFavorites.login();
		removeFavorites.getCategoryList();
		removeFavorites.getProductList();
		removeFavorites.removeFavorite();
	}
	
}
