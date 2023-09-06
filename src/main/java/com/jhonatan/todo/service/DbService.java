package com.jhonatan.todo.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jhonatan.todo.domain.Todo;
import com.jhonatan.todo.repository.TodoRepository;

@Service
public class DbService {
	
	@Autowired
	private TodoRepository repository;
	
	public void instaciaDB() {
		DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
		
		Todo todo1 = new Todo(null, "Estudar", "Estudar Spring Boot", LocalDateTime.parse("06/09/2023 07:30", format), false);
		
		repository.saveAll(Arrays.asList(todo1));
	}

}
