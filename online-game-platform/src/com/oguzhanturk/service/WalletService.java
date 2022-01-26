package com.oguzhanturk.service;

import java.util.List;
import java.util.Objects;

import com.oguzhanturk.entity.user.Wallet;
import com.oguzhanturk.repository.WalletRepository;
import com.oguzhanturk.util.logger.FileLogger;
import com.oguzhanturk.util.logger.Logger;

public class WalletService {

	private final WalletRepository repository;
	private static final Logger LOGGER = new FileLogger(WalletService.class);

	public WalletService(WalletRepository repository) {
		this.repository = repository;
	}

	public Wallet addWallet(Wallet wallet) {
		repository.save(wallet);
		LOGGER.log("addWallet -> Wallet with id = " + wallet.getId() + " added");
		return wallet;
	}

	public Wallet findWalletById(int id) {
		return repository.findById(id);
	}

	public boolean updateWallet(int id, Wallet newWallet) {
		Wallet walletWillBeUpdated = findWalletById(id);
		boolean update = repository.update(id, newWallet);
		if (update) {
			LOGGER.log("updateWallet -> Wallet with id = " + walletWillBeUpdated.getId() + " updated");
		} else {
			LOGGER.log("updateWallet -> Wallet with id = " + id + " not found");
		}
		return update;
	}

	public Wallet deleteWallet(int id) {
		Wallet walletWillBeDeleted = repository.delete(id);
		if (Objects.isNull(walletWillBeDeleted)) {
			LOGGER.log("deleteWallet -> Wallet with id = " + id + " not found");
		} else {
			LOGGER.log("deleteWallet -> Wallet with id = " + walletWillBeDeleted.getId() + " deleted");
		}
		return walletWillBeDeleted;
	}

	public List<Wallet> findAll() {
		return repository.findAll();
	}
}
