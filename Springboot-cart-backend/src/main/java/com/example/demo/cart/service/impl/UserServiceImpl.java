package com.example.demo.cart.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.cart.exception.UserNotFoundException;
import com.example.demo.cart.model.dto.FavoriteProductDTO;
import com.example.demo.cart.model.dto.FavoriteUserDTO;
import com.example.demo.cart.model.dto.LoginDTO;
import com.example.demo.cart.model.dto.UserDTO;
import com.example.demo.cart.model.entity.Product;
import com.example.demo.cart.model.entity.User;
import com.example.demo.cart.repository.ProductRepository;
import com.example.demo.cart.repository.UserRepository;
import com.example.demo.cart.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public Optional<UserDTO> findByUsername(String username) {
		Optional<User> optUser = userRepository.findByUsername(username);
		if(optUser.isEmpty()) {
			return Optional.empty();
		}
		User user = optUser.get();
		// 利用 modelMapper 將 user 轉 userDTO
		UserDTO userDTO = modelMapper.map(user, UserDTO.class);
		return Optional.of(userDTO);
	}

	@Override
	public Optional<UserDTO> login(LoginDTO loginDTO) {
		Optional<User> optUser = userRepository.findByUsername(loginDTO.getUsername());
		if(optUser.isEmpty()) {
			return Optional.empty();
		}
		User user = optUser.get();
		// 判斷密碼
		if(user.getPassword().equals(loginDTO.getPassword())) { // 比對成功
			UserDTO userDTO = modelMapper.map(user, UserDTO.class);
			return Optional.of(userDTO);
		}
		return Optional.empty();
	}

	@Override
	public Optional<UserDTO> saveUser(UserDTO userDTO) {
		// 將 userDTO 轉 user
		User user = modelMapper.map(userDTO, User.class);
		user = userRepository.save(user);
		// 將 user 轉 userDTO 
		userDTO = modelMapper.map(user, UserDTO.class);
		return Optional.of(userDTO);
	}
	
	// 用戶關注列表(用戶關注那些商品) - 正向查詢
	@Override
	public List<FavoriteProductDTO> getFavoriteProducts(Long userId) {
		User user = userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException("查無使用者"));
		// 查詢該用戶目前所關注的商品
		Set<Product> products = user.getFavoriteProducts();
		// 將 products 集合中的每一個 Product 元素轉 FavoriteProductDTO
		return products.stream()
						.map(product -> modelMapper.map(product, FavoriteProductDTO.class)) // 元素一個一個轉換
						.toList();
	}

	@Override
	public List<FavoriteUserDTO> getFavoriteUsers(Long productId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addFavoriteProduct(Long userId, Long productId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeFavoriteProduct(Long userId, Long productId) {
		// TODO Auto-generated method stub
		
	}

}
