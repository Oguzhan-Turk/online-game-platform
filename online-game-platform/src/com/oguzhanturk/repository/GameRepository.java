package com.oguzhanturk.repository;

import java.util.ArrayList;
import java.util.List;

import com.oguzhanturk.entity.game.Game;
import com.oguzhanturk.entity.user.Wallet;
import com.oguzhanturk.util.Utils;
import static com.oguzhanturk.db.OnMemoryDatabase.GAMES;
import static com.oguzhanturk.db.OnMemoryDatabase.WALLETS;

public class GameRepository implements CrudRepository<Game> {

	@Override
	public Game save(Game game) {
		return GAMES.put(Utils.generateIdFor(game), game);
	}

	@Override
	public Game findById(int id) {
		return GAMES.get(id);
	}

	@Override
	public boolean update(int idOfGameWillBeUpdated, Game newGame) {
		if (newGame.getId() != 0)
			return false;
		newGame.setId(idOfGameWillBeUpdated);
		return GAMES.replace(idOfGameWillBeUpdated, findById(idOfGameWillBeUpdated), newGame);
	}

	@Override
	public Game delete(int id) {
		return GAMES.remove(id);
	}

	@Override
	public List<Game> findAll() {
		List<Game> games = new ArrayList<Game>(GAMES.values());
		return games;
	}

}
