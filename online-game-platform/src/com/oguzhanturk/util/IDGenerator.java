package com.oguzhanturk.util;

import java.util.HashMap;

import com.oguzhanturk.entity.BaseEntity;
import com.oguzhanturk.entity.Campaign;
import com.oguzhanturk.entity.game.Category;
import com.oguzhanturk.entity.game.Game;
import com.oguzhanturk.entity.game.Review;
import com.oguzhanturk.entity.user.CreditCard;
import com.oguzhanturk.entity.user.User;
import com.oguzhanturk.entity.user.Wallet;

public class IDGenerator {

	private static HashMap<Class, Integer> idMap;
	static {
		idMap = new HashMap<Class, Integer>();
		init();
	}

//	public static int generate(BaseEntity entity) {
//		int id = idMap.get(entity.getClass());
//		idMap.put(entity.getClass(), id + 1);
//		return id;
//	}

	public static int generate(Class clazz) {
		int id = idMap.get(clazz);
		idMap.put(clazz, id + 1);
		return id;
	}

	private static void init() {
		idMap.put(Category.class, 1);
		idMap.put(Game.class, 1);
		idMap.put(Review.class, 1);
		idMap.put(CreditCard.class, 1);
		idMap.put(User.class, 1);
		idMap.put(Wallet.class, 1);
		idMap.put(Campaign.class, 1);
	}
}
