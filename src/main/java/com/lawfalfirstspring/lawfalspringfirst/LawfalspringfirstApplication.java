package com.lawfalfirstspring.lawfalspringfirst;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;


@SpringBootApplication
public class LawfalspringfirstApplication {

	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(LawfalspringfirstApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(LawfalspringfirstApplication.class, args);
	}

}
