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
	
	/**
	 * 2. ?帶參數
	 * 路徑:/greet?name=John&age=18
	 * 路徑:/greet?name=Mary
	 * 網址:http://localhost:8080/api/greet?name=John&age=18
	 * 網址:http://localhost:8080/api/greet?name=Mary
	 * 限制:name 參數是一定要有的
	 *     age 參數是可選的(若沒有 age 參數則會有初始值 0)
	 * */
	
	
	
	
}
