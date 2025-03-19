package com.interbox.interbox_be;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class InterboxBeApplication {

	public static void main(String[] args) {
		SpringApplication.run(InterboxBeApplication.class, args);
	}

}
