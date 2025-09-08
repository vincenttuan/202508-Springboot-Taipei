package com.example.todolist.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.example.todolist.model.dto.TodoDTO;
import com.example.todolist.model.entity.Todo;

@Configuration
public class ModelMapperConfig {
	
	@Bean // 由 Spring 來管理此物件
	//@Scope("singleton") // 單一實體(預設)
	//@Scope("prototype") // 多實體
	ModelMapper modelMapper() {
		ModelMapper modelMapper = new ModelMapper();
		
		// 自訂 Todo -> TodoDTO 欄位映射 
		modelMapper.typeMap(Todo.class, TodoDTO.class)
				   .addMappings(mapper -> {
					   mapper.map(Todo::getMessage, TodoDTO::setText);
					   mapper.map(Todo::getFinished, TodoDTO::setCompleted);
				   });
		
		// 自訂 TodoDTO -> Todo 欄位映射
		modelMapper.typeMap(TodoDTO.class, Todo.class)		   
				   .addMappings(mapper -> {
					   mapper.map(TodoDTO::getText, Todo::setMessage);
					   mapper.map(TodoDTO::getCompleted, Todo::setFinished);
				   });
		
		return modelMapper;
	}
	
}
