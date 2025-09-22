package com.example.demo.test;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.cart.repository.ProductRepository;

@SpringBootTest
public class UpdateProductTest {
	
	@Autowired
	private ProductRepository productRepository;
	
	@Test
	@Transactional // 因為會使用到 JPA 的 @Modifying 方法, 所以要設定 @Transactional
	@Commit // 防止 rollback
	public void updateProduct() {
		// 想要修改 id=1 的價格
		Long id = 1L;
		Integer price = 199;
		String name = "青森蘋果";
		
		//productRepository.updatePriceAndNameById(id, price, name);
		int rowcount = productRepository.updatePriceAndNameById(id, price, name);
		if(rowcount > 0) {
			System.out.println("價格名稱更新完畢 !");
		} else {
			System.out.println("修改失敗, 查無資料");
		}
		
		
	}
	
}
