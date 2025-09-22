package com.example.demo.test;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.cart.model.entity.Order;
import com.example.demo.cart.model.entity.OrderItem;
import com.example.demo.cart.model.entity.Product;
import com.example.demo.cart.model.entity.User;
import com.example.demo.cart.repository.OrderItemRepository;
import com.example.demo.cart.repository.OrderRepository;
import com.example.demo.cart.repository.ProductRepository;
import com.example.demo.cart.repository.UserRepository;

@SpringBootTest
public class AddOrderTest {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private OrderItemRepository orderItemRepository;
	
	@Test
	public void add() {
		// 建立一筆訂單 user.id=1 買 product.id=1 與 product.id=2
		// 建立一筆訂單 admin 買 青森蘋果 與 banana
		
		// 1.取得 admin 使用者
		User user = userRepository.findById(1L).get();
		// 2.1 取得 青森蘋果
		Product apple = productRepository.findById(1L).get();
		// 2.2 取得 Banana
		Product banana = productRepository.findById(2L).get();
		
		// 3.建立 order
		Order order = new Order();
		
		// 4.建立 order_item
		OrderItem item1 = new OrderItem();
		OrderItem item2 = new OrderItem();
		
		// 5.配置資料
		// 訂單主檔 
		order.setUser(user); // 配置使用者
				
		// 訂單細目
		item1.setOrder(order);
		item1.setProduct(apple);
		item1.setQty(10);
		
		item2.setOrder(order);
		item2.setProduct(banana);
		item2.setQty(20);
		
		// 儲存
		orderRepository.save(order);
		
		System.out.println("Order add OK");
	}
	
}
