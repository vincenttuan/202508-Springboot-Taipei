package com.example.demo.cart.exception;

// 自訂例外
public class UserNotFoundException extends RuntimeException {
	public UserNotFoundException(String message) {
		super(message);
	}
}
