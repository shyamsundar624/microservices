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
public class PostTestRunner implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {
//1 Create URL 
		String url="http://localhost:9090/v1/api/book/showC";
		//2 Create Request Headers
		
		HttpHeaders headers=new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		
		//3 Create Request Body
		String body="{\"bId\": 101,\"bname\":\"Book java\",\"bauth\":\"shyam\",\"bcost\":500.45}";
		
		//2+3 combine both Body and Headers
		HttpEntity<String> requestEntity=new HttpEntity<>(body,headers);
		
		//4 Create RestTemplate Object
		RestTemplate template=new RestTemplate();
		
		//5 Make Http call and get Response back
		//ResponseEntity<String> response = template.postForEntity(url, requestEntity, String.class);
		ResponseEntity<String> response=template.exchange(url, HttpMethod.POST,requestEntity,String.class);
		//6 Print Details
		
		System.out.println(response.getBody());
		System.out.println(response.getHeaders());
		System.out.println(response.getStatusCode().name());
		System.out.println(response.getStatusCode().value());
		
	}

}
