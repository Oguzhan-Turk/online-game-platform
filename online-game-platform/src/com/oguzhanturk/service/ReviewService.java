package com.oguzhanturk.service;

import java.util.List;
import java.util.Objects;

import com.oguzhanturk.entity.game.Review;
import com.oguzhanturk.repository.ReviewRepository;
import com.oguzhanturk.util.logger.FileLogger;
import com.oguzhanturk.util.logger.Logger;

public class ReviewService {

	private final ReviewRepository repository;
	private static final Logger LOGGER = new FileLogger(ReviewService.class);

	public ReviewService(ReviewRepository repository) {
		this.repository = repository;
	}

	public Review addReview(Review review) {
		LOGGER.log("addReview -> " + review.getId() + " added");
		return repository.save(review);
	}

	public Review findReviewById(int id) {
		return repository.findById(id);
	}

	public boolean updateReview(int id, Review newReview) {
		Review reviewWillBeUpdated = findReviewById(id);
		boolean update = repository.update(id, newReview);
		if (update) {
			LOGGER.log("updateReview -> " + reviewWillBeUpdated.getId() + " updated");
		} else {
			LOGGER.log("updateReview -> Review with id = " + id + " not found");
		}
		return update;
	}

	public Review deleteReview(int id) {
		Review reviewWillBeDeleted = repository.delete(id);
		if (Objects.isNull(reviewWillBeDeleted)) {
			LOGGER.log("deleteReview -> Review with id = " + id + " not found");
		} else {
			LOGGER.log("deleteReview -> " + reviewWillBeDeleted.getId() + " deleted");
		}
		return reviewWillBeDeleted;
	}

	public List<Review> findAll() {
		return repository.findAll();
	}

}
