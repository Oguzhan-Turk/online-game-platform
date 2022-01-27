package com.oguzhanturk.repository;

import java.util.ArrayList;
import java.util.List;

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
