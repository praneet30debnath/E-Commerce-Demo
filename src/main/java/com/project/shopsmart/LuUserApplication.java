package com.project.shopsmart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class LuUserApplication {

	public static void main(String[] args) {
		SpringApplication.run(LuUserApplication.class, args);
	}
}
