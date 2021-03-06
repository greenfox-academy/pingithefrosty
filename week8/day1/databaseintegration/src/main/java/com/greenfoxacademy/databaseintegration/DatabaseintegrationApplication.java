package com.greenfoxacademy.databaseintegration;

import com.greenfoxacademy.databaseintegration.models.Todo;
import com.greenfoxacademy.databaseintegration.repositories.TodoRepository;
import javafx.application.Application;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class DatabaseintegrationApplication {

	private static final org.slf4j.Logger log = LoggerFactory.getLogger(Application.class);

	public static void main(String[] args) {
		SpringApplication.run(DatabaseintegrationApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(TodoRepository todoRepository) {
		return (String... args) -> {
			todoRepository.save(new Todo("Finish the first exercise"));
			todoRepository.save(new Todo("Learn stuff"));
			todoRepository.save(new Todo("Understand things"));
			todoRepository.save(new Todo("What?"));

			log.info("Found with findAll():");
			log.info("------------------");
			for (Todo todo : todoRepository.findAll()) {
				log.info(todo.toString());
			}
			log.info("");
		};
	}
}
