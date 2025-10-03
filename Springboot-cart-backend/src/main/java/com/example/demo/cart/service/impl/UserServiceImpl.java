package com.example.demo.cart.service.impl;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.cart.model.dto.FavoriteProductDTO;
import com.example.demo.cart.model.dto.FavoriteUserDTO;
import com.example.demo.cart.model.dto.LoginDTO;
import com.example.demo.cart.model.dto.UserDTO;
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
		return Optional.empty();
	}

	@Override
	public Optional<UserDTO> saveUser(UserDTO userDTO) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public List<FavoriteProductDTO> getFavoriteProducts(Long userId) {
		// TODO Auto-generated method stub
		return null;
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
