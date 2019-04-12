package com.bookstore.service;

import java.util.List;

import com.bookstore.model.Book;
 
public interface BookService {

	long save(Book book);

	Book get(long id);

	List<Book> list();

	void update(long id, Book book);

	boolean delete(long id);
}
