package com.oguzhanturk.entity.sale;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.oguzhanturk.entity.BaseEntity;
import com.oguzhanturk.entity.game.Game;
import com.oguzhanturk.entity.user.User;

public class Sale extends BaseEntity {

	private User buyer;
	private Game purchasedGame;
	private LocalDate purchaseDate;
	private BigDecimal paymentTotal;
	private Campaign campaign;

	public Sale(User buyer, Game purchasedGame) {
		this.buyer = buyer;
		this.purchasedGame = purchasedGame;
		purchaseDate = LocalDate.now();
	}

	public Sale(User buyer, Game purchasedGame, Campaign campaign) {
		this(buyer, purchasedGame);
		this.campaign = campaign;
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
