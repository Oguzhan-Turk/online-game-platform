package com.oguzhanturk.repository;

import java.util.ArrayList;
import java.util.List;

import static com.oguzhanturk.db.OnMemoryDatabase.REVIEWS;
import com.oguzhanturk.entity.game.Review;
import com.oguzhanturk.util.Utils;

public class ReviewRepository implements CrudRepository<Review> {

	@Override
	public Review save(Review review) {

		Utils.generateIdFor(review);
		return REVIEWS.put(review.getId(), review);
	}

	@Override
	public Review findById(int id) {

		return REVIEWS.get(id);
	}

	@Override
	public boolean update(int idOfReviewWillBeUpdated, Review newReview) {

		if (newReview.getId() != 0) {
			return false;
		}
		newReview.setId(idOfReviewWillBeUpdated);
		return REVIEWS.replace(idOfReviewWillBeUpdated, findById(idOfReviewWillBeUpdated), newReview);
	}

	@Override
	public Review delete(int id) {
		return REVIEWS.remove(id);
	}

	@Override
	public List<Review> findAll() {
		List<Review> reviews = new ArrayList<Review>(REVIEWS.values());
		return reviews;
	}

}
