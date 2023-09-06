package com.jhonatan.todo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jhonatan.todo.domain.Todo;

public interface TodoRepository extends JpaRepository<Todo, Long>{

}
