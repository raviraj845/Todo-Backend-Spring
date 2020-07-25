package com.dodiya.rest.webservices.restfulwebservices;

import org.omg.CORBA.PRIVATE_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.dodiya.rest.webservices.restfulwebservices.todo.TodoJpaRepository;
@Configuration
@SpringBootApplication
public class RestfulWebServicesApplication {
	
	

	public static void main(String[] args) {
		SpringApplication.run(RestfulWebServicesApplication.class, args);
		
		
	
	

	}
}
