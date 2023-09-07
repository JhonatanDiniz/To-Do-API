package com.jhonatan.todo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jhonatan.todo.domain.Todo;
import com.jhonatan.todo.repository.TodoRepository;
import com.jhonatan.todo.service.exception.ObjectNotFound;

@Service
public class TodoService {
	
	@Autowired
	private TodoRepository repository;
	
	public List<Todo> findAll(){
		return repository.findAll();
	}
	
	public Todo findById(Long id){
		Optional<Todo> obj = repository.findById(id);
		return obj.orElseThrow(()-> new ObjectNotFound("Objeto não encontrado id: " + id));
	}

	public List<Todo> findAllOpen() {
		return repository.findAllOpen();
	}

	public List<Todo> findAllClose() {
		return repository.findByFinalizado(true);
	}

	public Todo create(Todo obj) {
		obj.setId(null);
		return repository.save(obj);
	}

	public void delete(long id) {
		findById(id);
		repository.deleteById(id);
		
	}

	public Todo update(long id, Todo obj) {
		Todo newObj = findById(id);
		updateData(newObj, obj);
		return repository.save(newObj);
	}

	private void updateData(Todo newObj, Todo obj) {
		newObj.setTitulo(obj.getTitulo());
		newObj.setDescricao(obj.getDescricao());
		newObj.setDtFinalizar(obj.getDtFinalizar());
		newObj.setFinalizado(obj.isFinalizado());
	}
}
