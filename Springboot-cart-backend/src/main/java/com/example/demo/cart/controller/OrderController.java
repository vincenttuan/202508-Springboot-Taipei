package com.example.demo.cart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.cart.model.dto.LoginDTO;
import com.example.demo.cart.model.dto.OrderDTO;
import com.example.demo.cart.model.dto.UserDTO;
import com.example.demo.cart.response.ApiResponse;
import com.example.demo.cart.service.OrderService;

import jakarta.servlet.http.HttpSession;

/**
 * -------------------------------------------------------------------
 * Servlet-Path: "/orders"
 * -------------------------------------------------------------------
 * GET  "/"         查詢該用戶(已登入)的所有商品(多筆) 範例: /orders/
 * POST "/checkout" 該用戶(已登入)進行結帳          範例: /checkout
*/
@RestController
@RequestMapping("/orders")
@CrossOrigin(origins = "http://localhost:5173", allowCredentials = "true")
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	@GetMapping(value = {"", "/"})
	public ResponseEntity<ApiResponse<List<OrderDTO>>> getAllOrders(HttpSession session) {
		if(session.getAttribute("userDTO") == null) {
			return ResponseEntity.status(404).body(new ApiResponse<>(404, "無登入資料", null));
		}
		UserDTO userDTO = (UserDTO)session.getAttribute("userDTO");
		List<OrderDTO> orderDTOs = orderService.findOrdersByUserId(userDTO.getId());
		return ResponseEntity.ok(new ApiResponse<>(200, "查詢成功", orderDTOs));
	}

}
