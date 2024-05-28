package com.black.bl.configuration;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.black.bl.model.Student;
import com.black.bl.repository.StudentRepository;

@Configuration
public class StudentConfiguration {
	
	@Bean
	CommandLineRunner commandLineRunner(StudentRepository repo) {
		return args ->{
	        Student jean = new Student(1L, "Jean", "Dupont");
	        Student marie = new Student(2L, "Marie", "Durand");
	        repo.saveAll(List.of(jean, marie));
		};
	}
}
