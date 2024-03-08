package com.todoapp.services;

import org.springframework.stereotype.Service;

import com.todoapp.entities.User;
import com.todoapp.exception.ResourceAlreadyExistException;
import com.todoapp.exception.ResourceNotFoundException;

@Service
public interface UserService {

	Boolean getUser(User user) throws ResourceNotFoundException;
	User createUser(User user) throws ResourceAlreadyExistException;
}
