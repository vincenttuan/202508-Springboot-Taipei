package com.example.todolist.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

// 建立 Server 與 Client 在傳遞資料上的統一結構與標準(含錯誤)
@Getter
@Setter
@AllArgsConstructor
public class ApiResponse<T> {
	private boolean success;
	private String message;
	private T data;
}
