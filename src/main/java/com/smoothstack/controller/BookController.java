package com.smoothstack.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smoothstack.entity.Book;
import com.smoothstack.service.BookService;

@RestController
@RequestMapping("/lms/administrator")
public class BookController {

	@Autowired
	private BookService bookRepository;

	@GetMapping("/books")
	public ResponseEntity<List<Book>> getAllBooks() {
		List<Book> list = bookRepository.getAll();
		return new ResponseEntity<List<Book>>(list, HttpStatus.OK);
	}

	@PostMapping("/books/book")
	public ResponseEntity<Book> addBook(@RequestBody Book book) {
		bookRepository.create(book);
		return new ResponseEntity<Book>(HttpStatus.CREATED);
	}

	@PutMapping("/books/book")
	public ResponseEntity<Book> updateBook(@RequestBody Book book) {

		try {
			bookRepository.update(book);
		} catch (Exception e) {
			return new ResponseEntity<Book>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Book>(HttpStatus.OK);
	}

	@DeleteMapping("/books/{bookId}")
	public ResponseEntity<Book> deleteBook(@PathVariable long bookId) {

		try {
			bookRepository.delete(bookId);
		} catch (Exception e) {
			return new ResponseEntity<Book>(HttpStatus.BAD_REQUEST);
		}
		bookRepository.delete(bookId);
		return new ResponseEntity<Book>(HttpStatus.ACCEPTED);
	}

}
