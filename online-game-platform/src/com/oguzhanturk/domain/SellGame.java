package com.oguzhanturk.domain;

import java.math.BigDecimal;
import java.util.Objects;

import com.oguzhanturk.entity.game.Game;
import com.oguzhanturk.entity.sale.Campaign;
import com.oguzhanturk.entity.sale.Sale;
import com.oguzhanturk.entity.user.User;

public class SellGame {

	private Sale sale;

	public SellGame(User buyer, Game game) {
		this(buyer, game, null);
	}

	public SellGame(User buyer, Game game, Campaign campaign) {
		this.sale = new Sale(buyer, game, campaign);
	}

	/**
	 * Performs the sale of specified Game to the specified User.
	 * 
	 * @return Sale object if sale is complete otherwise null.
	 */
	public Sale sell() {

		sale.setPaymentTotal(calculatePaymentTotal());
		if (!checkUserBalance()) {
			return null;
		}
		sale.getBuyer().addGame(sale.getPurchasedGame());
		sale.getBuyer().getWallet()
				.setBalance(sale.getBuyer().getWallet().getBalance().subtract(sale.getPaymentTotal()));
		return sale;

	}

	private boolean checkUserBalance() {
		BigDecimal userBalance = sale.getBuyer().getWallet().getBalance();
		sale.setPaymentTotal(sale.getPurchasedGame().getPrice());

		return userBalance.compareTo(sale.getPaymentTotal()) >= 0;

	}

	private BigDecimal calculatePaymentTotal() {

		BigDecimal calculatedPaymentTotal = sale.getPaymentTotal();
		if (Objects.nonNull(sale.getCampaign())) {
			calculatedPaymentTotal = applyDiscount();
		}
		return calculatedPaymentTotal;
	}

	private BigDecimal applyDiscount() {

		BigDecimal discountedPrice = sale.getPurchasedGame().getPrice()
				.multiply(BigDecimal.valueOf(1.0 - sale.getCampaign().getDiscountPercentage() / 100.0));

		return discountedPrice;
	}

}
