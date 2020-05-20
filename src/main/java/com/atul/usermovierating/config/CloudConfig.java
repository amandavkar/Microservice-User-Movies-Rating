package com.atul.usermovierating.config;

import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import brave.sampler.Sampler;

@Configuration
@EnableDiscoveryClient
public class CloudConfig {
	
	// Create a RestTemplate Bean
	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

	@Bean
	public Sampler defaultSampler() {
	   return Sampler.ALWAYS_SAMPLE;
	}

}
