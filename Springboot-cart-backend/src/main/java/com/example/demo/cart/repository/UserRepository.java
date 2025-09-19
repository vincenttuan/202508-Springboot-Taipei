package com.example.demo.cart.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.cart.model.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	// 自訂方法
	Optional<User> findByUsername(String username);
}
