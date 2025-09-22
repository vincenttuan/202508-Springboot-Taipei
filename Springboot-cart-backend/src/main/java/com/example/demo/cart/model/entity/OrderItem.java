package com.example.demo.cart.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "order_item")
public class OrderItem {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	// 商品數量
	private int qty;
	
	// order_item 與 product 多對一關聯
	@ManyToOne
	@JoinColumn(name = "product_id")
	private Product product;
	
	// order_iten 與 order 多對一關聯
	@ManyToOne
	@JoinColumn(name = "order_id")
	private Order order;
	
}
