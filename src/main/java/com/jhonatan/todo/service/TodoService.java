package com.jhonatan.todo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jhonatan.todo.domain.Todo;
import com.jhonatan.todo.repository.TodoRepository;

@Service
public class TodoService {
	
	@Autowired
	private TodoRepository repository;
	
	public List<Todo> findAll(){
		return repository.findAll();
	}
	
	public Todo findById(Long id){
		Optional<Todo> obj = repository.findById(id);
		return obj.orElse(null);
	}

	public List<Todo> findAllOpen() {
		return repository.findAllOpen();
	}

	public List<Todo> findAllClose() {
		return repository.findByFinalizado(true);
	}
}
