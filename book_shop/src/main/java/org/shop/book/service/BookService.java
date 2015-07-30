package org.shop.book.service;

import java.util.List;

import org.shop.book.model.Author;
import org.shop.book.model.Book;
import org.shop.book.model.Review;

public interface BookService {

	List<Book> getAllBooks();

	Book getById(Integer idbook);

	List<Author> getAuthorsByBookId(Integer idbook);

	List<Review> getReviewsByBookId(Integer idbook);
}
