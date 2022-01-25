package com.oguzhanturk.entity.game;

import com.oguzhanturk.entity.BaseEntity;
import com.oguzhanturk.entity.enumeration.Rate;
import com.oguzhanturk.entity.user.User;

public class Review extends BaseEntity {

	private User user;
	private String comment;
	private Rate rate;
	private Game game;

	public Review() {

	}

	public Review(User user, String comment, Rate rate, Game game) {
		super();
		this.user = user;
		this.comment = comment;
		this.rate = rate;
		this.game = game;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Rate getRate() {
		return rate;
	}

	public void setRate(Rate rate) {
		this.rate = rate;
	}

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

}
