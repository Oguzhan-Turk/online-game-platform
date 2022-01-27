package com.oguzhanturk.service;

import java.util.List;
import java.util.Objects;

import com.oguzhanturk.entity.Sale;
import com.oguzhanturk.repository.SaleRepository;
import com.oguzhanturk.util.logger.FileLogger;
import com.oguzhanturk.util.logger.Logger;

public class SaleService {
	private final SaleRepository repository;
	private static final Logger LOGGER = new FileLogger(SaleService.class);

	public SaleService(SaleRepository repository) {
		this.repository = repository;
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

}
