package com.example.demo.cart.exception;

// 自訂例外
public class ProductNotFoundException extends RuntimeException {
	public ProductNotFoundException(String message) {
		super(message);
	}
}
