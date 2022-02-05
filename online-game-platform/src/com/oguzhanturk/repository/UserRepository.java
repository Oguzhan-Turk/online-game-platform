package com.oguzhanturk.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static com.oguzhanturk.db.OnMemoryDatabase.USERS;
import com.oguzhanturk.entity.user.User;
import com.oguzhanturk.util.Utils;

public class UserRepository implements CrudRepository<User> {

	@Override
	public User save(User user) {

		USERS.put(Utils.generateIdFor(user), user);
		return findById(user.getId());
	}

	@Override
	public User findById(int id) {

		return USERS.get(id);
	}

	public User findByTckn(String tCKN) {
		List<User> usersWithTckn = USERS.values().stream().filter(user -> user.gettCKN().equals(tCKN))
				.collect(Collectors.toList());
		if (usersWithTckn.size() == 0) {
			return null;
		}
		return usersWithTckn.get(0);
	}

	@Override
	public boolean update(int idOfUserWillBeUpdated, User newUser) {

		if (newUser.getId() != 0)
			return false;

		newUser.setId(idOfUserWillBeUpdated);
		return USERS.replace(idOfUserWillBeUpdated, findById(idOfUserWillBeUpdated), newUser);

	}

	@Override
	public User delete(int id) {
		return USERS.remove(id);
	}

	@Override
	public List<User> findAll() {
		List<User> users = new ArrayList<User>(USERS.values());
		return users;
	}

}
