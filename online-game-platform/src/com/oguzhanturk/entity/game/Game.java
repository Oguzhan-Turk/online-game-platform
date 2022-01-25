package com.oguzhanturk.entity.game;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import com.oguzhanturk.entity.BaseEntity;

public class Game extends BaseEntity {

	private String name;
	private BigDecimal price;
	private String description;
	private Set<String> pictures;
	private Set<Review> reviews;

	public Game() {
		this(null, BigDecimal.ZERO, null);
	}

	public Game(String name, BigDecimal price, String description) {
		super();
		this.name = name;
		this.price = price;
		this.description = description;
		this.pictures = new HashSet<String>();
		this.reviews = new HashSet<Review>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set<String> getPictures() {
		return pictures;
	}

	public Set<Review> getReviews() {
		return reviews;
	}

	@Override
	public BaseEntity getInstance() {
		return this;
	}

}
