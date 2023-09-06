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
		
		Todo todo1 = new Todo(null, "Estudar", "Estudar Spring Boot", LocalDateTime.parse("10/09/2023 07:30", format), false);
		Todo todo2 = new Todo(null, "Trabalhar", "Trabalhar no projeto Todo", LocalDateTime.parse("25/09/2023 07:30", format), false);
		Todo todo3 = new Todo(null, "Lazer", "Descansar no feriado", LocalDateTime.parse("12/10/2023 07:30", format), false);
		Todo todo4 = new Todo(null, "Malhar", "Praticar algum exercicio", LocalDateTime.parse("05/09/2023 07:30", format), true);
		Todo todo5 = new Todo(null, "Meditar", "Meditar na LBV", LocalDateTime.parse("05/09/2023 07:30", format), true);
		
		repository.saveAll(Arrays.asList(todo1, todo2, todo3, todo4, todo5));
	}

}
