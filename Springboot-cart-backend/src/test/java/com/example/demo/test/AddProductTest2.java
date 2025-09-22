package com.example.demo.test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.cart.model.entity.Product;
import com.example.demo.cart.model.entity.ProductImage;
import com.example.demo.cart.repository.ProductRepository;

@SpringBootTest
public class AddProductTest2 {
	
	@Autowired
	ProductRepository productRepository;
	
	@Test
	void add() {
		ProductImage productImage = new ProductImage();
		// 香蕉小圖 base64
		String base64Banana = "iVBORw0KGgoAAAANSUhEUgAAABAAAAAQCAMAAAAoLQ9TAAAAZlBMVEUAAAD///+ZmZmZmZmZmZmZmZmZmZmZmZmZmZmZmZmZmZmZmZmZmZmZmZmZmZmZmZmZmZmZmZmZmZmZmZmZmZmZmZmZmZmZmZmZmZmZmZmZmZmZmZmZmZmZmZmZmZmZmZmZmZmZmZmZmZmZmZmZmZmZmZmZktjCjAAAAGHRSTlMANHhCT2Z7hJGz41Ads/TFa4QQLdrMQAAAF5JREFUGNNtzkcSgjAQBdA6BScz3Pb//+jUkdmoZrh13kRggJOiLJKkNTASd6w85wOmiK2wJFvGYZf90Wsf+TUYR3kGZVVknqssamLUofbQxazv0l1T6/xPqQfWCeTfbtWIAAAAASUVORK5CYII=";
		productImage.setImageBase64(base64Banana);
		
		Product product = new Product();
		// 設定欄位值
		product.setName("Banana");
		product.setPrice(70);
		// 設定關聯
		product.setProductImage(productImage);
		
		// 保存 Product
		productRepository.save(product);
		
	}
	
}
