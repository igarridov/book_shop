package org.shop.book.webcontrol;

import java.util.List;

import org.shop.book.model.Author;
import org.shop.book.model.Book;
import org.shop.book.model.Review;
import org.shop.book.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookRestController {

	@Autowired
	private transient BookService service;

	@RequestMapping(value = "/book", method = RequestMethod.GET)
	public List<Book> getAll() {
		return service.getAllBooks();
	}

	@RequestMapping(value = "/book/{id}", method = RequestMethod.GET)
	public Book getBook(@PathVariable(value = "id") Integer idbook) {
		return service.getById(idbook);
	}

	@RequestMapping(value = "/book/{id}/author", method = RequestMethod.GET)
	public List<Author> getBookAuthors(
			@PathVariable(value = "id") Integer idbook) {
		return service.getAuthorsByBookId(idbook);
	}

	@RequestMapping(value = "/book/{id}/review", method = RequestMethod.GET)
	public List<Review> getBookReviews(
			@PathVariable(value = "id") Integer idbook) {
		return service.getReviewsByBookId(idbook);
	}

}
