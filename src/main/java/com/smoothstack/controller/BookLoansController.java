package com.smoothstack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.smoothstack.entity.BookLoans;
import com.smoothstack.service.BookLoansService;

@RestController
@RequestMapping("/lms")
public class BookLoansController {

	@Autowired
	private BookLoansService bookLoansRepository;

	

	@PutMapping("/administrator/overRideDueDate")
	public ResponseEntity<BookLoans> overRideDueDate(@RequestParam("bookId") long bookId,
			@RequestParam("branchId") long branchId, @RequestParam("cardNo") long cardNo,
			@RequestParam String newDate) {
		return bookLoansRepository.overRideDueDate(bookId, branchId, cardNo, newDate);
	}

}

