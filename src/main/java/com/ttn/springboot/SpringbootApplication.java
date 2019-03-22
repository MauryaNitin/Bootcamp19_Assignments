package com.ttn.springboot;

import com.ttn.springboot.entity.Database;
import com.ttn.springboot.entity.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * Ques 3: Create Bean User containing two field username and password with Spring Context File
 *
 * Ques 4: Create a Bean Database with two fields port and name and Access its values using application.properties
 */

@SpringBootApplication
public class SpringbootApplication {

	@Bean
	User createUser(){
		return new User();
	}

	@Bean
	Database createDatabase(){
		return new Database();
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringbootApplication.class, args);
	}
}
