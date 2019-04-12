package com.bookstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookstore.model.Book;
import com.bookstore.service.BookService;

/**
 * WARING: In a real application the methods should not return
 * {@link ResponseEntity}
 *
 */
@RestController
@RequestMapping("/api")
public class BookController {

	@Autowired
	private BookService bookService;

	@GetMapping("/book")
	public ResponseEntity<List<Book>> list() {
		List<Book> books = bookService.list();
		return ResponseEntity.ok().body(books);
	}

	@PostMapping("/book")
	public ResponseEntity<?> save(@RequestBody Book book) {
		long id = bookService.save(book);
		return ResponseEntity.ok().body("New Book has been saved with ID:" + id);
	}

	@GetMapping("/book/{id}")
	public ResponseEntity<Book> get(@PathVariable("id") long id) {
		Book book = bookService.get(id);
		return ResponseEntity.ok().body(book);
	}

	@PutMapping("/book/{id}")
	public ResponseEntity<?> update(@PathVariable("id") long id, @RequestBody Book book) {
		bookService.update(id, book);
		return ResponseEntity.ok().body("Book has been updated successfully.");
	}

	@DeleteMapping("/book/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") long id) {
		boolean success = bookService.delete(id);
		if (success) {
			return ResponseEntity.ok().build(); //RETURN 202 OK
		} else {
			return ResponseEntity.notFound().build(); //RETURN 404 ERROR
		}
	}

}
