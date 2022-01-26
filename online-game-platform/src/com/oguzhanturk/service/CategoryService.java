package com.oguzhanturk.service;

import java.util.List;
import java.util.Objects;

import com.oguzhanturk.entity.game.Category;
import com.oguzhanturk.repository.CategoryRepository;
import com.oguzhanturk.util.logger.FileLogger;
import com.oguzhanturk.util.logger.Logger;

public class CategoryService {

	private final CategoryRepository repository;
	private static final Logger LOGGER = new FileLogger(CategoryService.class);

	public CategoryService(CategoryRepository repository) {
		this.repository = repository;
	}

	public Category addCategory(Category category) {
		LOGGER.log("addCategory -> " + category.getName() + " added");
		return repository.save(category);
	}

	public Category findCategoryById(int id) {
		return repository.findById(id);
	}

	public boolean updateCategory(int id, Category newCategory) {
		Category categoryWillBeUpdated = findCategoryById(id);
		boolean update = repository.update(id, newCategory);
		if (update) {
			LOGGER.log("updateCategory -> " + categoryWillBeUpdated.getName() + " updated to " + newCategory.getName());
		} else {
			LOGGER.log("updateCategory -> Category with id = " + id + " not found");
		}
		return update;
	}

	public Category deleteCategory(int id) {
		Category categoryWillBeDeleted = repository.delete(id);
		if (Objects.isNull(categoryWillBeDeleted)) {
			LOGGER.log("deleteCategory -> Category with id = " + id + " not found");
		} else {
			LOGGER.log("deleteCategory -> " + categoryWillBeDeleted.getName() + " deleted");
		}
		return categoryWillBeDeleted;
	}

	public List<Category> findAll() {
		return repository.findAll();
	}
}
