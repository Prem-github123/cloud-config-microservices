package com.movie.client;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@RestController
@RefreshScope
public class MovieClientMicroserviceApplication {
	
	@Autowired
	@Lazy
	RestTemplate restTemplate;
	
	@Value("${movie.url}")
	String movieUrl;
	
	@GetMapping("/getAllMovies")
	public List<String> get(){
		List<String> list=restTemplate.getForObject(movieUrl, List.class);
		return list;
	}

	public static void main(String[] args) {
		SpringApplication.run(MovieClientMicroserviceApplication.class, args);
	}
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

}
