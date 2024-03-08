package com.todoapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.todoapp.entities.Todos;
import com.todoapp.exception.ResourceNotFoundException;
import com.todoapp.services.TodoService;

@RestController
@RequestMapping("/todoapi/v1")
public class TodosController {

	@Autowired
	TodoService todoservice;

	@GetMapping("/user/{username}/todos")
	ResponseEntity< List<Todos> > getAllTodosByUsername(@PathVariable String username) {
		return  new ResponseEntity<List<Todos>> (
				todoservice.getAllTodosByUsername(username),HttpStatus.OK );
	}

	@GetMapping("/todos/{todoid}")
	ResponseEntity<Todos> getTodoById(@PathVariable Integer todoid) throws ResourceNotFoundException {
		return new ResponseEntity<Todos>(todoservice.getTodoById(todoid), HttpStatus.OK);
	}

	@PostMapping("/user/{username}/todos")
	ResponseEntity<Todos> createTodosByUsername(@PathVariable String username, @RequestBody Todos todo) {
		return new ResponseEntity<Todos>
		(todoservice.createTodosByUsername(username, todo), HttpStatus.CREATED);
	}

	@DeleteMapping("/todos/{todoid}")
	ResponseEntity<Void> deleteTodoById(@PathVariable Integer todoid) {
		todoservice.deleteTodoById(todoid);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PutMapping("/user/{username}/todos/{todoid}")
	ResponseEntity<Todos> updateTodoById(@PathVariable Integer todoid, @PathVariable String username,
			@RequestBody Todos todo) {
		return new ResponseEntity<Todos>(todoservice.updateTodo(todoid, username, todo), HttpStatus.OK);

	}

}
