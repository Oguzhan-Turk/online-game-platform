package com.oguzhanturk.repository;

import java.util.ArrayList;
import java.util.List;

import static com.oguzhanturk.db.OnMemoryDatabase.SALES;

import com.oguzhanturk.entity.sale.Sale;
import com.oguzhanturk.util.Utils;

public class SaleRepository implements CrudRepository<Sale> {

	@Override
	public Sale save(Sale sale) {
		Utils.generateIdFor(sale);
		return SALES.put(sale.getId(), sale);
	}

	@Override
	public Sale findById(int id) {
		return SALES.get(id);
	}

	@Override
	public boolean update(int idOfSaleWillBeUpdated, Sale newSale) {
		if (newSale.getId() != 0)
			return false;
		newSale.setId(idOfSaleWillBeUpdated);
		return SALES.replace(idOfSaleWillBeUpdated, findById(idOfSaleWillBeUpdated), newSale);
	}

	@Override
	public Sale delete(int id) {
		return SALES.remove(id);
	}

	@Override
	public List<Sale> findAll() {
		List<Sale> sales = new ArrayList<Sale>(SALES.values());
		return sales;
	}

}
