package com.micro.shyam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.micro.shyam.consumer.BookRestConsumer;

@RestController
@RequestMapping("/student")
public class StudentRestController {

	@Autowired
	private BookRestConsumer consumer;
	
	
	@GetMapping("/data")
	public String getStudentInfo() {
		System.out.println(consumer.getClass().getName());
		return "Accessing from STUDENT-SERVICE ===>"+consumer.getBookData();
	}
	
	@GetMapping("/allBooks")
	public String getBooksInfo() {
		return "Accessing From STUDENT-SERVICE"+consumer.getAllBooks();
	}
	
	@GetMapping("/getOneBook/{id}")
	public String getOneBook(@PathVariable Integer id) {
		return "Accessing from STUDENT-SERVICE ==> "+consumer.getBookById(id);
	}
}
