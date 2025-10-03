package com.example.demo.cart.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginDTO {
	private String username;
	private String password;
	private Boolean isLoggedIn; // 是否登入成功 ?
}
