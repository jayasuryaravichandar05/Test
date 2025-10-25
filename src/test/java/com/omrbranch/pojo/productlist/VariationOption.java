package com.omrbranch.pojo.productlist;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VariationOption {
	
	private int id;
    private int product_id;
    private int variation_id;
    private String attribute_id;
    private int attribute_value_id;
    private String status;
    private String created_at;
    private String updated_at;

}
