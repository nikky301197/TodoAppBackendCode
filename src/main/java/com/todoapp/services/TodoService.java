package com.todoapp.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.todoapp.entities.Todos;
import com.todoapp.exception.ResourceNotFoundException;

@Service
public interface TodoService {

	List<Todos> getAllTodosByUsername(String username);
	Todos updateTodo( Integer todoid , String username , Todos todo );
	void deleteTodoById( Integer id );
	Todos createTodosByUsername(String username , Todos todo);
	Todos getTodoById(Integer id ) throws ResourceNotFoundException; 
}
