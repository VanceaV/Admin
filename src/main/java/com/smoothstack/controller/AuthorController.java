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

import com.smoothstack.entity.Author;
import com.smoothstack.service.AuthorService;

@RestController
@RequestMapping("/lms/administrator")
public class AuthorController {

	@Autowired
	private AuthorService authorService;

	@GetMapping(value = "/authors", produces = { "application/json", "application/xml" })
	public ResponseEntity<List<Author>> getAllAuthors() {
		List<Author> list = authorService.getAll();
		return new ResponseEntity<List<Author>>(list, HttpStatus.OK);
	}

	@PostMapping("/authors/author")
	public ResponseEntity<Author> addAuthor(@RequestBody Author author) {
		authorService.create(author);
		return new ResponseEntity<Author>(HttpStatus.CREATED);
	}

	@PutMapping("/authors/author")
	public ResponseEntity<Author> updateAuthor(@RequestBody Author author) {

		try {
			authorService.update(author);
		} catch (Exception e) {
			return new ResponseEntity<Author>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Author>(HttpStatus.OK);

	}

	@DeleteMapping("/authors/{authorId}")
	public ResponseEntity<Author> deleteAuthor(@PathVariable long authorId) {
		try {
			authorService.delete(authorId);
		} catch (Exception e) {

			ResponseEntity<Author> re = new ResponseEntity<Author>(HttpStatus.BAD_REQUEST);

			return re;
		}
		return new ResponseEntity<Author>(HttpStatus.ACCEPTED);
	}
}
