package com.micro.shyam.rest;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.micro.shyam.entity.Student;
import com.micro.shyam.service.IStudentService;

@RestController
@RequestMapping("/v1/api/student")
public class StudentRestController {
	@Autowired
	private IStudentService service;
	@PostMapping("/save")
	public ResponseEntity<String> saveStudent(@RequestBody @Valid Student student){
		Integer id = service.saveStudent(student);
		return new ResponseEntity<String>("STUDENT '"+id+"' CREATED",HttpStatus.CREATED);
	}
}
