package com.example.demo.cart.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.cart.model.dto.ProductDTO;

public interface ProductService {
	// 取得所有商品
	List<ProductDTO> getAllProducts();
	
	// 取得單一商品
	Optional<ProductDTO> getProductById(Long id);
	
	// 新增商品
	Optional<ProductDTO> saveProduct(ProductDTO productDTO);
}
