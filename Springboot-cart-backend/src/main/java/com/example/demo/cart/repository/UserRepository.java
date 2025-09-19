package com.example.demo.cart.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.cart.model.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	// 自訂方法
	Optional<User> findByUsername(String username);
	
	Optional<User> findByUsernameAndPassword(String username, String password);
	
	Optional<User> findByUsernameOrPassword(String username, String password);
	
	List<User> findByUsernameContaining(String keyword);
	List<User> findByUsernameContainingOrderByIdDesc(String keyword);
	
	List<User> findByUsernameStartingWith(String prefix);
	
	boolean existsByUsername(String username);
	
}
