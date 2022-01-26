package com.oguzhanturk.repository;

import java.util.List;

public interface CrudRepository<T> {

	T save(T t);

	T findById(int id);

	boolean update(int idOfEntityWillBeUpdated, T newT);

	T delete(int id);

	List<T> findAll();
}
