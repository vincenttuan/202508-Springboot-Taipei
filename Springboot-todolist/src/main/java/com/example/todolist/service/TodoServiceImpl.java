package com.example.todolist.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.todolist.repository.TodoRepository;

@Service
public class TodoServiceImpl {
	
	@Autowired
	private TodoRepository todoRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	
	
}
