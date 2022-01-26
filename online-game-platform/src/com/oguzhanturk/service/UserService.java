package com.oguzhanturk.service;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.Executors;

import com.oguzhanturk.entity.user.User;
import com.oguzhanturk.repository.UserRepository;
import com.oguzhanturk.service.task.TcknVerificationTask;
import com.oguzhanturk.util.logger.FileLogger;
import com.oguzhanturk.util.logger.Logger;

public class UserService {

	private final UserRepository repository;
	private static final Logger LOGGER = new FileLogger(UserService.class);

	public UserService(UserRepository repository) {
		this.repository = repository;
	}

	public User addUser(User user) {
		repository.save(user);
		new Thread(new TcknVerificationTask(user)).start();
		LOGGER.log("addUser -> " + user.getId() + " added");
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

}
