package com.oguzhanturk.entity.user;

import java.time.LocalDate;

import com.oguzhanturk.entity.BaseEntity;

public class CreditCard extends BaseEntity {

	private User owner;
	private String cardNo;
	private LocalDate expiredDate;
	private byte password;

	public CreditCard() {
	}

	public CreditCard(User owner, String cardNo, LocalDate expiredDate, byte password) {
		super();
		this.owner = owner;
		this.cardNo = cardNo;
		this.expiredDate = expiredDate;
		this.password = password;
	}

	public User getOwner() {
		return owner;
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}

	public String getCardNo() {
		return cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

	public LocalDate getExpiredDate() {
		return expiredDate;
	}

	public void setExpiredDate(LocalDate expiredDate) {
		this.expiredDate = expiredDate;
	}

	public byte getPassword() {
		return password;
	}

	public void setPassword(byte password) {
		this.password = password;
	}
	
}
