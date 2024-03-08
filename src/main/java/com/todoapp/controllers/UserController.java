package com.todoapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.todoapp.entities.User;
import com.todoapp.exception.ResourceAlreadyExistException;
import com.todoapp.exception.ResourceNotFoundException;
import com.todoapp.services.UserService;

@RestController
@RequestMapping("/todoapi/v1")
public class UserController {

	@Autowired
	UserService userservice;

	@PutMapping("/")
	ResponseEntity<Boolean> verifyUserCredentials (@RequestBody User user) throws ResourceNotFoundException {
		return new ResponseEntity<>(userservice.getUser(user), HttpStatus.OK);

	}
	
	@PostMapping("/")
	ResponseEntity<User> createUser(@RequestBody User user) throws ResourceAlreadyExistException
	{
		User result  = userservice.createUser(user);
		return new ResponseEntity<User>(result , HttpStatus.CREATED);
		
		
	}

}
