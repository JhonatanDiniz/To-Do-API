package com.jhonatan.todo.resource.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.jhonatan.todo.service.exception.ObjectNotFound;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ResourceExceptionHandler {
	

	@ExceptionHandler(ObjectNotFound.class)
	public ResponseEntity<StandardError> notFound(ObjectNotFound e, HttpServletRequest request){
		long instant = System.currentTimeMillis();
		Integer status = HttpStatus.NOT_FOUND.value();
		String message = e.getMessage();
		String path = request.getRequestURI();
		
		StandardError erro = new StandardError(instant, status, message, path);
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
	}

}
