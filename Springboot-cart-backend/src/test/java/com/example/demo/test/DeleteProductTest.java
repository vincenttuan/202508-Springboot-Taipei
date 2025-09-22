package com.example.demo.test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.cart.repository.ProductRepository;

@SpringBootTest
public class DeleteProductTest {
	
	@Autowired
	private ProductRepository productRepository;
	
	@Test
	public void deleteProduct() {
		// 刪除 id=3 的 product
		// 1.先判斷 id=3 是否存在 ?
		if(productRepository.existsById(3L)) {
			// 2.刪除該筆資料
			productRepository.deleteById(3L);
			System.out.println("該筆資料已刪除");
		} else {
			System.out.println("查無資料");
		}
		
	}
	
}
