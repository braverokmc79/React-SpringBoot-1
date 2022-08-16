package com.cos.demo.web;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cos.demo.domain.Book;
import com.cos.demo.service.BookService;

import lombok.RequiredArgsConstructor;

@CrossOrigin
@RequiredArgsConstructor
@RestController
public class BookController {
	
	private final BookService bookService;
	
	@PostMapping("/book")
	public ResponseEntity<?> save(@RequestBody Book book){			
		return new ResponseEntity<>(bookService.saveBook(book), HttpStatus.CREATED);
	}
	
	@CrossOrigin
	@GetMapping("/book")
	public ResponseEntity<?> findAll(){		
		return new ResponseEntity<>(bookService.getAllBook(), HttpStatus.OK);
	}
	
	@GetMapping("/book/{id}")
	public ResponseEntity<?> findById(@PathVariable Long id){		
		return new ResponseEntity<>(bookService.getBook(id), HttpStatus.OK);	
	}
		
	@PutMapping("/book/{id}")
	public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Book book){
		return new ResponseEntity<>(bookService.getBook(id), HttpStatus.OK);
	}

	@DeleteMapping("/book/{id}")
	public ResponseEntity<?> deleteById(@PathVariable Long id){	
		return new ResponseEntity<>(bookService.deletBook(id), HttpStatus.OK);
	}
		
}



