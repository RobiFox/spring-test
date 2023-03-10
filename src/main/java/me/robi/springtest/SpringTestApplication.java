package me.robi.springtest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SpringTestApplication {
	public static void main(String[] args) {
		SpringApplication.run(SpringTestApplication.class, args);
	}

	@GetMapping("/")
	public String index() {
		return "<h1>hi</h1>";
	}
}
