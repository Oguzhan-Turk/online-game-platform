package com.oguzhanturk.main;

import com.oguzhanturk.entity.user.User;
import com.oguzhanturk.entity.user.User.UserBuilder;
import com.oguzhanturk.repository.UserRepository;
import com.oguzhanturk.entity.user.Wallet;;

public class Driver {

	public static void main(String[] args) {

		User user1 = new UserBuilder().setEmail("oguzhan@test").setFullName("OguzhanTurk").setPassword("852").build();
		User user2 = new UserBuilder().setEmail("ikram@test").setFullName("İkramDagcı").setPassword("123").build();
		User user3 = new UserBuilder().setEmail("ali@test").setFullName("AliTurk").setPassword("321").build();
		User user4 = new UserBuilder().setEmail("mustafa@test").setFullName("MustafaTurk").setPassword("258").build();

		Wallet wallet = new Wallet(user1);
		Wallet wallet1 = new Wallet(user2);
		Wallet wallet2 = new Wallet(user3);
		Wallet wallet3 = new Wallet(user1);

		UserRepository userRepository = new UserRepository();
		userRepository.save(user1);
		userRepository.save(user2);
		userRepository.save(user3);
		userRepository.save(user4);

		userRepository.update(1, user2);
//		userRepository.delete(1);

		for (User user : userRepository.findAll()) {
			System.out.println(user.getId() + " " + user.getFullName());
		}
	}
}
