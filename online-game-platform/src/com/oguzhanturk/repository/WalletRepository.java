package com.oguzhanturk.repository;

import java.util.ArrayList;
import java.util.List;

import com.oguzhanturk.entity.user.Wallet;
import static com.oguzhanturk.db.OnMemoryDatabase.WALLETS;
import com.oguzhanturk.util.Utils;

public class WalletRepository implements CrudRepository<Wallet> {

	@Override
	public Wallet save(Wallet wallet) {
		return WALLETS.put(Utils.generateIdFor(wallet), wallet);
	}

	@Override
	public Wallet findById(int id) {

		return WALLETS.get(id);
	}

	@Override
	public boolean update(int idOfWalletWillBeUpdated, Wallet newWallet) {

		if (newWallet.getId() != 0) {
			return false;
		}
		newWallet.setId(idOfWalletWillBeUpdated);
		return WALLETS.replace(idOfWalletWillBeUpdated, findById(idOfWalletWillBeUpdated), newWallet);
	}

	@Override
	public Wallet delete(int id) {
		return WALLETS.remove(id);
	}

	@Override
	public List<Wallet> findAll() {
		List<Wallet> wallets = new ArrayList<Wallet>(WALLETS.values());
		return wallets;
	}

}
