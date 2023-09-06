package com.jhonatan.todo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.jhonatan.todo.domain.Todo;

public interface TodoRepository extends JpaRepository<Todo, Long>{

	@Query("SELECT obj FROM Todo obj WHERE obj.finalizado = false")
	List<Todo> findAllOpen();

	List<Todo> findByFinalizado(boolean finalizado);

}
