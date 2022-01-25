package com.oguzhanturk.entity.enumeration;

public enum Rate {

	ONE(1), TWO(2), THREE(3), FOUR(4), FIVE(5);

	private int star;

	private Rate(int i) {
		star = i;
	}

	public int getStar() {
		return star;
	}

}
