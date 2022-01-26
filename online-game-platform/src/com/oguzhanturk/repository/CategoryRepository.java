package com.oguzhanturk.repository;

import java.util.ArrayList;
import java.util.List;

import com.oguzhanturk.entity.game.Category;
import static com.oguzhanturk.db.OnMemoryDatabase.CATEGORIES;
import com.oguzhanturk.util.Utils;

public class CategoryRepository implements CrudRepository<Category> {

	@Override
	public Category save(Category category) {
		return CATEGORIES.put(Utils.generateIdFor(category), category);
	}

	@Override
	public Category findById(int id) {
		return CATEGORIES.get(id);
	}

	@Override
	public boolean update(int idOfCategoryWillBeUpdated, Category newCategory) {
		if (newCategory.getId() != 0)
			return false;
		newCategory.setId(idOfCategoryWillBeUpdated);
		return CATEGORIES.replace(idOfCategoryWillBeUpdated, findById(idOfCategoryWillBeUpdated), newCategory);
	}

	@Override
	public Category delete(int id) {
		return CATEGORIES.remove(id);
	}

	@Override
	public List<Category> findAll() {
		List<Category> categories = new ArrayList<Category>(CATEGORIES.values());
		return categories;
	}

}
