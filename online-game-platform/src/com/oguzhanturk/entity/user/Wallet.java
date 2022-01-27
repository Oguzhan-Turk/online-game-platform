package com.oguzhanturk.entity.user;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import com.oguzhanturk.entity.BaseEntity;

public class Wallet extends BaseEntity {

	private User owner;
	private BigDecimal balance;
	private Set<CreditCard> registeredCards;

	public Wallet(User owner) {
		super();
		this.owner = owner;
		this.balance = BigDecimal.ZERO;
		this.registeredCards = new HashSet<CreditCard>();
	}

	public User getOwned() {
		return owner;
	}

	public void setOwned(User owner) {
		this.owner = owner;
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

	public boolean registerCard(CreditCard creditCard) {
		return registeredCards.add(creditCard);
	}

	public boolean removeCard(CreditCard creditCard) {
		return registeredCards.remove(creditCard);
	}

}
