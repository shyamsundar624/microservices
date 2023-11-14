package com.micro.shyam.controller;

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
		return "Data of Book-Service, Running on Port: "+environment.getProperty("local.server.port");
	}
	
	@GetMapping("/{id}")
	public Book getBookByid(@PathVariable Integer id) {
		return Book.builder()
				.bookId(id)
				.bookName("Head First Java")
				.bookCost(3434.4)
				.build();
	}
	@GetMapping("/all")
	public List<Book> getAllBooks(){
		return List.of(
				new Book(501,"Head First Java",501.44),
				new Book(601,"Spring in Action",601.23),
				new Book(701,"Hibernate In Action",701.23)
				);
	}
	
	@GetMapping("/entity")
	public ResponseEntity<String> getEntityData(){
		return new ResponseEntity<String>("Hello from BookRestController",HttpStatus.OK);
	}
}
