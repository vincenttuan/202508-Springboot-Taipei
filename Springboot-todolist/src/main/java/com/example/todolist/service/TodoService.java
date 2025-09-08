package com.example.todolist.service;

import java.util.List;

import com.example.todolist.exception.TodoNotFoundException;
import com.example.todolist.model.dto.TodoDTO;

public interface TodoService {
	
	// 取得所有代辦事項
	public List<TodoDTO> findAllTodos();
	
	// 新增代辦事項
	public TodoDTO addTodo(TodoDTO todoDTO);
	
	// 修改代辦事項
	public TodoDTO uptTodo(TodoDTO todoDTO) throws TodoNotFoundException;
	
	// 刪除代辦事項
	public void delTodo(TodoDTO todoDTO) throws TodoNotFoundException;
	
}
