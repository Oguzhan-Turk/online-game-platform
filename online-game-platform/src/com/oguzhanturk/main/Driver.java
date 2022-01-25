package com.oguzhanturk.main;

import com.oguzhanturk.entity.user.User;
import com.oguzhanturk.entity.user.User.UserBuilder;
import com.oguzhanturk.entity.user.Wallet;;

public class Driver {

	public static void main(String[] args) {

		User user1 = new UserBuilder().setEmail("test@test").setFullName("OguzhanTurk").setPassword("3632").build();
		User user2 = new UserBuilder().setEmail("test2@test").setFullName("Og22uzhanTurk").setPassword("3345332")
				.build();
		User user3 = new UserBuilder().setEmail("test2@test").setFullName("Og22uzhanTurk").setPassword("3333432")
				.build();
		User user4 = new UserBuilder().setEmail("tes11t2@test").setFullName("Og22uzha1nTurk").setPassword("33123332")
				.build();

		System.out.println(user1.getId());
		System.out.println(user2.getId());
		System.out.println(user3.getId());
		System.out.println(user4.getId());

		Wallet wallet = new Wallet(user1);
		Wallet wallet1 = new Wallet(user2);
		Wallet wallet2 = new Wallet(user3);
		Wallet wallet3 = new Wallet(user1);

		System.out.println(wallet.getId());
		System.out.println(wallet1.getId());
		System.out.println(wallet2.getId());
		System.out.println(wallet3.getId());

	}
}
