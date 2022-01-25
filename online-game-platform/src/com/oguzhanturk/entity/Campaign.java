package com.oguzhanturk.entity;

public class Campaign extends BaseEntity {

	private String name;
	private int discountPercentage;

	public Campaign() {
		// TODO Auto-generated constructor stub
	}

	public Campaign(String name, int discountPercentage) {
		super();
		this.name = name;
		this.discountPercentage = discountPercentage;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getDiscountPercentage() {
		return discountPercentage;
	}

	public void setDiscountPercentage(int discountPercentage) {
		this.discountPercentage = discountPercentage;
	}

	@Override
	public BaseEntity getInstance() {
		return this;
	}

}
