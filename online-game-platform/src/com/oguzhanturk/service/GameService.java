package com.oguzhanturk.service;

import java.util.List;
import java.util.Objects;

import com.oguzhanturk.entity.game.Game;
import com.oguzhanturk.repository.GameRepository;
import com.oguzhanturk.util.logger.FileLogger;
import com.oguzhanturk.util.logger.Logger;

public class GameService {

	private final GameRepository repository;
	private static final Logger LOGGER = new FileLogger(GameService.class);

	public GameService(GameRepository repository) {
		this.repository = repository;
	}

	public Game addGame(Game game) {
		LOGGER.log("addGame -> " + game.getName() + " added");
		return repository.save(game);
	}

	public Game findGameById(int id) {
		return repository.findById(id);
	}

	public boolean updateGame(int id, Game newGame) {
		Game gameWillBeUpdated = findGameById(id);
		boolean update = repository.update(id, newGame);
		if (update) {
			LOGGER.log("updateGame -> " + gameWillBeUpdated.getName() + " updated to " + newGame.getName());
		} else {
			LOGGER.log("updateGame -> Game with id = " + id + " not found");
		}
		return update;
	}

	public Game deleteGame(int id) {
		Game gameWillBeDeleted = repository.delete(id);
		if (Objects.isNull(gameWillBeDeleted)) {
			LOGGER.log("deleteGame -> Game with id = " + id + " not found");
		} else {
			LOGGER.log("deleteGame -> " + gameWillBeDeleted.getName() + " deleted");
		}
		return gameWillBeDeleted;
	}

	public List<Game> findAll() {
		return repository.findAll();
	}

}
