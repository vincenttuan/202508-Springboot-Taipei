package com.example.demo.cart.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.cart.aop.CheckUserSession;
import com.example.demo.cart.model.dto.LoginDTO;
import com.example.demo.cart.model.dto.OrderDTO;
import com.example.demo.cart.model.dto.OrderItemDTO;
import com.example.demo.cart.model.dto.UserDTO;
import com.example.demo.cart.response.ApiResponse;
import com.example.demo.cart.service.OrderService;

import jakarta.servlet.http.HttpSession;

/**
 * -------------------------------------------------------------------
 * Servlet-Path: "/orders"
 * -------------------------------------------------------------------
 * GET  "/"         查詢該用戶(已登入)的所有訂單(多筆) 範例: /orders/
 * POST "/checkout" 該用戶(已登入)進行結帳          範例: /checkout
*/
@RestController
@RequestMapping("/orders")
@CrossOrigin(origins = {"http://localhost:5173", "http://localhost"}, allowCredentials = "true")
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	@GetMapping(value = {"", "/"})
	@CheckUserSession
	public ResponseEntity<ApiResponse<List<OrderDTO>>> getAllOrders(HttpSession session) {
		UserDTO userDTO = (UserDTO)session.getAttribute("userDTO");
		List<OrderDTO> orderDTOs = orderService.findOrdersByUserId(userDTO.getId());
		return ResponseEntity.ok(new ApiResponse<>(200, "查詢成功", orderDTOs));
	}
	
	@PostMapping("/checkout")
	@CheckUserSession
	public ResponseEntity<ApiResponse<OrderDTO>> createOrder(@RequestBody List<OrderItemDTO> items, HttpSession session) {
		UserDTO userDTO = (UserDTO)session.getAttribute("userDTO");
		Optional<OrderDTO> optOrderDTO = orderService.saveOrder(userDTO.getId(), items);
		if(optOrderDTO.isEmpty()) {
			return ResponseEntity.status(400).body(new ApiResponse<>(400, "訂單結帳錯誤", null));
		}
		return ResponseEntity.ok(new ApiResponse<>(200, "結帳成功", optOrderDTO.get()));
	}

}
