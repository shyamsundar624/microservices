package com.micro.shyam.rest;

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

import com.micro.shyam.entity.Student;
import com.micro.shyam.exception.StudentNotFoundException;
import com.micro.shyam.service.IStudentService;

@RestController
@RequestMapping("/v1/api/student")
public class StudentRestController {
	@Autowired
	private IStudentService service;

	@PostMapping("/create")
	public ResponseEntity<String> createStudent(@RequestBody Student student) {
		Integer id = service.saveStudent(student);
		String msg = "STUDENT '" + id + "' CREATED";
		return new ResponseEntity<String>(msg, HttpStatus.CREATED);
	}

	@GetMapping("/all")
	public ResponseEntity<List<Student>> getAllStudent() {
		List<Student> list = service.getAllStudent();
		return ResponseEntity.ok(list);
	}

	@GetMapping("/find/{id}")
	public ResponseEntity<Student> getOneStuEntity(@PathVariable("id") Integer id) {
		ResponseEntity<Student> response = null;
		try {
			Student student = service.getStudent(id);
			response = ResponseEntity.ok(student);
		} catch (StudentNotFoundException e) {
			e.printStackTrace();
			throw e;
		}
		return response;
	}
 
	@DeleteMapping("/remove/{id}")
	public ResponseEntity<String> deleteStudent(@PathVariable("id") Integer id) {
		ResponseEntity<String> response = null;
		try {
			service.deleteStudent(id);
			response = ResponseEntity.ok("STUDENT '" + id + "' REMOVED");
		} catch (StudentNotFoundException e) {
			e.printStackTrace();
			throw e;
		}
		return response;
	}
@PutMapping("/update")
	public ResponseEntity<String> updateStudent(@RequestBody Student student) {
		ResponseEntity<String> response = null;
		try {
			service.updateStudent(student);
			response = ResponseEntity.ok("STUDENT '" + student.getStdId() + "' UPDATED");
		} catch (StudentNotFoundException e) {
			e.printStackTrace();
			throw e;
		}
		return response;
	}

}
