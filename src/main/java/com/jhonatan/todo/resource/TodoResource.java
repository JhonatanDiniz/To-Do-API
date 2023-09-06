package com.jhonatan.todo.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jhonatan.todo.domain.Todo;
import com.jhonatan.todo.service.TodoService;

@RestController
@RequestMapping(value = "/todo")
public class TodoResource {
	
	@Autowired
	private TodoService service;
	
	@GetMapping
	public ResponseEntity<List<Todo>> findAll(){
		List<Todo> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Todo> findById(@PathVariable long id){
		Todo obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@GetMapping(value = "/open")
	public ResponseEntity<List<Todo>> findAllOpen(){
		List<Todo> list = service.findAllOpen();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/close")
	public ResponseEntity<List<Todo>> findAllClose(){
		List<Todo> list = service.findAllClose();
		return ResponseEntity.ok().body(list);
	}
	
	

}