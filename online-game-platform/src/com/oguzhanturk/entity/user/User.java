package com.oguzhanturk.entity.user;

import java.util.HashSet;
import java.util.Set;

import com.oguzhanturk.entity.BaseEntity;
import com.oguzhanturk.entity.game.Game;

public class User extends BaseEntity {

	private String fullName;
	private String userName;
	private String profilePicture;
	private String email;
	private String password;
	private Wallet wallet;
	private Set<Game> games;
	private Set<User> friendsList;

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getProfilePicture() {
		return profilePicture;
	}

	public void setProfilePicture(String profilePicture) {
		this.profilePicture = profilePicture;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Wallet getWallet() {
		return wallet;
	}

	public void setWallet(Wallet wallet) {
		this.wallet = wallet;
	}

	public Set<Game> getGames() {
		return new HashSet<Game>(games);
	}

	public Set<User> getFriendsList() {
		return new HashSet<User>(friendsList);
	}

	private User(UserBuilder userBuilder) {
		fullName = userBuilder.fullName;
		userName = userBuilder.userName;
		profilePicture = userBuilder.profilePicture;
		email = userBuilder.email;
		password = userBuilder.password;
		wallet = userBuilder.wallet;
		games = new HashSet<Game>();
		friendsList = new HashSet<User>();
	}

	// builder pattern
	public static class UserBuilder {
		private String fullName;
		private String userName;
		private String profilePicture;
		private String email;
		private String password;
		private Wallet wallet;

		public UserBuilder setFullName(String fullName) {
			this.fullName = fullName;
			return this;
		}

		public UserBuilder setUserName(String userName) {
			this.userName = userName;
			return this;
		}

		public UserBuilder setProfilePicture(String profilePicture) {
			this.profilePicture = profilePicture;
			return this;
		}

		public UserBuilder setEmail(String email) {
			this.email = email;
			return this;
		}

		public UserBuilder setPassword(String password) {
			this.password = password;
			return this;
		}

		public UserBuilder setWallet(Wallet wallet) {
			this.wallet = wallet;
			return this;
		}

		public User build() {
			return new User(this);
		}

	}

	@Override
	public BaseEntity getInstance() {
		return this;
	}

}
