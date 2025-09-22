package com.example.demo.cart.model.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "product")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private String name;
	
	@Column
	private Integer price;
	
	// product 與 product_image 一對一關聯 (單向)
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "product_image_id")
	private ProductImage productImage;
	
	// product 與 order_item 一對多關聯
	@OneToMany
	private List<OrderItem> items;
	
}
