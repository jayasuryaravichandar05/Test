package com.omrbranch.pojo.productlist;

import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductList_Output_Pojo {

	private int status;
	private String message;
	private String currency;
	private ArrayList<Datum> data;
	private String banner;
	private int cart_count;

}
