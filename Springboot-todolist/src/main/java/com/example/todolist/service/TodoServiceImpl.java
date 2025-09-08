package com.example.todolist.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.todolist.exception.TodoNotFoundException;
import com.example.todolist.model.dto.TodoDTO;
import com.example.todolist.model.entity.Todo;
import com.example.todolist.repository.TodoRepository;

@Service
public class TodoServiceImpl implements TodoService {
	
	@Autowired
	private TodoRepository todoRepository;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public List<TodoDTO> findAllTodos() {
		List<Todo> todos = todoRepository.findAll();
		List<TodoDTO> todoDTOs = todos.stream()
									  .map(todo -> modelMapper.map(todo, TodoDTO.class))
									  .toList();
		return todoDTOs;
	}

	@Override
	public TodoDTO addTodo(TodoDTO todoDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TodoDTO uptTodo(TodoDTO todoDTO) throws TodoNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delTodo(TodoDTO todoDTO) throws TodoNotFoundException {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
