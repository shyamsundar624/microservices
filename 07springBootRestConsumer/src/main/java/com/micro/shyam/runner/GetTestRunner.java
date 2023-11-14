package com.micro.shyam.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
//@Component
public class GetTestRunner implements CommandLineRunner{

	@Override
	public void run(String... args) throws Exception {
//1 Create URL
		String url="http://localhost:9090/v1/api/book/showA";
		//2 Create Request Header
		//3 Create Request Body
		//2+3
		//4 Create RestTemplate Object
		RestTemplate template=new RestTemplate();
		//5 Make HTTP call and Get Response back
	//	ResponseEntity<String> response=template.getForEntity(url,String.class);
		ResponseEntity<String> response=template.exchange(url,HttpMethod.GET,null,String.class,101,"shyam");
		
		//6 Print Details
		System.out.println(response.getBody());
		System.out.println(response.getHeaders());
		System.out.println(response.getStatusCode().name());
		System.out.println(response.getStatusCode().value());
		
	}

}
