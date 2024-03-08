package com.todoapp.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todoapp.entities.Todos;
import com.todoapp.entities.User;
import com.todoapp.exception.ResourceNotFoundException;
import com.todoapp.repositories.TodosRepo;
import com.todoapp.repositories.UserRepo;
import com.todoapp.services.TodoService;

@Service
public class TodoServiceImpl implements TodoService {

	@Autowired
	TodosRepo todosrepo;
	@Autowired
	UserRepo userrepo;

	@Override
	public List<Todos> getAllTodosByUsername(String username) {

		User user = userrepo.findByUsername(username).get();

		return todosrepo.findByUser(user);

	}

	@Override
	public Todos updateTodo(Integer todoid, String username, Todos todo) {
		// TODO Auto-generated method stubs
		User user = userrepo.findByUsername(username).get();
		Todos foundtodo = todosrepo.findById(todoid).get();
		foundtodo.setDescription(todo.getDescription());
		foundtodo.setStatus(todo.getStatus());
		foundtodo.setTargetDate(todo.getTargetDate());
		foundtodo.setUser(user);
		todosrepo.save(foundtodo);
		return foundtodo;
	}

	@Override
	public void deleteTodoById(Integer todoid) {
		// TODO Auto-generated method stub
		todosrepo.deleteById(todoid);

	}

	@Override
	public Todos createTodosByUsername(String username, Todos todo) {
		User user = userrepo.findByUsername(username).get();
		todo.setUser(user);
		return todosrepo.save(todo);

	}

	@Override
	public Todos getTodoById(Integer id) throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		Todos foundtodo = todosrepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("To do is not present with to do id :" + id));
		return foundtodo;

	}

}
