package com.example.demo.test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.cart.model.entity.User;
import com.example.demo.cart.repository.UserRepository;

@SpringBootTest
public class AddUserTest {
	
	@Autowired
	UserRepository userRepository;
	
	@Test
	void add() {
		User user1 = new User();
		user1.setUsername("admin");
		user1.setPassword("1234");
		// 儲存
		userRepository.save(user1);
		
		User user2 = new User();
		user2.setUsername("mary");
		user2.setPassword("5678");
		// 儲存
		userRepository.save(user2);
		
		
	}
	
}
