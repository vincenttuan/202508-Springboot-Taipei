package com.example.demo.test;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.cart.model.entity.Product;
import com.example.demo.cart.repository.ProductRepository;

@SpringBootTest
public class SelectProductTest {
	
	@Autowired
	private ProductRepository productRepository;
	
	@Test
	public void select() {
		// 查詢所有商品
		List<Product> products = productRepository.findAll();
		products.forEach(product -> {
			System.out.println(product.getId() + "\t" + product.getName() + "\t" + product.getPrice());
			System.out.println(product.getProductImage().getImageBase64());
		});
		
		// 查詢單筆資料
		Optional<Product> optProduct = productRepository.findById(1L);
		if(optProduct.isPresent()) {
			Product product = optProduct.get();
			System.out.println(product.getId() + "\t" + product.getName() + "\t" + product.getPrice());
			System.out.println(product.getProductImage().getImageBase64());
		} else {
			System.out.println("無此資料");
		}
		
	}
	
}
