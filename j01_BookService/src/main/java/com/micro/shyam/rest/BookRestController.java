package com.micro.shyam.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.micro.shyam.model.Book;

@RestController
@RequestMapping("/book")
public class BookRestController {
	@Autowired
	private Environment environment;

	@GetMapping("/data")
	public String getBookData() {
		return "Data of BOOK_SERVICE, Running on Port: " + environment.getProperty("local.server.port");
	}

	@GetMapping("/{id}")
	public Book getBookId(@PathVariable Integer id) {
		return new Book(id, "Head First Java", 500.76);
	}

	@GetMapping("/all")
	public List<Book> getAllBooks() {
		return List.of(new Book(501, "Head First Java", 500.34), new Book(601, "Spring in Action", 600.43),
				new Book(701, "Hibernate in Action", 700.334));
	}

	@GetMapping("/entity")
	public ResponseEntity<String> getEntity() {
		return new ResponseEntity<String>("Hello from BookRestControler", HttpStatus.OK);
	}
}
