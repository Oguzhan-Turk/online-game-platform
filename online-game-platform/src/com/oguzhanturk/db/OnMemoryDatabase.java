package com.oguzhanturk.db;

import java.util.HashMap;

import com.oguzhanturk.entity.game.Category;
import com.oguzhanturk.entity.game.Game;
import com.oguzhanturk.entity.game.Review;
import com.oguzhanturk.entity.sale.Campaign;
import com.oguzhanturk.entity.sale.Sale;
import com.oguzhanturk.entity.user.CreditCard;
import com.oguzhanturk.entity.user.User;
import com.oguzhanturk.entity.user.Wallet;

public final class OnMemoryDatabase {

	public static final HashMap<Integer, User> USERS = new HashMap<Integer, User>();
	public static final HashMap<Integer, CreditCard> CREDITCARDS = new HashMap<Integer, CreditCard>();
	public static final HashMap<Integer, Wallet> WALLETS = new HashMap<Integer, Wallet>();
	public static final HashMap<Integer, Campaign> CAMPAIGNS = new HashMap<Integer, Campaign>();
	public static final HashMap<Integer, Category> CATEGORIES = new HashMap<Integer, Category>();
	public static final HashMap<Integer, Game> GAMES = new HashMap<Integer, Game>();
	public static final HashMap<Integer, Review> REVIEWS = new HashMap<Integer, Review>();
	public static final HashMap<Integer, Sale> SALES = new HashMap<Integer, Sale>();

}
