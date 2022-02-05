package com.oguzhanturk.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Executors;

import com.oguzhanturk.entity.game.Game;
import com.oguzhanturk.entity.user.User;
import com.oguzhanturk.repository.GameRepository;
import com.oguzhanturk.repository.UserRepository;
import com.oguzhanturk.service.task.TcknVerificationTask;
import com.oguzhanturk.util.logger.FileLogger;
import com.oguzhanturk.util.logger.Logger;

public class UserService {

	private final UserRepository repository;
	private final GameRepository gameRepository;
	private static final Logger LOGGER = new FileLogger(UserService.class);

	public UserService(UserRepository repository, GameRepository gameRepository) {
		this.repository = repository;
		this.gameRepository = gameRepository;
	}

	public User addUser(User user) {
		new Thread(new TcknVerificationTask(user, repository)).start();
		return user;
	}

	public User findUserById(int id) {
		return repository.findById(id);
	}

	public boolean updateUser(int id, User newUser) {
		User userWillBeUpdated = findUserById(id);
		boolean update = repository.update(id, newUser);
		if (update) {
			LOGGER.log("updateUser -> " + userWillBeUpdated.getName() + " updated to " + newUser.getName());
		} else {
			LOGGER.log("updateUser -> User with id = " + id + " not found");
		}
		return update;
	}

	public User deleteUser(int id) {
		User userWillBeDeleted = repository.delete(id);
		if (Objects.isNull(userWillBeDeleted)) {
			LOGGER.log("deleteUser -> User with id = " + id + " not found");
		} else {
			LOGGER.log("deleteUser -> " + userWillBeDeleted.getName() + " deleted");
		}
		return userWillBeDeleted;
	}

	public List<User> findAll() {
		return repository.findAll();
	}

	public boolean addFriend(User user, User friend) {
		User foundUser = repository.findByTckn(user.gettCKN());
		User foundFriend = repository.findByTckn(friend.gettCKN());
		if (Objects.isNull(foundUser) || Objects.isNull(foundFriend)) {
			LOGGER.log("addFriend -> There is no user or friend in DB");
			return false;
		}
		LOGGER.log("addFriend -> User with id = " + user.getId() + "friend with id = " + friend.getId());
		return user.addFriend(friend);
	}

	public boolean removeFriend(User user, User friend) {
		User foundUser = repository.findByTckn(user.gettCKN());
		User foundFriend = repository.findByTckn(friend.gettCKN());
		if (Objects.isNull(foundUser) || Objects.isNull(foundFriend)) {
			LOGGER.log("removeFriend -> There is no user or friend in DB");
			return false;
		}
		LOGGER.log("removeFriend -> User with id = " + user.getId() + " friend with id = " + friend.getId());
		return user.removeFriend(friend);
	}

	public List<User> getFriendsListById(int id) {
		User foundUser = repository.findById(id);
		if (Objects.isNull(foundUser)) {
			LOGGER.log("getFriendsListById -> There is no user in DB");
			return null;
		}
		LOGGER.log("getFriendsListById -> Return friends list of user with id = " + foundUser.getId() + ", with size = "
				+ foundUser.getFriendsList().size() + " ");
		return new ArrayList<User>(foundUser.getFriendsList());
	}

	public boolean addGame(User user, int gameID) {
		User foundUser = repository.findByTckn(user.gettCKN());
		Game foundGame = gameRepository.findById(gameID);
		if (Objects.isNull(foundUser) || Objects.isNull(foundGame)) {
			LOGGER.log("addGame -> There is no user or game in DB");
			return false;
		}
		LOGGER.log("addGame -> User with id = " + user.getId() + " game with id = " + foundGame.getId());
		return user.addGame(foundGame);
	}

	public boolean removeGame(User user, int gameID) {
		User foundUser = repository.findByTckn(user.gettCKN());
		Game foundGame = gameRepository.findById(gameID);
		if (Objects.isNull(foundUser) || Objects.isNull(foundGame)) {
			LOGGER.log("removeGame -> There is no user or game in DB");
			return false;
		}
		LOGGER.log("removeGame -> User with id = " + user.getId() + " game with id = " + foundGame.getId());
		return user.removeGame(foundGame);
	}

	public List<Game> getGamesListOfUserById(int id) {
		User foundUser = repository.findById(id);
		if (Objects.isNull(foundUser)) {
			LOGGER.log("getGamesListOfUserById -> There is no user in DB");
			return null;
		}
		LOGGER.log("getGamesListOfUserById -> Return games list of user with id = " + foundUser.getId()
				+ ", with size = " + foundUser.getGames().size() + " ");
		return new ArrayList<Game>(foundUser.getGames());
	}

}
