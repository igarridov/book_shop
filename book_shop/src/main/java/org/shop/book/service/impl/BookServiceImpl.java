package org.shop.book.service.impl;

import java.util.List;

import org.shop.book.dao.BookMapper;
import org.shop.book.model.Book;
import org.shop.book.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private transient BookMapper bookMapper;

	@Override
	public List<Book> getAllBooks() {
		return bookMapper.selectByExample(null);
	}

}
