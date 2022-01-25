package com.oguzhanturk.main;

import com.oguzhanturk.entity.User;
import com.oguzhanturk.entity.User.UserBuilder;;


public class Driver {

	public static void main(String[] args) {

		User user = new UserBuilder().setEmail("test@test").setFullName("OguzhanTurk").setPassword("332").build();
		
	}
}
