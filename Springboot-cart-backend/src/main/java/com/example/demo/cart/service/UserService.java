package com.example.demo.cart.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.cart.model.dto.FavoriteProductDTO;
import com.example.demo.cart.model.dto.FavoriteUserDTO;
import com.example.demo.cart.model.dto.LoginDTO;
import com.example.demo.cart.model.dto.UserDTO;

public interface UserService {
	
	// 根據名字找使用者
	Optional<UserDTO> findByUsername(String username);
	
	// 登入
	Optional<UserDTO> login(LoginDTO loginDTO);
	
	// 儲存
	Optional<UserDTO> saveUser(UserDTO userDTO);
	
	// 用戶關注列表(用戶關注那些商品) - 正向查詢
	List<FavoriteProductDTO> getFavoriteProducts(Long userId);
	
	// 商品關注列表(商品關注那些商品) - 反向查詢
	List<FavoriteUserDTO> getFavoriteUsers(Long productId);
	
	// 新增商品關注
	void addFavoriteProduct(Long userId, Long productId);
	
	// 移除所關注的商品
	void removeFavoriteProduct(Long userId, Long productId);
	
}
