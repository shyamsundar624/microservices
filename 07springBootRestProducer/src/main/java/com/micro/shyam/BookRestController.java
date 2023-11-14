package com.micro.shyam;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.micro.shyam.entity.Book;

@RestController
@RequestMapping("/v1/api/book")
public class BookRestController {

	@GetMapping("showA")
	public ResponseEntity<String> showMsg1() {
		return ResponseEntity.ok("Welcome to First Call Type");
	}

	@GetMapping("showB/{id}/{name}")
	public ResponseEntity<String> showMsg2(@PathVariable("id") Integer id, @PathVariable("name") String name) {
		return ResponseEntity.ok("Welcome to First get call " + id + " - " + name);
	}

	@PostMapping("/showC")
	public ResponseEntity<String> showMsg3(@RequestBody Book book ){
		return ResponseEntity.ok("Data is Given is "+book);
	}
	
	@PutMapping("/showD")
	public ResponseEntity<String> showMsg4(@RequestBody Book book){
		return ResponseEntity.ok("Data From Put is "+book);
	}
	
	@DeleteMapping("showF/{id}")
	public ResponseEntity<String> showMsg5(@PathVariable("id") Integer id){
		return ResponseEntity.ok("Delete Mapping"+id);
	}
}
