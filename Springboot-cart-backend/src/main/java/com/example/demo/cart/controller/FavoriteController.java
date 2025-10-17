package com.example.demo.cart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.cart.aop.CheckUserSession;
import com.example.demo.cart.model.dto.FavoriteProductDTO;
import com.example.demo.cart.model.dto.UserDTO;
import com.example.demo.cart.response.ApiResponse;
import com.example.demo.cart.service.UserService;

import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/favorites")
@CrossOrigin(origins = "http://localhost:5173", allowCredentials = "true")
public class FavoriteController {
	
	@Autowired
	private UserService userService;
	
	// 獲取用戶關注清單
	@GetMapping
	@CheckUserSession
	public ResponseEntity<ApiResponse<List<FavoriteProductDTO>>> getFavoriteProducts(HttpSession session) {
		Long userId = ((UserDTO)session.getAttribute("userDTO")).getId();
		List<FavoriteProductDTO> favoriteProductDTOs = userService.getFavoriteProducts(userId);
		return ResponseEntity.ok(new ApiResponse<>(200, "獲取用戶關注清單", favoriteProductDTOs));
	}
	
	// 獲取商品被那些用戶關注清單
	
	// 加入關注
	
	// 取消關注
	
	
}
