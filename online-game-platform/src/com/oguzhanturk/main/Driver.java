package com.oguzhanturk.main;

import java.math.BigDecimal;
import java.rmi.RemoteException;
import java.time.LocalDate;
import java.util.concurrent.TimeUnit;

import com.oguzhanturk.entity.Campaign;
import com.oguzhanturk.entity.Sale;
import com.oguzhanturk.entity.game.Game;
import com.oguzhanturk.entity.user.CreditCard;
import com.oguzhanturk.entity.user.User;
import com.oguzhanturk.entity.user.User.UserBuilder;
import com.oguzhanturk.repository.CampaignRepository;
import com.oguzhanturk.repository.GameRepository;
import com.oguzhanturk.repository.SaleRepository;
import com.oguzhanturk.repository.UserRepository;
import com.oguzhanturk.repository.WalletRepository;
import com.oguzhanturk.service.CampaignService;
import com.oguzhanturk.service.GameService;
import com.oguzhanturk.service.SaleService;
import com.oguzhanturk.service.UserService;
import com.oguzhanturk.service.WalletService;

import com.oguzhanturk.entity.user.Wallet;;

public class Driver {

	public static void main(String[] args) throws RemoteException, InterruptedException {

		CampaignRepository campaignRepository = new CampaignRepository();

		UserService userService = new UserService(new UserRepository());
		WalletService walletService = new WalletService(new WalletRepository());
		GameService gameService = new GameService(new GameRepository());
		SaleService saleService = new SaleService(new SaleRepository(), campaignRepository);
		CampaignService campaignService = new CampaignService(campaignRepository);

		User user = User.builder().setEmail("oguzhan@test").setName("Oğuzhan").setSurname("Türk").setTCKN("11111111111")
				.setDateOfBirth(LocalDate.of(1996, 8, 27)).build();

		Wallet wallet = new Wallet(user);
		wallet.setBalance(BigDecimal.valueOf(500.0));
		user.setWallet(wallet);

		Campaign campaign = new Campaign("Summer Campaign", 20);

		Game game = new Game("COD", BigDecimal.valueOf(150), "Nice War Game!!");

		campaignService.addCampaign(campaign);
		userService.addUser(user);
		walletService.addWallet(wallet);
		gameService.addGame(game);

		Sale sale = saleService.sellGame(user, game, campaign);

		printSaleInfo(sale);

	}

	public static void printSaleInfo(Sale sale) {

		System.out.println("Sale ID : " + sale.getId() + "\nBuyer : " + sale.getBuyer().getName() + " "
				+ sale.getBuyer().getSurname() + "\nGame : " + sale.getPurchasedGame().getName() + "\nTotal price : "
				+ sale.getPaymentTotal());

	}

}
