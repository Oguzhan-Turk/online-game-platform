package com.oguzhanturk.entity;

public abstract class BaseEntity implements Entity {

	private int id;

	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

}
