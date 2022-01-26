package com.oguzhanturk.main;

import java.rmi.RemoteException;
import java.time.LocalDate;
import java.util.concurrent.TimeUnit;

import com.oguzhanturk.entity.user.User;
import com.oguzhanturk.entity.user.User.UserBuilder;
import com.oguzhanturk.repository.UserRepository;
import com.oguzhanturk.repository.WalletRepository;
import com.oguzhanturk.service.UserService;
import com.oguzhanturk.service.WalletService;

import com.oguzhanturk.entity.user.Wallet;;

public class Driver {

	public static void main(String[] args) throws RemoteException, InterruptedException {

		User user1 = new UserBuilder().setEmail("oguzhan@test").setName("Oğuzhan").setSurname("Türk")
				.setTCKN("33718242370").setDateOfBirth(LocalDate.of(1996, 8, 27)).build();
		User user2 = new UserBuilder().setEmail("ikram@test").setName("İkramDagcı").setPassword("123").build();
		User user3 = new UserBuilder().setEmail("ali@test").setName("AliTurk").setPassword("321").build();
//		User user4 = new UserBuilder().setEmail("mustafa@test").setName("MustafaTurk").setPassword("258").build();

		Wallet wallet = new Wallet(user1);
//		Wallet wallet1 = new Wallet(user2);
//		Wallet wallet2 = new Wallet(user3);
//		Wallet wallet3 = new Wallet(user2);

		UserService userService = new UserService(new UserRepository());
		WalletService walletService = new WalletService(new WalletRepository());

		userService.addUser(user1);
		userService.addUser(user2);
		userService.addUser(user3);
//		userService.updateUser(1, user4);
//		userService.deleteUser(2);

		walletService.addWallet(wallet);
//		walletService.addWallet(wallet1);
//		walletService.addWallet(wallet2);
//		walletService.updateWallet(2, wallet3);
//		walletService.deleteWallet(1);

		for (Wallet wallet0 : walletService.findAll()) {
			System.out.println("Wallet id = " + wallet0.getId() + " Owner : " + wallet0.getOwned().getName());
		}

		TimeUnit.SECONDS.sleep(2);

		System.out.println("------------");

		for (User user : userService.findAll()) {
			System.out.println("User id = " + user.getId() + " Name : " + user.getName());
		}

//		new Thread(() -> {
//			try {
//				System.out.println(new KPSPublicSoapProxy().TCKimlikNoDogrula(33718242370L, "Oğuzhan", "Türk ", 1996));
//			} catch (RemoteException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}).start();

//		System.out.println("test");
	}

	public static void test1() {

//		User user1 = new UserBuilder().setEmail("oguzhan@test").setFullName("OguzhanTurk").setPassword("852").build();
//		User user2 = new UserBuilder().setEmail("ikram@test").setFullName("İkramDagcı").setPassword("123").build();
//		User user3 = new UserBuilder().setEmail("ali@test").setFullName("AliTurk").setPassword("321").build();
//		User user4 = new UserBuilder().setEmail("mustafa@test").setFullName("MustafaTurk").setPassword("258").build();
//
//		UserRepository userRepository = new UserRepository();
//		userRepository.save(user1);
//		userRepository.save(user2);
//		userRepository.save(user3);
//		userRepository.save(user4);
//
//		userRepository.update(1, user2);
//		userRepository.delete(1);
//
//		for (User user : userRepository.findAll()) {
//			System.out.println(user.getId() + " " + user.getFullName());
//		}

	}

}
