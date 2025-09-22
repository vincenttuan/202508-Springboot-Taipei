package com.example.demo.test;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.cart.model.entity.Product;
import com.example.demo.cart.repository.ProductRepository;

@SpringBootTest
public class UpdateProductTest2 {
	
	@Autowired
	private ProductRepository productRepository;
	
	@Test
	public void updateProduct() {
		// 想要修改 id=1 的價格
		// 1. 先找到 id=1 的 product
		Optional<Product> optProduct = productRepository.findById(1L);
		// 2. 判斷是否有找到
		if(optProduct.isEmpty()) {
			System.out.println("無此資料");
			return;
		}
		// 3. 取出 product 物件
		Product product = optProduct.get();
		// 4.1 修改 price
		product.setPrice(200);
		// 4.2 修改 name
		product.setName("富士蘋果");
		// 5. 回存
		productRepository.save(product);
		
		System.out.println("價格名稱更新完畢 !");
		
		
	}
	
}
