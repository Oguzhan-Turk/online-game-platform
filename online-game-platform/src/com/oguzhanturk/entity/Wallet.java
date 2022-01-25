package com.oguzhanturk.entity;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

public class Wallet extends BaseEntity {

	private User owned;
	private BigDecimal balance;
	private Set<CreditCard> registeredCards;

	public Wallet(User owned) {
		super();
		this.owned = owned;
		this.registeredCards = new HashSet<CreditCard>();
	}

	public User getOwned() {
		return owned;
	}

	public void setOwned(User owned) {
		this.owned = owned;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

	public Set<CreditCard> getRegisteredCards() {
		return new HashSet<CreditCard>(registeredCards);
	}

}
