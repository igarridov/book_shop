package org.shop.book.service.impl;

import java.util.List;

import org.shop.book.dao.ReviewMapper;
import org.shop.book.model.Review;
import org.shop.book.model.ReviewExample;
import org.shop.book.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReviewServiceImpl implements ReviewService {

	@Autowired
	private transient ReviewMapper reviewMapper;

	@Override
	public List<Review> getReviewsByBookId(Integer idbook) {
		ReviewExample example = new ReviewExample();
		example.createCriteria().andBookIdbookEqualTo(idbook);

		return reviewMapper.selectByExample(example);
	}

}
