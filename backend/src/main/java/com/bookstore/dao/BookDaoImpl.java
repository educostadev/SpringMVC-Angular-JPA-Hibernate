package com.bookstore.dao;

import java.util.List;
import java.util.Optional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bookstore.model.Book;

@Repository
public class BookDaoImpl implements BookDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public long save(Book book) {
		sessionFactory.getCurrentSession().save(book);
		return book.getId();
	}

	@Override
	public List<Book> list() {
		return sessionFactory.getCurrentSession().createQuery("from Books").list();
	}

	@Override
	public Book get(long id) {
		return sessionFactory.getCurrentSession().get(Book.class, id);
	}

	@Override
	public void update(long id, Book book) {
		Session session = sessionFactory.getCurrentSession();
		Book book2 = session.byId(Book.class).load(id);
		book2.setTitle(book.getTitle());
		book2.setAuthor(book.getAuthor());
		session.flush();
	}

	@Override
	public boolean delete(long id) {
		Book book = sessionFactory.getCurrentSession().byId(Book.class).load(id);
		if (book == null) {
			return false;
		}
		sessionFactory.getCurrentSession().delete(book);
		return true;
	}

}
