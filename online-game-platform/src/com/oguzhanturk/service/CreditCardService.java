package com.oguzhanturk.service;

import java.util.List;
import java.util.Objects;

import com.oguzhanturk.entity.user.CreditCard;
import com.oguzhanturk.repository.CreditCardRepository;
import com.oguzhanturk.util.logger.FileLogger;
import com.oguzhanturk.util.logger.Logger;

public class CreditCardService {

	private final CreditCardRepository repository;
	private static final Logger LOGGER = new FileLogger(CreditCardService.class);

	public CreditCardService(CreditCardRepository repository) {
		this.repository = repository;
	}

	public CreditCard addCreditCard(CreditCard creditCard) {
		LOGGER.log("addCreditCard -> " + creditCard.getCardNo() + " added");
		return repository.save(creditCard);
	}

	public CreditCard findCreditCardById(int id) {
		return repository.findById(id);
	}

	public boolean updateCreditCard(int id, CreditCard newCreditCard) {
		CreditCard creditCardWillBeUpdated = findCreditCardById(id);
		boolean update = repository.update(id, newCreditCard);
		if (update) {
			LOGGER.log(
					"updateCreditCard -> " + creditCardWillBeUpdated.getId() + " updated to " + newCreditCard.getId());
		} else {
			LOGGER.log("updateCreditCard -> Credit Card with id = " + id + " not found");
		}
		return update;
	}

	public CreditCard deleteCreditCard(int id) {
		CreditCard creditCardWillBeDeleted = repository.delete(id);
		if (Objects.isNull(creditCardWillBeDeleted)) {
			LOGGER.log("deleteCreditCard -> Credit Card with id = " + id + " not found");
		} else {
			LOGGER.log("deleteCreditCard -> " + creditCardWillBeDeleted.getCardNo() + " deleted");
		}
		return creditCardWillBeDeleted;
	}

	public List<CreditCard> findAll() {
		return repository.findAll();
	}

}
