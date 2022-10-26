package com.jpa.course1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.jpa.course1.security.AppProperties;

@SpringBootApplication
public class CourseProject1Application {

	public static void main(String[] args) {
		SpringApplication.run(CourseProject1Application.class, args);
	}

	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public SpringApplicationContext springApplicationContext() {
		return new SpringApplicationContext();
	}

	@Bean(name="ApplicationProperties")
	public AppProperties getAppProperties() {
		return new AppProperties();
	}
}
