package com.example.todolist.exception;

// 找不到代辦事項資料
public class TodoNotFoundException extends Exception {
	public TodoNotFoundException(String message) {
		super(message);
	}
}
