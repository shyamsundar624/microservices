package com.micro.shyam.controller;

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
		return "Accessing from STUDENT-SERVICE ==> " + consumer.getBookData();
	}

	@GetMapping("/allBook")
	public String getBooksInfo() {
		return "Accessing from STUDENT-SERVICE ==> " + consumer.getAllBooks();
	}

	@GetMapping("getOneBook/{id}")
	public String getOneBookfoeStd(@PathVariable Integer id) {
		return "Accessing from STUDENT-SERVICE ==> " + consumer.getBookId(id);
	}

	@GetMapping("/entityData")
	public String printEntityData() {
		return "Accessing from STUDENT-SERVICE ==> " + consumer.getEntityData();
	}
}
