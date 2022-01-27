package com.oguzhanturk.entity.user;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import com.oguzhanturk.entity.BaseEntity;
import com.oguzhanturk.entity.game.Game;

public class User extends BaseEntity {

	private String tCKN;
	private String name;
	private String surname;
	private LocalDate dateOfBirth;
	private String userName;
	private String profilePicture;
	private String email;
	private String password;
	private Wallet wallet;
	private Set<Game> games;
	private Set<User> friendsList;

	private User(UserBuilder userBuilder) {
		tCKN = userBuilder.tCKN;
		name = userBuilder.name;
		surname = userBuilder.surname;
		dateOfBirth = userBuilder.dateOfBirth;
		userName = userBuilder.userName;
		profilePicture = userBuilder.profilePicture;
		email = userBuilder.email;
		password = userBuilder.password;
		wallet = userBuilder.wallet;
		games = new HashSet<Game>();
		friendsList = new HashSet<User>();
	}

	public String gettCKN() {
		return tCKN;
	}

	public void settCKN(String tCKN) {
		this.tCKN = tCKN;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
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

	public boolean addGame(Game game) {
		return games.add(game);
	}

	public boolean removeGame(Game game) {
		return games.remove(game);
	}

	public boolean addFriend(User friend) {
		return friendsList.add(friend);
	}

	public boolean removeFriend(User friend) {
		return friendsList.remove(friend);
	}

	// builder pattern
	public static class UserBuilder {
		private String tCKN = "-1";
		private String name;
		private String surname;
		private LocalDate dateOfBirth = LocalDate.of(1, 1, 1);
		private String userName;
		private String profilePicture;
		private String email;
		private String password;
		private Wallet wallet;

		private UserBuilder() {
		}

		public UserBuilder setTCKN(String tCKN) {
			this.tCKN = tCKN;
			return this;
		}

		public UserBuilder setName(String name) {
			this.name = name;
			return this;
		}

		public UserBuilder setSurname(String surname) {
			this.surname = surname;
			return this;
		}

		public UserBuilder setDateOfBirth(LocalDate dateOfBirth) {
			this.dateOfBirth = dateOfBirth;
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

	public static UserBuilder builder() {
		return new UserBuilder();
	}

}
