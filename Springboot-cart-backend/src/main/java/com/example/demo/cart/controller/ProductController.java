package com.example.demo.cart.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.cart.exception.ProductNotFoundException;
import com.example.demo.cart.model.dto.ProductDTO;
import com.example.demo.cart.response.ApiResponse;
import com.example.demo.cart.service.ProductService;

/**
 * -------------------------------------------------------------------
 * Servlet-Path: "/products"
 * -------------------------------------------------------------------
 * GET  "/"     查詢所有商品(多筆) 範例: /products/
 * GET  "/{id}" 查詢指定商品(單筆) 範例: /products/1
 * POST "/"     新增商品        範例: /products/
 * -------------------------------------------------------------------
 */
@RestController
@RequestMapping("/products")
@CrossOrigin(origins = {"http://localhost:5173", "http://localhost:80"}, allowCredentials = "true")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@GetMapping(value = {"", "/"})
	public ResponseEntity<ApiResponse<List<ProductDTO>>> getAllProducts() {
		return ResponseEntity.ok(new ApiResponse<>(200, "查詢成功", productService.getAllProducts()));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ApiResponse<ProductDTO>> getProduct(@PathVariable(name = "id") Long productId) {
		Optional<ProductDTO> optProductDTO = null;
		try {
			optProductDTO = productService.getProductById(productId);
		} catch (ProductNotFoundException e) {
			return ResponseEntity.status(404).body(new ApiResponse<>(404, e.getMessage(), null));
		}
		ProductDTO productDTO = optProductDTO.get();
		return ResponseEntity.ok(new ApiResponse<>(200, "查詢成功", productDTO));
	}
	
	@PostMapping(value = {"", "/"})
	public ResponseEntity<ApiResponse<ProductDTO>> addProduct(@RequestBody ProductDTO productDTO) {
		Optional<ProductDTO> optProductDTO = productService.saveProduct(productDTO);
		if(optProductDTO.isEmpty()) {
			return ResponseEntity.status(500).body(new ApiResponse<>(500, "新增失敗", null));
		}
		productDTO = optProductDTO.get();
		return ResponseEntity.ok(new ApiResponse<>(200, "新增成功", productDTO));
	}
	
}
