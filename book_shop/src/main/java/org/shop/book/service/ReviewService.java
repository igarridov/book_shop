package org.shop.book.service;

import java.util.List;

import org.shop.book.model.Review;

public interface ReviewService {

	List<Review> getReviewsByBookId(Integer idbook);
}
