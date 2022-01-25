package com.oguzhanturk.entity.game;

import java.util.HashSet;
import java.util.Set;

import com.oguzhanturk.entity.BaseEntity;

public class Category extends BaseEntity {

	private String name;
	private Set<Game> games;

	public Category() {
		// TODO Auto-generated constructor stub
	}

	public Category(String name) {
		super();
		this.name = name;
		games = new HashSet<Game>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Game> getGames() {
		return new HashSet<Game>();
	}


}
