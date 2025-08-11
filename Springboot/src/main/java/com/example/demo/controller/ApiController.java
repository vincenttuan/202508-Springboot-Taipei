package com.example.demo.controller;

import java.util.Date;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// 了解各種不同 URL 與參數的傳遞與接收
@RestController
@RequestMapping("/api")
public class ApiController {
	
	/**
	 * 1. 歡迎頁
	 * 路徑:/hello
	 * 路徑:/home
	 * 路徑:/welcome
	 * 網址:http://localhost:8080/api/hello
	 * 網址:http://localhost:8080/api/home
	 * 網址:http://localhost:8080/api/welcome
	 * */
	//@GetMapping("/hello")
	@GetMapping(value = {"/hello", "/home", "/welcome"})
	public String hello() {
		return "Hello Spring " + new Date();
	}
	
	
	
}
