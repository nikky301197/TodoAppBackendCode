package com.todoapp.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.todoapp.entities.Todos;
import com.todoapp.entities.User;


@Repository
public interface TodosRepo extends JpaRepository<Todos, Integer>{

	List<Todos> findByUser(User user);
}
