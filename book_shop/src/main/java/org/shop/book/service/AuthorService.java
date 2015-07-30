package org.shop.book.service;

import java.util.List;

import org.shop.book.model.Author;

public interface AuthorService {

	List<Author> getAuthorsByBookId(Integer idbook);
}
