package com.oguzhanturk.util;

import com.oguzhanturk.entity.BaseEntity;

public class Utils {

	public static void generateIdFor(BaseEntity entity) {
		int generatedId = IDGenerator.generate(entity.getClass());
		entity.setId(generatedId);
	}

}
