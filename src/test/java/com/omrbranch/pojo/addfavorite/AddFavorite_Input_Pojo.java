package com.omrbranch.pojo.addfavorite;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddFavorite_Input_Pojo {
	
	private String product_id;
	private String product_variation_id;

}
