package com.example.demo.cart.service.impl;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.cart.exception.UserNotFoundException;
import com.example.demo.cart.model.dto.OrderDTO;
import com.example.demo.cart.model.dto.OrderItemDTO;
import com.example.demo.cart.model.entity.Order;
import com.example.demo.cart.model.entity.OrderItem;
import com.example.demo.cart.model.entity.User;
import com.example.demo.cart.repository.OrderItemRepository;
import com.example.demo.cart.repository.OrderRepository;
import com.example.demo.cart.repository.ProductRepository;
import com.example.demo.cart.repository.UserRepository;
import com.example.demo.cart.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private OrderItemRepository orderItemRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public List<OrderDTO> findOrdersByUserId(Long userId) {
		return orderRepository.findByUserId(userId).stream() // ... order
				.map(order -> modelMapper.map(order, OrderDTO.class)) // ... orderDTO
				.toList(); 
	}

	@Override
	public Optional<OrderDTO> saveOrder(Long userId, List<OrderItemDTO> items) {
		// 1. 取得 user
		User user = userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException("查無使用者"));
		
		// 2. 建立訂單 
		Order order = new Order();
		order.setUser(user); // 設定訂單與用戶的關聯
		
		// 3. 建立訂單明細列表
		List<OrderItem> orderItems = items.stream()
				.map(item -> {
					OrderItem orderItem = modelMapper.map(item, OrderItem.class);
					orderItem.setOrder(order); // 設定 item 與 order 的關係
					return orderItem;
				})
				.toList();
		
		// 4. 設定 order 與 orderItems 的關係
		order.setOrderItems(orderItems);
		
		// 5. 保存
		order = orderRepository.save(order);
		
		OrderDTO orderDTO = modelMapper.map(order, OrderDTO.class); 
		return Optional.of(orderDTO);
	}

}
