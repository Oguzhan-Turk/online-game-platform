package com.oguzhanturk.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.oguzhanturk.entity.game.Game;
import com.oguzhanturk.entity.user.User;

public class Sale extends BaseEntity {

	private User buyer;
	private Game purchasedGame;
	private LocalDate purchaseDate;
	private BigDecimal paymentTotal;
	private Campaign campaign;
//	private BigDecimal discountAmount = BigDecimal.valueOf((100 - campaign.getDiscountPercentage()) / 100);

	public Sale(User buyer, Game purchasedGame, LocalDate purchaseDate) {
		super();
		this.buyer = buyer;
		this.purchasedGame = purchasedGame;
		this.purchaseDate = purchaseDate;
//		this.paymentTotal = purchasedGame.getPrice();
	}

	public Sale(User buyer, Game purchasedGame, LocalDate purchaseDate, Campaign campaign) {
		super();
		this.buyer = buyer;
		this.purchasedGame = purchasedGame;
		this.purchaseDate = purchaseDate;
		this.campaign = campaign;
//		this.paymentTotal = purchasedGame.getPrice().multiply(discountAmount);

	}

	public User getBuyer() {
		return buyer;
	}

	public void setBuyer(User buyer) {
		this.buyer = buyer;
	}

	public Game getPurchasedGame() {
		return purchasedGame;
	}

	public void setPurchasedGame(Game purchasedGame) {
		this.purchasedGame = purchasedGame;
	}

	public LocalDate getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(LocalDate purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	public BigDecimal getPaymentTotal() {
		return paymentTotal;
	}

	public void setPaymentTotal(BigDecimal paymentTotal) {
		this.paymentTotal = paymentTotal;
	}

	public Campaign getCampaign() {
		return campaign;
	}

	public void setCampaign(Campaign campaign) {
		this.campaign = campaign;
	}

}
