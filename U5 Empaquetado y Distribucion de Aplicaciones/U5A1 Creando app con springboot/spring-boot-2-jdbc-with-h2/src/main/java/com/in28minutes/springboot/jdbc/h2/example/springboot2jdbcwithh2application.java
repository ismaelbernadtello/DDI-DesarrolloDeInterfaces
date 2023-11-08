package com.in28minutes.springboot.jdbc.h2.example;

import com.in28minutes.springboot.jdbc.h2.example.student.student;
import com.in28minutes.springboot.jdbc.h2.example.student.studentJdbcRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class springboot2jdbcwithh2application implements CommandLineRunner {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    studentJdbcRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(springboot2jdbcwithh2application.class, args);
    }

    @Override
    public void run(String... args) {

        logger.info("Student id 10001 -> {}", repository.findById(10001L));
        logger.info("all users 1 -> {}", repository.findAll());
        logger.info("inserting -> {}", repository.insert(new student(10010, "john", "a1234657")));
        logger.info("update 10001 -> {}", repository.update(new student(10001, "name-updated", "new-passport")));
        repository.deleteById(10002);
        logger.info("all users 2 -> {}", repository.findAll());
    }
}