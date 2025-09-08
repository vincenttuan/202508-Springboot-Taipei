package com.example.todolist.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class ModelMapperConfig {
	
	@Bean // 由 Spring 來管理此物件
	//@Scope("singleton") // 單一實體(預設)
	//@Scope("prototype") // 多實體
	ModelMapper modelMapper() {
		return new ModelMapper();
	}
	
}
