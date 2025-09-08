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
	
	// 取得所有代辦事項
	@Override
	public List<TodoDTO> findAllTodos() {
		List<Todo> todos = todoRepository.findAll();
		List<TodoDTO> todoDTOs = todos.stream()
									  .map(todo -> modelMapper.map(todo, TodoDTO.class))
									  .toList();
		return todoDTOs;
	}
	
	// 新增代辦事項
	@Override
	public TodoDTO addTodo(TodoDTO todoDTO) {
		// 將 TodoDTO 轉 Todo (dto 轉 entity)
		Todo todo = modelMapper.map(todoDTO, Todo.class);
		// 儲存
		Todo savedTodo = todoRepository.save(todo);
		// 回報結果
		todoDTO = modelMapper.map(savedTodo, TodoDTO.class);
		return todoDTO;
	}
	
	// 修改代辦事項
	@Override
	public TodoDTO uptTodo(TodoDTO todoDTO) throws TodoNotFoundException {
		return todoRepository.findById(todoDTO.getId())
							 .map(todo -> {
								 modelMapper.map(todoDTO, todo); // 更新欄位訊息
								 // 儲存更新
								 Todo uptTodo = todoRepository.save(todo);
								 // 回報
								 return modelMapper.map(uptTodo, TodoDTO.class);
							 })
							 .orElseThrow(() -> new TodoNotFoundException("查無資料"));
	}
	
	// 刪除代辦事項
	@Override
	public void delTodo(Long id) throws TodoNotFoundException {
		// 確認是否有此筆資料
		if(todoRepository.existsById(id)) {
			todoRepository.deleteById(id);
			return;
		}
		// 拋出例外
		throw new TodoNotFoundException("查無資料");
	}
	
	
	
}
