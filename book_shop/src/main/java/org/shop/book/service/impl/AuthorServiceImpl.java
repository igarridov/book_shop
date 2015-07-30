package org.shop.book.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.shop.book.dao.AuthorMapper;
import org.shop.book.dao.BookAuthorMapper;
import org.shop.book.model.Author;
import org.shop.book.model.AuthorExample;
import org.shop.book.model.BookAuthor;
import org.shop.book.model.BookAuthorExample;
import org.shop.book.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorServiceImpl implements AuthorService {

	@Autowired
	private transient BookAuthorMapper bookAuthorMapper;

	@Autowired
	private transient AuthorMapper authorMapper;

	@Override
	public List<Author> getAuthorsByBookId(Integer idbook) {
		List<Integer> authorsIdByBookId = getAuthorsIdByBookId(idbook);

		if (authorsIdByBookId.isEmpty()) {
			return new ArrayList<Author>();
		}

		AuthorExample example = new AuthorExample();
		example.createCriteria().andIdauthorIn(authorsIdByBookId);

		return authorMapper.selectByExample(example);
	}

	private List<Integer> getAuthorsIdByBookId(Integer idbook) {
		BookAuthorExample exampleAux = new BookAuthorExample();
		exampleAux.createCriteria().andIdbookEqualTo(idbook);

		List<BookAuthor> bookAuthor = bookAuthorMapper
				.selectByExample(exampleAux);

		List<Integer> authorIdList = new ArrayList<Integer>();
		for (BookAuthor aux : bookAuthor) {
			authorIdList.add(aux.getIdauthor());
		}

		return authorIdList;
	}

}
