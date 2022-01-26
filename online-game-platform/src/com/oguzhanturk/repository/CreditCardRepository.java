package com.oguzhanturk.repository;

import java.util.ArrayList;
import java.util.List;

import com.oguzhanturk.entity.user.CreditCard;
import static com.oguzhanturk.db.OnMemoryDatabase.CREDITCARDS;
import com.oguzhanturk.util.Utils;

public class CreditCardRepository implements CrudRepository<CreditCard> {

	@Override
	public CreditCard save(CreditCard creditCard) {
		return CREDITCARDS.put(Utils.generateIdFor(creditCard), creditCard);
	}

	@Override
	public CreditCard findById(int id) {

		return CREDITCARDS.get(id);
	}

	@Override
	public boolean update(int idOfCreditCardWillBeUpdated, CreditCard newCreditCard) {
		if (idOfCreditCardWillBeUpdated != 0)
			return false;
		newCreditCard.setId(idOfCreditCardWillBeUpdated);
		return CREDITCARDS.replace(idOfCreditCardWillBeUpdated, findById(idOfCreditCardWillBeUpdated), newCreditCard);
	}

	@Override
	public CreditCard delete(int id) {
		return CREDITCARDS.remove(id);
	}

	@Override
	public List<CreditCard> findAll() {
		List<CreditCard> creditCards = new ArrayList<CreditCard>(CREDITCARDS.values());
		return creditCards;
	}

}
