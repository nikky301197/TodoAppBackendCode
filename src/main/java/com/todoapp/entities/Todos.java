package com.todoapp.entities;

import java.util.Date;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Todos {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Integer todoId ;
	String description ;
	String status ;
	
	Date   targetDate;
	
	@ManyToOne
	User user ;
}
