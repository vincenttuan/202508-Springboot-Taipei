package com.example.demo.test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.cart.model.entity.Product;
import com.example.demo.cart.model.entity.User;
import com.example.demo.cart.repository.ProductRepository;
import com.example.demo.cart.repository.UserRepository;

@SpringBootTest
public class AddFavorite {
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	ProductRepository productRepository;
	
	@Test
	void add() {
		// 商品
		Product p1 = productRepository.findById(1L).get();
		Product p2 = productRepository.findById(2L).get();
		// 使用者
		User user = userRepository.findById(1L).get();
		// 使用者關注商品 -> 建立與商品之間的關聯關係
		user.getFavoriteProducts().add(p1); // 加入關注
		user.getFavoriteProducts().add(p2); // 加入關注
		// 保存
		userRepository.save(user);
		
		System.out.println("關注設定完畢!");
	}
	
}
