package com.example.demo.cart.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.cart.model.dto.LoginDTO;
import com.example.demo.cart.model.dto.UserDTO;
import com.example.demo.cart.response.ApiResponse;
import com.example.demo.cart.service.UserService;

import jakarta.servlet.http.HttpSession;

/**
 * -------------------------------------------------------------------
 * Servlet-Path: "/auth"
 * -------------------------------------------------------------------
 * POST "/login"      登入                範例: /auth/login
 * GET  "/logout"     登出                範例: /auth/logout
 * GET  "/isLoggedIn" 判斷目前使用者是否有登入 ? 範例: /auth/isLoggedIn
 * ------------------------------------------------------------------*/

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "http://localhost:5173", allowCredentials = "true")
public class AuthController {
	@Autowired
	private UserService userService;
	
	@PostMapping("/login")
	public ResponseEntity<ApiResponse<LoginDTO>> login(@RequestBody LoginDTO loginDTO, HttpSession session) {
		// login 比對判斷
		Optional<UserDTO> optUserDTO = userService.login(loginDTO);
		if(optUserDTO.isEmpty()) {
			return ResponseEntity.status(404).body(new ApiResponse<>(404, "登入失敗", null));
		}
		UserDTO userDTO = optUserDTO.get();
		// 存入到 HttpSession 中
		session.setAttribute("userDTO", userDTO);
		return ResponseEntity.ok(new ApiResponse<>(200, "登入成功", loginDTO));
		
	}
}









