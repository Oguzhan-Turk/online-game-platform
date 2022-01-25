package com.oguzhanturk.entity;

import com.oguzhanturk.util.IDGenerator;

public abstract class BaseEntity implements Entity {

	private int id = IDGenerator.generate(getInstance());

	public int getId() {
		return id;
	}

	public abstract BaseEntity getInstance();

}
