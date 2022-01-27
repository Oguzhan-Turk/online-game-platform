package com.oguzhanturk.service;

import java.util.List;
import java.util.Objects;

import com.oguzhanturk.domain.SellGame;
import com.oguzhanturk.entity.game.Game;
import com.oguzhanturk.entity.sale.Campaign;
import com.oguzhanturk.entity.sale.Sale;
import com.oguzhanturk.entity.user.User;
import com.oguzhanturk.repository.CampaignRepository;
import com.oguzhanturk.repository.SaleRepository;
import com.oguzhanturk.util.logger.FileLogger;
import com.oguzhanturk.util.logger.Logger;

public class SaleService {
	private final SaleRepository repository;
	private final CampaignRepository campaignRepository;
	private static final Logger LOGGER = new FileLogger(SaleService.class);

	public SaleService(SaleRepository repository, CampaignRepository campaignRepository) {
		this.repository = repository;
		this.campaignRepository = campaignRepository;
	}

	public Sale addSale(Sale sale) {
		LOGGER.log("addSale -> " + sale.getId() + " added");
		return repository.save(sale);
	}

	public Sale findSaleById(int id) {
		return repository.findById(id);
	}

	public boolean updateSale(int id, Sale newSale) {
		Sale saleWillBeUpdated = findSaleById(id);
		boolean update = repository.update(id, newSale);
		if (update) {
			LOGGER.log("updateSale -> " + saleWillBeUpdated.getId() + " updated");
		} else {
			LOGGER.log("updateSale -> Sale with id = " + id + " not found");
		}
		return update;
	}

	public Sale deleteSale(int id) {
		Sale saleWillBeDeleted = repository.delete(id);
		if (Objects.isNull(saleWillBeDeleted)) {
			LOGGER.log("deleteSale -> Sale with id = " + id + " not found");
		} else {
			LOGGER.log("deleteSale -> " + saleWillBeDeleted.getId() + " deleted");
		}
		return saleWillBeDeleted;
	}

	public List<Sale> findAll() {
		return repository.findAll();
	}

	public Sale sellGame(User buyer, Game game) {

		return sellGame(buyer, game, null);

	}

	public Sale sellGame(User buyer, Game game, Campaign campaign) {

		Sale sale = new SellGame(buyer, game, campaignRepository.findById(campaign.getId())).sell();
		if (Objects.nonNull(sale)) {
			addSale(sale);
			LOGGER.log("sellGame -> User ID : " + sale.getBuyer().getId() + " FullName : " + sale.getBuyer().getName()
					+ " " + sale.getBuyer().getSurname() + " bought " + game.getName() + " for $"
					+ sale.getPaymentTotal());
		} else {
			LOGGER.log(
					"sellGame -> Failed purchase (User ID : " + buyer.getId() + " Game Name : " + game.getName() + ")");
		}
		return sale;

	}

}
