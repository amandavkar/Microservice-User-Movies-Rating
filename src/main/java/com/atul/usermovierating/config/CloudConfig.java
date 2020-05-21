package com.atul.usermovierating.config;

import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
@EnableDiscoveryClient
public class CloudConfig {
	
	// Create a RestTemplate Bean
	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

}
