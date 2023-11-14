package com.micro.shyam.consumer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class CartRestConsumer {

	@Autowired
	private DiscoveryClient client;

	public String getCartInfo() {
		List<ServiceInstance> siList = client.getInstances("CART-SERVICE");

		ServiceInstance si = siList.get(0);
		String url = si.getUri() + "cart/getData";
		RestTemplate rt = new RestTemplate();
		String response = rt.getForObject(url, String.class);
		
		return response;
		
	}
}
