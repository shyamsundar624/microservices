package com.micro.shyam.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

//@Component
public class PutTestRunner implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {
		//1 Create url
		String url = "http://localhost:9090/v1/api/book/showD";

		//2 Create Header
		HttpHeaders headers=new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		
		// 3 Create Request Body
		String body = "{\"bId\": 101,\"bname\":\"Book java\",\"bauth\":\"shyam\",\"bcost\":500.45}";
		
		//4 Create HttpEntity
		HttpEntity<String> requestEntity=new HttpEntity<String>(body,headers);
		
		//5 Create RestTemplate
		RestTemplate template=new RestTemplate();
		ResponseEntity<String> entity = template.exchange(url,HttpMethod.PUT,requestEntity,String.class);
		
		System.out.println(entity.getBody());
		System.out.println(entity.getHeaders());
		System.out.println(entity.getStatusCode().value());
		System.out.println(entity.getStatusCode().name());
		
	}

}
