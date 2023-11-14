package com.micro.shyam.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
@Component
public class DeleteTestRunner implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {

		//1 Create URL
	    String url="http://localhost:9090/v1/api/book/showF/{id}";
	    
	    RestTemplate template=new RestTemplate();
	    ResponseEntity<String> res = template.exchange(url, HttpMethod.DELETE,null,String.class,101);
	    System.out.println(res.getBody());
	    System.out.println(res.getHeaders());
	    System.out.println(res.getStatusCode().name());
	    System.out.println(res.getStatusCode().value());
	}

}
