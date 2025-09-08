package com.example.todolist.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity // 對應實體資料表
@Table(name = "todo") // 預設的資料表名
public class Todo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // 由資料庫自行決定 id 生成策略
	private Long id;
	
	@Column(name = "text", length = 255, nullable = false, unique = false)
	private String text;
	
	@Column(name = "completed", nullable = false, unique = false)
	private Boolean completed;
	
}
