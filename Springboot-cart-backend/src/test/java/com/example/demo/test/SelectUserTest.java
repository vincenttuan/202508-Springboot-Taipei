package com.example.demo.test;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.cart.model.entity.User;
import com.example.demo.cart.repository.UserRepository;

@SpringBootTest
public class SelectUserTest {
	
	@Autowired
	UserRepository userRepository;
	
	@Test
	void select() {
		Optional<User> optUser1 = userRepository.findById(1L);
		if(optUser1.isPresent()) {
			User user = optUser1.get();
			System.out.println("user1 => " + user.getId() + "," + user.getUsername() + "," + user.getPassword());
		}
		Optional<User> optUser2 = userRepository.findByUsername("mary");
		if(optUser2.isPresent()) {
			User user = optUser2.get();
			System.out.println("user2 => " + user.getId() + "," + user.getUsername() + "," + user.getPassword());
		}
		
		List<User> users = userRepository.findAll();
		for(User user : users) {
			System.out.println(user.getId() + "," + user.getUsername() + "," + user.getPassword());
		}
		
		System.out.println("admin 是否存在: " + userRepository.existsByUsername("admin"));
		System.out.println("john 是否存在: " + userRepository.existsByUsername("john"));
		
		
	}
	
}
