package com.omrbranch.pojo.login;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@lombok.Data
@AllArgsConstructor
@NoArgsConstructor
public class PostmanBasicAuthentication_Output_Pojo {

	private int status;
	private String message;
	private Data data;
	private String refer_msg;
	private int cart_count;
	private String role;

}
