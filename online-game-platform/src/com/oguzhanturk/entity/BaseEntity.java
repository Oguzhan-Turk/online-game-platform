package com.oguzhanturk.entity;

import com.oguzhanturk.util.IDGenerator;

public abstract class BaseEntity implements Entity {

	private int id;
//	IDGenerator.generate(getInstance());

	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}


}
