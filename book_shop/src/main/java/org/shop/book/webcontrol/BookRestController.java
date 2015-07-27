package org.shop.book.webcontrol;

import java.util.List;

import org.shop.book.model.Book;
import org.shop.book.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
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

}
