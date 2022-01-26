package com.oguzhanturk.repository;

import java.util.ArrayList;
import java.util.List;

import static com.oguzhanturk.db.OnMemoryDatabase.USERS;
import com.oguzhanturk.entity.user.User;
import com.oguzhanturk.util.Utils;

public class UserRepository implements CrudRepository<User> {

	@Override
	public User save(User user) {

//		Utils.generateIdFor(user);
//		USERS.put(user.getId(), user);
		return USERS.put(Utils.generateIdFor(user), user);
	}

	@Override
	public User findById(int id) {

		return USERS.get(id);
	}

	@Override
	public boolean update(int idOfUserWillBeUpdated, User newUser) {
//		User userWillBeUpdate = USERS.get(idOfUserWillBeUpdated);
//		if (userWillBeUpdate == null)
//			return false;
//
//		updateUser(userWillBeUpdate, newUser);
//		return true;
		if (newUser.getId() != 0)
			return false;

		newUser.setId(idOfUserWillBeUpdated);
		return USERS.replace(idOfUserWillBeUpdated, findById(idOfUserWillBeUpdated), newUser);

	}
//
//	private User updateUser(User user, User newUser) {
//		user.setEmail(newUser.getEmail());
//		user.setFullName(newUser.getFullName());
//		user.setPassword(newUser.getPassword());
//		user.setProfilePicture(newUser.getProfilePicture());
//		user.setUserName(newUser.getUserName());
//		user.setWallet(newUser.getWallet());
//
//		return user;
//	}

	@Override
	public User delete(int id) {
		return USERS.remove(id); //What if we don't have any entity with this identity?	Should we return null?
	}

	@Override
	public List<User> findAll() {
		List<User> users = new ArrayList<User>(USERS.values());
		return users;
	}

}
