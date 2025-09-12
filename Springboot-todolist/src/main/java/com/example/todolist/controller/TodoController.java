package com.example.todolist.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.todolist.model.dto.TodoDTO;
import com.example.todolist.response.ApiResponse;
import com.example.todolist.service.TodoService;

/**
 * Rest API
 * ------------------------------------
 * Method | URI     | Message
 * ------------------------------------
 * GET    | "/"     | 取得所有代辦事項
 * POST   | "/"     | 新增代辦事項
 * PUT    | "/{id}" | 修改代辦事項
 * DELETE | "/{id}" | 刪除代辦事項
 * ------------------------------------
 * */

@RestController
@RequestMapping("/todolist")
@CrossOrigin(origins = "http://localhost:5173") // 設定跨域請求
public class TodoController {
	
	@Autowired
	private TodoService todoService;
	
	@GetMapping(value = "/", produces = "application/json;charset=utf-8")
	public ApiResponse<List<TodoDTO>> findAll() {
		List<TodoDTO> todoDTOs = todoService.findAllTodos();
		return new ApiResponse<List<TodoDTO>>(true, "查詢成功", todoDTOs);
	}
	
	@PostMapping(value = "/", produces = "application/json;charset=utf-8")
	public ApiResponse<TodoDTO> addTodo(@RequestBody TodoDTO todoDTO) {
		todoDTO = todoService.addTodo(todoDTO);
		return new ApiResponse<TodoDTO>(true, "新增成功", todoDTO);
	}
	
	
	
	
	
	
	
}
