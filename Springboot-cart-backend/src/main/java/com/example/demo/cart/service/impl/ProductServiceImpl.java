package com.example.demo.cart.service.impl;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.cart.exception.ProductNotFoundException;
import com.example.demo.cart.model.dto.ProductDTO;
import com.example.demo.cart.model.entity.Product;
import com.example.demo.cart.model.entity.ProductImage;
import com.example.demo.cart.repository.ProductRepository;
import com.example.demo.cart.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public List<ProductDTO> getAllProducts() {
		return productRepository.findAll()
								.stream()
								.map(product -> modelMapper.map(product, ProductDTO.class))
								.toList();
	}

	@Override
	public Optional<ProductDTO> getProductById(Long productId) {
		Product product = productRepository.findById(productId).orElseThrow(() -> new ProductNotFoundException("查無商品"));
		ProductDTO productDTO = modelMapper.map(product, ProductDTO.class);
		return Optional.of(productDTO);
	}

	@Override
	public Optional<ProductDTO> saveProduct(ProductDTO productDTO) {
		// 建立 ProductImage
		ProductImage productImage = new ProductImage();
		productImage.setImageBase64(productDTO.getImageBase64());
		
		// ProductDTO 轉 Product
		Product product = modelMapper.map(productDTO, Product.class);
		product.setProductImage(productImage);
		
		// 儲存
		product = productRepository.save(product);
		
		// Product 轉 ProductDTO
		productDTO = modelMapper.map(product, ProductDTO.class);
		
		return Optional.of(productDTO);
	}

}
