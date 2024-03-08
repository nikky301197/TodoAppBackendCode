package com.todoapp.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todoapp.entities.User;
import com.todoapp.exception.ResourceAlreadyExistException;
import com.todoapp.exception.ResourceNotFoundException;
import com.todoapp.repositories.UserRepo;
import com.todoapp.services.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepo userrepo;

	@Override
	public Boolean getUser(User user) throws ResourceNotFoundException {

		String username = user.getUsername();
		User founduser = userrepo.findByUsername(username)
				.orElseThrow(() -> new ResourceNotFoundException("User not fount with user name : " + username));

		
		
		if ((user.getUsername().equals( founduser.getUsername() ) ) && (user.getPassword().equals(founduser.getPassword()))) {
			System.out.println("true");
			return true;
		}
		return false;

	}

	@Override
	public User createUser(User user) throws ResourceAlreadyExistException {
		// TODO Auto-generated method stub
	Boolean founduser  = userrepo.findByUsername(user.getUsername()).isPresent();
	
	if (!founduser)
	{
		return userrepo.save(user);
	}
	else
	{
		throw new ResourceAlreadyExistException("User is  already present with this mail id : "+user.getUsername());
	}
	
		
	}

}
