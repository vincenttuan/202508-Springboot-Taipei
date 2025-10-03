package com.example.demo.cart.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.cart.model.dto.OrderDTO;
import com.example.demo.cart.model.dto.OrderItemDTO;

public interface OrderService {
	// 根據用戶 id 取得訂購資料
	List<OrderDTO> findOrdersByUserId(Long userId);
	
	// 新增訂購單
	Optional<OrderDTO> saveOrder(Long userId, List<OrderItemDTO> items);
	
}
