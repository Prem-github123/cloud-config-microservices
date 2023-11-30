package com.movie;

import java.util.Arrays;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RequestMapping("/movie")
public class MovieMicroserviceApplication {
	
	@GetMapping("/getAll")
	public List<String> getAllUsers() {
		List<String> names = Arrays.asList("Leo", "The Lion King", "Titanic","Suicide Squad");
		return names;
	}

	public static void main(String[] args) {
		SpringApplication.run(MovieMicroserviceApplication.class, args);
	}

}
