package com.example.demo.cart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.cart.model.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
	
	// 自訂修改(使用 PQL)
	@Modifying
	@Query("update Product p set p.price = :price, p.name = :name where p.id = :id")
	int updatePriceAndNameById(@Param("id") Long id, @Param("price") Integer price, @Param("name") String name);
	
	// 自訂修改(使用 T-SQL [nativeQuery = true])
	@Modifying
	@Query(value="update product set price = :price, name = :name where id = :id", nativeQuery = true)
	int updatePriceAndNameByIdNative(@Param("id") Long id, @Param("price") Integer price, @Param("name") String name);

}
