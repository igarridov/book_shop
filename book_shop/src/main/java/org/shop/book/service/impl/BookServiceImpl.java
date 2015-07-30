package org.shop.book.service.impl;

import java.util.List;

import org.shop.book.dao.BookMapper;
import org.shop.book.model.Author;
import org.shop.book.model.Book;
import org.shop.book.model.Review;
import org.shop.book.service.AuthorService;
import org.shop.book.service.BookService;
import org.shop.book.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private transient BookMapper bookMapper;

	@Autowired
	private transient AuthorService authorService;

	@Autowired
	private transient ReviewService reviewService;

	@Override
	public List<Book> getAllBooks() {
		return bookMapper.selectByExample(null);
	}

	@Override
	public Book getById(Integer idbook) {
		return bookMapper.selectByPrimaryKey(idbook);
	}

	@Override
	public List<Author> getAuthorsByBookId(Integer idbook) {
		return authorService.getAuthorsByBookId(idbook);
	}

	@Override
	public List<Review> getReviewsByBookId(Integer idbook) {
		return reviewService.getReviewsByBookId(idbook);
	}

}
